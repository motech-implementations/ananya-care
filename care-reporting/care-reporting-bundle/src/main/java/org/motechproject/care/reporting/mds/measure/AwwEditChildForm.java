package org.motechproject.care.reporting.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.dimension.Flw;
import org.motechproject.mcts.care.common.mds.measure.Form;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(name = "aww_edit_child_form")
@Unique(members = "instance_id")
public class AwwEditChildForm extends Form {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7234394038533535579L;
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
	private String updateChildName;
	@Field
	private String newChildName;
	@Field
	private String updateChildDob;
	@Field
	private DateTime newChildDob;
	@Field
	private String success;

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

	public String getUpdateChildName() {
		return updateChildName;
	}

	public void setUpdateChildName(String updateChildName) {
		this.updateChildName = updateChildName;
	}

	public String getNewChildName() {
		return newChildName;
	}

	public void setNewChildName(String newChildName) {
		this.newChildName = newChildName;
	}

	public String getUpdateChildDob() {
		return updateChildDob;
	}

	public void setUpdateChildDob(String updateChildDob) {
		this.updateChildDob = updateChildDob;
	}

	public DateTime getNewChildDob() {
		return newChildDob;
	}

	public void setNewChildDob(DateTime newChildDob) {
		this.newChildDob = newChildDob;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}
}
