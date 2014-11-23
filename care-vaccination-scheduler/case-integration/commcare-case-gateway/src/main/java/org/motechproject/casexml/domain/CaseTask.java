package org.motechproject.casexml.domain;

public class CaseTask {

    private String caseType;
    private String caseName;
    private String ownerId;
    private String caseId;
    private String motechUserId;
    private String currentTime;
    private String taskId;
    private String dateEligible;
    private String dateExpires;
    private String clientCaseId;
    private String clientCaseType;

    public String getClientCaseId() {
        return clientCaseId;
    }


    public void setClientCaseId(String clientCaseId) {
        this.clientCaseId = clientCaseId;
    }

    public String getClientCaseType() {
        return clientCaseType;
    }

    public void setClientCaseType(String clientCaseType) {
        this.clientCaseType = clientCaseType;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getMotechUserId() {
        return motechUserId;
    }

    public void setMotechUserId(String motechUserId) {
        this.motechUserId = motechUserId;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getDateEligible() {
        return dateEligible;
    }

    public void setDateEligible(String dateEligible) {
        this.dateEligible = dateEligible;
    }

    public String getDateExpires() {
        return dateExpires;
    }

    public void setDateExpires(String dateExpires) {
        this.dateExpires = dateExpires;
    }

}
