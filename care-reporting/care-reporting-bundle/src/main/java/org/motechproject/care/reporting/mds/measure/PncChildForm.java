package org.motechproject.care.reporting.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.care.reporting.mds.dimension.ChildCase;
import org.motechproject.care.reporting.mds.dimension.Flw;
import org.motechproject.care.reporting.utils.FormToString;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;


@Entity(name = "pnc_child_form")
@Unique(members = {"instance_id","case_id"})
public class PncChildForm extends Form {

	 private Flw flw;
	private ChildCase childCase;
	private DateTime timeEnd;
	private DateTime timeStart;
	private DateTime dateModified;
	private String ableExpressedMilk;
	private String adequateSupport;
	private String appliedToStump;
	private String babyActive;
	private String breastfeedingWell;
	private String childAlive;
	private String childDiedVillage;
	private String childPlaceDeath;
	private String childSiteDeath;
	private DateTime chldDateDeath;
	private String cordFallen;
	private String correctPosition;
	private String counselCordCare;
	private String counselExclusiveBf;
	private String counselExpressMilk;
	private String counselSkin;
	private String couselBfCorrect;
	private String demonstrateExpressed;
	private String demonstrateSkin;
	private String easyAwake;
	private String feedVigour;
	private String goodLatch;
	private String improvementsBf;
	private String observedBf;
	private String otherMilkToChild;
	private String secondObservation;
	private String skinToSkin;
	private String warmToTouch;
	private String whatApplied;
	private String wrapped;
    private Boolean close;
    private DateTime creationTime = new DateTime();

    public PncChildForm() {
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

	@Field(name = "able_expressed_milk")
	public String getAbleExpressedMilk() {
		return this.ableExpressedMilk;
	}

	public void setAbleExpressedMilk(String ableExpressedMilk) {
		this.ableExpressedMilk = ableExpressedMilk;
	}

	@Field(name = "adequate_support")
	public String getAdequateSupport() {
		return this.adequateSupport;
	}

	public void setAdequateSupport(String adequateSupport) {
		this.adequateSupport = adequateSupport;
	}

	@Field(name = "applied_to_stump")
	public String getAppliedToStump() {
		return this.appliedToStump;
	}

	public void setAppliedToStump(String appliedToStump) {
		this.appliedToStump = appliedToStump;
	}

	@Field(name = "baby_active")
	public String getBabyActive() {
		return this.babyActive;
	}

	public void setBabyActive(String babyActive) {
		this.babyActive = babyActive;
	}

	@Field(name = "breastfeeding_well")
	public String getBreastfeedingWell() {
		return this.breastfeedingWell;
	}

	public void setBreastfeedingWell(String breastfeedingWell) {
		this.breastfeedingWell = breastfeedingWell;
	}

	@Field(name = "child_alive")
	public String getChildAlive() {
		return this.childAlive;
	}

	public void setChildAlive(String childAlive) {
		this.childAlive = childAlive;
	}

	@Field(name = "child_died_village")
	public String getChildDiedVillage() {
		return this.childDiedVillage;
	}

	public void setChildDiedVillage(String childDiedVillage) {
		this.childDiedVillage = childDiedVillage;
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

	@Field(name = "cord_fallen")
	public String getCordFallen() {
		return this.cordFallen;
	}

	public void setCordFallen(String cordFallen) {
		this.cordFallen = cordFallen;
	}

	@Field(name = "correct_position")
	public String getCorrectPosition() {
		return this.correctPosition;
	}

	public void setCorrectPosition(String correctPosition) {
		this.correctPosition = correctPosition;
	}

	@Field(name = "counsel_cord_care")
	public String getCounselCordCare() {
		return this.counselCordCare;
	}

	public void setCounselCordCare(String counselCordCare) {
		this.counselCordCare = counselCordCare;
	}

	@Field(name = "counsel_exclusive_bf")
	public String getCounselExclusiveBf() {
		return this.counselExclusiveBf;
	}

	public void setCounselExclusiveBf(String counselExclusiveBf) {
		this.counselExclusiveBf = counselExclusiveBf;
	}

	@Field(name = "counsel_express_milk")
	public String getCounselExpressMilk() {
		return this.counselExpressMilk;
	}

	public void setCounselExpressMilk(String counselExpressMilk) {
		this.counselExpressMilk = counselExpressMilk;
	}

	@Field(name = "counsel_skin")
	public String getCounselSkin() {
		return this.counselSkin;
	}

	public void setCounselSkin(String counselSkin) {
		this.counselSkin = counselSkin;
	}

	@Field(name = "cousel_bf_correct")
	public String getCouselBfCorrect() {
		return this.couselBfCorrect;
	}

	public void setCouselBfCorrect(String couselBfCorrect) {
		this.couselBfCorrect = couselBfCorrect;
	}

	@Field(name = "demonstrate_expressed")
	public String getDemonstrateExpressed() {
		return this.demonstrateExpressed;
	}

	public void setDemonstrateExpressed(String demonstrateExpressed) {
		this.demonstrateExpressed = demonstrateExpressed;
	}

	@Field(name = "demonstrate_skin")
	public String getDemonstrateSkin() {
		return this.demonstrateSkin;
	}

	public void setDemonstrateSkin(String demonstrateSkin) {
		this.demonstrateSkin = demonstrateSkin;
	}

	@Field(name = "easy_awake")
	public String getEasyAwake() {
		return this.easyAwake;
	}

	public void setEasyAwake(String easyAwake) {
		this.easyAwake = easyAwake;
	}

	@Field(name = "feed_vigour")
	public String getFeedVigour() {
		return this.feedVigour;
	}

	public void setFeedVigour(String feedVigour) {
		this.feedVigour = feedVigour;
	}

	@Field(name = "good_latch")
	public String getGoodLatch() {
		return this.goodLatch;
	}

	public void setGoodLatch(String goodLatch) {
		this.goodLatch = goodLatch;
	}

	@Field(name = "improvements_bf")
	public String getImprovementsBf() {
		return this.improvementsBf;
	}

	public void setImprovementsBf(String improvementsBf) {
		this.improvementsBf = improvementsBf;
	}

	@Field(name = "observed_bf")
	public String getObservedBf() {
		return this.observedBf;
	}

	public void setObservedBf(String observedBf) {
		this.observedBf = observedBf;
	}

	@Field(name = "other_milk_to_child")
	public String getOtherMilkToChild() {
		return this.otherMilkToChild;
	}

	public void setOtherMilkToChild(String otherMilkToChild) {
		this.otherMilkToChild = otherMilkToChild;
	}

	@Field(name = "second_observation")
	public String getSecondObservation() {
		return this.secondObservation;
	}

	public void setSecondObservation(String secondObservation) {
		this.secondObservation = secondObservation;
	}

	@Field(name = "skin_to_skin")
	public String getSkinToSkin() {
		return this.skinToSkin;
	}

	public void setSkinToSkin(String skinToSkin) {
		this.skinToSkin = skinToSkin;
	}

	@Field(name = "warm_to_touch")
	public String getWarmToTouch() {
		return this.warmToTouch;
	}

	public void setWarmToTouch(String warmToTouch) {
		this.warmToTouch = warmToTouch;
	}

	@Field(name = "what_applied")
	public String getWhatApplied() {
		return this.whatApplied;
	}

	public void setWhatApplied(String whatApplied) {
		this.whatApplied = whatApplied;
	}

	@Field(name = "wrapped")
	public String getWrapped() {
		return this.wrapped;
	}

	public void setWrapped(String wrapped) {
		this.wrapped = wrapped;
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
        return close;
    }

    public void setClose(Boolean close) {
        this.close = close;
    }

    @Override
    public String toString() {
        return FormToString.toString(this);
    }
}
