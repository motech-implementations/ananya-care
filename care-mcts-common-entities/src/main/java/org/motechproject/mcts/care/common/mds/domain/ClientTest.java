package org.motechproject.mcts.care.common.mds.domain;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.joda.time.DateTime;
import org.motechproject.commons.date.util.DateUtil;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(name = "ClientTest")
public class ClientTest {

    @Field
    protected String caseId;
    @Field
    protected DateTime dateModified;
    @Field
    protected String flwId;
    @Field
    protected String name;
    @Field
    protected String groupId;
    @Field
    private DateTime docCreateTime;
    
    private boolean closedByCommcare;
    @Field
    private boolean expired;
    @Field
    protected boolean isAlive;

    public ClientTest() {
    }

    public ClientTest(boolean isAlive) {
        this.isAlive = isAlive;
    }

    @JsonIgnore
    public boolean isActive() {
        return isAlive && !closedByCommcare;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public DateTime getDateModified() {
        return dateModified;
    }


    public void setDateModified(DateTime dateModified) {
        this.dateModified = dateModified;
    }

    public String getFlwId() {
        return flwId;
    }

    public void setFlwId(String flwId) {
        this.flwId = flwId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public DateTime getDocCreateTime() {
        return DateUtil.setTimeZone(docCreateTime);
    }

    public void setDocCreateTime(DateTime docCreateTime) {
        this.docCreateTime = docCreateTime;
    }

    @Field
    public boolean getClosedByCommcare() {
        return closedByCommcare;
    }

    public void setClosedByCommcare(boolean closedByCommcare) {
        this.closedByCommcare = closedByCommcare;
    }

    public boolean getExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public boolean getAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}