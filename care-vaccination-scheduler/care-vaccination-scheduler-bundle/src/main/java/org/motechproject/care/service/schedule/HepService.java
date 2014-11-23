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
            schedulerService.enroll(child.getCaseId(), child.getDob(), scheduleName);
        if(child.getHepB1Time()!=null)
            fulfillMilestone(client, MilestoneType.Hep1, child.getHepB1Time());
        if(child.getHepB2Time()!=null)
            fulfillMilestone(client, MilestoneType.Hep2, child.getHepB2Time());
        if(child.getHepB3Time()!=null)
            fulfillMilestone(client, MilestoneType.Hep3, child.getHepB3Time());
    }
}
