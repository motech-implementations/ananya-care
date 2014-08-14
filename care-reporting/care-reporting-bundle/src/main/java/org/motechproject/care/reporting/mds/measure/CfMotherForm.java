package org.motechproject.care.reporting.mds.measure;


import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.care.reporting.domain.dimension.Flw;
import org.motechproject.care.reporting.domain.dimension.MotherCase;
import org.motechproject.care.reporting.utils.FormToString;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;


@Entity(name = "cf_mother_form")
@Unique(members = "instance_id")
public class CfMotherForm extends Form {

	 private Flw flw;
	private MotherCase motherCase;
	private DateTime timeEnd;
	private DateTime timeStart;
	private DateTime dateModified;
	private DateTime dateCf1;
	private DateTime dateCf2;
	private DateTime dateCf3;
	private DateTime dateCf4;
	private DateTime dateCf5;
	private DateTime dateCf6;
	private DateTime dateLastVisit;
	private DateTime dateNextCf;
	private String lastVisitType;
	private Short cfVisitNum;
    private Short numChildren;
	private String playCompFeedingVid;
	private String lastvisit;
	private DateTime dateCf7;
	private String confirmClose;
    private Boolean close;
    private DateTime creationTime = new DateTime();
    private String ownerId;
    private String invalidGroupsTransfer;
    private String newOwner;

    public CfMotherForm() {
	}
	
	@Field(name = "user_id")
    @Cascade(persist = true, update = true, delete = false)
	public Flw getFlw() {
		return this.flw;
	}

	public void setFlw(Flw flw) {
		this.flw = flw;
	}

	
	@Field(name = "case_id")
    @Cascade(persist = true, update = true, delete = false)
	public MotherCase getMotherCase() {
		return this.motherCase;
	}

	public void setMotherCase(MotherCase motherCase) {
		this.motherCase = motherCase;
	}

	
	@Field(name = "time_end")
	public DateTime getTimeEnd() {
		return this.timeEnd;
	}

	public void setTimeEnd(DateTime timeEnd) {
		this.timeEnd = timeEnd;
	}

	
	@Field(name = "time_start")
	public DateTime getTimeStart() {
		return this.timeStart;
	}

	public void setTimeStart(DateTime timeStart) {
		this.timeStart = timeStart;
	}

	
	@Field(name = "date_modified")
	public DateTime getDateModified() {
		return this.dateModified;
	}

	public void setDateModified(DateTime dateModified) {
		this.dateModified = dateModified;
	}

	
	@Field(name = "date_cf_1")
	public DateTime getDateCf1() {
		return this.dateCf1;
	}

	public void setDateCf1(DateTime dateCf1) {
		this.dateCf1 = dateCf1;
	}

	
	@Field(name = "date_cf_2")
	public DateTime getDateCf2() {
		return this.dateCf2;
	}

	public void setDateCf2(DateTime dateCf2) {
		this.dateCf2 = dateCf2;
	}

	
	@Field(name = "date_cf_3")
	public DateTime getDateCf3() {
		return this.dateCf3;
	}

	public void setDateCf3(DateTime dateCf3) {
		this.dateCf3 = dateCf3;
	}

	
	@Field(name = "date_cf_4")
	public DateTime getDateCf4() {
		return this.dateCf4;
	}

	public void setDateCf4(DateTime dateCf4) {
		this.dateCf4 = dateCf4;
	}

	
	@Field(name = "date_cf_5")
	public DateTime getDateCf5() {
		return this.dateCf5;
	}

	public void setDateCf5(DateTime dateCf5) {
		this.dateCf5 = dateCf5;
	}

	
	@Field(name = "date_cf_6")
	public DateTime getDateCf6() {
		return this.dateCf6;
	}

	public void setDateCf6(DateTime dateCf6) {
		this.dateCf6 = dateCf6;
	}

	
	@Field(name = "date_last_visit")
	public DateTime getDateLastVisit() {
		return this.dateLastVisit;
	}

	public void setDateLastVisit(DateTime dateLastVisit) {
		this.dateLastVisit = dateLastVisit;
	}

	
	@Field(name = "date_next_cf")
	public DateTime getDateNextCf() {
		return this.dateNextCf;
	}

	public void setDateNextCf(DateTime dateNextCf) {
		this.dateNextCf = dateNextCf;
	}

	@Field(name = "last_visit_type")
	public String getLastVisitType() {
		return this.lastVisitType;
	}

	public void setLastVisitType(String lastVisitType) {
		this.lastVisitType = lastVisitType;
	}

	@Field(name = "cf_visit_num")
	public Short getCfVisitNum() {
		return this.cfVisitNum;
	}

	public void setCfVisitNum(Short cfVisitNum) {
		this.cfVisitNum = cfVisitNum;
	}

    @Field(name = "num_children")
	public Short getNumChildren() {
		return this.numChildren;
	}

	public void setNumChildren(Short numChildren) {
		this.numChildren = numChildren;
	}

	@Field(name = "play_comp_feeding_vid")
	public String getPlayCompFeedingVid() {
		return this.playCompFeedingVid;
	}

	public void setPlayCompFeedingVid(String playCompFeedingVid) {
		this.playCompFeedingVid = playCompFeedingVid;
	}

	@Field(name = "lastvisit")
	public String getLastvisit() {
		return this.lastvisit;
	}

	public void setLastvisit(String lastvisit) {
		this.lastvisit = lastvisit;
	}

	
	@Field(name = "date_cf_7")
	public DateTime getDateCf7() {
		return this.dateCf7;
	}

	public void setDateCf7(DateTime dateCf7) {
		this.dateCf7 = dateCf7;
	}

	@Field(name = "confirm_close")
	public String getConfirmClose() {
		return this.confirmClose;
	}

	public void setConfirmClose(String confirmClose) {
		this.confirmClose = confirmClose;
	}

    @Field(name = "close")
    public Boolean getClose() {
        return this.close;
    }

    public void setClose(Boolean close) {
        this.close = close;
    }

    
    @Field(name = "creation_time")
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

    @Field(name = "owner_id")
    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    @Field(name = "invalid_groups_transfer")
    public String getInvalidGroupsTransfer() {
        return invalidGroupsTransfer;
    }

    public void setInvalidGroupsTransfer(String invalidGroupsTransfer) {
        this.invalidGroupsTransfer = invalidGroupsTransfer;
    }

    @Field(name = "new_owner")
    public String getNewOwner() {
        return newOwner;
    }

    public void setNewOwner(String newOwner) {
        this.newOwner = newOwner;
    }
}
