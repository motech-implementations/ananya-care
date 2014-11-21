package org.motechproject.care.reporting.scheduler;

import java.util.HashMap;

import org.motechproject.care.reporting.constants.EventConstants;
import org.motechproject.care.reporting.constants.PropertyConstants;
import org.motechproject.event.MotechEvent;
import org.motechproject.scheduler.contract.CronSchedulableJob;
import org.motechproject.scheduler.service.MotechSchedulerService;
import org.motechproject.server.config.SettingsFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy(false)
public class ComputeFieldsJobScheduler {

    private static final Logger logger = LoggerFactory.getLogger("commcare-reporting-mapper");

    @Autowired
    public ComputeFieldsJobScheduler(@Qualifier("careReportingSettings") SettingsFacade settings, @Qualifier("schedulerServiceOsgi")MotechSchedulerService motechSchedulerService) {
        scheduleCronJob(motechSchedulerService, settings.getProperty(PropertyConstants.COMPUTE_FIELDS_JOB_CRON_EXPRESSION), EventConstants.COMPUTE_FIELDS, EventConstants.COMPUTE_FIELDS_JOB_ID_KEY);
    }

    private void scheduleCronJob(MotechSchedulerService motechSchedulerService, String cronExpression, String eventSubject, Object jobIdKey) {
        logger.info(String.format("Setting up cron job for computing fields with cron expression %s", cronExpression));
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put(MotechSchedulerService.JOB_ID_KEY, jobIdKey);
        CronSchedulableJob providerSyncCronJob = new CronSchedulableJob(new MotechEvent(eventSubject, parameters), cronExpression);
        motechSchedulerService.scheduleJob(providerSyncCronJob);
    }

}
