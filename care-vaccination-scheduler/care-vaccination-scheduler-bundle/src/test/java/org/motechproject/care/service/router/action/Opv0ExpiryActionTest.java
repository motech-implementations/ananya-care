package org.motechproject.care.service.router.action;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.motechproject.care.service.schedule.Opv0Service;
import org.motechproject.mcts.care.common.mds.domain.Child;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.motechproject.scheduletracking.domain.WindowName;
import org.motechproject.scheduletracking.events.MilestoneEvent;

public class Opv0ExpiryActionTest {
    @Mock
    MdsRepository dbRepository;
    @Mock
    Opv0Service opv0Service;
    @InjectMocks
    Opv0ExpiryAction opv0ExpiryAction = new Opv0ExpiryAction(opv0Service);;

    @Before
    public void setUp(){
        initMocks(this);
        opv0ExpiryAction.setDbRepository(dbRepository);
    }

    @Test
    public void shouldUnEnrollChildFromOpv0ExpiredSchedule() {
        String caseId = "caseID";
        Child child = new Child();
        child.setCaseId(caseId);
        MilestoneEvent milestoneEvent = new MilestoneEvent(caseId, null, null, WindowName.late.name(), null, null);
        when(dbRepository.get(Child.class, "caseId", caseId)).thenReturn(child);
        opv0ExpiryAction.invoke(milestoneEvent);
        verify(opv0Service).close(child);
    }
}
