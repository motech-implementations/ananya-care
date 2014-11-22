package org.motechproject.care.service.schedule;

import org.motechproject.care.schedule.service.ScheduleService;
import org.motechproject.care.schedule.vaccinations.ExpirySchedule;
import org.motechproject.care.service.CareCaseTaskService;
import org.motechproject.care.service.util.PeriodUtil;
import org.motechproject.mcts.care.common.mds.domain.Client;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MotherCareService extends VaccinationService{

    @Autowired
    public MotherCareService(ScheduleService schedulerService, CareCaseTaskService careCaseTaskService) {
        super(schedulerService, ExpirySchedule.MotherCare.getName(), careCaseTaskService);
    }

    @Override
    public void process(Client client) {
        MotherCase mother = (MotherCase) client;
        if(mother.getEdd() != null){
            schedulerService.enroll(mother.getCaseId(), mother.getEdd().minusDays(PeriodUtil.DAYS_IN_9_MONTHS), scheduleName);
        }
    }
}
