package org.motechproject.care.reporting.mds.dimension;


import java.util.Arrays;
import java.util.List;

import org.joda.time.DateTime;
import org.motechproject.care.reporting.domain.SelfUpdatable;
import org.motechproject.care.reporting.domain.annotations.ExternalPrimaryKey;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Entity(name = "child_case")
public class ChildCase extends SelfUpdatable<ChildCase> implements java.io.Serializable {

	private static final Logger logger = LoggerFactory.getLogger("commcare-reporting-mapper");
	
	@Field(name = "user_id")
    @Cascade(persist = true, update = true, delete = true)
	private Flw flw;
	//TODO @ManyToOne(fetch = FetchType.EAGER)
	@Field(name = "mother_id")
    @Cascade(persist = true, update = true, delete = true)
	private MotherCase motherCase;
	
	@Field(name = "owner_id")
    @Cascade(persist = true, update = true, delete = true)
	private FlwGroup flwGroup;
	@ExternalPrimaryKey
	@Field(name = "case_id")
    private String caseId;
	@Field(name = "case_name")
	private String caseName;
	@Field(name = "DateTime_modified")
	private DateTime DateTimeModified;
	@Field(name = "server_DateTime_modified")
	private DateTime serverDateTimeModified;
    @Field(name = "case_type")
    private String caseType;
	@Field(name = "baby_measles")
	private String babyMeasles;
	@Field(name = "bcg_DateTime")
	private DateTime bcgDateTime;
	@Field(name = "birth_status")
	private String birthStatus;
	@Field(name = "dob")
	private DateTime dob;
	@Field(name = "dpt_1_DateTime")
	private DateTime dpt1DateTime;
	@Field(name = "dpt_2_DateTime")
	private DateTime dpt2DateTime;
	@Field(name = "dpt_3_DateTime")
	private DateTime dpt3DateTime;
	@Field(name = "gender")
	private String gender;
	@Field(name = "hep_b_0_DateTime")
	private DateTime hepB0DateTime;
	@Field(name = "hep_b_1_DateTime")
	private DateTime hepB1DateTime;
	@Field(name = "hep_b_2_DateTime")
	private DateTime hepB2DateTime;
	@Field(name = "hep_b_3_DateTime")
	private DateTime hepB3DateTime;
	@Field(name = "measles_DateTime")
	private DateTime measlesDateTime;
	@Field(name = "opv_0_DateTime")
	private DateTime opv0DateTime;
	@Field(name = "opv_1_DateTime")
	private DateTime opv1DateTime;
	@Field(name = "opv_2_DateTime")
	private DateTime opv2DateTime;
	@Field(name = "opv_3_DateTime")
	private DateTime opv3DateTime;
	@Field(name = "vit_a_1_DateTime")
	private DateTime vitA1DateTime;
	@Field(name = "child_alive")
	private String childAlive;
	@Field(name = "dpt_booster_DateTime")
	private DateTime dptBoosterDateTime;
	@Field(name = "opv_booster_DateTime")
	private DateTime opvBoosterDateTime;
	@Field(name = "DateTime_je")
	private DateTime DateTimeJe;
	@Field(name = "DateTime_measles_booster")
	private DateTime DateTimeMeaslesBooster;
    @Field(name = "baby_weight")
	private String babyWeight;
	@Field(name = "name")
	private String name;
	@Field(name = "term")
	private String term;
	@Field(name = "time_of_birth")
	private String timeOfBirth;
	@Field(name = "vit_a_2_DateTime")
	private DateTime vitA2DateTime;
	@Field(name = "vit_a_3_DateTime")
	private DateTime vitA3DateTime;
    @Field(name = "cord_fallen")
    private String cordFallen;
	@Field(name = "closed")
	private Boolean closed;
	@Field(name = "closed_on")
	private DateTime closedOn;
    @Field(name = "closed_by")
    @Cascade(persist = true, update = true, delete = true)
    private Flw closedBy;
    @Field(name = "creation_time")
    private DateTime creationTime;
    @Field(name = "last_modified_time")
    private DateTime lastModifiedTime;

    public ChildCase() {
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

	public MotherCase getMotherCase() {
		return this.motherCase;
	}

	public void setMotherCase(MotherCase motherCase) {
		this.motherCase = motherCase;
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

	public String getCaseType() {
		return this.caseType;
	}

	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}

	public String getBabyMeasles() {
		return this.babyMeasles;
	}

	public void setBabyMeasles(String babyMeasles) {
		this.babyMeasles = babyMeasles;
	}

	public DateTime getBcgDateTime() {
		return this.bcgDateTime;
	}

	public void setBcgDateTime(DateTime bcgDateTime) {
		this.bcgDateTime = bcgDateTime;
	}

	public String getBirthStatus() {
		return this.birthStatus;
	}

	public void setBirthStatus(String birthStatus) {
		this.birthStatus = birthStatus;
	}

	public DateTime getDob() {
		return this.dob;
	}

	public void setDob(DateTime dob) {
		this.dob = dob;
	}

	public DateTime getDpt1DateTime() {
		return this.dpt1DateTime;
	}

	public void setDpt1DateTime(DateTime dpt1DateTime) {
		this.dpt1DateTime = dpt1DateTime;
	}

	public DateTime getDpt2DateTime() {
		return this.dpt2DateTime;
	}

	public void setDpt2DateTime(DateTime dpt2DateTime) {
		this.dpt2DateTime = dpt2DateTime;
	}

	public DateTime getDpt3DateTime() {
		return this.dpt3DateTime;
	}

	public void setDpt3DateTime(DateTime dpt3DateTime) {
		this.dpt3DateTime = dpt3DateTime;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public DateTime getHepB0DateTime() {
		return this.hepB0DateTime;
	}

	public void setHepB0DateTime(DateTime hepB0DateTime) {
		this.hepB0DateTime = hepB0DateTime;
	}

	public DateTime getHepB1DateTime() {
		return this.hepB1DateTime;
	}

	public void setHepB1DateTime(DateTime hepB1DateTime) {
		this.hepB1DateTime = hepB1DateTime;
	}

	public DateTime getHepB2DateTime() {
		return this.hepB2DateTime;
	}

	public void setHepB2DateTime(DateTime hepB2DateTime) {
		this.hepB2DateTime = hepB2DateTime;
	}

	public DateTime getHepB3DateTime() {
		return this.hepB3DateTime;
	}

	public void setHepB3DateTime(DateTime hepB3DateTime) {
		this.hepB3DateTime = hepB3DateTime;
	}

	public DateTime getMeaslesDateTime() {
		return this.measlesDateTime;
	}

	public void setMeaslesDateTime(DateTime measlesDateTime) {
		this.measlesDateTime = measlesDateTime;
	}

	public DateTime getOpv0DateTime() {
		return this.opv0DateTime;
	}

	public void setOpv0DateTime(DateTime opv0DateTime) {
		this.opv0DateTime = opv0DateTime;
	}

	public DateTime getOpv1DateTime() {
		return this.opv1DateTime;
	}

	public void setOpv1DateTime(DateTime opv1DateTime) {
		this.opv1DateTime = opv1DateTime;
	}

	public DateTime getOpv2DateTime() {
		return this.opv2DateTime;
	}

	public void setOpv2DateTime(DateTime opv2DateTime) {
		this.opv2DateTime = opv2DateTime;
	}

	public DateTime getOpv3DateTime() {
		return this.opv3DateTime;
	}

	public void setOpv3DateTime(DateTime opv3DateTime) {
		this.opv3DateTime = opv3DateTime;
	}

	public DateTime getVitA1DateTime() {
		return this.vitA1DateTime;
	}

	public void setVitA1DateTime(DateTime vitA1DateTime) {
		this.vitA1DateTime = vitA1DateTime;
	}

	public String getChildAlive() {
		return this.childAlive;
	}

	public void setChildAlive(String childAlive) {
		this.childAlive = childAlive;
	}

	public DateTime getDptBoosterDateTime() {
		return this.dptBoosterDateTime;
	}

	public void setDptBoosterDateTime(DateTime dptBoosterDateTime) {
		this.dptBoosterDateTime = dptBoosterDateTime;
	}

	public DateTime getOpvBoosterDateTime() {
		return this.opvBoosterDateTime;
	}

	public void setOpvBoosterDateTime(DateTime opvBoosterDateTime) {
		this.opvBoosterDateTime = opvBoosterDateTime;
	}

	public DateTime getDateTimeJe() {
		return this.DateTimeJe;
	}

	public void setDateTimeJe(DateTime DateTimeJe) {
		this.DateTimeJe = DateTimeJe;
	}

	public DateTime getDateTimeMeaslesBooster() {
		return this.DateTimeMeaslesBooster;
	}

	public void setDateTimeMeaslesBooster(DateTime DateTimeMeaslesBooster) {
		this.DateTimeMeaslesBooster = DateTimeMeaslesBooster;
	}

    public String getBabyWeight() {
        return babyWeight;
    }

    public void setBabyWeight(String babyWeight) {
        this.babyWeight = babyWeight;
    }

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTerm() {
		return this.term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getTimeOfBirth() {
		return this.timeOfBirth;
	}

	public void setTimeOfBirth(String timeOfBirth) {
		this.timeOfBirth = timeOfBirth;
	}

	public DateTime getVitA2DateTime() {
		return this.vitA2DateTime;
	}

	public void setVitA2DateTime(DateTime vitA2DateTime) {
		this.vitA2DateTime = vitA2DateTime;
	}

	public DateTime getVitA3DateTime() {
		return this.vitA3DateTime;
	}

	public void setVitA3DateTime(DateTime vitA3DateTime) {
		this.vitA3DateTime = vitA3DateTime;
	}

    public String getCordFallen() {
        return cordFallen;
    }

    public void setCordFallen(String cordFallen) {
        this.cordFallen = cordFallen;
    }

	public Boolean getClosed() {
		return this.closed;
	}

	public void setClosed(Boolean closed) {
		this.closed = closed;
	}

	public DateTime getClosedOn() {
		return this.closedOn;
	}

	public void setClosedOn(DateTime closedOn) {
		this.closedOn = closedOn;
	}

    public Flw getClosedBy() {
        return closedBy;
    }

    public void setClosedBy(Flw closedBy) {
        this.closedBy = closedBy;
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

    @Override
    public void updateToLatest(ChildCase updated) {
        validateIfUpdatable(this.caseId, updated.caseId);

        if (!isLatest(updated)) {
            logger.warn(String.format("Ignoring mother case update with case id: %s since current DateTime modified is %s and given DateTime modified is %s", this.caseId, this.DateTimeModified, updated.DateTimeModified));
            return;
        }

        List<String> fieldsToIgnore = Arrays.asList("id", "caseId", "creationTime", "closedOn", "closedBy", "closed");
        updateFields(updated, fieldsToIgnore);
    }

    @Override
    public void updateLastModifiedTime() {
        this.lastModifiedTime = new DateTime();
    }

    private boolean isLatest(ChildCase updatedObject) {
        if (this.serverDateTimeModified == null)
            return true;
        else if (updatedObject.serverDateTimeModified == null)
            return false;
        return this.serverDateTimeModified.compareTo(updatedObject.serverDateTimeModified) <= 0;
    }
}
