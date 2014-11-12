package org.motechproject.care.service.router.action;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.motechproject.care.service.schedule.BcgService;
import org.motechproject.mcts.care.common.mds.domain.Child;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.motechproject.scheduletracking.domain.WindowName;
import org.motechproject.scheduletracking.events.MilestoneEvent;

public class BcgExpiryActionTest {
    @Mock
    MdsRepository dbRepository;
    @Mock
    BcgService bcgService;
    @InjectMocks
    BcgExpiryAction bcgExpiryAction = new BcgExpiryAction(bcgService);;

    @Before
    public void setUp(){
        initMocks(this);
        bcgExpiryAction.setDbRepository(dbRepository);
    }

    @Test
    public void shouldUnEnrollChildFromBcgExpiredSchedule() {
        String caseId = "caseID";
        Child child = new Child();
        child.setCaseId(caseId);
        MilestoneEvent milestoneEvent = new MilestoneEvent(caseId, null, null, WindowName.late.name(), null, null);
        when(dbRepository.get(Child.class, "caseId", caseId)).thenReturn(child);
        bcgExpiryAction.invoke(milestoneEvent);
        verify(bcgService).close(child);
    }

}
