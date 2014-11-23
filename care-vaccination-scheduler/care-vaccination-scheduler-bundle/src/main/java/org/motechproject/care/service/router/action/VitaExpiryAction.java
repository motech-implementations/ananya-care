package org.motechproject.care.service.router.action;

import org.motechproject.care.service.schedule.VitaService;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.motechproject.scheduletracking.events.MilestoneEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VitaExpiryAction implements Action {

    private VitaService vitaService;
    @Autowired
    MdsRepository dbRepository;

    @Autowired
    public VitaExpiryAction(VitaService vitaService) {
        this.vitaService = vitaService;
    }

    @Override
    public void invoke(MilestoneEvent event) {
        String externalId = event.getExternalId();
        ChildCase child = dbRepository.get(ChildCase.class, "caseId",
                externalId);
        vitaService.close(child);
    }
}
