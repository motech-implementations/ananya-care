package org.motechproject.care.reporting.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.care.reporting.domain.dimension.ChildCase;
import org.motechproject.care.reporting.domain.dimension.Flw;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(name = "aww_reg_child_form")
@Unique(members = "instance_id")
public class AwwRegisterChildForm extends Form {

	 private Flw flw;
	private ChildCase childCase;
	private DateTime timeStart;
	private DateTime timeEnd;
	private DateTime dateModified;
	private DateTime creationTime = new DateTime();
	private DateTime dob;
	private String childAlive;
	private String gender;
	private String childName;
	private Integer ageEstMonths;
	private Integer ageEstYears;
	private Integer childMctsId;
	private String invalidOwner;
	private Integer fullChildMctsId;
	private String success;
	private String ownerIdCalc;

	@Field(name = "user_id")
    @Cascade(persist = true, update = true, delete = false)
	public Flw getFlw() {
		return flw;
	}

	public void setFlw(Flw flw) {
		this.flw = flw;
	}

	
	@Field(name = "case_id")
    @Cascade(persist = true, update = true, delete = false)
	public ChildCase getChildCase() {
		return childCase;
	}

	public void setChildCase(ChildCase childCase) {
		this.childCase = childCase;
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

	
	@Field(name = "date_modified")
	public DateTime getDateModified() {
		return dateModified;
	}

	public void setDateModified(DateTime dateModified) {
		this.dateModified = dateModified;
	}

	
	@Field(name = "creation_time")
	public DateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(DateTime creationTime) {
		this.creationTime = creationTime;
	}

	
	@Field(name = "dob")
	public DateTime getDob() {
		return dob;
	}

	public void setDob(DateTime dob) {
		this.dob = dob;
	}

	@Field(name = "child_alive")
	public String getChildAlive() {
		return childAlive;
	}

	public void setChildAlive(String childAlive) {
		this.childAlive = childAlive;
	}
	@Field(name = "gender")
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Field(name = "child_name")
	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	@Field(name = "age_est_months")
	public Integer getAgeEstMonths() {
		return ageEstMonths;
	}

	public void setAgeEstMonths(Integer ageEstMonths) {
		this.ageEstMonths = ageEstMonths;
	}

	@Field(name = "age_est_years")
	public Integer getAgeEstYears() {
		return ageEstYears;
	}

	public void setAgeEstYears(Integer ageEstYears) {
		this.ageEstYears = ageEstYears;
	}

	@Field(name = "child_mcts_id")
	public Integer getChildMctsId() {
		return childMctsId;
	}

	public void setChildMctsId(Integer childMctsId) {
		this.childMctsId = childMctsId;
	}

	@Field(name = "invalid_owner")
	public String getInvalidOwner() {
		return invalidOwner;
	}

	public void setInvalidOwner(String invalidOwner) {
		this.invalidOwner = invalidOwner;
	}

	@Field(name = "full_child_mcts_id")
	public Integer getFullChildMctsId() {
		return fullChildMctsId;
	}

	public void setFullChildMctsId(Integer fullChildMctsId) {
		this.fullChildMctsId = fullChildMctsId;
	}

	@Field(name = "success")
	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	@Field(name = "owner_id_calc")
	public String getOwnerIdCalc() {
		return ownerIdCalc;
	}

	public void setOwnerIdCalc(String ownerIdCalc) {
		this.ownerIdCalc = ownerIdCalc;
	}
}
