package org.motechproject.care.integration.schedule;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.motechproject.care.schedule.service.MilestoneType;
import org.motechproject.care.schedule.vaccinations.MotherVaccinationSchedule;
import org.motechproject.care.service.MotherService;
import org.motechproject.care.service.VaccinationProcessor;
import org.motechproject.care.service.builder.MotherBuilder;
import org.motechproject.care.service.schedule.TTBoosterService;
import org.motechproject.care.service.schedule.VaccinationService;
import org.motechproject.care.service.util.PeriodUtil;
import org.motechproject.care.utils.CaseUtils;
import org.motechproject.care.utils.SpringIntegrationTest;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.motechproject.scheduletracking.domain.EnrollmentStatus;
import org.motechproject.scheduletracking.service.EnrollmentRecord;
import org.motechproject.commons.date.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TTBoosterIntegrationTest extends SpringIntegrationTest {

    @Autowired
    private TTBoosterService ttBoosterService;
    @Autowired
    MdsRepository dbRepository;
    private String caseId;
    private MotherService motherService;
    String scheduleName = MotherVaccinationSchedule.TTBooster.getName();

    @After
    public void tearDown() {
        dbRepository.deleteAll(MotherCase.class);
    }

    @Before
    public void setUp(){
        caseId = CaseUtils.getUniqueCaseId();
        List<VaccinationService> ttServices = Arrays.asList((VaccinationService) ttBoosterService);
        VaccinationProcessor motherVaccinationProcessor = new VaccinationProcessor(ttServices);
        motherService = new MotherService(motherVaccinationProcessor);
    }

    @Test
    public void shouldVerifyTTBoosterScheduleCreationWhenMotherIsRegisteredWithLastPregSetToTrue() {

        DateTime edd = DateUtil.newDateTime(DateUtil.today()).plusMonths(4);

        MotherCase mother=new MotherBuilder().withCaseId(caseId).withEdd(edd).withLastPregTT("yes").withTTBooster(null).build();
        motherService.process(mother);
        markScheduleForUnEnrollment(caseId, scheduleName);
        EnrollmentRecord enrollment = getEnrollmentRecord(scheduleName, caseId, EnrollmentStatus.ACTIVE);

        assertEquals(MilestoneType.TTBooster.toString(), enrollment.getCurrentMilestoneName());
        assertEquals(edd.minusDays(PeriodUtil.DAYS_IN_9_MONTHS), enrollment.getReferenceDateTime().withTimeAtStartOfDay());
        assertEquals(edd.minusDays(PeriodUtil.DAYS_IN_9_MONTHS), enrollment.getStartOfDueWindow().withTimeAtStartOfDay());
        assertEquals(edd.plusWeeks(2), enrollment.getStartOfLateWindow().withTimeAtStartOfDay());
    }

    @Test
    public void shouldVerifyTTBoosterScheduleFulfillmentWhenMotherHasTakenTTBooster() {

        DateTime today = DateUtil.newDateTime(DateUtil.today());
        DateTime edd = today.plusDays(PeriodUtil.DAYS_IN_9_MONTHS);
        DateTime ttBoosterDate = today.plusWeeks(4);

        MotherCase mother=new MotherBuilder().withCaseId(caseId).withEdd(edd).withLastPregTT("yes").withTTBooster(ttBoosterDate).build();
        motherService.process(mother);

        assertNull(trackingService.getEnrollment(caseId, scheduleName));
    }
}
