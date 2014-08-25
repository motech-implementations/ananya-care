package org.motechproject.care.reporting.mds.dimension;

import java.util.Arrays;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.care.reporting.domain.SelfUpdatable;
import org.motechproject.care.reporting.domain.annotations.ExternalPrimaryKey;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Entity(name = "mother_case")
public class MotherCase/* extends SelfUpdatable<MotherCase> */implements java.io.Serializable {

	private static final Logger logger = LoggerFactory.getLogger("commcare-reporting-mapper");

    @Field
    @Cascade(persist = true, update = true, delete = true)
    private Flw flw;
    
    @Field
    @Cascade(persist = true, update = true, delete = true)
	private FlwGroup flwGroup;
    
    @ExternalPrimaryKey
	@Field
	@Unique
	private String caseId;
    
	@Field
	private String caseName;

	@Field
	private String caseType;

	@Field
	private DateTime DateTimeModified;

	@Field
	private DateTime serverDateTimeModified;

    @Field
    private Integer familyNumber;
	@Field
	private Integer hhNumber;
	@Field
	private String husbandName;
    @Field
	private String lastVisitType;
    @Field
	private String motherAlive;

	@Field
	private DateTime motherDob;
	@Field
	private String motherName;

	@Field
	private DateTime closedOn;

	@Field
	private DateTime add;
	@Field
	private int age;
	@Field
	private String birthPlace;
	@Field
	private String complications;

	@Field
	private DateTime DateTimeNextBp;

	@Field
	private DateTime DateTimeNextCf;

	@Field
	private DateTime DateTimeNextEb;

	@Field
	private DateTime DateTimeNextPnc;
	@Field
	private String eatsMeat;

	@Field
	private DateTime edd;
	@Field
	private String enrolledInKilkari;
	@Field
	private String familyPlanningType;
	@Field
	private int howManyChildren;
	@Field
	private String interestInKilkari;
	@Field
	private String lastPregTt;

	@Field
	private DateTime lmp;
	@Field
	private String mobileNumber;
	@Field
	private int numBoys;

	@Field
	private DateTime DateTimeCf1;

	@Field
	private DateTime DateTimeCf2;

	@Field
	private DateTime DateTimeCf3;

	@Field
	private DateTime DateTimeCf4;

	@Field
	private DateTime DateTimeCf5;

	@Field
	private DateTime DateTimeCf6;

	@Field
	private DateTime DateTimeEb1;

	@Field
	private DateTime DateTimeEb2;

	@Field
	private DateTime DateTimeEb3;

	@Field
	private DateTime DateTimeEb4;

	@Field
	private DateTime DateTimeEb5;

	@Field
	private DateTime DateTimeEb6;
	@Field
	private String allPncOnTime;

	@Field
	private DateTime DateTimePnc1;

	@Field
	private DateTime DateTimePnc2;

	@Field
	private DateTime DateTimePnc3;
	@Field
	private String firstPncTime;
	@Field
	private Integer pnc1DaysLate;
	@Field
	private Integer pnc2DaysLate;
	@Field
	private Integer pnc3DaysLate;

	@Field
	private DateTime ttBoosterDateTime;
	@Field
	private String sba;
	@Field
	private String sbaPhone;
	@Field
	private String accompany;

	@Field
	private DateTime anc1DateTime;	

	@Field
	private DateTime anc2DateTime;	

	@Field
	private DateTime anc3DateTime;	

	@Field
	private DateTime anc4DateTime;
	@Field
	private String cleanCloth;
	@Field
	private String coupleInterested;

	@Field
	private DateTime DateTimeBp1;

	@Field
	private DateTime DateTimeBp2;

	@Field
	private DateTime DateTimeBp3;

	@Field
	private DateTime DateTimeLastVisit;
	@Field
	private String deliveryType;
	@Field
	private int ifaTablets;

	@Field
	private DateTime ifaTablets100;
	@Field
	private String materials;
	@Field
	private String maternalEmergency;
	@Field
	private String maternalEmergencyNumber;
	@Field
	private String phoneVehicle;
	@Field
	private String savingMoney;

	@Field
	private DateTime tt1DateTime;

	@Field
	private DateTime tt2DateTime;
	@Field
	private String vehicle;
	@Field
	private String birthStatus;

	@Field
	private DateTime migrateOutDateTime;
	@Field
	private String migratedStatus;
	@Field
	private String status;
	@Field
	private String term;

	@Field
	private DateTime DateTimeCf7;

	@Field
    private DateTime DateTimeDelFu;

	@Field
    private DateTime DateTimeNextReg;
	@Field
    private String institutional;

	@Field
    private DateTime dob;
	@Field
    private Boolean closed;

    @Field
    private DateTime creationTime;

    @Field
    private DateTime lastModifiedTime;
    @Field
    @Cascade(persist = true, update = true, delete = true)
    private Flw closedBy;
    @Field
    private String mobileNumberWhose;
    @Field
    private Integer bpVisitNum;
    @Field
    private Integer wardNumber;
    @Field
    private Integer ebVisitNum;    
    @Field
    private Integer pncVisitNum;
    @Field
    private Integer cfVisitNum;

    public MotherCase() {
        DateTime DateTime = new DateTime();
        creationTime = DateTime;
        lastModifiedTime = DateTime;
	}

    
	public Flw getFlw() {
		return this.flw;
	}

	public void setFlw(Flw flw) {
		this.flw = flw;
	}

	public FlwGroup getFlwGroup() {
		return this.flwGroup;
	}

	public void setFlwGroup(FlwGroup flwGroup) {
		this.flwGroup = flwGroup;
	}
	
	public String getCaseId() {
		return this.caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getCaseName() {
		return this.caseName;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}

	public String getCaseType() {
		return this.caseType;
	}

	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}

	public DateTime getDateTimeModified() {
		return this.DateTimeModified;
	}

	public void setDateTimeModified(DateTime DateTimeModified) {
		this.DateTimeModified = DateTimeModified;
	}

	public DateTime getServerDateTimeModified() {
		return this.serverDateTimeModified;
	}

	public void setServerDateTimeModified(DateTime serverDateTimeModified) {
		this.serverDateTimeModified = serverDateTimeModified;
	}

	public Integer getFamilyNumber() {
		return this.familyNumber;
	}

	public void setFamilyNumber(Integer familyNumber) {
		this.familyNumber = familyNumber;
	}

	public Integer getHhNumber() {
		return this.hhNumber;
	}

	public void setHhNumber(Integer hhNumber) {
		this.hhNumber = hhNumber;
	}

	public String getHusbandName() {
		return this.husbandName;
	}

	public void setHusbandName(String husbandName) {
		this.husbandName = husbandName;
	}

    public String getLastVisitType() {
        return lastVisitType;
    }

    public void setLastVisitType(String lastVisitType) {
        this.lastVisitType = lastVisitType;
    }

	public String getMotherAlive() {
		return this.motherAlive;
	}

	public void setMotherAlive(String motherAlive) {
		this.motherAlive = motherAlive;
	}

	public DateTime getMotherDob() {
		return this.motherDob;
	}

	public void setMotherDob(DateTime motherDob) {
		this.motherDob = motherDob;
	}

	public String getMotherName() {
		return this.motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public DateTime getClosedOn() {
		return this.closedOn;
	}

	public void setClosedOn(DateTime closedOn) {
		this.closedOn = closedOn;
	}

	public DateTime getAdd() {
		return this.add;
	}

	public void setAdd(DateTime add) {
		this.add = add;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBirthPlace() {
		return this.birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getComplications() {
		return this.complications;
	}

	public void setComplications(String complications) {
		this.complications = complications;
	}

	public DateTime getDateTimeNextBp() {
		return this.DateTimeNextBp;
	}

	public void setDateTimeNextBp(DateTime DateTimeNextBp) {
		this.DateTimeNextBp = DateTimeNextBp;
	}

	public DateTime getDateTimeNextCf() {
		return this.DateTimeNextCf;
	}

	public void setDateTimeNextCf(DateTime DateTimeNextCf) {
		this.DateTimeNextCf = DateTimeNextCf;
	}

	public DateTime getDateTimeNextEb() {
		return this.DateTimeNextEb;
	}

	public void setDateTimeNextEb(DateTime DateTimeNextEb) {
		this.DateTimeNextEb = DateTimeNextEb;
	}

	public DateTime getDateTimeNextPnc() {
		return this.DateTimeNextPnc;
	}

	public void setDateTimeNextPnc(DateTime DateTimeNextPnc) {
		this.DateTimeNextPnc = DateTimeNextPnc;
	}

	public String getEatsMeat() {
		return this.eatsMeat;
	}

	public void setEatsMeat(String eatsMeat) {
		this.eatsMeat = eatsMeat;
	}

	public DateTime getEdd() {
		return this.edd;
	}

	public void setEdd(DateTime edd) {
		this.edd = edd;
	}

	public String getEnrolledInKilkari() {
		return this.enrolledInKilkari;
	}

	public void setEnrolledInKilkari(String enrolledInKilkari) {
		this.enrolledInKilkari = enrolledInKilkari;
	}

	public String getFamilyPlanningType() {
		return this.familyPlanningType;
	}

	public void setFamilyPlanningType(String familyPlanningType) {
		this.familyPlanningType = familyPlanningType;
	}

	public int getHowManyChildren() {
		return this.howManyChildren;
	}

	public void setHowManyChildren(int howManyChildren) {
		this.howManyChildren = howManyChildren;
	}

	public String getInterestInKilkari() {
		return this.interestInKilkari;
	}

	public void setInterestInKilkari(String interestInKilkari) {
		this.interestInKilkari = interestInKilkari;
	}

	public String getLastPregTt() {
		return this.lastPregTt;
	}

	public void setLastPregTt(String lastPregTt) {
		this.lastPregTt = lastPregTt;
	}

	public DateTime getLmp() {
		return this.lmp;
	}

	public void setLmp(DateTime lmp) {
		this.lmp = lmp;
	}

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getNumBoys() {
		return this.numBoys;
	}

	public void setNumBoys(int numBoys) {
		this.numBoys = numBoys;
	}

	public DateTime getDateTimeCf1() {
		return this.DateTimeCf1;
	}

	public void setDateTimeCf1(DateTime DateTimeCf1) {
		this.DateTimeCf1 = DateTimeCf1;
	}

	public DateTime getDateTimeCf2() {
		return this.DateTimeCf2;
	}

	public void setDateTimeCf2(DateTime DateTimeCf2) {
		this.DateTimeCf2 = DateTimeCf2;
	}

	public DateTime getDateTimeCf3() {
		return this.DateTimeCf3;
	}

	public void setDateTimeCf3(DateTime DateTimeCf3) {
		this.DateTimeCf3 = DateTimeCf3;
	}

	public DateTime getDateTimeCf4() {
		return this.DateTimeCf4;
	}

	public void setDateTimeCf4(DateTime DateTimeCf4) {
		this.DateTimeCf4 = DateTimeCf4;
	}

	public DateTime getDateTimeCf5() {
		return this.DateTimeCf5;
	}

	public void setDateTimeCf5(DateTime DateTimeCf5) {
		this.DateTimeCf5 = DateTimeCf5;
	}

	public DateTime getDateTimeCf6() {
		return this.DateTimeCf6;
	}

	public void setDateTimeCf6(DateTime DateTimeCf6) {
		this.DateTimeCf6 = DateTimeCf6;
	}

	public DateTime getDateTimeEb1() {
		return this.DateTimeEb1;
	}

	public void setDateTimeEb1(DateTime DateTimeEb1) {
		this.DateTimeEb1 = DateTimeEb1;
	}

	public DateTime getDateTimeEb2() {
		return this.DateTimeEb2;
	}

	public void setDateTimeEb2(DateTime DateTimeEb2) {
		this.DateTimeEb2 = DateTimeEb2;
	}

	public DateTime getDateTimeEb3() {
		return this.DateTimeEb3;
	}

	public void setDateTimeEb3(DateTime DateTimeEb3) {
		this.DateTimeEb3 = DateTimeEb3;
	}

	public DateTime getDateTimeEb4() {
		return this.DateTimeEb4;
	}

	public void setDateTimeEb4(DateTime DateTimeEb4) {
		this.DateTimeEb4 = DateTimeEb4;
	}

	public DateTime getDateTimeEb5() {
		return this.DateTimeEb5;
	}

	public void setDateTimeEb5(DateTime DateTimeEb5) {
		this.DateTimeEb5 = DateTimeEb5;
	}

	public DateTime getDateTimeEb6() {
		return this.DateTimeEb6;
	}

	public void setDateTimeEb6(DateTime DateTimeEb6) {
		this.DateTimeEb6 = DateTimeEb6;
	}

	public String getAllPncOnTime() {
		return this.allPncOnTime;
	}

	public void setAllPncOnTime(String allPncOnTime) {
		this.allPncOnTime = allPncOnTime;
	}

	public DateTime getDateTimePnc1() {
		return this.DateTimePnc1;
	}

	public void setDateTimePnc1(DateTime DateTimePnc1) {
		this.DateTimePnc1 = DateTimePnc1;
	}

	public DateTime getDateTimePnc2() {
		return this.DateTimePnc2;
	}

	public void setDateTimePnc2(DateTime DateTimePnc2) {
		this.DateTimePnc2 = DateTimePnc2;
	}

	public DateTime getDateTimePnc3() {
		return this.DateTimePnc3;
	}

	public void setDateTimePnc3(DateTime DateTimePnc3) {
		this.DateTimePnc3 = DateTimePnc3;
	}

	public String getFirstPncTime() {
		return this.firstPncTime;
	}

	public void setFirstPncTime(String firstPncTime) {
		this.firstPncTime = firstPncTime;
	}

	public Integer getPnc1DaysLate() {
		return this.pnc1DaysLate;
	}

	public void setPnc1DaysLate(Integer pnc1DaysLate) {
		this.pnc1DaysLate = pnc1DaysLate;
	}

	public Integer getPnc2DaysLate() {
		return this.pnc2DaysLate;
	}

	public void setPnc2DaysLate(Integer pnc2DaysLate) {
		this.pnc2DaysLate = pnc2DaysLate;
	}

	public Integer getPnc3DaysLate() {
		return this.pnc3DaysLate;
	}

	public void setPnc3DaysLate(Integer pnc3DaysLate) {
		this.pnc3DaysLate = pnc3DaysLate;
	}

	public DateTime getTtBoosterDateTime() {
		return this.ttBoosterDateTime;
	}

	public void setTtBoosterDateTime(DateTime ttBoosterDateTime) {
		this.ttBoosterDateTime = ttBoosterDateTime;
	}

	public String getSba() {
		return this.sba;
	}

	public void setSba(String sba) {
		this.sba = sba;
	}

	public String getSbaPhone() {
		return this.sbaPhone;
	}

	public void setSbaPhone(String sbaPhone) {
		this.sbaPhone = sbaPhone;
	}

	public String getAccompany() {
		return this.accompany;
	}

	public void setAccompany(String accompany) {
		this.accompany = accompany;
	}

	public DateTime getAnc1DateTime() {
		return this.anc1DateTime;
	}

	public void setAnc1DateTime(DateTime anc1DateTime) {
		this.anc1DateTime = anc1DateTime;
	}

	public DateTime getAnc2DateTime() {
		return this.anc2DateTime;
	}

	public void setAnc2DateTime(DateTime anc2DateTime) {
		this.anc2DateTime = anc2DateTime;
	}
	
	public DateTime getAnc3DateTime() {
		return this.anc3DateTime;
	}

	public void setAnc3DateTime(DateTime anc3DateTime) {
		this.anc3DateTime = anc3DateTime;
	}

	public DateTime getAnc4DateTime() {
		return this.anc4DateTime;
	}

	public void setAnc4DateTime(DateTime anc4DateTime) {
		this.anc4DateTime = anc4DateTime;
	}

	public String getCleanCloth() {
		return this.cleanCloth;
	}

	public void setCleanCloth(String cleanCloth) {
		this.cleanCloth = cleanCloth;
	}

	public String getCoupleInterested() {
		return this.coupleInterested;
	}

	public void setCoupleInterested(String coupleInterested) {
		this.coupleInterested = coupleInterested;
	}

	public DateTime getDateTimeBp1() {
		return this.DateTimeBp1;
	}

	public void setDateTimeBp1(DateTime DateTimeBp1) {
		this.DateTimeBp1 = DateTimeBp1;
	}

	public DateTime getDateTimeBp2() {
		return this.DateTimeBp2;
	}

	public void setDateTimeBp2(DateTime DateTimeBp2) {
		this.DateTimeBp2 = DateTimeBp2;
	}

	public DateTime getDateTimeBp3() {
		return this.DateTimeBp3;
	}

	public void setDateTimeBp3(DateTime DateTimeBp3) {
		this.DateTimeBp3 = DateTimeBp3;
	}

	public DateTime getDateTimeLastVisit() {
		return this.DateTimeLastVisit;
	}

	public void setDateTimeLastVisit(DateTime DateTimeLastVisit) {
		this.DateTimeLastVisit = DateTimeLastVisit;
	}

	public String getDeliveryType() {
		return this.deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public int getIfaTablets() {
		return this.ifaTablets;
	}

	public void setIfaTablets(int ifaTablets) {
		this.ifaTablets = ifaTablets;
	}

	public DateTime getIfaTablets100() {
		return this.ifaTablets100;
	}

	public void setIfaTablets100(DateTime ifaTablets100) {
		this.ifaTablets100 = ifaTablets100;
	}

	public String getMaterials() {
		return this.materials;
	}

	public void setMaterials(String materials) {
		this.materials = materials;
	}

	public String getMaternalEmergency() {
		return this.maternalEmergency;
	}

	public void setMaternalEmergency(String maternalEmergency) {
		this.maternalEmergency = maternalEmergency;
	}

	public String getMaternalEmergencyNumber() {
		return this.maternalEmergencyNumber;
	}

	public void setMaternalEmergencyNumber(String maternalEmergencyNumber) {
		this.maternalEmergencyNumber = maternalEmergencyNumber;
	}

	public String getPhoneVehicle() {
		return this.phoneVehicle;
	}

	public void setPhoneVehicle(String phoneVehicle) {
		this.phoneVehicle = phoneVehicle;
	}

	public String getSavingMoney() {
		return this.savingMoney;
	}

	public void setSavingMoney(String savingMoney) {
		this.savingMoney = savingMoney;
	}

	public DateTime getTt1DateTime() {
		return this.tt1DateTime;
	}

	public void setTt1DateTime(DateTime tt1DateTime) {
		this.tt1DateTime = tt1DateTime;
	}

	public DateTime getTt2DateTime() {
		return this.tt2DateTime;
	}

	public void setTt2DateTime(DateTime tt2DateTime) {
		this.tt2DateTime = tt2DateTime;
	}

	public String getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	public String getBirthStatus() {
		return this.birthStatus;
	}

	public void setBirthStatus(String birthStatus) {
		this.birthStatus = birthStatus;
	}

	public DateTime getMigrateOutDateTime() {
		return this.migrateOutDateTime;
	}

	public void setMigrateOutDateTime(DateTime migrateOutDateTime) {
		this.migrateOutDateTime = migrateOutDateTime;
	}

	public String getMigratedStatus() {
		return this.migratedStatus;
	}

	public void setMigratedStatus(String migratedStatus) {
		this.migratedStatus = migratedStatus;
	}

	
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTerm() {
		return this.term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public DateTime getDateTimeCf7() {
		return this.DateTimeCf7;
	}

	public void setDateTimeCf7(DateTime DateTimeCf7) {
		this.DateTimeCf7 = DateTimeCf7;
	}

	public DateTime getDateTimeDelFu() {
		return this.DateTimeDelFu;
	}

	public void setDateTimeDelFu(DateTime DateTimeDelFu) {
		this.DateTimeDelFu = DateTimeDelFu;
	}

	public DateTime getDateTimeNextReg() {
		return this.DateTimeNextReg;
	}

	public void setDateTimeNextReg(DateTime DateTimeNextReg) {
		this.DateTimeNextReg = DateTimeNextReg;
	}

	public String getInstitutional() {
		return this.institutional;
	}

	public void setInstitutional(String institutional) {
		this.institutional = institutional;
	}

	public DateTime getDob() {
		return this.dob;
	}

	public void setDob(DateTime dob) {
		this.dob = dob;
	}

	public Boolean getClosed() {
		return this.closed;
	}

	public void setClosed(Boolean closed) {
		this.closed = closed;
	}

    public String getMobileNumberWhose() {
        return this.mobileNumberWhose;
    }

    public void setMobileNumberWhose(String mobileNumberWhose) {
        this.mobileNumberWhose = mobileNumberWhose;
    }
    
    public Integer getWardNumber() {
        return this.wardNumber;
    }

    public void setWardNumber(Integer wardNumber) {
        this.wardNumber = wardNumber;
    }
    
    public Integer getBpVisitNum() {
        return this.bpVisitNum;
    }

    public void setBpVisitNum(Integer bpVisitNum) {
        this.bpVisitNum = bpVisitNum;
    }
    
    public Integer getEbVisitNum() {
        return this.ebVisitNum;
    }

    public void setEbVisitNum(Integer ebVisitNum) {
        this.ebVisitNum = ebVisitNum;
    }

    public Integer getPncVisitNum() {
        return this.pncVisitNum;
    }

    public void setPncVisitNum(Integer pncVisitNum) {
        this.pncVisitNum = pncVisitNum;
    }

    public Integer getCfVisitNum() {
        return this.cfVisitNum;
    }

    public void setCfVisitNum(Integer cfVisitNum) {
        this.cfVisitNum = cfVisitNum;
    }
    
    public DateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(DateTime creationTime) {
        this.creationTime = creationTime;
    }

    public DateTime getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(DateTime lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public Flw getClosedBy() {
        return closedBy;
    }

    public void setClosedBy(Flw closedBy) {
        this.closedBy = closedBy;
    }

   /* @Override
    public void updateToLatest(MotherCase updated) {
        validateIfUpdatable(this.caseId, updated.caseId);

        if (!isLatest(updated)) {
            logger.warn(String.format("Ignoring mother case update with case id: %s since existing server DateTime modified is %s and new server DateTime modified is %s", this.caseId, this.serverDateTimeModified, updated.serverDateTimeModified));
            return;
        }
        updateFields(updated, Arrays.asList("id", "caseId", "creationTime", "closedOn", "closedBy", "closed"));
    }

    @Override
    public void updateLastModifiedTime() {
        this.lastModifiedTime = new DateTime();
    }*/

    private boolean isLatest(MotherCase updatedObject) {
        if (this.serverDateTimeModified == null)
            return true;
        else if (updatedObject.serverDateTimeModified == null)
            return false;
        return this.serverDateTimeModified.compareTo(updatedObject.serverDateTimeModified) <= 0;
    }
}
