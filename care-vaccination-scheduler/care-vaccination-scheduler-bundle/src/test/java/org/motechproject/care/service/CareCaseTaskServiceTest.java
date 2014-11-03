package org.motechproject.care.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.motechproject.care.service.util.CommcareTask;
import org.motechproject.casexml.domain.CaseTask;
import org.motechproject.casexml.gateway.CommcareCaseGateway;
import org.motechproject.commons.date.util.DateUtil;
import org.motechproject.mcts.care.common.mds.domain.CareCaseTask;
import org.motechproject.mcts.care.common.mds.repository.Repository;

import java.util.Map;
import java.util.Properties;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;

@RunWith(MockitoJUnitRunner.class)
public class CareCaseTaskServiceTest {

    private CareCaseTaskService careCaseTaskService;
    
    @Mock
    CommcareCaseGateway commcareCaseGateway;

    @Mock
    Properties ananyaCareProperties;
    
    @Mock
    Repository dbRepository;
    @Before
    public void setUp(){
        careCaseTaskService=new CareCaseTaskService(commcareCaseGateway,ananyaCareProperties);
    }

    @Test
    public void shouldNotCloseACaseIfNoCareTaskExistsForIt(){
        careCaseTaskService.close("clientCaseId", "milestoneName");
      //TODO added null as 5th argument in below method(check what it should be)
        verify(commcareCaseGateway, never()).closeCase(anyString(), any(CaseTask.class), anyString(), anyString(),null);
    }

    @Test
    public void shouldSendCloseUpdatesIfCareTaskExistsForItAndItIsOpen(){
        String clientCaseId = "clientCaseId";
        String milestoneName = "milestoneName";
        CareCaseTask careCaseTask = mock(CareCaseTask.class);
        when(careCaseTask.getIsOpen()).thenReturn(true);

        CaseTask caseTask = new CaseTask();
        String url = "someurl";

        when(ananyaCareProperties.getProperty("commcare.hq.url")).thenReturn(url);
        when(CommcareTask.toCaseTask(careCaseTask)).thenReturn(caseTask);
        when(dbRepository.get(CareCaseTask.class, any(Map.class), null)).thenReturn(careCaseTask);

        careCaseTaskService.close(clientCaseId, milestoneName);
      //TODO added null as 5th argument in below method(check what it should be)
        verify(commcareCaseGateway).closeCase(url, caseTask, null, null,null);
    }

    @Test
    public void shouldNotSendCloseUpdatesIfCareTaskExistsForItAndItIsAlreadyClosed(){
        String clientCaseId = "clientCaseId";
        String milestoneName = "milestoneName";
        CareCaseTask careCaseTask = mock(CareCaseTask.class);
        when(careCaseTask.getIsOpen()).thenReturn(false);

        when(dbRepository.get(CareCaseTask.class, any(Map.class), null)).thenReturn(careCaseTask);

        careCaseTaskService.close(clientCaseId, milestoneName);
        verify(dbRepository,never()).update(Matchers.<CareCaseTask>any());
      //TODO added null as 5th argument in below method(check what it should be)
        verify(commcareCaseGateway, never()).closeCase(Matchers.<String>any(), Matchers.<CaseTask>any(), anyString(), anyString(),null);
    }

    @Test
    public void shouldUpdateTheCaseTaskStatusToClose() {
        String clientCaseId = "clientCaseId";
        String milestoneName = "milestoneName";
        CareCaseTask careCaseTask = new CareCaseTask();
        careCaseTask.setIsOpen(true);
        String currentTime = DateUtil.now().toString();
        careCaseTask.setCurrentTime(currentTime);
        when(dbRepository.get(CareCaseTask.class, any(Map.class), null)).thenReturn(careCaseTask);

        careCaseTaskService.close(clientCaseId, milestoneName);
        ArgumentCaptor<CareCaseTask> captor = ArgumentCaptor.forClass(CareCaseTask.class);
        verify(dbRepository).update(captor.capture());

        CareCaseTask value = captor.getValue();
        assertFalse(value.getIsOpen());
        assertNotSame(currentTime,careCaseTask.getCurrentTime());
    }
}
