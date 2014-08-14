package org.motechproject.care.reporting.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.care.reporting.domain.dimension.ChildCase;
import org.motechproject.care.reporting.domain.dimension.Flw;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(name = "aww_thr_child_form")
@Unique(members = "instance_id")
public class AwwThrChildForm extends Form {

    private int id;
    private Flw flw;
    private ChildCase childCase;
    private DateTime timeStart;
    private DateTime timeEnd;
    private DateTime dateModified;
    private DateTime creationTime = new DateTime();
    private String collectRation;
    private String childDistributeRation;
    private Integer childDaysRationGiven;
    private String childAmountGiven;
    private String childCauseNotGiven;
    private String success;
    private String childName;
    private String motherName;

    @Field(name = "user_id")
     @Cascade(persist = true, update = true, delete = false)
    public Flw getFlw() {
        return flw;
    }

    public void setFlw(Flw flw) {
        this.flw = flw;
    }
    
    @Field(name = "case_id")
     @Cascade(persist = true, update = true, delete = false)
    public ChildCase getChildCase() {
        return childCase;
    }

    public void setChildCase(ChildCase childCase) {
        this.childCase = childCase;
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

    
    @Field(name = "date_modified")
    public DateTime getDateModified() {
        return dateModified;
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

    @Field(name = "collect_ration")
    public String getCollectRation() {
        return collectRation;
    }

    public void setCollectRation(String collectRation) {
        this.collectRation = collectRation;
    }

    @Field(name = "child_distribute_ration")
    public String getChildDistributeRation() {
        return childDistributeRation;
    }

    public void setChildDistributeRation(String childDistributeRation) {
        this.childDistributeRation = childDistributeRation;
    }

    @Field(name = "child_days_ration_given")
    public Integer getChildDaysRationGiven() {
        return childDaysRationGiven;
    }

    public void setChildDaysRationGiven(Integer childDaysRationGiven) {
        this.childDaysRationGiven = childDaysRationGiven;
    }

    @Field(name = "child_amount_given")
    public String getChildAmountGiven() {
        return childAmountGiven;
    }

    public void setChildAmountGiven(String childAmountGiven) {
        this.childAmountGiven = childAmountGiven;
    }

    @Field(name = "child_cause_not_given")
    public String getChildCauseNotGiven() {
        return childCauseNotGiven;
    }

    public void setChildCauseNotGiven(String childCauseNotGiven) {
        this.childCauseNotGiven = childCauseNotGiven;
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

    @Field(name = "mother_name")
    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }
}
