package org.motechproject.care.migration;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.motechproject.care.schedule.service.ScheduleService;
import org.motechproject.scheduler.service.MotechSchedulerService;
import org.motechproject.scheduletracking.repository.AllEnrollments;
import org.motechproject.scheduletracking.service.impl.EnrollmentAlertService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/migrate")

public class DuplicateVaccinationAlertMigrationController {
    
    private ScheduleService scheduleService;
    private EnrollmentAlertService enrollmentAlertService;
    private AllEnrollments allEnrollments;
    Logger logger = Logger.getLogger(DuplicateVaccinationAlertMigrationController.class);
    @Autowired
    private ForceCloseVaccinations forceCloseVaccinations;
    @Autowired
    private CloseOldTasks closeOldTasks;

    @Autowired
    public DuplicateVaccinationAlertMigrationController(ScheduleService scheduleService
             /*AllEnrollments allEnrollments*/) {
        this.scheduleService = scheduleService;
        this.enrollmentAlertService = null;
        this.allEnrollments = null;
    }

    @RequestMapping(value = "/deleteDuplicateVaccinations/{fileName}", method = RequestMethod.GET)
    public void deleteDuplicateVaccinationAlerts(@PathVariable String fileName) {
        DuplicateVaccinationAlertMigration duplicateVaccinationAlertMigration = new DuplicateVaccinationAlertMigration(scheduleService,enrollmentAlertService, allEnrollments);
        logger.info("Starting to load Case Ids from CSV...");
        duplicateVaccinationAlertMigration.loadCaseIdsFromCSVAndDeleteDuplicateTasks(fileName);
    }

    @RequestMapping(value="/forceCloseCase/{fileName}" , method = RequestMethod.GET)
    public void forceCloseCaseTask(@PathVariable String fileName){
	forceCloseVaccinations.forceCloseCases(fileName);
    }


    @RequestMapping(value="/oldJobs" , method = RequestMethod.GET)
    public void migrateOldJobs(HttpServletRequest request, HttpServletResponse response){
	MigrateOldJobs migrateOldJobs = new MigrateOldJobs();
	try {
			migrateOldJobs.runMigration();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
    }

    @RequestMapping(value="/closeOldTasks", method = RequestMethod.GET)
    public void closeOldTasks(HttpServletRequest request, HttpServletResponse response) {
        closeOldTasks.run();
    }
}
