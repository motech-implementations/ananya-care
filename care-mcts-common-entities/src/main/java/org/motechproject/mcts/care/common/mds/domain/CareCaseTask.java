package org.motechproject.mcts.care.common.mds.domain;

import org.motechproject.mcts.care.common.lookup.CaseType;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(name = "CareCaseTask")
public class CareCaseTask implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private String caseType = CaseType.Task.getType();

    private String milestoneName;

    private String ownerId;

    private Mother mother;
    
    private Child child;
    
    //TODO: remove this field and use Mother and Child Objects
    //private String caseId;

    private String motechUserId;

    private String currentTime;

    private String taskId;

    private String dateEligible;

    private String dateExpires;

    private String clientCaseType;

    private String clientCaseId;

    private Boolean isOpen = true;

    @Field
    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    @Field
    public String getMilestoneName() {
        return milestoneName;
    }

    public void setMilestoneName(String milestoneName) {
        this.milestoneName = milestoneName;
    }

    @Field
    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    /*@Field
    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }*/

    @Field
    public String getMotechUserId() {
        return motechUserId;
    }

    public void setMotechUserId(String motechUserId) {
        this.motechUserId = motechUserId;
    }

    @Field
    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    @Field
    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    @Field
    public String getDateEligible() {
        return dateEligible;
    }

    public void setDateEligible(String dateEligible) {
        this.dateEligible = dateEligible;
    }

    @Field
    public String getDateExpires() {
        return dateExpires;
    }

    public void setDateExpires(String dateExpires) {
        this.dateExpires = dateExpires;
    }

    @Field
    public String getClientCaseType() {
        return clientCaseType;
    }

    public void setClientCaseType(String clientCaseType) {
        this.clientCaseType = clientCaseType;
    }

    @Field
    public String getClientCaseId() {
        return clientCaseId;
    }

    public void setClientCaseId(String clientCaseId) {
        this.clientCaseId = clientCaseId;
    }

    @Field
    public Boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

    public CareCaseTask() {
    }

    public CareCaseTask(String milestoneName, String ownerId, String caseId,
            String motechUserId, String currentTime, String taskId,
            String dateEligible, String dateExpires, String clientCaseType,
            String clientCaseId) {
        this.milestoneName = milestoneName;
        this.ownerId = ownerId;
        //this.caseId = caseId;
        this.motechUserId = motechUserId;
        this.currentTime = currentTime;
        this.taskId = taskId;
        this.dateEligible = dateEligible;
        this.dateExpires = dateExpires;
        this.clientCaseType = clientCaseType;
        this.clientCaseId = clientCaseId;
    }

    // TODO: implement this in care-V in util class
    /*
     * public CaseTask toCaseTask() { CaseTask caseTask = new CaseTask();
     * caseTask.setCaseType(caseType); caseTask.setCaseName(milestoneName);
     * caseTask.setOwnerId(ownerId); caseTask.setCaseId(caseId);
     * caseTask.setMotechUserId(motechUserId);
     * caseTask.setCurrentTime(currentTime); caseTask.setTaskId(taskId);
     * caseTask.setDateEligible(dateEligible);
     * caseTask.setDateExpires(dateExpires);
     * caseTask.setClientCaseType(clientCaseType);
     * caseTask.setClientCaseId(clientCaseId); return caseTask; }
     */
}
