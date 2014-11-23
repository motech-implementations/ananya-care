package org.motechproject.care.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.motechproject.care.request.CareCase;
import org.motechproject.care.request.CaseType;
import org.motechproject.care.service.util.CommcareTask;
import org.motechproject.casexml.gateway.CommcareCaseGateway;
import org.motechproject.commons.date.util.DateUtil;
import org.motechproject.mcts.care.common.mds.domain.CareCaseTask;
import org.motechproject.mcts.care.common.mds.domain.Client;
import org.motechproject.mcts.care.common.mds.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CareCaseTaskService {

    //private AllCareCaseTasks allCareCaseTasks;
    @Autowired
	private Repository dbRepository;
    private CommcareCaseGateway commcareCaseGateway;
    private Properties ananyaCareProperties;

    Logger logger = Logger.getLogger(CareCaseTaskService.class);

    @Autowired
    public CareCaseTaskService(CommcareCaseGateway commcareCaseGateway, Properties ananyaCareProperties) {
        this.commcareCaseGateway = commcareCaseGateway;
        this.ananyaCareProperties = ananyaCareProperties;
    }

    public void close(Client client, String milestoneName) {
        logger.info(String.format("Closing case for Client Case Id: %s; Milestone Name: %s", client.getCaseId(), milestoneName));
        Map careFieldMap = new HashMap<String, Object>();
        if (client.getCaseType().equals(CaseType.Mother.getType())) {
            careFieldMap.put("motherCase.caseId", client.getCaseId());
        } else {
            careFieldMap.put("childCase.caseId", client.getCaseId());
        }
        
        careFieldMap.put("milestoneName", milestoneName);
        CareCaseTask careCaseTask = dbRepository.get(CareCaseTask.class, careFieldMap, null);
        if(careCaseTask == null|| !careCaseTask.getIsOpen()) {
            logger.info(String.format("Valid care case not found for Client Case Id: %s; Milestone Name: %s", client.getCaseId(), milestoneName));
            return;
        }
        logger.info(String.format("Sending close case to Commcare for Client Case Id: %s; Milestone Name: %s", client.getCaseId(), milestoneName));
        careCaseTask.setIsOpen(false);
        careCaseTask.setCurrentTime(DateUtil.now().toString());
        dbRepository.update(careCaseTask);
        String commcareUrl = ananyaCareProperties.getProperty("commcare.hq.url");
        String commcareUsername = ananyaCareProperties.getProperty("commcare.hq.username");
        String commcarePassword = ananyaCareProperties.getProperty("commcare.hq.password");
        //TODO added null as 5th argument in below method(check what it should be)
        commcareCaseGateway.closeCase(commcareUrl,CommcareTask.toCaseTask(careCaseTask), commcareUsername, commcarePassword, null);
    }

    public void closeAll(String clientCaseId, String milestoneName) {
        logger.info(String.format("Closing all cases for Client Case Id: %s; Milestone Name: %s", clientCaseId, milestoneName));
        Map careFieldMap = new HashMap<String, String>();
        careFieldMap.put("clientCaseId", clientCaseId);
        careFieldMap.put("milestoneName", milestoneName);
        List<CareCaseTask> careCaseTasks = (List<CareCaseTask>) dbRepository.get(CareCaseTask.class, careFieldMap, null);
        String commcareUrl = ananyaCareProperties.getProperty("commcare.hq.url");
        String commcareUsername = ananyaCareProperties.getProperty("commcare.hq.username");
        String commcarePassword = ananyaCareProperties.getProperty("commcare.hq.password");
        for(CareCaseTask task : careCaseTasks) {
            if (task != null && task.getIsOpen()) {
                logger.info(String.format("Sending close case to Commcare for Task Id: %s; Milestone Name: %s", task.getTaskId(), milestoneName));
                task.setIsOpen(false);
                task.setCurrentTime(DateUtil.now().toString());
                dbRepository.update(task);
              //TODO added null as 5th argument in below method(check what it should be)
                commcareCaseGateway.closeCase(commcareUrl, CommcareTask.toCaseTask(task), commcareUsername, commcarePassword, null);
            }
        }
    }
}
