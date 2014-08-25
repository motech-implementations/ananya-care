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
    public DateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(DateTime creationTime) {
        this.creationTime = creationTime;
    }

    @Field
    public String getUpdateHusbandName() {
        return updateHusbandName;
    }

    public void setUpdateHusbandName(String updateHusbandName) {
        this.updateHusbandName = updateHusbandName;
    }

    @Field
    public String getHusbandName() {
        return husbandName;
    }

    public void setHusbandName(String husbandName) {
        this.husbandName = husbandName;
    }

    @Field
    public String getUpdateMobileNumberWhose() {
        return updateMobileNumberWhose;
    }

    public void setUpdateMobileNumberWhose(String updateMobileNumberWhose) {
        this.updateMobileNumberWhose = updateMobileNumberWhose;
    }

    @Field
    public String getMobileNumberWhose() {
        return mobileNumberWhose;
    }

    public void setMobileNumberWhose(String mobileNumberWhose) {
        this.mobileNumberWhose = mobileNumberWhose;
    }

    @Field
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Field
    public String getUpdateWardNumber() {
        return updateWardNumber;
    }

    public void setUpdateWardNumber(String updateWardNumber) {
        this.updateWardNumber = updateWardNumber;
    }

    @Field
    public Integer getWardNumber() {
        return wardNumber;
    }

    public void setWardNumber(Integer wardNumber) {
        this.wardNumber = wardNumber;
    }

    @Field
    public String getUpdateMobileNumber() {
        return updateMobileNumber;
    }

    public void setUpdateMobileNumber(String updateMobileNumber) {
        this.updateMobileNumber = updateMobileNumber;
    }

    @Field
    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Field
    public String getUpdateFamilyNumber() {
        return updateFamilyNumber;
    }

    public void setUpdateFamilyNumber(String updateFamilyNumber) {
        this.updateFamilyNumber = updateFamilyNumber;
    }

    @Field
    public Integer getFamilyNumber() {
        return familyNumber;
    }

    public void setFamilyNumber(Integer familyNumber) {
        this.familyNumber = familyNumber;
    }

    @Field
    public String getUpdateMotherDob() {
        return updateMotherDob;
    }

    public void setUpdateMotherDob(String updateMotherDob) {
        this.updateMotherDob = updateMotherDob;
    }

    @Field
    public DateTime getMotherDob() {
        return motherDob;
    }

    public void setMotherDob(DateTime motherDob) {
        this.motherDob = motherDob;
    }

    @Field
    public String getUpdateHhNumber() {
        return updateHhNumber;
    }

    public void setUpdateHhNumber(String updateHhNumber) {
        this.updateHhNumber = updateHhNumber;
    }

    @Field
    public Integer getHhNumber() {
        return hhNumber;
    }

    public void setHhNumber(Integer hhNumber) {
        this.hhNumber = hhNumber;
    }

    @Field
    public String getUpdateMotherName() {
        return updateMotherName;
    }

    public void setUpdateMotherName(String updateMotherName) {
        this.updateMotherName = updateMotherName;
    }

    @Field
    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    @Field
    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    @Field
    public Integer getMctsId() {
        return mctsId;
    }

    public void setMctsId(Integer mctsId) {
        this.mctsId = mctsId;
    }

    @Field
    public String getUpdateMctsId() {
        return updateMctsId;
    }

    public void setUpdateMctsId(String updateMctsId) {
        this.updateMctsId = updateMctsId;
    }

    @Field
    public String getUpdateAadharNumber() {
        return updateAadharNumber;
    }

    public void setUpdateAadharNumber(String updateAadharNumber) {
        this.updateAadharNumber = updateAadharNumber;
    }

    @Field
    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    @Field
    public String getFullMctsId() {
        return fullMctsId;
    }

    public void setFullMctsId(String fullMctsId) {
        this.fullMctsId = fullMctsId;
    }
}