package org.motechproject.care.reporting.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.care.reporting.domain.dimension.ChildCase;
import org.motechproject.care.reporting.domain.dimension.Flw;
import org.motechproject.care.reporting.utils.FormToString;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;


@Entity(name = "close_child_form")
@Unique(members = {"instance_id","case_id"})
public class CloseChildForm extends Form {

	 private Flw flw;
	private ChildCase childCase;
	private DateTime timeEnd;
	private DateTime timeStart;
	private DateTime dateModified;
	private String childAlive;
    private String closeChild;
    private String confirmClose;
    private DateTime dateDeath;
    private String died;
    private String diedVillage;
    private String dupeReg;
    private String finishedContinuum;
    private String siteDeath;
    private String placeDeath;
    private DateTime creationTime = new DateTime();
    private Boolean close;
    private String ownerId;

    public CloseChildForm() {
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
	public ChildCase getChildCase() {
		return this.childCase;
	}

	public void setChildCase(ChildCase childCase) {
		this.childCase = childCase;
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

    @Field(name = "close")
    public Boolean getClose() {
        return close;
    }

    public void setClose(Boolean close) {
        this.close = close;
    }


    @Field(name = "child_alive")
	public String getChildAlive() {
		return this.childAlive;
	}

	public void setChildAlive(String childAlive) {
		this.childAlive = childAlive;
	}

	@Field(name = "close_child")
	public String getCloseChild() {
		return this.closeChild;
	}

	public void setCloseChild(String closeChild) {
		this.closeChild = closeChild;
	}

	@Field(name = "confirm_close")
	public String getConfirmClose() {
		return this.confirmClose;
	}

	public void setConfirmClose(String confirmClose) {
		this.confirmClose = confirmClose;
	}

	
	@Field(name = "date_death")
	public DateTime getDateDeath() {
		return this.dateDeath;
	}

	public void setDateDeath(DateTime dateDeath) {
		this.dateDeath = dateDeath;
	}

	@Field(name = "died")
	public String getDied() {
		return this.died;
	}

	public void setDied(String died) {
		this.died = died;
	}

	@Field(name = "died_village")
	public String getDiedVillage() {
		return this.diedVillage;
	}

	public void setDiedVillage(String diedVillage) {
		this.diedVillage = diedVillage;
	}

	@Field(name = "dupe_reg")
	public String getDupeReg() {
		return this.dupeReg;
	}

	public void setDupeReg(String dupeReg) {
		this.dupeReg = dupeReg;
	}

	@Field(name = "finished_continuum")
	public String getFinishedContinuum() {
		return this.finishedContinuum;
	}

	public void setFinishedContinuum(String finishedContinuum) {
		this.finishedContinuum = finishedContinuum;
	}

	@Field(name = "site_death")
	public String getSiteDeath() {
		return this.siteDeath;
	}

	public void setSiteDeath(String siteDeath) {
		this.siteDeath = siteDeath;
	}

	@Field(name = "place_death")
	public String getPlaceDeath() {
		return this.placeDeath;
	}

	public void setPlaceDeath(String placeDeath) {
		this.placeDeath = placeDeath;
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
}
