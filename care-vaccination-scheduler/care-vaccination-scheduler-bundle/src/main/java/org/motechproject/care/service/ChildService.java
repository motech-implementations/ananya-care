package org.motechproject.care.service;

import org.motechproject.care.service.util.Constants;
import org.motechproject.casexml.service.exception.CaseException;
import org.motechproject.event.MotechEvent;
import org.motechproject.event.listener.annotations.MotechListener;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

//import com.mysql.jdbc.Constants;

@Service
public class ChildService extends BaseService<ChildCase> {

	@Autowired
	public ChildService(
			@Qualifier("childVaccinationProcessor") VaccinationProcessor vaccinationProcessor) {
		super(vaccinationProcessor);
	}

	@Autowired
	MdsRepository dbRepository;

//	protected void onProcess(ChildCase child) {
//		// ChildCase childFromDb = dbRepository.get(ChildCase.class, "caseId",
//		// child.getCaseId());
//
//		// if(childFromDb == null)
//		// processNew(child);
//		// else if(childFromDb.isActive())
//		processExisting(child);
//	}

//	private void processNew(ChildCase child) {
//		dbRepository.save(child);
//		if (child.shouldEnrollForSchedules()) {
//			vaccinationProcessor.enrollUpdateVaccines(child);
//		}
//	}

	@MotechListener(subjects=Constants.CHILD_CREATE_UPDATE_EVENT)
	public void processExisting(MotechEvent event) {
		ChildCase child = (ChildCase) event.getParameters().get(
				Constants.CHILD_CASE_PARAM);
    	
		process(child);
	}
	
	public void process(ChildCase child){
		if (child == null) {
			return;
		}
		validateMandatory(child.getCaseId(), "Case Id");
		if (child.getFlwGroup() == null) {
			throw new CaseException("Owner Id is a mandatory field.",
					HttpStatus.BAD_REQUEST);
		}
		validateMandatory(child.getFlwGroup().getGroupId(), "Owner Id");

		synchronized (getLockName(child.getCaseId())) {
			if (child.isActive()) {
				vaccinationProcessor.enrollUpdateVaccines(child);
			} else {
				vaccinationProcessor.closeSchedules(child);
			}
		}
	}

	// @Override
	// public boolean closeCase(String caseId) {
	//
	// synchronized (getLockName(caseId)) {
	// ChildCase child = dbRepository.get(ChildCase.class,"caseId",caseId);
	// if(child == null)
	// return false;
	//
	// child.setClosedByCommcare(true);
	// dbRepository.update(child);
	// vaccinationProcessor.closeSchedules(child);
	// return true;
	// }
	//
	// }

	@Override
	@MotechListener(subjects=Constants.CHILD_CLOSE_EVENT)
	public boolean closeCase(MotechEvent event) {
		String caseId = (String) event.getParameters().get(
    			Constants.CHILD_CASE_ID_PARAM);
		
		return closeCase(caseId);
	}
	
	public boolean closeCase(String caseId) {
		synchronized (getLockName(caseId)) {
			 ChildCase child =
			dbRepository.get(ChildCase.class,"caseId",caseId);
			if (child == null)
				return false;
			//child.setClosedByCommcare(true);
			//dbRepository.update(child);
			vaccinationProcessor.closeSchedules(child);
			return true;
		}

	}

	/*@Override
	public boolean expireCase(String caseId) {
		synchronized (getLockName(caseId)) {
			ChildCase child = dbRepository.get(ChildCase.class, "caseId",
					caseId);
			if (child == null)
				return false;
			child.setExpired(true);
			dbRepository.update(child);
			return true;
		}
	}*/

	public MotherCase getMother(String mother_id) {
		return dbRepository.get(MotherCase.class, "caseId", mother_id);
	}
}
