package org.motechproject.care.service.router.action;

import org.motechproject.care.service.schedule.OpvService;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.motechproject.scheduletracking.events.MilestoneEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OpvExpiryAction implements Action {

    private OpvService opvService;
    @Autowired
    MdsRepository dbRepository;

    @Autowired
    public OpvExpiryAction(OpvService opvService) {
        this.opvService = opvService;
    }

    @Override
    public void invoke(MilestoneEvent event) {
        String externalId = event.getExternalId();
        ChildCase child = dbRepository.get(ChildCase.class, "caseId",
                externalId);
        opvService.close(child);
    }
}
