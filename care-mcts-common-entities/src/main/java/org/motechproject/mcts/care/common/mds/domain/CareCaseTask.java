package org.motechproject.mcts.care.common.mds.domain;

import org.motechproject.mcts.care.common.lookup.CaseType;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(name = "CareCaseTask")
public class CareCaseTask implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private String caseType;

    private String milestoneName;

    private String ownerId;

    // TODO: add getter and setter for mother and child fields
    @Field
    @Cascade(persist = true, update = true, delete = true)
    private MotherCase motherCase;

   
    @Field
    @Cascade(persist = true, update = true, delete = true)
    private ChildCase childCase;

    @Field
    /*
     * @Cascade(persist = true, update = true, delete = true) private ChildCase
     * child;
     */
    // TODO: remove this field and use Mother and Child Objects
    // private String clientCaseId;
    private String motechUserId;

    private String currentTime;

    private String taskId;

    private String dateEligible;

    private String dateExpires;

    private String clientCaseType;

    private String caseId;

    private Boolean isOpen = true;

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

    /*
     * @Field public String getCaseId() { return caseId; }
     * 
     * public void setCaseId(String caseId) { this.caseId = caseId; }
     */

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
    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public void setCaseType(String caseType) {
        this.caseType = CaseType.TASK;
    }

    @Field
    public String getCaseType() {
        return caseType;
    }

    /*
     * @Field public String getClientCaseId() { return clientCaseId; }
     */

    /*
     * public void setClientCaseId(String clientCaseId) { this.clientCaseId =
     * clientCaseId; }
     */
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
            MotherCase motherCase,ChildCase childCase) {
        this.milestoneName = milestoneName;
        this.ownerId = ownerId;
        this.caseId = caseId;
        this.motechUserId = motechUserId;
        this.currentTime = currentTime;
        this.taskId = taskId;
        this.dateEligible = dateEligible;
        this.dateExpires = dateExpires;
        this.clientCaseType = clientCaseType;
        this.motherCase = motherCase;
        this.childCase = childCase;
    }

    public MotherCase getMotherCase() {
        return motherCase;
    }

    public void setMotherCase(MotherCase motherCase) {
        this.motherCase = motherCase;
    }

    public ChildCase getChildCase() {
        return childCase;
    }

    public void setChildCase(ChildCase childCase) {
        this.childCase = childCase;
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