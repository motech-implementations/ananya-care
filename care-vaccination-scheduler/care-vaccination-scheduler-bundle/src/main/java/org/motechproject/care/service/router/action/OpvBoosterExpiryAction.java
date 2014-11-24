package org.motechproject.care.service.router.action;

import org.motechproject.care.service.schedule.OpvBoosterService;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.motechproject.scheduletracking.events.MilestoneEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OpvBoosterExpiryAction implements Action {

    private OpvBoosterService opvBoosterService;
    @Autowired
    MdsRepository dbRepository;

    @Autowired
    public OpvBoosterExpiryAction(OpvBoosterService opvBoosterService) {
        this.opvBoosterService = opvBoosterService;
    }

    @Override
    public void invoke(MilestoneEvent event) {
        String externalId = event.getExternalId();
        ChildCase child = dbRepository.get(ChildCase.class, "caseId",
                externalId);
        opvBoosterService.close(child);
    }
}