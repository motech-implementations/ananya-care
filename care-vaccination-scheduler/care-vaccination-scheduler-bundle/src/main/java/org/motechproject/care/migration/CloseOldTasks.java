package org.motechproject.care.migration;

import org.apache.log4j.Logger;
import org.motechproject.care.service.CareCaseTaskService;
import org.motechproject.mcts.care.common.mds.domain.CareCaseTask;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
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
                // check if there are any existent and active cases for given
                // task
                if ((dbRepository.get(MotherCase.class, "caseId", task
                        .getMotherCase().getCaseId()) == null || (dbRepository
                        .get(MotherCase.class, "caseId", task.getMotherCase()
                                .getCaseId())).isActive() == false)
                        && (dbRepository.get(ChildCase.class, "caseId", task
                                .getChildCase().getCaseId()) == null || dbRepository
                                .get(ChildCase.class, "caseId",
                                        task.getChildCase().getCaseId())
                                .isActive() == false)) {
                    // close it otherwise
                    logger.info("Found open task without active case: "
                            + task.getTaskId() + ", client case id: "
                            + task.getMotherCase().getCaseId() == null ? task
                            .getChildCase().getCaseId() : task.getMotherCase()
                            .getCaseId());
                    careCaseTaskService.closeAll(task.getMotherCase()
                            .getCaseId() == null ? task.getChildCase()
                            .getCaseId() : task.getMotherCase().getCaseId(),
                            task.getMilestoneName());
                }
            }
        }
    }

}
