package org.motechproject.care.service.router.action;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.motechproject.care.service.schedule.BcgService;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
import org.motechproject.mcts.care.common.mds.repository.Repository;
import org.motechproject.scheduletracking.domain.WindowName;
import org.motechproject.scheduletracking.events.MilestoneEvent;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class BcgExpiryActionTest {
    @Mock
    Repository dbRepository;
    @Mock
    BcgService bcgService;
    BcgExpiryAction bcgExpiryAction;

    @Before
    public void setUp(){
        initMocks(this);
        bcgExpiryAction = new BcgExpiryAction(bcgService);
    }

    @Test
    public void shouldUnEnrollChildFromBcgExpiredSchedule() {
        String caseId = "caseID";
        ChildCase child = new ChildCase();
        child.setCaseId(caseId);
        MilestoneEvent milestoneEvent = new MilestoneEvent(caseId, null, null, WindowName.late.name(), null, null);
        when(dbRepository.get(ChildCase.class, "caseId", caseId)).thenReturn(child);
        bcgExpiryAction.invoke(milestoneEvent);
        verify(bcgService).close(child);
    }

}
