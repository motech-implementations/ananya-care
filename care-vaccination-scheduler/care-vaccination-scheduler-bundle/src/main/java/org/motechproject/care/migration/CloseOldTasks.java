package org.motechproject.care.migration;

import org.apache.log4j.Logger;
import org.motechproject.care.service.CareCaseTaskService;
import org.motechproject.mcts.care.common.mds.domain.CareCaseTask;
import org.motechproject.mcts.care.common.mds.domain.Child;
import org.motechproject.mcts.care.common.mds.domain.Mother;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CloseOldTasks {

    Logger logger = Logger.getLogger(CloseOldTasks.class);

    @Autowired
    private CareCaseTaskService careCaseTaskService;

    @Autowired
    private MdsRepository dbRepository;
    
    public void run() {
        for (CareCaseTask task : dbRepository.retrieveAll(CareCaseTask.class)) {
            if (task.getIsOpen() == true) {
                // check if there are any existent and active cases for given task
                if ((dbRepository.get(Mother.class,"caseId",task.getClientCaseId()) == null || dbRepository.get(Mother.class,"caseId",task.getClientCaseId()).isActive() == false) &&
                    (dbRepository.get(Child.class,"caseId",task.getClientCaseId()) == null || dbRepository.get(Child.class,"caseId",task.getClientCaseId()).isActive() == false)) {
                    // close it otherwise
                    logger.info("Found open task without active case: " + task.getTaskId() + ", client case id: " + task.getClientCaseId());
                    careCaseTaskService.closeAll(task.getClientCaseId(), task.getMilestoneName());
                }
            }
        }
    }

}
