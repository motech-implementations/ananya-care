package org.motechproject.care.service.router.action;

import org.motechproject.care.service.schedule.MeaslesBoosterService;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.motechproject.scheduletracking.events.MilestoneEvent;
import org.springframework.beans.factory.annotation.Autowired;

public class MeaslesBoosterExpiryAction implements Action {

	 private MeaslesBoosterService measlesBoosterService;
	    @Autowired
	    MdsRepository dbRepository;

	    @Autowired
	    public MeaslesBoosterExpiryAction(MeaslesBoosterService measlesBoosterService) {
	        this.measlesBoosterService = measlesBoosterService;
	    }

	    @Override
	    public void invoke(MilestoneEvent event) {
	        String externalId = event.getExternalId();
	        ChildCase child = dbRepository.get(ChildCase.class, "caseId",
	                externalId);
	        measlesBoosterService.close(child);
	    }
}
