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
public class HepService extends VaccinationService{

    @Autowired
    public HepService(ScheduleService schedulerService, CareCaseTaskService careCaseTaskService) {
        super(schedulerService, ChildVaccinationSchedule.Hepatitis.getName(), careCaseTaskService);
    }

    @Override
    public void process(Client client) {
        ChildCase child = (ChildCase) client;
        if(child.getDob() != null)
            schedulerService.enroll(child.getCaseId(), child.getDob(), scheduleName, child.getDob());
        if(child.getHepB1Date()!=null)
            fulfillMilestone(client, MilestoneType.Hep1, child.getHepB1Date());
        if(child.getHepB2Date()!=null)
            fulfillMilestone(client, MilestoneType.Hep2, child.getHepB2Date());
        if(child.getHepB3Date()!=null)
            fulfillMilestone(client, MilestoneType.Hep3, child.getHepB3Date());
    }
}
