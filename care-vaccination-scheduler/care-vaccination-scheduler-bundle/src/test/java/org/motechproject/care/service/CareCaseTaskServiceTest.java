package org.motechproject.care.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Map;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.motechproject.care.service.util.CommcareTask;
import org.motechproject.casexml.domain.CaseTask;
import org.motechproject.casexml.gateway.CommcareCaseGateway;
import org.motechproject.commons.date.util.DateUtil;
import org.motechproject.mcts.care.common.mds.domain.CareCaseTask;
import org.motechproject.mcts.care.common.mds.repository.Repository;

@RunWith(MockitoJUnitRunner.class)
public class CareCaseTaskServiceTest {

    private CareCaseTaskService careCaseTaskService;
    
    private CareCaseTask careCaseTask = new CareCaseTask();
    
    @Mock
    CommcareCaseGateway commcareCaseGateway;

    @Mock
    Properties ananyaCareProperties;
    
    @Mock
    Repository dbRepository;
    
    @Before
    public void setUp(){
    	MockitoAnnotations.initMocks(this);
        careCaseTaskService=new CareCaseTaskService(commcareCaseGateway,ananyaCareProperties);
        careCaseTaskService.setDbRepository(dbRepository);
    }

    @SuppressWarnings("unchecked")
	@Test
    public void shouldNotCloseACaseIfNoCareTaskExistsForIt(){
        careCaseTaskService.close("clientCaseId", "milestoneName");
        when(dbRepository.get(any(Class.class), (Map)anyObject(), (Map)anyObject())).thenReturn(careCaseTask);
        verify(commcareCaseGateway, never()).closeCase(anyString(), any(CaseTask.class), anyString(), anyString(),(Integer) anyObject());
    }

    @Test
    public void shouldSendCloseUpdatesIfCareTaskExistsForItAndItIsOpen(){
        String clientCaseId = "clientCaseId";
        String milestoneName = "milestoneName";
        CareCaseTask careCaseTask = mock(CareCaseTask.class);
        when(careCaseTask.getIsOpen()).thenReturn(true);
        String url = "someurl";
        when(ananyaCareProperties.getProperty("commcare.hq.url")).thenReturn(url);
        when(dbRepository.get(any(Class.class), any(Map.class), any(Map.class))).thenReturn(careCaseTask);

        careCaseTaskService.close(clientCaseId, milestoneName);
        verify(commcareCaseGateway).closeCase(Matchers.<String>any(), Matchers.<CaseTask>any(), anyString(), anyString(),(Integer) anyObject());
    }

    @Test
    public void shouldNotSendCloseUpdatesIfCareTaskExistsForItAndItIsAlreadyClosed(){
        String clientCaseId = "clientCaseId";
        String milestoneName = "milestoneName";
        CareCaseTask careCaseTask = mock(CareCaseTask.class);
        when(careCaseTask.getIsOpen()).thenReturn(false);

        when(dbRepository.get(any(Class.class), any(Map.class), any(Map.class))).thenReturn(careCaseTask);

        careCaseTaskService.close(clientCaseId, milestoneName);
        verify(dbRepository,never()).update(Matchers.<CareCaseTask>any());
      //TODO added null as 5th argument in below method(check what it should be)
        verify(commcareCaseGateway, never()).closeCase(Matchers.<String>any(), Matchers.<CaseTask>any(), anyString(), anyString(),(Integer) anyObject());
    }

    @Test
    public void shouldUpdateTheCaseTaskStatusToClose() {
        String clientCaseId = "clientCaseId";
        String milestoneName = "milestoneName";
        CareCaseTask careCaseTask = new CareCaseTask();
        careCaseTask.setIsOpen(true);
        String currentTime = DateUtil.now().toString();
        careCaseTask.setCurrentTime(currentTime);
        when(dbRepository.get(any(Class.class), any(Map.class), any(Map.class))).thenReturn(careCaseTask);

        careCaseTaskService.close(clientCaseId, milestoneName);
        ArgumentCaptor<CareCaseTask> captor = ArgumentCaptor.forClass(CareCaseTask.class);
        verify(dbRepository).update(captor.capture());

        CareCaseTask value = captor.getValue();
        assertFalse(value.getIsOpen());
        assertNotSame(currentTime,careCaseTask.getCurrentTime());
    }
}
