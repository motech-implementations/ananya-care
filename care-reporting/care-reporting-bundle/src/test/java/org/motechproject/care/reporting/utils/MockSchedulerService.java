package org.motechproject.care.reporting.utils;

import java.util.Date;
import java.util.List;

import org.motechproject.event.MotechEvent;
import org.motechproject.scheduler.contract.CronSchedulableJob;
import org.motechproject.scheduler.contract.DayOfWeekSchedulableJob;
import org.motechproject.scheduler.contract.JobBasicInfo;
import org.motechproject.scheduler.contract.JobDetailedInfo;
import org.motechproject.scheduler.contract.JobId;
import org.motechproject.scheduler.contract.RepeatingSchedulableJob;
import org.motechproject.scheduler.contract.RunOnceSchedulableJob;
import org.motechproject.scheduler.service.MotechSchedulerService;

public class MockSchedulerService implements MotechSchedulerService {
    @Override
    public void scheduleJob(CronSchedulableJob cronSchedulableJob) {

    }

    @Override
    public void safeScheduleJob(CronSchedulableJob cronSchedulableJob) {

    }

    @Override
    public void updateScheduledJob(MotechEvent motechEvent) {

    }

    @Override
    public void rescheduleJob(String s, String s1, String s2) {

    }

    @Override
    public void scheduleRepeatingJob(RepeatingSchedulableJob repeatingSchedulableJob) {

    }

    @Override
    public void safeScheduleRepeatingJob(RepeatingSchedulableJob repeatingSchedulableJob) {

    }

    @Override
    public void scheduleRunOnceJob(RunOnceSchedulableJob runOnceSchedulableJob) {

    }

    @Override
    public void safeScheduleRunOnceJob(RunOnceSchedulableJob runOnceSchedulableJob) {

    }

    @Override
    public void scheduleDayOfWeekJob(DayOfWeekSchedulableJob dayOfWeekSchedulableJob) {

    }

    @Override
    public void unscheduleJob(String s, String s1) {

    }

    @Override
    public void unscheduleJob(JobId jobId) {

    }

    @Override
    public void safeUnscheduleJob(String s, String s1) {

    }

    @Override
    public void unscheduleAllJobs(String s) {

    }

    @Override
    public void safeUnscheduleAllJobs(String s) {

    }

    @Override
    public void unscheduleRepeatingJob(String s, String s1) {

    }

    @Override
    public void safeUnscheduleRepeatingJob(String s, String s1) {

    }

    @Override
    public void unscheduleRunOnceJob(String s, String s1) {

    }

    @Override
    public void safeUnscheduleRunOnceJob(String s, String s1) {

    }

    @Override
    public List<Date> getScheduledJobTimings(String s, String s1, Date date, Date date1) {
        return null;
    }

    @Override
    public List<Date> getScheduledJobTimingsWithPrefix(String s, String s1, Date date, Date date1) {
        return null;
    }

    @Override
    public List<JobBasicInfo> getScheduledJobsBasicInfo() {
        return null;
    }

    @Override
    public JobDetailedInfo getScheduledJobDetailedInfo(JobBasicInfo jobBasicInfo) {
        return null;
    }
}
