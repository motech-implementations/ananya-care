package org.motechproject.mcts.care.common.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.mcts.care.common.mds.dimension.Flw;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
import org.motechproject.mcts.care.common.mds.measure.Form;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(name = "aww_reg_mother_form")
@Unique(members = "instance_id")
public class AwwRegisterMotherForm extends Form {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6936500814469523093L;
	@Field
	@Cascade(persist = true, update = true, delete = false)
	private Flw flw;
	@Field
	@Cascade(persist = true, update = true, delete = false)
	private MotherCase motherCase;
	@Field
	private DateTime timeStart;
	@Field
	private DateTime timeEnd;
	@Field
	private DateTime dateModified;
	@Field
	private DateTime creationTime = new DateTime();
	@Field
	private DateTime dob;
	@Field
	private String fatherName;
	@Field
	private String motherName;
	@Field
	private String hhNumber;
	@Field
	private String wardNumber;
	@Field
	private String familyNumber;
	@Field
	private String aadharNumber;
	@Field
	private Integer mctsId;
	@Field
	private String mobileNumber;
	@Field
	private String mobileNumberWhose;
	@Field
	private String eatsMeat;
	@Field
	private String invalidOwner;
	@Field
	private String dobKnown;
	@Field
	private DateTime dobEntered;
	@Field
	private String showAge;
	@Field
	private Integer ageCalc;
	@Field
	private String updateMctsId;
	@Field
	private String updateAadharNumber;
	@Field
	private Integer fullMctsId;
	@Field
	private String caste;
	@Field
	private String resident;
	@Field
	private String success;
	@Field
	private String ownerIdCalc;

	public Flw getFlw() {
		return flw;
	}

	public void setFlw(Flw flw) {
		this.flw = flw;
	}

	public MotherCase getMotherCase() {
		return motherCase;
	}

	public void setMotherCase(MotherCase childCase) {
		this.motherCase = childCase;
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

	public DateTime getDateModified() {
		return dateModified;
	}

	public void setDateModified(DateTime dateModified) {
		this.dateModified = dateModified;
	}

	public DateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(DateTime creationTime) {
		this.creationTime = creationTime;
	}

	public DateTime getDob() {
		return dob;
	}

	public void setDob(DateTime dob) {
		this.dob = dob;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getHhNumber() {
		return hhNumber;
	}

	public void setHhNumber(String hhNumber) {
		this.hhNumber = hhNumber;
	}

	public String getWardNumber() {
		return wardNumber;
	}

	public void setWardNumber(String wardNumber) {
		this.wardNumber = wardNumber;
	}

	public String getFamilyNumber() {
		return familyNumber;
	}

	public void setFamilyNumber(String familyNumber) {
		this.familyNumber = familyNumber;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public Integer getMctsId() {
		return mctsId;
	}

	public void setMctsId(Integer mctsId) {
		this.mctsId = mctsId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getMobileNumberWhose() {
		return mobileNumberWhose;
	}

	public void setMobileNumberWhose(String mobileNumberWhose) {
		this.mobileNumberWhose = mobileNumberWhose;
	}

	public String getEatsMeat() {
		return eatsMeat;
	}

	public void setEatsMeat(String eatsMeat) {
		this.eatsMeat = eatsMeat;
	}

	public String getInvalidOwner() {
		return invalidOwner;
	}

	public void setInvalidOwner(String invalidOwner) {
		this.invalidOwner = invalidOwner;
	}

	public String getDobKnown() {
		return dobKnown;
	}

	public void setDobKnown(String dobKnown) {
		this.dobKnown = dobKnown;
	}

	public DateTime getDobEntered() {
		return dobEntered;
	}

	public void setDobEntered(DateTime dobEntered) {
		this.dobEntered = dobEntered;
	}

	public String getShowAge() {
		return showAge;
	}

	public void setShowAge(String showAge) {
		this.showAge = showAge;
	}

	public Integer getAgeCalc() {
		return ageCalc;
	}

	public void setAgeCalc(Integer ageCalc) {
		this.ageCalc = ageCalc;
	}

	public String getUpdateMctsId() {
		return updateMctsId;
	}

	public void setUpdateMctsId(String updateMctsId) {
		this.updateMctsId = updateMctsId;
	}

	public String getUpdateAadharNumber() {
		return updateAadharNumber;
	}

	public void setUpdateAadharNumber(String updateAadharNumber) {
		this.updateAadharNumber = updateAadharNumber;
	}

	public Integer getFullMctsId() {
		return fullMctsId;
	}

	public void setFullMctsId(Integer fullMctsId) {
		this.fullMctsId = fullMctsId;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public String getResident() {
		return resident;
	}

	public void setResident(String resident) {
		this.resident = resident;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getOwnerIdCalc() {
		return ownerIdCalc;
	}

	public void setOwnerIdCalc(String ownerIdCalc) {
		this.ownerIdCalc = ownerIdCalc;
	}
}
