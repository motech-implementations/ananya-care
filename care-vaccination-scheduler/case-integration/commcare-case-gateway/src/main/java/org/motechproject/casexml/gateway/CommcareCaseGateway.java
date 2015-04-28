package org.motechproject.casexml.gateway;


import org.apache.log4j.Logger;
import org.motechproject.casexml.domain.CaseTask;
import org.motechproject.http.agent.domain.Credentials;
import org.motechproject.http.agent.service.HttpAgent;
import org.motechproject.http.agent.service.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommcareCaseGateway {

    private CaseTaskXmlConverter caseTaskXmlConverter;
    private HttpAgent httpAgent;
   private final static Logger LOGGER = Logger.getLogger(CommcareCaseGateway.class.getName());

    @Autowired
    public CommcareCaseGateway(CaseTaskXmlConverter caseTaskXmlConverter,
            HttpAgent httpAgent) {
        this.caseTaskXmlConverter = caseTaskXmlConverter;
        this.httpAgent = httpAgent;
    }

    public void submitCase(String commcareUrl, CaseTask task, String username,
            String password, Integer redeliveryCount) {
        String request = caseTaskXmlConverter.convertToCaseXml(task);
        
        /*
         * HashMap<String, Object> parameters = constructParametersFrom(
         *       commcareUrl, request, "POST", username, password);
         */      
        sendEventMessage(commcareUrl, request, "POST", username, password);
    }

    public void closeCase(String commcareUrl, CaseTask task, String username,
            String password, Integer redeliveryCount) {
    	
        String request = caseTaskXmlConverter.convertToCloseCaseXml(task);
        sendEventMessage(commcareUrl, request, "POST", username, password);
    }

    private void sendEventMessage(String url, String data, String method,
            String username, String password) {
        try {
            Credentials credential = new Credentials(username, password);
            LOGGER.info(String.format("Posting url: %s with username: %s, password: %s", url, username, password));
            LOGGER.info("Data: " + data);
            url = url.trim();
            httpAgent.executeSync(url, (Object) data, Method.POST, credential);
            LOGGER.info(String.format("Posted url: %s with username: %s, password: %s", url, username, password));
        } catch (Exception e) {
        	LOGGER.error(String.format("Error Posting url: %s with username: %s, password: %s", url, username, password));
            throw new RuntimeException(e.getMessage());
            
        }
    }

    /**
     *    Older code removed 
    private HashMap<String, Object> constructParametersFrom(String url,
            Object data, String method, String username, String password) {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put(EventDataKeys.URL, url);
        parameters.put(EventDataKeys.METHOD, method);
        parameters.put(EventDataKeys.DATA, data);
        parameters.put(EventDataKeys.USERNAME, username);
        parameters.put(EventDataKeys.PASSWORD, password);
        return parameters;
    }**/
    
    /**
     * @author atish
     * Created to collect all cases to post in a folder "/home/naveen/motech/task".
     * Used for Testing purpose.
     **/
    /**
    private void createTask(String request,CaseTask task) {
      	 final String path ="/home/naveen/motech/task";
      	 final String FILE_APPENDER ="/";
      	 final String FILE_NAME_APPENDER="-";
      	 final String FILE_EXTENTION_APPENDER=".";
      	 final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
      	 String fileName = new StringBuilder(path).append(FILE_APPENDER).append(task.getCaseId()).append(FILE_NAME_APPENDER).append(dateFormat.format(new Date())).append(FILE_EXTENTION_APPENDER).append(".txt").toString();
      	 LOGGER.info(String.format("Logging request %s to file %s ",request, fileName));
      	 File file = new File(fileName);
      	 
      	 try {
      		boolean created = file.createNewFile();
      		if(created == true) {
      			BufferedWriter output = new BufferedWriter(new java.io.FileWriter(file));
      			output.write(request);
      			output.close();
      		}
      	 }catch (Exception e) {
      		LOGGER.info(String.format("failed to write file %s to path %s due to %s",fileName,path,e.getMessage()));
      	 }
      	
      }**/
      
}
