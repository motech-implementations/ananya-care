package org.motechproject.care.reporting.migration.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.motechproject.care.reporting.migration.common.CommcareResponseWrapper;
import org.motechproject.care.reporting.migration.statistics.EndpointStatisticsCollector;
import org.motechproject.care.reporting.migration.statistics.MigrationStatisticsCollector;
import org.motechproject.care.reporting.migration.statistics.RequestTimer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class MotechAPIHttpClient {

    private static final Logger logger = LoggerFactory
            .getLogger(MotechAPIHttpClient.class);

    private final Properties platformProperties;
    private EndpointStatisticsCollector statisticsCollector;
    private RestTemplate restTemplate;

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    public MotechAPIHttpClient(
            @Qualifier("platformProperties") Properties platformProperties,
            MigrationStatisticsCollector migrationStatisticsCollector,
            @Qualifier("restTemplate") RestTemplate restTemplate) {
        this.platformProperties = platformProperties;
        this.statisticsCollector = migrationStatisticsCollector
                .motechEndpoint();
        this.restTemplate = restTemplate;
        logConfig();
    }

    public void postForm(CommcareResponseWrapper form) {
        postContent(form, getFormUpdateUrl());
    }

    public void postCase(CommcareResponseWrapper aCase) {
        postContent(aCase, getCaseUpdateUrl());
    }

    ResponseEntity<Void> getLogin() {
        ResponseEntity<Void> response = new ResponseEntity<Void>(null);
        try {

            response = restTemplate.postForEntity(getMotechPlatformLoginUrl(),
                    getMotechPlatformLoginForm(), null);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    private String getMotechPlatformLoginUrl() {
        return String.format("%s/%s", platformProperties
                .getProperty("motech.platform.base.url"), platformProperties
                .getProperty("motech.platform.login.url"));
    }

    private MultiValueMap<String, String> getMotechPlatformLoginForm() {
        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("j_username", platformProperties
                .getProperty("motech.platform.username"));
        form.add("j_password", platformProperties
                .getProperty("motech.platform.password"));
        return form;
    }

    void postContent(CommcareResponseWrapper responseWrapper, String url) {
        final RequestTimer requestTimer = statisticsCollector.newRequest();
        boolean success = false;
        try {

            // addHeader(postMethod, responseWrapper.getHeaders());
            // postMethod.setRequestEntity(new
            // "text/xml; charset=UTF-8", "UTF-8"));

            final int maxRetries = getMaxRetries();
            final int sleepTime = getSleepTimeBeforeRetries();
            /*
             * postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER
             * , new HttpMethodRetryHandler() {
             * 
             * @Override public boolean retryMethod(HttpMethod method,
             * IOException exception, int executionCount) {
             * requestTimer.retried(); boolean retry = executionCount <=
             * maxRetries;
             * 
             * logger.error("Exception occurred while posting data to motech",
             * exception);
             * logger.error(String.format("Execution Count: %s, Retrying again: %s"
             * , executionCount, retry));
             * 
             * if(!retry) { return false; }
             * 
             * try { Thread.sleep(sleepTime); } catch (InterruptedException
             * ignored) { } return true; } });
             */

            // requestTimer.start();
            ResponseEntity<Void> loginresponse = getLogin();
            if (getMotechLoginRedirectUrl().equals(
                    loginresponse.getHeaders().getLocation().toString())) {
                MultiValueMap<String, String> requestHeaders = new HttpHeaders();
                Map<String, String> headers = responseWrapper.getHeaders();
                for (Map.Entry<String, String> header : headers.entrySet()) {
                    requestHeaders.add(header.getKey(), header.getValue());
                }
                HttpEntity requestEntity = (HttpEntity) new HttpEntity<String>(
                        responseWrapper.getResponseBody(), requestHeaders);
                ResponseEntity<Void> response = restTemplate.postForEntity(url,
                        requestEntity, null);
                int statusCode = response.getStatusCode().value();
                if (statusCode != HttpStatus.SC_OK) {
                    BadResponseException e = new BadResponseException(url,
                            statusCode, response.toString());
                    logger.error(e.getMessage(), e);
                    throw e;
                }
                success = true;
            } else {
                logger.error("login unsuccessfull");
            }

        } finally {
            if (success) {
                requestTimer.successful();
            } else {
                requestTimer.failed();
            }
        }
    }

    private String getMotechLoginRedirectUrl() {
        return String.format("%s/%s", platformProperties
                .getProperty("motech.platform.base.url"), platformProperties
                .getProperty("motech.platform.login.redirect.url"));
    }

    private void addHeader(PostMethod postMethod, Map<String, String> headers) {
        for (Map.Entry<String, String> header : headers.entrySet()) {
            postMethod.addRequestHeader(header.getKey(), header.getValue());
        }
    }

    private String readResponse(PostMethod postMethod) throws IOException {
        InputStream responseStream = postMethod.getResponseBodyAsStream();
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(responseStream));
        StringBuffer sb = new StringBuffer();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }

    private String getFormUpdateUrl() {
        return String.format("%s/%s",
                platformProperties.getProperty("app.url"), platformProperties
                        .getProperty("app.form.endpoint"));
    }

    private String getCaseUpdateUrl() {
        return String.format("%s/%s",
                platformProperties.getProperty("app.url"), platformProperties
                        .getProperty("app.case.endpoint"));
    }

    private int getSleepTimeBeforeRetries() {
        return Integer.parseInt(platformProperties
                .getProperty("retry.sleep.time.in.ms"));
    }

    private int getMaxRetries() {
        return Integer.parseInt(platformProperties.getProperty("retry.count"));
    }

    private void logConfig() {
        logger.info(String.format("Motech case update endpoint: %s",
                getCaseUpdateUrl()));
        logger.info(String.format("Motech form update Endpoint: %s",
                getFormUpdateUrl()));
        logger.info(String.format(
                "Motech maximumm retries: %s; with sleep time: %s",
                getMaxRetries(), getSleepTimeBeforeRetries()));
    }
}
