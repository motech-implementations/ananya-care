package org.motechproject.care.reporting.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.care.reporting.domain.annotations.ExternalPrimaryKey;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(name = "form")
public class Form implements java.io.Serializable {
    @ExternalPrimaryKey
    private String instanceId;

    private String appVersion;

    private DateTime serverDateModified;

    private Integer deliveryOffsetDays;

    public Form() {
    }

    @Field
    @Unique
    public String getInstanceId() {
        return this.instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    @Field
    public String getAppVersion() {
        return this.appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    
    @Field
    public DateTime getServerDateModified() {
        return serverDateModified;
    }

    public void setServerDateModified(DateTime serverDateModified) {
        this.serverDateModified = serverDateModified;
    }


    @Field
    public Integer getDeliveryOffsetDays() {
        return this.deliveryOffsetDays;
    }

    public void setDeliveryOffsetDays(Integer deliveryOffsetDays) {
        this.deliveryOffsetDays = deliveryOffsetDays;
    }

}
