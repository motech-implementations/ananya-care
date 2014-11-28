package org.motechproject.mcts.care.common.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.mcts.care.common.mds.dimension.Flw;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
import org.motechproject.mcts.care.common.utils.FormToString;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(name = "delivery_mother_form")
@Unique(members = "instanceId")
public class DeliveryMotherForm extends Form {

    private static final long serialVersionUID = -9135512533444340625L;

    private Flw flw;
    private MotherCase motherCase;
    private DateTime timeEnd;
    private DateTime timeStart;
    private DateTime dateModified;
    private String ppiud;
    private String pptl;
    private String abdPain;
    private DateTime add;
    private String birthPlace;
    private DateTime dateDelFu;
    private DateTime dateLastVisit;
    private DateTime dateNextCf;
    private DateTime dateNextEb;
    private DateTime dateNextPnc;
    private String familyPlanningType;
    private String lastVisitType;
    private String motherAlive;
    private String term;
    private int castNumChildren;
    private String complications;
    private DateTime dateDeath;
    private String deathVillage;
    private String deliveryNature;
    private String fever;
    private String hasDelivered;
    private int howManyChildren;
    private String ifaTabletsGiven;
    private String inDistrict;
    private String jsyMoney;
    private String nextvisittype;
    private DateTime notified;
    private int numChildren;
    private String otherConditions;
    private String otherDistrict;
    private String otherVillage;
    private String painUrine;
    private String placeDeath;
    private String postPostpartumFp;
    private String safe;
    private String siteDeath;
    private String vaginalDischarge;
    private String whereBorn;
    private String whichHospital;
    private String whichVillage;
    private Boolean close;
    private DateTime creationTime = new DateTime();
    private DateTime jsyMoneyDate;
    private String deliveryComplications;
    private DateTime dischargeDate;
    private String dischargeTime;
    private String whoAssisted;
    private String bleeding;
    private String homeSbaAssist;
    private Integer ageCurrentWeight;
    private Integer ageLastWeight;

    public DeliveryMotherForm() {
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
    public DateTime getAdd() {
        return this.add;
    }

    public void setAdd(DateTime add) {
        this.add = add;
    }

    @Field
    public String getBirthPlace() {
        return this.birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    @Field
    public DateTime getDateDelFu() {
        return this.dateDelFu;
    }

    public void setDateDelFu(DateTime dateDelFu) {
        this.dateDelFu = dateDelFu;
    }

    @Field
    public DateTime getDateLastVisit() {
        return this.dateLastVisit;
    }

    public void setDateLastVisit(DateTime dateLastVisit) {
        this.dateLastVisit = dateLastVisit;
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
    public String getFamilyPlanningType() {
        return this.familyPlanningType;
    }

    public void setFamilyPlanningType(String familyPlanningType) {
        this.familyPlanningType = familyPlanningType;
    }

    @Field
    public String getLastVisitType() {
        return this.lastVisitType;
    }

    public void setLastVisitType(String lastVisitType) {
        this.lastVisitType = lastVisitType;
    }

    @Field
    public String getMotherAlive() {
        return this.motherAlive;
    }

    public void setMotherAlive(String motherAlive) {
        this.motherAlive = motherAlive;
    }

    @Field
    public String getTerm() {
        return this.term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    @Field
    public int getCastNumChildren() {
        return this.castNumChildren;
    }

    public void setCastNumChildren(int castNumChildren) {
        this.castNumChildren = castNumChildren;
    }

    @Field
    public String getComplications() {
        return this.complications;
    }

    public void setComplications(String complications) {
        this.complications = complications;
    }

    @Field
    public DateTime getDateDeath() {
        return this.dateDeath;
    }

    public void setDateDeath(DateTime dateDeath) {
        this.dateDeath = dateDeath;
    }

    @Field
    public String getDeathVillage() {
        return this.deathVillage;
    }

    public void setDeathVillage(String deathVillage) {
        this.deathVillage = deathVillage;
    }

    @Field
    public String getDeliveryNature() {
        return this.deliveryNature;
    }

    public void setDeliveryNature(String deliveryNature) {
        this.deliveryNature = deliveryNature;
    }

    @Field
    public String getFever() {
        return this.fever;
    }

    public void setFever(String fever) {
        this.fever = fever;
    }

    @Field
    public String getHasDelivered() {
        return this.hasDelivered;
    }

    public void setHasDelivered(String hasDelivered) {
        this.hasDelivered = hasDelivered;
    }

    @Field
    public int getHowManyChildren() {
        return this.howManyChildren;
    }

    public void setHowManyChildren(int howManyChildren) {
        this.howManyChildren = howManyChildren;
    }

    @Field
    public String getIfaTabletsGiven() {
        return this.ifaTabletsGiven;
    }

    public void setIfaTabletsGiven(String ifaTabletsGiven) {
        this.ifaTabletsGiven = ifaTabletsGiven;
    }

    @Field
    public String getInDistrict() {
        return this.inDistrict;
    }

    public void setInDistrict(String inDistrict) {
        this.inDistrict = inDistrict;
    }

    @Field
    public String getJsyMoney() {
        return this.jsyMoney;
    }

    public void setJsyMoney(String jsyMoney) {
        this.jsyMoney = jsyMoney;
    }

    @Field
    public String getNextvisittype() {
        return this.nextvisittype;
    }

    public void setNextvisittype(String nextvisittype) {
        this.nextvisittype = nextvisittype;
    }

    @Field
    public DateTime getNotified() {
        return this.notified;
    }

    public void setNotified(DateTime notified) {
        this.notified = notified;
    }

    @Field
    public int getNumChildren() {
        return this.numChildren;
    }

    public void setNumChildren(int numChildren) {
        this.numChildren = numChildren;
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
    public String getPlaceDeath() {
        return this.placeDeath;
    }

    public void setPlaceDeath(String placeDeath) {
        this.placeDeath = placeDeath;
    }

    @Field
    public String getPostPostpartumFp() {
        return this.postPostpartumFp;
    }

    public void setPostPostpartumFp(String postPostpartumFp) {
        this.postPostpartumFp = postPostpartumFp;
    }

    @Field
    public String getSafe() {
        return this.safe;
    }

    public void setSafe(String safe) {
        this.safe = safe;
    }

    @Field
    public String getSiteDeath() {
        return this.siteDeath;
    }

    public void setSiteDeath(String siteDeath) {
        this.siteDeath = siteDeath;
    }

    @Field
    public String getVaginalDischarge() {
        return this.vaginalDischarge;
    }

    public void setVaginalDischarge(String vaginalDischarge) {
        this.vaginalDischarge = vaginalDischarge;
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

    @Field
    public Boolean getClose() {
        return this.close;
    }

    public void setClose(Boolean close) {
        this.close = close;
    }

    @Override
    public String toString() {
        return FormToString.toString(this);
    }

    @Field
    public DateTime getJsyMoneyDate() {
        return jsyMoneyDate;
    }

    public void setJsyMoneyDate(DateTime jsyMoneyDate) {
        this.jsyMoneyDate = jsyMoneyDate;
    }

    @Field
    public String getDeliveryComplications() {
        return deliveryComplications;
    }

    public void setDeliveryComplications(String deliveryComplications) {
        this.deliveryComplications = deliveryComplications;
    }

    @Field
    public DateTime getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(DateTime dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    @Field
    public String getDischargeTime() {
        return dischargeTime;
    }

    public void setDischargeTime(String dischargeTime) {
        this.dischargeTime = dischargeTime;
    }

    @Field
    public String getWhoAssisted() {
        return whoAssisted;
    }

    public void setWhoAssisted(String whoAssisted) {
        this.whoAssisted = whoAssisted;
    }

    @Field
    public String getBleeding() {
        return bleeding;
    }

    public void setBleeding(String bleeding) {
        this.bleeding = bleeding;
    }

    @Field
    public String getHomeSbaAssist() {
        return homeSbaAssist;
    }

    public void setHomeSbaAssist(String homeSbaAssist) {
        this.homeSbaAssist = homeSbaAssist;
    }

    @Field
    public Integer getAgeCurrentWeight() {
        return ageCurrentWeight;
    }

    public void setAgeCurrentWeight(Integer ageCurrentWeight) {
        this.ageCurrentWeight = ageCurrentWeight;
    }

    @Field
    public Integer getAgeLastWeight() {
        return ageLastWeight;
    }

    public void setAgeLastWeight(Integer ageLastWeight) {
        this.ageLastWeight = ageLastWeight;
    }
}
