package org.motechproject.care.reporting.migration.service;

import java.util.HashMap;
import java.util.Map;

import org.motechproject.care.reporting.migration.CommcareSyncValidatorArguments;
import org.motechproject.care.reporting.migration.common.Constants;
import org.motechproject.care.reporting.migration.util.CommcareAPIHttpClient;
import org.motechproject.care.reporting.model.CaseType;
import org.motechproject.care.reporting.repository.CommcareDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommcareSyncValidatorService {

    private CommcareAPIHttpClient commcareAPIHttpClient;

    private CommcareDao careDao;

    @Autowired
    public CommcareSyncValidatorService(
            CommcareAPIHttpClient commcareAPIHttpClient) {
        this.commcareAPIHttpClient = commcareAPIHttpClient;
    }

    public void validate(
            CommcareSyncValidatorArguments commcareSyncValidatorArguments) {

        Map<String, String> paramsMap = getNameValuePair(commcareSyncValidatorArguments);
        String caseType  = paramsMap.get(Constants.CASE_TYPE);
        if(!validateCase(caseType)) {
    	  	throw new IllegalArgumentException(String.format("case type %s not supported", caseType));
        }
    	   String response = commcareAPIHttpClient.hitRequest(paramsMap);
        // Map<String , Object> form = careDao.getCases(caseType);
    }
    
    
    private boolean validateCase(String caseType) {
    	boolean flag = true;
    	if(caseType!= "mother" && caseType != "child") {
    	     flag = false;	
    	}
    	return flag;
    }

    private Map<String, String> getNameValuePair(
            CommcareSyncValidatorArguments commcareSyncValidatorArguments) {
        Map<String, String> optionsToUrlMapper = new HashMap<>();

        Map<String, String> pairs = new HashMap<>();
        for (Map.Entry<String, Object> entry : commcareSyncValidatorArguments
                .getOptions().entrySet()) {
            String optionKey = entry.getKey();

            if (optionsToUrlMapper.containsKey(optionKey)) {
                pairs.put(optionsToUrlMapper.get(optionKey), entry.getValue()
                        .toString());
            } else
                pairs.put(optionKey, entry.getValue().toString());
        }
        pairs.put(Constants.OFFSET, String
                .valueOf(Constants.DEFAULT_OFFSET_SYNC_VALIDATION));
        pairs.put(Constants.LIMIT, String
                .valueOf(Constants.DEFAULT_LIMIT_SYNC_VALIDATION));
        pairs.put(Constants.FORMAT, Constants.DEFAULT_FORMAT_SYNC_VALIDATION);
        return pairs;
    }

}
