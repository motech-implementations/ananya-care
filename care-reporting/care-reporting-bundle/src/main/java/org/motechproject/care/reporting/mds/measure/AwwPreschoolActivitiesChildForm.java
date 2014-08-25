package org.motechproject.care.reporting.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.care.reporting.mds.dimension.ChildCase;
import org.motechproject.care.reporting.mds.dimension.Flw;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(name = "aww_preschool_activities_child_form")
@Unique(members = { "instance_id", "case_id" })
public class AwwPreschoolActivitiesChildForm extends Form {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2958896328819030338L;
	@Field
	@Cascade(persist = true, update = true, delete = false)
	private AwwPreschoolActivitiesForm form;
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
	private DateTime creationTime = new DateTime();
	@Field
	private String caseId;
	@Field
	private String childAttend;
	@Field
	private String breakfast;
	@Field
	private String participated;
	@Field
	private String lunch;

	public AwwPreschoolActivitiesChildForm() {

	}

	public AwwPreschoolActivitiesForm getForm() {
		return form;
	}

	public void setForm(AwwPreschoolActivitiesForm form) {
		this.form = form;
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

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getChildAttend() {
		return childAttend;
	}

	public void setChildAttend(String childAttend) {
		this.childAttend = childAttend;
	}

	public String getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(String breakfast) {
		this.breakfast = breakfast;
	}

	public String getParticipated() {
		return participated;
	}

	public void setParticipated(String participated) {
		this.participated = participated;
	}

	public String getLunch() {
		return lunch;
	}

	public void setLunch(String lunch) {
		this.lunch = lunch;
	}
}
