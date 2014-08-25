package org.motechproject.care.reporting.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.care.reporting.mds.dimension.Flw;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(name = "aww_preschool_activities_form")
@Unique(members = "instance_id")
public class AwwPreschoolActivitiesForm extends Form {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8990103902947600674L;
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
	private String menu;
	@Field
	private String activity;
	@Field
	private String success;
	@Field
	private Integer numChildren;
	@Field
	private String childIds;

	public AwwPreschoolActivitiesForm() {

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

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public Integer getNumChildren() {
		return numChildren;
	}

	public void setNumChildren(Integer numChildren) {
		this.numChildren = numChildren;
	}

	public String getChildIds() {
		return childIds;
	}

	public void setChildIds(String childIds) {
		this.childIds = childIds;
	}
}
