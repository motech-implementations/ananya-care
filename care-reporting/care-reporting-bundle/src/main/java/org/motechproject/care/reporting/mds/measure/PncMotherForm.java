package org.motechproject.care.reporting.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.care.reporting.mds.dimension.Flw;
import org.motechproject.care.reporting.mds.dimension.MotherCase;
import org.motechproject.care.reporting.utils.FormToString;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;


@Entity(name = "pnc_mother_form")
@Unique(members = "instance_id")
public class PncMotherForm extends Form {

	 private Flw flw;
	private MotherCase motherCase;
	private DateTime timeEnd;
	private DateTime timeStart;
	private DateTime dateModified;
	private String abdominalPain;
	private DateTime addval;
	private String adoptImmediately;
	private String allPncOnTime;
	private String bleeding;
    private String complications;
	private String congested;
	private String counselBreast;
	private String counselFollowUpPpiud;
	private String counselFollowUpPptl;
	private String counselIncreaseFoodBf;
	private String counselMateralComp;
	private String counselMethods;
	private String counselNeonatalComp;
	private String counselPpfp;
	private String counselTimeIud;
	private DateTime dateDeath;
	private DateTime dateIudAdopted;
	private DateTime dateLastVisit;
	private DateTime dateNextEb;
	private DateTime dateNextPnc;
	private DateTime dateNextCf;
	private DateTime datePnc1;
	private DateTime datePnc2;
	private DateTime datePnc3;
	private DateTime dateTlAdopted;
	private String deathVillage;
	private String discharge;
	private String distension;
	private String eatingWell;
	private String familyPlanningType;
	private String fever;
	private String firstPncTime;
	private String intervalPpfpInterest;
	private String iud;
	private String iudAdopted;
	private String iudCounselDuration;
	private String iudCounselFollowUp;
	private String iudCounselHospital;
	private String iudCounselPlacement;
	private String iudCounselScreening;
	private String iudCounselSideEffects;
	private String lastVisitType;
	private String motherAlive;
	private String motherChildAlive;
	private String nextvisittype;
	private int numChildren;
	private String otherIssues;
	private String painUrination;
	private String painfulNipples;
	private String placeDeath;
	private Integer pnc1DaysLate;
	private Integer pnc2DaysLate;
	private Integer pnc3DaysLate;
	private int pncVisitNum;
	private Boolean ppfpInterest;
	private String ppiudAbdominalPain;
	private String ppiudBleeding;
	private String ppiudDischarge;
	private String ppiudFever;
	private String ppiudProblems;
	private String pptlAbdominalPain;
	private String pptlExcessiveBleeding;
	private String pptlPainSurgery;
	private String pptlProblems;
	private String problemsBreast;
	private String safe;
	private String siteDeath;
	private String tl;
	private String tlAdopted;
	private String tlConselIncentives;
	private String tlCounselFollowUp;
	private String tlCounselHospital;
	private String tlCounselIrreversible;
	private String tlCounselScreening;
	private String tlCounselSideEffects;
	private String tlCounselTiming;
	private String whyNoPpffp;
    private DateTime creationTime = new DateTime();
    private String pncComplications;

    public PncMotherForm() {
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

	@Field(name = "abdominal_pain")
	public String getAbdominalPain() {
		return this.abdominalPain;
	}

	public void setAbdominalPain(String abdominalPain) {
		this.abdominalPain = abdominalPain;
	}

	
	@Field(name = "addval")
	public DateTime getAddval() {
		return this.addval;
	}

	public void setAddval(DateTime addval) {
		this.addval = addval;
	}

	@Field(name = "adopt_immediately")
	public String getAdoptImmediately() {
		return this.adoptImmediately;
	}

	public void setAdoptImmediately(String adoptImmediately) {
		this.adoptImmediately = adoptImmediately;
	}

	@Field(name = "all_pnc_on_time")
	public String getAllPncOnTime() {
		return this.allPncOnTime;
	}

	public void setAllPncOnTime(String allPncOnTime) {
		this.allPncOnTime = allPncOnTime;
	}

	@Field(name = "bleeding")
	public String getBleeding() {
		return this.bleeding;
	}

	public void setBleeding(String bleeding) {
		this.bleeding = bleeding;
	}

    @Field(name = "complications")
	public String getComplications() {
		return this.complications;
	}

	public void setComplications(String complications) {
		this.complications = complications;
	}

	@Field(name = "congested")
	public String getCongested() {
		return this.congested;
	}

	public void setCongested(String congested) {
		this.congested = congested;
	}

	@Field(name = "counsel_breast")
	public String getCounselBreast() {
		return this.counselBreast;
	}

	public void setCounselBreast(String counselBreast) {
		this.counselBreast = counselBreast;
	}

	@Field(name = "counsel_follow_up_ppiud")
	public String getCounselFollowUpPpiud() {
		return this.counselFollowUpPpiud;
	}

	public void setCounselFollowUpPpiud(String counselFollowUpPpiud) {
		this.counselFollowUpPpiud = counselFollowUpPpiud;
	}

	@Field(name = "counsel_follow_up_pptl")
	public String getCounselFollowUpPptl() {
		return this.counselFollowUpPptl;
	}

	public void setCounselFollowUpPptl(String counselFollowUpPptl) {
		this.counselFollowUpPptl = counselFollowUpPptl;
	}

	@Field(name = "counsel_increase_food_bf")
	public String getCounselIncreaseFoodBf() {
		return this.counselIncreaseFoodBf;
	}

	public void setCounselIncreaseFoodBf(String counselIncreaseFoodBf) {
		this.counselIncreaseFoodBf = counselIncreaseFoodBf;
	}

	@Field(name = "counsel_materal_comp")
	public String getCounselMateralComp() {
		return this.counselMateralComp;
	}

	public void setCounselMateralComp(String counselMateralComp) {
		this.counselMateralComp = counselMateralComp;
	}

	@Field(name = "counsel_methods")
	public String getCounselMethods() {
		return this.counselMethods;
	}

	public void setCounselMethods(String counselMethods) {
		this.counselMethods = counselMethods;
	}

	@Field(name = "counsel_neonatal_comp")
	public String getCounselNeonatalComp() {
		return this.counselNeonatalComp;
	}

	public void setCounselNeonatalComp(String counselNeonatalComp) {
		this.counselNeonatalComp = counselNeonatalComp;
	}

	@Field(name = "counsel_ppfp")
	public String getCounselPpfp() {
		return this.counselPpfp;
	}

	public void setCounselPpfp(String counselPpfp) {
		this.counselPpfp = counselPpfp;
	}

	@Field(name = "counsel_time_iud")
	public String getCounselTimeIud() {
		return this.counselTimeIud;
	}

	public void setCounselTimeIud(String counselTimeIud) {
		this.counselTimeIud = counselTimeIud;
	}

	
	@Field(name = "date_death")
	public DateTime getDateDeath() {
		return this.dateDeath;
	}

	public void setDateDeath(DateTime dateDeath) {
		this.dateDeath = dateDeath;
	}

	
	@Field(name = "date_iud_adopted")
	public DateTime getDateIudAdopted() {
		return this.dateIudAdopted;
	}

	public void setDateIudAdopted(DateTime dateIudAdopted) {
		this.dateIudAdopted = dateIudAdopted;
	}

	
	@Field(name = "date_last_visit")
	public DateTime getDateLastVisit() {
		return this.dateLastVisit;
	}

	public void setDateLastVisit(DateTime dateLastVisit) {
		this.dateLastVisit = dateLastVisit;
	}

	
	@Field(name = "date_next_eb")
	public DateTime getDateNextEb() {
		return this.dateNextEb;
	}

	public void setDateNextEb(DateTime dateNextEb) {
		this.dateNextEb = dateNextEb;
	}

    
    @Field(name = "date_next_cf")
    public DateTime getDateNextCf() {
        return this.dateNextCf;
    }

    public void setDateNextCf(DateTime dateNextCf) {
        this.dateNextCf = dateNextCf;
    }
    
	
	@Field(name = "date_next_pnc")
	public DateTime getDateNextPnc() {
		return this.dateNextPnc;
	}

	public void setDateNextPnc(DateTime dateNextPnc) {
		this.dateNextPnc = dateNextPnc;
	}

	
	@Field(name = "date_pnc_1")
	public DateTime getDatePnc1() {
		return this.datePnc1;
	}

	public void setDatePnc1(DateTime datePnc1) {
		this.datePnc1 = datePnc1;
	}

	
	@Field(name = "date_pnc_2")
	public DateTime getDatePnc2() {
		return this.datePnc2;
	}

	public void setDatePnc2(DateTime datePnc2) {
		this.datePnc2 = datePnc2;
	}

	
	@Field(name = "date_pnc_3")
	public DateTime getDatePnc3() {
		return this.datePnc3;
	}

	public void setDatePnc3(DateTime datePnc3) {
		this.datePnc3 = datePnc3;
	}

	
	@Field(name = "date_tl_adopted")
	public DateTime getDateTlAdopted() {
		return this.dateTlAdopted;
	}

	public void setDateTlAdopted(DateTime dateTlAdopted) {
		this.dateTlAdopted = dateTlAdopted;
	}

	@Field(name = "death_village")
	public String getDeathVillage() {
		return this.deathVillage;
	}

	public void setDeathVillage(String deathVillage) {
		this.deathVillage = deathVillage;
	}

	@Field(name = "discharge")
	public String getDischarge() {
		return this.discharge;
	}

	public void setDischarge(String discharge) {
		this.discharge = discharge;
	}

	@Field(name = "distension")
	public String getDistension() {
		return this.distension;
	}

	public void setDistension(String distension) {
		this.distension = distension;
	}

	@Field(name = "eating_well")
	public String getEatingWell() {
		return this.eatingWell;
	}

	public void setEatingWell(String eatingWell) {
		this.eatingWell = eatingWell;
	}

	@Field(name = "family_planning_type")
	public String getFamilyPlanningType() {
		return this.familyPlanningType;
	}

	public void setFamilyPlanningType(String familyPlanningType) {
		this.familyPlanningType = familyPlanningType;
	}

	@Field(name = "fever")
	public String getFever() {
		return this.fever;
	}

	public void setFever(String fever) {
		this.fever = fever;
	}

	@Field(name = "first_pnc_time")
	public String getFirstPncTime() {
		return this.firstPncTime;
	}

	public void setFirstPncTime(String firstPncTime) {
		this.firstPncTime = firstPncTime;
	}

	@Field(name = "interval_ppfp_interest")
	public String getIntervalPpfpInterest() {
		return this.intervalPpfpInterest;
	}

	public void setIntervalPpfpInterest(String intervalPpfpInterest) {
		this.intervalPpfpInterest = intervalPpfpInterest;
	}

	@Field(name = "iud")
	public String getIud() {
		return this.iud;
	}

	public void setIud(String iud) {
		this.iud = iud;
	}

	@Field(name = "iud_adopted")
	public String getIudAdopted() {
		return this.iudAdopted;
	}

	public void setIudAdopted(String iudAdopted) {
		this.iudAdopted = iudAdopted;
	}

	@Field(name = "iud_counsel_duration")
	public String getIudCounselDuration() {
		return this.iudCounselDuration;
	}

	public void setIudCounselDuration(String iudCounselDuration) {
		this.iudCounselDuration = iudCounselDuration;
	}

	@Field(name = "iud_counsel_follow_up")
	public String getIudCounselFollowUp() {
		return this.iudCounselFollowUp;
	}

	public void setIudCounselFollowUp(String iudCounselFollowUp) {
		this.iudCounselFollowUp = iudCounselFollowUp;
	}

	@Field(name = "iud_counsel_hospital")
	public String getIudCounselHospital() {
		return this.iudCounselHospital;
	}

	public void setIudCounselHospital(String iudCounselHospital) {
		this.iudCounselHospital = iudCounselHospital;
	}

	@Field(name = "iud_counsel_placement")
	public String getIudCounselPlacement() {
		return this.iudCounselPlacement;
	}

	public void setIudCounselPlacement(String iudCounselPlacement) {
		this.iudCounselPlacement = iudCounselPlacement;
	}

	@Field(name = "iud_counsel_screening")
	public String getIudCounselScreening() {
		return this.iudCounselScreening;
	}

	public void setIudCounselScreening(String iudCounselScreening) {
		this.iudCounselScreening = iudCounselScreening;
	}

	@Field(name = "iud_counsel_side_effects")
	public String getIudCounselSideEffects() {
		return this.iudCounselSideEffects;
	}

	public void setIudCounselSideEffects(String iudCounselSideEffects) {
		this.iudCounselSideEffects = iudCounselSideEffects;
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

	@Field(name = "mother_child_alive")
	public String getMotherChildAlive() {
		return this.motherChildAlive;
	}

	public void setMotherChildAlive(String motherChildAlive) {
		this.motherChildAlive = motherChildAlive;
	}

	@Field(name = "nextvisittype")
	public String getNextvisittype() {
		return this.nextvisittype;
	}

	public void setNextvisittype(String nextvisittype) {
		this.nextvisittype = nextvisittype;
	}

	@Field(name = "num_children")
	public int getNumChildren() {
		return this.numChildren;
	}

	public void setNumChildren(int numChildren) {
		this.numChildren = numChildren;
	}

	@Field(name = "other_issues")
	public String getOtherIssues() {
		return this.otherIssues;
	}

	public void setOtherIssues(String otherIssues) {
		this.otherIssues = otherIssues;
	}

	@Field(name = "pain_urination")
	public String getPainUrination() {
		return this.painUrination;
	}

	public void setPainUrination(String painUrination) {
		this.painUrination = painUrination;
	}

	@Field(name = "painful_nipples")
	public String getPainfulNipples() {
		return this.painfulNipples;
	}

	public void setPainfulNipples(String painfulNipples) {
		this.painfulNipples = painfulNipples;
	}

	@Field(name = "place_death")
	public String getPlaceDeath() {
		return this.placeDeath;
	}

	public void setPlaceDeath(String placeDeath) {
		this.placeDeath = placeDeath;
	}

	@Field(name = "pnc_1_days_late")
	public Integer getPnc1DaysLate() {
		return this.pnc1DaysLate;
	}

	public void setPnc1DaysLate(Integer pnc1DaysLate) {
		this.pnc1DaysLate = pnc1DaysLate;
	}

	@Field(name = "pnc_2_days_late")
	public Integer getPnc2DaysLate() {
		return this.pnc2DaysLate;
	}

	public void setPnc2DaysLate(Integer pnc2DaysLate) {
		this.pnc2DaysLate = pnc2DaysLate;
	}

	@Field(name = "pnc_3_days_late")
	public Integer getPnc3DaysLate() {
		return this.pnc3DaysLate;
	}

	public void setPnc3DaysLate(Integer pnc3DaysLate) {
		this.pnc3DaysLate = pnc3DaysLate;
	}

	@Field(name = "pnc_visit_num")
	public int getPncVisitNum() {
		return this.pncVisitNum;
	}

	public void setPncVisitNum(int pncVisitNum) {
		this.pncVisitNum = pncVisitNum;
	}

	@Field(name = "ppfp_interest")
	public Boolean getPpfpInterest() {
		return this.ppfpInterest;
	}

	public void setPpfpInterest(Boolean ppfpInterest) {
		this.ppfpInterest = ppfpInterest;
	}

	@Field(name = "ppiud_abdominal_pain")
	public String getPpiudAbdominalPain() {
		return this.ppiudAbdominalPain;
	}

	public void setPpiudAbdominalPain(String ppiudAbdominalPain) {
		this.ppiudAbdominalPain = ppiudAbdominalPain;
	}

	@Field(name = "ppiud_bleeding")
	public String getPpiudBleeding() {
		return this.ppiudBleeding;
	}

	public void setPpiudBleeding(String ppiudBleeding) {
		this.ppiudBleeding = ppiudBleeding;
	}

	@Field(name = "ppiud_discharge")
	public String getPpiudDischarge() {
		return this.ppiudDischarge;
	}

	public void setPpiudDischarge(String ppiudDischarge) {
		this.ppiudDischarge = ppiudDischarge;
	}

	@Field(name = "ppiud_fever")
	public String getPpiudFever() {
		return this.ppiudFever;
	}

	public void setPpiudFever(String ppiudFever) {
		this.ppiudFever = ppiudFever;
	}

	@Field(name = "ppiud_problems")
	public String getPpiudProblems() {
		return this.ppiudProblems;
	}

	public void setPpiudProblems(String ppiudProblems) {
		this.ppiudProblems = ppiudProblems;
	}

	@Field(name = "pptl_abdominal_pain")
	public String getPptlAbdominalPain() {
		return this.pptlAbdominalPain;
	}

	public void setPptlAbdominalPain(String pptlAbdominalPain) {
		this.pptlAbdominalPain = pptlAbdominalPain;
	}

	@Field(name = "pptl_excessive_bleeding")
	public String getPptlExcessiveBleeding() {
		return this.pptlExcessiveBleeding;
	}

	public void setPptlExcessiveBleeding(String pptlExcessiveBleeding) {
		this.pptlExcessiveBleeding = pptlExcessiveBleeding;
	}

	@Field(name = "pptl_pain_surgery")
	public String getPptlPainSurgery() {
		return this.pptlPainSurgery;
	}

	public void setPptlPainSurgery(String pptlPainSurgery) {
		this.pptlPainSurgery = pptlPainSurgery;
	}

	@Field(name = "pptl_problems")
	public String getPptlProblems() {
		return this.pptlProblems;
	}

	public void setPptlProblems(String pptlProblems) {
		this.pptlProblems = pptlProblems;
	}

	@Field(name = "problems_breast")
	public String getProblemsBreast() {
		return this.problemsBreast;
	}

	public void setProblemsBreast(String problemsBreast) {
		this.problemsBreast = problemsBreast;
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

	@Field(name = "tl")
	public String getTl() {
		return this.tl;
	}

	public void setTl(String tl) {
		this.tl = tl;
	}

	@Field(name = "tl_adopted")
	public String getTlAdopted() {
		return this.tlAdopted;
	}

	public void setTlAdopted(String tlAdopted) {
		this.tlAdopted = tlAdopted;
	}

	@Field(name = "tl_consel_incentives")
	public String getTlConselIncentives() {
		return this.tlConselIncentives;
	}

	public void setTlConselIncentives(String tlConselIncentives) {
		this.tlConselIncentives = tlConselIncentives;
	}

	@Field(name = "tl_counsel_follow_up")
	public String getTlCounselFollowUp() {
		return this.tlCounselFollowUp;
	}

	public void setTlCounselFollowUp(String tlCounselFollowUp) {
		this.tlCounselFollowUp = tlCounselFollowUp;
	}

	@Field(name = "tl_counsel_hospital")
	public String getTlCounselHospital() {
		return this.tlCounselHospital;
	}

	public void setTlCounselHospital(String tlCounselHospital) {
		this.tlCounselHospital = tlCounselHospital;
	}

	@Field(name = "tl_counsel_irreversible")
	public String getTlCounselIrreversible() {
		return this.tlCounselIrreversible;
	}

	public void setTlCounselIrreversible(String tlCounselIrreversible) {
		this.tlCounselIrreversible = tlCounselIrreversible;
	}

	@Field(name = "tl_counsel_screening")
	public String getTlCounselScreening() {
		return this.tlCounselScreening;
	}

	public void setTlCounselScreening(String tlCounselScreening) {
		this.tlCounselScreening = tlCounselScreening;
	}

	@Field(name = "tl_counsel_side_effects")
	public String getTlCounselSideEffects() {
		return this.tlCounselSideEffects;
	}

	public void setTlCounselSideEffects(String tlCounselSideEffects) {
		this.tlCounselSideEffects = tlCounselSideEffects;
	}

	@Field(name = "tl_counsel_timing")
	public String getTlCounselTiming() {
		return this.tlCounselTiming;
	}

	public void setTlCounselTiming(String tlCounselTiming) {
		this.tlCounselTiming = tlCounselTiming;
	}

	@Field(name = "why_no_ppffp")
	public String getWhyNoPpffp() {
		return this.whyNoPpffp;
	}

	public void setWhyNoPpffp(String whyNoPpffp) {
		this.whyNoPpffp = whyNoPpffp;
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

    @Field(name = "pnc_complications")
    public String getPncComplications() {
        return pncComplications;
    }

    public void setPncComplications(String pncComplications) {
        this.pncComplications = pncComplications;
    }
}
