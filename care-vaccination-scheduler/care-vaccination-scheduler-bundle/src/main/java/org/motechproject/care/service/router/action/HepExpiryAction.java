package org.motechproject.care.service.router.action;

import org.motechproject.care.service.schedule.HepService;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.motechproject.scheduletracking.events.MilestoneEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HepExpiryAction implements Action {
    private HepService hepService;
    @Autowired
    MdsRepository dbRepository;

    @Autowired
    public HepExpiryAction(HepService hepService) {
        this.hepService = hepService;
    }

    @Override
    public void invoke(MilestoneEvent event) {
        String externalId = event.getExternalId();
        ChildCase child = dbRepository.get(ChildCase.class, "caseId",
                externalId);
        hepService.close(child);
    }

}
