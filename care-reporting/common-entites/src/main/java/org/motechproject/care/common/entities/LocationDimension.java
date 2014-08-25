package org.motechproject.care.common.entities;

import javax.jdo.annotations.Unique;

import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;


@Entity(name = "location_dimension")
@Unique(members = {"state", "district", "block"})
public class LocationDimension implements java.io.Serializable {

    @Field
    private String state;
    @Field
    private String district;
    @Field
    private String block;

    public LocationDimension() {

    }

    public LocationDimension(String state, String district, String block) {
        this.state = state;
        this.district = district;
        this.block = block;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }
}
