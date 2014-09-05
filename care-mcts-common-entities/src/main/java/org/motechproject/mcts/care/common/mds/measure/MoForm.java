package org.motechproject.mcts.care.common.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.mcts.care.common.mds.dimension.Flw;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
import org.motechproject.mcts.care.common.utils.FormToString;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;


@Entity(name = "mo_form")
@Unique(members = "instanceId")
public class MoForm extends Form {

	 private Flw flw;
	private MotherCase motherCase;
	private DateTime timeEnd;
	private DateTime timeStart;
	private DateTime dateModified;
	private DateTime migrateOutDate;
	private String migratedStatus;
	private String status;
	private DateTime dateLearned;
	private DateTime dateLeft;
	private String name;
	private String noteGiven;
    private DateTime creationTime = new DateTime();

    public MoForm() {
	}
    
    @Field
    @Cascade(persist = true, update = true, delete = false)
	public Flw getFlw() {
		return this.flw;
	}

	public void setFlw(Flw flw) {
		this.flw = flw;
	}

	
	@Field
    @Cascade(persist = true, update = true, delete = false)
	public MotherCase getMotherCase() {
		return this.motherCase;
	}

	public void setMotherCase(MotherCase motherCase) {
		this.motherCase = motherCase;
	}

	
	@Field
	public DateTime getTimeEnd() {
		return this.timeEnd;
	}

	public void setTimeEnd(DateTime timeEnd) {
		this.timeEnd = timeEnd;
	}

	
	@Field
	public DateTime getTimeStart() {
		return this.timeStart;
	}

	public void setTimeStart(DateTime timeStart) {
		this.timeStart = timeStart;
	}

	
	@Field
	public DateTime getDateModified() {
		return this.dateModified;
	}

	public void setDateModified(DateTime dateModified) {
		this.dateModified = dateModified;
	}

	
	@Field
	public DateTime getMigrateOutDateTime() {
		return this.migrateOutDate;
	}

	public void setMigrateOutDate(DateTime migrateOutDate) {
		this.migrateOutDate = migrateOutDate;
	}

	@Field
	public String getMigratedStatus() {
		return this.migratedStatus;
	}

	public void setMigratedStatus(String migratedStatus) {
		this.migratedStatus = migratedStatus;
	}

	@Field
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	@Field
	public DateTime getDateLearned() {
		return this.dateLearned;
	}

	public void setDateLearned(DateTime dateLearned) {
		this.dateLearned = dateLearned;
	}

	
	@Field
	public DateTime getDateLeft() {
		return this.dateLeft;
	}

	public void setDateLeft(DateTime dateLeft) {
		this.dateLeft = dateLeft;
	}

	@Field
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Field
	public String getNoteGiven() {
		return this.noteGiven;
	}

	public void setNoteGiven(String noteGiven) {
		this.noteGiven = noteGiven;
	}

    
    @Field
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
