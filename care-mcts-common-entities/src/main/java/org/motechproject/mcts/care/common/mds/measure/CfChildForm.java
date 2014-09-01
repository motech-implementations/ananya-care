package org.motechproject.mcts.care.common.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.dimension.Flw;
import org.motechproject.mcts.care.common.utils.FormToString;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(name = "cf_child_form")
@Unique(members = { "instance_id", "case_id" })
public class CfChildForm extends Form {

    @Field
    @Cascade(persist = true, update = true, delete = false)
    private Flw flw;
    @Field
    @Cascade(persist = true, update = true, delete = false)
    private ChildCase childCase;
    @Field
    private DateTime timeEnd;
    private DateTime timeStart;
    private DateTime dateModified;
    private String addVaccinations;
    private String amountGood;
    private String babyBcg;
    private String babyDpt1;
    private String babyDpt2;
    private String babyDpt3;
    private String babyHepB0;
    private String babyHepB1;
    private String babyHepB2;
    private String babyHepB3;
    private String babyMeasles;
    @Field
    private String babyOpv0;
    @Field
    private String babyOpv1;
    @Field
    private String babyOpv2;
    @Field
    private String babyOpv3;
    @Field
    private String babyVita1;
    @Field
    private DateTime bcgDate;
    @Field
     private String caseName;
    @Field
    private DateTime dpt1Date;
    private DateTime dpt2Date;
    private DateTime dpt3Date;
    private DateTime hepB0Date;
    private DateTime hepB1Date;
    private DateTime hepB2Date;
    private DateTime hepB3Date;
    private DateTime measlesDate;
    private DateTime opv0Date;
    private DateTime opv1Date;
    private DateTime opv2Date;
    private DateTime opv3Date;
    private DateTime vitA1Date;
    private String dal;
    private String eatenCereal;
    private String egg;
    private String fish;
    private String meat;
    private String milkCurd;
    private String moreFeedingLessSix;
    private String nameUpdate;
	private String newName;
    private String numberGood;
    private String oilGhee;
    private String recentFever;
    private String treatedLessSix;
    private String babyDptBooster;
    private String babyJe;
    private String babyMeaslesBooster;
    private String babyOpvBooster;
    private String babyVita2;
    private String babyVita3;
    private DateTime dateJe;
    private DateTime dateMeaslesBooster;
    private DateTime dptBoosterDate;
    @Field
    private DateTime opvBoosterDate;
    @Field
    private DateTime vitA3Date;
    @Field
    private DateTime vitA2Date;
    @Field
    private Boolean close;
    @Field
    private DateTime creationTime = new DateTime();
    @Field
    private String ownerId;

    public CfChildForm() {
    }

    public Flw getFlw() {
        return this.flw;
    }

    public void setFlw(Flw flw) {
        this.flw = flw;
    }
    
    @Field
    public String getNameUpdate() {
		return nameUpdate;
	}

	public void setNameUpdate(String nameUpdate) {
		this.nameUpdate = nameUpdate;
	}


    public ChildCase getChildCase() {
        return this.childCase;
    }

    public void setChildCase(ChildCase childCase) {
        this.childCase = childCase;
    }

    public DateTime getTimeEnd() {
        return this.timeEnd;
    }

    public void setTimeEnd(DateTime timeEnd) {
        this.timeEnd = timeEnd;
    }

    public DateTime getTimeStart() {
        return this.timeStart;
    }

    public void setTimeStart(DateTime timeStart) {
        this.timeStart = timeStart;
    }

    public DateTime getDateModified() {
        return this.dateModified;
    }

    public void setDateModified(DateTime dateModified) {
        this.dateModified = dateModified;
    }

    public String getAddVaccinations() {
        return this.addVaccinations;
    }

    public void setAddVaccinations(String addVaccinations) {
        this.addVaccinations = addVaccinations;
    }

    public String getAmountGood() {
        return this.amountGood;
    }

    public void setAmountGood(String amountGood) {
        this.amountGood = amountGood;
    }

    public String getBabyBcg() {
        return this.babyBcg;
    }

    public void setBabyBcg(String babyBcg) {
        this.babyBcg = babyBcg;
    }

    public String getBabyDpt1() {
        return this.babyDpt1;
    }

    public void setBabyDpt1(String babyDpt1) {
        this.babyDpt1 = babyDpt1;
    }

    public String getBabyDpt2() {
        return this.babyDpt2;
    }

    public void setBabyDpt2(String babyDpt2) {
        this.babyDpt2 = babyDpt2;
    }

    public String getBabyDpt3() {
        return this.babyDpt3;
    }

    public void setBabyDpt3(String babyDpt3) {
        this.babyDpt3 = babyDpt3;
    }

    public String getBabyHepB0() {
        return this.babyHepB0;
    }

    public void setBabyHepB0(String babyHepB0) {
        this.babyHepB0 = babyHepB0;
    }

    public String getBabyHepB1() {
        return this.babyHepB1;
    }

    public void setBabyHepB1(String babyHepB1) {
        this.babyHepB1 = babyHepB1;
    }

    public String getBabyHepB2() {
        return this.babyHepB2;
    }

    public void setBabyHepB2(String babyHepB2) {
        this.babyHepB2 = babyHepB2;
    }

    public String getBabyHepB3() {
        return this.babyHepB3;
    }

    public void setBabyHepB3(String babyHepB3) {
        this.babyHepB3 = babyHepB3;
    }

    public String getBabyMeasles() {
        return this.babyMeasles;
    }

    public void setBabyMeasles(String babyMeasles) {
        this.babyMeasles = babyMeasles;
    }

    public String getBabyOpv0() {
        return this.babyOpv0;
    }

    public void setBabyOpv0(String babyOpv0) {
        this.babyOpv0 = babyOpv0;
    }

    public String getBabyOpv1() {
        return this.babyOpv1;
    }

    public void setBabyOpv1(String babyOpv1) {
        this.babyOpv1 = babyOpv1;
    }

    public String getBabyOpv2() {
        return this.babyOpv2;
    }

    public void setBabyOpv2(String babyOpv2) {
        this.babyOpv2 = babyOpv2;
    }

    public String getBabyOpv3() {
        return this.babyOpv3;
    }

    public void setBabyOpv3(String babyOpv3) {
        this.babyOpv3 = babyOpv3;
    }

    public String getBabyVita1() {
        return this.babyVita1;
    }

    public void setBabyVita1(String babyVita1) {
        this.babyVita1 = babyVita1;
    }

    public DateTime getBcgDateTime() {
        return this.bcgDate;
    }

    public void setBcgDate(DateTime bcgDate) {
        this.bcgDate = bcgDate;
    }

     public String getCaseName() {
        return this.caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

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
    public DateTime getMeaslesDateTime() {
        return this.measlesDate;
    }

    public void setMeaslesDate(DateTime measlesDate) {
        this.measlesDate = measlesDate;
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
    public DateTime getVitA1DateTime() {
        return this.vitA1Date;
    }

    public void setVitA1Date(DateTime vitA1Date) {
        this.vitA1Date = vitA1Date;
    }

    @Field
    public String getDal() {
        return this.dal;
    }

    public void setDal(String dal) {
        this.dal = dal;
    }

    @Field
    public String getEatenCereal() {
        return this.eatenCereal;
    }

    public void setEatenCereal(String eatenCereal) {
        this.eatenCereal = eatenCereal;
    }

    @Field
    public String getEgg() {
        return this.egg;
    }

    public void setEgg(String egg) {
        this.egg = egg;
    }

    @Field
    public String getFish() {
        return this.fish;
    }

    public void setFish(String fish) {
        this.fish = fish;
    }

    @Field
    public String getMeat() {
        return this.meat;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    @Field
    public String getMilkCurd() {
        return this.milkCurd;
    }

    public void setMilkCurd(String milkCurd) {
        this.milkCurd = milkCurd;
    }

    @Field
    public String getMoreFeedingLessSix() {
        return this.moreFeedingLessSix;
    }

    public void setMoreFeedingLessSix(String moreFeedingLessSix) {
        this.moreFeedingLessSix = moreFeedingLessSix;
    }


    @Field
    public String getNewName() {
        return this.newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    @Field
    public String getNumberGood() {
        return this.numberGood;
    }

    public void setNumberGood(String numberGood) {
        this.numberGood = numberGood;
    }

    @Field
    public String getOilGhee() {
        return this.oilGhee;
    }

    public void setOilGhee(String oilGhee) {
        this.oilGhee = oilGhee;
    }

    @Field
    public String getRecentFever() {
        return this.recentFever;
    }

    public void setRecentFever(String recentFever) {
        this.recentFever = recentFever;
    }

    @Field
    public String getTreatedLessSix() {
        return this.treatedLessSix;
    }

    public void setTreatedLessSix(String treatedLessSix) {
        this.treatedLessSix = treatedLessSix;
    }

    @Field
    public String getBabyDptBooster() {
        return this.babyDptBooster;
    }

    public void setBabyDptBooster(String babyDptBooster) {
        this.babyDptBooster = babyDptBooster;
    }

    @Field
    public String getBabyJe() {
        return this.babyJe;
    }

    public void setBabyJe(String babyJe) {
        this.babyJe = babyJe;
    }

    @Field
    public String getBabyMeaslesBooster() {
        return this.babyMeaslesBooster;
    }

    public void setBabyMeaslesBooster(String babyMeaslesBooster) {
        this.babyMeaslesBooster = babyMeaslesBooster;
    }

    @Field
    public String getBabyOpvBooster() {
        return this.babyOpvBooster;
    }

    public void setBabyOpvBooster(String babyOpvBooster) {
        this.babyOpvBooster = babyOpvBooster;
    }

    @Field
    public String getBabyVita2() {
        return this.babyVita2;
    }

    public void setBabyVita2(String babyVita2) {
        this.babyVita2 = babyVita2;
    }

    @Field
    public String getBabyVita3() {
        return this.babyVita3;
    }

    public void setBabyVita3(String babyVita3) {
        this.babyVita3 = babyVita3;
    }

    @Field
    public DateTime getDateJe() {
        return this.dateJe;
    }

    public void setDateJe(DateTime dateJe) {
        this.dateJe = dateJe;
    }

    @Field
    public DateTime getDateMeaslesBooster() {
        return this.dateMeaslesBooster;
    }

    public void setDateMeaslesBooster(DateTime dateMeaslesBooster) {
        this.dateMeaslesBooster = dateMeaslesBooster;
    }

    @Field
    public DateTime getDptBoosterDateTime() {
        return this.dptBoosterDate;
    }

    public void setDptBoosterDate(DateTime dptBoosterDate) {
        this.dptBoosterDate = dptBoosterDate;
    }

    @Field
    public DateTime getOpvBoosterDateTime() {
        return this.opvBoosterDate;
    }

    public void setOpvBoosterDate(DateTime opvBoosterDate) {
        this.opvBoosterDate = opvBoosterDate;
    }

    @Field
    public DateTime getVitA3DateTime() {
        return this.vitA3Date;
    }

    public void setVitA3Date(DateTime vitA3Date) {
        this.vitA3Date = vitA3Date;
    }

    @Field
    public DateTime getVitA2DateTime() {
        return this.vitA2Date;
    }

    public void setVitA2Date(DateTime vitA2Date) {
        this.vitA2Date = vitA2Date;
    }

    @Field
    public Boolean getClose() {
        return close;
    }

    public void setClose(Boolean close) {
        this.close = close;
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
    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
}
