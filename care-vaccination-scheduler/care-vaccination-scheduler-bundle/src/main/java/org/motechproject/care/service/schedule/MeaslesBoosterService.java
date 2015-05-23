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
public class MeaslesBoosterService extends VaccinationService {
    @Autowired
    public MeaslesBoosterService(ScheduleService schedulerService,
            CareCaseTaskService careCaseTaskService) {
        super(schedulerService, ChildVaccinationSchedule.MeaslesBooster
                .getName(), careCaseTaskService);
    }

    @Override
    public void process(Client client) {
        ChildCase child = (ChildCase) client;
        if (child.getDob() != null) {
            schedulerService.enroll(child.getCaseId(), child.getDob(),
                    scheduleName);
        }
        if (child.getDateMeaslesBooster() != null) {
            fulfillMilestone(client, MilestoneType.MeaslesBooster, child
                    .getDateMeaslesBooster());
        }
    }
}