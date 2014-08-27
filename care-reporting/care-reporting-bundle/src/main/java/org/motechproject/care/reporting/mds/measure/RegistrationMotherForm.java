package org.motechproject.care.reporting.mds.measure;


import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.care.reporting.utils.FormToString;
import org.motechproject.mcts.care.common.mds.dimension.Flw;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
import org.motechproject.mcts.care.common.mds.measure.Form;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;


@Entity(name = "registration_mother_form")
@Unique(members = "instance_id")
public class RegistrationMotherForm extends Form {

	private Flw flw;
	private MotherCase motherCase;
	private DateTime timeEnd;
	private DateTime timeStart;
	private DateTime dateModified;
	private String ppiud;
	private String pptl;
	private String abdPain;
	private int ageCalc;
	private int ageCalcAdj;
	private int ageEst;
	private String ageEstTrigger;
	private DateTime add;
	private int age;
	private String birthPlace;
	private String complications;
	private DateTime dateLastVisit;
	private DateTime dateNextBp;
	private DateTime dateNextCf;
	private DateTime dateNextEb;
	private DateTime dateNextPnc;
	private String eatsMeat;
	private DateTime edd;
	private String enrolledInKilkari;
	private String familyPlanningType;
	private int howManyChildren;
	private String interestInKilkari;
	private String lastPregTt;
	private String lastVisitType;
	private DateTime lmp;
	private String mobileNumber;
	private DateTime motherDob;
	private int numBoys;
	private String status;
	private DateTime childDob;
    private String clientNoRegister;
	private String clientNotPregnant;
	private String clinicalExam;
	private String condoms;
	private String continuePreg;
	private String deliveryNature;
	private String dobEst;
	private DateTime eddCalc;
	private String eddKnown;
	private String education;
	private String fever;
	private String firstPregnancy;
	private int gestAge;
	private String goodToRegister;
	private String inDistrict;
	private String injectible;
	private String isPregnant;
	private String iudUsed;
	private String jsyBeneficiary;
	private String jsyMoney;
	private Integer lastPreg;
	private String lastPregCSection;
	private String lastPregFullTerm;
	private DateTime lmpCalc;
	private String lmpKnown;
	private String missedPeriod;
	private String mobileNumberWhose;
	private String nextvisit;
	private String nextvisitBp;
	private String nextvisittype;
	private int numChildren;
	private int numGirls;
	private String ocpUsed;
	private String otherConditions;
	private String otherDistrict;
	private String otherVillage;
	private String painUrine;
	private String postPostpartumFp;
	private String pregDesired;
	private String recentlyDelivered;
	private String referralPrompt;
	private String resident;
	private String urineTest;
	private String usedFp;
	private String vaginalDischarge;
	private String vegetarian;
	private String whereBorn;
	private String whichHospital;
	private String whichVillage;
	private String children;
    private Boolean close;

    private DateTime creationTime = new DateTime();

    public RegistrationMotherForm() {
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
	public String getPpiud() {
		return this.ppiud;
	}

	public void setPpiud(String ppiud) {
		this.ppiud = ppiud;
	}

	@Field
	public String getPptl() {
		return this.pptl;
	}

	public void setPptl(String pptl) {
		this.pptl = pptl;
	}

	@Field
	public String getAbdPain() {
		return this.abdPain;
	}

	public void setAbdPain(String abdPain) {
		this.abdPain = abdPain;
	}

	@Field
	public int getAgeCalc() {
		return this.ageCalc;
	}

	public void setAgeCalc(int ageCalc) {
		this.ageCalc = ageCalc;
	}

	@Field
	public int getAgeCalcAdj() {
		return this.ageCalcAdj;
	}

	public void setAgeCalcAdj(int ageCalcAdj) {
		this.ageCalcAdj = ageCalcAdj;
	}

	@Field
	public int getAgeEst() {
		return this.ageEst;
	}

	public void setAgeEst(int ageEst) {
		this.ageEst = ageEst;
	}

	@Field
	public String getAgeEstTrigger() {
		return this.ageEstTrigger;
	}

	public void setAgeEstTrigger(String ageEstTrigger) {
		this.ageEstTrigger = ageEstTrigger;
	}

	@Field
	public DateTime getAdd() {
		return this.add;
	}

	public void setAdd(DateTime add) {
		this.add = add;
	}

	@Field
	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Field
	public String getBirthPlace() {
		return this.birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	@Field
	public String getComplications() {
		return this.complications;
	}

	public void setComplications(String complications) {
		this.complications = complications;
	}

	@Field
	public DateTime getDateLastVisit() {
		return this.dateLastVisit;
	}

	public void setDateLastVisit(DateTime dateLastVisit) {
		this.dateLastVisit = dateLastVisit;
	}

	@Field
	public DateTime getDateNextBp() {
		return this.dateNextBp;
	}

	public void setDateNextBp(DateTime dateNextBp) {
		this.dateNextBp = dateNextBp;
	}

	@Field
	public DateTime getDateNextCf() {
		return this.dateNextCf;
	}

	public void setDateNextCf(DateTime dateNextCf) {
		this.dateNextCf = dateNextCf;
	}

	@Field
	public DateTime getDateNextEb() {
		return this.dateNextEb;
	}

	public void setDateNextEb(DateTime dateNextEb) {
		this.dateNextEb = dateNextEb;
	}

	@Field
	public DateTime getDateNextPnc() {
		return this.dateNextPnc;
	}

	public void setDateNextPnc(DateTime dateNextPnc) {
		this.dateNextPnc = dateNextPnc;
	}

	@Field
	public String getEatsMeat() {
		return this.eatsMeat;
	}

	public void setEatsMeat(String eatsMeat) {
		this.eatsMeat = eatsMeat;
	}

	@Field
	public DateTime getEdd() {
		return this.edd;
	}

	public void setEdd(DateTime edd) {
		this.edd = edd;
	}

	@Field
	public String getEnrolledInKilkari() {
		return this.enrolledInKilkari;
	}

	public void setEnrolledInKilkari(String enrolledInKilkari) {
		this.enrolledInKilkari = enrolledInKilkari;
	}

	@Field
	public String getFamilyPlanningType() {
		return this.familyPlanningType;
	}

	public void setFamilyPlanningType(String familyPlanningType) {
		this.familyPlanningType = familyPlanningType;
	}

	@Field
	public int getHowManyChildren() {
		return this.howManyChildren;
	}

	public void setHowManyChildren(int howManyChildren) {
		this.howManyChildren = howManyChildren;
	}

	@Field
	public String getInterestInKilkari() {
		return this.interestInKilkari;
	}

	public void setInterestInKilkari(String interestInKilkari) {
		this.interestInKilkari = interestInKilkari;
	}

	@Field
	public String getLastPregTt() {
		return this.lastPregTt;
	}

	public void setLastPregTt(String lastPregTt) {
		this.lastPregTt = lastPregTt;
	}

	@Field
	public String getLastVisitType() {
		return this.lastVisitType;
	}

	public void setLastVisitType(String lastVisitType) {
		this.lastVisitType = lastVisitType;
	}

	@Field
	public DateTime getLmp() {
		return this.lmp;
	}

	public void setLmp(DateTime lmp) {
		this.lmp = lmp;
	}

	@Field
	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Field
	public DateTime getMotherDob() {
		return this.motherDob;
	}

	public void setMotherDob(DateTime motherDob) {
		this.motherDob = motherDob;
	}

	@Field
	public int getNumBoys() {
		return this.numBoys;
	}

	public void setNumBoys(int numBoys) {
		this.numBoys = numBoys;
	}

	@Field
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Field
	public DateTime getChildDob() {
		return this.childDob;
	}

	public void setChildDob(DateTime childDob) {
		this.childDob = childDob;
	}

    @Field
	public String getClientNoRegister() {
		return this.clientNoRegister;
	}

	public void setClientNoRegister(String clientNoRegister) {
		this.clientNoRegister = clientNoRegister;
	}

	@Field
	public String getClientNotPregnant() {
		return this.clientNotPregnant;
	}

	public void setClientNotPregnant(String clientNotPregnant) {
		this.clientNotPregnant = clientNotPregnant;
	}

	@Field
	public String getClinicalExam() {
		return this.clinicalExam;
	}

	public void setClinicalExam(String clinicalExam) {
		this.clinicalExam = clinicalExam;
	}

	@Field
	public String getCondoms() {
		return this.condoms;
	}

	public void setCondoms(String condoms) {
		this.condoms = condoms;
	}

	@Field
	public String getContinuePreg() {
		return this.continuePreg;
	}

	public void setContinuePreg(String continuePreg) {
		this.continuePreg = continuePreg;
	}

	@Field
	public String getDeliveryNature() {
		return this.deliveryNature;
	}

	public void setDeliveryNature(String deliveryNature) {
		this.deliveryNature = deliveryNature;
	}

	@Field
	public String getDobEst() {
		return this.dobEst;
	}

	public void setDobEst(String dobEst) {
		this.dobEst = dobEst;
	}

	@Field
	public DateTime getEddCalc() {
		return this.eddCalc;
	}

	public void setEddCalc(DateTime eddCalc) {
		this.eddCalc = eddCalc;
	}

	@Field
	public String getEddKnown() {
		return this.eddKnown;
	}

	public void setEddKnown(String eddKnown) {
		this.eddKnown = eddKnown;
	}

	@Field
	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	@Field
	public String getFever() {
		return this.fever;
	}

	public void setFever(String fever) {
		this.fever = fever;
	}

	@Field
	public String getFirstPregnancy() {
		return this.firstPregnancy;
	}

	public void setFirstPregnancy(String firstPregnancy) {
		this.firstPregnancy = firstPregnancy;
	}

	@Field
	public int getGestAge() {
		return this.gestAge;
	}

	public void setGestAge(int gestAge) {
		this.gestAge = gestAge;
	}

	@Field
	public String getGoodToRegister() {
		return this.goodToRegister;
	}

	public void setGoodToRegister(String goodToRegister) {
		this.goodToRegister = goodToRegister;
	}

	@Field
	public String getInDistrict() {
		return this.inDistrict;
	}

	public void setInDistrict(String inDistrict) {
		this.inDistrict = inDistrict;
	}

	@Field
	public String getInjectible() {
		return this.injectible;
	}

	public void setInjectible(String injectible) {
		this.injectible = injectible;
	}

	@Field
	public String getIsPregnant() {
		return this.isPregnant;
	}

	public void setIsPregnant(String isPregnant) {
		this.isPregnant = isPregnant;
	}

	@Field
	public String getIudUsed() {
		return this.iudUsed;
	}

	public void setIudUsed(String iudUsed) {
		this.iudUsed = iudUsed;
	}

	@Field
	public String getJsyBeneficiary() {
		return this.jsyBeneficiary;
	}

	public void setJsyBeneficiary(String jsyBeneficiary) {
		this.jsyBeneficiary = jsyBeneficiary;
	}

	@Field
	public String getJsyMoney() {
		return this.jsyMoney;
	}

	public void setJsyMoney(String jsyMoney) {
		this.jsyMoney = jsyMoney;
	}

	@Field
	public Integer getLastPreg() {
		return this.lastPreg;
	}

	public void setLastPreg(Integer lastPreg) {
		this.lastPreg = lastPreg;
	}

	@Field
	public String getLastPregCSection() {
		return this.lastPregCSection;
	}

	public void setLastPregCSection(String lastPregCSection) {
		this.lastPregCSection = lastPregCSection;
	}

	@Field
	public String getLastPregFullTerm() {
		return this.lastPregFullTerm;
	}

	public void setLastPregFullTerm(String lastPregFullTerm) {
		this.lastPregFullTerm = lastPregFullTerm;
	}

	@Field
	public DateTime getLmpCalc() {
		return this.lmpCalc;
	}

	public void setLmpCalc(DateTime lmpCalc) {
		this.lmpCalc = lmpCalc;
	}

	@Field
	public String getLmpKnown() {
		return this.lmpKnown;
	}

	public void setLmpKnown(String lmpKnown) {
		this.lmpKnown = lmpKnown;
	}

	@Field
	public String getMissedPeriod() {
		return this.missedPeriod;
	}

	public void setMissedPeriod(String missedPeriod) {
		this.missedPeriod = missedPeriod;
	}

	@Field
	public String getMobileNumberWhose() {
		return this.mobileNumberWhose;
	}

	public void setMobileNumberWhose(String mobileNumberWhose) {
		this.mobileNumberWhose = mobileNumberWhose;
	}

	@Field
	public String getNextvisit() {
		return this.nextvisit;
	}

	public void setNextvisit(String nextvisit) {
		this.nextvisit = nextvisit;
	}

	@Field
	public String getNextvisitBp() {
		return this.nextvisitBp;
	}

	public void setNextvisitBp(String nextvisitBp) {
		this.nextvisitBp = nextvisitBp;
	}

	@Field
	public String getNextvisittype() {
		return this.nextvisittype;
	}

	public void setNextvisittype(String nextvisittype) {
		this.nextvisittype = nextvisittype;
	}

	@Field
	public int getNumChildren() {
		return this.numChildren;
	}

	public void setNumChildren(int numChildren) {
		this.numChildren = numChildren;
	}

	@Field
	public int getNumGirls() {
		return this.numGirls;
	}

	public void setNumGirls(int numGirls) {
		this.numGirls = numGirls;
	}

	@Field
	public String getOcpUsed() {
		return this.ocpUsed;
	}

	public void setOcpUsed(String ocpUsed) {
		this.ocpUsed = ocpUsed;
	}

	@Field
	public String getOtherConditions() {
		return this.otherConditions;
	}

	public void setOtherConditions(String otherConditions) {
		this.otherConditions = otherConditions;
	}

	@Field
	public String getOtherDistrict() {
		return this.otherDistrict;
	}

	public void setOtherDistrict(String otherDistrict) {
		this.otherDistrict = otherDistrict;
	}

	@Field
	public String getOtherVillage() {
		return this.otherVillage;
	}

	public void setOtherVillage(String otherVillage) {
		this.otherVillage = otherVillage;
	}

	@Field
	public String getPainUrine() {
		return this.painUrine;
	}

	public void setPainUrine(String painUrine) {
		this.painUrine = painUrine;
	}

	@Field
	public String getPostPostpartumFp() {
		return this.postPostpartumFp;
	}

	public void setPostPostpartumFp(String postPostpartumFp) {
		this.postPostpartumFp = postPostpartumFp;
	}

	@Field
	public String getPregDesired() {
		return this.pregDesired;
	}

	public void setPregDesired(String pregDesired) {
		this.pregDesired = pregDesired;
	}

	@Field
	public String getRecentlyDelivered() {
		return this.recentlyDelivered;
	}

	public void setRecentlyDelivered(String recentlyDelivered) {
		this.recentlyDelivered = recentlyDelivered;
	}

	@Field
	public String getReferralPrompt() {
		return this.referralPrompt;
	}

	public void setReferralPrompt(String referralPrompt) {
		this.referralPrompt = referralPrompt;
	}

	@Field
	public String getResident() {
		return this.resident;
	}

	public void setResident(String resident) {
		this.resident = resident;
	}

	@Field
	public String getUrineTest() {
		return this.urineTest;
	}

	public void setUrineTest(String urineTest) {
		this.urineTest = urineTest;
	}

	@Field
	public String getUsedFp() {
		return this.usedFp;
	}

	public void setUsedFp(String usedFp) {
		this.usedFp = usedFp;
	}

	@Field
	public String getVaginalDischarge() {
		return this.vaginalDischarge;
	}

	public void setVaginalDischarge(String vaginalDischarge) {
		this.vaginalDischarge = vaginalDischarge;
	}

	@Field
	public String getVegetarian() {
		return this.vegetarian;
	}

	public void setVegetarian(String vegetarian) {
		this.vegetarian = vegetarian;
	}

	@Field
	public String getWhereBorn() {
		return this.whereBorn;
	}

	public void setWhereBorn(String whereBorn) {
		this.whereBorn = whereBorn;
	}

	@Field
	public String getWhichHospital() {
		return this.whichHospital;
	}

	public void setWhichHospital(String whichHospital) {
		this.whichHospital = whichHospital;
	}

	@Field
	public String getWhichVillage() {
		return this.whichVillage;
	}

	public void setWhichVillage(String whichVillage) {
		this.whichVillage = whichVillage;
	}

    @Field
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

    @Field
    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    @Field
    public Boolean getClose() {
        return close;
    }

    public void setClose(Boolean close) {
        this.close = close;
    }

}
