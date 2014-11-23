package org.motechproject.care.service.schedule;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.motechproject.care.schedule.service.MilestoneType;
import org.motechproject.care.schedule.service.ScheduleService;
import org.motechproject.care.schedule.vaccinations.ChildVaccinationSchedule;
import org.motechproject.care.service.CareCaseTaskService;
import org.motechproject.care.service.util.PeriodUtil;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OpvBoosterServiceTest {
    @Mock
    private ScheduleService schedulerService;
    @Mock
    private CareCaseTaskService careCaseTaskService;
    @Mock
    private PeriodUtil periodUtil;

    private OpvBoosterService opvBoosterService;
    private String scheduleName = ChildVaccinationSchedule.OPVBooster.getName();
    private final Period periodOffset = Period.weeks(-2);

    @Before
    public void setUp(){
        opvBoosterService = new OpvBoosterService(schedulerService, careCaseTaskService, periodUtil);
        when(periodUtil.getScheduleOffset()).thenReturn(periodOffset);
    }

    @Test
    public void shouldEnrollChildForOPVBoosterScheduleWhenOPV3IsTakenBetween16to24MonthsAge(){
        DateTime dob = new DateTime();
        DateTime opv3Taken = dob.plusMonths(17);
        String caseId = "caseId";
        ChildCase child = new ChildCase();
        child.setDob(dob);
        child.setOpv3Time(opv3Taken);
        child.setCaseId(caseId);

        opvBoosterService.process(child);
        Mockito.verify(schedulerService).enroll(caseId, opv3Taken.plusDays(180).plus(periodOffset), scheduleName);
    }

    @Test
    public void shouldEnrollChildForOPVBoosterScheduleWhenOPV3IsTaken180OrMoreDaysPriorTo16MonthsAge(){
        DateTime dob = new DateTime();
        DateTime opv3Taken = dob.plusMonths(8);
        String caseId = "caseId";
        ChildCase child = new ChildCase();
        child.setDob(dob);
        child.setOpv3Time(opv3Taken);
        child.setCaseId(caseId);

        opvBoosterService.process(child);
        Mockito.verify(schedulerService).enroll(caseId, dob.plusMonths(16).plus(periodOffset), scheduleName);
    }

    @Test
    public void shouldEnrollChildForOPVBoosterScheduleWhenOPV3IsTakenLessThan180DaysPriorTo16MonthsAge(){
        DateTime dob = new DateTime();
        DateTime opv3Taken = dob.plusMonths(11);
        String caseId = "caseId";
        ChildCase child = new ChildCase();
        child.setDob(dob);
        child.setOpv3Time(opv3Taken);
        child.setCaseId(caseId);

        opvBoosterService.process(child);
        Mockito.verify(schedulerService).enroll(caseId, opv3Taken.plusDays(180).plus(periodOffset), scheduleName);
    }

    @Test
    public void shouldNotEnrollChildForOPVBoosterScheduleWhenOPV3IsNotTaken(){
        DateTime dob = new DateTime();
        String caseId = "caseId";
        ChildCase child = new ChildCase();
        child.setDob(dob);
        child.setCaseId(caseId);

        opvBoosterService.process(child);
        Mockito.verify(schedulerService, never()).enroll(anyString(), any(DateTime.class), anyString());
    }

    @Test
    public void shouldNotEnrollChildForOPVBoosterScheduleWhenOPV3IsTakenAfter18MonthsOfAge(){
        DateTime dob = new DateTime();
        DateTime opv3Taken = dob.plusMonths(19);
        String caseId = "caseId";
        ChildCase child = new ChildCase();
        child.setDob(dob);
        child.setOpv3Time(opv3Taken);
        child.setCaseId(caseId);

        opvBoosterService.process(child);
        Mockito.verify(schedulerService, never()).enroll(anyString(), any(DateTime.class), anyString());
    }

    @Test
    public void shouldFulfillOPVBoosterIfOPVBoosterDatePresentInChild(){
        DateTime opvBoosterDate = new DateTime();
        String caseId = "caseId";

        ChildCase child = new ChildCase();
        child.setOpvBoosterTime(opvBoosterDate);
        child.setCaseId(caseId);

        opvBoosterService.process(child);
        Mockito.verify(schedulerService).fulfillMilestone(caseId, MilestoneType.OPVBooster.toString(), opvBoosterDate, scheduleName);
        Mockito.verify(careCaseTaskService).close(child, MilestoneType.OPVBooster.toString());
    }

    @Test
    public void shouldUnenrollFromOpvBoosterSchedule(){
        String caseId = "caseId";
        MotherCase mother = new MotherCase();
        mother.setCaseId(caseId);

        opvBoosterService.close(mother);
        Mockito.verify(schedulerService).unenroll(caseId,scheduleName);
    }
}