package org.motechproject.care.service.router.action;

import org.motechproject.care.service.ChildService;
import org.motechproject.care.service.MotherService;
import org.motechproject.care.service.VaccinationProcessor;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
import org.motechproject.mcts.care.common.mds.domain.Client;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.motechproject.scheduletracking.events.MilestoneEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ClientExpiryAction implements Action {

	private MotherService motherService;
	private ChildService childService;
	private VaccinationProcessor vaccinationProcessor;

	@Autowired
	MdsRepository dbRepository;

	@Autowired
	public ClientExpiryAction(MotherService motherService,
			ChildService childService, @Qualifier("childVaccinationProcessor") VaccinationProcessor vaccinationProcessor) {
		this.motherService = motherService;
		this.childService = childService;
		this.vaccinationProcessor = vaccinationProcessor;
	}

	@Override
	public void invoke(MilestoneEvent event) {
		String externalId = event.getExternalId();
		Client client = null;
		client = (ChildCase) dbRepository.get(ChildCase.class, "caseId",
				externalId);
//		if (client == null) {
//			client = dbRepository.get(MotherCase.class, "caseId", externalId);
//		}
		if (client != null) {
			vaccinationProcessor.closeSchedules(client);
		}

		// TODO if mother els if child ??

		// boolean didExpireMother = motherService.expireCase(externalId);
		/*
		 * if (!didExpireMother) childService.expireCase(externalId);
		 */
	}
}
