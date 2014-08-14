package org.motechproject.care.reporting.mds.measure;

import javax.jdo.annotations.Unique;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.joda.time.DateTime;
import org.motechproject.care.reporting.domain.dimension.Flw;
import org.motechproject.care.reporting.domain.dimension.MotherCase;
import org.motechproject.care.reporting.utils.FormToString;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;


@Entity(name = "delivery_mother_form")
@Unique(members = "instance_id")
public class DeliveryMotherForm extends Form {

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
	private Short castNumChildren;
	private String complications;
	private DateTime dateDeath;
	private String deathVillage;
	private String deliveryNature;
	private String fever;
	private String hasDelivered;
	private Short howManyChildren;
	private String ifaTabletsGiven;
	private String inDistrict;
	private String jsyMoney;
	private String nextvisittype;
	private DateTime notified;
	private Short numChildren;
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

	@Field(name = "ppiud")
	public String getPpiud() {
		return this.ppiud;
	}

	public void setPpiud(String ppiud) {
		this.ppiud = ppiud;
	}

	@Field(name = "pptl")
	public String getPptl() {
		return this.pptl;
	}

	public void setPptl(String pptl) {
		this.pptl = pptl;
	}

	@Field(name = "abd_pain")
	public String getAbdPain() {
		return this.abdPain;
	}

	public void setAbdPain(String abdPain) {
		this.abdPain = abdPain;
	}

	
	@Field(name = "add")
	public DateTime getAdd() {
		return this.add;
	}

	public void setAdd(DateTime add) {
		this.add = add;
	}

	@Field(name = "birth_place")
	public String getBirthPlace() {
		return this.birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	
	@Field(name = "date_del_fu")
	public DateTime getDateDelFu() {
		return this.dateDelFu;
	}

	public void setDateDelFu(DateTime dateDelFu) {
		this.dateDelFu = dateDelFu;
	}

	
	@Field(name = "date_last_visit")
	public DateTime getDateLastVisit() {
		return this.dateLastVisit;
	}

	public void setDateLastVisit(DateTime dateLastVisit) {
		this.dateLastVisit = dateLastVisit;
	}

	
	@Field(name = "date_next_cf")
	public DateTime getDateNextCf() {
		return this.dateNextCf;
	}

	public void setDateNextCf(DateTime dateNextCf) {
		this.dateNextCf = dateNextCf;
	}

	
	@Field(name = "date_next_eb")
	public DateTime getDateNextEb() {
		return this.dateNextEb;
	}

	public void setDateNextEb(DateTime dateNextEb) {
		this.dateNextEb = dateNextEb;
	}

	
	@Field(name = "date_next_pnc")
	public DateTime getDateNextPnc() {
		return this.dateNextPnc;
	}

	public void setDateNextPnc(DateTime dateNextPnc) {
		this.dateNextPnc = dateNextPnc;
	}

	@Field(name = "family_planning_type")
	public String getFamilyPlanningType() {
		return this.familyPlanningType;
	}

	public void setFamilyPlanningType(String familyPlanningType) {
		this.familyPlanningType = familyPlanningType;
	}

	@Field(name = "last_visit_type")
	public String getLastVisitType() {
		return this.lastVisitType;
	}

	public void setLastVisitType(String lastVisitType) {
		this.lastVisitType = lastVisitType;
	}

	@Field(name = "mother_alive")
	public String getMotherAlive() {
		return this.motherAlive;
	}

	public void setMotherAlive(String motherAlive) {
		this.motherAlive = motherAlive;
	}

	@Field(name = "term")
	public String getTerm() {
		return this.term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	@Field(name = "cast_num_children")
	public Short getCastNumChildren() {
		return this.castNumChildren;
	}

	public void setCastNumChildren(Short castNumChildren) {
		this.castNumChildren = castNumChildren;
	}

	@Field(name = "complications")
	public String getComplications() {
		return this.complications;
	}

	public void setComplications(String complications) {
		this.complications = complications;
	}

	
	@Field(name = "date_death")
	public DateTime getDateDeath() {
		return this.dateDeath;
	}

	public void setDateDeath(DateTime dateDeath) {
		this.dateDeath = dateDeath;
	}

	@Field(name = "death_village")
	public String getDeathVillage() {
		return this.deathVillage;
	}

	public void setDeathVillage(String deathVillage) {
		this.deathVillage = deathVillage;
	}

	@Field(name = "delivery_nature")
	public String getDeliveryNature() {
		return this.deliveryNature;
	}

	public void setDeliveryNature(String deliveryNature) {
		this.deliveryNature = deliveryNature;
	}

	@Field(name = "fever")
	public String getFever() {
		return this.fever;
	}

	public void setFever(String fever) {
		this.fever = fever;
	}

	@Field(name = "has_delivered")
	public String getHasDelivered() {
		return this.hasDelivered;
	}

	public void setHasDelivered(String hasDelivered) {
		this.hasDelivered = hasDelivered;
	}

	@Field(name = "how_many_children")
	public Short getHowManyChildren() {
		return this.howManyChildren;
	}

	public void setHowManyChildren(Short howManyChildren) {
		this.howManyChildren = howManyChildren;
	}

	@Field(name = "ifa_tablets_given")
	public String getIfaTabletsGiven() {
		return this.ifaTabletsGiven;
	}

	public void setIfaTabletsGiven(String ifaTabletsGiven) {
		this.ifaTabletsGiven = ifaTabletsGiven;
	}

	@Field(name = "in_district")
	public String getInDistrict() {
		return this.inDistrict;
	}

	public void setInDistrict(String inDistrict) {
		this.inDistrict = inDistrict;
	}

	@Field(name = "jsy_money")
	public String getJsyMoney() {
		return this.jsyMoney;
	}

	public void setJsyMoney(String jsyMoney) {
		this.jsyMoney = jsyMoney;
	}

	@Field(name = "nextvisittype")
	public String getNextvisittype() {
		return this.nextvisittype;
	}

	public void setNextvisittype(String nextvisittype) {
		this.nextvisittype = nextvisittype;
	}

	
	@Field(name = "notified")
	public DateTime getNotified() {
		return this.notified;
	}

	public void setNotified(DateTime notified) {
		this.notified = notified;
	}

	@Field(name = "num_children")
	public Short getNumChildren() {
		return this.numChildren;
	}

	public void setNumChildren(Short numChildren) {
		this.numChildren = numChildren;
	}

	@Field(name = "other_conditions")
	public String getOtherConditions() {
		return this.otherConditions;
	}

	public void setOtherConditions(String otherConditions) {
		this.otherConditions = otherConditions;
	}

	@Field(name = "other_district")
	public String getOtherDistrict() {
		return this.otherDistrict;
	}

	public void setOtherDistrict(String otherDistrict) {
		this.otherDistrict = otherDistrict;
	}

	@Field(name = "other_village")
	public String getOtherVillage() {
		return this.otherVillage;
	}

	public void setOtherVillage(String otherVillage) {
		this.otherVillage = otherVillage;
	}

	@Field(name = "pain_urine")
	public String getPainUrine() {
		return this.painUrine;
	}

	public void setPainUrine(String painUrine) {
		this.painUrine = painUrine;
	}

	@Field(name = "place_death")
	public String getPlaceDeath() {
		return this.placeDeath;
	}

	public void setPlaceDeath(String placeDeath) {
		this.placeDeath = placeDeath;
	}

	@Field(name = "post_postpartum_fp")
	public String getPostPostpartumFp() {
		return this.postPostpartumFp;
	}

	public void setPostPostpartumFp(String postPostpartumFp) {
		this.postPostpartumFp = postPostpartumFp;
	}

	@Field(name = "safe")
	public String getSafe() {
		return this.safe;
	}

	public void setSafe(String safe) {
		this.safe = safe;
	}

	@Field(name = "site_death")
	public String getSiteDeath() {
		return this.siteDeath;
	}

	public void setSiteDeath(String siteDeath) {
		this.siteDeath = siteDeath;
	}

	@Field(name = "vaginal_discharge")
	public String getVaginalDischarge() {
		return this.vaginalDischarge;
	}

	public void setVaginalDischarge(String vaginalDischarge) {
		this.vaginalDischarge = vaginalDischarge;
	}

	@Field(name = "where_born")
	public String getWhereBorn() {
		return this.whereBorn;
	}

	public void setWhereBorn(String whereBorn) {
		this.whereBorn = whereBorn;
	}

	@Field(name = "which_hospital")
	public String getWhichHospital() {
		return this.whichHospital;
	}

	public void setWhichHospital(String whichHospital) {
		this.whichHospital = whichHospital;
	}

	@Field(name = "which_village")
	public String getWhichVillage() {
		return this.whichVillage;
	}

	public void setWhichVillage(String whichVillage) {
		this.whichVillage = whichVillage;
	}

    
    @Field(name = "creation_time")
    public DateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(DateTime creationTime) {
        this.creationTime = creationTime;
    }

    @Field(name = "close")
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

    @Field(name = "jsy_money_date")
    public DateTime getJsyMoneyDateTime() {
        return jsyMoneyDate;
    }

    public void setJsyMoneyDate(DateTime jsyMoneyDate) {
        this.jsyMoneyDate = jsyMoneyDate;
    }

    @Field(name = "delivery_complications")
    public String getDeliveryComplications() {
        return deliveryComplications;
    }

    public void setDeliveryComplications(String deliveryComplications) {
        this.deliveryComplications = deliveryComplications;
    }

    
    @Field(name = "discharge_date")
    public DateTime getDischargeDateTime() {
        return dischargeDate;
    }

    public void setDischargeDate(DateTime dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    @Field(name = "discharge_time")
    public String getDischargeTime() {
        return dischargeTime;
    }

    public void setDischargeTime(String dischargeTime) {
        this.dischargeTime = dischargeTime;
    }

    @Field(name = "who_assisted")
    public String getWhoAssisted() {
        return whoAssisted;
    }

    public void setWhoAssisted(String whoAssisted) {
        this.whoAssisted = whoAssisted;
    }

    @Field(name = "bleeding")
    public String getBleeding() {
        return bleeding;
    }

    public void setBleeding(String bleeding) {
        this.bleeding = bleeding;
    }

    @Field(name = "home_sba_assist")
    public String getHomeSbaAssist() {
        return homeSbaAssist;
    }

    public void setHomeSbaAssist(String homeSbaAssist) {
        this.homeSbaAssist = homeSbaAssist;
    }

    @Field(name = "age_current_weight")
    public Integer getAgeCurrentWeight() {
        return ageCurrentWeight;
    }

    public void setAgeCurrentWeight(Integer ageCurrentWeight) {
        this.ageCurrentWeight = ageCurrentWeight;
    }

    @Field(name = "age_last_weight")
    public Integer getAgeLastWeight() {
        return ageLastWeight;
    }

    public void setAgeLastWeight(Integer ageLastWeight) {
        this.ageLastWeight = ageLastWeight;
    }
}
