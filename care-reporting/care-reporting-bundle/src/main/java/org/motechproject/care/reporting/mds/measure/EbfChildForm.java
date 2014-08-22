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

	@Field(name = "add_vaccinations")
	public String getAddVaccinations() {
		return this.addVaccinations;
	}

	public void setAddVaccinations(String addVaccinations) {
		this.addVaccinations = addVaccinations;
	}

	@Field(name = "at_night")
	public String getAtNight() {
		return this.atNight;
	}

	public void setAtNight(String atNight) {
		this.atNight = atNight;
	}

	@Field(name = "baby_bcg")
	public String getBabyBcg() {
		return this.babyBcg;
	}

	public void setBabyBcg(String babyBcg) {
		this.babyBcg = babyBcg;
	}

	@Field(name = "baby_dpt1")
	public String getBabyDpt1() {
		return this.babyDpt1;
	}

	public void setBabyDpt1(String babyDpt1) {
		this.babyDpt1 = babyDpt1;
	}

	@Field(name = "baby_dpt2")
	public String getBabyDpt2() {
		return this.babyDpt2;
	}

	public void setBabyDpt2(String babyDpt2) {
		this.babyDpt2 = babyDpt2;
	}

	@Field(name = "baby_dpt3")
	public String getBabyDpt3() {
		return this.babyDpt3;
	}

	public void setBabyDpt3(String babyDpt3) {
		this.babyDpt3 = babyDpt3;
	}

	@Field(name = "baby_hep_b_0")
	public String getBabyHepB0() {
		return this.babyHepB0;
	}

	public void setBabyHepB0(String babyHepB0) {
		this.babyHepB0 = babyHepB0;
	}

	@Field(name = "baby_hep_b_1")
	public String getBabyHepB1() {
		return this.babyHepB1;
	}

	public void setBabyHepB1(String babyHepB1) {
		this.babyHepB1 = babyHepB1;
	}

	@Field(name = "baby_hep_b_2")
	public String getBabyHepB2() {
		return this.babyHepB2;
	}

	public void setBabyHepB2(String babyHepB2) {
		this.babyHepB2 = babyHepB2;
	}

	@Field(name = "baby_hep_b_3")
	public String getBabyHepB3() {
		return this.babyHepB3;
	}

	public void setBabyHepB3(String babyHepB3) {
		this.babyHepB3 = babyHepB3;
	}

	@Field(name = "baby_opv0")
	public String getBabyOpv0() {
		return this.babyOpv0;
	}

	public void setBabyOpv0(String babyOpv0) {
		this.babyOpv0 = babyOpv0;
	}

	@Field(name = "baby_opv1")
	public String getBabyOpv1() {
		return this.babyOpv1;
	}

	public void setBabyOpv1(String babyOpv1) {
		this.babyOpv1 = babyOpv1;
	}

	@Field(name = "baby_opv2")
	public String getBabyOpv2() {
		return this.babyOpv2;
	}

	public void setBabyOpv2(String babyOpv2) {
		this.babyOpv2 = babyOpv2;
	}

	@Field(name = "baby_opv3")
	public String getBabyOpv3() {
		return this.babyOpv3;
	}

	public void setBabyOpv3(String babyOpv3) {
		this.babyOpv3 = babyOpv3;
	}

	
	@Field(name = "bcg_date")
	public DateTime getBcgDateTime() {
		return this.bcgDate;
	}

	public void setBcgDate(DateTime bcgDate) {
		this.bcgDate = bcgDate;
	}

	@Field(name = "breastfeeding")
	public String getBreastfeeding() {
		return this.breastfeeding;
	}

	public void setBreastfeeding(String breastfeeding) {
		this.breastfeeding = breastfeeding;
	}

	@Field(name = "case_name")
	public String getCaseName() {
		return this.caseName;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}

	@Field(name = "child_name")
	public String getChildName() {
		return this.childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	@Field(name = "counsel_adequate_bf")
	public String getCounselAdequateBf() {
		return this.counselAdequateBf;
	}

	public void setCounselAdequateBf(String counselAdequateBf) {
		this.counselAdequateBf = counselAdequateBf;
	}

	@Field(name = "counsel_only_milk")
	public String getCounselOnlyMilk() {
		return this.counselOnlyMilk;
	}

	public void setCounselOnlyMilk(String counselOnlyMilk) {
		this.counselOnlyMilk = counselOnlyMilk;
	}

	@Field(name = "counsel_stop_bottle")
	public String getCounselStopBottle() {
		return this.counselStopBottle;
	}

	public void setCounselStopBottle(String counselStopBottle) {
		this.counselStopBottle = counselStopBottle;
	}

	
	@Field(name = "dpt_1_date")
	public DateTime getDpt1DateTime() {
		return this.dpt1Date;
	}

	public void setDpt1Date(DateTime dpt1Date) {
		this.dpt1Date = dpt1Date;
	}

	
	@Field(name = "dpt_2_date")
	public DateTime getDpt2DateTime() {
		return this.dpt2Date;
	}

	public void setDpt2Date(DateTime dpt2Date) {
		this.dpt2Date = dpt2Date;
	}

	
	@Field(name = "dpt_3_date")
	public DateTime getDpt3DateTime() {
		return this.dpt3Date;
	}

	public void setDpt3Date(DateTime dpt3Date) {
		this.dpt3Date = dpt3Date;
	}

	@Field(name = "eating")
	public String getEating() {
		return this.eating;
	}

	public void setEating(String eating) {
		this.eating = eating;
	}

	@Field(name = "emptying")
	public String getEmptying() {
		return this.emptying;
	}

	public void setEmptying(String emptying) {
		this.emptying = emptying;
	}

	@Field(name = "feeding_bottle")
	public String getFeedingBottle() {
		return this.feedingBottle;
	}

	public void setFeedingBottle(String feedingBottle) {
		this.feedingBottle = feedingBottle;
	}

	
	@Field(name = "hep_b_0_date")
	public DateTime getHepB0DateTime() {
		return this.hepB0Date;
	}

	public void setHepB0Date(DateTime hepB0Date) {
		this.hepB0Date = hepB0Date;
	}

	
	@Field(name = "hep_b_1_date")
	public DateTime getHepB1DateTime() {
		return this.hepB1Date;
	}

	public void setHepB1Date(DateTime hepB1Date) {
		this.hepB1Date = hepB1Date;
	}

	
	@Field(name = "hep_b_2_date")
	public DateTime getHepB2DateTime() {
		return this.hepB2Date;
	}

	public void setHepB2Date(DateTime hepB2Date) {
		this.hepB2Date = hepB2Date;
	}

	
	@Field(name = "hep_b_3_date")
	public DateTime getHepB3DateTime() {
		return this.hepB3Date;
	}

	public void setHepB3Date(DateTime hepB3Date) {
		this.hepB3Date = hepB3Date;
	}

	@Field(name = "more_feeding_less_six")
	public String getMoreFeedingLessSix() {
		return this.moreFeedingLessSix;
	}

	public void setMoreFeedingLessSix(String moreFeedingLessSix) {
		this.moreFeedingLessSix = moreFeedingLessSix;
	}

	@Field(name = "name_update")
	public String getNameupdate() {
		return this.nameUpdate;
	}

	public void setNameUpdate(String nameUpdate) {
		this.nameUpdate = nameUpdate;
	}

	@Field(name = "not_breasfeeding")
	public String getNotBreasfeeding() {
		return this.notBreasfeeding;
	}

	public void setNotBreasfeeding(String notBreasfeeding) {
		this.notBreasfeeding = notBreasfeeding;
	}

	@Field(name = "on_demand")
	public String getOnDemand() {
		return this.onDemand;
	}

	public void setOnDemand(String onDemand) {
		this.onDemand = onDemand;
	}

	
	@Field(name = "opv_0_date")
	public DateTime getOpv0DateTime() {
		return this.opv0Date;
	}

	public void setOpv0Date(DateTime opv0Date) {
		this.opv0Date = opv0Date;
	}

	
	@Field(name = "opv_1_date")
	public DateTime getOpv1DateTime() {
		return this.opv1Date;
	}

	public void setOpv1Date(DateTime opv1Date) {
		this.opv1Date = opv1Date;
	}

	
	@Field(name = "opv_2_date")
	public DateTime getOpv2DateTime() {
		return this.opv2Date;
	}

	public void setOpv2Date(DateTime opv2Date) {
		this.opv2Date = opv2Date;
	}

	
	@Field(name = "opv_3_date")
	public DateTime getOpv3DateTime() {
		return this.opv3Date;
	}

	public void setOpv3Date(DateTime opv3Date) {
		this.opv3Date = opv3Date;
	}

	@Field(name = "recent_fever")
	public String getRecentFever() {
		return this.recentFever;
	}

	public void setRecentFever(String recentFever) {
		this.recentFever = recentFever;
	}

	@Field(name = "tea_other")
	public String getTeaOther() {
		return this.teaOther;
	}

	public void setTeaOther(String teaOther) {
		this.teaOther = teaOther;
	}

	@Field(name = "treated_less_six")
	public String getTreatedLessSix() {
		return this.treatedLessSix;
	}

	public void setTreatedLessSix(String treatedLessSix) {
		this.treatedLessSix = treatedLessSix;
	}

	@Field(name = "water_or_milk")
	public String getWaterOrMilk() {
		return this.waterOrMilk;
	}

	public void setWaterOrMilk(String waterOrMilk) {
		this.waterOrMilk = waterOrMilk;
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
