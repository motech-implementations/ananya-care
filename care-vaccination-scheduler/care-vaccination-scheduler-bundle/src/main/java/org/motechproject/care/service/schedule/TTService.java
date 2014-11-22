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
public class TTService extends VaccinationService{

    @Autowired
    public TTService(ScheduleService schedulerService, CareCaseTaskService careCaseTaskService) {
        super(schedulerService, MotherVaccinationSchedule.TT.getName(), careCaseTaskService);
    }

    @Override
    public void process(Client client) {
        MotherCase mother = (MotherCase) client;
        if(mother.getEdd() != null && isNotEligibleForBooster(mother)){
            schedulerService.enroll(mother.getCaseId(), mother.getEdd().minusDays(PeriodUtil.DAYS_IN_9_MONTHS), scheduleName);
        }
        if(mother.getTt1Date() != null){
            fulfillMilestone(client, MilestoneType.TT1, mother.getTt1Date());
        }
        if(mother.getTt2Date() != null){
            fulfillMilestone(client, MilestoneType.TT2, mother.getTt2Date());
        }
    }

    private boolean isNotEligibleForBooster(MotherCase mother) {
        return mother.getLastPregTt()==null || mother.getLastPregTt().equals("no");
    }
}
