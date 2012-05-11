package org.motechproject.care.schedule.service;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.motechproject.model.Time;
import org.motechproject.scheduletracking.api.domain.EnrollmentStatus;
import org.motechproject.scheduletracking.api.service.EnrollmentRecord;
import org.motechproject.scheduletracking.api.service.EnrollmentRequest;
import org.motechproject.scheduletracking.api.service.EnrollmentsQuery;
import org.motechproject.scheduletracking.api.service.ScheduleTrackingService;
import org.motechproject.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ScheduleService {
    protected ScheduleTrackingService trackingService;
    Logger logger = Logger.getLogger(ScheduleService.class);

    @Autowired
    public ScheduleService(ScheduleTrackingService trackingService) {
        this.trackingService = trackingService;
    }

    public void enroll(String caseId, DateTime referenceDate, String scheduleName) {
        if (isNotEnrolled(caseId, scheduleName)) {
            logger.info(String.format("Enrolling client for external id : %s , schedule : %s", caseId, scheduleName));
            trackingService.enroll(enrollmentRequestFor(caseId, referenceDate.toLocalDate(), scheduleName));
        }
    }

    public EnrollmentRecord unenroll(String caseId, String scheduleName) {
        EnrollmentRecord enrollment = getActiveOrDefaultedEnrollment(caseId, scheduleName);
        if (enrollment == null) {
            return null;
        }
        logger.info(String.format("Un-enrolling client for external id : %s , schedule : %s", caseId, scheduleName));
        trackingService.unenroll(caseId, Arrays.asList(scheduleName));

        return enrollment;
    }

    public void fulfillMileStone(String caseId, String milestoneName, DateTime vaccinationTakenDate, String scheduleName) {
        if (isCurrentMilestone(caseId, milestoneName, scheduleName))
            fulfillCurrentMilestone(caseId, vaccinationTakenDate, scheduleName);
    }

    private EnrollmentRecord getActiveOrDefaultedEnrollment(String externalId, String scheduleName) {
        EnrollmentsQuery activeEnrollmentsQuery = new EnrollmentsQuery()
                .havingExternalId(externalId)
                .havingSchedule(scheduleName).havingState(EnrollmentStatus.ACTIVE);
        EnrollmentsQuery defaultedEnrollmentsQuery = new EnrollmentsQuery()
                .havingExternalId(externalId)
                .havingSchedule(scheduleName).havingState(EnrollmentStatus.DEFAULTED);

        List<EnrollmentRecord> enrollmentRecords = trackingService.search(activeEnrollmentsQuery);
        if (enrollmentRecords.size() == 1)
            return enrollmentRecords.get(0);
        enrollmentRecords= trackingService.search(defaultedEnrollmentsQuery);
        if (enrollmentRecords.size() == 1)
            return enrollmentRecords.get(0);

        return null;
    }

    private boolean isNotEnrolled(String externalId, String scheduleName) {
        EnrollmentsQuery query = new EnrollmentsQuery()
                .havingExternalId(externalId)
                .havingSchedule(scheduleName);

        if (trackingService.search(query).size() == 1)
            return false;
        return true;
    }

    private boolean isCurrentMilestone(String caseId, String milestoneName, String scheduleName) {
        EnrollmentRecord enrollment = trackingService.getEnrollment(caseId, scheduleName);
        if (enrollment == null) return false;
        return enrollment.getCurrentMilestoneName().equals(milestoneName);
    }

    private void fulfillCurrentMilestone(String caseId, DateTime fulfillmentDateTime, String scheduleName) {
        LocalDate fulfillmentDate = fulfillmentDateTime.toLocalDate();
        Time fulfillmentTime = DateUtil.time(fulfillmentDateTime);
        logger.info(String.format("Fulfilling current milestone for external id : %s , schedule : %s", caseId, scheduleName));
        trackingService.fulfillCurrentMilestone(caseId, scheduleName, fulfillmentDate, fulfillmentTime);
    }

    private EnrollmentRequest enrollmentRequestFor(String caseId, LocalDate referenceDate, String scheduleName) {
        Time preferredAlertTime = DateUtil.time(DateTime.now().plusMinutes(2));
        LocalDate enrollmentDate = DateUtil.today();
        Time enrollmentTime = DateUtil.time(DateUtil.now());
        return new EnrollmentRequest(caseId, scheduleName, preferredAlertTime, referenceDate, null, enrollmentDate, enrollmentTime, null, null);
    }
}
