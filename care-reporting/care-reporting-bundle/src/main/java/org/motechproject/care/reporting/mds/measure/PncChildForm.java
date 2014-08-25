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
	public String getAbleExpressedMilk() {
		return this.ableExpressedMilk;
	}

	public void setAbleExpressedMilk(String ableExpressedMilk) {
		this.ableExpressedMilk = ableExpressedMilk;
	}

	@Field
	public String getAdequateSupport() {
		return this.adequateSupport;
	}

	public void setAdequateSupport(String adequateSupport) {
		this.adequateSupport = adequateSupport;
	}

	@Field
	public String getAppliedToStump() {
		return this.appliedToStump;
	}

	public void setAppliedToStump(String appliedToStump) {
		this.appliedToStump = appliedToStump;
	}

	@Field
	public String getBabyActive() {
		return this.babyActive;
	}

	public void setBabyActive(String babyActive) {
		this.babyActive = babyActive;
	}

	@Field
	public String getBreastfeedingWell() {
		return this.breastfeedingWell;
	}

	public void setBreastfeedingWell(String breastfeedingWell) {
		this.breastfeedingWell = breastfeedingWell;
	}

	@Field
	public String getChildAlive() {
		return this.childAlive;
	}

	public void setChildAlive(String childAlive) {
		this.childAlive = childAlive;
	}

	@Field
	public String getChildDiedVillage() {
		return this.childDiedVillage;
	}

	public void setChildDiedVillage(String childDiedVillage) {
		this.childDiedVillage = childDiedVillage;
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
	public String getCordFallen() {
		return this.cordFallen;
	}

	public void setCordFallen(String cordFallen) {
		this.cordFallen = cordFallen;
	}

	@Field
	public String getCorrectPosition() {
		return this.correctPosition;
	}

	public void setCorrectPosition(String correctPosition) {
		this.correctPosition = correctPosition;
	}

	@Field
	public String getCounselCordCare() {
		return this.counselCordCare;
	}

	public void setCounselCordCare(String counselCordCare) {
		this.counselCordCare = counselCordCare;
	}

	@Field
	public String getCounselExclusiveBf() {
		return this.counselExclusiveBf;
	}

	public void setCounselExclusiveBf(String counselExclusiveBf) {
		this.counselExclusiveBf = counselExclusiveBf;
	}

	@Field
	public String getCounselExpressMilk() {
		return this.counselExpressMilk;
	}

	public void setCounselExpressMilk(String counselExpressMilk) {
		this.counselExpressMilk = counselExpressMilk;
	}

	@Field
	public String getCounselSkin() {
		return this.counselSkin;
	}

	public void setCounselSkin(String counselSkin) {
		this.counselSkin = counselSkin;
	}

	@Field
	public String getCouselBfCorrect() {
		return this.couselBfCorrect;
	}

	public void setCouselBfCorrect(String couselBfCorrect) {
		this.couselBfCorrect = couselBfCorrect;
	}

	@Field
	public String getDemonstrateExpressed() {
		return this.demonstrateExpressed;
	}

	public void setDemonstrateExpressed(String demonstrateExpressed) {
		this.demonstrateExpressed = demonstrateExpressed;
	}

	@Field
	public String getDemonstrateSkin() {
		return this.demonstrateSkin;
	}

	public void setDemonstrateSkin(String demonstrateSkin) {
		this.demonstrateSkin = demonstrateSkin;
	}

	@Field
	public String getEasyAwake() {
		return this.easyAwake;
	}

	public void setEasyAwake(String easyAwake) {
		this.easyAwake = easyAwake;
	}

	@Field
	public String getFeedVigour() {
		return this.feedVigour;
	}

	public void setFeedVigour(String feedVigour) {
		this.feedVigour = feedVigour;
	}

	@Field
	public String getGoodLatch() {
		return this.goodLatch;
	}

	public void setGoodLatch(String goodLatch) {
		this.goodLatch = goodLatch;
	}

	@Field
	public String getImprovementsBf() {
		return this.improvementsBf;
	}

	public void setImprovementsBf(String improvementsBf) {
		this.improvementsBf = improvementsBf;
	}

	@Field
	public String getObservedBf() {
		return this.observedBf;
	}

	public void setObservedBf(String observedBf) {
		this.observedBf = observedBf;
	}

	@Field
	public String getOtherMilkToChild() {
		return this.otherMilkToChild;
	}

	public void setOtherMilkToChild(String otherMilkToChild) {
		this.otherMilkToChild = otherMilkToChild;
	}

	@Field
	public String getSecondObservation() {
		return this.secondObservation;
	}

	public void setSecondObservation(String secondObservation) {
		this.secondObservation = secondObservation;
	}

	@Field
	public String getSkinToSkin() {
		return this.skinToSkin;
	}

	public void setSkinToSkin(String skinToSkin) {
		this.skinToSkin = skinToSkin;
	}

	@Field
	public String getWarmToTouch() {
		return this.warmToTouch;
	}

	public void setWarmToTouch(String warmToTouch) {
		this.warmToTouch = warmToTouch;
	}

	@Field
	public String getWhatApplied() {
		return this.whatApplied;
	}

	public void setWhatApplied(String whatApplied) {
		this.whatApplied = whatApplied;
	}

	@Field
	public String getWrapped() {
		return this.wrapped;
	}

	public void setWrapped(String wrapped) {
		this.wrapped = wrapped;
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
