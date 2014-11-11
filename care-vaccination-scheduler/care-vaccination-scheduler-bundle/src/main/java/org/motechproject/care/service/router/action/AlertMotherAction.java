package org.motechproject.care.service.router.action;

import org.joda.time.DateTime;
import org.motechproject.casexml.gateway.CommcareCaseGateway;
import org.motechproject.mcts.care.common.mds.domain.Mother;
import org.motechproject.mcts.care.common.mds.domain.Window;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class AlertMotherAction extends AlertClientAction implements Action{

    @Autowired
    MdsRepository dbRepository;
    @Autowired
    public AlertMotherAction(CommcareCaseGateway commcareCaseGateway, @Qualifier("ananyaCareProperties") Properties ananyaCareProperties) {
        super(commcareCaseGateway,ananyaCareProperties);
    }

    @Override
    public void process(Window alertWindow, String externalId, String milestoneName) {
        Mother mother = dbRepository.get(Mother.class, "caseId", externalId);
        if (!mother.isActive()) {
            return;
        }
        alertWindow = alertWindow.resize(new Window(DateTime.now(), mother.getEdd()));
        if(!alertWindow.isValid()) {
            return;
        }
        postToCommCare(alertWindow, externalId, milestoneName, mother);
    }
}
