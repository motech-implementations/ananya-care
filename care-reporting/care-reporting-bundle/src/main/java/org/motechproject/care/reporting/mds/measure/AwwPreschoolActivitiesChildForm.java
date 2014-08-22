package org.motechproject.care.reporting.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.care.reporting.mds.dimension.ChildCase;
import org.motechproject.care.reporting.mds.dimension.Flw;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(name = "aww_preschool_activities_child_form")
@Unique(members = {"instance_id","case_id"})
public class AwwPreschoolActivitiesChildForm extends Form {

    private Integer id;
    private AwwPreschoolActivitiesForm form;
    private ChildCase childCase;
    private Flw flw;
    private DateTime dateModified;
    private DateTime timeStart;
    private DateTime timeEnd;
    private DateTime creationTime = new DateTime();
    private String caseId;
    private String childAttend;
    private String breakfast;
    private String participated;
    private String lunch;

    public AwwPreschoolActivitiesChildForm() {

    }
    
    @Field(name = "form_id")
    @Cascade(persist = true, update = true, delete = false)
    public AwwPreschoolActivitiesForm getForm() {
        return form;
    }

    public void setForm(AwwPreschoolActivitiesForm form) {
        this.form = form;
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

    @Field(name = "caseid")
    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    @Field(name = "child_attend")
    public String getChildAttend() {
        return childAttend;
    }

    public void setChildAttend(String childAttend) {
        this.childAttend = childAttend;
    }

    @Field(name = "breakfast")
    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    @Field(name = "participated")
    public String getParticipated() {
        return participated;
    }

    public void setParticipated(String participated) {
        this.participated = participated;
    }

    @Field(name = "lunch")
    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }
}
