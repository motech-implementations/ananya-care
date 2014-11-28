package org.motechproject.mcts.care.common.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.mcts.care.common.mds.dimension.Flw;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
import org.motechproject.mcts.care.common.utils.FormToString;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(name = "close_mother_form")
@Unique(members = "instanceId")
public class CloseMotherForm extends Form {

    private static final long serialVersionUID = 58862069553048667L;

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
    private int numChildren;
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
    public String getCloseMother() {
        return this.closeMother;
    }

    public void setCloseMother(String closeMother) {
        this.closeMother = closeMother;
    }

    @Field
    public String getConfirmClose() {
        return this.confirmClose;
    }

    public void setConfirmClose(String confirmClose) {
        this.confirmClose = confirmClose;
    }

    @Field
    public String getDeathVillage() {
        return this.deathVillage;
    }

    public void setDeathVillage(String deathVillage) {
        this.deathVillage = deathVillage;
    }

    @Field
    public String getDiedVillage() {
        return this.diedVillage;
    }

    public void setDiedVillage(String diedVillage) {
        this.diedVillage = diedVillage;
    }

    @Field
    public String getPlaceDeath() {
        return this.placeDeath;
    }

    public void setPlaceDeath(String placeDeath) {
        this.placeDeath = placeDeath;
    }

    @Field
    public String getDupeReg() {
        return this.dupeReg;
    }

    public void setDupeReg(String dupeReg) {
        this.dupeReg = dupeReg;
    }

    @Field
    public String getFinishedContinuum() {
        return this.finishedContinuum;
    }

    public void setFinishedContinuum(String finishedContinuum) {
        this.finishedContinuum = finishedContinuum;
    }

    @Field
    public int getNumChildren() {
        return this.numChildren;
    }

    public void setNumChildren(int numChildren) {
        this.numChildren = numChildren;
    }

    @Field
    public String getMotherAlive() {
        return this.motherAlive;
    }

    public void setMotherAlive(String motherAlive) {
        this.motherAlive = motherAlive;
    }

    @Field
    public String getMoved() {
        return this.moved;
    }

    public void setMoved(String moved) {
        this.moved = moved;
    }

    @Field
    public String getMigrated() {
        return this.migrated;
    }

    public void setMigrated(String migrated) {
        this.migrated = migrated;
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
    public String getMigrationNote() {
        return this.migrationNote;
    }

    public void setMigrationNote(String migrationNote) {
        this.migrationNote = migrationNote;
    }

    @Field
    public String getDied() {
        return this.died;
    }

    public void setDied(String died) {
        this.died = died;
    }

    @Field
    public DateTime getDateDeath() {
        return this.dateDeath;
    }

    public void setDateDeath(DateTime dateDeath) {
        this.dateDeath = dateDeath;
    }

    @Field
    public String getSiteDeath() {
        return this.siteDeath;
    }

    public void setSiteDeath(String siteDeath) {
        this.siteDeath = siteDeath;
    }

    @Field
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Field
    public Boolean getClose() {
        return this.close;
    }

    public void setClose(Boolean close) {
        this.close = close;
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

    @Field
    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    @Field
    public String getConfirmTransfer() {
        return confirmTransfer;
    }

    public void setConfirmTransfer(String confirmTransfer) {
        this.confirmTransfer = confirmTransfer;
    }

    @Field
    public String getInvalidGroupsTransfer() {
        return invalidGroupsTransfer;
    }

    public void setInvalidGroupsTransfer(String invalidGroupsTransfer) {
        this.invalidGroupsTransfer = invalidGroupsTransfer;
    }

    @Field
    public String getNewOwner() {
        return newOwner;
    }

    public void setNewOwner(String newOwner) {
        this.newOwner = newOwner;
    }
}
