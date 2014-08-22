package org.motechproject.care.reporting.mds.measure;

import org.joda.time.DateTime;

import javax.jdo.annotations.Unique;

import org.motechproject.care.reporting.mds.dimension.Flw;
import org.motechproject.care.reporting.mds.dimension.MotherCase;
import org.motechproject.care.reporting.utils.FormToString;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;


@Entity(name = "ui_mother_form")
@Unique(members = "instance_id")
public class UiMotherForm extends Form {

	@Field(name = "user_id")
    @Cascade(persist = true, update = true, delete = false)
	private Flw flw;
	@Field(name = "case_id")
    @Cascade(persist = true, update = true, delete = false)
	private MotherCase motherCase;
	@Field(name = "time_end")
	private DateTime timeEnd;
	@Field(name = "time_start")
	private DateTime timeStart;
	@Field(name = "date_modified")
	private DateTime dateModified;
	@Field(name = "details_available")
	private String detailsAvailable;
	@Field(name = "tt_1_date")
	private DateTime tt1Date;
	@Field(name = "tt_2_date")
	private DateTime tt2Date;
	@Field(name = "tt_booster_date")
	private DateTime ttBoosterDate;
	@Field(name = "received_tt1")
	private String receivedTt1;
	@Field(name = "received_tt2")
	private String receivedTt2;
	@Field(name = "up_to_date")
	private String upToDate;
	@Field(name = "num_children")
	private int numChildren;
	@Field(name = "update_mother")
	private String updateMother;
	@Field(name = "tt_booster")
	private String ttBooster;
    @Field(name = "creation_time")
	private DateTime creationTime = new DateTime();

    public UiMotherForm() {
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

	public String getDetailsAvailable() {
		return this.detailsAvailable;
	}

	public void setDetailsAvailable(String detailsAvailable) {
		this.detailsAvailable = detailsAvailable;
	}

	public DateTime getTt1DateTime() {
		return this.tt1Date;
	}

	public void setTt1Date(DateTime tt1Date) {
		this.tt1Date = tt1Date;
	}

	public DateTime getTt2DateTime() {
		return this.tt2Date;
	}

	public void setTt2Date(DateTime tt2Date) {
		this.tt2Date = tt2Date;
	}

	public DateTime getTtBoosterDateTime() {
		return this.ttBoosterDate;
	}

	public void setTtBoosterDate(DateTime ttBoosterDate) {
		this.ttBoosterDate = ttBoosterDate;
	}

	public String getReceivedTt1() {
		return this.receivedTt1;
	}

	public void setReceivedTt1(String receivedTt1) {
		this.receivedTt1 = receivedTt1;
	}

	public String getReceivedTt2() {
		return this.receivedTt2;
	}

	public void setReceivedTt2(String receivedTt2) {
		this.receivedTt2 = receivedTt2;
	}

	public String getUpToDateTime() {
		return this.upToDate;
	}

	public void setUpToDate(String upToDate) {
		this.upToDate = upToDate;
	}

	public int getNumChildren() {
		return this.numChildren;
	}

	public void setNumChildren(int numChildren) {
		this.numChildren = numChildren;
	}

	public String getUpdateMother() {
		return this.updateMother;
	}

	public void setUpdateMother(String updateMother) {
		this.updateMother = updateMother;
	}

	public String getTtBooster() {
		return this.ttBooster;
	}

	public void setTtBooster(String ttBooster) {
		this.ttBooster = ttBooster;
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
}
