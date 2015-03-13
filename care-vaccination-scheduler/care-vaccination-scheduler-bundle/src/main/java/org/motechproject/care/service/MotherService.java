package org.motechproject.care.service;

import org.motechproject.care.service.util.Constants;
import org.motechproject.casexml.service.exception.CaseException;
import org.motechproject.commons.date.util.StringUtil;
import org.motechproject.event.MotechEvent;
import org.motechproject.event.listener.annotations.MotechListener;
import org.motechproject.mcts.care.common.mds.domain.Client;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class MotherService extends BaseService<MotherCase> {
    
    private static final Logger logger = LoggerFactory
            .getLogger(MotherService.class);
	
    @Autowired
    MdsRepository dbRepository;
    @Autowired
    public MotherService(@Qualifier("motherVaccinationProcessor") VaccinationProcessor vaccinationProcessor) {
        super(vaccinationProcessor);
    }

//    protected void onProcess(MotherCase mother) {
//        //MotherCase motherFromDb = dbRepository.get(MotherCase.class, "caseId",  mother.getCaseId());
//
//       // if(motherFromDb == null)
//        //    processNew(mother);
//        //else
//            processExisting(mother);
//    }
//
//    private void processNew(MotherCase mother) {
//        dbRepository.save(mother);
//        if(mother.isActive())
//            vaccinationProcessor.enrollUpdateVaccines(mother);
//    }
    
    
    
    @MotechListener(subjects=Constants.MOTHER_CREATE_UPDATE_EVENT) 
    public void processExisting(MotechEvent event) {
    	
    	logger.info("In MOTHER_CREATE_UPDATE_EVENT "+ event.toString());
    	MotherCase mother = (MotherCase) event.getParameters().get(Constants.MOTHER_CASE_PARAM);
    	logger.info("Mother Case extracted with Case Id"+ mother.getCaseId());
    	process(mother);
    	
    }
    
    
    public void process(MotherCase mother) {
    	if(mother == null) {
    		return;
    	}
    	logger.info("Validating Case Id, %s"+mother.getCaseId());
    	validateMandatory(mother.getCaseId(), "Case Id");
    	logger.info("Validating Owner Id, %s"+mother.getFlwGroup());
    	if(mother.getFlwGroup() == null) {
            throw new CaseException("Owner Id is a mandatory field.", HttpStatus.BAD_REQUEST);
        }
        validateMandatory(mother.getFlwGroup().getGroupId(), "Owner Id");
    	  synchronized (getLockName(mother.getCaseId())) {
        if(mother.isActive())
            vaccinationProcessor.enrollUpdateVaccines(mother);
        else
            vaccinationProcessor.closeSchedules(mother);
    	  }
    }

    @Override
    @MotechListener(subjects=Constants.MOTHER_CLOSE_EVENT)
    public boolean closeCase(MotechEvent event) {
    	String caseId = (String) event.getParameters().get(
    			Constants.MOTHER_CASE_ID_PARAM);
    	
    	return closeCase(caseId);
    }
    
    public boolean closeCase(String caseId){

   	 validateMandatory(caseId, "Case Id");
   	 
       synchronized (getLockName(caseId)) {
           MotherCase mother =  dbRepository.get(MotherCase.class,"caseId",caseId);
           if (mother == null)
				return false;

        //   mother.setClosed(true);
        //   dbRepository.update(mother);
           vaccinationProcessor.closeSchedules(mother);
           return true;
       }
    }

  /*  @Override
    public boolean expireCase(String caseId) {
        synchronized (getLockName(caseId)) {
            MotherCase mother = dbRepository.get(MotherCase.class,"caseId",caseId);
            if(mother == null)
                return false;
            mother.setExpired(true);
            dbRepository.update(mother);
            return true;
        }
    }*/
}