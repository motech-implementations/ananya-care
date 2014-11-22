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
public class OpvBoosterService extends VaccinationService{

    private PeriodUtil periodUtil;

    @Autowired
    public OpvBoosterService(ScheduleService schedulerService, CareCaseTaskService careCaseTaskService, PeriodUtil periodUtil) {
        super(schedulerService, ChildVaccinationSchedule.OPVBooster.getName(), careCaseTaskService);
        this.periodUtil = periodUtil;
    }

    @Override
    public void process(Client client) {
        ChildCase child = (ChildCase) client;

        if(child.getOpv3Time() != null && child.getDob() != null){
            Window opvBoosterWindow = getOPVBoosterWindow(child.getOpv3Time(), child.getDob());
            if(opvBoosterWindow.isValid()) {
                DateTime referenceDate = opvBoosterWindow.getStart().plus(periodUtil.getScheduleOffset());
                schedulerService.enroll(child.getCaseId(), referenceDate, scheduleName);
            }
        }
        if(child.getOpvBoosterTime() != null) {
            fulfillMilestone(client, MilestoneType.OPVBooster, child.getOpvBoosterTime());
        }
    }

    private Window getOPVBoosterWindow(DateTime opv3Date, DateTime dob) {
        DateTime nextPossibleOPVBoosterDate = opv3Date.plusDays(180);
        Window opvBoosterWindow = new Window(nextPossibleOPVBoosterDate, dob.plusMonths(24));

        Window last8MonthsWindow = new Window(dob.plusMonths(16), dob.plusMonths(24));

        return opvBoosterWindow.resize(last8MonthsWindow);
    }
}