package org.motechproject.mcts.care.common.mds.domain;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.joda.time.DateTime;
import org.motechproject.commons.date.util.DateUtil;
import org.motechproject.mcts.care.common.lookup.CaseType;
import org.motechproject.mcts.care.common.utils.NullAwareBeanUtilsBean;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(name = "ChildTest")
public class ChildTest extends ClientTest {

    @Field
    private DateTime measlesDate;
    @Field
    private DateTime dob;
    @Field
    private DateTime bcgDate;
    @Field
    private DateTime vitamin1Date;
    @Field
    private DateTime hep0Date;
    @Field
    private DateTime hep1Date;
    @Field
    private DateTime hep2Date;
    @Field
    private DateTime hep3Date;
    @Field
    private DateTime dpt1Date;
    @Field
    private DateTime dpt2Date;
    @Field
    private DateTime dpt3Date;
    @Field
    private DateTime dptBoosterDate;
    @Field
    private DateTime opv0Date;
    @Field
    private DateTime opv1Date;
    @Field
    private DateTime opv2Date;
    @Field
    private DateTime opv3Date;
    @Field
    private DateTime opvBoosterDate;
    @Field
    private String motherCaseId;
    @Field
    private String caseType;

    public ChildTest(String caseId, DateTime dateModified, String flwId,
            String name, String groupId, DateTime dob, DateTime measlesDate,
            DateTime bcgDate, DateTime vitamin1Date, String motherCaseId,
            DateTime hep0Date, DateTime hep1Date, DateTime hep2Date,
            DateTime hep3Date, DateTime dpt1Date, DateTime dpt2Date,
            DateTime dpt3Date, DateTime dptBoosterDate, DateTime opv0Date,
            DateTime opv1Date, DateTime opv2Date, DateTime opv3Date,
            DateTime opvBoosterDate, Boolean isAlive) {
        super(isAlive);
        this.motherCaseId = motherCaseId;
        this.caseId = caseId;
        this.dateModified = dateModified;
        this.flwId = flwId;
        this.name = name;
        this.groupId = groupId;
        this.dob = dob;
        this.measlesDate = measlesDate;
        this.bcgDate = bcgDate;
        this.vitamin1Date = vitamin1Date;
        this.hep0Date = hep0Date;
        this.hep1Date = hep1Date;
        this.hep2Date = hep2Date;
        this.hep3Date = hep3Date;
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
    }

    public ChildTest() {
        this.caseType = CaseType.CHILD;
    }

    public DateTime getHep0Date() {
        return hep0Date;
    }

    public void setHep0Date(DateTime hep0Date) {
        this.hep0Date = hep0Date;
    }

    public DateTime getHep1Date() {
        return hep1Date;
    }

    public void setHep1Date(DateTime hep1Date) {
        this.hep1Date = hep1Date;
    }

    public DateTime getHep2Date() {
        return hep2Date;
    }

    public void setHep2Date(DateTime hep2Date) {
        this.hep2Date = hep2Date;
    }

    public DateTime getHep3Date() {
        return hep3Date;
    }

    public void setHep3Date(DateTime hep3Date) {
        this.hep3Date = hep3Date;
    }

    public DateTime getDpt1Date() {
        return dpt1Date;
    }

    public void setDpt1Date(DateTime dpt1Date) {
        this.dpt1Date = dpt1Date;
    }

    public DateTime getDpt2Date() {
        return dpt2Date;
    }

    public void setDpt2Date(DateTime dpt2Date) {
        this.dpt2Date = dpt2Date;
    }

    public DateTime getDpt3Date() {
        return dpt3Date;
    }

    public void setDpt3Date(DateTime dpt3Date) {
        this.dpt3Date = dpt3Date;
    }

    public DateTime getDptBoosterDate() {
        return dptBoosterDate;
    }

    public void setDptBoosterDate(DateTime dptBoosterDate) {
        this.dptBoosterDate = dptBoosterDate;
    }

    public DateTime getOpv0Date() {
        return opv0Date;
    }

    public void setOpv0Date(DateTime opv0Date) {
        this.opv0Date = opv0Date;
    }

    public DateTime getOpv1Date() {
        return opv1Date;
    }

    public void setOpv1Date(DateTime opv1Date) {
        this.opv1Date = opv1Date;
    }

    public DateTime getOpv2Date() {
        return opv2Date;
    }

    public void setOpv2Date(DateTime opv2Date) {
        this.opv2Date = opv2Date;
    }

    public DateTime getOpv3Date() {
        return opv3Date;
    }

    public void setOpv3Date(DateTime opv3Date) {
        this.opv3Date = opv3Date;
    }

    public DateTime getOpvBoosterDate() {
        return opvBoosterDate;
    }

    public void setOpvBoosterDate(DateTime opvBoosterDate) {
        this.opvBoosterDate = opvBoosterDate;
    }

    public String getMotherCaseId() {
        return motherCaseId;
    }

    public void setMotherCaseId(String motherCaseId) {
        this.motherCaseId = motherCaseId;
    }

    public DateTime getDob() {
        return DateUtil.setTimeZone(dob);
    }

    public void setDob(DateTime dob) {
        this.dob = dob;
    }

    public DateTime getMeaslesDate() {
        return DateUtil.setTimeZone(measlesDate);
    }

    public void setMeaslesDate(DateTime measlesDate) {
        this.measlesDate = measlesDate;
    }

    public DateTime getBcgDate() {
        return DateUtil.setTimeZone(bcgDate);
    }

    public void setBcgDate(DateTime bcgDate) {
        this.bcgDate = bcgDate;
    }

    public DateTime getVitamin1Date() {
        return DateUtil.setTimeZone(vitamin1Date);
    }

    public void setVitamin1Date(DateTime vitamin1Date) {
        this.vitamin1Date = vitamin1Date;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = CaseType.CHILD;
    }

    
    public void setValuesFrom(ChildTest child) {
        try {
            NullAwareBeanUtilsBean nullAwareBeanUtilsBean = new NullAwareBeanUtilsBean();
            nullAwareBeanUtilsBean.copyProperties(this, child);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @JsonIgnore
    public boolean shouldEnrollForSchedules() {
        return getDob() != null && !isOlderThanAYear() && isActive();
    }

    @JsonIgnore
    private boolean isOlderThanAYear() {
        return !DateUtil.today().minusYears(1).isBefore(getDob().toLocalDate());
    }

}