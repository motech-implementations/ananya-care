package org.motechproject.care.reporting.scheduler;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.motechproject.care.reporting.constants.EventConstants;
import org.motechproject.care.reporting.constants.PropertyConstants;
import org.motechproject.event.MotechEvent;
import org.motechproject.scheduler.contract.CronSchedulableJob;
import org.motechproject.scheduler.service.MotechSchedulerService;
import org.motechproject.server.config.SettingsFacade;

public class ComputeFieldsJobSchedulerTest {

    @Mock
    private SettingsFacade settings;
    @Mock
    private MotechSchedulerService motechSchedulerService;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void shouldScheduleComputeFieldsCronJob() {
        String cronExpression = "0 6 * * 0";

        when(settings.getProperty(PropertyConstants.COMPUTE_FIELDS_JOB_CRON_EXPRESSION)).thenReturn(cronExpression);

        new ComputeFieldsJobScheduler(settings, motechSchedulerService);

        ArgumentCaptor<CronSchedulableJob> cronJobCaptor = ArgumentCaptor.forClass(CronSchedulableJob.class);
        verify(motechSchedulerService).scheduleJob(cronJobCaptor.capture());
        CronSchedulableJob actualScheduledCronJob = cronJobCaptor.getValue();

        assertEquals(cronExpression, actualScheduledCronJob.getCronExpression());

        MotechEvent actualMotechEvent = actualScheduledCronJob.getMotechEvent();

        Map<String,Object> parameters = actualMotechEvent.getParameters();
        assertEquals(1, parameters.size());
        assertEquals(EventConstants.COMPUTE_FIELDS_JOB_ID_KEY, parameters.get(MotechSchedulerService.JOB_ID_KEY));
        assertEquals(EventConstants.COMPUTE_FIELDS, actualMotechEvent.getSubject());
    }
}
