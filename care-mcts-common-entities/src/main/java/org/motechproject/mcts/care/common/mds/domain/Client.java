package org.motechproject.mcts.care.common.mds.domain;

import org.joda.time.DateTime;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity (name = "Client")
public class Client implements java.io.Serializable {

    private static final long serialVersionUID = -5140470554942711265L;
    
    protected String caseId;
    protected DateTime dateModified;
    protected String flwId;
    protected String name;
    protected String groupId;
    protected String caseType;
    private DateTime docCreateTime;
    private Boolean closedByCommcare;
    private Boolean expired;
    protected Boolean isAlive;
    
    public Client() {
       
    }
    public Client(Boolean isAlive) {
        this.isAlive = isAlive;
        closedByCommcare = false;
    }
    
    public boolean isActive() {
        return isAlive && !closedByCommcare;
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
    public String getFlwId() {
        return flwId;
    }

    public void setFlwId(String flwId) {
        this.flwId = flwId;
    }

    @Field
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Field
    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    @Field
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Field
    public DateTime getDocCreateTime() {
        return docCreateTime;
    }

    public void setDocCreateTime(DateTime docCreateTime) {
        this.docCreateTime = docCreateTime;
    }

    @Field
    public Boolean getClosedByCommcare() {
        return closedByCommcare;
    }

    public void setClosedByCommcare(Boolean closedByCommcare) {
        this.closedByCommcare = closedByCommcare;
    }

    @Field
    public Boolean getExpired() {
        return expired;
    }

    public void setExpired(Boolean expired) {
        this.expired = expired;
    }

    @Field
    public Boolean getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(Boolean isAlive) {
        this.isAlive = isAlive;
    }
}