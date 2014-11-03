package org.motechproject.care.tools;

import org.joda.time.LocalDate;
import org.motechproject.scheduler.contract.EventInfo;
import org.motechproject.scheduler.contract.JobBasicInfo;
import org.motechproject.scheduler.contract.JobDetailedInfo;
import org.motechproject.scheduler.factory.MotechSchedulerFactoryBean;
import org.motechproject.scheduler.service.MotechSchedulerService;
import org.motechproject.scheduletracking.domain.MilestoneAlert;
import org.motechproject.scheduletracking.events.constants.EventDataKeys;
import org.motechproject.scheduletracking.service.EnrollmentRecord;
import org.motechproject.scheduletracking.service.ScheduleTrackingService;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.TriggerUtils;
import org.quartz.impl.calendar.BaseCalendar;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.spi.OperableTrigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class QuartzWrapper {

    private MotechSchedulerService scheduler;
    private ScheduleTrackingService trackingService;

    @Autowired
    public QuartzWrapper(MotechSchedulerService scheduler, ScheduleTrackingService trackingService) {
        this.scheduler = scheduler;
        this.trackingService = trackingService;
    }

    public AlertDetails checkQuartzQueueForNextAlertsForThisSchedule(String externalId, String scheduleName) throws SchedulerException, IOException {
        AlertDetails nextAlertDetails = new NullAlertDetails();

     //   GroupMatcher<TriggerKey> groupMatcher = GroupMatcher.groupEquals("default");
    //    Set<TriggerKey> triggersInGroup = scheduler.getTriggerKeys(groupMatcher);

    ///    for(TriggerKey triggerKey : triggersInGroup) {
     //       Trigger trigger = scheduler.getTrigger(triggerKey);
     //       JobDetail detail = scheduler.getJobDetail(JobKey.jobKey(triggerKey.getName(), triggerKey.getGroup()));

     //       JobDataMap dataMap = detail.getJobDataMap();
        JobBasicInfo jobInfo = new JobBasicInfo();
        jobInfo.setName(scheduleName); //TODO TEST THIS THOROUGHLY ..whether schedulename is the param that needs to be sent
        JobDetailedInfo jobDetailedInfo = scheduler.getScheduledJobDetailedInfo(jobInfo);
        for(EventInfo curr: jobDetailedInfo.getEventInfoList()) {
            Map<String,Object> dataMap = curr.getParameters();
            if (scheduleName.equals(dataMap.get(EventDataKeys.SCHEDULE_NAME)) && externalId.equals(dataMap.get(EventDataKeys.EXTERNAL_ID))) {
                EnrollmentRecord enrollment = trackingService.getEnrollment(externalId, scheduleName);
                if(enrollment == null) {
                    continue;
                }
                LocalDate startDate = new LocalDate(enrollment.getReferenceDateTime());
                LocalDate endDate = startDate.plusYears(2).plusMonths(1);
                AlertDetails alertDetails = getAlertDetail(scheduler.getScheduledJobTimings(
                        curr.getSubject(), externalId, startDate.toDate(), endDate.toDate()), dataMap,startDate);
                if(alertDetails.isBefore(nextAlertDetails)) {
                    nextAlertDetails = alertDetails;
                }
            }
        }
    
        return nextAlertDetails;
    }
    
    private AlertDetails getAlertDetail(List times, Map<String,Object> dataMap, LocalDate startDate) {
        if (times == null || times.size() == 0) {
            return new NullAlertDetails();
        }

        MilestoneAlert milestoneAlert = (MilestoneAlert) dataMap.get(EventDataKeys.MILESTONE_NAME);
        String milestoneName = milestoneAlert.getMilestoneName();
        return new AlertDetails(milestoneName, (String) dataMap.get(EventDataKeys.WINDOW_NAME), (Date) times.get(0));
    }
 
    private AlertDetails getAlertDetail(List times, JobDataMap dataMap, LocalDate startDate) {
        if (times == null || times.size() == 0) {
            return new NullAlertDetails();
        }

        MilestoneAlert milestoneAlert = (MilestoneAlert) dataMap.get(EventDataKeys.MILESTONE_NAME);
        String milestoneName = milestoneAlert.getMilestoneName();
        return new AlertDetails(milestoneName, (String) dataMap.get(EventDataKeys.WINDOW_NAME), (Date) times.get(0));
    }

    private AlertDetails getAlertDetail(Trigger trigger, JobDataMap dataMap, LocalDate startDate) {
        if(!(trigger instanceof OperableTrigger)) {
            return new NullAlertDetails();
        }

        OperableTrigger operableTrigger = (OperableTrigger) trigger;
        LocalDate endDate = startDate.plusYears(2).plusMonths(1);

        List times = TriggerUtils.computeFireTimesBetween(operableTrigger, new BaseCalendar(), startDate.toDate(), endDate.toDate());
        return getAlertDetail(times, dataMap, startDate);
    }
}
