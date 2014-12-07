package org.motechproject.care.service.schedule;

import org.joda.time.DateTime;
import org.motechproject.care.schedule.service.MilestoneType;
import org.motechproject.care.schedule.service.ScheduleService;
import org.motechproject.care.schedule.vaccinations.ChildVaccinationSchedule;
import org.motechproject.care.service.CareCaseTaskService;
import org.motechproject.care.service.util.PeriodUtil;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.domain.Client;
import org.motechproject.mcts.care.common.mds.domain.Window;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MeaslesBoosterService extends VaccinationService {
    private PeriodUtil periodUtil;
    @Autowired
    public MeaslesBoosterService(ScheduleService schedulerService,
            CareCaseTaskService careCaseTaskService, PeriodUtil periodUtil) {
        super(schedulerService, ChildVaccinationSchedule.MeaslesBooster
                .getName(), careCaseTaskService);
        this.periodUtil = periodUtil;
    }

    @Override
    public void process(Client client) {
        ChildCase child = (ChildCase) client;
        if (child.getMeaslesDate() != null && child.getDob() != null) {
            Window measlesBoosterWindow = getMeaslesBoosterWindow(child.getMeaslesDate(), child.getDob());
            if(measlesBoosterWindow.isValid()) {
                DateTime referenceDate = measlesBoosterWindow.getStart().plus(periodUtil.getScheduleOffset());
            schedulerService.enroll(child.getCaseId(), referenceDate,
                    scheduleName);
            }
        }
        if (child.getDateMeaslesBooster() != null) {
            fulfillMilestone(client, MilestoneType.MeaslesBooster, child
                    .getDateMeaslesBooster());
        }
    }
    
    private Window getMeaslesBoosterWindow(DateTime measlesDate, DateTime dob) {
        DateTime nextPossibleMeaslesBoosterDate = measlesDate.plusDays(180);
        Window measlesBoosterWindow = new Window(nextPossibleMeaslesBoosterDate, dob.plusMonths(24));

        Window last8MonthsWindow = new Window(dob.plusMonths(16), dob.plusMonths(24));

        return measlesBoosterWindow.resize(last8MonthsWindow);
    }
    
}
