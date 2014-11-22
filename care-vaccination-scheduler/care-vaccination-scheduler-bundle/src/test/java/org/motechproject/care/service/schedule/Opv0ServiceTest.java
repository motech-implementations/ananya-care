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

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class Opv0ServiceTest {

    @Mock
    private ScheduleService schedulerService;
    @Mock
    CareCaseTaskService careCaseTaskService;

    private String scheduleName = ChildVaccinationSchedule.OPV0.getName();

    private Opv0Service opv0Service;


    @Before
    public void setUp(){
        opv0Service =new Opv0Service(schedulerService, careCaseTaskService);
    }

    @Test
    public void shouldNotEnrollChildForOPV0ScheduleWhenDOBIsNull(){
        ChildCase child = new ChildCase();
        child.setCaseId("caseId");
        opv0Service.process(child);
        verify(schedulerService, never()).enroll(any(String.class), any(DateTime.class), anyString());
    }

    @Test
    public void shouldEnrollChildForOPV0ScheduleWhenDOBIsAvailable(){
        ChildCase child = new ChildCase();
        child.setCaseId("caseId");
        child.setDob(DateTime.now());
        opv0Service.process(child);
        verify(schedulerService).enroll(any(String.class), any(DateTime.class), anyString());
    }

    @Test
    public void shouldFulfillOPV0MilestoneIfOPV0DateAvailable(){
        ChildCase child = new ChildCase();
        String caseId = "caseId";
        child.setCaseId(caseId);
        child.setDob(DateTime.now());
        DateTime opv0Date = DateTime.now().minusDays(1);
        child.setOpv0Time(opv0Date);
        opv0Service.process(child);
        verify(schedulerService).fulfillMilestone(caseId, MilestoneType.OPV0.toString(), opv0Date, ChildVaccinationSchedule.OPV0.getName());
        Mockito.verify(careCaseTaskService).close(child, MilestoneType.OPV0.toString());
    }

    @Test
    public void shouldUnenrollFromOpv0Schedule() {
        String caseId = "caseId";

        MotherCase mother = new MotherCase();
        mother.setCaseId(caseId);

        opv0Service.close(mother);
        Mockito.verify(schedulerService).unenroll(caseId,scheduleName);

    }



}
