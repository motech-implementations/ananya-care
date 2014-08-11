package org.motechproject.care.integration.schedule;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.motechproject.care.domain.Child;
import org.motechproject.care.repository.AllChildren;
import org.motechproject.care.schedule.service.MilestoneType;
import org.motechproject.care.schedule.vaccinations.ChildVaccinationSchedule;
import org.motechproject.care.service.ChildService;
import org.motechproject.care.service.VaccinationProcessor;
import org.motechproject.care.service.builder.ChildBuilder;
import org.motechproject.care.service.schedule.MeaslesBoosterService;
import org.motechproject.care.service.schedule.MeaslesService;
import org.motechproject.care.service.schedule.VaccinationService;
import org.motechproject.care.utils.CaseUtils;
import org.motechproject.care.utils.SpringIntegrationTest;
import org.motechproject.scheduletracking.api.domain.EnrollmentStatus;
import org.motechproject.scheduletracking.api.service.EnrollmentRecord;
import org.motechproject.scheduletracking.api.service.EnrollmentsQuery;
import org.motechproject.commons.date.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MeaslesBoosterIntegrationTest extends SpringIntegrationTest {

    @Autowired
    private MeaslesBoosterService measlesBoosterService;
    @Autowired
    private AllChildren allChildren;

    private String caseId;
    private ChildService childService;

    @Before
    public void setUp() {
        caseId = CaseUtils.getUniqueCaseId();
        List<VaccinationService> vaccinationServices = Arrays.asList((VaccinationService) measlesBoosterService);
        VaccinationProcessor childVaccinationProcessor = new VaccinationProcessor(vaccinationServices);
        childService = new ChildService(allChildren, childVaccinationProcessor);
    }

    @After
    public void tearDown() {
        allChildren.removeAll();
    }

    @Test
    public void shouldVerifyMeaslesBoosterScheduleCreationWhenChildIsRegistered() {
        String measlesBoosterScheduleName = ChildVaccinationSchedule.MeaslesBooster.getName();
        DateTime dob = DateUtil.newDateTime(DateUtil.today().minusMonths(4));

        Child child = new ChildBuilder().withCaseId(caseId).withDOB(dob).withMeaslesDate(null).withMeaslesBoosterDate(null).withMotherCaseId("motherCaseId").build();
        childService.process(child);

        markScheduleForUnEnrollment(caseId, measlesBoosterScheduleName);
        EnrollmentsQuery query = new EnrollmentsQuery()
                .havingExternalId(caseId)
                .havingState(EnrollmentStatus.ACTIVE)
                .havingSchedule(measlesBoosterScheduleName);

        EnrollmentRecord enrollment = trackingService.searchWithWindowDates(query).get(0);

        assertEquals(MilestoneType.MeaslesBooster.toString(), enrollment.getCurrentMilestoneName());
        assertEquals(dob, enrollment.getReferenceDateTime().withTimeAtStartOfDay());
        assertEquals(dob.plusMonths(15), enrollment.getStartOfDueWindow().withTimeAtStartOfDay());
        assertEquals(dob.plusMonths(24), enrollment.getStartOfLateWindow().withTimeAtStartOfDay());

        Child childFromDb = allChildren.findByCaseId(caseId);
        assertEquals(dob, childFromDb.getDOB());
        assertNull(childFromDb.getMeaslesBoosterDate());
    }
}
