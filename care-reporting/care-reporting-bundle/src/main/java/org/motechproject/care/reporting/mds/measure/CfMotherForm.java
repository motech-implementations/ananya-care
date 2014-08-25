package org.motechproject.care.reporting.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.care.reporting.mds.dimension.Flw;
import org.motechproject.care.reporting.mds.dimension.MotherCase;
import org.motechproject.care.reporting.utils.FormToString;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(name = "cf_mother_form")
@Unique(members = "instance_id")
public class CfMotherForm extends Form {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9218530786409330609L;
	@Field
	@Cascade(persist = true, update = true, delete = false)
	private Flw flw;
	@Field
	@Cascade(persist = true, update = true, delete = false)
	private MotherCase motherCase;
	@Field
	private DateTime timeEnd;
	@Field
	private DateTime timeStart;
	@Field
	private DateTime dateModified;
	@Field
	private DateTime dateCf1;
	@Field
	private DateTime dateCf2;
	@Field
	private DateTime dateCf3;
	@Field
	private DateTime dateCf4;
	@Field
	private DateTime dateCf5;
	@Field
	private DateTime dateCf6;
	@Field
	private DateTime dateLastVisit;
	@Field
	private DateTime dateNextCf;
	@Field
	private String lastVisitType;
	@Field
	private int cfVisitNum;
	@Field
	private int numChildren;
	@Field
	private String playCompFeedingVid;
	@Field
	private String lastvisit;
	@Field
	private DateTime dateCf7;
	@Field
	private String confirmClose;
	@Field
	private Boolean close;
	@Field
	private DateTime creationTime = new DateTime();
	@Field
	private String ownerId;
	@Field
	private String invalidGroupsTransfer;
	@Field
	private String newOwner;

	public CfMotherForm() {
	}

	public Flw getFlw() {
		return this.flw;
	}

	public void setFlw(Flw flw) {
		this.flw = flw;
	}

	public MotherCase getMotherCase() {
		return this.motherCase;
	}

	public void setMotherCase(MotherCase motherCase) {
		this.motherCase = motherCase;
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

	public DateTime getDateCf1() {
		return this.dateCf1;
	}

	public void setDateCf1(DateTime dateCf1) {
		this.dateCf1 = dateCf1;
	}

	public DateTime getDateCf2() {
		return this.dateCf2;
	}

	public void setDateCf2(DateTime dateCf2) {
		this.dateCf2 = dateCf2;
	}

	public DateTime getDateCf3() {
		return this.dateCf3;
	}

	public void setDateCf3(DateTime dateCf3) {
		this.dateCf3 = dateCf3;
	}

	public DateTime getDateCf4() {
		return this.dateCf4;
	}

	public void setDateCf4(DateTime dateCf4) {
		this.dateCf4 = dateCf4;
	}

	public DateTime getDateCf5() {
		return this.dateCf5;
	}

	public void setDateCf5(DateTime dateCf5) {
		this.dateCf5 = dateCf5;
	}

	public DateTime getDateCf6() {
		return this.dateCf6;
	}

	public void setDateCf6(DateTime dateCf6) {
		this.dateCf6 = dateCf6;
	}

	public DateTime getDateLastVisit() {
		return this.dateLastVisit;
	}

	public void setDateLastVisit(DateTime dateLastVisit) {
		this.dateLastVisit = dateLastVisit;
	}

	public DateTime getDateNextCf() {
		return this.dateNextCf;
	}

	public void setDateNextCf(DateTime dateNextCf) {
		this.dateNextCf = dateNextCf;
	}

	public String getLastVisitType() {
		return this.lastVisitType;
	}

	public void setLastVisitType(String lastVisitType) {
		this.lastVisitType = lastVisitType;
	}

	public int getCfVisitNum() {
		return this.cfVisitNum;
	}

	public void setCfVisitNum(int cfVisitNum) {
		this.cfVisitNum = cfVisitNum;
	}

	public int getNumChildren() {
		return this.numChildren;
	}

	public void setNumChildren(int numChildren) {
		this.numChildren = numChildren;
	}

	public String getPlayCompFeedingVid() {
		return this.playCompFeedingVid;
	}

	public void setPlayCompFeedingVid(String playCompFeedingVid) {
		this.playCompFeedingVid = playCompFeedingVid;
	}

	public String getLastvisit() {
		return this.lastvisit;
	}

	public void setLastvisit(String lastvisit) {
		this.lastvisit = lastvisit;
	}

	public DateTime getDateCf7() {
		return this.dateCf7;
	}

	public void setDateCf7(DateTime dateCf7) {
		this.dateCf7 = dateCf7;
	}

	public String getConfirmClose() {
		return this.confirmClose;
	}

	public void setConfirmClose(String confirmClose) {
		this.confirmClose = confirmClose;
	}

	public Boolean getClose() {
		return this.close;
	}

	public void setClose(Boolean close) {
		this.close = close;
	}

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

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getInvalidGroupsTransfer() {
		return invalidGroupsTransfer;
	}

	public void setInvalidGroupsTransfer(String invalidGroupsTransfer) {
		this.invalidGroupsTransfer = invalidGroupsTransfer;
	}

	public String getNewOwner() {
		return newOwner;
	}

	public void setNewOwner(String newOwner) {
		this.newOwner = newOwner;
	}
}
