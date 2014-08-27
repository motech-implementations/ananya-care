package org.motechproject.care.reporting.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.care.reporting.utils.FormToString;
import org.motechproject.mcts.care.common.mds.dimension.Flw;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
import org.motechproject.mcts.care.common.mds.measure.Form;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;


@Entity(name = "new_form")
@Unique(members = "instance_id")
public class NewForm extends Form {

	 private Flw flw;
	private MotherCase motherCase;
	private DateTime timeEnd;
	private DateTime timeStart;
	private DateTime dateModified;
	private int ageCalc;
	private String caseName;
	private String caseType;
	private DateTime dateLastVisit;
	private DateTime dateNextReg;
	private Integer familyNumber;
	private Integer hhNumber;
	private String husbandName;
	private String lastVisitType;
	private String motherAlive;
	private DateTime motherDob;
	private String motherName;
	private String caste;
	private DateTime dob;
	private String dobKnown;
	private String fullName;
    private String manualGroup;
    private DateTime creationTime = new DateTime();

    public NewForm() {
	}

	@Field
    @Cascade(persist = true, update = true, delete = false)
	public Flw getFlw() {
		return this.flw;
	}

	public void setFlw(Flw flw) {
		this.flw = flw;
	}

	@Field
	public String getManualGroup() {
		return this.manualGroup;
	}

	public void setManualGroup(String manualGroup) {
		this.manualGroup = manualGroup;
	}

	
	@Field
    @Cascade(persist = true, update = true, delete = false)
	public MotherCase getMotherCase() {
		return this.motherCase;
	}

	public void setMotherCase(MotherCase motherCase) {
		this.motherCase = motherCase;
	}

	
	@Field
	public DateTime getTimeEnd() {
		return this.timeEnd;
	}

	public void setTimeEnd(DateTime timeEnd) {
		this.timeEnd = timeEnd;
	}

	
	@Field
	public DateTime getTimeStart() {
		return this.timeStart;
	}

	public void setTimeStart(DateTime timeStart) {
		this.timeStart = timeStart;
	}

	
	@Field
	public DateTime getDateModified() {
		return this.dateModified;
	}

	public void setDateModified(DateTime dateModified) {
		this.dateModified = dateModified;
	}

	@Field
	public int getAgeCalc() {
		return this.ageCalc;
	}

	public void setAgeCalc(int ageCalc) {
		this.ageCalc = ageCalc;
	}

	@Field
	public String getCaseName() {
		return this.caseName;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}

	@Field
	public String getCaseType() {
		return this.caseType;
	}

	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}

	
	@Field
	public DateTime getDateLastVisit() {
		return this.dateLastVisit;
	}

	public void setDateLastVisit(DateTime dateLastVisit) {
		this.dateLastVisit = dateLastVisit;
	}

	
	@Field
	public DateTime getDateNextReg() {
		return this.dateNextReg;
	}

	public void setDateNextReg(DateTime dateNextReg) {
		this.dateNextReg = dateNextReg;
	}

	@Field
	public Integer getFamilyNumber() {
		return this.familyNumber;
	}

	public void setFamilyNumber(Integer familyNumber) {
		this.familyNumber = familyNumber;
	}

	@Field
	public Integer getHhNumber() {
		return this.hhNumber;
	}

	public void setHhNumber(Integer hhNumber) {
		this.hhNumber = hhNumber;
	}

	@Field
	public String getHusbandName() {
		return this.husbandName;
	}

	public void setHusbandName(String husbandName) {
		this.husbandName = husbandName;
	}

	@Field
	public String getLastVisitType() {
		return this.lastVisitType;
	}

	public void setLastVisitType(String lastVisitType) {
		this.lastVisitType = lastVisitType;
	}

	@Field
	public String getMotherAlive() {
		return this.motherAlive;
	}

	public void setMotherAlive(String motherAlive) {
		this.motherAlive = motherAlive;
	}

	
	@Field
	public DateTime getMotherDob() {
		return this.motherDob;
	}

	public void setMotherDob(DateTime motherDob) {
		this.motherDob = motherDob;
	}

	@Field
	public String getMotherName() {
		return this.motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	@Field
	public String getCaste() {
		return this.caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	
	@Field
	public DateTime getDob() {
		return this.dob;
	}

	public void setDob(DateTime dob) {
		this.dob = dob;
	}

	@Field
	public String getDobKnown() {
		return this.dobKnown;
	}

	public void setDobKnown(String dobKnown) {
		this.dobKnown = dobKnown;
	}

	@Field
	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

    
    @Field
    public DateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(DateTime creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public String toString() {
        return FormToString.toString(this);
    }
}
