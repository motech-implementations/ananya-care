package org.motechproject.care.reporting.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.care.reporting.mds.dimension.ChildCase;
import org.motechproject.care.reporting.mds.dimension.Flw;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;


@Entity(name = "aww_close_child_form")
@Unique(members = {"instance_id","case_id"})
public class AwwCloseChildForm extends Form {

    private int id;
    private ChildCase childCase;
    private Flw flw;
    private DateTime timeEnd;
    private DateTime timeStart;
    private DateTime dateModified;
    private DateTime creationTime = new DateTime();
    private String closeChild;
    private String childOverSix;
    private String dupeReg;
    private String died;
    private DateTime dateDeath;
    private String siteDeath;
    private String diedVillage;
    private String placeDeath;
    private String confirmClose;
    private String yesClosedMessage;
    private String noClosedMessage;
    private String childAlive;
    private String success;
    private String childName;
    private DateTime dob;
    private String closeChildCase;

    public AwwCloseChildForm() {

    }
    
    @Field(name = "case_id")
     @Cascade(persist = true, update = true, delete = false)
    public ChildCase getChildCase() {
        return this.childCase;
    }

    public void setChildCase(ChildCase childCase) {
        this.childCase = childCase;
    }

    
    @Field(name = "user_id")
     @Cascade(persist = true, update = true, delete = false)
    public Flw getFlw() {
        return this.flw;
    }

    public void setFlw(Flw flw) {
        this.flw = flw;
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

    
    @Field(name = "creation_time")
    public DateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(DateTime creationTime) {
        this.creationTime = creationTime;
    }

    @Field(name = "close_child")
    public String getCloseChild() {
        return closeChild;
    }

    public void setCloseChild(String closeChild) {
        this.closeChild = closeChild;
    }

    @Field(name = "child_over_six")
    public String getChildOverSix() {
        return childOverSix;
    }

    public void setChildOverSix(String childOverSix) {
        this.childOverSix = childOverSix;
    }

    @Field(name = "dupe_reg")
    public String getDupeReg() {
        return dupeReg;
    }

    public void setDupeReg(String dupeReg) {
        this.dupeReg = dupeReg;
    }

    @Field(name = "died")
    public String getDied() {
        return died;
    }

    public void setDied(String died) {
        this.died = died;
    }

    @Field(name = "date_death")
    public DateTime getDateDeath() {
        return dateDeath;
    }

    public void setDateDeath(DateTime dateDeath) {
        this.dateDeath = dateDeath;
    }

    @Field(name = "site_death")
    public String getSiteDeath() {
        return siteDeath;
    }

    public void setSiteDeath(String siteDeath) {
        this.siteDeath = siteDeath;
    }

    @Field(name = "died_village")
    public String getDiedVillage() {
        return diedVillage;
    }

    public void setDiedVillage(String diedVillage) {
        this.diedVillage = diedVillage;
    }

    @Field(name = "place_death")
    public String getPlaceDeath() {
        return placeDeath;
    }

    public void setPlaceDeath(String placeDeath) {
        this.placeDeath = placeDeath;
    }

    @Field(name = "confirm_close")
    public String getConfirmClose() {
        return confirmClose;
    }

    public void setConfirmClose(String confirmClose) {
        this.confirmClose = confirmClose;
    }

    @Field(name = "yes_closed_message")
    public String getYesClosedMessage() {
        return yesClosedMessage;
    }

    public void setYesClosedMessage(String yesClosedMessage) {
        this.yesClosedMessage = yesClosedMessage;
    }

    @Field(name = "no_closed_message")
    public String getNoClosedMessage() {
        return noClosedMessage;
    }

    public void setNoClosedMessage(String noClosedMessage) {
        this.noClosedMessage = noClosedMessage;
    }

    @Field(name = "child_alive")
    public String getChildAlive() {
        return childAlive;
    }

    public void setChildAlive(String childAlive) {
        this.childAlive = childAlive;
    }

    @Field(name = "success")
    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    @Field(name = "child_name")
    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    @Field(name = "dob")
    public DateTime getDob() {
        return dob;
    }

    public void setDob(DateTime dob) {
        this.dob = dob;
    }

    @Field(name = "close_child_case")
    public String getCloseChildCase() {
        return closeChildCase;
    }

    public void setCloseChildCase(String closeChildCase) {
        this.closeChildCase = closeChildCase;
    }
}
