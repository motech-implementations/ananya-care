package org.motechproject.care.service.schedule;

import org.motechproject.care.schedule.service.ScheduleService;
import org.motechproject.care.schedule.vaccinations.ExpirySchedule;
import org.motechproject.care.service.CareCaseTaskService;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChildCareService extends VaccinationService{

    @Autowired
    public ChildCareService(ScheduleService schedulerService, CareCaseTaskService careCaseTaskService) {
        super(schedulerService, ExpirySchedule.ChildCare.getName(), careCaseTaskService);
    }

    @Override
    public void process(Client client) {
        ChildCase child = (ChildCase) client;
        if(child.getDob() != null){
            schedulerService.enroll(child.getCaseId(), child.getDob(), scheduleName);
        }
    }
}
