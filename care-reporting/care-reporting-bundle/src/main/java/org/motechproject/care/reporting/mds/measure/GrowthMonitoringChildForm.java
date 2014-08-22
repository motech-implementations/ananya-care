package org.motechproject.care.reporting.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.care.reporting.mds.dimension.ChildCase;
import org.motechproject.care.reporting.mds.dimension.Flw;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(name = "growth_monitoring_child_form")
@Unique(members = "instance_id")
public class GrowthMonitoringChildForm extends Form {

    private Integer id;
    private ChildCase childCase;
    private Flw flw;
    private DateTime dateModified;
    private DateTime timeStart;
    private DateTime timeEnd;
    private DateTime creationTime;
    private String takeWeight;
    private String childWeight;
    private String showGrade;
    private String requiresAttention;
    private String success;
    private String calcGrade;
    private String calcGrowth;
    private String childGender;
    private Integer childAge;
    private DateTime dob;
    private String gender;
    private String changeFromNormal;
    private String changeFromMuw;
    private String changeFromSuw;

    public GrowthMonitoringChildForm() {

    }

    @Field(name = "case_id")
    @Cascade(persist = true, update = true, delete = false)
    public ChildCase getChildCase() {
        return childCase;
    }

    public void setChildCase(ChildCase childCase) {
        this.childCase = childCase;
    }

    
    @Field(name = "user_id")
    @Cascade(persist = true, update = true, delete = false)
    public Flw getFlw() {
        return this.flw;
    }

    public void setFlw(Flw flw) {
        this.flw = flw;
    }

     
    @Field(name = "date_modified")
    public DateTime getDateModified() {
        return dateModified;
    }

    public void setDateModified(DateTime dateModified) {
        this.dateModified = dateModified;
    }

     
    @Field(name = "time_start")
    public DateTime getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(DateTime timeStart) {
        this.timeStart = timeStart;
    }

     
    @Field(name = "time_end")
    public DateTime getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(DateTime timeEnd) {
        this.timeEnd = timeEnd;
    }

     
    @Field(name = "creation_time")
    public DateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(DateTime creationTime) {
        this.creationTime = creationTime;
    }

    @Field(name = "take_weight")
    public String getTakeWeight() {
        return takeWeight;
    }

    public void setTakeWeight(String takeWeight) {
        this.takeWeight = takeWeight;
    }

    @Field(name = "child_weight")
    public String getChildWeight() {
        return childWeight;
    }

    public void setChildWeight(String childWeight) {
        this.childWeight = childWeight;
    }

    @Field(name = "show_grade")
    public String getShowGrade() {
        return showGrade;
    }

    public void setShowGrade(String showGrade) {
        this.showGrade = showGrade;
    }

    @Field(name = "requires_attention")
    public String getRequiresAttention() {
        return requiresAttention;
    }

    public void setRequiresAttention(String requiresAttention) {
        this.requiresAttention = requiresAttention;
    }

    @Field(name = "success")
    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    @Field(name = "calc_grade")
    public String getCalcGrade() {
        return calcGrade;
    }

    public void setCalcGrade(String calcGrade) {
        this.calcGrade = calcGrade;
    }

    @Field(name = "calc_growth")
    public String getCalcGrowth() {
        return calcGrowth;
    }

    public void setCalcGrowth(String calcGrowth) {
        this.calcGrowth = calcGrowth;
    }

    @Field(name = "child_gender")
    public String getChildGender() {
        return childGender;
    }

    public void setChildGender(String childGender) {
        this.childGender = childGender;
    }

    @Field(name = "child_age")
    public Integer getChildAge() {
        return childAge;
    }

    public void setChildAge(Integer childAge) {
        this.childAge = childAge;
    }

    @Field(name = "dob")
    public DateTime getDob() {
        return dob;
    }

    public void setDob(DateTime dob) {
        this.dob = dob;
    }

    @Field(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Field(name = "change_from_normal")
    public String getChangeFromNormal() {
        return changeFromNormal;
    }

    public void setChangeFromNormal(String changeFromNormal) {
        this.changeFromNormal = changeFromNormal;
    }

    @Field(name = "change_from_muw")
    public String getChangeFromMuw() {
        return changeFromMuw;
    }

    public void setChangeFromMuw(String changeFromMuw) {
        this.changeFromMuw = changeFromMuw;
    }

    @Field(name = "change_from_suw")
    public String getChangeFromSuw() {
        return changeFromSuw;
    }

    public void setChangeFromSuw(String changeFromSuw) {
        this.changeFromSuw = changeFromSuw;
    }
}
