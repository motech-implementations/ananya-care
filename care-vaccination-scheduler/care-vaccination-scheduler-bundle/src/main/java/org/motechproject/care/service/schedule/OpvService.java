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
public class OpvService extends VaccinationService{

    @Autowired
    public OpvService(ScheduleService schedulerService, CareCaseTaskService careCaseTaskService) {
        super(schedulerService, ChildVaccinationSchedule.OPV.getName(), careCaseTaskService);
    }

    @Override
    public void process(Client client) {
        ChildCase child = (ChildCase) client;
        if(child.getDob() != null)
            schedulerService.enroll(child.getCaseId(), child.getDob(), scheduleName, child.getDob());
        if(child.getOpv1Date()!=null)
            fulfillMilestone(client, MilestoneType.OPV1, child.getOpv1Date());
        if(child.getOpv2Date()!=null)
            fulfillMilestone(client, MilestoneType.OPV2, child.getOpv2Date());
        if(child.getOpv3Date()!=null)
            fulfillMilestone(client, MilestoneType.OPV3, child.getOpv3Date());
    }
}
