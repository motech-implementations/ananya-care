package org.motechproject.care.service.schedule;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.motechproject.care.schedule.service.MilestoneType;
import org.motechproject.care.schedule.service.ScheduleService;
import org.motechproject.care.service.CareCaseTaskService;
import org.motechproject.mcts.care.common.mds.domain.Client;
import org.motechproject.scheduletracking.service.EnrollmentRecord;

public abstract class VaccinationService {

    protected ScheduleService schedulerService;
    protected String scheduleName;
    private CareCaseTaskService careCaseTaskService;
    
    Logger logger = Logger.getLogger(VaccinationService.class);


    public VaccinationService(ScheduleService schedulerService, String scheduleName, CareCaseTaskService careCaseTaskService) {
        this.schedulerService = schedulerService;
        this.scheduleName = scheduleName;
        this.careCaseTaskService = careCaseTaskService;
    }

    public abstract  void process(Client client);

    public void close(Client client) {
    	
        EnrollmentRecord enrollmentRecord = schedulerService.unenroll(client.getCaseId(), scheduleName);
        if(enrollmentRecord == null)
            return;
        String currentMilestoneName = enrollmentRecord.getCurrentMilestoneName();
        
        if(currentMilestoneName != null) {
        		careCaseTaskService.close(client, currentMilestoneName);
        }else {
        	logger.info( String.format("For Client case Id %s , there is no care case task scheduled ",client.getCaseId()));
        }
    }

    protected void fulfillMilestone(Client client, MilestoneType milestone, DateTime fulfillmentDate) {
        schedulerService.fulfillMilestone(client.getCaseId(), milestone.toString(), fulfillmentDate, scheduleName);
        careCaseTaskService.close(client, milestone.toString());
    }
}
