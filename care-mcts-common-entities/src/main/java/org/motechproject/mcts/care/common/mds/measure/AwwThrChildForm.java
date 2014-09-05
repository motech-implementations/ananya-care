package org.motechproject.mcts.care.common.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.dimension.Flw;
import org.motechproject.mcts.care.common.mds.measure.Form;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(name = "aww_thr_child_form")
@Unique(members = "instanceId")
public class AwwThrChildForm extends Form {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2073998367169294335L;
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
	private String collectRation;
	@Field
	private String childDistributeRation;
	@Field
	private Integer childDaysRationGiven;
	@Field
	private String childAmountGiven;
	@Field
	private String childCauseNotGiven;
	@Field
	private String success;
	@Field
	private String childName;
	@Field
	private String motherName;

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

	public String getCollectRation() {
		return collectRation;
	}

	public void setCollectRation(String collectRation) {
		this.collectRation = collectRation;
	}

	public String getChildDistributeRation() {
		return childDistributeRation;
	}

	public void setChildDistributeRation(String childDistributeRation) {
		this.childDistributeRation = childDistributeRation;
	}

	public Integer getChildDaysRationGiven() {
		return childDaysRationGiven;
	}

	public void setChildDaysRationGiven(Integer childDaysRationGiven) {
		this.childDaysRationGiven = childDaysRationGiven;
	}

	public String getChildAmountGiven() {
		return childAmountGiven;
	}

	public void setChildAmountGiven(String childAmountGiven) {
		this.childAmountGiven = childAmountGiven;
	}

	public String getChildCauseNotGiven() {
		return childCauseNotGiven;
	}

	public void setChildCauseNotGiven(String childCauseNotGiven) {
		this.childCauseNotGiven = childCauseNotGiven;
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

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
}
