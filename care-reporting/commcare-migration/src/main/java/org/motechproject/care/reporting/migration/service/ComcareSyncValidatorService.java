package org.motechproject.care.reporting.migration.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.motechproject.care.reporting.migration.common.Page;
import org.motechproject.care.reporting.migration.util.CommcareAPIHttpClient;
import org.motechproject.care.reporting.model.CaseType;
import org.motechproject.care.reporting.repository.CommcareDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComcareSyncValidatorService {
	
	private CommcareAPIHttpClient commcareAPIHttpClient;
	
	private CommcareDao careDao;

	@Autowired
	public ComcareSyncValidatorService(CommcareAPIHttpClient commcareAPIHttpClient) {
		this.commcareAPIHttpClient = commcareAPIHttpClient;
	}
	
	
	public void compareForm(CaseType caseType) {    
		String response = commcareAPIHttpClient.hitRequest(createParameterMap(caseType), createPaginationOptions());	
        //Map<String , Object> form = careDao.getCases(caseType,);
	}
	
	private Page createPaginationOptions(){
		return new Page(1, 1);
	}
	
	private Map<String, String> createParameterMap(CaseType caseType){
		Map<String, String> parameters = new HashMap<>();
		Date now = new Date();
        parameters.put("data_modified_start",format(now));
        parameters.put("case_type", caseType.name());
        parameters.put("format", "json");
        return parameters;
	}
	
	private static String format(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
		return simpleDateFormat.format(date);
	}


	
	public static void main(String[] args) {
		System.out.println(format(new Date()));
	}

}
