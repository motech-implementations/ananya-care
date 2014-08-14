package org.motechproject.care.reporting.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.care.reporting.domain.dimension.Flw;
import org.motechproject.care.reporting.domain.dimension.MotherCase;
import org.motechproject.care.reporting.utils.FormToString;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;


@Entity(name = "close_mother_form")
@Unique(members = "instance_id")
public class CloseMotherForm extends Form {

	 private Flw flw;
	private MotherCase motherCase;
	private DateTime timeEnd;
	private DateTime timeStart;
	private DateTime dateModified;
    private String closeMother;
    private String confirmClose;
    private String deathVillage;
    private String diedVillage;
    private String placeDeath;
    private String dupeReg;
    private String finishedContinuum;
    private Short numChildren;
    private String motherAlive;
    private String moved;
    private String migrated;
    private DateTime dateLearned;
    private DateTime dateLeft;
    private String migrationNote;
    private String died;
    private DateTime dateDeath;
    private String siteDeath;
    private String status;
    private DateTime creationTime = new DateTime();
    private Boolean close;
    private String ownerId;
    private String confirmTransfer;
    private String invalidGroupsTransfer;
    private String newOwner;

    public CloseMotherForm() {
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


    @Field(name = "close_mother")
	public String getCloseMother() {
		return this.closeMother;
	}

	public void setCloseMother(String closeMother) {
		this.closeMother = closeMother;
	}

	@Field(name = "confirm_close")
	public String getConfirmClose() {
		return this.confirmClose;
	}

	public void setConfirmClose(String confirmClose) {
		this.confirmClose = confirmClose;
	}

	@Field(name = "death_village")
	public String getDeathVillage() {
		return this.deathVillage;
	}

	public void setDeathVillage(String deathVillage) {
		this.deathVillage = deathVillage;
	}

	@Field(name = "died_village")
	public String getDiedVillage() {
		return this.diedVillage;
	}

	public void setDiedVillage(String diedVillage) {
		this.diedVillage = diedVillage;
	}	
    
    @Field(name = "place_death")
	public String getPlaceDeath() {
		return this.placeDeath;
	}

	public void setPlaceDeath(String placeDeath) {
		this.placeDeath = placeDeath;
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

	@Field(name = "num_children")
	public Short getNumChildren() {
		return this.numChildren;
	}

	public void setNumChildren(Short numChildren) {
		this.numChildren = numChildren;
	}

	@Field(name = "mother_alive")
	public String getMotherAlive() {
		return this.motherAlive;
	}

	public void setMotherAlive(String motherAlive) {
		this.motherAlive = motherAlive;
	}

	@Field(name = "moved")
	public String getMoved() {
		return this.moved;
	}

	public void setMoved(String moved) {
		this.moved = moved;
	}

	@Field(name = "migrated")
	public String getMigrated() {
		return this.migrated;
	}

	public void setMigrated(String migrated) {
		this.migrated = migrated;
	}

	
	@Field(name = "date_learned")
	public DateTime getDateLearned() {
		return this.dateLearned;
	}

	public void setDateLearned(DateTime dateLearned) {
		this.dateLearned = dateLearned;
	}

	
	@Field(name = "date_left")
	public DateTime getDateLeft() {
		return this.dateLeft;
	}

	public void setDateLeft(DateTime dateLeft) {
		this.dateLeft = dateLeft;
	}

	@Field(name = "migration_note")
	public String getMigrationNote() {
		return this.migrationNote;
	}

	public void setMigrationNote(String migrationNote) {
		this.migrationNote = migrationNote;
	}

	@Field(name = "died")
	public String getDied() {
		return this.died;
	}

	public void setDied(String died) {
		this.died = died;
	}

	
	@Field(name = "date_death")
	public DateTime getDateDeath() {
		return this.dateDeath;
	}

	public void setDateDeath(DateTime dateDeath) {
		this.dateDeath = dateDeath;
	}

	@Field(name = "site_death")
	public String getSiteDeath() {
		return this.siteDeath;
	}

	public void setSiteDeath(String siteDeath) {
		this.siteDeath = siteDeath;
	}

    @Field(name = "status")
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    @Field(name = "confirm_transfer")
    public String getConfirmTransfer() {
        return confirmTransfer;
    }

    public void setConfirmTransfer(String confirmTransfer) {
        this.confirmTransfer = confirmTransfer;
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
