package org.motechproject.care.reporting.mds.measure;

import java.math.BigDecimal;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.care.reporting.domain.dimension.ChildCase;
import org.motechproject.care.reporting.domain.dimension.Flw;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(name = "aww_growth_monitoring_1_child_form")
@Unique(members = "instance_id")
public class AwwGrowthMonitoringChildForm1 extends Form {

    private Integer id;
    private ChildCase childCase;
    private Flw flw;
    private DateTime dateModified;
    private DateTime timeStart;
    private DateTime timeEnd;
    private DateTime creationTime;
    private String currentGrowth;
    private String lastGrowth1;
    private String lastGrowth2;
    private String lastGrowth3;
    private DateTime currentWeightDate;
    private DateTime lastWeightDate;
    private BigDecimal currentWeight;
    private String lastWeight;
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
    private Integer ageLastWeight;

    public AwwGrowthMonitoringChildForm1() {

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

    @Field(name = "current_growth")
    public String getCurrentGrowth() {
        return currentGrowth;
    }

    public void setCurrentGrowth(String currentGrowth) {
        this.currentGrowth = currentGrowth;
    }

    @Field(name = "last_growth_1")
    public String getLastGrowth1() {
        return lastGrowth1;
    }

    public void setLastGrowth1(String lastGrowth1) {
        this.lastGrowth1 = lastGrowth1;
    }

    @Field(name = "last_growth_2")
    public String getLastGrowth2() {
        return lastGrowth2;
    }

    public void setLastGrowth2(String lastGrowth2) {
        this.lastGrowth2 = lastGrowth2;
    }

    @Field(name = "last_growth_3")
    public String getLastGrowth3() {
        return lastGrowth3;
    }

    public void setLastGrowth3(String lastGrowth3) {
        this.lastGrowth3 = lastGrowth3;
    }

    @Field(name = "current_weight_date")
    public DateTime getCurrentWeightDateTime() {
        return currentWeightDate;
    }

    public void setCurrentWeightDate(DateTime currentWeightDate) {
        this.currentWeightDate = currentWeightDate;
    }

    @Field(name = "last_weight_date")
    public DateTime getLastWeightDateTime() {
        return lastWeightDate;
    }

    public void setLastWeightDate(DateTime lastWeightDate) {
        this.lastWeightDate = lastWeightDate;
    }

    @Field(name = "current_weight")
    public BigDecimal getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(BigDecimal currentWeight) {
        this.currentWeight = currentWeight;
    }

    @Field(name = "last_weight")
    public String getLastWeight() {
        return lastWeight;
    }

    public void setLastWeight(String lastWeight) {
        this.lastWeight = lastWeight;
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

    @Field(name = "age_last_weight")
    public Integer getAgeLastWeight() {
        return ageLastWeight;
    }

    public void setAgeLastWeight(Integer ageLastWeight) {
        this.ageLastWeight = ageLastWeight;
    }
}
