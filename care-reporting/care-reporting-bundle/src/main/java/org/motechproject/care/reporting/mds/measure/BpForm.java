package org.motechproject.care.reporting.mds.measure;

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

	/**
	 * 
	 */
	private static final long serialVersionUID = -1558836102875878836L;
	@Field
	@Cascade(persist = true, update = true, delete = false)
	private Flw flw;
	@Field
	@Cascade(persist = true, update = true, delete = false)
	private MotherCase motherCase;
	@Field
	private DateTime timeEnd;
	@Field
	private DateTime timeStart;
	@Field
	private DateTime dateModified;
	@Field
	private DateTime ancLatestDate;
	@Field
	private Integer ancLatestNum;
	@Field
	private String anc1_AbdominalExam;
	private String anc1_Abnormalities;
	@Field
	private String anc1_BloodPressure;
	@Field
	private DateTime anc1_Date;
	@Field
	private String anc1_Facility;
	@Field
	private String anc1_Details;
	@Field
	private String anc2_AbdominalExam;
	@Field
	private String anc2_Abnormalities;
	@Field
	private String anc2_BloodPressure;
	@Field
	private DateTime anc2_Date;
	@Field
	private String anc2_Facility;
	@Field
	private String anc2_Details;
	@Field
	private String anc3_AbdominalExam;
	@Field
	private String anc3_Abnormalities;
	@Field
	private String anc3_BloodPressure;
	@Field
	private DateTime anc3_Date;
	@Field
	private String anc3_Facility;
	@Field
	private String anc3_Details;
	@Field
	private String anc4_AbdominalExam;
	@Field
	private String anc4_Abnormalities;
	@Field
	private String anc4_BloodPressure;
	@Field
	private DateTime anc4_Date;
	@Field
	private String anc4_Facility;
	@Field
	private String anc4_Details;
	@Field
	private String counselIfa;
	@Field
	private String counselTt;
	@Field
	private String eatingExtra;
	@Field
	private int ifaTabletsIssued;
	@Field
	private String reasonNoIfa;
	@Field
	private String receivedTt1;
	@Field
	private String receivedTt2;
	@Field
	private String resting;
	@Field
	private DateTime tt1_Date;
	@Field
	private DateTime tt2_Date;
	@Field
	private String ttBooster;
	@Field
	private DateTime ttBoosterDate;
	@Field
	private String usingIfa;
	@Field
	private String sba;
	@Field
	private String sbaPhone;
	@Field
	private String accompany;
	@Field
	private String careOfHome;
	@Field
	private String cleanCloth;
	@Field
	private String cordCare;
	@Field
	private String counselHomeDelivery;
	@Field
	private String counselInstitutional;
	@Field
	private String counselPreparation;
	@Field
	private String dangerInstitution;
	@Field
	private String dangerNumber;
	@Field
	private String hasDangerSigns;
	@Field
	private String immediateBreastfeeding;
	@Field
	private String informDangerSigns;
	@Field
	private String materials;
	@Field
	private String maternalDangerSigns;
	@Field
	private String nowInstitutional;
	@Field
	private String phoneVehicle;
	@Field
	private String playBirthPreparednessVid;
	@Field
	private String playCordCareVid;
	@Field
	private String savingMoney;
	@Field
	private String skinToSkin;
	@Field
	private String vehicle;
	@Field
	private String wrapping;
	@Field
	private int bpVisitNum;
	@Field
	private DateTime anc1Date;
	@Field
	private DateTime anc2Date;
	@Field
	private DateTime anc3Date;
	@Field
	private DateTime anc4Date;
	@Field
	private String coupleInterested;
	@Field
	private DateTime dateBp1;
	@Field
	private DateTime dateBp2;
	@Field
	private DateTime dateBp3;
	@Field
	private DateTime dateLastVisit;
	@Field
	private DateTime dateNextBp;
	@Field
	private String deliveryType;
	@Field
	private int ifaTablets;
	@Field
	private DateTime ifaTablets100;
	@Field
	private String lastVisitType;
	@Field
	private String maternalEmergency;
	@Field
	private String maternalEmergencyNumber;
	@Field
	private DateTime tt1Date;
	@Field
	private DateTime tt2Date;
	@Field
	private String conceive;
	@Field
	private DateTime delFup;
	@Field
	private String availImmediate;
	@Field
	private String counselAccessible;
	@Field
	private String counselBenefits;
	@Field
	private String counselDisqualification;
	@Field
	private String counselInstitution;
	@Field
	private String counselMethods;
	@Field
	private String counselNearest;
	@Field
	private String counselOptions;
	@Field
	private String counselStay;
	@Field
	private String immediateAppropriate;
	@Field
	private String institutionImmediate;
	@Field
	private String postponeConception;
	@Field
	private String riskOfPreg;
	@Field
	private String spacingMethods;
	@Field
	private String stopChildren;
	@Field
	private int ifaTabletsTotal;
	@Field
	private String nextvisittype;
	@Field
	private String playFamilyPlanningVid;
	@Field
	private String postponing;
	@Field
	private String institutional;
	@Field
	private DateTime creationTime = new DateTime();
	@Field
	private int anc1_Weight;
	@Field
	private Integer anc1_Hemoglobin;
	@Field
	private int anc2_Weight;
	@Field
	private Integer anc2_Hemoglobin;
	@Field
	private int anc3_Weight;
	@Field
	private Integer anc3_Hemoglobin;
	@Field
	private int anc4_Weight;
	@Field
	private Integer anc4_Hemoglobin;
	@Field
	private String anaemia;
	@Field
	private String rtiSti;
	@Field
	private String whichHospital;
	@Field
	private String bleeding;
	@Field
	private String bpComplications;

	public BpForm() {
	}

	public Flw getFlw() {
		return this.flw;
	}

	public void setFlw(Flw flw) {
		this.flw = flw;
	}

	public MotherCase getMotherCase() {
		return this.motherCase;
	}

	public void setMotherCase(MotherCase motherCase) {
		this.motherCase = motherCase;
	}

	public DateTime getTimeEnd() {
		return this.timeEnd;
	}

	public void setTimeEnd(DateTime timeEnd) {
		this.timeEnd = timeEnd;
	}

	public DateTime getTimeStart() {
		return this.timeStart;
	}

	public void setTimeStart(DateTime timeStart) {
		this.timeStart = timeStart;
	}

	public DateTime getDateModified() {
		return this.dateModified;
	}

	public void setDateModified(DateTime dateModified) {
		this.dateModified = dateModified;
	}

	public DateTime getAncLatestDateTime() {
		return this.ancLatestDate;
	}

	public void setAncLatestDate(DateTime ancLatestDate) {
		this.ancLatestDate = ancLatestDate;
	}

	public Integer getAncLatestNum() {
		return this.ancLatestNum;
	}

	public void setAncLatestNum(Integer ancLatestNum) {
		this.ancLatestNum = ancLatestNum;
	}

	public String getAnc1_AbdominalExam() {
		return this.anc1_AbdominalExam;
	}

	public void setAnc1_AbdominalExam(String anc1_AbdominalExam) {
		this.anc1_AbdominalExam = anc1_AbdominalExam;
	}

	@Field
    public String getAnc1_Abnormalities() {
		return this.anc1_Abnormalities;
	}

	public void setAnc1_Abnormalities(String anc1_Abnormalities) {
		this.anc1_Abnormalities = anc1_Abnormalities;
	}

	public String getAnc1_BloodPressure() {
		return this.anc1_BloodPressure;
	}

	public void setAnc1_BloodPressure(String anc1_BloodPressure) {
		this.anc1_BloodPressure = anc1_BloodPressure;
	}

	public DateTime getAnc1_Date() {
		return this.anc1_Date;
	}

	public void setAnc1_Date(DateTime anc1_Date) {
		this.anc1_Date = anc1_Date;
	}

	public String getAnc1_Facility() {
		return this.anc1_Facility;
	}

	public void setAnc1_Facility(String anc1_Facility) {
		this.anc1_Facility = anc1_Facility;
	}

	public String getAnc1_Details() {
		return this.anc1_Details;
	}

	public void setAnc1_Details(String anc1_Details) {
		this.anc1_Details = anc1_Details;
	}

	public String getAnc2_AbdominalExam() {
		return this.anc2_AbdominalExam;
	}

	public void setAnc2_AbdominalExam(String anc2_AbdominalExam) {
		this.anc2_AbdominalExam = anc2_AbdominalExam;
	}

	public String getAnc2_Abnormalities() {
		return this.anc2_Abnormalities;
	}

	public void setAnc2_Abnormalities(String anc2_Abnormalities) {
		this.anc2_Abnormalities = anc2_Abnormalities;
	}

	public String getAnc2_BloodPressure() {
		return this.anc2_BloodPressure;
	}

	public void setAnc2_BloodPressure(String anc2_BloodPressure) {
		this.anc2_BloodPressure = anc2_BloodPressure;
	}

	public DateTime getAnc2_Date() {
		return this.anc2_Date;
	}

	public void setAnc2_Date(DateTime anc2_Date) {
		this.anc2_Date = anc2_Date;
	}

	public String getAnc2_Facility() {
		return this.anc2_Facility;
	}

	public void setAnc2_Facility(String anc2_Facility) {
		this.anc2_Facility = anc2_Facility;
	}

	public String getAnc2_Details() {
		return this.anc2_Details;
	}

	public void setAnc2_Details(String anc2_Details) {
		this.anc2_Details = anc2_Details;
	}

	public String getAnc3_AbdominalExam() {
		return this.anc3_AbdominalExam;
	}

	public void setAnc3_AbdominalExam(String anc3_AbdominalExam) {
		this.anc3_AbdominalExam = anc3_AbdominalExam;
	}

	public String getAnc3_Abnormalities() {
		return this.anc3_Abnormalities;
	}

	public void setAnc3_Abnormalities(String anc3_Abnormalities) {
		this.anc3_Abnormalities = anc3_Abnormalities;
	}

	public String getAnc3_BloodPressure() {
		return this.anc3_BloodPressure;
	}

	public void setAnc3_BloodPressure(String anc3_BloodPressure) {
		this.anc3_BloodPressure = anc3_BloodPressure;
	}

	public DateTime getAnc3_Date() {
		return this.anc3_Date;
	}

	public void setAnc3_Date(DateTime anc3_Date) {
		this.anc3_Date = anc3_Date;
	}

	public String getAnc3_Facility() {
		return this.anc3_Facility;
	}

	public void setAnc3_Facility(String anc3_Facility) {
		this.anc3_Facility = anc3_Facility;
	}

	public String getAnc3_Details() {
		return this.anc3_Details;
	}

	public void setAnc3_Details(String anc3_Details) {
		this.anc3_Details = anc3_Details;
	}

	public String getAnc4_AbdominalExam() {
		return this.anc4_AbdominalExam;
	}

	public void setAnc4_AbdominalExam(String anc4_AbdominalExam) {
		this.anc4_AbdominalExam = anc4_AbdominalExam;
	}

	public String getAnc4_Abnormalities() {
		return this.anc4_Abnormalities;
	}

	public void setAnc4_Abnormalities(String anc4_Abnormalities) {
		this.anc4_Abnormalities = anc4_Abnormalities;
	}

	public String getAnc4_BloodPressure() {
		return this.anc4_BloodPressure;
	}

	public void setAnc4_BloodPressure(String anc4_BloodPressure) {
		this.anc4_BloodPressure = anc4_BloodPressure;
	}

	public DateTime getAnc4_Date() {
		return this.anc4_Date;
	}

	public void setAnc4_Date(DateTime anc4_Date) {
		this.anc4_Date = anc4_Date;
	}

	public String getAnc4_Facility() {
		return this.anc4_Facility;
	}

	public void setAnc4_Facility(String anc4_Facility) {
		this.anc4_Facility = anc4_Facility;
	}

	public String getAnc4_Details() {
		return this.anc4_Details;
	}

	public void setAnc4_Details(String anc4_Details) {
		this.anc4_Details = anc4_Details;
	}

	public String getCounselIfa() {
		return this.counselIfa;
	}

	public void setCounselIfa(String counselIfa) {
		this.counselIfa = counselIfa;
	}

	public String getCounselTt() {
		return this.counselTt;
	}

	public void setCounselTt(String counselTt) {
		this.counselTt = counselTt;
	}

	public String getEatingExtra() {
		return this.eatingExtra;
	}

	public void setEatingExtra(String eatingExtra) {
		this.eatingExtra = eatingExtra;
	}

	public int getIfaTabletsIssued() {
		return this.ifaTabletsIssued;
	}

	public void setIfaTabletsIssued(int ifaTabletsIssued) {
		this.ifaTabletsIssued = ifaTabletsIssued;
	}

	public String getReasonNoIfa() {
		return this.reasonNoIfa;
	}

	public void setReasonNoIfa(String reasonNoIfa) {
		this.reasonNoIfa = reasonNoIfa;
	}

	public String getReceivedTt1() {
		return this.receivedTt1;
	}

	public void setReceivedTt1(String receivedTt1) {
		this.receivedTt1 = receivedTt1;
	}

	public String getReceivedTt2() {
		return this.receivedTt2;
	}

	public void setReceivedTt2(String receivedTt2) {
		this.receivedTt2 = receivedTt2;
	}

	public String getResting() {
		return this.resting;
	}

	public void setResting(String resting) {
		this.resting = resting;
	}

	public DateTime getTt1_Date() {
		return this.tt1_Date;
	}

	public void setTt1_Date(DateTime tt1_Date) {
		this.tt1_Date = tt1_Date;
	}

	public DateTime getTt2_Date() {
		return this.tt2_Date;
	}

	public void setTt2_Date(DateTime tt2_Date) {
		this.tt2_Date = tt2_Date;
	}

	public String getTtBooster() {
		return this.ttBooster;
	}

	public void setTtBooster(String ttBooster) {
		this.ttBooster = ttBooster;
	}

	public DateTime getTtBoosterDateTime() {
		return this.ttBoosterDate;
	}

	public void setTtBoosterDate(DateTime ttBoosterDate) {
		this.ttBoosterDate = ttBoosterDate;
	}

	public String getUsingIfa() {
		return this.usingIfa;
	}

	public void setUsingIfa(String usingIfa) {
		this.usingIfa = usingIfa;
	}

	public String getSba() {
		return this.sba;
	}

	public void setSba(String sba) {
		this.sba = sba;
	}

	public String getSbaPhone() {
		return this.sbaPhone;
	}

	public void setSbaPhone(String sbaPhone) {
		this.sbaPhone = sbaPhone;
	}

	public String getAccompany() {
		return this.accompany;
	}

	public void setAccompany(String accompany) {
		this.accompany = accompany;
	}

	public String getCareOfHome() {
		return this.careOfHome;
	}

	public void setCareOfHome(String careOfHome) {
		this.careOfHome = careOfHome;
	}

	public String getCleanCloth() {
		return this.cleanCloth;
	}

	public void setCleanCloth(String cleanCloth) {
		this.cleanCloth = cleanCloth;
	}

	public String getCordCare() {
		return this.cordCare;
	}

	public void setCordCare(String cordCare) {
		this.cordCare = cordCare;
	}

	public String getCounselHomeDelivery() {
		return this.counselHomeDelivery;
	}

	public void setCounselHomeDelivery(String counselHomeDelivery) {
		this.counselHomeDelivery = counselHomeDelivery;
	}

	public String getCounselInstitutional() {
		return this.counselInstitutional;
	}

	public void setCounselInstitutional(String counselInstitutional) {
		this.counselInstitutional = counselInstitutional;
	}

	public String getCounselPreparation() {
		return this.counselPreparation;
	}

	public void setCounselPreparation(String counselPreparation) {
		this.counselPreparation = counselPreparation;
	}

	public String getDangerInstitution() {
		return this.dangerInstitution;
	}

	public void setDangerInstitution(String dangerInstitution) {
		this.dangerInstitution = dangerInstitution;
	}

	public String getDangerNumber() {
		return this.dangerNumber;
	}

	public void setDangerNumber(String dangerNumber) {
		this.dangerNumber = dangerNumber;
	}

	public String getHasDangerSigns() {
		return this.hasDangerSigns;
	}

	public void setHasDangerSigns(String hasDangerSigns) {
		this.hasDangerSigns = hasDangerSigns;
	}

	public String getImmediateBreastfeeding() {
		return this.immediateBreastfeeding;
	}

	public void setImmediateBreastfeeding(String immediateBreastfeeding) {
		this.immediateBreastfeeding = immediateBreastfeeding;
	}

	public String getInformDangerSigns() {
		return this.informDangerSigns;
	}

	public void setInformDangerSigns(String informDangerSigns) {
		this.informDangerSigns = informDangerSigns;
	}

	public String getMaterials() {
		return this.materials;
	}

	public void setMaterials(String materials) {
		this.materials = materials;
	}

	public String getMaternalDangerSigns() {
		return this.maternalDangerSigns;
	}

	public void setMaternalDangerSigns(String maternalDangerSigns) {
		this.maternalDangerSigns = maternalDangerSigns;
	}

	public String getNowInstitutional() {
		return this.nowInstitutional;
	}

	public void setNowInstitutional(String nowInstitutional) {
		this.nowInstitutional = nowInstitutional;
	}

	public String getPhoneVehicle() {
		return this.phoneVehicle;
	}

	public void setPhoneVehicle(String phoneVehicle) {
		this.phoneVehicle = phoneVehicle;
	}

	public String getPlayBirthPreparednessVid() {
		return this.playBirthPreparednessVid;
	}

	public void setPlayBirthPreparednessVid(String playBirthPreparednessVid) {
		this.playBirthPreparednessVid = playBirthPreparednessVid;
	}

	public String getPlayCordCareVid() {
		return this.playCordCareVid;
	}

	public void setPlayCordCareVid(String playCordCareVid) {
		this.playCordCareVid = playCordCareVid;
	}

	public String getSavingMoney() {
		return this.savingMoney;
	}

	public void setSavingMoney(String savingMoney) {
		this.savingMoney = savingMoney;
	}

	public String getSkinToSkin() {
		return this.skinToSkin;
	}

	public void setSkinToSkin(String skinToSkin) {
		this.skinToSkin = skinToSkin;
	}

	public String getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	public String getWrapping() {
		return this.wrapping;
	}

	public void setWrapping(String wrapping) {
		this.wrapping = wrapping;
	}

	public int getBpVisitNum() {
		return this.bpVisitNum;
	}

	public void setBpVisitNum(int bpVisitNum) {
		this.bpVisitNum = bpVisitNum;
	}

	public DateTime getAnc1DateTime() {
		return this.anc1Date;
	}

	public void setAnc1Date(DateTime anc1Date) {
		this.anc1Date = anc1Date;
	}

	public DateTime getAnc2DateTime() {
		return this.anc2Date;
	}

	public void setAnc2Date(DateTime anc2Date) {
		this.anc2Date = anc2Date;
	}

	public DateTime getAnc3DateTime() {
		return this.anc3Date;
	}

	public void setAnc3Date(DateTime anc3Date) {
		this.anc3Date = anc3Date;
	}

	public DateTime getAnc4DateTime() {
		return this.anc4Date;
	}

	public void setAnc4Date(DateTime anc4Date) {
		this.anc4Date = anc4Date;
	}

	public String getCoupleInterested() {
		return this.coupleInterested;
	}

	public void setCoupleInterested(String coupleInterested) {
		this.coupleInterested = coupleInterested;
	}

	public DateTime getDateBp1() {
		return this.dateBp1;
	}

	public void setDateBp1(DateTime dateBp1) {
		this.dateBp1 = dateBp1;
	}

	public DateTime getDateBp2() {
		return this.dateBp2;
	}

	public void setDateBp2(DateTime dateBp2) {
		this.dateBp2 = dateBp2;
	}

	public DateTime getDateBp3() {
		return this.dateBp3;
	}

	public void setDateBp3(DateTime dateBp3) {
		this.dateBp3 = dateBp3;
	}

	public DateTime getDateLastVisit() {
		return this.dateLastVisit;
	}

	public void setDateLastVisit(DateTime dateLastVisit) {
		this.dateLastVisit = dateLastVisit;
	}

	public DateTime getDateNextBp() {
		return this.dateNextBp;
	}

	public void setDateNextBp(DateTime dateNextBp) {
		this.dateNextBp = dateNextBp;
	}

	public String getDeliveryType() {
		return this.deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public int getIfaTablets() {
		return this.ifaTablets;
	}

	public void setIfaTablets(int ifaTablets) {
		this.ifaTablets = ifaTablets;
	}

	public DateTime getIfaTablets100() {
		return this.ifaTablets100;
	}

	public void setIfaTablets100(DateTime ifaTablets100) {
		this.ifaTablets100 = ifaTablets100;
	}

	public String getLastVisitType() {
		return this.lastVisitType;
	}

	public void setLastVisitType(String lastVisitType) {
		this.lastVisitType = lastVisitType;
	}

	public String getMaternalEmergency() {
		return this.maternalEmergency;
	}

	public void setMaternalEmergency(String maternalEmergency) {
		this.maternalEmergency = maternalEmergency;
	}

	public String getMaternalEmergencyNumber() {
		return this.maternalEmergencyNumber;
	}

	public void setMaternalEmergencyNumber(String maternalEmergencyNumber) {
		this.maternalEmergencyNumber = maternalEmergencyNumber;
	}

	public DateTime getTt1DateTime() {
		return this.tt1Date;
	}

	public void setTt1Date(DateTime tt1Date) {
		this.tt1Date = tt1Date;
	}

	public DateTime getTt2DateTime() {
		return this.tt2Date;
	}

	public void setTt2Date(DateTime tt2Date) {
		this.tt2Date = tt2Date;
	}

	public String getConceive() {
		return this.conceive;
	}

	public void setConceive(String conceive) {
		this.conceive = conceive;
	}

	public DateTime getDelFup() {
		return this.delFup;
	}

	public void setDelFup(DateTime delFup) {
		this.delFup = delFup;
	}

	public String getAvailImmediate() {
		return this.availImmediate;
	}

	public void setAvailImmediate(String availImmediate) {
		this.availImmediate = availImmediate;
	}

	public String getCounselAccessible() {
		return this.counselAccessible;
	}

	public void setCounselAccessible(String counselAccessible) {
		this.counselAccessible = counselAccessible;
	}

	public String getCounselBenefits() {
		return this.counselBenefits;
	}

	public void setCounselBenefits(String counselBenefits) {
		this.counselBenefits = counselBenefits;
	}

	public String getCounselDisqualification() {
		return this.counselDisqualification;
	}

	public void setCounselDisqualification(String counselDisqualification) {
		this.counselDisqualification = counselDisqualification;
	}

	public String getCounselInstitution() {
		return this.counselInstitution;
	}

	public void setCounselInstitution(String counselInstitution) {
		this.counselInstitution = counselInstitution;
	}

	public String getCounselMethods() {
		return this.counselMethods;
	}

	public void setCounselMethods(String counselMethods) {
		this.counselMethods = counselMethods;
	}

	public String getCounselNearest() {
		return this.counselNearest;
	}

	public void setCounselNearest(String counselNearest) {
		this.counselNearest = counselNearest;
	}

	public String getCounselOptions() {
		return this.counselOptions;
	}

	public void setCounselOptions(String counselOptions) {
		this.counselOptions = counselOptions;
	}

	public String getCounselStay() {
		return this.counselStay;
	}

	public void setCounselStay(String counselStay) {
		this.counselStay = counselStay;
	}

	public String getImmediateAppropriate() {
		return this.immediateAppropriate;
	}

	public void setImmediateAppropriate(String immediateAppropriate) {
		this.immediateAppropriate = immediateAppropriate;
	}

	public String getInstitutionImmediate() {
		return this.institutionImmediate;
	}

	public void setInstitutionImmediate(String institutionImmediate) {
		this.institutionImmediate = institutionImmediate;
	}

	public String getPostponeConception() {
		return this.postponeConception;
	}

	public void setPostponeConception(String postponeConception) {
		this.postponeConception = postponeConception;
	}

	public String getRiskOfPreg() {
		return this.riskOfPreg;
	}

	public void setRiskOfPreg(String riskOfPreg) {
		this.riskOfPreg = riskOfPreg;
	}

	public String getSpacingMethods() {
		return this.spacingMethods;
	}

	public void setSpacingMethods(String spacingMethods) {
		this.spacingMethods = spacingMethods;
	}

	public String getStopChildren() {
		return this.stopChildren;
	}

	public void setStopChildren(String stopChildren) {
		this.stopChildren = stopChildren;
	}

	public int getIfaTabletsTotal() {
		return this.ifaTabletsTotal;
	}

	public void setIfaTabletsTotal(int ifaTabletsTotal) {
		this.ifaTabletsTotal = ifaTabletsTotal;
	}

	public String getNextvisittype() {
		return this.nextvisittype;
	}

	public void setNextvisittype(String nextvisittype) {
		this.nextvisittype = nextvisittype;
	}

	public String getPlayFamilyPlanningVid() {
		return this.playFamilyPlanningVid;
	}

	public void setPlayFamilyPlanningVid(String playFamilyPlanningVid) {
		this.playFamilyPlanningVid = playFamilyPlanningVid;
	}

	public String getPostponing() {
		return this.postponing;
	}

	public void setPostponing(String postponing) {
		this.postponing = postponing;
	}

	public String getInstitutional() {
		return this.institutional;
	}

	public void setInstitutional(String institutional) {
		this.institutional = institutional;
	}

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

	public int getAnc1_Weight() {
		return anc1_Weight;
	}

	public void setAnc1_Weight(int anc1_Weight) {
		this.anc1_Weight = anc1_Weight;
	}

	public Integer getAnc1_Hemoglobin() {
		return anc1_Hemoglobin;
	}

	public void setAnc1_Hemoglobin(Integer anc1_Hemoglobin) {
		this.anc1_Hemoglobin = anc1_Hemoglobin;
	}

	public int getAnc2_Weight() {
		return anc2_Weight;
	}

	public void setAnc2_Weight(int anc2_Weight) {
		this.anc2_Weight = anc2_Weight;
	}

	public Integer getAnc2_Hemoglobin() {
		return anc2_Hemoglobin;
	}

	public void setAnc2_Hemoglobin(Integer anc2_Hemoglobin) {
		this.anc2_Hemoglobin = anc2_Hemoglobin;
	}

	public int getAnc3_Weight() {
		return anc3_Weight;
	}

	public void setAnc3_Weight(int anc3_Weight) {
		this.anc3_Weight = anc3_Weight;
	}

	public Integer getAnc3_Hemoglobin() {
		return anc3_Hemoglobin;
	}

	public void setAnc3_Hemoglobin(Integer anc3_Hemoglobin) {
		this.anc3_Hemoglobin = anc3_Hemoglobin;
	}

	public int getAnc4_Weight() {
		return anc4_Weight;
	}

	public void setAnc4_Weight(int anc4_Weight) {
		this.anc4_Weight = anc4_Weight;
	}

	public Integer getAnc4_Hemoglobin() {
		return anc4_Hemoglobin;
	}

	public void setAnc4_Hemoglobin(Integer anc4_Hemoglobin) {
		this.anc4_Hemoglobin = anc4_Hemoglobin;
	}

	public String getAnaemia() {
		return anaemia;
	}

	public void setAnaemia(String anaemia) {
		this.anaemia = anaemia;
	}

	public String getRtiSti() {
		return rtiSti;
	}

	public void setRtiSti(String rtiSti) {
		this.rtiSti = rtiSti;
	}

	public String getWhichHospital() {
		return whichHospital;
	}

	public void setWhichHospital(String whichHospital) {
		this.whichHospital = whichHospital;
	}

	public String getBleeding() {
		return bleeding;
	}

	public void setBleeding(String bleeding) {
		this.bleeding = bleeding;
	}

	public String getBpComplications() {
		return bpComplications;
	}

	public void setBpComplications(String bpComplications) {
		this.bpComplications = bpComplications;
	}
}
