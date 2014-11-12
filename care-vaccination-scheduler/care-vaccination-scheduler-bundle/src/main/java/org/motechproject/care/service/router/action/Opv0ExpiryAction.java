package org.motechproject.care.service.router.action;

import org.motechproject.care.service.schedule.Opv0Service;
import org.motechproject.mcts.care.common.mds.domain.Child;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.motechproject.scheduletracking.events.MilestoneEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Opv0ExpiryAction implements Action {


    private Opv0Service opv0Service;
    @Autowired
    MdsRepository dbRepository;
    
    public void setDbRepository(MdsRepository dbRepository) {
		this.dbRepository = dbRepository;
	}

	@Autowired
    public Opv0ExpiryAction(Opv0Service opv0Service) {
        this.opv0Service = opv0Service;
    }

    @Override
    public void invoke(MilestoneEvent event) {
        String externalId = event.getExternalId();
        Child child = dbRepository.get(Child.class, "caseId", externalId);
        opv0Service.close(child);
    }
}
