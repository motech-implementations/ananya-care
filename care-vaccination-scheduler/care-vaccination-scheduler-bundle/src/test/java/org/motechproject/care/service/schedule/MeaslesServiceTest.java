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
public class MeaslesServiceTest {

    @Mock
    private ScheduleService schedulerService;
    @Mock
    CareCaseTaskService careCaseTaskService;

    MeaslesService measlesService;
    private String scheduleName = ChildVaccinationSchedule.Measles.getName();


    @Before
    public void setUp(){
        measlesService = new MeaslesService(schedulerService, careCaseTaskService);
    }

    @Test
    public void shouldEnrollChildForMeaslesSchedule(){
        DateTime dob = new DateTime();
        String caseId = "caseId";
        ChildCase child = new ChildCase();
        child.setDob(dob);
        child.setCaseId(caseId);

        measlesService.process(child);
        Mockito.verify(schedulerService).enroll(caseId, dob, scheduleName);
    }

    @Test
    public void shouldNotEnrollChildForMeaslesScheduleWhenDOBIsNull(){
        ChildCase child = new ChildCase();
        child.setCaseId("caseId");

        measlesService.process(child);
        verify(schedulerService, never()).enroll(any(String.class), any(DateTime.class), anyString());
    }

    @Test
    public void shouldFulfilMeaslesIfMeaslesDatePresentInChild(){
        DateTime measlesDate = new DateTime();
        String caseId = "caseId";
        ChildCase child = new ChildCase();
        child.setMeaslesDate(measlesDate);
        child.setCaseId(caseId);

        measlesService.process(child);
        Mockito.verify(schedulerService).fulfillMilestone(caseId, MilestoneType.Measles.toString(), measlesDate, scheduleName);
        Mockito.verify(careCaseTaskService).close(child, MilestoneType.Measles.toString());
    }

    @Test
    public void shouldNotFulfilMeaslesIfMeaslesDateNotPresentInChild(){
        ChildCase child = new ChildCase();
        child.setCaseId("caseId");

        measlesService.process(child);
        verify(schedulerService, never()).fulfillMilestone(any(String.class), any(String.class), any(DateTime.class), anyString());
        Mockito.verify(careCaseTaskService, never()).close(any(Client.class), any(String.class));
    }


    @Test
    public void shouldUnenrollFromMeaslesSchedule(){
        String caseId = "caseId";

        MotherCase mother = new MotherCase();
        mother.setCaseId(caseId);

        measlesService.close(mother);
        Mockito.verify(schedulerService).unenroll(caseId, scheduleName);

    }
}
