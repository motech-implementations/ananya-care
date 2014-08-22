package org.motechproject.care.reporting.mds.measure;

import java.math.BigDecimal;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.care.reporting.mds.dimension.Flw;
import org.motechproject.care.reporting.mds.dimension.MotherCase;
import org.motechproject.care.reporting.utils.FormToString;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;


@Entity(name = "bp_form")
@Unique(members = "instance_id")
public class BpForm extends Form {

    private int id;
    private Flw flw;
    private MotherCase motherCase;
    private DateTime timeEnd;
    private DateTime timeStart;
    private DateTime dateModified;
    private DateTime ancLatestDate;
    private Integer ancLatestNum;
    private String anc1_AbdominalExam;
    private String anc1_Abnormalities;
    private String anc1_BloodPressure;
    private DateTime anc1_Date;
    private String anc1_Facility;
    private String anc1_Details;
    private String anc2_AbdominalExam;
    private String anc2_Abnormalities;
    private String anc2_BloodPressure;
    private DateTime anc2_Date;
    private String anc2_Facility;
    private String anc2_Details;
    private String anc3_AbdominalExam;
    private String anc3_Abnormalities;
    private String anc3_BloodPressure;
    private DateTime anc3_Date;
    private String anc3_Facility;
    private String anc3_Details;
    private String anc4_AbdominalExam;
    private String anc4_Abnormalities;
    private String anc4_BloodPressure;
    private DateTime anc4_Date;
    private String anc4_Facility;
    private String anc4_Details;
    private String counselIfa;
    private String counselTt;
    private String eatingExtra;
    private int ifaTabletsIssued;
    private String reasonNoIfa;
    private String receivedTt1;
    private String receivedTt2;
    private String resting;
    private DateTime tt1_Date;
    private DateTime tt2_Date;
    private String ttBooster;
    private DateTime ttBoosterDate;
    private String usingIfa;
    private String sba;
    private String sbaPhone;
    private String accompany;
    private String careOfHome;
    private String cleanCloth;
    private String cordCare;
    private String counselHomeDelivery;
    private String counselInstitutional;
    private String counselPreparation;
    private String dangerInstitution;
    private String dangerNumber;
    private String hasDangerSigns;
    private String immediateBreastfeeding;
    private String informDangerSigns;
    private String materials;
    private String maternalDangerSigns;
    private String nowInstitutional;
    private String phoneVehicle;
    private String playBirthPreparednessVid;
    private String playCordCareVid;
    private String savingMoney;
    private String skinToSkin;
    private String vehicle;
    private String wrapping;
    private int bpVisitNum;
    private DateTime anc1Date;
    private DateTime anc2Date;
    private DateTime anc3Date;
    private DateTime anc4Date;
    private String coupleInterested;
    private DateTime dateBp1;
    private DateTime dateBp2;
    private DateTime dateBp3;
    private DateTime dateLastVisit;
    private DateTime dateNextBp;
    private String deliveryType;
    private int ifaTablets;
    private DateTime ifaTablets100;
    private String lastVisitType;
    private String maternalEmergency;
    private String maternalEmergencyNumber;
    private DateTime tt1Date;
    private DateTime tt2Date;
    private String conceive;
    private DateTime delFup;
    private String availImmediate;
    private String counselAccessible;
    private String counselBenefits;
    private String counselDisqualification;
    private String counselInstitution;
    private String counselMethods;
    private String counselNearest;
    private String counselOptions;
    private String counselStay;
    private String immediateAppropriate;
    private String institutionImmediate;
    private String postponeConception;
    private String riskOfPreg;
    private String spacingMethods;
    private String stopChildren;
    private int ifaTabletsTotal;
    private String nextvisittype;
    private String playFamilyPlanningVid;
    private String postponing;
    private String institutional;
    private DateTime creationTime = new DateTime();
    private int anc1_Weight;
    private Integer anc1_Hemoglobin;
    private int anc2_Weight;
    private Integer anc2_Hemoglobin;
    private int anc3_Weight;
    private Integer anc3_Hemoglobin;
    private int anc4_Weight;
    private Integer anc4_Hemoglobin;
    private String anaemia;
    private String rtiSti;
    private String whichHospital;
    private String bleeding;
    private String bpComplications;

    public BpForm() {
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

    
    @Field(name = "anc_latest_date")
    public DateTime getAncLatestDateTime() {
        return this.ancLatestDate;
    }

    public void setAncLatestDate(DateTime ancLatestDate) {
        this.ancLatestDate = ancLatestDate;
    }

    @Field(name = "anc_latest_num")
    public Integer getAncLatestNum() {
        return this.ancLatestNum;
    }

    public void setAncLatestNum(Integer ancLatestNum) {
        this.ancLatestNum = ancLatestNum;
    }

    @Field(name = "anc1_abdominal_exam")
    public String getAnc1_AbdominalExam() {
        return this.anc1_AbdominalExam;
    }

    public void setAnc1_AbdominalExam(String anc1_AbdominalExam) {
        this.anc1_AbdominalExam = anc1_AbdominalExam;
    }

    @Field(name = "anc1_abnormalities")
    public String getAnc1_Abnormalities() {
        return this.anc1_Abnormalities;
    }

    public void setAnc1_Abnormalities(String anc1_Abnormalities) {
        this.anc1_Abnormalities = anc1_Abnormalities;
    }

    @Field(name = "anc1_blood_pressure")
    public String getAnc1_BloodPressure() {
        return this.anc1_BloodPressure;
    }

    public void setAnc1_BloodPressure(String anc1_BloodPressure) {
        this.anc1_BloodPressure = anc1_BloodPressure;
    }

    
    @Field(name = "anc1_date")
    public DateTime getAnc1_DateTime() {
        return this.anc1_Date;
    }

    public void setAnc1_Date(DateTime anc1_Date) {
        this.anc1_Date = anc1_Date;
    }

    @Field(name = "anc1_facility")
    public String getAnc1_Facility() {
        return this.anc1_Facility;
    }

    public void setAnc1_Facility(String anc1_Facility) {
        this.anc1_Facility = anc1_Facility;
    }

    @Field(name = "anc1_details")
    public String getAnc1_Details() {
        return this.anc1_Details;
    }

    public void setAnc1_Details(String anc1_Details) {
        this.anc1_Details = anc1_Details;
    }

    @Field(name = "anc2_abdominal_exam")
    public String getAnc2_AbdominalExam() {
        return this.anc2_AbdominalExam;
    }

    public void setAnc2_AbdominalExam(String anc2_AbdominalExam) {
        this.anc2_AbdominalExam = anc2_AbdominalExam;
    }

    @Field(name = "anc2_abnormalities")
    public String getAnc2_Abnormalities() {
        return this.anc2_Abnormalities;
    }

    public void setAnc2_Abnormalities(String anc2_Abnormalities) {
        this.anc2_Abnormalities = anc2_Abnormalities;
    }

    @Field(name = "anc2_blood_pressure")
    public String getAnc2_BloodPressure() {
        return this.anc2_BloodPressure;
    }

    public void setAnc2_BloodPressure(String anc2_BloodPressure) {
        this.anc2_BloodPressure = anc2_BloodPressure;
    }

    
    @Field(name = "anc2_date")
    public DateTime getAnc2_DateTime() {
        return this.anc2_Date;
    }

    public void setAnc2_Date(DateTime anc2_Date) {
        this.anc2_Date = anc2_Date;
    }

    @Field(name = "anc2_facility")
    public String getAnc2_Facility() {
        return this.anc2_Facility;
    }

    public void setAnc2_Facility(String anc2_Facility) {
        this.anc2_Facility = anc2_Facility;
    }

    @Field(name = "anc2_details")
    public String getAnc2_Details() {
        return this.anc2_Details;
    }

    public void setAnc2_Details(String anc2_Details) {
        this.anc2_Details = anc2_Details;
    }

    @Field(name = "anc3_abdominal_exam")
    public String getAnc3_AbdominalExam() {
        return this.anc3_AbdominalExam;
    }

    public void setAnc3_AbdominalExam(String anc3_AbdominalExam) {
        this.anc3_AbdominalExam = anc3_AbdominalExam;
    }

    @Field(name = "anc3_abnormalities")
    public String getAnc3_Abnormalities() {
        return this.anc3_Abnormalities;
    }

    public void setAnc3_Abnormalities(String anc3_Abnormalities) {
        this.anc3_Abnormalities = anc3_Abnormalities;
    }

    @Field(name = "anc3_blood_pressure")
    public String getAnc3_BloodPressure() {
        return this.anc3_BloodPressure;
    }

    public void setAnc3_BloodPressure(String anc3_BloodPressure) {
        this.anc3_BloodPressure = anc3_BloodPressure;
    }

    
    @Field(name = "anc3_date")
    public DateTime getAnc3_DateTime() {
        return this.anc3_Date;
    }

    public void setAnc3_Date(DateTime anc3_Date) {
        this.anc3_Date = anc3_Date;
    }

    @Field(name = "anc3_facility")
    public String getAnc3_Facility() {
        return this.anc3_Facility;
    }

    public void setAnc3_Facility(String anc3_Facility) {
        this.anc3_Facility = anc3_Facility;
    }

    @Field(name = "anc3_details")
    public String getAnc3_Details() {
        return this.anc3_Details;
    }

    public void setAnc3_Details(String anc3_Details) {
        this.anc3_Details = anc3_Details;
    }

    @Field(name = "anc4_abdominal_exam")
    public String getAnc4_AbdominalExam() {
        return this.anc4_AbdominalExam;
    }

    public void setAnc4_AbdominalExam(String anc4_AbdominalExam) {
        this.anc4_AbdominalExam = anc4_AbdominalExam;
    }

    @Field(name = "anc4_abnormalities")
    public String getAnc4_Abnormalities() {
        return this.anc4_Abnormalities;
    }

    public void setAnc4_Abnormalities(String anc4_Abnormalities) {
        this.anc4_Abnormalities = anc4_Abnormalities;
    }

    @Field(name = "anc4_blood_pressure")
    public String getAnc4_BloodPressure() {
        return this.anc4_BloodPressure;
    }

    public void setAnc4_BloodPressure(String anc4_BloodPressure) {
        this.anc4_BloodPressure = anc4_BloodPressure;
    }

    
    @Field(name = "anc4_date")
    public DateTime getAnc4_DateTime() {
        return this.anc4_Date;
    }

    public void setAnc4_Date(DateTime anc4_Date) {
        this.anc4_Date = anc4_Date;
    }

    @Field(name = "anc4_facility")
    public String getAnc4_Facility() {
        return this.anc4_Facility;
    }

    public void setAnc4_Facility(String anc4_Facility) {
        this.anc4_Facility = anc4_Facility;
    }

    @Field(name = "anc4_details")
    public String getAnc4_Details() {
        return this.anc4_Details;
    }

    public void setAnc4_Details(String anc4_Details) {
        this.anc4_Details = anc4_Details;
    }

    @Field(name = "counsel_ifa")
    public String getCounselIfa() {
        return this.counselIfa;
    }

    public void setCounselIfa(String counselIfa) {
        this.counselIfa = counselIfa;
    }

    @Field(name = "counsel_tt")
    public String getCounselTt() {
        return this.counselTt;
    }

    public void setCounselTt(String counselTt) {
        this.counselTt = counselTt;
    }

    @Field(name = "eating_extra")
    public String getEatingExtra() {
        return this.eatingExtra;
    }

    public void setEatingExtra(String eatingExtra) {
        this.eatingExtra = eatingExtra;
    }

    @Field(name = "ifa_tablets_issued")
    public int getIfaTabletsIssued() {
        return this.ifaTabletsIssued;
    }

    public void setIfaTabletsIssued(int ifaTabletsIssued) {
        this.ifaTabletsIssued = ifaTabletsIssued;
    }

    @Field(name = "reason_no_ifa")
    public String getReasonNoIfa() {
        return this.reasonNoIfa;
    }

    public void setReasonNoIfa(String reasonNoIfa) {
        this.reasonNoIfa = reasonNoIfa;
    }

    @Field(name = "received_tt1")
    public String getReceivedTt1() {
        return this.receivedTt1;
    }

    public void setReceivedTt1(String receivedTt1) {
        this.receivedTt1 = receivedTt1;
    }

    @Field(name = "received_tt2")
    public String getReceivedTt2() {
        return this.receivedTt2;
    }

    public void setReceivedTt2(String receivedTt2) {
        this.receivedTt2 = receivedTt2;
    }

    @Field(name = "resting")
    public String getResting() {
        return this.resting;
    }

    public void setResting(String resting) {
        this.resting = resting;
    }

    
    @Field(name = "tt1_date")
    public DateTime getTt1_DateTime() {
        return this.tt1_Date;
    }

    public void setTt1_Date(DateTime tt1_Date) {
        this.tt1_Date = tt1_Date;
    }

    
    @Field(name = "tt2_date")
    public DateTime getTt2_DateTime() {
        return this.tt2_Date;
    }

    public void setTt2_Date(DateTime tt2_Date) {
        this.tt2_Date = tt2_Date;
    }

    @Field(name = "tt_booster")
    public String getTtBooster() {
        return this.ttBooster;
    }

    public void setTtBooster(String ttBooster) {
        this.ttBooster = ttBooster;
    }

    
    @Field(name = "tt_booster_date")
    public DateTime getTtBoosterDateTime() {
        return this.ttBoosterDate;
    }

    public void setTtBoosterDate(DateTime ttBoosterDate) {
        this.ttBoosterDate = ttBoosterDate;
    }

    @Field(name = "using_ifa")
    public String getUsingIfa() {
        return this.usingIfa;
    }

    public void setUsingIfa(String usingIfa) {
        this.usingIfa = usingIfa;
    }

    @Field(name = "sba")
    public String getSba() {
        return this.sba;
    }

    public void setSba(String sba) {
        this.sba = sba;
    }

    @Field(name = "sba_phone")
    public String getSbaPhone() {
        return this.sbaPhone;
    }

    public void setSbaPhone(String sbaPhone) {
        this.sbaPhone = sbaPhone;
    }

    @Field(name = "accompany")
    public String getAccompany() {
        return this.accompany;
    }

    public void setAccompany(String accompany) {
        this.accompany = accompany;
    }

    @Field(name = "care_of_home")
    public String getCareOfHome() {
        return this.careOfHome;
    }

    public void setCareOfHome(String careOfHome) {
        this.careOfHome = careOfHome;
    }

    @Field(name = "clean_cloth")
    public String getCleanCloth() {
        return this.cleanCloth;
    }

    public void setCleanCloth(String cleanCloth) {
        this.cleanCloth = cleanCloth;
    }

    @Field(name = "cord_care")
    public String getCordCare() {
        return this.cordCare;
    }

    public void setCordCare(String cordCare) {
        this.cordCare = cordCare;
    }

    @Field(name = "counsel_home_delivery")
    public String getCounselHomeDelivery() {
        return this.counselHomeDelivery;
    }

    public void setCounselHomeDelivery(String counselHomeDelivery) {
        this.counselHomeDelivery = counselHomeDelivery;
    }

    @Field(name = "counsel_institutional")
    public String getCounselInstitutional() {
        return this.counselInstitutional;
    }

    public void setCounselInstitutional(String counselInstitutional) {
        this.counselInstitutional = counselInstitutional;
    }

    @Field(name = "counsel_preparation")
    public String getCounselPreparation() {
        return this.counselPreparation;
    }

    public void setCounselPreparation(String counselPreparation) {
        this.counselPreparation = counselPreparation;
    }

    @Field(name = "danger_institution")
    public String getDangerInstitution() {
        return this.dangerInstitution;
    }

    public void setDangerInstitution(String dangerInstitution) {
        this.dangerInstitution = dangerInstitution;
    }

    @Field(name = "danger_number")
    public String getDangerNumber() {
        return this.dangerNumber;
    }

    public void setDangerNumber(String dangerNumber) {
        this.dangerNumber = dangerNumber;
    }

    @Field(name = "has_danger_signs")
    public String getHasDangerSigns() {
        return this.hasDangerSigns;
    }

    public void setHasDangerSigns(String hasDangerSigns) {
        this.hasDangerSigns = hasDangerSigns;
    }

    @Field(name = "immediate_breastfeeding")
    public String getImmediateBreastfeeding() {
        return this.immediateBreastfeeding;
    }

    public void setImmediateBreastfeeding(String immediateBreastfeeding) {
        this.immediateBreastfeeding = immediateBreastfeeding;
    }

    @Field(name = "inform_danger_signs")
    public String getInformDangerSigns() {
        return this.informDangerSigns;
    }

    public void setInformDangerSigns(String informDangerSigns) {
        this.informDangerSigns = informDangerSigns;
    }

    @Field(name = "materials")
    public String getMaterials() {
        return this.materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    @Field(name = "maternal_danger_signs")
    public String getMaternalDangerSigns() {
        return this.maternalDangerSigns;
    }

    public void setMaternalDangerSigns(String maternalDangerSigns) {
        this.maternalDangerSigns = maternalDangerSigns;
    }

    @Field(name = "now_institutional")
    public String getNowInstitutional() {
        return this.nowInstitutional;
    }

    public void setNowInstitutional(String nowInstitutional) {
        this.nowInstitutional = nowInstitutional;
    }

    @Field(name = "phone_vehicle")
    public String getPhoneVehicle() {
        return this.phoneVehicle;
    }

    public void setPhoneVehicle(String phoneVehicle) {
        this.phoneVehicle = phoneVehicle;
    }

    @Field(name = "play_birth_preparedness_vid")
    public String getPlayBirthPreparednessVid() {
        return this.playBirthPreparednessVid;
    }

    public void setPlayBirthPreparednessVid(String playBirthPreparednessVid) {
        this.playBirthPreparednessVid = playBirthPreparednessVid;
    }

    @Field(name = "play_cord_care_vid")
    public String getPlayCordCareVid() {
        return this.playCordCareVid;
    }

    public void setPlayCordCareVid(String playCordCareVid) {
        this.playCordCareVid = playCordCareVid;
    }

    @Field(name = "saving_money")
    public String getSavingMoney() {
        return this.savingMoney;
    }

    public void setSavingMoney(String savingMoney) {
        this.savingMoney = savingMoney;
    }

    @Field(name = "skin_to_skin")
    public String getSkinToSkin() {
        return this.skinToSkin;
    }

    public void setSkinToSkin(String skinToSkin) {
        this.skinToSkin = skinToSkin;
    }

    @Field(name = "vehicle")
    public String getVehicle() {
        return this.vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    @Field(name = "wrapping")
    public String getWrapping() {
        return this.wrapping;
    }

    public void setWrapping(String wrapping) {
        this.wrapping = wrapping;
    }

    @Field(name = "bp_visit_num")
    public int getBpVisitNum() {
        return this.bpVisitNum;
    }

    public void setBpVisitNum(int bpVisitNum) {
        this.bpVisitNum = bpVisitNum;
    }

    
    @Field(name = "anc_1_date")
    public DateTime getAnc1DateTime() {
        return this.anc1Date;
    }

    public void setAnc1Date(DateTime anc1Date) {
        this.anc1Date = anc1Date;
    }

    
    @Field(name = "anc_2_date")
    public DateTime getAnc2DateTime() {
        return this.anc2Date;
    }

    public void setAnc2Date(DateTime anc2Date) {
        this.anc2Date = anc2Date;
    }

    
    @Field(name = "anc_3_date")
    public DateTime getAnc3DateTime() {
        return this.anc3Date;
    }

    public void setAnc3Date(DateTime anc3Date) {
        this.anc3Date = anc3Date;
    }

    
    @Field(name = "anc_4_date")
    public DateTime getAnc4DateTime() {
        return this.anc4Date;
    }

    public void setAnc4Date(DateTime anc4Date) {
        this.anc4Date = anc4Date;
    }

    @Field(name = "couple_interested")
    public String getCoupleInterested() {
        return this.coupleInterested;
    }

    public void setCoupleInterested(String coupleInterested) {
        this.coupleInterested = coupleInterested;
    }

    
    @Field(name = "date_bp_1")
    public DateTime getDateBp1() {
        return this.dateBp1;
    }

    public void setDateBp1(DateTime dateBp1) {
        this.dateBp1 = dateBp1;
    }

    
    @Field(name = "date_bp_2")
    public DateTime getDateBp2() {
        return this.dateBp2;
    }

    public void setDateBp2(DateTime dateBp2) {
        this.dateBp2 = dateBp2;
    }

    
    @Field(name = "date_bp_3")
    public DateTime getDateBp3() {
        return this.dateBp3;
    }

    public void setDateBp3(DateTime dateBp3) {
        this.dateBp3 = dateBp3;
    }

    
    @Field(name = "date_last_visit")
    public DateTime getDateLastVisit() {
        return this.dateLastVisit;
    }

    public void setDateLastVisit(DateTime dateLastVisit) {
        this.dateLastVisit = dateLastVisit;
    }

    
    @Field(name = "date_next_bp")
    public DateTime getDateNextBp() {
        return this.dateNextBp;
    }

    public void setDateNextBp(DateTime dateNextBp) {
        this.dateNextBp = dateNextBp;
    }

    @Field(name = "delivery_type")
    public String getDeliveryType() {
        return this.deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    @Field(name = "ifa_tablets")
    public int getIfaTablets() {
        return this.ifaTablets;
    }

    public void setIfaTablets(int ifaTablets) {
        this.ifaTablets = ifaTablets;
    }

    
    @Field(name = "ifa_tablets_100")
    public DateTime getIfaTablets100() {
        return this.ifaTablets100;
    }

    public void setIfaTablets100(DateTime ifaTablets100) {
        this.ifaTablets100 = ifaTablets100;
    }

    @Field(name = "last_visit_type")
    public String getLastVisitType() {
        return this.lastVisitType;
    }

    public void setLastVisitType(String lastVisitType) {
        this.lastVisitType = lastVisitType;
    }

    @Field(name = "maternal_emergency")
    public String getMaternalEmergency() {
        return this.maternalEmergency;
    }

    public void setMaternalEmergency(String maternalEmergency) {
        this.maternalEmergency = maternalEmergency;
    }

    @Field(name = "maternal_emergency_number")
    public String getMaternalEmergencyNumber() {
        return this.maternalEmergencyNumber;
    }

    public void setMaternalEmergencyNumber(String maternalEmergencyNumber) {
        this.maternalEmergencyNumber = maternalEmergencyNumber;
    }

    
    @Field(name = "tt_1_date")
    public DateTime getTt1DateTime() {
        return this.tt1Date;
    }

    public void setTt1Date(DateTime tt1Date) {
        this.tt1Date = tt1Date;
    }

    
    @Field(name = "tt_2_date")
    public DateTime getTt2DateTime() {
        return this.tt2Date;
    }

    public void setTt2Date(DateTime tt2Date) {
        this.tt2Date = tt2Date;
    }

    @Field(name = "conceive")
    public String getConceive() {
        return this.conceive;
    }

    public void setConceive(String conceive) {
        this.conceive = conceive;
    }

    @Field(name = "del_fup")
    public DateTime getDelFup() {
        return this.delFup;
    }

    public void setDelFup(DateTime delFup) {
        this.delFup = delFup;
    }

    @Field(name = "avail_immediate")
    public String getAvailImmediate() {
        return this.availImmediate;
    }

    public void setAvailImmediate(String availImmediate) {
        this.availImmediate = availImmediate;
    }

    @Field(name = "counsel_accessible")
    public String getCounselAccessible() {
        return this.counselAccessible;
    }

    public void setCounselAccessible(String counselAccessible) {
        this.counselAccessible = counselAccessible;
    }

    @Field(name = "counsel_benefits")
    public String getCounselBenefits() {
        return this.counselBenefits;
    }

    public void setCounselBenefits(String counselBenefits) {
        this.counselBenefits = counselBenefits;
    }

    @Field(name = "counsel_disqualification")
    public String getCounselDisqualification() {
        return this.counselDisqualification;
    }

    public void setCounselDisqualification(String counselDisqualification) {
        this.counselDisqualification = counselDisqualification;
    }

    @Field(name = "counsel_institution")
    public String getCounselInstitution() {
        return this.counselInstitution;
    }

    public void setCounselInstitution(String counselInstitution) {
        this.counselInstitution = counselInstitution;
    }

    @Field(name = "counsel_methods")
    public String getCounselMethods() {
        return this.counselMethods;
    }

    public void setCounselMethods(String counselMethods) {
        this.counselMethods = counselMethods;
    }

    @Field(name = "counsel_nearest")
    public String getCounselNearest() {
        return this.counselNearest;
    }

    public void setCounselNearest(String counselNearest) {
        this.counselNearest = counselNearest;
    }

    @Field(name = "counsel_options")
    public String getCounselOptions() {
        return this.counselOptions;
    }

    public void setCounselOptions(String counselOptions) {
        this.counselOptions = counselOptions;
    }

    @Field(name = "counsel_stay")
    public String getCounselStay() {
        return this.counselStay;
    }

    public void setCounselStay(String counselStay) {
        this.counselStay = counselStay;
    }

    @Field(name = "immediate_appropriate")
    public String getImmediateAppropriate() {
        return this.immediateAppropriate;
    }

    public void setImmediateAppropriate(String immediateAppropriate) {
        this.immediateAppropriate = immediateAppropriate;
    }

    @Field(name = "institution_immediate")
    public String getInstitutionImmediate() {
        return this.institutionImmediate;
    }

    public void setInstitutionImmediate(String institutionImmediate) {
        this.institutionImmediate = institutionImmediate;
    }

    @Field(name = "postpone_conception")
    public String getPostponeConception() {
        return this.postponeConception;
    }

    public void setPostponeConception(String postponeConception) {
        this.postponeConception = postponeConception;
    }

    @Field(name = "risk_of_preg")
    public String getRiskOfPreg() {
        return this.riskOfPreg;
    }

    public void setRiskOfPreg(String riskOfPreg) {
        this.riskOfPreg = riskOfPreg;
    }

    @Field(name = "spacing_methods")
    public String getSpacingMethods() {
        return this.spacingMethods;
    }

    public void setSpacingMethods(String spacingMethods) {
        this.spacingMethods = spacingMethods;
    }

    @Field(name = "stop_children")
    public String getStopChildren() {
        return this.stopChildren;
    }

    public void setStopChildren(String stopChildren) {
        this.stopChildren = stopChildren;
    }

    @Field(name = "ifa_tablets_total")
    public int getIfaTabletsTotal() {
        return this.ifaTabletsTotal;
    }

    public void setIfaTabletsTotal(int ifaTabletsTotal) {
        this.ifaTabletsTotal = ifaTabletsTotal;
    }

    @Field(name = "nextvisittype")
    public String getNextvisittype() {
        return this.nextvisittype;
    }

    public void setNextvisittype(String nextvisittype) {
        this.nextvisittype = nextvisittype;
    }

    @Field(name = "play_family_planning_vid")
    public String getPlayFamilyPlanningVid() {
        return this.playFamilyPlanningVid;
    }

    public void setPlayFamilyPlanningVid(String playFamilyPlanningVid) {
        this.playFamilyPlanningVid = playFamilyPlanningVid;
    }

    @Field(name = "postponing")
    public String getPostponing() {
        return this.postponing;
    }

    public void setPostponing(String postponing) {
        this.postponing = postponing;
    }


    @Field(name = "institutional")
    public String getInstitutional() {
        return this.institutional;
    }

    public void setInstitutional(String institutional) {
        this.institutional = institutional;
    }

    
    @Field(name = "creation_time")
    public DateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(DateTime creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public String toString() {
        return FormToString.toString(this);
    }

    @Field(name = "anc1_weight")
    public int getAnc1_Weight() {
        return anc1_Weight;
    }

    public void setAnc1_Weight(int anc1_Weight) {
        this.anc1_Weight = anc1_Weight;
    }

    @Field(name = "anc1_hemoglobin")
    public Integer getAnc1_Hemoglobin() {
        return anc1_Hemoglobin;
    }

    public void setAnc1_Hemoglobin(Integer anc1_Hemoglobin) {
        this.anc1_Hemoglobin = anc1_Hemoglobin;
    }

    @Field(name = "anc2_weight")
    public int getAnc2_Weight() {
        return anc2_Weight;
    }

    public void setAnc2_Weight(int anc2_Weight) {
        this.anc2_Weight = anc2_Weight;
    }

    @Field(name = "anc2_hemoglobin")
    public Integer getAnc2_Hemoglobin() {
        return anc2_Hemoglobin;
    }

    public void setAnc2_Hemoglobin(Integer anc2_Hemoglobin) {
        this.anc2_Hemoglobin = anc2_Hemoglobin;
    }

    @Field(name = "anc3_weight")
    public int getAnc3_Weight() {
        return anc3_Weight;
    }

    public void setAnc3_Weight(int anc3_Weight) {
        this.anc3_Weight = anc3_Weight;
    }

    @Field(name = "anc3_hemoglobin")
    public Integer getAnc3_Hemoglobin() {
        return anc3_Hemoglobin;
    }

    public void setAnc3_Hemoglobin(Integer anc3_Hemoglobin) {
        this.anc3_Hemoglobin = anc3_Hemoglobin;
    }

    @Field(name = "anc4_weight")
    public int getAnc4_Weight() {
        return anc4_Weight;
    }

    public void setAnc4_Weight(int anc4_Weight) {
        this.anc4_Weight = anc4_Weight;
    }

    @Field(name = "anc4_hemoglobin")
    public Integer getAnc4_Hemoglobin() {
        return anc4_Hemoglobin;
    }

    public void setAnc4_Hemoglobin(Integer anc4_Hemoglobin) {
        this.anc4_Hemoglobin = anc4_Hemoglobin;
    }

    @Field(name = "anaemia")
    public String getAnaemia() {
        return anaemia;
    }

    public void setAnaemia(String anaemia) {
        this.anaemia = anaemia;
    }

    @Field(name = "rti_sti")
    public String getRtiSti() {
        return rtiSti;
    }

    public void setRtiSti(String rtiSti) {
        this.rtiSti = rtiSti;
    }

    @Field(name = "which_hospital")
    public String getWhichHospital() {
        return whichHospital;
    }

    public void setWhichHospital(String whichHospital) {
        this.whichHospital = whichHospital;
    }

    @Field(name = "bleeding")
    public String getBleeding() {
        return bleeding;
    }

    public void setBleeding(String bleeding) {
        this.bleeding = bleeding;
    }

    @Field(name = "bp_complications")
    public String getBpComplications() {
        return bpComplications;
    }

    public void setBpComplications(String bpComplications) {
        this.bpComplications = bpComplications;
    }
}
