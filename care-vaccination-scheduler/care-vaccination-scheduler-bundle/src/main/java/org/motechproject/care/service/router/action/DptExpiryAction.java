package org.motechproject.care.service.router.action;

import org.motechproject.care.service.schedule.DptService;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.motechproject.scheduletracking.events.MilestoneEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DptExpiryAction implements Action {

    private DptService dptService;
    @Autowired
    MdsRepository dbRepository;

    @Autowired
    public DptExpiryAction(DptService dptService) {
        this.dptService = dptService;
    }

    @Override
    public void invoke(MilestoneEvent event) {
        String externalId = event.getExternalId();
        ChildCase child = dbRepository.get(ChildCase.class, "caseId",
                externalId);
        dptService.close(child);
    }

}
