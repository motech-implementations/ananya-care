package org.motechproject.care.reporting.domain.measure;

import org.hibernate.annotations.Cascade;
import org.motechproject.care.reporting.domain.dimension.Flw;
import org.motechproject.care.reporting.domain.dimension.MotherCase;
import org.motechproject.care.reporting.utils.FormToString;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "close_mother_form", uniqueConstraints = @UniqueConstraint(columnNames = "instance_id"))
public class CloseMotherForm extends Form {

	private int id;
	private Flw flw;
	private MotherCase motherCase;
	private Date timeEnd;
	private Date timeStart;
	private Date dateModified;
    private Boolean closeMother;
    private Boolean confirmClose;
    private Boolean deathVillage;
    private String diedVillage;
    private String placeDeath;
    private Boolean dupeReg;
    private Boolean finishedContinuum;
    private Short numChildren;
    private Boolean motherAlive;
    private Boolean moved;
    private Boolean migrated;
    private Date dateLearned;
    private Date dateLeft;
    private Boolean migrationNote;
    private Boolean died;
    private Date dateDeath;
    private String siteDeath;
    private String status;
    private Date creationTime = new Date();
    private Boolean close;


    public CloseMotherForm() {
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	public Flw getFlw() {
		return this.flw;
	}

	public void setFlw(Flw flw) {
		this.flw = flw;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "case_id")
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	public MotherCase getMotherCase() {
		return this.motherCase;
	}

	public void setMotherCase(MotherCase motherCase) {
		this.motherCase = motherCase;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time_end")
	public Date getTimeEnd() {
		return this.timeEnd;
	}

	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time_start")
	public Date getTimeStart() {
		return this.timeStart;
	}

	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_modified")
	public Date getDateModified() {
		return this.dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}


    @Column(name = "close_mother")
	public Boolean getCloseMother() {
		return this.closeMother;
	}

	public void setCloseMother(Boolean closeMother) {
		this.closeMother = closeMother;
	}

	@Column(name = "confirm_close")
	public Boolean getConfirmClose() {
		return this.confirmClose;
	}

	public void setConfirmClose(Boolean confirmClose) {
		this.confirmClose = confirmClose;
	}

	@Column(name = "death_village")
	public Boolean getDeathVillage() {
		return this.deathVillage;
	}

	public void setDeathVillage(Boolean deathVillage) {
		this.deathVillage = deathVillage;
	}

	@Column(name = "died_village")
	public String getDiedVillage() {
		return this.diedVillage;
	}

	public void setDiedVillage(String diedVillage) {
		this.diedVillage = diedVillage;
	}	
    
    @Column(name = "place_death")
	public String getPlaceDeath() {
		return this.placeDeath;
	}

	public void setPlaceDeath(String placeDeath) {
		this.placeDeath = placeDeath;
	}

	@Column(name = "dupe_reg")
	public Boolean getDupeReg() {
		return this.dupeReg;
	}

	public void setDupeReg(Boolean dupeReg) {
		this.dupeReg = dupeReg;
	}

	@Column(name = "finished_continuum")
	public Boolean getFinishedContinuum() {
		return this.finishedContinuum;
	}

	public void setFinishedContinuum(Boolean finishedContinuum) {
		this.finishedContinuum = finishedContinuum;
	}

	@Column(name = "num_children")
	public Short getNumChildren() {
		return this.numChildren;
	}

	public void setNumChildren(Short numChildren) {
		this.numChildren = numChildren;
	}

	@Column(name = "mother_alive")
	public Boolean getMotherAlive() {
		return this.motherAlive;
	}

	public void setMotherAlive(Boolean motherAlive) {
		this.motherAlive = motherAlive;
	}

	@Column(name = "moved")
	public Boolean getMoved() {
		return this.moved;
	}

	public void setMoved(Boolean moved) {
		this.moved = moved;
	}

	@Column(name = "migrated")
	public Boolean getMigrated() {
		return this.migrated;
	}

	public void setMigrated(Boolean migrated) {
		this.migrated = migrated;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_learned")
	public Date getDateLearned() {
		return this.dateLearned;
	}

	public void setDateLearned(Date dateLearned) {
		this.dateLearned = dateLearned;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_left")
	public Date getDateLeft() {
		return this.dateLeft;
	}

	public void setDateLeft(Date dateLeft) {
		this.dateLeft = dateLeft;
	}

	@Column(name = "migration_note")
	public Boolean getMigrationNote() {
		return this.migrationNote;
	}

	public void setMigrationNote(Boolean migrationNote) {
		this.migrationNote = migrationNote;
	}

	@Column(name = "died")
	public Boolean getDied() {
		return this.died;
	}

	public void setDied(Boolean died) {
		this.died = died;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_death")
	public Date getDateDeath() {
		return this.dateDeath;
	}

	public void setDateDeath(Date dateDeath) {
		this.dateDeath = dateDeath;
	}

	@Column(name = "site_death")
	public String getSiteDeath() {
		return this.siteDeath;
	}

	public void setSiteDeath(String siteDeath) {
		this.siteDeath = siteDeath;
	}

    @Column(name = "status")
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "close")
    public Boolean getClose() {
        return this.close;
    }

    public void setClose(Boolean close) {
        this.close = close;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_time")
    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public String toString() {
        return FormToString.toString(this);
    }


}
