package org.motechproject.care.reporting.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.care.reporting.mds.dimension.Flw;
import org.motechproject.care.reporting.mds.dimension.MotherCase;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(name = "aww_thr_mother_form")
@Unique(members = "instance_id")
public class AwwThrMotherForm extends Form {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7383146887354226913L;
	@Field
	@Cascade(persist = true, update = true, delete = false)
	private MotherCase motherCase;
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
	private DateTime creationTime = new DateTime();
	@Field
	private String collectRation;
	@Field
	private String distributeRation;
	@Field
	private Integer daysRationGiven;
	@Field
	private String causeNotGiven;
	@Field
	private String success;
	@Field
	private String addval;
	@Field
	private String motherRations;
	@Field
	private String motherName;

	public AwwThrMotherForm() {

	}

	public MotherCase getMotherCase() {
		return this.motherCase;
	}

	public void setMotherCase(MotherCase motherCase) {
		this.motherCase = motherCase;
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

	public String getCollectRation() {
		return collectRation;
	}

	public void setCollectRation(String collectRation) {
		this.collectRation = collectRation;
	}

	public String getDistributeRation() {
		return distributeRation;
	}

	public void setDistributeRation(String distributeRation) {
		this.distributeRation = distributeRation;
	}

	public Integer getDaysRationGiven() {
		return daysRationGiven;
	}

	public void setDaysRationGiven(Integer daysRationGiven) {
		this.daysRationGiven = daysRationGiven;
	}

	public String getCauseNotGiven() {
		return causeNotGiven;
	}

	public void setCauseNotGiven(String causeNotGiven) {
		this.causeNotGiven = causeNotGiven;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getAddval() {
		return addval;
	}

	public void setAddval(String addval) {
		this.addval = addval;
	}

	public String getMotherRations() {
		return motherRations;
	}

	public void setMotherRations(String motherRations) {
		this.motherRations = motherRations;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
}
