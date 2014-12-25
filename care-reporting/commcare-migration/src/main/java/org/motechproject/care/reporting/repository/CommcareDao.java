package org.motechproject.care.reporting.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.motechproject.care.reporting.model.CaseType;
import org.motechproject.care.reporting.query.QueryExecutor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CommcareDao {
	
	private static final String FIND_QUERY_MOTHER_CASE = "find.query.mother.case";
	
	private static final String FIND_QUERY_CHILD_CASE = "find.query.child.case";
	
	private QueryExecutor queryExecutor;
	
	private Properties queryProperties;
	
	public CommcareDao(QueryExecutor queryExecutor, @Qualifier("queryProperties") Properties queryProperties) {
	   this.queryExecutor = queryExecutor;
	   this.queryProperties = queryProperties;
	}
	
    

	public Map<String,Object> getCases(CaseType caseType,String caseId) {
		    if(caseType==caseType.Mother) {
		        return queryExecutor.execute(SQL(FIND_QUERY_MOTHER_CASE),buildParams(caseId));
		    }else {
		    	return queryExecutor.execute(SQL(FIND_QUERY_CHILD_CASE),buildParams(caseId));
		    }
	}
	
	
	private Map<String, Object> buildParams(String caseId){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("caseId", caseId);
		return params;
	}
	
	private String SQL(String sqlKey) {
		 return queryProperties.getProperty(sqlKey);
	}
	
}
