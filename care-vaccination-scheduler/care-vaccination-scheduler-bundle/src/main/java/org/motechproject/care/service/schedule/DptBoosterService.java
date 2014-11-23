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
public class DptBoosterService extends VaccinationService{

    private PeriodUtil periodUtil;

    @Autowired
    public DptBoosterService(ScheduleService schedulerService, CareCaseTaskService careCaseTaskService, PeriodUtil periodUtil) {
        super(schedulerService, ChildVaccinationSchedule.DPTBooster.getName(), careCaseTaskService);
        this.periodUtil = periodUtil;
    }

    @Override
    public void process(Client client) {
        ChildCase child = (ChildCase) client;

        if(child.getDpt3Time() != null && child.getDob() != null){
            Window dptBoosterWindow = getDPTBoosterWindow(child.getDpt3Time(), child.getDob());
            if(dptBoosterWindow.isValid()) {
                DateTime referenceDate = dptBoosterWindow.getStart().plus(periodUtil.getScheduleOffset());
                schedulerService.enroll(child.getCaseId(), referenceDate, scheduleName);
            }
        }
        if(child.getDptBoosterTime() != null) {
            fulfillMilestone(client, MilestoneType.DPTBooster, child.getDptBoosterTime());
        }
    }

    private Window getDPTBoosterWindow(DateTime dpt3Date, DateTime dob) {
        DateTime nextPossibleDPTBoosterDate = dpt3Date.plusDays(180);
        Window dptBoosterWindow = new Window(nextPossibleDPTBoosterDate, dob.plusMonths(24));

        Window last8MonthsWindow = new Window(dob.plusMonths(16), dob.plusMonths(24));

        return dptBoosterWindow.resize(last8MonthsWindow);
    }
}
