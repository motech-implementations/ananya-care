package org.motechproject.care.reporting.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.care.reporting.domain.dimension.Flw;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(name = "aww_preschool_activities_form")
@Unique(members = "instance_id")
public class AwwPreschoolActivitiesForm extends Form {

    private Integer id;
    private Flw flw;
    private DateTime dateModified;
    private DateTime timeStart;
    private DateTime timeEnd;
    private DateTime creationTime = new DateTime();
    private String menu;
    private String activity;
    private String success;
    private Integer numChildren;
    private String childIds;

    public AwwPreschoolActivitiesForm() {

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

    @Field(name = "menu")
    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    @Field(name = "activity")
    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    @Field(name = "success")
    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    @Field(name = "num_children")
    public Integer getNumChildren() {
        return numChildren;
    }

    public void setNumChildren(Integer numChildren) {
        this.numChildren = numChildren;
    }

    @Field(name = "child_ids")
    public String getChildIds() {
        return childIds;
    }

    public void setChildIds(String childIds) {
        this.childIds = childIds;
    }
}
