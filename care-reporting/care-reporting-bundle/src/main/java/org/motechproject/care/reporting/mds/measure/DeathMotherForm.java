package org.motechproject.care.reporting.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.care.reporting.domain.dimension.Flw;
import org.motechproject.care.reporting.domain.dimension.MotherCase;
import org.motechproject.care.reporting.utils.FormToString;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;


@Entity(name = "death_mother_form")
@Unique(members = "instance_id")
public class DeathMotherForm extends Form {

	 private Flw flw;
	private MotherCase motherCase;
	private DateTime timeEnd;
	private DateTime timeStart;
	private DateTime dateModified;
	private String motherAlive;
	private String status;
	private Short castNumChildren;
    private DateTime dateDeath;
	private String deathVillage;
	private Short numChildren;
	private String placeDeath;
	private String siteDeath;
    private Boolean close;
    private DateTime creationTime = new DateTime();

    public DeathMotherForm() {
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

	@Field(name = "mother_alive")
	public String getMotherAlive() {
		return this.motherAlive;
	}

	public void setMotherAlive(String motherAlive) {
		this.motherAlive = motherAlive;
	}

	@Field(name = "status")
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Field(name = "cast_num_children")
	public Short getCastNumChildren() {
		return this.castNumChildren;
	}

	public void setCastNumChildren(Short castNumChildren) {
		this.castNumChildren = castNumChildren;
	}

    
	@Field(name = "date_death")
	public DateTime getDateDeath() {
		return this.dateDeath;
	}

	public void setDateDeath(DateTime dateDeath) {
		this.dateDeath = dateDeath;
	}

	@Field(name = "death_village")
	public String getDeathVillage() {
		return this.deathVillage;
	}

	public void setDeathVillage(String deathVillage) {
		this.deathVillage = deathVillage;
	}

	@Field(name = "num_children")
	public Short getNumChildren() {
		return this.numChildren;
	}

	public void setNumChildren(Short numChildren) {
		this.numChildren = numChildren;
	}

	@Field(name = "place_death")
	public String getPlaceDeath() {
		return this.placeDeath;
	}

	public void setPlaceDeath(String placeDeath) {
		this.placeDeath = placeDeath;
	}

	@Field(name = "site_death")
	public String getSiteDeath() {
		return this.siteDeath;
	}

	public void setSiteDeath(String siteDeath) {
		this.siteDeath = siteDeath;
	}

    
    @Field(name = "creation_time")
    public DateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(DateTime creationTime) {
        this.creationTime = creationTime;
    }

    @Field(name = "close")
    public Boolean getClose() {
        return close;
    }

    public void setClose(Boolean close) {
        this.close = close;
    }

    @Override
    public String toString() {
        return FormToString.toString(this);
    }
}
