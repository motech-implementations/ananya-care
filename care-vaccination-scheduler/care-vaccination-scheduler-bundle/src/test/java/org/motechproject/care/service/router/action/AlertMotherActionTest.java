package org.motechproject.care.service.router.action;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.motechproject.care.domain.CareCaseTask;
import org.motechproject.care.domain.Mother;
import org.motechproject.care.repository.AllCareCaseTasks;
import org.motechproject.care.repository.AllMothers;
import org.motechproject.care.request.CaseType;
import org.motechproject.casexml.domain.CaseTask;
import org.motechproject.casexml.service.CaseService;
import org.motechproject.casexml.gateway.CommcareCaseGateway;
import org.motechproject.scheduletracking.api.domain.Milestone;
import org.motechproject.scheduletracking.api.domain.MilestoneAlert;
import org.motechproject.scheduletracking.api.events.MilestoneEvent;
import org.motechproject.commons.date.util.DateUtil;

import java.util.Properties;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class AlertMotherActionTest {

    @Mock
    private CommcareCaseGateway commcareCaseGateway;
    @Mock
    private AllMothers allMothers;
    @Mock
    private AllCareCaseTasks allCareCaseTasks;
    @Mock
    private Properties ananyaCareProperties;

    private AlertMotherAction alertMotherAction;


    @Before
    public void setUp() {
        initMocks(this);
        this.alertMotherAction = new AlertMotherAction(allMothers, commcareCaseGateway, allCareCaseTasks, ananyaCareProperties);
    }

    @Test
    public void shouldSendRightCaseTaskObjectToGateway() {
        String scheduleName = "TT Vaccination";
        String motherCaseId = "0A8MF30IJWI0FJW3JFW0J0W3A8";
        String milestoneName = "TT 1";
        String groupId = "groupId";
        String flwId = "FLW1234";
        String motherName = "Sita";
        DateTime startOfSchedule = DateUtil.now();

        Milestone milestone = new Milestone(milestoneName, weeks(0), weeks(36), null, null);
        MilestoneAlert milestoneAlert = MilestoneAlert.fromMilestone(milestone, startOfSchedule);
        MilestoneEvent milestoneEvent = new MilestoneEvent(motherCaseId, scheduleName, milestoneAlert, "due", startOfSchedule, null);

        Mother client = new Mother(motherCaseId, null, flwId, motherName, groupId, DateTime.now().plusYears(1), null, null, null, false, null, null, null, null, null, true);
        when(allMothers.findByCaseId(motherCaseId)).thenReturn(client);
        String commCareUrl = "commCareUrl";
        String motechUserId = "motechUserId";
        when(ananyaCareProperties.getProperty("commcare.hq.url")).thenReturn(commCareUrl);
        when(ananyaCareProperties.getProperty("motech.user.id")).thenReturn(motechUserId);
        String redeliveryCount = "5";
        when(ananyaCareProperties.getProperty("commcare.hq.redelivery.count")).thenReturn(redeliveryCount);
        alertMotherAction.invoke(milestoneEvent);


        ArgumentCaptor<CaseTask> argumentCaptor = ArgumentCaptor.forClass(CaseTask.class);
        verify(commcareCaseGateway).submitCase(eq(commCareUrl), argumentCaptor.capture(), anyString(), anyString(), anyInt());
        CaseTask task = argumentCaptor.getValue();

        assertNotNull(task.getTaskId());
        assertNotNull(task.getCurrentTime());
        assertEquals(milestoneName, task.getCaseName());
        assertEquals(startOfSchedule.toString("yyyy-MM-dd"), task.getDateEligible());
        assertEquals(null, task.getDateExpires());
        assertEquals(groupId, task.getOwnerId());
        assertEquals("tt_1", task.getTaskId());
        assertEquals(motherCaseId,task.getClientCaseId());
        assertEquals(CaseType.Mother.getType(),task.getClientCaseType());
        assertEquals(motechUserId,task.getMotechUserId());
    }

    @Test
    public void shouldSaveTaskToDb() {
        String scheduleName = "TT Vaccination";
        String motherCaseId = "0A8MF30IJWI0FJW3JFW0J0W3A8";
        String caseName = "TT 1";
        String groupId = "groupId";
        String flwId = "FLW1234";
        String motherName = "Sita";
        DateTime startScheduleDate = DateUtil.now();

        Milestone milestone = new Milestone(caseName, weeks(0), weeks(36), null, null);
        MilestoneAlert milestoneAlert = MilestoneAlert.fromMilestone(milestone, startScheduleDate);
        MilestoneEvent milestoneEvent = new MilestoneEvent(motherCaseId, scheduleName, milestoneAlert, "due", startScheduleDate, null);

        Mother client = new Mother(motherCaseId, null, flwId, motherName, groupId, startScheduleDate.plusYears(1), null, null, null, false, null, null, null, null, null, true);
        when(allMothers.findByCaseId(motherCaseId)).thenReturn(client);
        String redeliveryCount = "5";
        when(ananyaCareProperties.getProperty("commcare.hq.redelivery.count")).thenReturn(redeliveryCount);

        String motechUserId = "motechUserId";
        when(ananyaCareProperties.getProperty("motech.user.id")).thenReturn(motechUserId);
        alertMotherAction.invoke(milestoneEvent);

        ArgumentCaptor<CareCaseTask> careCaseTaskArgumentCaptor = ArgumentCaptor.forClass(CareCaseTask.class);
        verify(allCareCaseTasks).add(careCaseTaskArgumentCaptor.capture());

        CareCaseTask task = careCaseTaskArgumentCaptor.getValue();

        assertNotNull(task.getCurrentTime());
        assertEquals(caseName, task.getMilestoneName());
        assertEquals("task", task.getCaseType());
        assertEquals(startScheduleDate.toString("yyyy-MM-dd"), task.getDateEligible());
        assertEquals(null, task.getDateExpires());
        assertEquals(groupId, task.getOwnerId());
        assertEquals("tt_1", task.getTaskId());
        assertEquals(motherCaseId,task.getClientCaseId());
        assertEquals(CaseType.Mother.getType(),task.getClientCaseType());
        assertEquals(motechUserId,task.getMotechUserId());
    }

    @Test
    public void shouldHandleWhenExpiryDateIsBeyondEDDBeforeSendingToGateway() {
        String scheduleName = "TT Vaccination";
        String motherCaseId = "0A8MF30IJWI0FJW3JFW0J0W3A8";
        String caseName = "TT 1";
        String groupId = "groupId";
        String flwId = "FLW1234";
        String motherName = "Sita";
        DateTime now = DateTime.now();
        DateTime edd = now.plusMonths(2);
        DateTime startScheduleDate = edd.minusMonths(8);

        Milestone milestone = new Milestone(caseName, null, months(9), null, null);
        MilestoneAlert milestoneAlert = MilestoneAlert.fromMilestone(milestone, startScheduleDate);
        MilestoneEvent milestoneEvent = new MilestoneEvent(motherCaseId, scheduleName, milestoneAlert, "due", startScheduleDate, null);

        Mother client = new Mother(motherCaseId, null, flwId, motherName, groupId, edd, null, null, null, false, null, null, null, null, null, true);
        when(allMothers.findByCaseId(motherCaseId)).thenReturn(client);
        String commCareUrl = "commCareUrl";
        String motechUserId = "motechUserId";
        when(ananyaCareProperties.getProperty("commcare.hq.url")).thenReturn(commCareUrl);
        when(ananyaCareProperties.getProperty("motech.user.id")).thenReturn(motechUserId);
        String redeliveryCount = "5";
        when(ananyaCareProperties.getProperty("commcare.hq.redelivery.count")).thenReturn(redeliveryCount);
        alertMotherAction.invoke(milestoneEvent);


        ArgumentCaptor<CaseTask> argumentCaptor = ArgumentCaptor.forClass(CaseTask.class);
        verify(commcareCaseGateway).submitCase(eq(commCareUrl), argumentCaptor.capture(), anyString(), anyString(), anyInt());
        CaseTask task = argumentCaptor.getValue();

        assertEquals(null, task.getDateExpires());
    }

    @Test
    public void shouldHandleWhenEligibleDateIsBeforeTodayBeforeSendingToGateway() {
        String scheduleName = "Measles Vaccination";
        String childCaseId = "0A8MF30IJWI0FJW3JFW0J0W3A8";
        String motherCaseId = "motherCaseId";
        String milestoneName = "Measles";
        String groupId = "groupId";
        String flwId = "FLW1234";
        String motherName = "Sita";
        DateTime now = DateUtil.now();
        DateTime edd = now.plusMonths(8);
        DateTime startOfSchedule = edd.minusMonths(9);

        Milestone milestone = new Milestone(milestoneName, months(0), months(9), null, null);
        MilestoneAlert milestoneAlert = MilestoneAlert.fromMilestone(milestone, startOfSchedule);
        MilestoneEvent milestoneEvent = new MilestoneEvent(childCaseId, scheduleName, milestoneAlert, "due", startOfSchedule, null);

        Mother client = new Mother(motherCaseId, null, flwId, motherName, groupId, edd, null, null, null, false, null, null, null, null, null, true);
        when(allMothers.findByCaseId(childCaseId)).thenReturn(client);
        String redeliveryCount = "5";
        when(ananyaCareProperties.getProperty("commcare.hq.redelivery.count")).thenReturn(redeliveryCount);
        alertMotherAction.invoke(milestoneEvent);

        ArgumentCaptor<CaseTask> argumentCaptor = ArgumentCaptor.forClass(CaseTask.class);
        verify(commcareCaseGateway).submitCase(anyString(), argumentCaptor.capture(), anyString(), anyString(), anyInt());
        CaseTask task = argumentCaptor.getValue();

        assertEquals(now.toString("yyyy-MM-dd"), task.getDateEligible());
    }

    @Test
    public void shouldNotSendAlertIfDueDateStartFallsAfterEDD() {
        String scheduleName = "TT Vaccination";
        String motherCaseId = "0A8MF30IJWI0FJW3JFW0J0W3A8";
        String caseName = "TT 1";
        String groupId = "groupId";
        String flwId = "FLW1234";
        String motherName = "Sita";
        DateTime now = DateTime.now();
        DateTime edd = now.plusMonths(1);
        DateTime startScheduleDate = edd.plusMonths(1);

        Milestone milestone = new Milestone(caseName, null, months(9), null, null);
        MilestoneAlert milestoneAlert = MilestoneAlert.fromMilestone(milestone, startScheduleDate);
        MilestoneEvent milestoneEvent = new MilestoneEvent(motherCaseId, scheduleName, milestoneAlert, "due", DateUtil.now(), null);

        Mother client = new Mother(motherCaseId, null, flwId, motherName, groupId, edd, null, null, null, false, null, null, null, null, null, true);
        when(allMothers.findByCaseId(motherCaseId)).thenReturn(client);
        alertMotherAction.invoke(milestoneEvent);

        verify(commcareCaseGateway, never()).submitCase(anyString(), any(CaseTask.class), anyString(), anyString(), anyInt());
    }

    @Test
    public void shouldNotRaiseAnAlertIfExpiresDateForAlertIsBeforeToday(){
        String scheduleName = "TT Vaccination";
        String motherCaseId = "0A8MF30IJWI0FJW3JFW0J0W3A8";
        String caseName = "TT 1";
        String groupId = "groupId";
        String flwId = "FLW1234";
        String motherName = "Sita";
        DateTime now = DateTime.now();
        DateTime edd = now.minusMonths(1);
        DateTime startScheduleDate = edd.minusMonths(9);

        Milestone milestone = new Milestone(caseName, null, months(9), null, null);
        MilestoneAlert milestoneAlert = MilestoneAlert.fromMilestone(milestone, startScheduleDate);
        MilestoneEvent milestoneEvent = new MilestoneEvent(motherCaseId, scheduleName, milestoneAlert, "due", DateUtil.now(), null);

        Mother client = new Mother(motherCaseId, null, flwId, motherName, groupId, edd, null, null, null, false, null, null, null, null, null, true);
        when(allMothers.findByCaseId(motherCaseId)).thenReturn(client);
        alertMotherAction.invoke(milestoneEvent);

        verify(commcareCaseGateway, never()).submitCase(anyString(), any(CaseTask.class), anyString(), anyString(), anyInt());
    }

    @Test
    public void shouldNotCaseTaskObjectToGatewayIfMotherIsInactive() {
        String scheduleName = "TT Vaccination";
        String motherCaseId = "0A8MF30IJWI0FJW3JFW0J0W3A8";
        String milestoneName = "TT 1";
        String groupId = "groupId";
        String flwId = "FLW1234";
        String motherName = "Sita";
        DateTime startOfSchedule = DateUtil.now();

        Milestone milestone = new Milestone(milestoneName, weeks(0), weeks(36), null, null);
        MilestoneAlert milestoneAlert = MilestoneAlert.fromMilestone(milestone, startOfSchedule);
        MilestoneEvent milestoneEvent = new MilestoneEvent(motherCaseId, scheduleName, milestoneAlert, "due", startOfSchedule, null);

        Mother client = new Mother(motherCaseId, null, flwId, motherName, groupId, DateTime.now().plusYears(1), null, null, null, false, null, null, null, null, null, true);
        client.setClosedByCommcare(true);
        when(allMothers.findByCaseId(motherCaseId)).thenReturn(client);
        alertMotherAction.invoke(milestoneEvent);

        verify(commcareCaseGateway, never()).submitCase(anyString(), any(CaseTask.class), anyString(), anyString(), anyInt());

    }

    public static Period months(int numberOfMonths) {
        return new Period(0, numberOfMonths, 0, 0, 0, 0, 0, 0);
    }

    public static Period weeks(int numberOfWeeks) {
        return new Period(0, 0, numberOfWeeks, 0, 0, 0, 0, 0);
    }


}
