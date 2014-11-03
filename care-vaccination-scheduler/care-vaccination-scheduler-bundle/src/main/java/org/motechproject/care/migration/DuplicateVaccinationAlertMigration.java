package org.motechproject.care.migration;


import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.motechproject.care.schedule.service.ScheduleService;
import org.motechproject.mcts.care.common.mds.domain.Child;
import org.motechproject.mcts.care.common.mds.domain.Mother;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.motechproject.scheduletracking.repository.AllEnrollments;
import org.motechproject.scheduletracking.service.impl.EnrollmentAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class DuplicateVaccinationAlertMigration {

    Logger logger = Logger.getLogger(DuplicateVaccinationAlertMigration.class);
    private ScheduleService scheduleService;
    private EnrollmentAlertService enrollmentAlertService;
    private AllEnrollments allEnrollments;
    @Autowired
    private MdsRepository dbRepository;


    public DuplicateVaccinationAlertMigration(ScheduleService scheduleService, EnrollmentAlertService enrollmentAlertService, AllEnrollments allEnrollments) {
        this.scheduleService = scheduleService;
        this.enrollmentAlertService = enrollmentAlertService;
        this.allEnrollments = allEnrollments;
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationCareMigrationContext.xml");
//        DuplicateVaccinationAlertMigration duplicateVaccinationAlertMigration = (DuplicateVaccinationAlertMigration) context.getBean("duplicateVaccinationAlertMigration");
//        duplicateVaccinationAlertMigration.loadCaseIdsFromCSVAndDeleteDuplicateTasks();
    }

    /**
     * Client id is the CASE ID of either the MOTHER CASE OR THE CHILD CASE for whom the
     * vaccination alerts have been raised multiple times due to the platform issue.
     * The platform scheduled the Repeatable schedule job to repeat indefinitely.
     *
     * @param clientCaseID
     */
    public void deleteAndUnEnrollDuplicateVaccinationAlerts(String clientCaseID) {

        if (StringUtils.isNotEmpty(clientCaseID)) {

            DuplicateVaccinationAlertService duplicateVaccinationAlertService = new DuplicateVaccinationAlertService(allEnrollments, enrollmentAlertService);
            Mother mother = dbRepository.get(Mother.class,"caseId",clientCaseID);
            if (mother != null) {
                duplicateVaccinationAlertService.deleteCareTasksForGivenMotherCase(clientCaseID);
            } else {
                Child child = dbRepository.get(Child.class,"caseId",clientCaseID);
                if (child != null) {
                    duplicateVaccinationAlertService.deleteCareTasksForGivenChildCase(clientCaseID);
                }
            }
        }
    }

    public void loadCaseIdsFromCSVAndDeleteDuplicateTasks(String fileName) {

	List<String> caseIds = MigrationUtil.readFile(fileName);
        for (String caseId : caseIds) {
            logger.info("deleting details for the case Id : " + caseId);
            deleteAndUnEnrollDuplicateVaccinationAlerts(caseId);

        }
    }
}
