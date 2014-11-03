package org.motechproject.care.service.util;

import org.motechproject.casexml.domain.CaseTask;
import org.motechproject.mcts.care.common.mds.domain.CareCaseTask;

public class CommcareTask {

    public static CaseTask toCaseTask(CareCaseTask careCaseTask) {
        CaseTask caseTask = new CaseTask();
        caseTask.setCaseType(careCaseTask.getCaseType());
        caseTask.setCaseName(careCaseTask.getMilestoneName());
        caseTask.setOwnerId(careCaseTask.getOwnerId());
        caseTask.setCaseId(careCaseTask.getCaseId());
        caseTask.setMotechUserId(careCaseTask.getMotechUserId());
        caseTask.setCurrentTime(careCaseTask.getCurrentTime());
        caseTask.setTaskId(careCaseTask.getTaskId());
        caseTask.setDateEligible(careCaseTask.getDateEligible());
        caseTask.setDateExpires(careCaseTask.getDateExpires());
        caseTask.setClientCaseType(careCaseTask.getClientCaseType());
        caseTask.setClientCaseId(careCaseTask.getClientCaseId());
        return caseTask;
    }
}
