package org.motechproject.mcts.care.common.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.dimension.Flw;
import org.motechproject.mcts.care.common.utils.FormToString;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(name = "delivery_child_form")
@Unique(members = {"instance_id","case_id"})
public class DeliveryChildForm extends Form {

	private Flw flw;
	private ChildCase childCase;
	private DateTime timeEnd;
	private DateTime timeStart;
	private DateTime dateModified;
	private String abnormalities;
	private String addVaccinations;
	private String babyBcg;
	private String babyHepB0;
	private String babyOpv0;
	private String breastfedHour;
	private String caseName;
	private String caseType;
	private String babyWeight;
	private DateTime bcgDate;
	private String birthStatus;
	private DateTime dob;
	private String gender;
	private DateTime hepB0Date;
	private DateTime opv0Date;
	private String term;
	private String timeOfBirth;
	private String childAlive;
	private String childBreathing;
	private String childCried;
	private String childDiedVillage;
	private String childHaveAName;
	private String childHeartbeats;
	private String childMovement;
	private String childName;
	private String childPlaceDeath;
	private String childSiteDeath;
	private DateTime chldDateDeath;
	private String cordApplied;
	private String cordCut;
	private String cordTied;
	private DateTime dateFirstWeight;
	private DateTime dateTimeFeed;
	private int firstWeight;
	private String skinCare;
	private String whatApplied;
	private String wrappedDried;
    private Boolean close;
    private DateTime creationTime = new DateTime();

    public DeliveryChildForm() {
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
	public ChildCase getChildCase() {
		return this.childCase;
	}

	public void setChildCase(ChildCase childCase) {
		this.childCase = childCase;
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
	public String getAbnormalities() {
		return this.abnormalities;
	}

	public void setAbnormalities(String abnormalities) {
		this.abnormalities = abnormalities;
	}

	@Field
	public String getAddVaccinations() {
		return this.addVaccinations;
	}

	public void setAddVaccinations(String addVaccinations) {
		this.addVaccinations = addVaccinations;
	}

	@Field
	public String getBabyBcg() {
		return this.babyBcg;
	}

	public void setBabyBcg(String babyBcg) {
		this.babyBcg = babyBcg;
	}

	@Field
	public String getBabyHepB0() {
		return this.babyHepB0;
	}

	public void setBabyHepB0(String babyHepB0) {
		this.babyHepB0 = babyHepB0;
	}

	@Field
	public String getBabyOpv0() {
		return this.babyOpv0;
	}

	public void setBabyOpv0(String babyOpv0) {
		this.babyOpv0 = babyOpv0;
	}

	@Field
	public String getBreastfedHour() {
		return this.breastfedHour;
	}

	public void setBreastfedHour(String breastfedHour) {
		this.breastfedHour = breastfedHour;
	}

	@Field
	public String getCaseName() {
		return this.caseName;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}

	@Field
	public String getCaseType() {
		return this.caseType;
	}

	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}

	@Field
	public String getBabyWeight() {
		return this.babyWeight;
	}

	public void setBabyWeight(String babyWeight) {
		this.babyWeight = babyWeight;
	}

	
	@Field
	public DateTime getBcgDateTime() {
		return this.bcgDate;
	}

	public void setBcgDate(DateTime bcgDate) {
		this.bcgDate = bcgDate;
	}

	@Field
	public String getBirthStatus() {
		return this.birthStatus;
	}

	public void setBirthStatus(String birthStatus) {
		this.birthStatus = birthStatus;
	}

	
	@Field
	public DateTime getDob() {
		return this.dob;
	}

	public void setDob(DateTime dob) {
		this.dob = dob;
	}

	@Field
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
	@Field
	public DateTime getHepB0DateTime() {
		return this.hepB0Date;
	}

	public void setHepB0Date(DateTime hepB0Date) {
		this.hepB0Date = hepB0Date;
	}

	
	@Field
	public DateTime getOpv0DateTime() {
		return this.opv0Date;
	}

	public void setOpv0Date(DateTime opv0Date) {
		this.opv0Date = opv0Date;
	}

	@Field
	public String getTerm() {
		return this.term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	@Field
	public String getTimeOfBirth() {
		return this.timeOfBirth;
	}

	public void setTimeOfBirth(String timeOfBirth) {
		this.timeOfBirth = timeOfBirth;
	}

	@Field
	public String getChildAlive() {
		return this.childAlive;
	}

	public void setChildAlive(String childAlive) {
		this.childAlive = childAlive;
	}

	@Field
	public String getChildBreathing() {
		return this.childBreathing;
	}

	public void setChildBreathing(String childBreathing) {
		this.childBreathing = childBreathing;
	}

	@Field
	public String getChildCried() {
		return this.childCried;
	}

	public void setChildCried(String childCried) {
		this.childCried = childCried;
	}

	@Field
	public String getChildDiedVillage() {
		return this.childDiedVillage;
	}

	public void setChildDiedVillage(String childDiedVillage) {
		this.childDiedVillage = childDiedVillage;
	}

	@Field
	public String getChildHaveAName() {
		return this.childHaveAName;
	}

	public void setChildHaveAName(String childHaveAName) {
		this.childHaveAName = childHaveAName;
	}

	@Field
	public String getChildHeartbeats() {
		return this.childHeartbeats;
	}

	public void setChildHeartbeats(String childHeartbeats) {
		this.childHeartbeats = childHeartbeats;
	}

	@Field
	public String getChildMovement() {
		return this.childMovement;
	}

	public void setChildMovement(String childMovement) {
		this.childMovement = childMovement;
	}

	@Field
	public String getChildName() {
		return this.childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	@Field
	public String getChildPlaceDeath() {
		return this.childPlaceDeath;
	}

	public void setChildPlaceDeath(String childPlaceDeath) {
		this.childPlaceDeath = childPlaceDeath;
	}

	@Field
	public String getChildSiteDeath() {
		return this.childSiteDeath;
	}

	public void setChildSiteDeath(String childSiteDeath) {
		this.childSiteDeath = childSiteDeath;
	}

	
	@Field
	public DateTime getChldDateDeath() {
		return this.chldDateDeath;
	}

	public void setChldDateDeath(DateTime chldDateDeath) {
		this.chldDateDeath = chldDateDeath;
	}

	@Field
	public String getCordApplied() {
		return this.cordApplied;
	}

	public void setCordApplied(String cordApplied) {
		this.cordApplied = cordApplied;
	}

	@Field
	public String getCordCut() {
		return this.cordCut;
	}

	public void setCordCut(String cordCut) {
		this.cordCut = cordCut;
	}

	@Field
	public String getCordTied() {
		return this.cordTied;
	}

	public void setCordTied(String cordTied) {
		this.cordTied = cordTied;
	}

	
	@Field
	public DateTime getDateFirstWeight() {
		return this.dateFirstWeight;
	}

	public void setDateFirstWeight(DateTime dateFirstWeight) {
		this.dateFirstWeight = dateFirstWeight;
	}

	
	@Field
	public DateTime getDateTimeFeed() {
		return this.dateTimeFeed;
	}

	public void setDateTimeFeed(DateTime dateTimeFeed) {
		this.dateTimeFeed = dateTimeFeed;
	}

	@Field
	public int getFirstWeight() {
		return this.firstWeight;
	}

	public void setFirstWeight(int firstWeight) {
		this.firstWeight = firstWeight;
	}

	@Field
	public String getSkinCare() {
		return this.skinCare;
	}

	public void setSkinCare(String skinCare) {
		this.skinCare = skinCare;
	}

	@Field
	public String getWhatApplied() {
		return this.whatApplied;
	}

	public void setWhatApplied(String whatApplied) {
		this.whatApplied = whatApplied;
	}

	@Field
	public String getWrappedDried() {
		return this.wrappedDried;
	}

	public void setWrappedDried(String wrappedDried) {
		this.wrappedDried = wrappedDried;
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
}
