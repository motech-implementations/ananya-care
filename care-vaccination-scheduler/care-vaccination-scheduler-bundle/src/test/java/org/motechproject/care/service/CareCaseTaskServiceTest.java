package org.motechproject.care.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.motechproject.care.domain.CareCaseTask;
import org.motechproject.care.repository.AllCareCaseTasks;
import org.motechproject.casexml.domain.CaseTask;
import org.motechproject.casexml.gateway.CommcareCaseGateway;
import org.motechproject.commons.date.util.DateUtil;

import java.util.Properties;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CareCaseTaskServiceTest {

    private CareCaseTaskService careCaseTaskService;
    @Mock
    AllCareCaseTasks allCareCaseTasks;
    @Mock
    CommcareCaseGateway commcareCaseGateway;

    @Mock
    Properties ananyaCareProperties;

    @Before
    public void setUp(){
        careCaseTaskService=new CareCaseTaskService(allCareCaseTasks,commcareCaseGateway,ananyaCareProperties);
    }

    @Test
    public void shouldNotCloseACaseIfNoCareTaskExistsForIt(){
        careCaseTaskService.close("clientCaseId", "milestoneName");
        verify(commcareCaseGateway, never()).closeCase(anyString(), any(CaseTask.class), anyString(), anyString(), anyInt());
    }

    @Test
    public void shouldSendCloseUpdatesIfCareTaskExistsForItAndItIsOpen(){
        String clientCaseId = "clientCaseId";
        String milestoneName = "milestoneName";
        CareCaseTask careCaseTask = mock(CareCaseTask.class);
        when(careCaseTask.getOpen()).thenReturn(true);

        CaseTask caseTask = new CaseTask();
        String url = "someurl";

        when(ananyaCareProperties.getProperty("commcare.hq.url")).thenReturn(url);
        when(careCaseTask.toCaseTask()).thenReturn(caseTask);
        when(allCareCaseTasks.findByClientCaseIdAndMilestoneName(clientCaseId, milestoneName)).thenReturn(careCaseTask);
        String redeliveryCount = "5";
        when(ananyaCareProperties.getProperty("commcare.hq.redelivery.count")).thenReturn(redeliveryCount);

        careCaseTaskService.close(clientCaseId, milestoneName);

        verify(commcareCaseGateway).closeCase(url, caseTask, null, null,
                Integer.parseInt(ananyaCareProperties.getProperty("commcare.hq.redelivery.count")));
    }

    @Test
    public void shouldNotSendCloseUpdatesIfCareTaskExistsForItAndItIsAlreadyClosed(){
        String clientCaseId = "clientCaseId";
        String milestoneName = "milestoneName";
        CareCaseTask careCaseTask = mock(CareCaseTask.class);
        when(careCaseTask.getOpen()).thenReturn(false);

        when(allCareCaseTasks.findByClientCaseIdAndMilestoneName(clientCaseId, milestoneName)).thenReturn(careCaseTask);

        careCaseTaskService.close(clientCaseId, milestoneName);
        verify(allCareCaseTasks, never()).update(Matchers.<CareCaseTask>any());
        verify(commcareCaseGateway, never()).closeCase(Matchers.<String>any(), Matchers.<CaseTask>any(), anyString(), anyString(), anyInt());
    }

    @Test
    public void shouldUpdateTheCaseTaskStatusToClose() {
        String clientCaseId = "clientCaseId";
        String milestoneName = "milestoneName";
        CareCaseTask careCaseTask = new CareCaseTask();
        careCaseTask.setOpen(true);
        String currentTime = DateUtil.now().toString();
        careCaseTask.setCurrentTime(currentTime);
        when(allCareCaseTasks.findByClientCaseIdAndMilestoneName(clientCaseId, milestoneName)).thenReturn(careCaseTask);
        String redeliveryCount = "5";
        when(ananyaCareProperties.getProperty("commcare.hq.redelivery.count")).thenReturn(redeliveryCount);

        careCaseTaskService.close(clientCaseId, milestoneName);
        ArgumentCaptor<CareCaseTask> captor = ArgumentCaptor.forClass(CareCaseTask.class);
        verify(allCareCaseTasks).update(captor.capture());

        CareCaseTask value = captor.getValue();
        assertFalse(value.getOpen());
        assertNotSame(currentTime, careCaseTask.getCurrentTime());
    }

    @Test
    public void shouldNotUpdateTheCaseTaskStatusToCloseIfDeliveryFails() {
        String clientCaseId = "clientCaseId";
        String milestoneName = "milestoneName";
        CareCaseTask careCaseTask = new CareCaseTask();
        careCaseTask.setOpen(true);
        String currentTime = DateUtil.now().toString();
        careCaseTask.setCurrentTime(currentTime);
        when(allCareCaseTasks.findByClientCaseIdAndMilestoneName(clientCaseId, milestoneName)).thenReturn(careCaseTask);
        String redeliveryCount = "5";
        when(ananyaCareProperties.getProperty("commcare.hq.redelivery.count")).thenReturn(redeliveryCount);
        doThrow(new RuntimeException("Connection refused")).when(commcareCaseGateway).closeCase(anyString(), any(CaseTask.class), anyString(), anyString(), anyInt());

        careCaseTaskService.close(clientCaseId, milestoneName);
        ArgumentCaptor<CareCaseTask> captor = ArgumentCaptor.forClass(CareCaseTask.class);

        verify(allCareCaseTasks, never()).update(captor.capture());
    }
}
