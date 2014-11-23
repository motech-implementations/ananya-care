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
public class AncService extends VaccinationService{
    @Autowired
    public AncService(ScheduleService schedulerService, CareCaseTaskService careCaseTaskService) {
        super(schedulerService, MotherVaccinationSchedule.Anc.getName(), careCaseTaskService);
    }

    @Override
    public void process(Client client) {
        MotherCase mother = (MotherCase) client;
        if(mother.getEdd() != null){
            schedulerService.enroll(mother.getCaseId(), mother.getEdd().minusDays(PeriodUtil.DAYS_IN_9_MONTHS), scheduleName);
        }
        if(mother.getAnc1Date() != null) {
            fulfillMilestone(client, MilestoneType.Anc1, mother.getAnc1Date());
        }
        if(mother.getAnc2Date() != null) {
            fulfillMilestone(client, MilestoneType.Anc2, mother.getAnc2Date());
        }
        if(mother.getAnc3Date() != null) {
            fulfillMilestone(client, MilestoneType.Anc3, mother.getAnc3Date());
        }
    }
}
