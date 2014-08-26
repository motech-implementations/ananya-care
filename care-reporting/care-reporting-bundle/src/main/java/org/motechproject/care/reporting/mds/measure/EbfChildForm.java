package org.motechproject.care.reporting.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.care.reporting.mds.dimension.ChildCase;
import org.motechproject.care.reporting.mds.dimension.Flw;
import org.motechproject.care.reporting.utils.FormToString;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;


@Entity(name = "ebf_child_form")
@Unique(members = {"instance_id","case_id"})
public class EbfChildForm extends Form {
	 private Flw flw;
	private ChildCase childCase;
	private DateTime timeEnd;
	private DateTime timeStart;
	private DateTime dateModified;
	private String addVaccinations;
	private String atNight;
	private String babyBcg;
	private String babyDpt1;
	private String babyDpt2;
	private String babyDpt3;
	private String babyHepB0;
	private String babyHepB1;
	private String babyHepB2;
	private String babyHepB3;
	private String babyOpv0;
	private String babyOpv1;
	private String babyOpv2;
	private String babyOpv3;
	private DateTime bcgDate;
	private String breastfeeding;
	private String caseName;
	private String childName;
	private String counselAdequateBf;
	private String counselOnlyMilk;
	private String counselStopBottle;
	private DateTime dpt1Date;
	private DateTime dpt2Date;
	private DateTime dpt3Date;
	private String eating;
	private String emptying;
	private String feedingBottle;
	private DateTime hepB0Date;
	private DateTime hepB1Date;
	private DateTime hepB2Date;
	private DateTime hepB3Date;
	private String moreFeedingLessSix;
	private String nameUpdate;
	private String notBreasfeeding;
	private String onDemand;
	private DateTime opv0Date;
	private DateTime opv1Date;
	private DateTime opv2Date;
	private DateTime opv3Date;
	private String recentFever;
	private String teaOther;
	private String treatedLessSix;
	private String waterOrMilk;
    private DateTime creationTime = new DateTime();

    public EbfChildForm() {
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
	public String getAddVaccinations() {
		return this.addVaccinations;
	}

	public void setAddVaccinations(String addVaccinations) {
		this.addVaccinations = addVaccinations;
	}

	@Field
	public String getAtNight() {
		return this.atNight;
	}

	public void setAtNight(String atNight) {
		this.atNight = atNight;
	}

	@Field
	public String getBabyBcg() {
		return this.babyBcg;
	}

	public void setBabyBcg(String babyBcg) {
		this.babyBcg = babyBcg;
	}

	@Field
	public String getBabyDpt1() {
		return this.babyDpt1;
	}

	public void setBabyDpt1(String babyDpt1) {
		this.babyDpt1 = babyDpt1;
	}

	@Field
	public String getBabyDpt2() {
		return this.babyDpt2;
	}

	public void setBabyDpt2(String babyDpt2) {
		this.babyDpt2 = babyDpt2;
	}

	@Field
	public String getBabyDpt3() {
		return this.babyDpt3;
	}

	public void setBabyDpt3(String babyDpt3) {
		this.babyDpt3 = babyDpt3;
	}

	@Field
	public String getBabyHepB0() {
		return this.babyHepB0;
	}

	public void setBabyHepB0(String babyHepB0) {
		this.babyHepB0 = babyHepB0;
	}

	@Field
	public String getBabyHepB1() {
		return this.babyHepB1;
	}

	public void setBabyHepB1(String babyHepB1) {
		this.babyHepB1 = babyHepB1;
	}

	@Field
	public String getBabyHepB2() {
		return this.babyHepB2;
	}

	public void setBabyHepB2(String babyHepB2) {
		this.babyHepB2 = babyHepB2;
	}

	@Field
	public String getBabyHepB3() {
		return this.babyHepB3;
	}

	public void setBabyHepB3(String babyHepB3) {
		this.babyHepB3 = babyHepB3;
	}

	@Field
	public String getBabyOpv0() {
		return this.babyOpv0;
	}

	public void setBabyOpv0(String babyOpv0) {
		this.babyOpv0 = babyOpv0;
	}

	@Field
	public String getBabyOpv1() {
		return this.babyOpv1;
	}

	public void setBabyOpv1(String babyOpv1) {
		this.babyOpv1 = babyOpv1;
	}

	@Field
	public String getBabyOpv2() {
		return this.babyOpv2;
	}

	public void setBabyOpv2(String babyOpv2) {
		this.babyOpv2 = babyOpv2;
	}

	@Field
	public String getBabyOpv3() {
		return this.babyOpv3;
	}

	public void setBabyOpv3(String babyOpv3) {
		this.babyOpv3 = babyOpv3;
	}

	
	@Field
	public DateTime getBcgDateTime() {
		return this.bcgDate;
	}

	public void setBcgDate(DateTime bcgDate) {
		this.bcgDate = bcgDate;
	}

	@Field
	public String getBreastfeeding() {
		return this.breastfeeding;
	}

	public void setBreastfeeding(String breastfeeding) {
		this.breastfeeding = breastfeeding;
	}

	@Field
	public String getCaseName() {
		return this.caseName;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}

	@Field
	public String getChildName() {
		return this.childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	@Field
	public String getCounselAdequateBf() {
		return this.counselAdequateBf;
	}

	public void setCounselAdequateBf(String counselAdequateBf) {
		this.counselAdequateBf = counselAdequateBf;
	}

	@Field
	public String getCounselOnlyMilk() {
		return this.counselOnlyMilk;
	}

	public void setCounselOnlyMilk(String counselOnlyMilk) {
		this.counselOnlyMilk = counselOnlyMilk;
	}

	@Field
	public String getCounselStopBottle() {
		return this.counselStopBottle;
	}

	public void setCounselStopBottle(String counselStopBottle) {
		this.counselStopBottle = counselStopBottle;
	}

	
	@Field
	public DateTime getDpt1DateTime() {
		return this.dpt1Date;
	}

	public void setDpt1Date(DateTime dpt1Date) {
		this.dpt1Date = dpt1Date;
	}

	
	@Field
	public DateTime getDpt2DateTime() {
		return this.dpt2Date;
	}

	public void setDpt2Date(DateTime dpt2Date) {
		this.dpt2Date = dpt2Date;
	}

	
	@Field
	public DateTime getDpt3DateTime() {
		return this.dpt3Date;
	}

	public void setDpt3Date(DateTime dpt3Date) {
		this.dpt3Date = dpt3Date;
	}

	@Field
	public String getEating() {
		return this.eating;
	}

	public void setEating(String eating) {
		this.eating = eating;
	}

	@Field
	public String getEmptying() {
		return this.emptying;
	}

	public void setEmptying(String emptying) {
		this.emptying = emptying;
	}

	@Field
	public String getFeedingBottle() {
		return this.feedingBottle;
	}

	public void setFeedingBottle(String feedingBottle) {
		this.feedingBottle = feedingBottle;
	}

	
	@Field
	public DateTime getHepB0DateTime() {
		return this.hepB0Date;
	}

	public void setHepB0Date(DateTime hepB0Date) {
		this.hepB0Date = hepB0Date;
	}

	
	@Field
	public DateTime getHepB1DateTime() {
		return this.hepB1Date;
	}

	public void setHepB1Date(DateTime hepB1Date) {
		this.hepB1Date = hepB1Date;
	}

	
	@Field
	public DateTime getHepB2DateTime() {
		return this.hepB2Date;
	}

	public void setHepB2Date(DateTime hepB2Date) {
		this.hepB2Date = hepB2Date;
	}

	
	@Field
	public DateTime getHepB3DateTime() {
		return this.hepB3Date;
	}

	public void setHepB3Date(DateTime hepB3Date) {
		this.hepB3Date = hepB3Date;
	}

	@Field
	public String getMoreFeedingLessSix() {
		return this.moreFeedingLessSix;
	}

	public void setMoreFeedingLessSix(String moreFeedingLessSix) {
		this.moreFeedingLessSix = moreFeedingLessSix;
	}

	
    @Field
	public String getNameUpdate() {
		return nameUpdate;
	}

	public void setNameUpdate(String nameUpdate) {
		this.nameUpdate = nameUpdate;
	}

	@Field
	public String getNotBreasfeeding() {
		return this.notBreasfeeding;
	}

	public void setNotBreasfeeding(String notBreasfeeding) {
		this.notBreasfeeding = notBreasfeeding;
	}

	@Field
	public String getOnDemand() {
		return this.onDemand;
	}

	public void setOnDemand(String onDemand) {
		this.onDemand = onDemand;
	}

	
	@Field
	public DateTime getOpv0DateTime() {
		return this.opv0Date;
	}

	public void setOpv0Date(DateTime opv0Date) {
		this.opv0Date = opv0Date;
	}

	
	@Field
	public DateTime getOpv1DateTime() {
		return this.opv1Date;
	}

	public void setOpv1Date(DateTime opv1Date) {
		this.opv1Date = opv1Date;
	}

	
	@Field
	public DateTime getOpv2DateTime() {
		return this.opv2Date;
	}

	public void setOpv2Date(DateTime opv2Date) {
		this.opv2Date = opv2Date;
	}

	
	@Field
	public DateTime getOpv3DateTime() {
		return this.opv3Date;
	}

	public void setOpv3Date(DateTime opv3Date) {
		this.opv3Date = opv3Date;
	}

	@Field
	public String getRecentFever() {
		return this.recentFever;
	}

	public void setRecentFever(String recentFever) {
		this.recentFever = recentFever;
	}

	@Field
	public String getTeaOther() {
		return this.teaOther;
	}

	public void setTeaOther(String teaOther) {
		this.teaOther = teaOther;
	}

	@Field
	public String getTreatedLessSix() {
		return this.treatedLessSix;
	}

	public void setTreatedLessSix(String treatedLessSix) {
		this.treatedLessSix = treatedLessSix;
	}

	@Field
	public String getWaterOrMilk() {
		return this.waterOrMilk;
	}

	public void setWaterOrMilk(String waterOrMilk) {
		this.waterOrMilk = waterOrMilk;
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
