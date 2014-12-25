package org.motechproject.care.reporting.migration.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.auth.CredentialsProvider;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.motechproject.care.reporting.migration.common.Constants;
import org.motechproject.care.reporting.migration.common.Page;
import org.motechproject.care.reporting.migration.statistics.EndpointStatisticsCollector;
import org.motechproject.care.reporting.migration.statistics.MigrationStatisticsCollector;
import org.motechproject.care.reporting.migration.statistics.RequestTimer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Component
public class CommcareAPIHttpClient {

    private static final Logger logger = LoggerFactory.getLogger(CommcareAPIHttpClient.class);

    private HttpClient httpClient;
    private final Properties commcareProperties;
    private EndpointStatisticsCollector statisticsCollector;

    @Autowired
    public CommcareAPIHttpClient(@Qualifier("commcareHttpClient") HttpClient httpClient,
                                 @Qualifier("commcareProperties") Properties commcareProperties,
                                 MigrationStatisticsCollector statisticsCollector) {
        this.httpClient = httpClient;
        this.commcareProperties = commcareProperties;
        this.statisticsCollector = statisticsCollector.commcareEndpoint();
        logConfig();
        authenticate();
    }

    public String fetchForms(Map<String, String> parameters, Page paginationOptions) {
        NameValuePair[] queryParams = populateParams(parameters, paginationOptions);
        return getRequest(getCommcareFormListUrl(), queryParams);
    }

    public String fetchCases(Map<String, String> parameters, Page paginationOptions) {
        NameValuePair[] queryParams = populateParams(parameters, paginationOptions);
        return getRequest(getCommcareCaseListUrl(), queryParams);
    }

    private NameValuePair[] populateParams(Map<String, String> parameters, Page paginationOptions) {
        parameters.put(Constants.OFFSET, String.valueOf(paginationOptions.getOffset()));
        parameters.put(Constants.LIMIT, String.valueOf(paginationOptions.getLimit()));
        return toArray(parameters);
    }

    private NameValuePair[] toArray(Map<String, String> parameters) {
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        for (Map.Entry<String, String> parameterEntry : parameters.entrySet()) {
            nameValuePairs.add(new NameValuePair(parameterEntry.getKey(), parameterEntry.getValue()));
        }
        return nameValuePairs.toArray(new NameValuePair[nameValuePairs.size()]);
    }

    private HttpMethod buildRequest(String url, NameValuePair[] queryParams) {
        HttpMethod requestMethod = new GetMethod(url);

        if (queryParams != null) {
            requestMethod.setQueryString(queryParams);
        }

        return requestMethod;
    }

    private String getRequest(String requestUrl, NameValuePair[] queryParams) {
        boolean success = false;
        final RequestTimer requestTimer = statisticsCollector.newRequest();

        HttpMethod getMethod = buildRequest(requestUrl, queryParams);
        getMethod.getParams().setParameter(CredentialsProvider.PROVIDER, new SimpleCredentialsProvider(getUsername(), getPassword()));

        final int maxRetries = getMaxRetries();
        final int sleepTime = getSleepTimeBeforeRetries();
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new HttpMethodRetryHandler() {
            @Override
            public boolean retryMethod(HttpMethod method, IOException exception, int executionCount) {
                requestTimer.retried();
                boolean retry = executionCount <= maxRetries;

                logger.error("Exception occurred while pulling data from commcare hq", exception);
                logger.error(String.format("Execution Count: %s, Retrying again: %s", executionCount, retry));

                if(!retry) {
                    return false;
                }

                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException ignored) {
                }
                return true;
            }
        });

        try {
            logger.info("Fetching from: " + getMethod.getURI().getURI());
            requestTimer.start();
            int statusCode = httpClient.executeMethod(getMethod);

            String response = readResponse(getMethod);
            if (statusCode != HttpStatus.SC_OK) {
                BadResponseException e = new BadResponseException(requestUrl, statusCode, response);
                logger.error(e.getMessage(), e);
                throw e;
            }
            success = true;
            logger.info("Successfully Fetched: " + getMethod.getURI().getURI());
            return response;
        } catch (IOException e) {
            getMethod.releaseConnection();
            logger.error("IOException while sending request to Commcare", e);
            throw new RuntimeException(e);
        } finally {
            if(success) {
                requestTimer.successful();
            } else {
                requestTimer.failed();
            }
        }
    }
    
    /**
     * @since 24/Dec/2014
     * @author atish
     * @param parameters
     * @param paginationOptions
     * @return {@link String}
     */
    public String hitRequest(Map<String, String> parameters, Page paginationOptions) {
       
    	NameValuePair[] queryParams = populateParams(parameters, paginationOptions);
    	String requestUrl = getCommcareCaseListUrl();
        HttpMethod getMethod = buildRequest(requestUrl, queryParams);
        getMethod.getParams().setParameter(CredentialsProvider.PROVIDER, new SimpleCredentialsProvider(getUsername(), getPassword()));

        try {
            logger.info("fetching case : " + getMethod.getURI().getURI());
            int statusCode = httpClient.executeMethod(getMethod);

            String response = readResponse(getMethod);
            if (statusCode != HttpStatus.SC_OK) {
                BadResponseException e = new BadResponseException(requestUrl, statusCode, response);
                logger.error(e.getMessage(), e);
                throw e;
            }
            
            logger.info("Successfully Fetched: " + getMethod.getURI().getURI());
            return response;
        } catch (IOException e) {
            getMethod.releaseConnection();
            logger.error("IOException while sending request to Commcare", e);
            throw new RuntimeException(e);
        } 
    }

    private int getSleepTimeBeforeRetries() {
        return Integer.parseInt(commcareProperties.getProperty("retry.sleep.time.in.ms"));
    }

    private int getMaxRetries() {
        return Integer.parseInt(commcareProperties.getProperty("retry.count"));
    }

    private String readResponse(HttpMethod getMethod) throws IOException {
        InputStream responseStream = getMethod.getResponseBodyAsStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(responseStream));
        StringBuffer sb = new StringBuffer();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }

    private void authenticate() {
        httpClient.getParams().setAuthenticationPreemptive(false);

        httpClient.getState().setCredentials(
                new AuthScope(null, -1, null, null),
                new UsernamePasswordCredentials(getUsername(), getPassword()));
    }

    String getCommcareCaseListUrl() {
        return String.format("%s/%s/api/%s/case/", getCommcareBaseUrl(), getCommcareDomain(), getVersion());
    }

    String getCommcareFormListUrl() {
        return String.format("%s/%s/api/%s/form/", getCommcareBaseUrl(), getCommcareDomain(), getVersion());
    }

    private String getCommcareBaseUrl() {
        String commcareBaseUrl = getBaseUrl();

        if (commcareBaseUrl.endsWith("/")) {
            commcareBaseUrl = commcareBaseUrl.substring(0, commcareBaseUrl.length() - 1);
        }

        return commcareBaseUrl;
    }

    private String getBaseUrl() {
        return commcareProperties.getProperty("commcareBaseUrl");
    }

    private String getCommcareDomain() {
        return commcareProperties.getProperty("commcareDomain");
    }

    private String getUsername() {
        return commcareProperties.getProperty("username");
    }


    private String getPassword() {
        return commcareProperties.getProperty("password");
    }

    private String getVersion() {
        return commcareProperties.getProperty("apiVersion");
    }

    private void logConfig() {
        logger.info(String.format("Commcare case list endpoint: %s", getCommcareCaseListUrl()));
        logger.info(String.format("Commcare form list endpoint: %s", getCommcareFormListUrl()));
        logger.info(String.format("Commcare maximumm retries: %s; with sleep time: %s", getMaxRetries(), getSleepTimeBeforeRetries()));
    }
}
