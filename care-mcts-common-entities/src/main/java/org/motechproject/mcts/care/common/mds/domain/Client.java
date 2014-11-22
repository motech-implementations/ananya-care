package org.motechproject.mcts.care.common.mds.domain;

import org.joda.time.DateTime;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity (name = "Client")
public class Client implements java.io.Serializable {

    private static final long serialVersionUID = -5140470554942711265L;

    protected String caseId;
    protected DateTime dateModified;
    protected String caseName;
    /* protected String groupId; */
    protected String caseType;
    protected DateTime creationTime;
    protected boolean closed;
    protected boolean expired;
    protected String isAlive;
    
    /*protected Flw flw;

    
    protected FlwGroup flwGroup;*/

    public Client() {

    }

    public Client(String isAlive) {
        this.isAlive = isAlive;
        closed = false;
    }

    public boolean isActive() {
        return isAlive.equals("yes") && !closed && !expired;
    }

    @Field
    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    @Field
    public DateTime getDateModified() {
        return dateModified;
    }

    public void setDateModified(DateTime dateModified) {
        this.dateModified = dateModified;
    }


    @Field
    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    @Field
    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }
    
    @Field
    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }


    /*
     * @Field public String getGroupId() { return groupId; }
     * 
     * public void setGroupId(String groupId) { this.groupId = groupId; }
     */
    /*
     * @Field public DateTime getDocCreateTime() { return docCreateTime; }
     * 
     * public void setDocCreateTime(DateTime docCreateTime) { this.docCreateTime
     * = docCreateTime; }
     */
    @Field
    public DateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(DateTime creationTime) {
        this.creationTime = creationTime;
    }

    @Field
    public Boolean getClosedByCommcare() {
        return closed;
    }

    public void setClosedByCommcare(Boolean closed) {
        this.closed = closed;
    }

    @Field
    public Boolean getExpired() {
        return expired;
    }

    public void setExpired(Boolean expired) {
        this.expired = expired;
    }

    @Field
    public String getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(String isAlive) {
        this.isAlive = isAlive;
    }

    /*@Field
    @Cascade(persist = true, update = true, delete = true)
    public FlwGroup getFlwGroup() {
        return this.flwGroup;
    }

    public void setFlwGroup(FlwGroup flwGroup) {
        this.flwGroup = flwGroup;
    }*/
}
