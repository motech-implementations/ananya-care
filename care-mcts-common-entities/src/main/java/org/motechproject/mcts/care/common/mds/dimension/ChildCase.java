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
    private DateTime dateModified;
    @Field
    private DateTime serverDateTimeModified;
    @Field
    private String caseType;
    @Field
    private String babyMeasles;
    @Field
    private DateTime bcgDate;
    @Field
    private String birthStatus;
    @Field
    private DateTime dob;
    @Field
    private DateTime dpt1Date;
    @Field
    private DateTime dpt2Date;
    @Field
    private DateTime dpt3Date;
    @Field
    private String gender;
    @Field
    private DateTime hepB0Date;
    @Field
    private DateTime hepB1Date;
    @Field
    private DateTime hepB2Date;
    @Field
    private DateTime hepB3Date;
    @Field
    private DateTime measlesDate;
    @Field
    private DateTime opv0Date;
    @Field
    private DateTime opv1Date;
    @Field
    private DateTime opv2Date;
    @Field
    private DateTime opv3Date;
    @Field
    private DateTime vitA1Date;
    @Field
    private String childAlive;
    @Field
    private DateTime dptBoosterDate;
    @Field
    private DateTime opvBoosterDate;
    @Field
    private DateTime dateJe;
    @Field
    private DateTime dateMeaslesBooster;
    @Field
    private String babyWeight;
    @Field
    private String name;
    @Field
    private String term;
    @Field
    private String timeOfBirth;
    @Field
    private DateTime vitA2Date;
    @Field
    private DateTime vitA3Date;
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
        DateTime date = new DateTime();
        creationTime = date;
        lastModifiedTime = date;
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

    public DateTime getDateModified() {
        return this.dateModified;
    }

    public void setDateModified(DateTime dateModified) {
        this.dateModified = dateModified;
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
        return this.bcgDate;
    }

    public void setBcgDateTime(DateTime bcgDate) {
        this.bcgDate = bcgDate;
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
        return this.dpt1Date;
    }

    public void setDpt1DateTime(DateTime dpt1Date) {
        this.dpt1Date = dpt1Date;
    }

    public DateTime getDpt2DateTime() {
        return this.dpt2Date;
    }

    public void setDpt2DateTime(DateTime dpt2Date) {
        this.dpt2Date = dpt2Date;
    }

    public DateTime getDpt3DateTime() {
        return this.dpt3Date;
    }

    public void setDpt3DateTime(DateTime dpt3Date) {
        this.dpt3Date = dpt3Date;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public DateTime getHepB0DateTime() {
        return this.hepB0Date;
    }

    public void setHepB0DateTime(DateTime hepB0Date) {
        this.hepB0Date = hepB0Date;
    }

    public DateTime getHepB1DateTime() {
        return this.hepB1Date;
    }

    public void setHepB1DateTime(DateTime hepB1Date) {
        this.hepB1Date = hepB1Date;
    }

    public DateTime getHepB2DateTime() {
        return this.hepB2Date;
    }

    public void setHepB2DateTime(DateTime hepB2Date) {
        this.hepB2Date = hepB2Date;
    }

    public DateTime getHepB3DateTime() {
        return this.hepB3Date;
    }

    public void setHepB3DateTime(DateTime hepB3Date) {
        this.hepB3Date = hepB3Date;
    }

    public DateTime getMeaslesDateTime() {
        return this.measlesDate;
    }

    public void setMeaslesDateTime(DateTime measlesDate) {
        this.measlesDate = measlesDate;
    }

    public DateTime getOpv0DateTime() {
        return this.opv0Date;
    }

    public void setOpv0DateTime(DateTime opv0Date) {
        this.opv0Date = opv0Date;
    }

    public DateTime getOpv1DateTime() {
        return this.opv1Date;
    }

    public void setOpv1DateTime(DateTime opv1Date) {
        this.opv1Date = opv1Date;
    }

    public DateTime getOpv2DateTime() {
        return this.opv2Date;
    }

    public void setOpv2DateTime(DateTime opv2Date) {
        this.opv2Date = opv2Date;
    }

    public DateTime getOpv3DateTime() {
        return this.opv3Date;
    }

    public void setOpv3DateTime(DateTime opv3Date) {
        this.opv3Date = opv3Date;
    }

    public DateTime getVitA1DateTime() {
        return this.vitA1Date;
    }

    public void setVitA1DateTime(DateTime vitA1Date) {
        this.vitA1Date = vitA1Date;
    }

    public String getChildAlive() {
        return this.childAlive;
    }

    public void setChildAlive(String childAlive) {
        this.childAlive = childAlive;
    }

    public DateTime getDptBoosterDateTime() {
        return this.dptBoosterDate;
    }

    public void setDptBoosterDateTime(DateTime dptBoosterDate) {
        this.dptBoosterDate = dptBoosterDate;
    }

    public DateTime getOpvBoosterDateTime() {
        return this.opvBoosterDate;
    }

    public void setOpvBoosterDateTime(DateTime opvBoosterDate) {
        this.opvBoosterDate = opvBoosterDate;
    }

    public DateTime getDateJe() {
        return this.dateJe;
    }

    public void setDateJe(DateTime dateJe) {
        this.dateJe = dateJe;
    }

    public DateTime getDateMeaslesBooster() {
        return this.dateMeaslesBooster;
    }

    public void setDateMeaslesBooster(DateTime dateMeaslesBooster) {
        this.dateMeaslesBooster = dateMeaslesBooster;
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
        return this.vitA2Date;
    }

    public void setVitA2DateTime(DateTime vitA2Date) {
        this.vitA2Date = vitA2Date;
    }

    public DateTime getVitA3DateTime() {
        return this.vitA3Date;
    }

    public void setVitA3DateTime(DateTime vitA3Date) {
        this.vitA3Date = vitA3Date;
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
            // this.caseId, this.dateModified, updated.DateTimeModified));
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
