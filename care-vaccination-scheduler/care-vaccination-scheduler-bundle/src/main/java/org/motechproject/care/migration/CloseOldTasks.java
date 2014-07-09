package org.motechproject.care.migration;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.motechproject.care.domain.CareCaseTask;
import org.motechproject.care.domain.Mother;
import org.motechproject.care.repository.AllCareCaseTasks;
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

    public CloseOldTasks() {
    }

    public void run() {
        List<Mother> mothers = allMothers.getAll();
        for (CareCaseTask task : allCareCaseTasks.getAll()) {
            if (task.getOpen() == true && llMothers.findByCaseId(task.getClientCaseId()) == null) {
                logger.info("Found open task without active case: " + task.getId() + ", client case id: " + task.getClientCaseId());
                careCaseTaskService.closeAll(task.getClientCaseId(), task.getMilestoneName());
            }
        }
    }

}
