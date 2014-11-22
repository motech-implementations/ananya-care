package org.motechproject.care.service.router.action;

import org.motechproject.care.service.schedule.Opv0Service;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.motechproject.scheduletracking.events.MilestoneEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Opv0ExpiryAction implements Action {

    private Opv0Service opv0Service;
    @Autowired
    MdsRepository dbRepository;

    @Autowired
    public Opv0ExpiryAction(Opv0Service opv0Service) {
        this.opv0Service = opv0Service;
    }

    @Override
    public void invoke(MilestoneEvent event) {
        String externalId = event.getExternalId();
        ChildCase child = dbRepository.get(ChildCase.class, "caseId",
                externalId);
        opv0Service.close(child);
    }
}
