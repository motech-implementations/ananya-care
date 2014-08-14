package org.motechproject.care.reporting.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.care.reporting.domain.dimension.Flw;
import org.motechproject.care.reporting.domain.dimension.MotherCase;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(name = "aww_reg_mother_form")
@Unique(members = "instance_id")
public class AwwRegisterMotherForm extends Form {

	 private Flw flw;
	private MotherCase motherCase;
	private DateTime timeStart;
	private DateTime timeEnd;
	private DateTime dateModified;
	private DateTime creationTime = new DateTime();
	private DateTime dob;
	private String fatherName;
	private String motherName;
	private String hhNumber;
	private String wardNumber;
	private String familyNumber;
	private String aadharNumber;
	private Integer mctsId;
	private String mobileNumber;
	private String mobileNumberWhose;
	private String eatsMeat;
	private String invalidOwner;
	private String dobKnown;
	private DateTime dobEntered;
	private String showAge;
	private Integer ageCalc;
	private String updateMctsId;
	private String updateAadharNumber;
	private Integer fullMctsId;
	private String caste;
	private String resident;
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
	public MotherCase getMotherCase() {
		return motherCase;
	}

	public void setMotherCase(MotherCase childCase) {
		this.motherCase = childCase;
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

    @Field(name = "father_name")
    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

	@Field(name = "mother_name")
	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	@Field(name = "hh_number")
	public String getHhNumber() {
		return hhNumber;
	}

	public void setHhNumber(String hhNumber) {
		this.hhNumber = hhNumber;
	}

	@Field(name = "ward_number")
	public String getWardNumber() {
		return wardNumber;
	}

	public void setWardNumber(String wardNumber) {
		this.wardNumber = wardNumber;
	}

	@Field(name = "family_number")
	public String getFamilyNumber() {
		return familyNumber;
	}

	public void setFamilyNumber(String familyNumber) {
		this.familyNumber = familyNumber;
	}

	@Field(name = "aadhar_number")
	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	@Field(name = "mcts_id")
	public Integer getMctsId() {
		return mctsId;
	}

	public void setMctsId(Integer mctsId) {
		this.mctsId = mctsId;
	}

	@Field(name = "mobile_number")
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Field(name = "mobile_number_whose")
	public String getMobileNumberWhose() {
		return mobileNumberWhose;
	}

	public void setMobileNumberWhose(String mobileNumberWhose) {
		this.mobileNumberWhose = mobileNumberWhose;
	}

	@Field(name = "eats_meat")
	public String getEatsMeat() {
		return eatsMeat;
	}

	public void setEatsMeat(String eatsMeat) {
		this.eatsMeat = eatsMeat;
	}

	@Field(name = "invalid_owner")
	public String getInvalidOwner() {
		return invalidOwner;
	}

	public void setInvalidOwner(String invalidOwner) {
		this.invalidOwner = invalidOwner;
	}

	@Field(name = "dob_known")
	public String getDobKnown() {
		return dobKnown;
	}

	public void setDobKnown(String dobKnown) {
		this.dobKnown = dobKnown;
	}
	
	@Field(name = "dob_entered")
	public DateTime getDobEntered() {
		return dobEntered;
	}

	public void setDobEntered(DateTime dobEntered) {
		this.dobEntered = dobEntered;
	}

	@Field(name = "show_age")
	public String getShowAge() {
		return showAge;
	}

	public void setShowAge(String showAge) {
		this.showAge = showAge;
	}

	@Field(name = "age_calc")
	public Integer getAgeCalc() {
		return ageCalc;
	}

	public void setAgeCalc(Integer ageCalc) {
		this.ageCalc = ageCalc;
	}

	@Field(name = "update_mcts_id")
	public String getUpdateMctsId() {
		return updateMctsId;
	}

	public void setUpdateMctsId(String updateMctsId) {
		this.updateMctsId = updateMctsId;
	}

	@Field(name = "update_aadhar_number")
	public String getUpdateAadharNumber() {
		return updateAadharNumber;
	}

	public void setUpdateAadharNumber(String updateAadharNumber) {
		this.updateAadharNumber = updateAadharNumber;
	}

	@Field(name = "full_mcts_id")
	public Integer getFullMctsId() {
		return fullMctsId;
	}

	public void setFullMctsId(Integer fullMctsId) {
		this.fullMctsId = fullMctsId;
	}

	@Field(name = "caste")
	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	@Field(name = "resident")
	public String getResident() {
		return resident;
	}

	public void setResident(String resident) {
		this.resident = resident;
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
