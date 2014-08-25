package org.motechproject.care.reporting.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.care.reporting.mds.dimension.ChildCase;
import org.motechproject.care.reporting.mds.dimension.Flw;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(name = "aww_growth_monitoring_1_child_form")
@Unique(members = "instance_id")
public class AwwGrowthMonitoringChildForm1 extends Form {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1091629470558636407L;
	@Field
	@Cascade(persist = true, update = true, delete = false)
	private ChildCase childCase;
	@Field
	@Cascade(persist = true, update = true, delete = false)
	private Flw flw;
	@Field
	private DateTime dateModified;
	@Field
	private DateTime timeStart;
	@Field
	private DateTime timeEnd;
	@Field
	private DateTime creationTime;
	@Field
	private String currentGrowth;
	@Field
	private String lastGrowth1;
	@Field
	private String lastGrowth2;
	@Field
	private String lastGrowth3;
	@Field
	private DateTime currentWeightDate;
	@Field
	private DateTime lastWeightDate;
	@Field
	private int currentWeight;
	@Field
	private String lastWeight;
	@Field
	private String takeWeight;
	@Field
	private String childWeight;
	@Field
	private String showGrade;
	@Field
	private String requiresAttention;
	@Field
	private String success;
	@Field
	private String calcGrade;
	@Field
	private String calcGrowth;
	@Field
	private String childGender;
	@Field
	private Integer childAge;
	@Field
	private DateTime dob;
	@Field
	private String gender;
	@Field
	private String changeFromNormal;
	@Field
	private String changeFromMuw;
	@Field
	private String changeFromSuw;
	@Field
	private Integer ageLastWeight;

	public AwwGrowthMonitoringChildForm1() {

	}

	public ChildCase getChildCase() {
		return childCase;
	}

	public void setChildCase(ChildCase childCase) {
		this.childCase = childCase;
	}

	public Flw getFlw() {
		return this.flw;
	}

	public void setFlw(Flw flw) {
		this.flw = flw;
	}

	public DateTime getDateModified() {
		return dateModified;
	}

	public void setDateModified(DateTime dateModified) {
		this.dateModified = dateModified;
	}

	public DateTime getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(DateTime timeStart) {
		this.timeStart = timeStart;
	}

	public DateTime getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(DateTime timeEnd) {
		this.timeEnd = timeEnd;
	}

	public DateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(DateTime creationTime) {
		this.creationTime = creationTime;
	}

	public String getCurrentGrowth() {
		return currentGrowth;
	}

	public void setCurrentGrowth(String currentGrowth) {
		this.currentGrowth = currentGrowth;
	}

	public String getLastGrowth1() {
		return lastGrowth1;
	}

	public void setLastGrowth1(String lastGrowth1) {
		this.lastGrowth1 = lastGrowth1;
	}

	public String getLastGrowth2() {
		return lastGrowth2;
	}

	public void setLastGrowth2(String lastGrowth2) {
		this.lastGrowth2 = lastGrowth2;
	}

	public String getLastGrowth3() {
		return lastGrowth3;
	}

	public void setLastGrowth3(String lastGrowth3) {
		this.lastGrowth3 = lastGrowth3;
	}

	public DateTime getCurrentWeightDateTime() {
		return currentWeightDate;
	}

	public void setCurrentWeightDate(DateTime currentWeightDate) {
		this.currentWeightDate = currentWeightDate;
	}

	public DateTime getLastWeightDateTime() {
		return lastWeightDate;
	}

	public void setLastWeightDate(DateTime lastWeightDate) {
		this.lastWeightDate = lastWeightDate;
	}

	public int getCurrentWeight() {
		return currentWeight;
	}

	public void setCurrentWeight(int currentWeight) {
		this.currentWeight = currentWeight;
	}

	public String getLastWeight() {
		return lastWeight;
	}

	public void setLastWeight(String lastWeight) {
		this.lastWeight = lastWeight;
	}

	public String getTakeWeight() {
		return takeWeight;
	}

	public void setTakeWeight(String takeWeight) {
		this.takeWeight = takeWeight;
	}

	public String getChildWeight() {
		return childWeight;
	}

	public void setChildWeight(String childWeight) {
		this.childWeight = childWeight;
	}

	public String getShowGrade() {
		return showGrade;
	}

	public void setShowGrade(String showGrade) {
		this.showGrade = showGrade;
	}

	public String getRequiresAttention() {
		return requiresAttention;
	}

	public void setRequiresAttention(String requiresAttention) {
		this.requiresAttention = requiresAttention;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getCalcGrade() {
		return calcGrade;
	}

	public void setCalcGrade(String calcGrade) {
		this.calcGrade = calcGrade;
	}

	public String getCalcGrowth() {
		return calcGrowth;
	}

	public void setCalcGrowth(String calcGrowth) {
		this.calcGrowth = calcGrowth;
	}

	public String getChildGender() {
		return childGender;
	}

	public void setChildGender(String childGender) {
		this.childGender = childGender;
	}

	public Integer getChildAge() {
		return childAge;
	}

	public void setChildAge(Integer childAge) {
		this.childAge = childAge;
	}

	public DateTime getDob() {
		return dob;
	}

	public void setDob(DateTime dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getChangeFromNormal() {
		return changeFromNormal;
	}

	public void setChangeFromNormal(String changeFromNormal) {
		this.changeFromNormal = changeFromNormal;
	}

	public String getChangeFromMuw() {
		return changeFromMuw;
	}

	public void setChangeFromMuw(String changeFromMuw) {
		this.changeFromMuw = changeFromMuw;
	}

	public String getChangeFromSuw() {
		return changeFromSuw;
	}

	public void setChangeFromSuw(String changeFromSuw) {
		this.changeFromSuw = changeFromSuw;
	}

	public Integer getAgeLastWeight() {
		return ageLastWeight;
	}

	public void setAgeLastWeight(Integer ageLastWeight) {
		this.ageLastWeight = ageLastWeight;
	}
}
