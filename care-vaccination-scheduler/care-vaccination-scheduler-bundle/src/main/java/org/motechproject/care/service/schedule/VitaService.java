package org.motechproject.care.service.schedule;

import org.motechproject.care.schedule.service.MilestoneType;
import org.motechproject.care.schedule.service.ScheduleService;
import org.motechproject.care.schedule.vaccinations.ChildVaccinationSchedule;
import org.motechproject.care.service.CareCaseTaskService;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VitaService extends VaccinationService {

    @Autowired
    public VitaService(ScheduleService schedulerService,
            CareCaseTaskService careCaseTaskService) {
        super(schedulerService, ChildVaccinationSchedule.Vita.getName(),
                careCaseTaskService);
    }

    @Override
    public void process(Client client) {
        ChildCase child = (ChildCase) client;
        if (child.getDob() != null) {
            schedulerService.enroll(child.getCaseId(), child.getDob(),
                    scheduleName, child.getDob());
        }
        if (child.getVitA1Date() != null) {
            fulfillMilestone(client, MilestoneType.VitaminA, child
                    .getVitA1Date());
        }
        if (child.getVitA2Date() != null) {
            fulfillMilestone(client, MilestoneType.VitaminA2, child
                    .getVitA2Date());
        }
    }
}
