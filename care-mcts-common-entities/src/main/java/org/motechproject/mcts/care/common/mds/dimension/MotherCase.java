package org.motechproject.mcts.care.common.mds.dimension;

import java.util.Arrays;
import java.util.List;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.mcts.care.common.domain.SelfUpdatable;
import org.motechproject.mcts.care.common.domain.annotations.ExternalPrimaryKey;
import org.motechproject.mcts.care.common.lookup.MCTSPregnantMotherCaseAuthorisedStatus;
import org.motechproject.mcts.care.common.utils.SelfUpdatableUtil;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity(name = "mother_case")
public class MotherCase implements java.io.Serializable,
        SelfUpdatable<MotherCase> {

    private static final long serialVersionUID = 2017951207352639547L;

    private static final Logger LOGGER = LoggerFactory
            .getLogger(MotherCase.class);

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
    private DateTime dateModified;

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
    private DateTime actualDeliveryDate;
    @Field
    private int age;
    @Field
    private String birthPlace;
    @Field
    private String complications;

    @Field
    private DateTime dateNextBp;

    @Field
    private DateTime dateNextCf;

    @Field
    private DateTime dateNextEb;

    @Field
    private DateTime dateNextPnc;
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
    private DateTime dateCf1;

    @Field
    private DateTime dateCf2;

    @Field
    private DateTime dateCf3;

    @Field
    private DateTime dateCf4;

    @Field
    private DateTime dateCf5;

    @Field
    private DateTime dateCf6;

    @Field
    private DateTime dateCf7;

    @Field
    private DateTime dateEb1;

    @Field
    private DateTime dateEb2;

    @Field
    private DateTime dateEb3;

    @Field
    private DateTime dateEb4;

    @Field
    private DateTime dateEb5;

    @Field
    private DateTime dateEb6;
    @Field
    private String allPncOnTime;

    @Field
    private DateTime datePnc1;

    @Field
    private DateTime datePnc2;

    @Field
    private DateTime datePnc3;
    @Field
    private String firstPncTime;
    @Field
    private Integer pnc1DaysLate;
    @Field
    private Integer pnc2DaysLate;
    @Field
    private Integer pnc3DaysLate;

    @Field
    private DateTime ttBoosterDate;
    @Field
    private String sba;
    @Field
    private String sbaPhone;
    @Field
    private String accompany;

    @Field
    private DateTime anc1Date;

    @Field
    private DateTime anc2Date;

    @Field
    private DateTime anc3Date;

    @Field
    private DateTime anc4Date;
    @Field
    private String cleanCloth;
    @Field
    private String coupleInterested;

    @Field
    private DateTime dateBp1;

    @Field
    private DateTime dateBp2;

    @Field
    private DateTime dateBp3;

    @Field
    private DateTime dateLastVisit;
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
    private DateTime tt1Date;

    @Field
    private DateTime tt2Date;
    @Field
    private String vehicle;
    @Field
    private String birthStatus;

    @Field
    private DateTime migrateOutDate;
    @Field
    private String migratedStatus;
    @Field
    private String status;
    @Field
    private String term;
    @Field
    private DateTime dateDelFu;

    @Field
    private DateTime dateNextReg;
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
    @Field
    private String mctsId;
    @Field
    private MCTSPregnantMotherCaseAuthorisedStatus mCTSPregnantMotherCaseAuthorisedStatus;
    @Field
    private String fullMctsId;
    @Field
    private String dateModifiedString;

    public MotherCase() {
        DateTime date = new DateTime();
        creationTime = date;
        lastModifiedTime = date;
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

    public DateTime getDateModified() {
        return this.dateModified;
    }

    public void setDateModified(DateTime dateModified) {
        this.dateModified = dateModified;
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

    public DateTime getActualDeliveryDate() {
        return this.actualDeliveryDate;
    }

    public void setActualDeliveryDate(DateTime actualDeliveryDate) {
        this.actualDeliveryDate = actualDeliveryDate;
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

    public DateTime getDateNextBp() {
        return this.dateNextBp;
    }

    public void setDateNextBp(DateTime dateNextBp) {
        this.dateNextBp = dateNextBp;
    }

    public DateTime getDateNextCf() {
        return this.dateNextCf;
    }

    public void setDateNextCf(DateTime dateNextCf) {
        this.dateNextCf = dateNextCf;
    }

    public DateTime getDateNextEb() {
        return this.dateNextEb;
    }

    public void setDateNextEb(DateTime dateNextEb) {
        this.dateNextEb = dateNextEb;
    }

    public DateTime getDateNextPnc() {
        return this.dateNextPnc;
    }

    public void setDateNextPnc(DateTime dateNextPnc) {
        this.dateNextPnc = dateNextPnc;
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

    public DateTime getDateCf1() {
        return this.dateCf1;
    }

    public void setDateCf1(DateTime dateCf1) {
        this.dateCf1 = dateCf1;
    }

    public DateTime getDateCf2() {
        return this.dateCf2;
    }

    public void setDateCf2(DateTime dateCf2) {
        this.dateCf2 = dateCf2;
    }

    public DateTime getDateCf3() {
        return this.dateCf3;
    }

    public void setDateCf3(DateTime dateCf3) {
        this.dateCf3 = dateCf3;
    }

    public DateTime getDateCf4() {
        return this.dateCf4;
    }

    public void setDateCf4(DateTime dateCf4) {
        this.dateCf4 = dateCf4;
    }

    public DateTime getDateCf5() {
        return this.dateCf5;
    }

    public void setDateCf5(DateTime dateCf5) {
        this.dateCf5 = dateCf5;
    }

    public DateTime getDateCf6() {
        return this.dateCf6;
    }

    public void setDateCf6(DateTime dateCf6) {
        this.dateCf6 = dateCf6;
    }

    public DateTime getDateEb1() {
        return this.dateEb1;
    }

    public void setDateEb1(DateTime dateEb1) {
        this.dateEb1 = dateEb1;
    }

    public DateTime getDateEb2() {
        return this.dateEb2;
    }

    public void setDateEb2(DateTime dateEb2) {
        this.dateEb2 = dateEb2;
    }

    public DateTime getDateEb3() {
        return this.dateEb3;
    }

    public void setDateEb3(DateTime dateEb3) {
        this.dateEb3 = dateEb3;
    }

    public DateTime getDateEb4() {
        return this.dateEb4;
    }

    public void setDateEb4(DateTime dateEb4) {
        this.dateEb4 = dateEb4;
    }

    public DateTime getDateEb5() {
        return this.dateEb5;
    }

    public void setDateEb5(DateTime dateEb5) {
        this.dateEb5 = dateEb5;
    }

    public DateTime getDateEb6() {
        return this.dateEb6;
    }

    public void setDateEb6(DateTime dateEb6) {
        this.dateEb6 = dateEb6;
    }

    public String getAllPncOnTime() {
        return this.allPncOnTime;
    }

    public void setAllPncOnTime(String allPncOnTime) {
        this.allPncOnTime = allPncOnTime;
    }

    public DateTime getDatePnc1() {
        return this.datePnc1;
    }

    public void setDatePnc1(DateTime datePnc1) {
        this.datePnc1 = datePnc1;
    }

    public DateTime getDatePnc2() {
        return this.datePnc2;
    }

    public void setDatePnc2(DateTime datePnc2) {
        this.datePnc2 = datePnc2;
    }

    public DateTime getDatePnc3() {
        return this.datePnc3;
    }

    public void setDatePnc3(DateTime datePnc3) {
        this.datePnc3 = datePnc3;
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
        return this.ttBoosterDate;
    }

    public void setTtBoosterDateTime(DateTime ttBoosterDate) {
        this.ttBoosterDate = ttBoosterDate;
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
    public DateTime getAnc1Date() {
        return this.anc1Date;
    }

    public void setAnc1Date(DateTime anc1Date) {
        this.anc1Date = anc1Date;
    }

    public DateTime getAnc2Date() {
        return this.anc2Date;
    }

    public void setAnc2Date(DateTime anc2Date) {
        this.anc2Date = anc2Date;
    }

    public DateTime getAnc3Date() {
        return this.anc3Date;
    }

    public void setAnc3Date(DateTime anc3Date) {
        this.anc3Date = anc3Date;
    }

    public DateTime getAnc4DateTime() {
        return this.anc4Date;
    }

    public void setAnc4DateTime(DateTime anc4Date) {
        this.anc4Date = anc4Date;
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

    public DateTime getDateBp1() {
        return this.dateBp1;
    }

    public void setDateBp1(DateTime dateBp1) {
        this.dateBp1 = dateBp1;
    }

    public DateTime getDateBp2() {
        return this.dateBp2;
    }

    public void setDateBp2(DateTime dateBp2) {
        this.dateBp2 = dateBp2;
    }

    public DateTime getDateBp3() {
        return this.dateBp3;
    }

    public void setDateBp3(DateTime dateBp3) {
        this.dateBp3 = dateBp3;
    }

    public DateTime getDateLastVisit() {
        return this.dateLastVisit;
    }

    public void setDateLastVisit(DateTime dateLastVisit) {
        this.dateLastVisit = dateLastVisit;
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
        return this.tt1Date;
    }

    public void setTt1DateTime(DateTime tt1Date) {
        this.tt1Date = tt1Date;
    }

    public DateTime getTt2DateTime() {
        return this.tt2Date;
    }

    public void setTt2DateTime(DateTime tt2Date) {
        this.tt2Date = tt2Date;
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
        return this.migrateOutDate;
    }

    public void setMigrateOutDateTime(DateTime migrateOutDate) {
        this.migrateOutDate = migrateOutDate;
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

    public DateTime getDateCf7() {
        return this.dateCf7;
    }

    public void setDateCf7(DateTime dateCf7) {
        this.dateCf7 = dateCf7;
    }

    public DateTime getDateDelFu() {
        return this.dateDelFu;
    }

    public void setDateDelFu(DateTime dateDelFu) {
        this.dateDelFu = dateDelFu;
    }

    public DateTime getDateNextReg() {
        return this.dateNextReg;
    }

    public void setDateNextReg(DateTime dateNextReg) {
        this.dateNextReg = dateNextReg;
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

    public String getMctsId() {
        return mctsId;
    }

    public void setMctsId(String mctsId) {
        this.mctsId = mctsId;
    }

    public MCTSPregnantMotherCaseAuthorisedStatus getmCTSPregnantMotherCaseAuthorisedStatus() {
        return mCTSPregnantMotherCaseAuthorisedStatus;
    }

    public void setmCTSPregnantMotherCaseAuthorisedStatus(
            MCTSPregnantMotherCaseAuthorisedStatus mCTSPregnantMotherCaseAuthorisedStatus) {
        this.mCTSPregnantMotherCaseAuthorisedStatus = mCTSPregnantMotherCaseAuthorisedStatus;
    }

    public String getFullMctsId() {
        return fullMctsId;
    }

    public void setFullMctsId(String fullMctsId) {
        this.fullMctsId = fullMctsId;
    }

    public String getDateModifiedString() {
        return dateModifiedString;
    }

    public void setDateModifiedString(String dateModifiedString) {
        this.dateModifiedString = dateModifiedString;
    }

    public Boolean validateIfUpdatable(String thisId, String otherId) {
        return SelfUpdatableUtil.validateIfUpdatable(thisId, otherId, this
                .getClass());
    }

    public void updateFields(MotherCase source, List<String> ignoredFields) {
        SelfUpdatableUtil.updateFields(source, ignoredFields, this.getClass(),
                this);
    }

    @Override
    public void updateToLatest(MotherCase updated) {
        validateIfUpdatable(this.caseId, updated.caseId);

        if (!isLatest(updated)) {

            LOGGER.warn(String
                    .format("Ignoring mother case update with case id: %s since existing server DateTime modified is %s and new server DateTime modified is %s",
                            this.caseId, this.serverDateTimeModified,
                            updated.serverDateTimeModified));
            return;
        }
        updateFields(updated, Arrays.asList("id", "caseId", "creationTime",
                "closedOn", "closedBy", "closed"));
    }

    private boolean isLatest(MotherCase updatedObject) {
        if (this.serverDateTimeModified == null)
            return true;
        else if (updatedObject.serverDateTimeModified == null)
            return false;
        return this.serverDateTimeModified
                .compareTo(updatedObject.serverDateTimeModified) <= 0;
    }
}
