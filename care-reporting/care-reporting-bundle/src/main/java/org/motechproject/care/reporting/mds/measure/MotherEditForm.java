package org.motechproject.care.reporting.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.care.reporting.mds.dimension.Flw;
import org.motechproject.care.reporting.mds.dimension.MotherCase;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(name = "mother_edit_form")
@Unique(members = "instance_id")
public class MotherEditForm extends Form {

    private int id;
    private Flw flw;
    private MotherCase motherCase;
    private DateTime timeEnd;
    private DateTime timeStart;
    private DateTime dateModified;
    private DateTime creationTime = new DateTime();
    private Integer age;
    private String caseName;
    private String motherName;
    private String updateMotherName;
    private Integer hhNumber;
    private String updateHhNumber;
    private DateTime motherDob;
    private String updateMotherDob;
    private Integer familyNumber;
    private String updateFamilyNumber;
    private String mobileNumber;
    private String updateMobileNumber;
    private Integer wardNumber;
    private String updateWardNumber;
    private String mobileNumberWhose;
    private String updateMobileNumberWhose;
    private String husbandName;
    private String updateHusbandName;
    private Integer mctsId;
    private String updateMctsId;
    private String updateAadharNumber;
    private String aadharNumber;
    private String fullMctsId;

    public MotherEditForm() {

    }

    @Field(name = "user_id")
    @Cascade(persist = true, update = true, delete = false)
    public Flw getFlw() {
        return this.flw;
    }

    public void setFlw(Flw flw) {
        this.flw = flw;
    }

    
    @Field(name = "case_id")
    @Cascade(persist = true, update = true, delete = false)
    public MotherCase getMotherCase() {
        return this.motherCase;
    }

    public void setMotherCase(MotherCase motherCase) {
        this.motherCase = motherCase;
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

    @Field(name = "update_husband_name")
    public String getUpdateHusbandName() {
        return updateHusbandName;
    }

    public void setUpdateHusbandName(String updateHusbandName) {
        this.updateHusbandName = updateHusbandName;
    }

    @Field(name = "husband_name")
    public String getHusbandName() {
        return husbandName;
    }

    public void setHusbandName(String husbandName) {
        this.husbandName = husbandName;
    }

    @Field(name = "update_mobile_number_whose")
    public String getUpdateMobileNumberWhose() {
        return updateMobileNumberWhose;
    }

    public void setUpdateMobileNumberWhose(String updateMobileNumberWhose) {
        this.updateMobileNumberWhose = updateMobileNumberWhose;
    }

    @Field(name = "mobile_number_whose")
    public String getMobileNumberWhose() {
        return mobileNumberWhose;
    }

    public void setMobileNumberWhose(String mobileNumberWhose) {
        this.mobileNumberWhose = mobileNumberWhose;
    }

    @Field(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Field(name = "update_ward_number")
    public String getUpdateWardNumber() {
        return updateWardNumber;
    }

    public void setUpdateWardNumber(String updateWardNumber) {
        this.updateWardNumber = updateWardNumber;
    }

    @Field(name = "ward_number")
    public Integer getWardNumber() {
        return wardNumber;
    }

    public void setWardNumber(Integer wardNumber) {
        this.wardNumber = wardNumber;
    }

    @Field(name = "update_mobile_number")
    public String getUpdateMobileNumber() {
        return updateMobileNumber;
    }

    public void setUpdateMobileNumber(String updateMobileNumber) {
        this.updateMobileNumber = updateMobileNumber;
    }

    @Field(name = "mobile_number")
    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Field(name = "update_family_number")
    public String getUpdateFamilyNumber() {
        return updateFamilyNumber;
    }

    public void setUpdateFamilyNumber(String updateFamilyNumber) {
        this.updateFamilyNumber = updateFamilyNumber;
    }

    @Field(name = "family_number")
    public Integer getFamilyNumber() {
        return familyNumber;
    }

    public void setFamilyNumber(Integer familyNumber) {
        this.familyNumber = familyNumber;
    }

    @Field(name = "update_mother_dob")
    public String getUpdateMotherDob() {
        return updateMotherDob;
    }

    public void setUpdateMotherDob(String updateMotherDob) {
        this.updateMotherDob = updateMotherDob;
    }

    @Field(name = "mother_dob")
    public DateTime getMotherDob() {
        return motherDob;
    }

    public void setMotherDob(DateTime motherDob) {
        this.motherDob = motherDob;
    }

    @Field(name = "update_hh_number")
    public String getUpdateHhNumber() {
        return updateHhNumber;
    }

    public void setUpdateHhNumber(String updateHhNumber) {
        this.updateHhNumber = updateHhNumber;
    }

    @Field(name = "hh_number")
    public Integer getHhNumber() {
        return hhNumber;
    }

    public void setHhNumber(Integer hhNumber) {
        this.hhNumber = hhNumber;
    }

    @Field(name = "update_mother_name")
    public String getUpdateMotherName() {
        return updateMotherName;
    }

    public void setUpdateMotherName(String updateMotherName) {
        this.updateMotherName = updateMotherName;
    }

    @Field(name = "mother_name")
    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    @Field(name = "case_name")
    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    @Field(name = "mcts_id")
    public Integer getMctsId() {
        return mctsId;
    }

    public void setMctsId(Integer mctsId) {
        this.mctsId = mctsId;
    }

    @Field(name = "update_mcts_id")
    public String getUpdateMctsId() {
        return updateMctsId;
    }

    public void setUpdateMctsId(String updateMctsId) {
        this.updateMctsId = updateMctsId;
    }

    @Field(name = "update_aadhar_number")
    public String getUpdateAadharNumber() {
        return updateAadharNumber;
    }

    public void setUpdateAadharNumber(String updateAadharNumber) {
        this.updateAadharNumber = updateAadharNumber;
    }

    @Field(name = "aadhar_number")
    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    @Field(name = "full_mcts_id")
    public String getFullMctsId() {
        return fullMctsId;
    }

    public void setFullMctsId(String fullMctsId) {
        this.fullMctsId = fullMctsId;
    }
}