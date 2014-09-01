package org.motechproject.mcts.care.common.mds.dimension;

import java.util.Arrays;
import java.util.List;

import org.joda.time.DateTime;
import org.motechproject.mcts.care.common.domain.SelfUpdatable;
import org.motechproject.mcts.care.common.domain.annotations.ExternalPrimaryKey;
import org.motechproject.mcts.care.common.utils.SelfUpdatableUtil;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(name = "child_case")
public class ChildCase implements java.io.Serializable,
        SelfUpdatable<ChildCase> {

    private static final long serialVersionUID = -7655944396275293118L;

    @Field
    @Cascade(persist = true, update = true, delete = true)
    private Flw flw;
    // TODO @ManyToOne(fetch = FetchType.EAGER)
    @Field
    @Cascade(persist = true, update = true, delete = true)
    private MotherCase motherCase;

    @Field
    @Cascade(persist = true, update = true, delete = true)
    private FlwGroup flwGroup;
    @ExternalPrimaryKey
    @Field
    private String caseId;
    @Field
    private String caseName;
    @Field
    private DateTime DateTimeModified;
    @Field
    private DateTime serverDateTimeModified;
    @Field
    private String caseType;
    @Field
    private String babyMeasles;
    @Field
    private DateTime bcgDateTime;
    @Field
    private String birthStatus;
    @Field
    private DateTime dob;
    @Field
    private DateTime dpt1DateTime;
    @Field
    private DateTime dpt2DateTime;
    @Field
    private DateTime dpt3DateTime;
    @Field
    private String gender;
    @Field
    private DateTime hepB0DateTime;
    @Field
    private DateTime hepB1DateTime;
    @Field
    private DateTime hepB2DateTime;
    @Field
    private DateTime hepB3DateTime;
    @Field
    private DateTime measlesDateTime;
    @Field
    private DateTime opv0DateTime;
    @Field
    private DateTime opv1DateTime;
    @Field
    private DateTime opv2DateTime;
    @Field
    private DateTime opv3DateTime;
    @Field
    private DateTime vitA1DateTime;
    @Field
    private String childAlive;
    @Field
    private DateTime dptBoosterDateTime;
    @Field
    private DateTime opvBoosterDateTime;
    @Field
    private DateTime DateTimeJe;
    @Field
    private DateTime DateTimeMeaslesBooster;
    @Field
    private String babyWeight;
    @Field
    private String name;
    @Field
    private String term;
    @Field
    private String timeOfBirth;
    @Field
    private DateTime vitA2DateTime;
    @Field
    private DateTime vitA3DateTime;
    @Field
    private String cordFallen;
    @Field
    private Boolean closed;
    @Field
    private DateTime closedOn;
    @Field
    @Cascade(persist = true, update = true, delete = true)
    private Flw closedBy;
    @Field
    private DateTime creationTime;
    @Field
    private DateTime lastModifiedTime;

    public ChildCase() {
        DateTime DateTime = new DateTime();
        creationTime = DateTime;
        lastModifiedTime = DateTime;
    }

    public Flw getFlw() {
        return this.flw;
    }

    public void setFlw(Flw flw) {
        this.flw = flw;
    }

    public MotherCase getMotherCase() {
        return this.motherCase;
    }

    public void setMotherCase(MotherCase motherCase) {
        this.motherCase = motherCase;
    }

    public FlwGroup getFlwGroup() {
        return this.flwGroup;
    }

    public void setFlwGroup(FlwGroup flwGroup) {
        this.flwGroup = flwGroup;
    }

    public String getCaseId() {
        return this.caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getCaseName() {
        return this.caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public DateTime getDateTimeModified() {
        return this.DateTimeModified;
    }

    public void setDateTimeModified(DateTime DateTimeModified) {
        this.DateTimeModified = DateTimeModified;
    }

    public DateTime getServerDateTimeModified() {
        return this.serverDateTimeModified;
    }

    public void setServerDateTimeModified(DateTime serverDateTimeModified) {
        this.serverDateTimeModified = serverDateTimeModified;
    }

    public String getCaseType() {
        return this.caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getBabyMeasles() {
        return this.babyMeasles;
    }

    public void setBabyMeasles(String babyMeasles) {
        this.babyMeasles = babyMeasles;
    }

    public DateTime getBcgDateTime() {
        return this.bcgDateTime;
    }

    public void setBcgDateTime(DateTime bcgDateTime) {
        this.bcgDateTime = bcgDateTime;
    }

    public String getBirthStatus() {
        return this.birthStatus;
    }

    public void setBirthStatus(String birthStatus) {
        this.birthStatus = birthStatus;
    }

    public DateTime getDob() {
        return this.dob;
    }

    public void setDob(DateTime dob) {
        this.dob = dob;
    }

    public DateTime getDpt1DateTime() {
        return this.dpt1DateTime;
    }

    public void setDpt1DateTime(DateTime dpt1DateTime) {
        this.dpt1DateTime = dpt1DateTime;
    }

    public DateTime getDpt2DateTime() {
        return this.dpt2DateTime;
    }

    public void setDpt2DateTime(DateTime dpt2DateTime) {
        this.dpt2DateTime = dpt2DateTime;
    }

    public DateTime getDpt3DateTime() {
        return this.dpt3DateTime;
    }

    public void setDpt3DateTime(DateTime dpt3DateTime) {
        this.dpt3DateTime = dpt3DateTime;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public DateTime getHepB0DateTime() {
        return this.hepB0DateTime;
    }

    public void setHepB0DateTime(DateTime hepB0DateTime) {
        this.hepB0DateTime = hepB0DateTime;
    }

    public DateTime getHepB1DateTime() {
        return this.hepB1DateTime;
    }

    public void setHepB1DateTime(DateTime hepB1DateTime) {
        this.hepB1DateTime = hepB1DateTime;
    }

    public DateTime getHepB2DateTime() {
        return this.hepB2DateTime;
    }

    public void setHepB2DateTime(DateTime hepB2DateTime) {
        this.hepB2DateTime = hepB2DateTime;
    }

    public DateTime getHepB3DateTime() {
        return this.hepB3DateTime;
    }

    public void setHepB3DateTime(DateTime hepB3DateTime) {
        this.hepB3DateTime = hepB3DateTime;
    }

    public DateTime getMeaslesDateTime() {
        return this.measlesDateTime;
    }

    public void setMeaslesDateTime(DateTime measlesDateTime) {
        this.measlesDateTime = measlesDateTime;
    }

    public DateTime getOpv0DateTime() {
        return this.opv0DateTime;
    }

    public void setOpv0DateTime(DateTime opv0DateTime) {
        this.opv0DateTime = opv0DateTime;
    }

    public DateTime getOpv1DateTime() {
        return this.opv1DateTime;
    }

    public void setOpv1DateTime(DateTime opv1DateTime) {
        this.opv1DateTime = opv1DateTime;
    }

    public DateTime getOpv2DateTime() {
        return this.opv2DateTime;
    }

    public void setOpv2DateTime(DateTime opv2DateTime) {
        this.opv2DateTime = opv2DateTime;
    }

    public DateTime getOpv3DateTime() {
        return this.opv3DateTime;
    }

    public void setOpv3DateTime(DateTime opv3DateTime) {
        this.opv3DateTime = opv3DateTime;
    }

    public DateTime getVitA1DateTime() {
        return this.vitA1DateTime;
    }

    public void setVitA1DateTime(DateTime vitA1DateTime) {
        this.vitA1DateTime = vitA1DateTime;
    }

    public String getChildAlive() {
        return this.childAlive;
    }

    public void setChildAlive(String childAlive) {
        this.childAlive = childAlive;
    }

    public DateTime getDptBoosterDateTime() {
        return this.dptBoosterDateTime;
    }

    public void setDptBoosterDateTime(DateTime dptBoosterDateTime) {
        this.dptBoosterDateTime = dptBoosterDateTime;
    }

    public DateTime getOpvBoosterDateTime() {
        return this.opvBoosterDateTime;
    }

    public void setOpvBoosterDateTime(DateTime opvBoosterDateTime) {
        this.opvBoosterDateTime = opvBoosterDateTime;
    }

    public DateTime getDateTimeJe() {
        return this.DateTimeJe;
    }

    public void setDateTimeJe(DateTime DateTimeJe) {
        this.DateTimeJe = DateTimeJe;
    }

    public DateTime getDateTimeMeaslesBooster() {
        return this.DateTimeMeaslesBooster;
    }

    public void setDateTimeMeaslesBooster(DateTime DateTimeMeaslesBooster) {
        this.DateTimeMeaslesBooster = DateTimeMeaslesBooster;
    }

    public String getBabyWeight() {
        return babyWeight;
    }

    public void setBabyWeight(String babyWeight) {
        this.babyWeight = babyWeight;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTerm() {
        return this.term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTimeOfBirth() {
        return this.timeOfBirth;
    }

    public void setTimeOfBirth(String timeOfBirth) {
        this.timeOfBirth = timeOfBirth;
    }

    public DateTime getVitA2DateTime() {
        return this.vitA2DateTime;
    }

    public void setVitA2DateTime(DateTime vitA2DateTime) {
        this.vitA2DateTime = vitA2DateTime;
    }

    public DateTime getVitA3DateTime() {
        return this.vitA3DateTime;
    }

    public void setVitA3DateTime(DateTime vitA3DateTime) {
        this.vitA3DateTime = vitA3DateTime;
    }

    public String getCordFallen() {
        return cordFallen;
    }

    public void setCordFallen(String cordFallen) {
        this.cordFallen = cordFallen;
    }

    public Boolean getClosed() {
        return this.closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public DateTime getClosedOn() {
        return this.closedOn;
    }

    public void setClosedOn(DateTime closedOn) {
        this.closedOn = closedOn;
    }

    public Flw getClosedBy() {
        return closedBy;
    }

    public void setClosedBy(Flw closedBy) {
        this.closedBy = closedBy;
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

    @Override
    public void updateToLatest(ChildCase updated) {
        validateIfUpdatable(this.caseId, updated.caseId);

        if (!isLatest(updated)) {
            // TODO add logger below
            // logger.warn(String.format("Ignoring mother case update with case id: %s since current DateTime modified is %s and given DateTime modified is %s",
            // this.caseId, this.DateTimeModified, updated.DateTimeModified));
            return;
        }

        List<String> fieldsToIgnore = Arrays.asList("id", "caseId",
                "creationTime", "closedOn", "closedBy", "closed");
        updateFields(updated, fieldsToIgnore);
    }

    public Boolean validateIfUpdatable(String thisId, String otherId) {
       return SelfUpdatableUtil.validateIfUpdatable(thisId, otherId, this.getClass());
    }

    public void updateFields(ChildCase source, List<String> ignoredFields) {
       SelfUpdatableUtil.updateFields(source, ignoredFields, this.getClass(), this);
    }

    private boolean isLatest(ChildCase updatedObject) {
        if (this.serverDateTimeModified == null)
            return true;
        else if (updatedObject.serverDateTimeModified == null)
            return false;
        return this.serverDateTimeModified
                .compareTo(updatedObject.serverDateTimeModified) <= 0;
    }
}
