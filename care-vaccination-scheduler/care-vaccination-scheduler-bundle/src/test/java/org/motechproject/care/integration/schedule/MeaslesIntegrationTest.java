package org.motechproject.care.integration.schedule;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.motechproject.care.schedule.service.MilestoneType;
import org.motechproject.care.schedule.vaccinations.ChildVaccinationSchedule;
import org.motechproject.care.service.ChildService;
import org.motechproject.care.service.VaccinationProcessor;
import org.motechproject.care.service.builder.ChildBuilder;
import org.motechproject.care.service.schedule.MeaslesService;
import org.motechproject.care.service.schedule.VaccinationService;
import org.motechproject.care.utils.CaseUtils;
import org.motechproject.care.utils.SpringIntegrationTest;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.motechproject.scheduletracking.domain.EnrollmentStatus;
import org.motechproject.scheduletracking.service.EnrollmentRecord;
import org.motechproject.scheduletracking.service.EnrollmentsQuery;
import org.motechproject.commons.date.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MeaslesIntegrationTest extends SpringIntegrationTest {

    @Autowired
    private MeaslesService measlesService;
    @Autowired
    MdsRepository dbRepository;

    private String caseId;
    private ChildService childService;

    @Before
    public void setUp(){
        caseId = CaseUtils.getUniqueCaseId();
        List<VaccinationService> vaccinationServices = Arrays.asList((VaccinationService) measlesService);
        VaccinationProcessor childVaccinationProcessor = new VaccinationProcessor(vaccinationServices);
        childService = new ChildService(childVaccinationProcessor);
    }

    @After
    public void tearDown() {
        dbRepository.deleteAll(ChildCase.class);
    }

    @Test
    public void shouldVerifyMeaslesScheduleCreationWhenChildIsRegistered() {
        String measlesScheduleName = ChildVaccinationSchedule.Measles.getName();
        DateTime dob = DateUtil.newDateTime(DateUtil.today().minusMonths(4));

        ChildCase child=new ChildBuilder().withCaseId(caseId).withDOB(dob).withMeaslesDate(null).withMotherCaseId("motherCaseId").build();
        childService.process(child);

        markScheduleForUnEnrollment(caseId,  measlesScheduleName);
        EnrollmentsQuery query = new EnrollmentsQuery()
                .havingExternalId(caseId)
                .havingState(EnrollmentStatus.ACTIVE)
                .havingSchedule(measlesScheduleName);

        EnrollmentRecord enrollment = trackingService.searchWithWindowDates(query).get(0);

        assertEquals(MilestoneType.Measles.toString(), enrollment.getCurrentMilestoneName());
        assertEquals(dob, enrollment.getReferenceDateTime().withTimeAtStartOfDay());
        assertEquals(dob.plusMonths(9), enrollment.getStartOfDueWindow().withTimeAtStartOfDay());
        assertEquals(dob.plusMonths(24), enrollment.getStartOfLateWindow().withTimeAtStartOfDay());

        ChildCase childFromDb = dbRepository.get(ChildCase.class, "caseId", caseId);
        assertEquals(dob, childFromDb.getDob());
        assertNull(childFromDb.getMeaslesDate());
    }

    @Test
    public void shouldVerifyMeaslesScheduleFulfillmentWhenChildHasTakenMeasles() {
        String measlesScheduleName = ChildVaccinationSchedule.Measles.getName();
        DateTime dob = DateUtil.newDateTime(DateUtil.today().minusMonths(4));
        DateTime measlesTaken = DateUtil.newDateTime(DateUtil.today().plusMonths(1));
        String motherCaseId = "motherCaseId";

        ChildCase child=new ChildBuilder().withCaseId(caseId).withDOB(dob).withMeaslesDate(null).withMotherCaseId(motherCaseId).build();
        childService.process(child);
        child=new ChildBuilder().withCaseId(caseId).withDOB(dob).withMeaslesDate(measlesTaken).withMotherCaseId(motherCaseId).build();
        childService.process(child);

        assertNull(trackingService.getEnrollment(caseId, measlesScheduleName));

        ChildCase childFromDb = dbRepository.get(ChildCase.class, "caseId", caseId);
        assertEquals(dob, childFromDb.getDob());
        assertEquals(measlesTaken, childFromDb.getMeaslesDate());
    }
}
