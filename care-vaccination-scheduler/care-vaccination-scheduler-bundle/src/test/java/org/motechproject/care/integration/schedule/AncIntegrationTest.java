package org.motechproject.care.integration.schedule;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.motechproject.care.schedule.service.MilestoneType;
import org.motechproject.care.schedule.vaccinations.MotherVaccinationSchedule;
import org.motechproject.care.service.MotherService;
import org.motechproject.care.service.VaccinationProcessor;
import org.motechproject.care.service.builder.MotherBuilder;
import org.motechproject.care.service.schedule.AncService;
import org.motechproject.care.service.schedule.VaccinationService;
import org.motechproject.care.service.util.PeriodUtil;
import org.motechproject.care.utils.CaseUtils;
import org.motechproject.care.utils.SpringIntegrationTest;
import org.motechproject.mcts.care.common.mds.domain.Mother;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.motechproject.scheduletracking.domain.EnrollmentStatus;
import org.motechproject.scheduletracking.service.EnrollmentRecord;
import org.motechproject.testing.osgi.BasePaxIT;
import org.motechproject.testing.osgi.container.MotechNativeTestContainerFactory;
import org.motechproject.commons.date.util.DateUtil;
import org.ops4j.pax.exam.ExamFactory;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerSuite;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
@RunWith(PaxExam.class)
@ExamReactorStrategy(PerSuite.class)
@ExamFactory(MotechNativeTestContainerFactory.class)
public class AncIntegrationTest extends SpringIntegrationTest {

    @Autowired
    private AncService ancService;
    @Autowired 
    MdsRepository dbRepository;
    private String caseId;
    private MotherService motherService;

    @After
    public void tearDown() {
        
        dbRepository.deleteAll(Mother.class);
    }

    @Before
    public void setUp(){
        caseId = CaseUtils.getUniqueCaseId();
        List<VaccinationService> ancServices = Arrays.asList((VaccinationService) ancService);
        VaccinationProcessor motherVaccinationProcessor = new VaccinationProcessor(ancServices);
        motherService = new MotherService(motherVaccinationProcessor);
    }

    @Test
    public void shouldVerifyAncScheduleCreationWhenMotherIsRegistered() {
        String ancScheduleName = MotherVaccinationSchedule.Anc.getName();
        DateTime edd = DateUtil.newDateTime(DateUtil.today()).plusMonths(4);

        Mother mother=new MotherBuilder().withCaseId(caseId).withEdd(edd).withANC1(null).withANC2(null).withANC3(null).build();
        motherService.process(mother);
        markScheduleForUnEnrollment(caseId, ancScheduleName);
        EnrollmentRecord enrollment = getEnrollmentRecord(ancScheduleName, caseId, EnrollmentStatus.ACTIVE);

        assertEquals(MilestoneType.Anc1.toString(), enrollment.getCurrentMilestoneName());
        assertEquals(edd.minusDays(PeriodUtil.DAYS_IN_9_MONTHS), enrollment.getReferenceDateTime().withTimeAtStartOfDay());
        assertEquals(edd.minusDays(PeriodUtil.DAYS_IN_9_MONTHS), enrollment.getStartOfDueWindow().withTimeAtStartOfDay());
        assertEquals(edd.plusWeeks(2), enrollment.getStartOfLateWindow().withTimeAtStartOfDay());
    }

    @Test
    public void shouldVerifyAnc1ScheduleFulfillmentWhenAnc1VisitIsOver() {
        String ancScheduleName = MotherVaccinationSchedule.Anc.getName();
        DateTime edd = DateUtil.newDateTime(DateUtil.today()).plusMonths(4);
        DateTime anc1Date = DateUtil.newDateTime(DateUtil.today()).plusMonths(1);

        Mother mother=new MotherBuilder().withCaseId(caseId).withEdd(edd).withANC1(null).withANC2(null).withANC3(null).build();
        motherService.process(mother);
        mother = new MotherBuilder().withCaseId(caseId).withEdd(edd).withANC1(anc1Date).withANC2(null).withANC3(null).build();
        motherService.process(mother);

        markScheduleForUnEnrollment(caseId, ancScheduleName);
        EnrollmentRecord enrollment = getEnrollmentRecord(ancScheduleName, caseId, EnrollmentStatus.ACTIVE);

        assertEquals(MilestoneType.Anc2.toString(), enrollment.getCurrentMilestoneName());
        assertEquals(anc1Date.plusDays(30), enrollment.getStartOfDueWindow().withTimeAtStartOfDay());
        assertEquals(anc1Date.plusDays(PeriodUtil.DAYS_IN_9_MONTHS).plusWeeks(2), enrollment.getStartOfLateWindow().withTimeAtStartOfDay());

    }

    @Test
    public void shouldVerifyAnc2ScheduleFulfillmentWhenAnc2VisitHasHappened() {
        String ancScheduleName = MotherVaccinationSchedule.Anc.getName();
        DateTime edd = DateUtil.newDateTime(DateUtil.today()).plusMonths(4);
        DateTime anc1FulfillmentDate = DateUtil.newDateTime(DateUtil.today()).plusMonths(1);
        DateTime anc2FulfillmentDate = DateUtil.newDateTime(DateUtil.today()).plusMonths(3);

        Mother mother=new MotherBuilder().withCaseId(caseId).withEdd(edd).withANC1(null).withANC2(null).withANC3(null).build();
        motherService.process(mother);
        mother=new MotherBuilder().withCaseId(caseId).withEdd(edd).withANC1(anc1FulfillmentDate).withANC2(null).withANC3(null).build();
        motherService.process(mother);
        mother=new MotherBuilder().withCaseId(caseId).withEdd(edd).withANC1((anc1FulfillmentDate)).withANC2(anc2FulfillmentDate).withANC3(null).build();
        motherService.process(mother);

        markScheduleForUnEnrollment(caseId, ancScheduleName);
        EnrollmentRecord enrollment = getEnrollmentRecord(ancScheduleName, caseId, EnrollmentStatus.ACTIVE);

        assertEquals(MilestoneType.Anc3.toString(), enrollment.getCurrentMilestoneName());
        assertEquals(anc2FulfillmentDate.plusDays(30), enrollment.getStartOfDueWindow().withTimeAtStartOfDay());
        assertEquals(anc2FulfillmentDate.plusDays(PeriodUtil.DAYS_IN_9_MONTHS).plusWeeks(2), enrollment.getStartOfLateWindow().withTimeAtStartOfDay());
    }

    @Test
    public void shouldVerifyAnc3ScheduleFulfillmentWhenAnc3VisitHasHappened() {
        String ancScheduleName = MotherVaccinationSchedule.Anc.getName();
        DateTime edd = DateUtil.newDateTime(DateUtil.today()).plusMonths(4);
        DateTime anc1FulfillmentDate = DateUtil.newDateTime(DateUtil.today()).plusMonths(1);
        DateTime anc2FulfillmentDate = DateUtil.newDateTime(DateUtil.today()).plusMonths(3);
        DateTime anc3FulfillmentDate = DateUtil.newDateTime(DateUtil.today()).plusMonths(5);

        Mother mother=new MotherBuilder().withCaseId(caseId).withEdd(edd).withANC1(null).withANC2(null).withANC3(null).build();
        motherService.process(mother);
        mother=new MotherBuilder().withCaseId(caseId).withEdd(edd).withANC1(anc1FulfillmentDate).withANC2(null).withANC3(null).build();
        motherService.process(mother);
        mother=new MotherBuilder().withCaseId(caseId).withEdd(edd).withANC1(anc1FulfillmentDate).withANC2(anc2FulfillmentDate).withANC3(null).build();
        motherService.process(mother);
        mother=new MotherBuilder().withCaseId(caseId).withEdd(edd).withANC1((anc1FulfillmentDate)).withANC2(anc2FulfillmentDate).withANC3(anc3FulfillmentDate).build();
        motherService.process(mother);

        Assert.assertNull(trackingService.getEnrollment(caseId, ancScheduleName));
    }
}
