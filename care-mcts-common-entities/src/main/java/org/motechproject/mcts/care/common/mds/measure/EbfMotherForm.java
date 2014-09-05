package org.motechproject.mcts.care.common.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.mcts.care.common.mds.dimension.Flw;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
import org.motechproject.mcts.care.common.utils.FormToString;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;


@Entity(name = "ebf_mother_form")
@Unique(members = "instanceId")
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
	public String getAskPpiud() {
		return this.askPpiud;
	}

	public void setAskPpiud(String askPpiud) {
		this.askPpiud = askPpiud;
	}

	@Field
	public String getAwareOfFailure() {
		return this.awareOfFailure;
	}

	public void setAwareOfFailure(String awareOfFailure) {
		this.awareOfFailure = awareOfFailure;
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
	public String getCondoms() {
		return this.condoms;
	}

	public void setCondoms(String condoms) {
		this.condoms = condoms;
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
	public String getCounselMenstrualCycle() {
		return this.counselMenstrualCycle;
	}

	public void setCounselMenstrualCycle(String counselMenstrualCycle) {
		this.counselMenstrualCycle = counselMenstrualCycle;
	}

	@Field
	public String getCounselMethods() {
		return this.counselMethods;
	}

	public void setCounselMethods(String counselMethods) {
		this.counselMethods = counselMethods;
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
	public DateTime getDateEb1() {
		return this.dateEb1;
	}

	public void setDateEb1(DateTime dateEb1) {
		this.dateEb1 = dateEb1;
	}

	
	@Field
	public DateTime getDateEb2() {
		return this.dateEb2;
	}

	public void setDateEb2(DateTime dateEb2) {
		this.dateEb2 = dateEb2;
	}

	
	@Field
	public DateTime getDateEb3() {
		return this.dateEb3;
	}

	public void setDateEb3(DateTime dateEb3) {
		this.dateEb3 = dateEb3;
	}

	
	@Field
	public DateTime getDateEb4() {
		return this.dateEb4;
	}

	public void setDateEb4(DateTime dateEb4) {
		this.dateEb4 = dateEb4;
	}

	
	@Field
	public DateTime getDateEb5() {
		return this.dateEb5;
	}

	public void setDateEb5(DateTime dateEb5) {
		this.dateEb5 = dateEb5;
	}

	
	@Field
	public DateTime getDateEb6() {
		return this.dateEb6;
	}

	public void setDateEb6(DateTime dateEb6) {
		this.dateEb6 = dateEb6;
	}

	
	@Field
	public DateTime getDateIudAdopted() {
		return this.dateIudAdopted;
	}

	public void setDateIudAdopted(DateTime dateIudAdopted) {
		this.dateIudAdopted = dateIudAdopted;
	}

	
	@Field
	public DateTime getDateLastInj() {
		return this.dateLastInj;
	}

	public void setDateLastInj(DateTime dateLastInj) {
		this.dateLastInj = dateLastInj;
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
	public int getEbVisitNum() {
		return this.ebVisitNum;
	}

	public void setEbVisitNum(int ebVisitNum) {
		this.ebVisitNum = ebVisitNum;
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
	public String getHaveCondoms() {
		return this.haveCondoms;
	}

	public void setHaveCondoms(String haveCondoms) {
		this.haveCondoms = haveCondoms;
	}

	@Field
	public String getHeadaches() {
		return this.headaches;
	}

	public void setHeadaches(String headaches) {
		this.headaches = headaches;
	}

	@Field
	public String getHighBp() {
		return this.highBp;
	}

	public void setHighBp(String highBp) {
		this.highBp = highBp;
	}

	@Field
	public String getInjMenstrualIrregularity() {
		return this.injMenstrualIrregularity;
	}

	public void setInjMenstrualIrregularity(String injMenstrualIrregularity) {
		this.injMenstrualIrregularity = injMenstrualIrregularity;
	}

	@Field
	public String getInjectable() {
		return this.injectable;
	}

	public void setInjectable(String injectable) {
		this.injectable = injectable;
	}

	@Field
	public String getIntendToContinue() {
		return this.intendToContinue;
	}

	public void setIntendToContinue(String intendToContinue) {
		this.intendToContinue = intendToContinue;
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
	public String getMenstrualIrregularity() {
		return this.menstrualIrregularity;
	}

	public void setMenstrualIrregularity(String menstrualIrregularity) {
		this.menstrualIrregularity = menstrualIrregularity;
	}

	
	@Field
	public DateTime getNextInjCalc() {
		return this.nextInjCalc;
	}

	public void setNextInjCalc(DateTime nextInjCalc) {
		this.nextInjCalc = nextInjCalc;
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
	public String getOcp() {
		return this.ocp;
	}

	public void setOcp(String ocp) {
		this.ocp = ocp;
	}

	@Field
	public String getOcpContinue() {
		return this.ocpContinue;
	}

	public void setOcpContinue(String ocpContinue) {
		this.ocpContinue = ocpContinue;
	}

	@Field
	public String getOcpCounselRegularity() {
		return this.ocpCounselRegularity;
	}

	public void setOcpCounselRegularity(String ocpCounselRegularity) {
		this.ocpCounselRegularity = ocpCounselRegularity;
	}

	@Field
	public String getPainSwelling() {
		return this.painSwelling;
	}

	public void setPainSwelling(String painSwelling) {
		this.painSwelling = painSwelling;
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
	public String getRegularPeriods() {
		return this.regularPeriods;
	}

	public void setRegularPeriods(String regularPeriods) {
		this.regularPeriods = regularPeriods;
	}

	@Field
	public String getTabletsReceived() {
		return this.tabletsReceived;
	}

	public void setTabletsReceived(String tabletsReceived) {
		this.tabletsReceived = tabletsReceived;
	}

	@Field
	public String getTakenAsPrescribed() {
		return this.takenAsPrescribed;
	}

	public void setTakenAsPrescribed(String takenAsPrescribed) {
		this.takenAsPrescribed = takenAsPrescribed;
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
	public String getUnderstandTablets() {
		return this.understandTablets;
	}

	public void setUnderstandTablets(String understandTablets) {
		this.understandTablets = understandTablets;
	}

	@Field
	public String getUsingCorrectly() {
		return this.usingCorrectly;
	}

	public void setUsingCorrectly(String usingCorrectly) {
		this.usingCorrectly = usingCorrectly;
	}

	@Field
	public String getWhereReplace() {
		return this.whereReplace;
	}

	public void setWhereReplace(String whereReplace) {
		this.whereReplace = whereReplace;
	}

	@Field
	public String getWhyNoPpffp() {
		return this.whyNoPpffp;
	}

	public void setWhyNoPpffp(String whyNoPpffp) {
		this.whyNoPpffp = whyNoPpffp;
	}

	@Field
	public String getWithin42() {
		return this.within42;
	}

	public void setWithin42(String within42) {
		this.within42 = within42;
	}

	
	@Field
	public DateTime getDateTlAdopted() {
		return this.dateTlAdopted;
	}

	public void setDateTlAdopted(DateTime dateTlAdopted) {
		this.dateTlAdopted = dateTlAdopted;
	}

	@Field
	public String getAbdominalPain() {
		return this.abdominalPain;
	}

	public void setAbdominalPain(String abdominalPain) {
		this.abdominalPain = abdominalPain;
	}

	@Field
	public String getPainUrination() {
		return this.painUrination;
	}

	public void setPainUrination(String painUrination) {
		this.painUrination = painUrination;
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
