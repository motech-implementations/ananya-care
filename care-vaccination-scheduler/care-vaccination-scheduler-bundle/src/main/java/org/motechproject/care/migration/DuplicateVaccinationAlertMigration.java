package org.motechproject.care.migration;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.motechproject.care.schedule.service.ScheduleService;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.motechproject.scheduletracking.repository.AllEnrollments;
import org.motechproject.scheduletracking.service.impl.EnrollmentAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DuplicateVaccinationAlertMigration {

    Logger logger = Logger.getLogger(DuplicateVaccinationAlertMigration.class);
    private ScheduleService scheduleService;
    private EnrollmentAlertService enrollmentAlertService;
    private AllEnrollments allEnrollments;
    @Autowired
    private MdsRepository dbRepository;

    public DuplicateVaccinationAlertMigration(ScheduleService scheduleService,
            EnrollmentAlertService enrollmentAlertService,
            AllEnrollments allEnrollments) {
        this.scheduleService = scheduleService;
        this.enrollmentAlertService = enrollmentAlertService;
        this.allEnrollments = allEnrollments;
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationCareMigrationContext.xml");
    }

    /**
     * Client id is the CASE ID of either the MOTHER CASE OR THE CHILD CASE for
     * whom the vaccination alerts have been raised multiple times due to the
     * platform issue. The platform scheduled the Repeatable schedule job to
     * repeat indefinitely.
     * 
     * @param clientCaseID
     */
    public void deleteAndUnEnrollDuplicateVaccinationAlerts(String clientCaseID) {

        if (StringUtils.isNotEmpty(clientCaseID)) {

            DuplicateVaccinationAlertService duplicateVaccinationAlertService = new DuplicateVaccinationAlertService(
                    allEnrollments, enrollmentAlertService);
            MotherCase mother = dbRepository.get(MotherCase.class, "caseId",
                    clientCaseID);
            if (mother != null) {
                duplicateVaccinationAlertService
                        .deleteCareTasksForGivenMotherCase(clientCaseID);
            } else {
                ChildCase child = dbRepository.get(ChildCase.class, "caseId",
                        clientCaseID);
                if (child != null) {
                    duplicateVaccinationAlertService
                            .deleteCareTasksForGivenChildCase(clientCaseID);
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
