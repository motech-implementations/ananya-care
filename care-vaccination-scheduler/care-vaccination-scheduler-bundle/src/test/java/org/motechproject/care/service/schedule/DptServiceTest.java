package org.motechproject.care.service.schedule;

import org.joda.time.DateTime;
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
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
import org.motechproject.mcts.care.common.mds.domain.Client;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DptServiceTest {
    @Mock
    private ScheduleService schedulerService;
    @Mock
    CareCaseTaskService careCaseTaskService;

    DptService dptService;
    private String scheduleName = ChildVaccinationSchedule.DPT.getName();

    @Before
    public void setUp(){
        dptService = new DptService(schedulerService, careCaseTaskService);
    }

    @Test
    public void shouldEnrollChildForDptSchedule(){
        DateTime dob = new DateTime();
        String caseId = "caseId";
        ChildCase child = new ChildCase();
        child.setDob(dob);
        child.setCaseId(caseId);

        dptService.process(child);
        Mockito.verify(schedulerService).enroll(caseId, dob, scheduleName);
    }

    @Test
    public void shouldNotEnrollChildForDptScheduleWhenDOBIsNull(){
        ChildCase child = new ChildCase();
        child.setCaseId("caseId");

        dptService.process(child);
        verify(schedulerService, never()).enroll(any(String.class), any(DateTime.class), anyString());
    }

    @Test
    public void shouldFulfillDpt1IfDpt1DatePresentInChild(){
        DateTime dpt1Date = new DateTime();
        String caseId = "caseId";
        ChildCase child = new ChildCase();
        child.setDpt1Date(dpt1Date);
        child.setCaseId(caseId);

        dptService.process(child);
        Mockito.verify(schedulerService).fulfillMilestone(caseId, MilestoneType.DPT1.toString(), dpt1Date, scheduleName);
        Mockito.verify(careCaseTaskService).close(child, MilestoneType.DPT1.toString());
    }

    @Test
    public void shouldFulfillDpt2IfDpt2DatePresentInChild(){
        DateTime dpt2Date = new DateTime();
        String caseId = "caseId";
        ChildCase child = new ChildCase();
        child.setDpt2Date(dpt2Date);
        child.setCaseId(caseId);

        dptService.process(child);
        Mockito.verify(schedulerService).fulfillMilestone(caseId, MilestoneType.DPT2.toString(), dpt2Date, scheduleName);
        Mockito.verify(careCaseTaskService).close(child, MilestoneType.DPT2.toString());
    }

    @Test
    public void shouldFulfillDpt3IfDpt3DatePresentInChild(){
        DateTime dpt3Date = new DateTime();
        String caseId = "caseId";
        ChildCase child = new ChildCase();
        child.setDpt3Date(dpt3Date);
        child.setCaseId(caseId);

        dptService.process(child);

        Mockito.verify(schedulerService).fulfillMilestone(caseId, MilestoneType.DPT3.toString(), dpt3Date, scheduleName);
        Mockito.verify(careCaseTaskService).close(child, MilestoneType.DPT3.toString());
    }

    @Test
    public void shouldNotFulfillAnyDptIfNoneOfTheTakenDatesArePresentInChild(){
        ChildCase child = new ChildCase();
        child.setCaseId("caseId");

        dptService.process(child);
        verify(schedulerService, never()).fulfillMilestone(any(String.class), any(String.class), any(DateTime.class), anyString());
        Mockito.verify(careCaseTaskService, never()).close(any(Client.class), any(String.class));
    }

    @Test
    public void shouldUnenrollFromDptSchedule(){
        String caseId = "caseId";

        MotherCase mother = new MotherCase();
        mother.setCaseId(caseId);

        dptService.close(mother);
        Mockito.verify(schedulerService).unenroll(caseId, scheduleName);

    }

}
