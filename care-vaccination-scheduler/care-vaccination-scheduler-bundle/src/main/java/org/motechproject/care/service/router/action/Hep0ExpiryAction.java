package org.motechproject.care.service.router.action;

import org.motechproject.care.service.schedule.Hep0Service;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.motechproject.scheduletracking.events.MilestoneEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Hep0ExpiryAction implements Action {

    private Hep0Service hep0Service;
    @Autowired
    MdsRepository dbRepository;

    @Autowired
    public Hep0ExpiryAction(Hep0Service hep0Service) {
        this.hep0Service = hep0Service;
    }

    @Override
    public void invoke(MilestoneEvent event) {
        String externalId = event.getExternalId();
        ChildCase child = dbRepository.get(ChildCase.class, "caseId",
                externalId);
        hep0Service.close(child);
    }
}
