package org.motechproject.care.reporting.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.care.reporting.mds.dimension.ChildCase;
import org.motechproject.care.reporting.mds.dimension.Flw;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(name = "aww_update_vaccinations_child_form")
@Unique(members = { "instance_id", "case_id" })
public class AwwUpdateVaccinationsChildForm extends Form {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8030579448441647454L;
	@Field
	@Cascade(persist = true, update = true, delete = false)
	private ChildCase childCase;
	@Field
	@Cascade(persist = true, update = true, delete = false)
	private Flw flw;
	@Field
	private DateTime dateModified;
	@Field
	private DateTime timeStart;
	@Field
	private DateTime timeEnd;
	@Field
	private DateTime creationTime = new DateTime();
	@Field
	private String detailsAvailable;
	@Field
	private String detailsNeeded;
	@Field
	private String addVaccinations;
	@Field
	private DateTime bcgDate;
	@Field
	private DateTime opv0Date;
	@Field
	private DateTime opv1Date;
	@Field
	private DateTime opv2Date;
	@Field
	private DateTime opv3Date;
	@Field
	private DateTime opvBoosterDate;
	@Field
	private DateTime dpt1Date;
	@Field
	private DateTime dpt2Date;
	@Field
	private DateTime dpt3Date;
	@Field
	private DateTime dptBoosterDate;
	@Field
	private DateTime hepB0Date;
	@Field
	private DateTime hepB1Date;
	@Field
	private DateTime hepB2Date;
	@Field
	private DateTime hepB3Date;
	@Field
	private DateTime measlesDate;
	@Field
	private DateTime dateMeaslesBooster;
	@Field
	private DateTime vitA1Date;
	@Field
	private DateTime vitA2Date;
	@Field
	private DateTime vitA3Date;
	@Field
	private DateTime dateJe;
	@Field
	private String upToDate;
	@Field
	private String babyBcg;
	@Field
	private String babyOpv0;
	@Field
	private String babyOpv1;
	@Field
	private String babyOpv2;
	@Field
	private String babyOpv3;
	@Field
	private String babyOpvBooster;
	@Field
	private String babyDpt1;
	@Field
	private String babyDpt2;
	@Field
	private String babyDpt3;
	@Field
	private String babyDptBooster;
	@Field
	private String babyHepB0;
	@Field
	private String babyHepB1;
	@Field
	private String babyHepB2;
	@Field
	private String babyHepB3;
	@Field
	private String babyMeasles;
	@Field
	private String babyMeaslesBooster;
	@Field
	private String babyVita1;
	@Field
	private String babyVita2;
	@Field
	private String babyVita3;
	@Field
	private String babyJe;
	@Field
	private String upToDateSixWeeks;
	@Field
	private String upToDateTenWeeks;
	@Field
	private String upToDate14Weeks;
	@Field
	private String upToDateOneYear;
	@Field
	private String upToDateTwoYear;
	@Field
	private String success;
	@Field
	private String immunsUpToDate;
	@Field
	private String childName;
	@Field
	private DateTime dob;

	public AwwUpdateVaccinationsChildForm() {

	}

	public ChildCase getChildCase() {
		return this.childCase;
	}

	public void setChildCase(ChildCase childCase) {
		this.childCase = childCase;
	}

	public Flw getFlw() {
		return this.flw;
	}

	public void setFlw(Flw flw) {
		this.flw = flw;
	}

	public DateTime getDateModified() {
		return this.dateModified;
	}

	public void setDateModified(DateTime dateModified) {
		this.dateModified = dateModified;
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

	public DateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(DateTime creationTime) {
		this.creationTime = creationTime;
	}

	public String getDetailsAvailable() {
		return detailsAvailable;
	}

	public void setDetailsAvailable(String detailsAvailable) {
		this.detailsAvailable = detailsAvailable;
	}

	public String getDetailsNeeded() {
		return detailsNeeded;
	}

	public void setDetailsNeeded(String detailsNeeded) {
		this.detailsNeeded = detailsNeeded;
	}

	public String getAddVaccinations() {
		return addVaccinations;
	}

	public void setAddVaccinations(String addVaccinations) {
		this.addVaccinations = addVaccinations;
	}

	public DateTime getBcgDateTime() {
		return bcgDate;
	}

	public void setBcgDate(DateTime bcgDate) {
		this.bcgDate = bcgDate;
	}

	public DateTime getOpv0DateTime() {
		return opv0Date;
	}

	public void setOpv0Date(DateTime opv0Date) {
		this.opv0Date = opv0Date;
	}

	public DateTime getOpv1DateTime() {
		return opv1Date;
	}

	public void setOpv1Date(DateTime opv1Date) {
		this.opv1Date = opv1Date;
	}

	public DateTime getOpv2DateTime() {
		return opv2Date;
	}

	public void setOpv2Date(DateTime opv2Date) {
		this.opv2Date = opv2Date;
	}

	public DateTime getOpv3DateTime() {
		return opv3Date;
	}

	public void setOpv3Date(DateTime opv3Date) {
		this.opv3Date = opv3Date;
	}

	public DateTime getOpvBoosterDateTime() {
		return opvBoosterDate;
	}

	public void setOpvBoosterDate(DateTime opvBoosterDate) {
		this.opvBoosterDate = opvBoosterDate;
	}

	public DateTime getDpt1DateTime() {
		return dpt1Date;
	}

	public void setDpt1Date(DateTime dpt1Date) {
		this.dpt1Date = dpt1Date;
	}

	public DateTime getDpt2DateTime() {
		return dpt2Date;
	}

	public void setDpt2Date(DateTime dpt2Date) {
		this.dpt2Date = dpt2Date;
	}

	public DateTime getDpt3DateTime() {
		return dpt3Date;
	}

	public void setDpt3Date(DateTime dpt3Date) {
		this.dpt3Date = dpt3Date;
	}

	public DateTime getDptBoosterDateTime() {
		return dptBoosterDate;
	}

	public void setDptBoosterDate(DateTime dptBoosterDate) {
		this.dptBoosterDate = dptBoosterDate;
	}

	public DateTime getHepB0DateTime() {
		return hepB0Date;
	}

	public void setHepB0Date(DateTime hepB0Date) {
		this.hepB0Date = hepB0Date;
	}

	public DateTime getHepB1DateTime() {
		return hepB1Date;
	}

	public void setHepB1Date(DateTime hepB1Date) {
		this.hepB1Date = hepB1Date;
	}

	public DateTime getHepB2DateTime() {
		return hepB2Date;
	}

	public void setHepB2Date(DateTime hepB2Date) {
		this.hepB2Date = hepB2Date;
	}

	public DateTime getHepB3DateTime() {
		return hepB3Date;
	}

	public void setHepB3Date(DateTime hepB3Date) {
		this.hepB3Date = hepB3Date;
	}

	public DateTime getMeaslesDateTime() {
		return measlesDate;
	}

	public void setMeaslesDate(DateTime measlesDate) {
		this.measlesDate = measlesDate;
	}

	public DateTime getDateMeaslesBooster() {
		return dateMeaslesBooster;
	}

	public void setDateMeaslesBooster(DateTime dateMeaslesBooster) {
		this.dateMeaslesBooster = dateMeaslesBooster;
	}

	public DateTime getVitA1DateTime() {
		return vitA1Date;
	}

	public void setVitA1Date(DateTime vitA1Date) {
		this.vitA1Date = vitA1Date;
	}

	public DateTime getVitA2DateTime() {
		return vitA2Date;
	}

	public void setVitA2Date(DateTime vitA2Date) {
		this.vitA2Date = vitA2Date;
	}

	public DateTime getVitA3DateTime() {
		return vitA3Date;
	}

	public void setVitA3Date(DateTime vitA3Date) {
		this.vitA3Date = vitA3Date;
	}

	public DateTime getDateJe() {
		return dateJe;
	}

	public void setDateJe(DateTime dateJe) {
		this.dateJe = dateJe;
	}

	public String getUpToDateTime() {
		return upToDate;
	}

	public void setUpToDate(String upToDate) {
		this.upToDate = upToDate;
	}

	public String getBabyBcg() {
		return babyBcg;
	}

	public void setBabyBcg(String babyBcg) {
		this.babyBcg = babyBcg;
	}

	public String getBabyOpv0() {
		return babyOpv0;
	}

	public void setBabyOpv0(String babyOpv0) {
		this.babyOpv0 = babyOpv0;
	}

	public String getBabyOpv1() {
		return babyOpv1;
	}

	public void setBabyOpv1(String babyOpv1) {
		this.babyOpv1 = babyOpv1;
	}

	public String getBabyOpv2() {
		return babyOpv2;
	}

	public void setBabyOpv2(String babyOpv2) {
		this.babyOpv2 = babyOpv2;
	}

	public String getBabyOpv3() {
		return babyOpv3;
	}

	public void setBabyOpv3(String babyOpv3) {
		this.babyOpv3 = babyOpv3;
	}

	public String getBabyOpvBooster() {
		return babyOpvBooster;
	}

	public void setBabyOpvBooster(String babyOpvBooster) {
		this.babyOpvBooster = babyOpvBooster;
	}

	public String getBabyDpt1() {
		return babyDpt1;
	}

	public void setBabyDpt1(String babyDpt1) {
		this.babyDpt1 = babyDpt1;
	}

	public String getBabyDpt2() {
		return babyDpt2;
	}

	public void setBabyDpt2(String babyDpt2) {
		this.babyDpt2 = babyDpt2;
	}

	public String getBabyDpt3() {
		return babyDpt3;
	}

	public void setBabyDpt3(String babyDpt3) {
		this.babyDpt3 = babyDpt3;
	}

	public String getBabyDptBooster() {
		return babyDptBooster;
	}

	public void setBabyDptBooster(String babyDptBooster) {
		this.babyDptBooster = babyDptBooster;
	}

	public String getBabyHepB0() {
		return babyHepB0;
	}

	public void setBabyHepB0(String babyHepB0) {
		this.babyHepB0 = babyHepB0;
	}

	public String getBabyHepB1() {
		return babyHepB1;
	}

	public void setBabyHepB1(String babyHepB1) {
		this.babyHepB1 = babyHepB1;
	}

	public String getBabyHepB2() {
		return babyHepB2;
	}

	public void setBabyHepB2(String babyHepB2) {
		this.babyHepB2 = babyHepB2;
	}

	public String getBabyHepB3() {
		return babyHepB3;
	}

	public void setBabyHepB3(String babyHepB3) {
		this.babyHepB3 = babyHepB3;
	}

	public String getBabyMeasles() {
		return babyMeasles;
	}

	public void setBabyMeasles(String babyMeasles) {
		this.babyMeasles = babyMeasles;
	}

	public String getBabyMeaslesBooster() {
		return babyMeaslesBooster;
	}

	public void setBabyMeaslesBooster(String babyMeaslesBooster) {
		this.babyMeaslesBooster = babyMeaslesBooster;
	}

	public String getBabyVita1() {
		return babyVita1;
	}

	public void setBabyVita1(String babyVita1) {
		this.babyVita1 = babyVita1;
	}

	public String getBabyVita2() {
		return babyVita2;
	}

	public void setBabyVita2(String babyVita2) {
		this.babyVita2 = babyVita2;
	}

	public String getBabyVita3() {
		return babyVita3;
	}

	public void setBabyVita3(String babyVita3) {
		this.babyVita3 = babyVita3;
	}

	public String getBabyJe() {
		return babyJe;
	}

	public void setBabyJe(String babyJe) {
		this.babyJe = babyJe;
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

	public String getUpToDateOneYear() {
		return upToDateOneYear;
	}

	public void setUpToDateOneYear(String upToDateOneYear) {
		this.upToDateOneYear = upToDateOneYear;
	}

	public String getUpToDateTwoYear() {
		return upToDateTwoYear;
	}

	public void setUpToDateTwoYear(String upToDateTwoYear) {
		this.upToDateTwoYear = upToDateTwoYear;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getImmunsUpToDateTime() {
		return immunsUpToDate;
	}

	public void setImmunsUpToDate(String immunsUpToDate) {
		this.immunsUpToDate = immunsUpToDate;
	}

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	public DateTime getDob() {
		return dob;
	}

	public void setDob(DateTime dob) {
		this.dob = dob;
	}
}
