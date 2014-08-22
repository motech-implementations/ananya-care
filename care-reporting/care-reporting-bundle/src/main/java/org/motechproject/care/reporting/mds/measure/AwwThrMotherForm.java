package org.motechproject.care.reporting.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.care.reporting.mds.dimension.Flw;
import org.motechproject.care.reporting.mds.dimension.MotherCase;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(name = "aww_thr_mother_form")@Unique(members = "instance_id")
public class AwwThrMotherForm extends Form {

    private Integer id;
    private MotherCase motherCase;
    private Flw flw;
    private DateTime dateModified;
    private DateTime timeStart;
    private DateTime timeEnd;
    private DateTime creationTime = new DateTime();
    private String collectRation;
    private String distributeRation;
    private Integer daysRationGiven;
    private String causeNotGiven;
    private String success;
    private String addval;
    private String motherRations;
    private String motherName;

    public AwwThrMotherForm() {

    }

    @Field(name = "case_id")
     @Cascade(persist = true, update = true, delete = false)
    public MotherCase getMotherCase() {
        return this.motherCase;
    }

    public void setMotherCase(MotherCase motherCase) {
        this.motherCase = motherCase;
    }

    
    @Field(name = "user_id")
    @Cascade(persist = true, update = true, delete = false)
    public Flw getFlw() {
        return this.flw;
    }

    public void setFlw(Flw flw) {
        this.flw = flw;
    }

     
    @Field(name = "date_modified")
    public DateTime getDateModified() {
        return dateModified;
    }

    public void setDateModified(DateTime dateModified) {
        this.dateModified = dateModified;
    }

     
    @Field(name = "time_start")
    public DateTime getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(DateTime timeStart) {
        this.timeStart = timeStart;
    }

     
    @Field(name = "time_end")
    public DateTime getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(DateTime timeEnd) {
        this.timeEnd = timeEnd;
    }

     
    @Field(name = "creation_time")
    public DateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(DateTime creationTime) {
        this.creationTime = creationTime;
    }

    @Field(name = "collect_ration")
    public String getCollectRation() {
        return collectRation;
    }

    public void setCollectRation(String collectRation) {
        this.collectRation = collectRation;
    }

    @Field(name = "distribute_ration")
    public String getDistributeRation() {
        return distributeRation;
    }

    public void setDistributeRation(String distributeRation) {
        this.distributeRation = distributeRation;
    }

    @Field(name = "days_ration_given")
    public Integer getDaysRationGiven() {
        return daysRationGiven;
    }

    public void setDaysRationGiven(Integer daysRationGiven) {
        this.daysRationGiven = daysRationGiven;
    }

    @Field(name = "cause_not_given")
    public String getCauseNotGiven() {
        return causeNotGiven;
    }

    public void setCauseNotGiven(String causeNotGiven) {
        this.causeNotGiven = causeNotGiven;
    }

    @Field(name = "success")
    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    @Field(name = "addval")
    public String getAddval() {
        return addval;
    }

    public void setAddval(String addval) {
        this.addval = addval;
    }

    @Field(name = "mother_rations")
    public String getMotherRations() {
        return motherRations;
    }

    public void setMotherRations(String motherRations) {
        this.motherRations = motherRations;
    }

    @Field(name = "mother_name")
    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }
}
