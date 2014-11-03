package org.motechproject.care.service.router.action;

import org.joda.time.DateTime;
import org.motechproject.casexml.gateway.CommcareCaseGateway;
import org.motechproject.mcts.care.common.mds.domain.Child;
import org.motechproject.mcts.care.common.mds.domain.Window;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class AlertChildAction extends AlertClientAction implements Action{
    
    @Autowired
    MdsRepository dbRepository;
    @Autowired
    public AlertChildAction(CommcareCaseGateway commcareCaseGateway, Properties ananyaCareProperties) {
        super(commcareCaseGateway,ananyaCareProperties);
    }
    
    @Override
    public void process(Window alertWindow, String externalId, String milestoneName) {
        Child child = dbRepository.get(Child.class,"caseId", externalId);
        if(!child.isActive()) {
            return;
        }
        alertWindow = alertWindow.resize(new Window(DateTime.now(), dateOf2ndYear(child)));
        if(!alertWindow.isValid()) {
            return;
        }
        postToCommCare(alertWindow, externalId, milestoneName, child);
    }

    private DateTime dateOf2ndYear(Child child) {
        return child.getDOB().plusYears(2);
    }
}
