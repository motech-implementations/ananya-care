package org.motechproject.care.service.util;

import org.motechproject.mcts.care.common.mds.domain.Client;

public class ClientLoggerUtil {

	private static final String EMPTY = "{}";
	
	private static final String EMPTY_FIELD = "''";
	
	
	/**
    * Bug Fix : Following code handles if any vaccination schedular fails 
    * and allows to proceed with other vaccination schedular
    * @author atish
    * @since 5/12/2015
    * @param client
    */
   public static StringBuilder clientBuilder(Client client) {
   	
			   	StringBuilder clientBuilder = new StringBuilder();
			   	
			   
			   	if(client == null) { 
			   		clientBuilder.append("Client"+EMPTY);
			   	} else {
			   		clientBuilder
			   		    .append("Client{ ")
			   		    .append("Case Id : ")
			   			.append((client.getCaseId()!=null)?client.getCaseId():EMPTY_FIELD).append(", ")
			   			.append("Case Name : ")
			   			.append((client.getCaseName()!=null)?client.getCaseName():EMPTY_FIELD).append(", ")
			   			.append("Case Type : ")
			   			.append((client.getCaseType()!=null)?client.getCaseType():EMPTY_FIELD).append(", ")
			   			.append("Closed : ")
			   			.append((client.getClosed())?client.getClosed():EMPTY_FIELD).append(",")
			   			.append("Creation Time : ")
			   			.append((client.getCreationTime()!=null)?client.getCreationTime():EMPTY_FIELD).append(", ")
			   			.append("Date Modified : ")
			   			.append((client.getDateModified()!=null)?client.getDateModified():EMPTY_FIELD).append(", ")
			   			.append("Expired : ")
			   			.append((client.getExpired()!=null)?client.getExpired():EMPTY_FIELD)
			   			.append(" }");
					}
   	return clientBuilder;
   }
   
   /**
    * Bug Fix : Following code handles if any vaccination schedular fails 
    * and allows to proceed with other vaccination schedular
    * @author atish
    * @since 5/12/2015
    * @param exception
    */
   public static StringBuilder ExceptionBuilder(Exception exception) {
	   StringBuilder exceptionBuilder = new StringBuilder();
	    
	   String exceptionName = (exception != null)?exception.getClass().getName():null;
	   
	   	exceptionBuilder.append("{ errorClass :")
	   					.append(exceptionName)
	   					.append(" }");
	   	return exceptionBuilder;
   }
   
}
