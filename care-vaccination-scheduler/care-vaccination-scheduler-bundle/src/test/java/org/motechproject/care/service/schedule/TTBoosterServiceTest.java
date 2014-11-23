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
import org.motechproject.care.schedule.vaccinations.MotherVaccinationSchedule;
import org.motechproject.care.service.CareCaseTaskService;
import org.motechproject.care.service.util.PeriodUtil;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TTBoosterServiceTest {
    @Mock
    private ScheduleService schedulerService;
    @Mock
    CareCaseTaskService careCaseTaskService;

    TTBoosterService ttBoosterService;
    private String scheduleName = MotherVaccinationSchedule.TTBooster.getName();


    @Before
    public void setUp(){
        ttBoosterService = new TTBoosterService(schedulerService, careCaseTaskService);
    }

    @Test
    public void shouldEnrollMotherForTTBoosterScheduleIfLastPregFlagTrueAndEddPresent(){
        DateTime edd = new DateTime();
        String caseId = "caseId";
        MotherCase mother = new MotherCase();
        mother.setEdd(edd);
        mother.setLastPregTt("yes");
        mother.setCaseId(caseId);

        ttBoosterService.process(mother);
        Mockito.verify(schedulerService).enroll(caseId, edd.minusDays(PeriodUtil.DAYS_IN_9_MONTHS), scheduleName);
    }

    @Test
    public void shouldNotEnrollMotherForTTBoosterScheduleIfLastPregFlagFalseAndEddPresent(){
        DateTime edd = new DateTime();
        String caseId = "caseId";
        MotherCase mother = new MotherCase();
        mother.setEdd(edd);
        mother.setLastPregTt("no");
        mother.setCaseId(caseId);

        ttBoosterService.process(mother);
        verify(schedulerService, never()).enroll(any(String.class), any(DateTime.class), anyString());
    }

    @Test
    public void shouldNotEnrollMotherForTTBoosterScheduleIfLastPregFlagTrueAndEddNotPresent(){
        DateTime edd = new DateTime();
        String caseId = "caseId";
        MotherCase mother = new MotherCase();
        mother.setLastPregTt("yes");
        mother.setCaseId(caseId);

        ttBoosterService.process(mother);
        verify(schedulerService, never()).enroll(any(String.class), any(DateTime.class), anyString());
    }

    @Test
    public void shouldFulfillTTBoosterIfTTBoosterDatePresentInMother(){
        DateTime ttBoosterDate = new DateTime();
        String caseId = "caseId";
        MotherCase mother = new MotherCase();
        mother.setTtBoosterDate(ttBoosterDate);
        mother.setCaseId(caseId);

        ttBoosterService.process(mother);
        Mockito.verify(schedulerService).fulfillMilestone(caseId, MilestoneType.TTBooster.toString(), ttBoosterDate, scheduleName);
        Mockito.verify(careCaseTaskService).close(mother, MilestoneType.TTBooster.toString());
    }

    @Test
    public void shouldUnenrollFromTTBoosterSchedule(){
        String caseId = "caseId";

        MotherCase mother = new MotherCase();
        mother.setCaseId(caseId);

        ttBoosterService.close(mother);
        Mockito.verify(schedulerService).unenroll(caseId, scheduleName);

    }


}
