package org.motechproject.care.service.router.action;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.motechproject.care.service.schedule.Opv0Service;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.repository.Repository;
import org.motechproject.scheduletracking.domain.WindowName;
import org.motechproject.scheduletracking.events.MilestoneEvent;

public class Opv0ExpiryActionTest {
    @Mock
    Repository dbRepository;
    @Mock
    Opv0Service opv0Service;
    Opv0ExpiryAction opv0ExpiryAction;

    @Before
    public void setUp(){
        initMocks(this);
        opv0ExpiryAction = new Opv0ExpiryAction(opv0Service);
    }

    @Test
    public void shouldUnEnrollChildFromOpv0ExpiredSchedule() {
        String caseId = "caseID";
        ChildCase child = new ChildCase();
        child.setCaseId(caseId);
        MilestoneEvent milestoneEvent = new MilestoneEvent(caseId, null, null, WindowName.late.name(), null, null);
        when(dbRepository.get(ChildCase.class, "caseId", caseId)).thenReturn(child);
        opv0ExpiryAction.invoke(milestoneEvent);
        verify(opv0Service).close(child);
    }
}
