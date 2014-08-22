package org.motechproject.care.reporting.mds.measure;

import org.motechproject.care.reporting.mds.dimension.ChildCase;
import org.motechproject.care.reporting.mds.dimension.Flw;
import org.motechproject.care.reporting.utils.FormToString;

import javax.jdo.annotations.Unique;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

import org.joda.time.DateTime;


@Entity(name = "ui_child_form")
@Unique(members = {"instance_id","case_id"})
public class UiChildForm extends Form {

	@Field(name = "user_id")
	@Cascade(persist = true, update = true, delete = false)
	private Flw flw;
	@Field(name = "case_id")
	@Cascade(persist = true, update = true, delete = false)
	private ChildCase childCase;
	@Field(name = "time_end")
	private DateTime timeEnd;
	@Field(name = "time_start")
	private DateTime timeStart;
	@Field(name = "date_modified")
	private DateTime dateModified;
	@Field(name = "add_vaccinations")
	private String addVaccinations;
	@Field(name = "baby_bcg")
	private String babyBcg;
	@Field(name = "baby_dpt1")
	private String babyDpt1;
	@Field(name = "baby_dpt2")
	private String babyDpt2;
	@Field(name = "baby_dpt3")
	private String babyDpt3;
	@Field(name = "baby_hep_b_0")
	private String babyHepB0;
	@Field(name = "baby_hep_b_1")
	private String babyHepB1;
	@Field(name = "baby_hep_b_2")
	private String babyHepB2;
	@Field(name = "baby_hep_b_3")
	private String babyHepB3;
	@Field(name = "baby_measles")
	private String babyMeasles;
	@Field(name = "baby_opv0")
	private String babyOpv0;
	@Field(name = "baby_opv1")
	private String babyOpv1;
	@Field(name = "baby_opv2")
	private String babyOpv2;
	@Field(name = "baby_opv3")
	private String babyOpv3;
	@Field(name = "baby_vita1")
	private String babyVita1;
	@Field(name = "bcg_date")
	private DateTime bcgDate;
	@Field(name = "dpt_1_date")
	private DateTime dpt1Date;
	@Field(name = "dpt_2_date")
	private DateTime dpt2Date;
	@Field(name = "dpt_3_date")
	private DateTime dpt3Date;
	@Field(name = "dpt_booster_date")
	private DateTime dptBoosterDate;
	@Field(name = "hep_b_0_date")
	private DateTime hepB0Date;
	@Field(name = "hep_b_1_date")
	private DateTime hepB1Date;
	@Field(name = "hep_b_2_date")
	private DateTime hepB2Date;
	@Field(name = "hep_b_3_date")
	private DateTime hepB3Date;
	@Field(name = "measles_date")
	private DateTime measlesDate;
	@Field(name = "opv_0_date")
	private DateTime opv0Date;
	@Field(name = "opv_1_date")
	private DateTime opv1Date;
	@Field(name = "opv_2_date")
	private DateTime opv2Date;
	@Field(name = "opv_3_date")
	private DateTime opv3Date;
	@Field(name = "opv_booster_date")
	private DateTime opvBoosterDate;
	@Field(name = "vit_a_1_date")
	private DateTime vitA1Date;
	@Field(name = "baby_dpt_booster")
	private String babyDptBooster;
	@Field(name = "baby_je")
	private String babyJe;
	@Field(name = "baby_measles_booster")
	private String babyMeaslesBooster;
	@Field(name = "baby_opv_booster")
	private String babyOpvBooster;
	@Field(name = "baby_vita2")
	private String babyVita2;
	@Field(name = "baby_vita3")
	private String babyVita3;
	@Field(name = "date_je")
	private DateTime dateJe;
	@Field(name = "date_measles_booster")
	private DateTime dateMeaslesBooster;
	@Field(name = "vit_a_2_date")
	private DateTime vitA2Date;
	@Field(name = "vit_a_3_date")
	private DateTime vitA3Date;
    @Field(name = "creation_time")
    private DateTime creationTime = new DateTime();
	@Field(name = "up_to_date_six_weeks")
    private String upToDateSixWeeks;
	@Field(name = "up_to_date_ten_weeks")
	private String upToDateTenWeeks;
	@Field(name = "up_to_date_14_weeks")
    private String upToDate14Weeks;
	@Field(name = "up_to_date_two_year")
    private String upToDateTwoYear;
	@Field(name = "immuns_up_to_date")
    private String immunsUpToDate;

    public UiChildForm() {
	}

	public Flw getFlw() {
		return this.flw;
	}

	public void setFlw(Flw flw) {
		this.flw = flw;
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

	public DateTime getDpt1DateTime() {
		return this.dpt1Date;
	}

	public void setDpt1Date(DateTime dpt1Date) {
		this.dpt1Date = dpt1Date;
	}

	public DateTime getDpt2DateTime() {
		return this.dpt2Date;
	}

	public void setDpt2Date(DateTime dpt2Date) {
		this.dpt2Date = dpt2Date;
	}

	public DateTime getDpt3DateTime() {
		return this.dpt3Date;
	}

	public void setDpt3Date(DateTime dpt3Date) {
		this.dpt3Date = dpt3Date;
	}

	public DateTime getDptBoosterDateTime() {
		return this.dptBoosterDate;
	}

	public void setDptBoosterDate(DateTime dptBoosterDate) {
		this.dptBoosterDate = dptBoosterDate;
	}

	public DateTime getHepB0DateTime() {
		return this.hepB0Date;
	}

	public void setHepB0Date(DateTime hepB0Date) {
		this.hepB0Date = hepB0Date;
	}

	public DateTime getHepB1DateTime() {
		return this.hepB1Date;
	}

	public void setHepB1Date(DateTime hepB1Date) {
		this.hepB1Date = hepB1Date;
	}

	public DateTime getHepB2DateTime() {
		return this.hepB2Date;
	}

	public void setHepB2Date(DateTime hepB2Date) {
		this.hepB2Date = hepB2Date;
	}

	public DateTime getHepB3DateTime() {
		return this.hepB3Date;
	}

	public void setHepB3Date(DateTime hepB3Date) {
		this.hepB3Date = hepB3Date;
	}

	public DateTime getMeaslesDateTime() {
		return this.measlesDate;
	}

	public void setMeaslesDate(DateTime measlesDate) {
		this.measlesDate = measlesDate;
	}

	public DateTime getOpv0DateTime() {
		return this.opv0Date;
	}

	public void setOpv0Date(DateTime opv0Date) {
		this.opv0Date = opv0Date;
	}

	public DateTime getOpv1DateTime() {
		return this.opv1Date;
	}

	public void setOpv1Date(DateTime opv1Date) {
		this.opv1Date = opv1Date;
	}

	public DateTime getOpv2DateTime() {
		return this.opv2Date;
	}

	public void setOpv2Date(DateTime opv2Date) {
		this.opv2Date = opv2Date;
	}

	public DateTime getOpv3DateTime() {
		return this.opv3Date;
	}

	public void setOpv3Date(DateTime opv3Date) {
		this.opv3Date = opv3Date;
	}

	public DateTime getOpvBoosterDateTime() {
		return this.opvBoosterDate;
	}

	public void setOpvBoosterDate(DateTime opvBoosterDate) {
		this.opvBoosterDate = opvBoosterDate;
	}

	public DateTime getVitA1DateTime() {
		return this.vitA1Date;
	}

	public void setVitA1Date(DateTime vitA1Date) {
		this.vitA1Date = vitA1Date;
	}

	public String getBabyDptBooster() {
		return this.babyDptBooster;
	}

	public void setBabyDptBooster(String babyDptBooster) {
		this.babyDptBooster = babyDptBooster;
	}

	public String getBabyJe() {
		return this.babyJe;
	}

	public void setBabyJe(String babyJe) {
		this.babyJe = babyJe;
	}

	public String getBabyMeaslesBooster() {
		return this.babyMeaslesBooster;
	}

	public void setBabyMeaslesBooster(String babyMeaslesBooster) {
		this.babyMeaslesBooster = babyMeaslesBooster;
	}

	public String getBabyOpvBooster() {
		return this.babyOpvBooster;
	}

	public void setBabyOpvBooster(String babyOpvBooster) {
		this.babyOpvBooster = babyOpvBooster;
	}

	public String getBabyVita2() {
		return this.babyVita2;
	}

	public void setBabyVita2(String babyVita2) {
		this.babyVita2 = babyVita2;
	}

	public String getBabyVita3() {
		return this.babyVita3;
	}

	public void setBabyVita3(String babyVita3) {
		this.babyVita3 = babyVita3;
	}

	public DateTime getDateJe() {
		return this.dateJe;
	}

	public void setDateJe(DateTime dateJe) {
		this.dateJe = dateJe;
	}

	public DateTime getDateMeaslesBooster() {
		return this.dateMeaslesBooster;
	}

	public void setDateMeaslesBooster(DateTime dateMeaslesBooster) {
		this.dateMeaslesBooster = dateMeaslesBooster;
	}

	public DateTime getVitA2DateTime() {
		return this.vitA2Date;
	}

	public void setVitA2Date(DateTime vitA2Date) {
		this.vitA2Date = vitA2Date;
	}

	public DateTime getVitA3DateTime() {
		return this.vitA3Date;
	}

	public void setVitA3Date(DateTime vitA3Date) {
		this.vitA3Date = vitA3Date;
	}

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

    public String getUpToDateSixWeeks() {
        return upToDateSixWeeks;
    }

    public void setUpToDateSixWeeks(String upToDateSixWeeks) {
        this.upToDateSixWeeks = upToDateSixWeeks;
    }

   public String getUpToDateTenWeeks() {
        return upToDateTenWeeks;
    }

    public void setUpToDateTenWeeks(String upToDateTenWeeks) {
        this.upToDateTenWeeks = upToDateTenWeeks;
    }

    public String getUpToDate14Weeks() {
        return upToDate14Weeks;
    }

    public void setUpToDate14Weeks(String upToDate14Weeks) {
        this.upToDate14Weeks = upToDate14Weeks;
    }

    public String getUpToDateTwoYear() {
        return upToDateTwoYear;
    }

    public void setUpToDateTwoYear(String upToDateTwoYear) {
        this.upToDateTwoYear = upToDateTwoYear;
    }

    public String getImmunsUpToDateTime() {
        return immunsUpToDate;
    }

    public void setImmunsUpToDate(String immunsUpToDate) {
        this.immunsUpToDate = immunsUpToDate;
    }
}
