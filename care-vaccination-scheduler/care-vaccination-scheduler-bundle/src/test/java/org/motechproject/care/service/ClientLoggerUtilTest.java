package org.motechproject.care.service;

import java.io.IOException;

import junit.framework.Assert;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.motechproject.care.service.util.ClientLoggerUtil;
import org.motechproject.mcts.care.common.mds.domain.Client;


public class ClientLoggerUtilTest {

	private static final String EXPECTED_NULL_Client = "Client{}";
	
	private static final String EXPECTED_PROPERTIES_NULL="Client{ Case Id : '', Case Name : '', Case Type : '', Closed : '',Creation Time : '', Date Modified : '', Expired : false }";
	
	private static final String EXPECTED_PROPERTIES = "Client{ Case Id : fdfbfd58-26f6-41f4-8598-0c925829aa6e, Case Name : &#2333;&#2369;&#2344;&#2366; &#2342;&#2375;&#2357;&#2368; &#2325;&#2366; &#2348;&#2375;&#2335;&#2366;, Case Type : cc_bihar_newborn, Closed : '',Creation Time : 2014-12-10T06:44:00.000+05:30, Date Modified : 2014-07-11T05:44:00.000+05:30, Expired : true }";
	
	private static final String EXPECTED_ERROR = "{ errorClass :java.io.IOException }";
	
	private static final String EXPECTED_NULL = "{ errorClass :null }";
	
	private Client client_null;
	
	private Client client_properties_null;
	
	private Client client_with_properties;
	
	private Exception inputException;
	
	private Exception inputNullException;
	
	@Before
	public void setUp() {
		client_null = null;
		inputException = new IOException();
		inputNullException = null;
		client_properties_null= new Client();
		client_with_properties = new Client();
		client_with_properties.setCaseId("fdfbfd58-26f6-41f4-8598-0c925829aa6e");
		client_with_properties.setCaseName("&#2333;&#2369;&#2344;&#2366; &#2342;&#2375;&#2357;&#2368; &#2325;&#2366; &#2348;&#2375;&#2335;&#2366;");;
		client_with_properties.setCaseType("cc_bihar_newborn");
		client_with_properties.setCreationTime(new DateTime(2014, 12, 10, 6, 44));
		client_with_properties.setDateModified(new DateTime(2014, 7, 11, 5, 44));
		client_with_properties.setExpired(true);
	}
	
	
	@Test
	public void NullClientTest() {
		String output = ClientLoggerUtil.clientBuilder(client_null).toString();
		Assert.assertEquals(EXPECTED_NULL_Client, output);
	} 
	
	@Test
	public void ClientWithNullProperties() {
		String output = ClientLoggerUtil.clientBuilder(client_properties_null).toString();
		Assert.assertEquals(EXPECTED_PROPERTIES_NULL, output);
	}
	
	@Test
	public void ClientWithProperties() {
		String output = ClientLoggerUtil.clientBuilder(client_with_properties).toString();
		Assert.assertEquals(EXPECTED_PROPERTIES, output);
	}
	
	@Test
	public void TestException() {
		String output = ClientLoggerUtil.ExceptionBuilder(inputException).toString();
		Assert.assertEquals(EXPECTED_ERROR,output);
	}
	
	@Test
	public void TestNullException() {
		String output = ClientLoggerUtil.ExceptionBuilder(inputNullException).toString();
		Assert.assertEquals(EXPECTED_NULL,output);
	}


}
