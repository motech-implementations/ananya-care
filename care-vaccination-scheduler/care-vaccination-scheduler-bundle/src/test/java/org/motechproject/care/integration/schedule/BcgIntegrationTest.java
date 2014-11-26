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
import org.motechproject.care.service.schedule.BcgService;
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

public class BcgIntegrationTest extends SpringIntegrationTest {

    @Autowired
    private BcgService bcgService;
    @Autowired 
    MdsRepository dbRepository;
    
    private String caseId;

    private ChildService childService;
    private final String scheduleName = ChildVaccinationSchedule.Bcg.getName();

    @Before
    public void setUp(){
        caseId = CaseUtils.getUniqueCaseId();
        List<VaccinationService> vaccinationServices = Arrays.asList((VaccinationService) bcgService);
        VaccinationProcessor childVaccinationProcessor = new VaccinationProcessor(vaccinationServices);
        childService = new ChildService(childVaccinationProcessor);
    }

    @After
    public void tearDown() {
        dbRepository.deleteAll(ChildCase.class);
    }

    @Test
    public void shouldVerifyBcgScheduleCreationWhenChildIsRegistered() {
        DateTime dob = DateUtil.newDateTime(DateUtil.today().minusMonths(4));

        String motherCaseId = "motherCaseId";
        ChildCase child = new ChildBuilder().withCaseId(caseId).withDOB(dob).withBcgDate(null).withMotherCaseId(motherCaseId).build();
        childService.process(child);

        markScheduleForUnEnrollment(caseId, scheduleName);
        EnrollmentsQuery query = new EnrollmentsQuery()
                .havingExternalId(caseId)
                .havingState(EnrollmentStatus.ACTIVE)
                .havingSchedule(scheduleName);

        EnrollmentRecord enrollment = trackingService.searchWithWindowDates(query).get(0);

        assertEquals(MilestoneType.Bcg.toString(), enrollment.getCurrentMilestoneName());
        assertEquals(dob, enrollment.getReferenceDateTime().withTimeAtStartOfDay());
        assertEquals(dob, enrollment.getStartOfDueWindow().withTimeAtStartOfDay());
        assertEquals(dob.plusMonths(12), enrollment.getStartOfLateWindow().withTimeAtStartOfDay());

        ChildCase childFromDB = dbRepository.get(ChildCase.class, "caseId", caseId);
        assertEquals(dob , childFromDB.getDob());
        assertNull(childFromDB.getBcgDate());
    }

    @Test
    public void shouldVerifyBcgScheduleFulfillmentWhenChildHasTakenBcg() {
        String bcgScheduleName = ChildVaccinationSchedule.Bcg.getName();
        DateTime dob = DateUtil.newDateTime(DateUtil.today().minusMonths(4));
        DateTime bcgTaken = DateUtil.newDateTime(DateUtil.today().plusMonths(1));
        String motherCaseId = "motherCaseId";

        ChildCase child = new ChildBuilder().withCaseId(caseId).withDOB(dob).withBcgDate(null).withMotherCaseId(motherCaseId).build();
        childService.process(child);
        child=new ChildBuilder().withCaseId(caseId).withDOB(dob).withBcgDate(bcgTaken).withMotherCaseId(motherCaseId).build();
        childService.process(child);

        assertNull(trackingService.getEnrollment(caseId, bcgScheduleName));

        ChildCase childFromDb = dbRepository.get(ChildCase.class, "caseId", caseId);
        assertEquals(dob, childFromDb.getDob());
        assertEquals(bcgTaken, childFromDb.getBcgDate());
    }
}
