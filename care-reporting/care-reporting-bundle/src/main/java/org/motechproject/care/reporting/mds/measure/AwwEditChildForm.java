package org.motechproject.care.reporting.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.care.reporting.mds.dimension.ChildCase;
import org.motechproject.care.reporting.mds.dimension.Flw;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(name = "aww_edit_child_form")
@Unique(members = "instance_id")
public class AwwEditChildForm extends Form {

	 private Flw flw;
	private ChildCase childCase;
	private DateTime timeStart;
	private DateTime timeEnd;
	private DateTime dateModified;
	private DateTime creationTime = new DateTime();
	String updateChildName;
	String newChildName;
	String updateChildDob;
	DateTime newChildDob;
	String success;

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

	@Field(name = "update_child_name")
	public String getUpdateChildName() {
		return updateChildName;
	}

	public void setUpdateChildName(String updateChildName) {
		this.updateChildName = updateChildName;
	}

	@Field(name = "new_child_name")
	public String getNewChildName() {
		return newChildName;
	}

	public void setNewChildName(String newChildName) {
		this.newChildName = newChildName;
	}

	@Field(name = "update_child_dob")
	public String getUpdateChildDob() {
		return updateChildDob;
	}

	public void setUpdateChildDob(String updateChildDob) {
		this.updateChildDob = updateChildDob;
	}

	
	@Field(name = "new_child_dob")
	public DateTime getNewChildDob() {
		return newChildDob;
	}

	public void setNewChildDob(DateTime newChildDob) {
		this.newChildDob = newChildDob;
	}

	@Field(name = "success")
	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}
}
