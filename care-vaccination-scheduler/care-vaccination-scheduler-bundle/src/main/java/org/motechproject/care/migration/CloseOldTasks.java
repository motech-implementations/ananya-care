package org.motechproject.care.migration;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.motechproject.care.domain.CareCaseTask;
import org.motechproject.care.domain.Child;
import org.motechproject.care.domain.Mother;
import org.motechproject.care.repository.AllCareCaseTasks;
import org.motechproject.care.repository.AllChildren;
import org.motechproject.care.repository.AllClients;
import org.motechproject.care.repository.AllMothers;
import org.motechproject.care.service.CareCaseTaskService;
import org.motechproject.scheduletracking.api.domain.Enrollment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CloseOldTasks {

    Logger logger = Logger.getLogger(CloseOldTasks.class);

    @Autowired
    private CareCaseTaskService careCaseTaskService;

    @Autowired
    private AllCareCaseTasks allCareCaseTasks;

    @Autowired
    private AllMothers allMothers;

    @Autowired
    private AllChildren allChildren;

    public void run() {
        for (CareCaseTask task : allCareCaseTasks.getAll()) {
            if (task.getOpen() == true) {
                // check if there are any existent and active cases for given task
                if ((allMothers.findByCaseId(task.getClientCaseId()) == null || allMothers.findByCaseId(task.getClientCaseId()).isActive() == false) &&
                    (allChildren.findByCaseId(task.getClientCaseId()) == null || allChildren.findByCaseId(task.getClientCaseId()).isActive() == false)) {
                    // close it otherwise
                    logger.info("Found open task without active case: " + task.getId() + ", client case id: " + task.getClientCaseId());
                    careCaseTaskService.closeAll(task.getClientCaseId(), task.getMilestoneName());
                }
            }
        }
    }

}
