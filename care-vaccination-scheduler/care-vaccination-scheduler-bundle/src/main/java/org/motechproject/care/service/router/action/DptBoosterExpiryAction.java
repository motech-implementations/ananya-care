package org.motechproject.care.service.router.action;

import org.motechproject.care.service.schedule.DptBoosterService;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.motechproject.scheduletracking.events.MilestoneEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DptBoosterExpiryAction implements Action {

    private DptBoosterService dptBoosterService;
    @Autowired
    MdsRepository dbRepository;

    @Autowired
    public DptBoosterExpiryAction(DptBoosterService dptBoosterService) {
        this.dptBoosterService = dptBoosterService;
    }

    @Override
    public void invoke(MilestoneEvent event) {
        String externalId = event.getExternalId();
        ChildCase child = dbRepository.get(ChildCase.class, "caseId",
                externalId);
        dptBoosterService.close(child);
    }
}
