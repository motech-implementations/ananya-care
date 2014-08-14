package org.motechproject.care.reporting.mds.measure;

import java.math.BigDecimal;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.care.reporting.domain.dimension.ChildCase;
import org.motechproject.care.reporting.domain.dimension.Flw;
import org.motechproject.care.reporting.utils.FormToString;
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
	private BigDecimal firstWeight;
	private String skinCare;
	private String whatApplied;
	private String wrappedDried;
    private Boolean close;
    private DateTime creationTime = new DateTime();

    public DeliveryChildForm() {
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
	public ChildCase getChildCase() {
		return this.childCase;
	}

	public void setChildCase(ChildCase childCase) {
		this.childCase = childCase;
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

	@Field(name = "abnormalities")
	public String getAbnormalities() {
		return this.abnormalities;
	}

	public void setAbnormalities(String abnormalities) {
		this.abnormalities = abnormalities;
	}

	@Field(name = "add_vaccinations")
	public String getAddVaccinations() {
		return this.addVaccinations;
	}

	public void setAddVaccinations(String addVaccinations) {
		this.addVaccinations = addVaccinations;
	}

	@Field(name = "baby_bcg")
	public String getBabyBcg() {
		return this.babyBcg;
	}

	public void setBabyBcg(String babyBcg) {
		this.babyBcg = babyBcg;
	}

	@Field(name = "baby_hep_b_0")
	public String getBabyHepB0() {
		return this.babyHepB0;
	}

	public void setBabyHepB0(String babyHepB0) {
		this.babyHepB0 = babyHepB0;
	}

	@Field(name = "baby_opv0")
	public String getBabyOpv0() {
		return this.babyOpv0;
	}

	public void setBabyOpv0(String babyOpv0) {
		this.babyOpv0 = babyOpv0;
	}

	@Field(name = "breastfed_hour")
	public String getBreastfedHour() {
		return this.breastfedHour;
	}

	public void setBreastfedHour(String breastfedHour) {
		this.breastfedHour = breastfedHour;
	}

	@Field(name = "case_name")
	public String getCaseName() {
		return this.caseName;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}

	@Field(name = "case_type")
	public String getCaseType() {
		return this.caseType;
	}

	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}

	@Field(name = "baby_weight")
	public String getBabyWeight() {
		return this.babyWeight;
	}

	public void setBabyWeight(String babyWeight) {
		this.babyWeight = babyWeight;
	}

	
	@Field(name = "bcg_date")
	public DateTime getBcgDateTime() {
		return this.bcgDate;
	}

	public void setBcgDate(DateTime bcgDate) {
		this.bcgDate = bcgDate;
	}

	@Field(name = "birth_status")
	public String getBirthStatus() {
		return this.birthStatus;
	}

	public void setBirthStatus(String birthStatus) {
		this.birthStatus = birthStatus;
	}

	
	@Field(name = "dob")
	public DateTime getDob() {
		return this.dob;
	}

	public void setDob(DateTime dob) {
		this.dob = dob;
	}

	@Field(name = "gender")
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
	@Field(name = "hep_b_0_date")
	public DateTime getHepB0DateTime() {
		return this.hepB0Date;
	}

	public void setHepB0Date(DateTime hepB0Date) {
		this.hepB0Date = hepB0Date;
	}

	
	@Field(name = "opv_0_date")
	public DateTime getOpv0DateTime() {
		return this.opv0Date;
	}

	public void setOpv0Date(DateTime opv0Date) {
		this.opv0Date = opv0Date;
	}

	@Field(name = "term")
	public String getTerm() {
		return this.term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	@Field(name = "time_of_birth")
	public String getTimeOfBirth() {
		return this.timeOfBirth;
	}

	public void setTimeOfBirth(String timeOfBirth) {
		this.timeOfBirth = timeOfBirth;
	}

	@Field(name = "child_alive")
	public String getChildAlive() {
		return this.childAlive;
	}

	public void setChildAlive(String childAlive) {
		this.childAlive = childAlive;
	}

	@Field(name = "child_breathing")
	public String getChildBreathing() {
		return this.childBreathing;
	}

	public void setChildBreathing(String childBreathing) {
		this.childBreathing = childBreathing;
	}

	@Field(name = "child_cried")
	public String getChildCried() {
		return this.childCried;
	}

	public void setChildCried(String childCried) {
		this.childCried = childCried;
	}

	@Field(name = "child_died_village")
	public String getChildDiedVillage() {
		return this.childDiedVillage;
	}

	public void setChildDiedVillage(String childDiedVillage) {
		this.childDiedVillage = childDiedVillage;
	}

	@Field(name = "child_have_a_name")
	public String getChildHaveAName() {
		return this.childHaveAName;
	}

	public void setChildHaveAName(String childHaveAName) {
		this.childHaveAName = childHaveAName;
	}

	@Field(name = "child_heartbeats")
	public String getChildHeartbeats() {
		return this.childHeartbeats;
	}

	public void setChildHeartbeats(String childHeartbeats) {
		this.childHeartbeats = childHeartbeats;
	}

	@Field(name = "child_movement")
	public String getChildMovement() {
		return this.childMovement;
	}

	public void setChildMovement(String childMovement) {
		this.childMovement = childMovement;
	}

	@Field(name = "child_name")
	public String getChildName() {
		return this.childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	@Field(name = "child_place_death")
	public String getChildPlaceDeath() {
		return this.childPlaceDeath;
	}

	public void setChildPlaceDeath(String childPlaceDeath) {
		this.childPlaceDeath = childPlaceDeath;
	}

	@Field(name = "child_site_death")
	public String getChildSiteDeath() {
		return this.childSiteDeath;
	}

	public void setChildSiteDeath(String childSiteDeath) {
		this.childSiteDeath = childSiteDeath;
	}

	
	@Field(name = "chld_date_death")
	public DateTime getChldDateDeath() {
		return this.chldDateDeath;
	}

	public void setChldDateDeath(DateTime chldDateDeath) {
		this.chldDateDeath = chldDateDeath;
	}

	@Field(name = "cord_applied")
	public String getCordApplied() {
		return this.cordApplied;
	}

	public void setCordApplied(String cordApplied) {
		this.cordApplied = cordApplied;
	}

	@Field(name = "cord_cut")
	public String getCordCut() {
		return this.cordCut;
	}

	public void setCordCut(String cordCut) {
		this.cordCut = cordCut;
	}

	@Field(name = "cord_tied")
	public String getCordTied() {
		return this.cordTied;
	}

	public void setCordTied(String cordTied) {
		this.cordTied = cordTied;
	}

	
	@Field(name = "date_first_weight")
	public DateTime getDateFirstWeight() {
		return this.dateFirstWeight;
	}

	public void setDateFirstWeight(DateTime dateFirstWeight) {
		this.dateFirstWeight = dateFirstWeight;
	}

	
	@Field(name = "date_time_feed")
	public DateTime getDateTimeFeed() {
		return this.dateTimeFeed;
	}

	public void setDateTimeFeed(DateTime dateTimeFeed) {
		this.dateTimeFeed = dateTimeFeed;
	}

	@Field(name = "first_weight")//TODO: precision = 131089, scale = 0)
	public BigDecimal getFirstWeight() {
		return this.firstWeight;
	}

	public void setFirstWeight(BigDecimal firstWeight) {
		this.firstWeight = firstWeight;
	}

	@Field(name = "skin_care")
	public String getSkinCare() {
		return this.skinCare;
	}

	public void setSkinCare(String skinCare) {
		this.skinCare = skinCare;
	}

	@Field(name = "what_applied")
	public String getWhatApplied() {
		return this.whatApplied;
	}

	public void setWhatApplied(String whatApplied) {
		this.whatApplied = whatApplied;
	}

	@Field(name = "wrapped_dried")
	public String getWrappedDried() {
		return this.wrappedDried;
	}

	public void setWrappedDried(String wrappedDried) {
		this.wrappedDried = wrappedDried;
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
}
