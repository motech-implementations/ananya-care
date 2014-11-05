package org.motechproject.mcts.care.common.mds.dimension;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.mcts.care.common.domain.SelfUpdatable;
import org.motechproject.mcts.care.common.domain.annotations.ExternalPrimaryKey;
import org.motechproject.mcts.care.common.utils.SelfUpdatableUtil;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(name = "flw_group")
public class FlwGroup implements java.io.Serializable, SelfUpdatable<FlwGroup> {

    private static final long serialVersionUID = 1325270026216609695L;

    @ExternalPrimaryKey
    @Field
    @Unique
    private String groupId;
    @Field
    private Boolean caseSharing;
    @Field
    private String domain;
    @Field
    private String awcCode;
    @Field
    private String name;
    @Field
    private Boolean reporting;
    @Field
    private DateTime creationTime;
    @Field
    private DateTime lastModifiedTime;

    /*
     * //TODO: @ManyToMany(mappedBy="flwGroups")
     * 
     * @Persistent(mappedBy="flwGroups") private Set<Flw> flws;
     */

    public FlwGroup() {
        DateTime date = new DateTime();
        creationTime = date;
        lastModifiedTime = date;
        // flws = new HashSet<>(0);
    }

    public FlwGroup(String groupId, Boolean caseSharing, String domain,
            String awcCode, String name, Boolean reporting,
            DateTime creationTime, DateTime lastModifiedTime, Set<Flw> flws) {
        this.groupId = groupId;
        this.caseSharing = caseSharing;
        this.domain = domain;
        this.awcCode = awcCode;
        this.name = name;
        this.reporting = reporting;
        this.creationTime = creationTime;
        this.lastModifiedTime = lastModifiedTime;
        // this.flws = flws;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Boolean getCaseSharing() {
        return this.caseSharing;
    }

    public void setCaseSharing(Boolean caseSharing) {
        this.caseSharing = caseSharing;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getAwcCode() {
        return this.awcCode;
    }

    public void setAwcCode(String awcCode) {
        this.awcCode = awcCode;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getReporting() {
        return this.reporting;
    }

    public void setReporting(Boolean reporting) {
        this.reporting = reporting;
    }

    public DateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(DateTime creationTime) {
        this.creationTime = creationTime;
    }

    public DateTime getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(DateTime lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    /*
     * public Set<Flw> getFlws() { return flws; }
     * 
     * public void setFlws(Set<Flw> flws) { this.flws = flws; }
     */

    @Override
    public void updateToLatest(FlwGroup other) {
        validateIfUpdatable(this.groupId, other.groupId);

        updateFields(other, Arrays.asList("id", "groupId", "creationTime",
                "flws"));
    }

    public Boolean validateIfUpdatable(String thisId, String otherId) {
        return SelfUpdatableUtil.validateIfUpdatable(thisId, otherId, this
                .getClass());
    }

    public void updateFields(FlwGroup source, List<String> ignoredFields) {
        SelfUpdatableUtil.updateFields(source, ignoredFields, this.getClass(),
                this);
    }

}
