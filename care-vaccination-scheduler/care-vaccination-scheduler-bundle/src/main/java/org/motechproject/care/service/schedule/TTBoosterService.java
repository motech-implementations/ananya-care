package org.motechproject.care.service.schedule;

import org.motechproject.care.schedule.service.MilestoneType;
import org.motechproject.care.schedule.service.ScheduleService;
import org.motechproject.care.schedule.vaccinations.MotherVaccinationSchedule;
import org.motechproject.care.service.CareCaseTaskService;
import org.motechproject.care.service.util.PeriodUtil;
import org.motechproject.mcts.care.common.mds.domain.Client;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TTBoosterService extends VaccinationService{


    @Autowired
    public TTBoosterService(ScheduleService schedulerService, CareCaseTaskService careCaseTaskService) {
        super(schedulerService, MotherVaccinationSchedule.TTBooster.getName(), careCaseTaskService);
    }

    @Override
    public void process(Client client) {
        MotherCase mother = (MotherCase) client;
        if(mother.getEdd() != null && mother.getLastPregTt().equals("yes")){
            schedulerService.enroll(mother.getCaseId(), mother.getEdd().minusDays(PeriodUtil.DAYS_IN_9_MONTHS), scheduleName);
        }
        if(mother.getTtBoosterDate() != null){
            fulfillMilestone(client, MilestoneType.TTBooster, mother.getTtBoosterDate());
        }
    }
}
