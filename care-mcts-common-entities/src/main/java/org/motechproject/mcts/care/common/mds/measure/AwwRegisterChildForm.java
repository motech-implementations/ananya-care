package org.motechproject.mcts.care.common.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.dimension.Flw;
import org.motechproject.mcts.care.common.mds.measure.Form;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(name = "aww_reg_child_form")
@Unique(members = "instanceId")
public class AwwRegisterChildForm extends Form {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 2520193494145920723L;
	@Field
    @Cascade(persist = true, update = true, delete = false)
	private Flw flw;
	@Field
    @Cascade(persist = true, update = true, delete = false)
	private ChildCase childCase;
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
	private String childAlive;
	@Field
	private String gender;
	@Field
	private String childName;
	@Field
	private Integer ageEstMonths;
	@Field
	private Integer ageEstYears;
	@Field
	private Integer childMctsId;
	@Field
	private String invalidOwner;
	@Field
	private Integer fullChildMctsId;
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

	
	public ChildCase getChildCase() {
		return childCase;
	}

	public void setChildCase(ChildCase childCase) {
		this.childCase = childCase;
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

	public String getChildAlive() {
		return childAlive;
	}

	public void setChildAlive(String childAlive) {
		this.childAlive = childAlive;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	public Integer getAgeEstMonths() {
		return ageEstMonths;
	}

	public void setAgeEstMonths(Integer ageEstMonths) {
		this.ageEstMonths = ageEstMonths;
	}

	public Integer getAgeEstYears() {
		return ageEstYears;
	}

	public void setAgeEstYears(Integer ageEstYears) {
		this.ageEstYears = ageEstYears;
	}

	public Integer getChildMctsId() {
		return childMctsId;
	}

	public void setChildMctsId(Integer childMctsId) {
		this.childMctsId = childMctsId;
	}

	public String getInvalidOwner() {
		return invalidOwner;
	}

	public void setInvalidOwner(String invalidOwner) {
		this.invalidOwner = invalidOwner;
	}

	public Integer getFullChildMctsId() {
		return fullChildMctsId;
	}

	public void setFullChildMctsId(Integer fullChildMctsId) {
		this.fullChildMctsId = fullChildMctsId;
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
