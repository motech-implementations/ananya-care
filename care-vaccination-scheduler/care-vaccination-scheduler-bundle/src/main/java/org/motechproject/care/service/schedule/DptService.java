package org.motechproject.care.service.schedule;

import org.motechproject.care.schedule.service.MilestoneType;
import org.motechproject.care.schedule.service.ScheduleService;
import org.motechproject.care.schedule.vaccinations.ChildVaccinationSchedule;
import org.motechproject.care.service.CareCaseTaskService;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DptService extends VaccinationService{

    @Autowired
    public DptService(ScheduleService schedulerService, CareCaseTaskService careCaseTaskService) {
        super(schedulerService, ChildVaccinationSchedule.DPT.getName(), careCaseTaskService);
    }

    @Override
    public void process(Client client) {
        ChildCase child = (ChildCase) client;
        if(child.getDob() != null)
            schedulerService.enroll(child.getCaseId(), child.getDob(), scheduleName, child.getDob());
        if(child.getDpt1Date()!=null)
            fulfillMilestone(client, MilestoneType.DPT1, child.getDpt1Date());
        if(child.getDpt2Date()!=null)
            fulfillMilestone(client, MilestoneType.DPT2, child.getDpt2Date());
        if(child.getDpt3Date()!=null)
            fulfillMilestone(client, MilestoneType.DPT3, child.getDpt3Date());
    }
}
