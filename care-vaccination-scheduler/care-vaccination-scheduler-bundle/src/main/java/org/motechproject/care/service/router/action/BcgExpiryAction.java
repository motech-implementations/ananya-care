package org.motechproject.care.service.router.action;

import org.motechproject.care.service.schedule.BcgService;
import org.motechproject.mcts.care.common.mds.domain.Child;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.motechproject.scheduletracking.events.MilestoneEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BcgExpiryAction implements Action {

    private BcgService bcgService;
    @Autowired
    MdsRepository dbRepository;
    @Autowired
    public BcgExpiryAction(BcgService bcgService) {
        this.bcgService = bcgService;
    }

    @Override
    public void invoke(MilestoneEvent event) {
        String externalId = event.getExternalId();
        Child child = dbRepository.get(Child.class, "caseId", externalId);
        bcgService.close(child);
    }
}
