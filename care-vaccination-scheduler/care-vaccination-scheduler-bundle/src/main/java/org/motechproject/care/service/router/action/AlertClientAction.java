package org.motechproject.care.service.router.action;

import org.apache.log4j.Logger;
import org.motechproject.care.request.CaseType;
import org.motechproject.care.schedule.service.MilestoneType;
import org.motechproject.care.service.util.CommcareTask;
import org.motechproject.casexml.domain.CaseTask;
import org.motechproject.casexml.gateway.CommcareCaseGateway;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
import org.motechproject.mcts.care.common.mds.domain.CareCaseTask;
import org.motechproject.mcts.care.common.mds.domain.Client;
import org.motechproject.mcts.care.common.mds.domain.Window;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.motechproject.scheduletracking.domain.MilestoneAlert;
import org.motechproject.scheduletracking.events.MilestoneEvent;
import org.motechproject.commons.date.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.UUID;

public abstract class AlertClientAction {
    private CommcareCaseGateway commcareCaseGateway;
    private Properties ananyaCareProperties;
    Logger logger = Logger.getLogger(AlertClientAction.class);

    public AlertClientAction(CommcareCaseGateway commcareCaseGateway,
            Properties ananyaCareProperties) {
        this.commcareCaseGateway = commcareCaseGateway;
        this.ananyaCareProperties = ananyaCareProperties;
    }

    @Autowired
    MdsRepository dbRepository;

    public void invoke(MilestoneEvent event) {
        String externalId = event.getExternalId();
        MilestoneAlert milestoneAlert = event.getMilestoneAlert();
        String milestoneName = milestoneAlert.getMilestoneName();

        process(new Window(milestoneAlert.getDueDateTime(),
                milestoneAlert.getLateDateTime()), externalId, milestoneName);
    }

    public abstract void process(Window alertWindow, String externalId,
            String milestoneName);

    protected void postToCommCare(Window alertWindow, String externalId,
            String milestoneName, Client client) {
        String commcareUrl = ananyaCareProperties
                .getProperty("commcare.hq.url");
        String commcareUsername = ananyaCareProperties
                .getProperty("commcare.hq.username");
        String commcarePassword = ananyaCareProperties
                .getProperty("commcare.hq.password");

        CareCaseTask careCaseTask = createCaseTask(alertWindow, externalId,
                milestoneName, client);
       
        logger.info(String
                .format("Notifying commcare -- TaskId: %s, ExternalId: %s, EligibleDate: %s, ExpiryDate: %s ",
                        careCaseTask.getTaskId(),
                        careCaseTask.getMotherCase() == null ? careCaseTask
                                .getChildCase().getCaseId() : careCaseTask
                                .getMotherCase().getCaseId(), careCaseTask
                                .getDateEligible(), careCaseTask
                                .getDateExpires()));
        commcareCaseGateway.submitCase(commcareUrl,
                CommcareTask.toCaseTask(careCaseTask), commcareUsername,
                commcarePassword, null);
        dbRepository.save(careCaseTask);
    }

    private CareCaseTask createCaseTask(Window alertWindow, String externalId,
            String milestoneName, Client client) {
        String motechUserId = ananyaCareProperties
                .getProperty("motech.user.id");
        String currentTime = DateUtil.now().toString();
        String taskId = MilestoneType.forType(milestoneName).getTaskId();
        String caseId = UUID.randomUUID().toString();
        String dateExpires = (alertWindow.getEnd() == null) ? null
                : alertWindow.getEnd().toString("yyyy-MM-dd");
        String flwId;
        MotherCase motherCase = null;
        ChildCase childCase = null;
        if (client.getCaseType().equals(CaseType.Mother.getType())) {
            flwId = ((MotherCase) client).getFlw().getFlwId();
            motherCase = (MotherCase) client;
        } else {
            flwId = ((ChildCase) client).getFlw().getFlwId();
            childCase = (ChildCase) client;
        }
        return new CareCaseTask(milestoneName, flwId, caseId, motechUserId,
                currentTime, taskId, alertWindow.getStart().toString(
                        "yyyy-MM-dd"), dateExpires, client.getCaseType(),
                motherCase, childCase);
    }
}
