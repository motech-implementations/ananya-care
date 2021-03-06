package org.motechproject.care.migration;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.motechproject.care.domain.CareCaseTask;
import org.motechproject.care.repository.AllCareCaseTasks;
import org.motechproject.care.service.CareCaseTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ForceCloseVaccinations {

	Logger logger = Logger.getLogger(ForceCloseVaccinations.class);
	@Autowired
	private CareCaseTaskService careCaseTaskService;

	@Autowired
	private AllCareCaseTasks allCareCaseTasks;


	public void closeCase(String caseId) {
		if (StringUtils.isNotEmpty(caseId)) {
			CareCaseTask careCaseTask = allCareCaseTasks.findByCaseId(caseId);
			if(careCaseTask != null){
			    careCaseTaskService.close(careCaseTask.getClientCaseId(), careCaseTask.getMilestoneName());
			    return;
			}
			logger.info("No careCaseTask exists for CaseId" + caseId);
		}
	}

	public void forceCloseCases(String fileName){
		List<String> caseIds = MigrationUtil.readFile(fileName);
		for(String caseId : caseIds){
			closeCase(caseId);
		}
	}



}
