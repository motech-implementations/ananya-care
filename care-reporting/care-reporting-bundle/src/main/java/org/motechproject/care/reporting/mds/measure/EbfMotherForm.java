package org.motechproject.care.reporting.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.care.reporting.mds.dimension.Flw;
import org.motechproject.care.reporting.mds.dimension.MotherCase;
import org.motechproject.care.reporting.utils.FormToString;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;


@Entity(name = "ebf_mother_form")
@Unique(members = "instance_id")
public class EbfMotherForm extends Form {

	 private Flw flw;
	private MotherCase motherCase;
	private DateTime timeEnd;
	private DateTime timeStart;
	private DateTime dateModified;
	private DateTime addval;
	private String adoptImmediately;
	private String askPpiud;
	private String awareOfFailure;
	private String bleeding;
    private String complications;
	private String condoms;
	private String counselFollowUpPpiud;
	private String counselFollowUpPptl;
	private String counselMenstrualCycle;
	private String counselMethods;
	private String counselPpfp;
	private String counselTimeIud;
	private DateTime dateEb1;
	private DateTime dateEb2;
	private DateTime dateEb3;
	private DateTime dateEb4;
	private DateTime dateEb5;
	private DateTime dateEb6;
	private DateTime dateIudAdopted;
	private DateTime dateLastInj;
	private DateTime dateLastVisit;
	private DateTime dateNextCf;
	private DateTime dateNextEb;
	private String discharge;
	private String distension;
	private int ebVisitNum;
	private String familyPlanningType;
	private String fever;
	private String haveCondoms;
	private String headaches;
	private String highBp;
	private String injMenstrualIrregularity;
	private String injectable;
	private String intendToContinue;
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
	private String menstrualIrregularity;
	private DateTime nextInjCalc;
	private String nextvisittype;
	private int numChildren;
	private String ocp;
	private String ocpContinue;
	private String ocpCounselRegularity;
	private String painSwelling;
	private Boolean ppfpInterest;
	private String ppiudAbdominalPain;
	private String ppiudProblems;
	private String pptlAbdominalPain;
	private String pptlPainSurgery;
	private String pptlProblems;
	private String regularPeriods;
	private String tabletsReceived;
	private String takenAsPrescribed;
	private String tl;
	private String tlAdopted;
	private String tlConselIncentives;
	private String tlCounselFollowUp;
	private String tlCounselHospital;
	private String tlCounselIrreversible;
	private String tlCounselScreening;
	private String tlCounselSideEffects;
	private String tlCounselTiming;
	private String understandTablets;
	private String usingCorrectly;
	private String whereReplace;
	private String whyNoPpffp;
	private String within42;
	private DateTime dateTlAdopted;
	private String abdominalPain;
	private String painUrination;
	private String ppiudBleeding;
	private String ppiudDischarge;
	private String ppiudFever;
    private DateTime creationTime = new DateTime();

    public EbfMotherForm() {
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

	@Field(name = "ask_ppiud")
	public String getAskPpiud() {
		return this.askPpiud;
	}

	public void setAskPpiud(String askPpiud) {
		this.askPpiud = askPpiud;
	}

	@Field(name = "aware_of_failure")
	public String getAwareOfFailure() {
		return this.awareOfFailure;
	}

	public void setAwareOfFailure(String awareOfFailure) {
		this.awareOfFailure = awareOfFailure;
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

	@Field(name = "condoms")
	public String getCondoms() {
		return this.condoms;
	}

	public void setCondoms(String condoms) {
		this.condoms = condoms;
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

	@Field(name = "counsel_menstrual_cycle")
	public String getCounselMenstrualCycle() {
		return this.counselMenstrualCycle;
	}

	public void setCounselMenstrualCycle(String counselMenstrualCycle) {
		this.counselMenstrualCycle = counselMenstrualCycle;
	}

	@Field(name = "counsel_methods")
	public String getCounselMethods() {
		return this.counselMethods;
	}

	public void setCounselMethods(String counselMethods) {
		this.counselMethods = counselMethods;
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

	
	@Field(name = "date_eb_1")
	public DateTime getDateEb1() {
		return this.dateEb1;
	}

	public void setDateEb1(DateTime dateEb1) {
		this.dateEb1 = dateEb1;
	}

	
	@Field(name = "date_eb_2")
	public DateTime getDateEb2() {
		return this.dateEb2;
	}

	public void setDateEb2(DateTime dateEb2) {
		this.dateEb2 = dateEb2;
	}

	
	@Field(name = "date_eb_3")
	public DateTime getDateEb3() {
		return this.dateEb3;
	}

	public void setDateEb3(DateTime dateEb3) {
		this.dateEb3 = dateEb3;
	}

	
	@Field(name = "date_eb_4")
	public DateTime getDateEb4() {
		return this.dateEb4;
	}

	public void setDateEb4(DateTime dateEb4) {
		this.dateEb4 = dateEb4;
	}

	
	@Field(name = "date_eb_5")
	public DateTime getDateEb5() {
		return this.dateEb5;
	}

	public void setDateEb5(DateTime dateEb5) {
		this.dateEb5 = dateEb5;
	}

	
	@Field(name = "date_eb_6")
	public DateTime getDateEb6() {
		return this.dateEb6;
	}

	public void setDateEb6(DateTime dateEb6) {
		this.dateEb6 = dateEb6;
	}

	
	@Field(name = "date_iud_adopted")
	public DateTime getDateIudAdopted() {
		return this.dateIudAdopted;
	}

	public void setDateIudAdopted(DateTime dateIudAdopted) {
		this.dateIudAdopted = dateIudAdopted;
	}

	
	@Field(name = "date_last_inj")
	public DateTime getDateLastInj() {
		return this.dateLastInj;
	}

	public void setDateLastInj(DateTime dateLastInj) {
		this.dateLastInj = dateLastInj;
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

	@Field(name = "eb_visit_num")
	public int getEbVisitNum() {
		return this.ebVisitNum;
	}

	public void setEbVisitNum(int ebVisitNum) {
		this.ebVisitNum = ebVisitNum;
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

	@Field(name = "have_condoms")
	public String getHaveCondoms() {
		return this.haveCondoms;
	}

	public void setHaveCondoms(String haveCondoms) {
		this.haveCondoms = haveCondoms;
	}

	@Field(name = "headaches")
	public String getHeadaches() {
		return this.headaches;
	}

	public void setHeadaches(String headaches) {
		this.headaches = headaches;
	}

	@Field(name = "high_bp")
	public String getHighBp() {
		return this.highBp;
	}

	public void setHighBp(String highBp) {
		this.highBp = highBp;
	}

	@Field(name = "inj_menstrual_irregularity")
	public String getInjMenstrualIrregularity() {
		return this.injMenstrualIrregularity;
	}

	public void setInjMenstrualIrregularity(String injMenstrualIrregularity) {
		this.injMenstrualIrregularity = injMenstrualIrregularity;
	}

	@Field(name = "injectable")
	public String getInjectable() {
		return this.injectable;
	}

	public void setInjectable(String injectable) {
		this.injectable = injectable;
	}

	@Field(name = "intend_to_continue")
	public String getIntendToContinue() {
		return this.intendToContinue;
	}

	public void setIntendToContinue(String intendToContinue) {
		this.intendToContinue = intendToContinue;
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

	@Field(name = "menstrual_irregularity")
	public String getMenstrualIrregularity() {
		return this.menstrualIrregularity;
	}

	public void setMenstrualIrregularity(String menstrualIrregularity) {
		this.menstrualIrregularity = menstrualIrregularity;
	}

	
	@Field(name = "next_inj_calc")
	public DateTime getNextInjCalc() {
		return this.nextInjCalc;
	}

	public void setNextInjCalc(DateTime nextInjCalc) {
		this.nextInjCalc = nextInjCalc;
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

	@Field(name = "ocp")
	public String getOcp() {
		return this.ocp;
	}

	public void setOcp(String ocp) {
		this.ocp = ocp;
	}

	@Field(name = "ocp_continue")
	public String getOcpContinue() {
		return this.ocpContinue;
	}

	public void setOcpContinue(String ocpContinue) {
		this.ocpContinue = ocpContinue;
	}

	@Field(name = "ocp_counsel_regularity")
	public String getOcpCounselRegularity() {
		return this.ocpCounselRegularity;
	}

	public void setOcpCounselRegularity(String ocpCounselRegularity) {
		this.ocpCounselRegularity = ocpCounselRegularity;
	}

	@Field(name = "pain_swelling")
	public String getPainSwelling() {
		return this.painSwelling;
	}

	public void setPainSwelling(String painSwelling) {
		this.painSwelling = painSwelling;
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

	@Field(name = "regular_periods")
	public String getRegularPeriods() {
		return this.regularPeriods;
	}

	public void setRegularPeriods(String regularPeriods) {
		this.regularPeriods = regularPeriods;
	}

	@Field(name = "tablets_received")
	public String getTabletsReceived() {
		return this.tabletsReceived;
	}

	public void setTabletsReceived(String tabletsReceived) {
		this.tabletsReceived = tabletsReceived;
	}

	@Field(name = "taken_as_prescribed")
	public String getTakenAsPrescribed() {
		return this.takenAsPrescribed;
	}

	public void setTakenAsPrescribed(String takenAsPrescribed) {
		this.takenAsPrescribed = takenAsPrescribed;
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

	@Field(name = "understand_tablets")
	public String getUnderstandTablets() {
		return this.understandTablets;
	}

	public void setUnderstandTablets(String understandTablets) {
		this.understandTablets = understandTablets;
	}

	@Field(name = "using_correctly")
	public String getUsingCorrectly() {
		return this.usingCorrectly;
	}

	public void setUsingCorrectly(String usingCorrectly) {
		this.usingCorrectly = usingCorrectly;
	}

	@Field(name = "where_replace")
	public String getWhereReplace() {
		return this.whereReplace;
	}

	public void setWhereReplace(String whereReplace) {
		this.whereReplace = whereReplace;
	}

	@Field(name = "why_no_ppffp")
	public String getWhyNoPpffp() {
		return this.whyNoPpffp;
	}

	public void setWhyNoPpffp(String whyNoPpffp) {
		this.whyNoPpffp = whyNoPpffp;
	}

	@Field(name = "within_42")
	public String getWithin42() {
		return this.within42;
	}

	public void setWithin42(String within42) {
		this.within42 = within42;
	}

	
	@Field(name = "date_tl_adopted")
	public DateTime getDateTlAdopted() {
		return this.dateTlAdopted;
	}

	public void setDateTlAdopted(DateTime dateTlAdopted) {
		this.dateTlAdopted = dateTlAdopted;
	}

	@Field(name = "abdominal_pain")
	public String getAbdominalPain() {
		return this.abdominalPain;
	}

	public void setAbdominalPain(String abdominalPain) {
		this.abdominalPain = abdominalPain;
	}

	@Field(name = "pain_urination")
	public String getPainUrination() {
		return this.painUrination;
	}

	public void setPainUrination(String painUrination) {
		this.painUrination = painUrination;
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
}
