package org.motechproject.care.service.router.action;

import org.apache.log4j.Logger;
import org.motechproject.care.schedule.service.MilestoneType;
import org.motechproject.care.service.util.CommcareTask;
import org.motechproject.casexml.gateway.CommcareCaseGateway;
import org.motechproject.mcts.care.common.mds.domain.CareCaseTask;
import org.motechproject.mcts.care.common.mds.domain.Client;
import org.motechproject.mcts.care.common.mds.domain.Window;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.motechproject.scheduletracking.domain.MilestoneAlert;
import org.motechproject.scheduletracking.events.MilestoneEvent;
import org.motechproject.commons.date.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Properties;
import java.util.UUID;

public abstract class AlertClientAction {
    private CommcareCaseGateway commcareCaseGateway;
    private Properties ananyaCareProperties;
    @Autowired MdsRepository dbRepository;
    Logger logger = Logger.getLogger(AlertClientAction.class);

    public AlertClientAction(CommcareCaseGateway commcareCaseGateway, Properties ananyaCareProperties) {
        this.commcareCaseGateway = commcareCaseGateway;
        this.ananyaCareProperties = ananyaCareProperties;
    }
    
   
    
    public void invoke(MilestoneEvent event){
        String externalId = event.getExternalId();
        MilestoneAlert milestoneAlert = event.getMilestoneAlert();
        String milestoneName = milestoneAlert.getMilestoneName();

        process(new Window(milestoneAlert.getDueDateTime(), milestoneAlert.getLateDateTime()), externalId, milestoneName);
    }

    public abstract void process(Window alertWindow, String externalId, String milestoneName);

    protected void postToCommCare(Window alertWindow, String externalId, String milestoneName, Client client) {
        String commcareUrl = ananyaCareProperties.getProperty("commcare.hq.url");
        String commcareUsername = ananyaCareProperties.getProperty("commcare.hq.username");
        String commcarePassword = ananyaCareProperties.getProperty("commcare.hq.password");
        CareCaseTask careCaseTask = createCaseTask(alertWindow, externalId, milestoneName, client);
        dbRepository.save(careCaseTask);
        logger.info(String.format("Notifying commcare -- TaskId: %s, ExternalId: %s, EligibleDate: %s, ExpiryDate: %s ",
                careCaseTask.getTaskId(), careCaseTask.getClientCaseId(), careCaseTask.getDateEligible(), careCaseTask.getDateExpires()));
        
      //TODO added null as 5th argument in below method(check what it should be)
        commcareCaseGateway.submitCase(commcareUrl, CommcareTask.toCaseTask(careCaseTask), commcareUsername, commcarePassword, null);
    }

    private CareCaseTask createCaseTask(Window alertWindow, String externalId, String milestoneName, Client client) {
        String motechUserId = ananyaCareProperties.getProperty("motech.user.id");
        String currentTime = DateUtil.now().toString();
        String taskId = MilestoneType.forType(milestoneName).getTaskId();
        String caseId = UUID.randomUUID().toString();
        String dateExpires = (alertWindow.getEnd() == null) ? null : alertWindow.getEnd().toString("yyyy-MM-dd");
        return new CareCaseTask(milestoneName, client.getGroupId(), caseId, motechUserId, currentTime, taskId, alertWindow.getStart().toString("yyyy-MM-dd"), dateExpires, client.getCaseType(), externalId);
    }
}
