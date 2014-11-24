package org.motechproject.mcts.care.common.mds.dimension;

import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.joda.time.DateTime;
import org.motechproject.commons.date.util.DateUtil;
import org.motechproject.mcts.care.common.domain.SelfUpdatable;
import org.motechproject.mcts.care.common.lookup.CaseType;
import org.motechproject.mcts.care.common.mds.domain.Client;
import org.motechproject.mcts.care.common.utils.NullAwareBeanUtilsBean;
import org.motechproject.mcts.care.common.utils.SelfUpdatableUtil;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(name = "child_case")
public class ChildCase extends Client implements java.io.Serializable,
        SelfUpdatable<ChildCase> {

    private static final long serialVersionUID = -7655944396275293118L;

    @Field
    @Cascade(persist = true, update = true, delete = true)
    private MotherCase motherCase;

    @Field
    private DateTime serverDateTimeModified;
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
    private DateTime closedOn;
    @Field
    @Cascade(persist = true, update = true, delete = true)
    private Flw closedBy;
    @Field
    private DateTime creationTime;
    @Field
    private DateTime lastModifiedTime;

    protected Flw flw;

    protected FlwGroup flwGroup;

    public ChildCase() {
        DateTime date = new DateTime();
        creationTime = date;
        lastModifiedTime = date;
        super.isAlive = "yes";
    }

    public ChildCase(String caseId, DateTime dateModified, Flw flw,
            String name, FlwGroup flwGroup, DateTime dob, DateTime measlesDate,
            DateTime bcgDate, DateTime vitamin1Date, MotherCase motherCase,
            DateTime hep0Date, DateTime hep1Date, DateTime hep2Date,
            DateTime hep3Date, DateTime dpt1Date, DateTime dpt2Date,
            DateTime dpt3Date, DateTime dptBoosterDate, DateTime opv0Date,
            DateTime opv1Date, DateTime opv2Date, DateTime opv3Date,
            DateTime opvBoosterDate, String isAlive) {
        super(isAlive);
        this.caseId = caseId;
        this.dateModified = dateModified;
        this.flw = flw;
        super.setCaseName(name);
        this.flwGroup = flwGroup;
        this.dob = dob;
        this.measlesDate = measlesDate;
        this.bcgDate = bcgDate;
        this.vitA1Date = vitamin1Date;
        this.hepB0Date = hep0Date;
        this.hepB1Date = hep1Date;
        this.hepB2Date = hep2Date;
        this.hepB3Date = hep3Date;
        this.dpt1Date = dpt1Date;
        this.dpt2Date = dpt2Date;
        this.dpt3Date = dpt3Date;
        this.dptBoosterDate = dptBoosterDate;
        this.opv0Date = opv0Date;
        this.opv1Date = opv1Date;
        this.opv2Date = opv2Date;
        this.opv3Date = opv3Date;
        this.opvBoosterDate = opvBoosterDate;
        this.caseType = CaseType.CHILD;
        this.motherCase = motherCase;

    }

    public MotherCase getMotherCase() {
        return this.motherCase;
    }

    public void setMotherCase(MotherCase motherCase) {
        this.motherCase = motherCase;
    }

    public DateTime getServerDateTimeModified() {
        return this.serverDateTimeModified;
    }

    public void setServerDateTimeModified(DateTime serverDateTimeModified) {
        this.serverDateTimeModified = serverDateTimeModified;
    }

    public String getBabyMeasles() {
        return this.babyMeasles;
    }

    public void setBabyMeasles(String babyMeasles) {
        this.babyMeasles = babyMeasles;
    }

    public DateTime getBcgTime() {
        return this.bcgDate;
    }

    public void setBcgTime(DateTime bcgDate) {
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

    public DateTime getDpt1Time() {
        return this.dpt1Date;
    }

    public void setDpt1Time(DateTime dpt1Date) {
        this.dpt1Date = dpt1Date;
    }

    public DateTime getDpt2Time() {
        return this.dpt2Date;
    }

    public void setDpt2Time(DateTime dpt2Date) {
        this.dpt2Date = dpt2Date;
    }

    public DateTime getDpt3Time() {
        return this.dpt3Date;
    }

    public void setDpt3Time(DateTime dpt3Date) {
        this.dpt3Date = dpt3Date;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public DateTime getHepB0Time() {
        return this.hepB0Date;
    }

    public void setHepB0Time(DateTime hepB0Date) {
        this.hepB0Date = hepB0Date;
    }

    public DateTime getHepB1Time() {
        return this.hepB1Date;
    }

    public void setHepB1Time(DateTime hepB1Date) {
        this.hepB1Date = hepB1Date;
    }

    public DateTime getHepB2Time() {
        return this.hepB2Date;
    }

    public void setHepB2Time(DateTime hepB2Date) {
        this.hepB2Date = hepB2Date;
    }

    public DateTime getHepB3Time() {
        return this.hepB3Date;
    }

    public void setHepB3Time(DateTime hepB3Date) {
        this.hepB3Date = hepB3Date;
    }

    public DateTime getMeaslesTime() {
        return this.measlesDate;
    }

    public void setMeaslesTime(DateTime measlesDate) {
        this.measlesDate = measlesDate;
    }

    public DateTime getOpv0Time() {
        return this.opv0Date;
    }

    public void setOpv0Time(DateTime opv0Date) {
        this.opv0Date = opv0Date;
    }

    public DateTime getOpv1Time() {
        return this.opv1Date;
    }

    public void setOpv1Time(DateTime opv1Date) {
        this.opv1Date = opv1Date;
    }

    public DateTime getOpv2Time() {
        return this.opv2Date;
    }

    public void setOpv2Time(DateTime opv2Date) {
        this.opv2Date = opv2Date;
    }

    public DateTime getOpv3Time() {
        return this.opv3Date;
    }

    public void setOpv3Time(DateTime opv3Date) {
        this.opv3Date = opv3Date;
    }

    public DateTime getVitA1Time() {
        return this.vitA1Date;
    }

    public void setVitA1Time(DateTime vitA1Date) {
        this.vitA1Date = vitA1Date;
    }

    public DateTime getDptBoosterTime() {
        return this.dptBoosterDate;
    }

    public void setDptBoosterTime(DateTime dptBoosterDate) {
        this.dptBoosterDate = dptBoosterDate;
    }

    public DateTime getOpvBoosterTime() {
        return this.opvBoosterDate;
    }

    public void setOpvBoosterTime(DateTime opvBoosterDate) {
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

    public DateTime getVitA2Time() {
        return this.vitA2Date;
    }

    public void setVitA2Time(DateTime vitA2Date) {
        this.vitA2Date = vitA2Date;
    }

    public DateTime getVitA3Time() {
        return this.vitA3Date;
    }

    public void setVitA3Time(DateTime vitA3Date) {
        this.vitA3Date = vitA3Date;
    }

    public String getCordFallen() {
        return cordFallen;
    }

    public void setCordFallen(String cordFallen) {
        this.cordFallen = cordFallen;
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
                "creationTime", "closedOn", "closedBy", "closed", "modifiedBy",
                "modificationDate", "creationDate", "creator"); // TODO: remove
                                                                // later
        updateFields(updated, fieldsToIgnore);
    }

    public Boolean validateIfUpdatable(String thisId, String otherId) {
        return SelfUpdatableUtil.validateIfUpdatable(thisId, otherId,
                this.getClass());
    }

    public void updateFields(ChildCase source, List<String> ignoredFields) {
        SelfUpdatableUtil.updateFields(source, ignoredFields, this.getClass(),
                this);
        SelfUpdatableUtil.updateFields(source, ignoredFields, this.getClass().getSuperclass(),
                this);
    }

    @Field
    @Cascade(persist = true, update = true, delete = true)
    public Flw getFlw() {
        return this.flw;
    }

    public void setFlw(Flw flw) {
        this.flw = flw;
    }

    @Field
    @Cascade(persist = true, update = true, delete = true)
    public FlwGroup getFlwGroup() {
        return this.flwGroup;
    }

    public void setFlwGroup(FlwGroup flwGroup) {
        this.flwGroup = flwGroup;
    }

    private boolean isLatest(ChildCase updatedObject) {
        if (this.serverDateTimeModified == null)
            return true;
        else if (updatedObject.serverDateTimeModified == null)
            return false;
        return this.serverDateTimeModified
                .compareTo(updatedObject.serverDateTimeModified) <= 0;
    }

    // Below methods are added from Child class while unifying the tables of
    // Mother and MotherCase

    public boolean isActive() {
        return super.isActive();
    }

    @JsonIgnore
    public boolean shouldEnrollForSchedules() {
        return getDob() != null && !isOlderThanAYear() && isActive();
    }

    @JsonIgnore
    private boolean isOlderThanAYear() {
        return !DateUtil.today().minusYears(1).isBefore(getDob().toLocalDate());
    }

    public void valuesSetFrom(ChildCase child) {
        try {
            NullAwareBeanUtilsBean nullAwareBeanUtilsBean = new NullAwareBeanUtilsBean();
            nullAwareBeanUtilsBean.copyProperties(this, child);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}