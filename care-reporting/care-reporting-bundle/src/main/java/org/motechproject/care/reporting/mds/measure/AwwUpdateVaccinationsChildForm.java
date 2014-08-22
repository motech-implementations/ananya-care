package org.motechproject.care.reporting.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.care.reporting.mds.dimension.ChildCase;
import org.motechproject.care.reporting.mds.dimension.Flw;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;


@Entity(name = "aww_update_vaccinations_child_form")
@Unique(members = {"instance_id", "case_id"})
public class AwwUpdateVaccinationsChildForm extends Form {

    private int id;
    private ChildCase childCase;
    private Flw flw;
    private DateTime dateModified;
    private DateTime timeStart;
    private DateTime timeEnd;
    private DateTime creationTime = new DateTime();
    private String detailsAvailable;
    private String detailsNeeded;
    private String addVaccinations;
    private DateTime bcgDate;
    private DateTime opv0Date;
    private DateTime opv1Date;
    private DateTime opv2Date;
    private DateTime opv3Date;
    private DateTime opvBoosterDate;
    private DateTime dpt1Date;
    private DateTime dpt2Date;
    private DateTime dpt3Date;
    private DateTime dptBoosterDate;
    private DateTime hepB0Date;
    private DateTime hepB1Date;
    private DateTime hepB2Date;
    private DateTime hepB3Date;
    private DateTime measlesDate;
    private DateTime dateMeaslesBooster;
    private DateTime vitA1Date;
    private DateTime vitA2Date;
    private DateTime vitA3Date;
    private DateTime dateJe;
    private String upToDate;
    private String babyBcg;
    private String babyOpv0;
    private String babyOpv1;
    private String babyOpv2;
    private String babyOpv3;
    private String babyOpvBooster;
    private String babyDpt1;
    private String babyDpt2;
    private String babyDpt3;
    private String babyDptBooster;
    private String babyHepB0;
    private String babyHepB1;
    private String babyHepB2;
    private String babyHepB3;
    private String babyMeasles;
    private String babyMeaslesBooster;
    private String babyVita1;
    private String babyVita2;
    private String babyVita3;
    private String babyJe;
    private String upToDateSixWeeks;
    private String upToDateTenWeeks;
    private String upToDate14Weeks;
    private String upToDateOneYear;
    private String upToDateTwoYear;
    private String success;
    private String immunsUpToDate;
    private String childName;
    private DateTime dob;

    public AwwUpdateVaccinationsChildForm() {

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
        return this.dateModified;
    }

    public void setDateModified(DateTime dateModified) {
        this.dateModified = dateModified;
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

     
    @Field(name = "creation_time")
    public DateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(DateTime creationTime) {
        this.creationTime = creationTime;
    }

    @Field(name = "details_available")
    public String getDetailsAvailable() {
        return detailsAvailable;
    }

    public void setDetailsAvailable(String detailsAvailable) {
        this.detailsAvailable = detailsAvailable;
    }

    @Field(name = "details_needed")
    public String getDetailsNeeded() {
        return detailsNeeded;
    }

    public void setDetailsNeeded(String detailsNeeded) {
        this.detailsNeeded = detailsNeeded;
    }

    @Field(name = "add_vaccinations")
    public String getAddVaccinations() {
        return addVaccinations;
    }

    public void setAddVaccinations(String addVaccinations) {
        this.addVaccinations = addVaccinations;
    }

    @Field(name = "bcg_date")
    public DateTime getBcgDateTime() {
        return bcgDate;
    }

    public void setBcgDate(DateTime bcgDate) {
        this.bcgDate = bcgDate;
    }

    @Field(name = "opv_0_date")
    public DateTime getOpv0DateTime() {
        return opv0Date;
    }

    public void setOpv0Date(DateTime opv0Date) {
        this.opv0Date = opv0Date;
    }

    @Field(name = "opv_1_date")
    public DateTime getOpv1DateTime() {
        return opv1Date;
    }

    public void setOpv1Date(DateTime opv1Date) {
        this.opv1Date = opv1Date;
    }

    @Field(name = "opv_2_date")
    public DateTime getOpv2DateTime() {
        return opv2Date;
    }

    public void setOpv2Date(DateTime opv2Date) {
        this.opv2Date = opv2Date;
    }

    @Field(name = "opv_3_date")
    public DateTime getOpv3DateTime() {
        return opv3Date;
    }

    public void setOpv3Date(DateTime opv3Date) {
        this.opv3Date = opv3Date;
    }

    @Field(name = "opv_booster_date")
    public DateTime getOpvBoosterDateTime() {
        return opvBoosterDate;
    }

    public void setOpvBoosterDate(DateTime opvBoosterDate) {
        this.opvBoosterDate = opvBoosterDate;
    }

    @Field(name = "dpt_1_date")
    public DateTime getDpt1DateTime() {
        return dpt1Date;
    }

    public void setDpt1Date(DateTime dpt1Date) {
        this.dpt1Date = dpt1Date;
    }

    @Field(name = "dpt_2_date")
    public DateTime getDpt2DateTime() {
        return dpt2Date;
    }

    public void setDpt2Date(DateTime dpt2Date) {
        this.dpt2Date = dpt2Date;
    }

    @Field(name = "dpt_3_date")
    public DateTime getDpt3DateTime() {
        return dpt3Date;
    }

    public void setDpt3Date(DateTime dpt3Date) {
        this.dpt3Date = dpt3Date;
    }

    @Field(name = "dpt_booster_date")
    public DateTime getDptBoosterDateTime() {
        return dptBoosterDate;
    }

    public void setDptBoosterDate(DateTime dptBoosterDate) {
        this.dptBoosterDate = dptBoosterDate;
    }

    @Field(name = "hep_b_0_date")
    public DateTime getHepB0DateTime() {
        return hepB0Date;
    }

    public void setHepB0Date(DateTime hepB0Date) {
        this.hepB0Date = hepB0Date;
    }

    @Field(name = "hep_b_1_date")
    public DateTime getHepB1DateTime() {
        return hepB1Date;
    }

    public void setHepB1Date(DateTime hepB1Date) {
        this.hepB1Date = hepB1Date;
    }

    @Field(name = "hep_b_2_date")
    public DateTime getHepB2DateTime() {
        return hepB2Date;
    }

    public void setHepB2Date(DateTime hepB2Date) {
        this.hepB2Date = hepB2Date;
    }

    @Field(name = "hep_b_3_date")
    public DateTime getHepB3DateTime() {
        return hepB3Date;
    }

    public void setHepB3Date(DateTime hepB3Date) {
        this.hepB3Date = hepB3Date;
    }

    @Field(name = "measles_date")
    public DateTime getMeaslesDateTime() {
        return measlesDate;
    }

    public void setMeaslesDate(DateTime measlesDate) {
        this.measlesDate = measlesDate;
    }

    @Field(name = "date_measles_booster")
    public DateTime getDateMeaslesBooster() {
        return dateMeaslesBooster;
    }

    public void setDateMeaslesBooster(DateTime dateMeaslesBooster) {
        this.dateMeaslesBooster = dateMeaslesBooster;
    }

    @Field(name = "vit_a_1_date")
    public DateTime getVitA1DateTime() {
        return vitA1Date;
    }

    public void setVitA1Date(DateTime vitA1Date) {
        this.vitA1Date = vitA1Date;
    }

    @Field(name = "vit_a_2_date")
    public DateTime getVitA2DateTime() {
        return vitA2Date;
    }

    public void setVitA2Date(DateTime vitA2Date) {
        this.vitA2Date = vitA2Date;
    }

    @Field(name = "vit_a_3_date")
    public DateTime getVitA3DateTime() {
        return vitA3Date;
    }

    public void setVitA3Date(DateTime vitA3Date) {
        this.vitA3Date = vitA3Date;
    }

    @Field(name = "date_je")
    public DateTime getDateJe() {
        return dateJe;
    }

    public void setDateJe(DateTime dateJe) {
        this.dateJe = dateJe;
    }

    @Field(name = "up_to_date")
    public String getUpToDateTime() {
        return upToDate;
    }

    public void setUpToDate(String upToDate) {
        this.upToDate = upToDate;
    }

    @Field(name = "baby_bcg")
    public String getBabyBcg() {
        return babyBcg;
    }

    public void setBabyBcg(String babyBcg) {
        this.babyBcg = babyBcg;
    }

    @Field(name = "baby_opv_0")
    public String getBabyOpv0() {
        return babyOpv0;
    }

    public void setBabyOpv0(String babyOpv0) {
        this.babyOpv0 = babyOpv0;
    }

    @Field(name = "baby_opv_1")
    public String getBabyOpv1() {
        return babyOpv1;
    }

    public void setBabyOpv1(String babyOpv1) {
        this.babyOpv1 = babyOpv1;
    }

    @Field(name = "baby_opv_2")
    public String getBabyOpv2() {
        return babyOpv2;
    }

    public void setBabyOpv2(String babyOpv2) {
        this.babyOpv2 = babyOpv2;
    }

    @Field(name = "baby_opv_3")
    public String getBabyOpv3() {
        return babyOpv3;
    }

    public void setBabyOpv3(String babyOpv3) {
        this.babyOpv3 = babyOpv3;
    }

    @Field(name = "baby_opv_booster")
    public String getBabyOpvBooster() {
        return babyOpvBooster;
    }

    public void setBabyOpvBooster(String babyOpvBooster) {
        this.babyOpvBooster = babyOpvBooster;
    }

    @Field(name = "baby_dpt_1")
    public String getBabyDpt1() {
        return babyDpt1;
    }

    public void setBabyDpt1(String babyDpt1) {
        this.babyDpt1 = babyDpt1;
    }

    @Field(name = "baby_dpt_2")
    public String getBabyDpt2() {
        return babyDpt2;
    }

    public void setBabyDpt2(String babyDpt2) {
        this.babyDpt2 = babyDpt2;
    }

    @Field(name = "baby_dpt_3")
    public String getBabyDpt3() {
        return babyDpt3;
    }

    public void setBabyDpt3(String babyDpt3) {
        this.babyDpt3 = babyDpt3;
    }

    @Field(name = "baby_dpt_booster")
    public String getBabyDptBooster() {
        return babyDptBooster;
    }

    public void setBabyDptBooster(String babyDptBooster) {
        this.babyDptBooster = babyDptBooster;
    }

    @Field(name = "baby_hep_b_0")
    public String getBabyHepB0() {
        return babyHepB0;
    }

    public void setBabyHepB0(String babyHepB0) {
        this.babyHepB0 = babyHepB0;
    }

    @Field(name = "baby_hep_b_1")
    public String getBabyHepB1() {
        return babyHepB1;
    }

    public void setBabyHepB1(String babyHepB1) {
        this.babyHepB1 = babyHepB1;
    }

    @Field(name = "baby_hep_b_2")
    public String getBabyHepB2() {
        return babyHepB2;
    }

    public void setBabyHepB2(String babyHepB2) {
        this.babyHepB2 = babyHepB2;
    }

    @Field(name = "baby_hep_b_3")
    public String getBabyHepB3() {
        return babyHepB3;
    }

    public void setBabyHepB3(String babyHepB3) {
        this.babyHepB3 = babyHepB3;
    }

    @Field(name = "baby_measles")
    public String getBabyMeasles() {
        return babyMeasles;
    }

    public void setBabyMeasles(String babyMeasles) {
        this.babyMeasles = babyMeasles;
    }

    @Field(name = "baby_measles_booster")
    public String getBabyMeaslesBooster() {
        return babyMeaslesBooster;
    }

    public void setBabyMeaslesBooster(String babyMeaslesBooster) {
        this.babyMeaslesBooster = babyMeaslesBooster;
    }

    @Field(name = "baby_vita_1")
    public String getBabyVita1() {
        return babyVita1;
    }

    public void setBabyVita1(String babyVita1) {
        this.babyVita1 = babyVita1;
    }

    @Field(name = "baby_vita_2")
    public String getBabyVita2() {
        return babyVita2;
    }

    public void setBabyVita2(String babyVita2) {
        this.babyVita2 = babyVita2;
    }

    @Field(name = "baby_vita_3")
    public String getBabyVita3() {
        return babyVita3;
    }

    public void setBabyVita3(String babyVita3) {
        this.babyVita3 = babyVita3;
    }

    @Field(name = "baby_je")
    public String getBabyJe() {
        return babyJe;
    }

    public void setBabyJe(String babyJe) {
        this.babyJe = babyJe;
    }

    @Field(name = "up_to_date_six_weeks")
    public String getUpToDateSixWeeks() {
        return upToDateSixWeeks;
    }

    public void setUpToDateSixWeeks(String upToDateSixWeeks) {
        this.upToDateSixWeeks = upToDateSixWeeks;
    }

    @Field(name = "up_to_date_ten_weeks")
    public String getUpToDateTenWeeks() {
        return upToDateTenWeeks;
    }

    public void setUpToDateTenWeeks(String upToDateTenWeeks) {
        this.upToDateTenWeeks = upToDateTenWeeks;
    }

    @Field(name = "up_to_date_14_weeks")
    public String getUpToDate14Weeks() {
        return upToDate14Weeks;
    }

    public void setUpToDate14Weeks(String upToDate14Weeks) {
        this.upToDate14Weeks = upToDate14Weeks;
    }

    @Field(name = "up_to_date_one_year")
    public String getUpToDateOneYear() {
        return upToDateOneYear;
    }

    public void setUpToDateOneYear(String upToDateOneYear) {
        this.upToDateOneYear = upToDateOneYear;
    }

    @Field(name = "up_to_date_two_year")
    public String getUpToDateTwoYear() {
        return upToDateTwoYear;
    }

    public void setUpToDateTwoYear(String upToDateTwoYear) {
        this.upToDateTwoYear = upToDateTwoYear;
    }

    @Field(name = "success")
    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    @Field(name = "immuns_up_to_date")
    public String getImmunsUpToDateTime() {
        return immunsUpToDate;
    }

    public void setImmunsUpToDate(String immunsUpToDate) {
        this.immunsUpToDate = immunsUpToDate;
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
}
