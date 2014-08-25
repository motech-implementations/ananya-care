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
	public String getAbdominalPain() {
		return this.abdominalPain;
	}

	public void setAbdominalPain(String abdominalPain) {
		this.abdominalPain = abdominalPain;
	}

	
	@Field
	public DateTime getAddval() {
		return this.addval;
	}

	public void setAddval(DateTime addval) {
		this.addval = addval;
	}

	@Field
	public String getAdoptImmediately() {
		return this.adoptImmediately;
	}

	public void setAdoptImmediately(String adoptImmediately) {
		this.adoptImmediately = adoptImmediately;
	}

	@Field
	public String getAllPncOnTime() {
		return this.allPncOnTime;
	}

	public void setAllPncOnTime(String allPncOnTime) {
		this.allPncOnTime = allPncOnTime;
	}

	@Field
	public String getBleeding() {
		return this.bleeding;
	}

	public void setBleeding(String bleeding) {
		this.bleeding = bleeding;
	}

    @Field
	public String getComplications() {
		return this.complications;
	}

	public void setComplications(String complications) {
		this.complications = complications;
	}

	@Field
	public String getCongested() {
		return this.congested;
	}

	public void setCongested(String congested) {
		this.congested = congested;
	}

	@Field
	public String getCounselBreast() {
		return this.counselBreast;
	}

	public void setCounselBreast(String counselBreast) {
		this.counselBreast = counselBreast;
	}

	@Field
	public String getCounselFollowUpPpiud() {
		return this.counselFollowUpPpiud;
	}

	public void setCounselFollowUpPpiud(String counselFollowUpPpiud) {
		this.counselFollowUpPpiud = counselFollowUpPpiud;
	}

	@Field
	public String getCounselFollowUpPptl() {
		return this.counselFollowUpPptl;
	}

	public void setCounselFollowUpPptl(String counselFollowUpPptl) {
		this.counselFollowUpPptl = counselFollowUpPptl;
	}

	@Field
	public String getCounselIncreaseFoodBf() {
		return this.counselIncreaseFoodBf;
	}

	public void setCounselIncreaseFoodBf(String counselIncreaseFoodBf) {
		this.counselIncreaseFoodBf = counselIncreaseFoodBf;
	}

	@Field
	public String getCounselMateralComp() {
		return this.counselMateralComp;
	}

	public void setCounselMateralComp(String counselMateralComp) {
		this.counselMateralComp = counselMateralComp;
	}

	@Field
	public String getCounselMethods() {
		return this.counselMethods;
	}

	public void setCounselMethods(String counselMethods) {
		this.counselMethods = counselMethods;
	}

	@Field
	public String getCounselNeonatalComp() {
		return this.counselNeonatalComp;
	}

	public void setCounselNeonatalComp(String counselNeonatalComp) {
		this.counselNeonatalComp = counselNeonatalComp;
	}

	@Field
	public String getCounselPpfp() {
		return this.counselPpfp;
	}

	public void setCounselPpfp(String counselPpfp) {
		this.counselPpfp = counselPpfp;
	}

	@Field
	public String getCounselTimeIud() {
		return this.counselTimeIud;
	}

	public void setCounselTimeIud(String counselTimeIud) {
		this.counselTimeIud = counselTimeIud;
	}

	
	@Field
	public DateTime getDateDeath() {
		return this.dateDeath;
	}

	public void setDateDeath(DateTime dateDeath) {
		this.dateDeath = dateDeath;
	}

	
	@Field
	public DateTime getDateIudAdopted() {
		return this.dateIudAdopted;
	}

	public void setDateIudAdopted(DateTime dateIudAdopted) {
		this.dateIudAdopted = dateIudAdopted;
	}

	
	@Field
	public DateTime getDateLastVisit() {
		return this.dateLastVisit;
	}

	public void setDateLastVisit(DateTime dateLastVisit) {
		this.dateLastVisit = dateLastVisit;
	}

	
	@Field
	public DateTime getDateNextEb() {
		return this.dateNextEb;
	}

	public void setDateNextEb(DateTime dateNextEb) {
		this.dateNextEb = dateNextEb;
	}

    
    @Field
    public DateTime getDateNextCf() {
        return this.dateNextCf;
    }

    public void setDateNextCf(DateTime dateNextCf) {
        this.dateNextCf = dateNextCf;
    }
    
	
	@Field
	public DateTime getDateNextPnc() {
		return this.dateNextPnc;
	}

	public void setDateNextPnc(DateTime dateNextPnc) {
		this.dateNextPnc = dateNextPnc;
	}

	
	@Field
	public DateTime getDatePnc1() {
		return this.datePnc1;
	}

	public void setDatePnc1(DateTime datePnc1) {
		this.datePnc1 = datePnc1;
	}

	
	@Field
	public DateTime getDatePnc2() {
		return this.datePnc2;
	}

	public void setDatePnc2(DateTime datePnc2) {
		this.datePnc2 = datePnc2;
	}

	
	@Field
	public DateTime getDatePnc3() {
		return this.datePnc3;
	}

	public void setDatePnc3(DateTime datePnc3) {
		this.datePnc3 = datePnc3;
	}

	
	@Field
	public DateTime getDateTlAdopted() {
		return this.dateTlAdopted;
	}

	public void setDateTlAdopted(DateTime dateTlAdopted) {
		this.dateTlAdopted = dateTlAdopted;
	}

	@Field
	public String getDeathVillage() {
		return this.deathVillage;
	}

	public void setDeathVillage(String deathVillage) {
		this.deathVillage = deathVillage;
	}

	@Field
	public String getDischarge() {
		return this.discharge;
	}

	public void setDischarge(String discharge) {
		this.discharge = discharge;
	}

	@Field
	public String getDistension() {
		return this.distension;
	}

	public void setDistension(String distension) {
		this.distension = distension;
	}

	@Field
	public String getEatingWell() {
		return this.eatingWell;
	}

	public void setEatingWell(String eatingWell) {
		this.eatingWell = eatingWell;
	}

	@Field
	public String getFamilyPlanningType() {
		return this.familyPlanningType;
	}

	public void setFamilyPlanningType(String familyPlanningType) {
		this.familyPlanningType = familyPlanningType;
	}

	@Field
	public String getFever() {
		return this.fever;
	}

	public void setFever(String fever) {
		this.fever = fever;
	}

	@Field
	public String getFirstPncTime() {
		return this.firstPncTime;
	}

	public void setFirstPncTime(String firstPncTime) {
		this.firstPncTime = firstPncTime;
	}

	@Field
	public String getIntervalPpfpInterest() {
		return this.intervalPpfpInterest;
	}

	public void setIntervalPpfpInterest(String intervalPpfpInterest) {
		this.intervalPpfpInterest = intervalPpfpInterest;
	}

	@Field
	public String getIud() {
		return this.iud;
	}

	public void setIud(String iud) {
		this.iud = iud;
	}

	@Field
	public String getIudAdopted() {
		return this.iudAdopted;
	}

	public void setIudAdopted(String iudAdopted) {
		this.iudAdopted = iudAdopted;
	}

	@Field
	public String getIudCounselDuration() {
		return this.iudCounselDuration;
	}

	public void setIudCounselDuration(String iudCounselDuration) {
		this.iudCounselDuration = iudCounselDuration;
	}

	@Field
	public String getIudCounselFollowUp() {
		return this.iudCounselFollowUp;
	}

	public void setIudCounselFollowUp(String iudCounselFollowUp) {
		this.iudCounselFollowUp = iudCounselFollowUp;
	}

	@Field
	public String getIudCounselHospital() {
		return this.iudCounselHospital;
	}

	public void setIudCounselHospital(String iudCounselHospital) {
		this.iudCounselHospital = iudCounselHospital;
	}

	@Field
	public String getIudCounselPlacement() {
		return this.iudCounselPlacement;
	}

	public void setIudCounselPlacement(String iudCounselPlacement) {
		this.iudCounselPlacement = iudCounselPlacement;
	}

	@Field
	public String getIudCounselScreening() {
		return this.iudCounselScreening;
	}

	public void setIudCounselScreening(String iudCounselScreening) {
		this.iudCounselScreening = iudCounselScreening;
	}

	@Field
	public String getIudCounselSideEffects() {
		return this.iudCounselSideEffects;
	}

	public void setIudCounselSideEffects(String iudCounselSideEffects) {
		this.iudCounselSideEffects = iudCounselSideEffects;
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
	public String getMotherChildAlive() {
		return this.motherChildAlive;
	}

	public void setMotherChildAlive(String motherChildAlive) {
		this.motherChildAlive = motherChildAlive;
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
	public String getOtherIssues() {
		return this.otherIssues;
	}

	public void setOtherIssues(String otherIssues) {
		this.otherIssues = otherIssues;
	}

	@Field
	public String getPainUrination() {
		return this.painUrination;
	}

	public void setPainUrination(String painUrination) {
		this.painUrination = painUrination;
	}

	@Field
	public String getPainfulNipples() {
		return this.painfulNipples;
	}

	public void setPainfulNipples(String painfulNipples) {
		this.painfulNipples = painfulNipples;
	}

	@Field
	public String getPlaceDeath() {
		return this.placeDeath;
	}

	public void setPlaceDeath(String placeDeath) {
		this.placeDeath = placeDeath;
	}

	@Field
	public Integer getPnc1DaysLate() {
		return this.pnc1DaysLate;
	}

	public void setPnc1DaysLate(Integer pnc1DaysLate) {
		this.pnc1DaysLate = pnc1DaysLate;
	}

	@Field
	public Integer getPnc2DaysLate() {
		return this.pnc2DaysLate;
	}

	public void setPnc2DaysLate(Integer pnc2DaysLate) {
		this.pnc2DaysLate = pnc2DaysLate;
	}

	@Field
	public Integer getPnc3DaysLate() {
		return this.pnc3DaysLate;
	}

	public void setPnc3DaysLate(Integer pnc3DaysLate) {
		this.pnc3DaysLate = pnc3DaysLate;
	}

	@Field
	public int getPncVisitNum() {
		return this.pncVisitNum;
	}

	public void setPncVisitNum(int pncVisitNum) {
		this.pncVisitNum = pncVisitNum;
	}

	@Field
	public Boolean getPpfpInterest() {
		return this.ppfpInterest;
	}

	public void setPpfpInterest(Boolean ppfpInterest) {
		this.ppfpInterest = ppfpInterest;
	}

	@Field
	public String getPpiudAbdominalPain() {
		return this.ppiudAbdominalPain;
	}

	public void setPpiudAbdominalPain(String ppiudAbdominalPain) {
		this.ppiudAbdominalPain = ppiudAbdominalPain;
	}

	@Field
	public String getPpiudBleeding() {
		return this.ppiudBleeding;
	}

	public void setPpiudBleeding(String ppiudBleeding) {
		this.ppiudBleeding = ppiudBleeding;
	}

	@Field
	public String getPpiudDischarge() {
		return this.ppiudDischarge;
	}

	public void setPpiudDischarge(String ppiudDischarge) {
		this.ppiudDischarge = ppiudDischarge;
	}

	@Field
	public String getPpiudFever() {
		return this.ppiudFever;
	}

	public void setPpiudFever(String ppiudFever) {
		this.ppiudFever = ppiudFever;
	}

	@Field
	public String getPpiudProblems() {
		return this.ppiudProblems;
	}

	public void setPpiudProblems(String ppiudProblems) {
		this.ppiudProblems = ppiudProblems;
	}

	@Field
	public String getPptlAbdominalPain() {
		return this.pptlAbdominalPain;
	}

	public void setPptlAbdominalPain(String pptlAbdominalPain) {
		this.pptlAbdominalPain = pptlAbdominalPain;
	}

	@Field
	public String getPptlExcessiveBleeding() {
		return this.pptlExcessiveBleeding;
	}

	public void setPptlExcessiveBleeding(String pptlExcessiveBleeding) {
		this.pptlExcessiveBleeding = pptlExcessiveBleeding;
	}

	@Field
	public String getPptlPainSurgery() {
		return this.pptlPainSurgery;
	}

	public void setPptlPainSurgery(String pptlPainSurgery) {
		this.pptlPainSurgery = pptlPainSurgery;
	}

	@Field
	public String getPptlProblems() {
		return this.pptlProblems;
	}

	public void setPptlProblems(String pptlProblems) {
		this.pptlProblems = pptlProblems;
	}

	@Field
	public String getProblemsBreast() {
		return this.problemsBreast;
	}

	public void setProblemsBreast(String problemsBreast) {
		this.problemsBreast = problemsBreast;
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
	public String getTl() {
		return this.tl;
	}

	public void setTl(String tl) {
		this.tl = tl;
	}

	@Field
	public String getTlAdopted() {
		return this.tlAdopted;
	}

	public void setTlAdopted(String tlAdopted) {
		this.tlAdopted = tlAdopted;
	}

	@Field
	public String getTlConselIncentives() {
		return this.tlConselIncentives;
	}

	public void setTlConselIncentives(String tlConselIncentives) {
		this.tlConselIncentives = tlConselIncentives;
	}

	@Field
	public String getTlCounselFollowUp() {
		return this.tlCounselFollowUp;
	}

	public void setTlCounselFollowUp(String tlCounselFollowUp) {
		this.tlCounselFollowUp = tlCounselFollowUp;
	}

	@Field
	public String getTlCounselHospital() {
		return this.tlCounselHospital;
	}

	public void setTlCounselHospital(String tlCounselHospital) {
		this.tlCounselHospital = tlCounselHospital;
	}

	@Field
	public String getTlCounselIrreversible() {
		return this.tlCounselIrreversible;
	}

	public void setTlCounselIrreversible(String tlCounselIrreversible) {
		this.tlCounselIrreversible = tlCounselIrreversible;
	}

	@Field
	public String getTlCounselScreening() {
		return this.tlCounselScreening;
	}

	public void setTlCounselScreening(String tlCounselScreening) {
		this.tlCounselScreening = tlCounselScreening;
	}

	@Field
	public String getTlCounselSideEffects() {
		return this.tlCounselSideEffects;
	}

	public void setTlCounselSideEffects(String tlCounselSideEffects) {
		this.tlCounselSideEffects = tlCounselSideEffects;
	}

	@Field
	public String getTlCounselTiming() {
		return this.tlCounselTiming;
	}

	public void setTlCounselTiming(String tlCounselTiming) {
		this.tlCounselTiming = tlCounselTiming;
	}

	@Field
	public String getWhyNoPpffp() {
		return this.whyNoPpffp;
	}

	public void setWhyNoPpffp(String whyNoPpffp) {
		this.whyNoPpffp = whyNoPpffp;
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
    public String getPncComplications() {
        return pncComplications;
    }

    public void setPncComplications(String pncComplications) {
        this.pncComplications = pncComplications;
    }
}
