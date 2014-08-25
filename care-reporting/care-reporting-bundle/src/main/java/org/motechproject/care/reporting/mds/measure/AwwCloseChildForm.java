package org.motechproject.care.reporting.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.care.reporting.mds.dimension.ChildCase;
import org.motechproject.care.reporting.mds.dimension.Flw;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(name = "aww_close_child_form")
@Unique(members = { "instance_id", "case_id" })
public class AwwCloseChildForm extends Form {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6692658655289936938L;
	@Field
	@Cascade(persist = true, update = true, delete = false)
	private ChildCase childCase;
	@Field
	@Cascade(persist = true, update = true, delete = false)
	private Flw flw;
	@Field
	private DateTime timeEnd;
	@Field
	private DateTime timeStart;
	@Field
	private DateTime dateModified;
	@Field
	private DateTime creationTime = new DateTime();
	@Field
	private String closeChild;
	@Field
	private String childOverSix;
	@Field
	private String dupeReg;
	@Field
	private String died;
	@Field
	private DateTime dateDeath;
	@Field
	private String siteDeath;
	@Field
	private String diedVillage;
	@Field
	private String placeDeath;
	@Field
	private String confirmClose;
	@Field
	private String yesClosedMessage;
	@Field
	private String noClosedMessage;
	@Field
	private String childAlive;
	@Field
	private String success;
	@Field
	private String childName;
	@Field
	private DateTime dob;
	@Field
	private String closeChildCase;

	public AwwCloseChildForm() {

	}

	public ChildCase getChildCase() {
		return this.childCase;
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

	public DateTime getTimeEnd() {
		return this.timeEnd;
	}

	public void setTimeEnd(DateTime timeEnd) {
		this.timeEnd = timeEnd;
	}

	public DateTime getTimeStart() {
		return this.timeStart;
	}

	public void setTimeStart(DateTime timeStart) {
		this.timeStart = timeStart;
	}

	public DateTime getDateModified() {
		return this.dateModified;
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

	public String getCloseChild() {
		return closeChild;
	}

	public void setCloseChild(String closeChild) {
		this.closeChild = closeChild;
	}

	public String getChildOverSix() {
		return childOverSix;
	}

	public void setChildOverSix(String childOverSix) {
		this.childOverSix = childOverSix;
	}

	public String getDupeReg() {
		return dupeReg;
	}

	public void setDupeReg(String dupeReg) {
		this.dupeReg = dupeReg;
	}

	public String getDied() {
		return died;
	}

	public void setDied(String died) {
		this.died = died;
	}

	public DateTime getDateDeath() {
		return dateDeath;
	}

	public void setDateDeath(DateTime dateDeath) {
		this.dateDeath = dateDeath;
	}

	public String getSiteDeath() {
		return siteDeath;
	}

	public void setSiteDeath(String siteDeath) {
		this.siteDeath = siteDeath;
	}

	public String getDiedVillage() {
		return diedVillage;
	}

	public void setDiedVillage(String diedVillage) {
		this.diedVillage = diedVillage;
	}

	public String getPlaceDeath() {
		return placeDeath;
	}

	public void setPlaceDeath(String placeDeath) {
		this.placeDeath = placeDeath;
	}

	public String getConfirmClose() {
		return confirmClose;
	}

	public void setConfirmClose(String confirmClose) {
		this.confirmClose = confirmClose;
	}

	public String getYesClosedMessage() {
		return yesClosedMessage;
	}

	public void setYesClosedMessage(String yesClosedMessage) {
		this.yesClosedMessage = yesClosedMessage;
	}

	public String getNoClosedMessage() {
		return noClosedMessage;
	}

	public void setNoClosedMessage(String noClosedMessage) {
		this.noClosedMessage = noClosedMessage;
	}

	public String getChildAlive() {
		return childAlive;
	}

	public void setChildAlive(String childAlive) {
		this.childAlive = childAlive;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	public DateTime getDob() {
		return dob;
	}

	public void setDob(DateTime dob) {
		this.dob = dob;
	}

	public String getCloseChildCase() {
		return closeChildCase;
	}

	public void setCloseChildCase(String closeChildCase) {
		this.closeChildCase = closeChildCase;
	}
}
