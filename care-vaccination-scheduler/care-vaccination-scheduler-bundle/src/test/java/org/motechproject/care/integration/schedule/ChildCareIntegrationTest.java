package org.motechproject.care.integration.schedule;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.motechproject.care.schedule.service.MilestoneType;
import org.motechproject.care.schedule.vaccinations.ExpirySchedule;
import org.motechproject.care.service.ChildService;
import org.motechproject.care.service.VaccinationProcessor;
import org.motechproject.care.service.builder.ChildBuilder;
import org.motechproject.care.service.schedule.ChildCareService;
import org.motechproject.care.service.schedule.VaccinationService;
import org.motechproject.care.utils.CaseUtils;
import org.motechproject.care.utils.SpringIntegrationTest;
import org.motechproject.mcts.care.common.mds.domain.Child;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.motechproject.scheduletracking.domain.EnrollmentStatus;
import org.motechproject.scheduletracking.service.EnrollmentRecord;
import org.motechproject.scheduletracking.service.EnrollmentsQuery;
import org.motechproject.scheduletracking.service.ScheduleTrackingService;
import org.motechproject.commons.date.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class ChildCareIntegrationTest extends SpringIntegrationTest {

    @Autowired
    private ChildCareService childCareService;
    @Autowired
    private ScheduleTrackingService scheduleTrackingService;
    @Autowired
    MdsRepository dbRepository;

    private String caseId;
    private ChildService childService;

    @After
    public void tearDown() {
        dbRepository.deleteAll(Child.class);
    }

    @Before
    public void setUp(){
        caseId = CaseUtils.getUniqueCaseId();
        List<VaccinationService> ttServices = Arrays.asList((VaccinationService) childCareService);
        VaccinationProcessor childVaccinationProcessor = new VaccinationProcessor(ttServices);
        childService = new ChildService(childVaccinationProcessor);
    }

    @Test
    public void shouldVerifyChildCareScheduleCreationWhenChildIsRegistered() {
        String childCareScheduleName = ExpirySchedule.ChildCare.getName();
        DateTime dob = DateUtil.newDateTime(DateUtil.today()).plusMonths(4);

        Child child=new ChildBuilder().withCaseId(caseId).withDOB(dob).build();
        childService.process(child);
        markScheduleForUnEnrollment(caseId, childCareScheduleName);
        EnrollmentsQuery query = new EnrollmentsQuery()
                .havingExternalId(caseId)
                .havingState(EnrollmentStatus.ACTIVE)
                .havingSchedule(childCareScheduleName);

        EnrollmentRecord enrollment = scheduleTrackingService.searchWithWindowDates(query).get(0);

        assertEquals(MilestoneType.ChildCare.toString(), enrollment.getCurrentMilestoneName());
        assertEquals(dob, enrollment.getReferenceDateTime().withTimeAtStartOfDay());
        assertEquals(dob, enrollment.getStartOfDueWindow().withTimeAtStartOfDay());
        assertEquals(dob.plusMonths(24).plusDays(1), enrollment.getStartOfLateWindow().withTimeAtStartOfDay());
    }
}
