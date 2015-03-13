package org.motechproject.care.service;


import org.motechproject.casexml.service.exception.CaseException;
import org.motechproject.commons.date.util.StringUtil;
import org.motechproject.event.MotechEvent;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.dimension.Flw;
import org.motechproject.mcts.care.common.mds.dimension.FlwGroup;
import org.motechproject.mcts.care.common.mds.domain.Client;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

public abstract class BaseService<T> {
	
    protected  VaccinationProcessor vaccinationProcessor;
    
 
    @Autowired
    MdsRepository dbRepository;
    
    public BaseService(VaccinationProcessor vaccinationProcessor) {
        this.vaccinationProcessor = vaccinationProcessor;
    }


    public String getLockName(String caseId) {
        return String.format("%s-%s", BaseService.class.getCanonicalName(), caseId).intern();
    }
    
    protected void validateMandatory(String fieldValue, String fieldName) throws CaseException {
        if(StringUtil.isNullOrEmpty(fieldValue)) {
            throw new CaseException(fieldName + " is a mandatory field.", HttpStatus.BAD_REQUEST);
        }
    }
    
    //public abstract boolean expireCase(String caseId);
    
    public abstract boolean closeCase(MotechEvent event);
    
}
