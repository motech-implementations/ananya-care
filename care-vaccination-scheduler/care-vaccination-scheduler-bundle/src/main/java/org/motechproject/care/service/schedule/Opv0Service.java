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
public class Opv0Service extends VaccinationService{

    @Autowired
    public Opv0Service(ScheduleService schedulerService, CareCaseTaskService careCaseTaskService) {
        super(schedulerService, ChildVaccinationSchedule.OPV0.getName(), careCaseTaskService);
    }

    @Override
    public void process(Client client) {
        ChildCase child = (ChildCase) client;
        if(child.getDob() != null)
            schedulerService.enroll(child.getCaseId(), child.getDob(), scheduleName);
        if(child.getOpv0Date()!=null)
            fulfillMilestone(client, MilestoneType.OPV0, child.getOpv0Date());
    }
}
