package org.motechproject.care.reporting.domain.measure;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.motechproject.care.reporting.domain.dimension.ChildCase;
import org.motechproject.care.reporting.domain.dimension.Flw;
import org.motechproject.care.reporting.utils.FormToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "registration_child_form", uniqueConstraints = @UniqueConstraint(columnNames = {"instance_id","case_id"}))
public class RegistrationChildForm extends Form {

	private int id;
	private Flw flw;
	private ChildCase childCase;
	private Date timeEnd;
	private Date timeStart;
	private Date dateModified;
	private String abnormalities;
	private String addVaccinations;
	private String babyBcg;
	private String babyDpt1;
	private String babyDpt2;
	private String babyDpt3;
	private String babyHepB0;
	private String babyHepB1;
	private String babyHepB2;
	private String babyHepB3;
	private String babyMeasles;
	private String babyOpv0;
	private String babyOpv1;
	private String babyOpv2;
	private String babyOpv3;
	private String babyVita1;
	private String caseName;
	private String caseType;
	private Date bcgDate;
	private String birthStatus;
	private Date dob;
	private Date dpt1Date;
	private Date dpt2Date;
	private Date dpt3Date;
	private String gender;
	private Date hepB0Date;
	private Date hepB1Date;
	private Date hepB2Date;
	private Date hepB3Date;
	private Date measlesDate;
	private Date opv0Date;
	private Date opv1Date;
	private Date opv2Date;
	private Date opv3Date;
	private Date vitA1Date;
	private String childHaveAName;
	private String childName;
	private BigDecimal weight;
    private Date creationTime = new Date();

    public RegistrationChildForm() {
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
   @Cascade({	CascadeType.SAVE_UPDATE, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REPLICATE, CascadeType.LOCK, CascadeType.EVICT })
	public Flw getFlw() {
		return this.flw;
	}

	public void setFlw(Flw flw) {
		this.flw = flw;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "case_id")
   @Cascade({	CascadeType.SAVE_UPDATE, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REPLICATE, CascadeType.LOCK, CascadeType.EVICT })
	public ChildCase getChildCase() {
		return this.childCase;
	}

	public void setChildCase(ChildCase childCase) {
		this.childCase = childCase;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time_end")
	public Date getTimeEnd() {
		return this.timeEnd;
	}

	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time_start")
	public Date getTimeStart() {
		return this.timeStart;
	}

	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_modified")
	public Date getDateModified() {
		return this.dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	@Column(name = "abnormalities")
	public String getAbnormalities() {
		return this.abnormalities;
	}

	public void setAbnormalities(String abnormalities) {
		this.abnormalities = abnormalities;
	}

	@Column(name = "add_vaccinations")
	public String getAddVaccinations() {
		return this.addVaccinations;
	}

	public void setAddVaccinations(String addVaccinations) {
		this.addVaccinations = addVaccinations;
	}

	@Column(name = "baby_bcg")
	public String getBabyBcg() {
		return this.babyBcg;
	}

	public void setBabyBcg(String babyBcg) {
		this.babyBcg = babyBcg;
	}

	@Column(name = "baby_dpt1")
	public String getBabyDpt1() {
		return this.babyDpt1;
	}

	public void setBabyDpt1(String babyDpt1) {
		this.babyDpt1 = babyDpt1;
	}

	@Column(name = "baby_dpt2")
	public String getBabyDpt2() {
		return this.babyDpt2;
	}

	public void setBabyDpt2(String babyDpt2) {
		this.babyDpt2 = babyDpt2;
	}

	@Column(name = "baby_dpt3")
	public String getBabyDpt3() {
		return this.babyDpt3;
	}

	public void setBabyDpt3(String babyDpt3) {
		this.babyDpt3 = babyDpt3;
	}

	@Column(name = "baby_hep_b_0")
	public String getBabyHepB0() {
		return this.babyHepB0;
	}

	public void setBabyHepB0(String babyHepB0) {
		this.babyHepB0 = babyHepB0;
	}

	@Column(name = "baby_hep_b_1")
	public String getBabyHepB1() {
		return this.babyHepB1;
	}

	public void setBabyHepB1(String babyHepB1) {
		this.babyHepB1 = babyHepB1;
	}

	@Column(name = "baby_hep_b_2")
	public String getBabyHepB2() {
		return this.babyHepB2;
	}

	public void setBabyHepB2(String babyHepB2) {
		this.babyHepB2 = babyHepB2;
	}

	@Column(name = "baby_hep_b_3")
	public String getBabyHepB3() {
		return this.babyHepB3;
	}

	public void setBabyHepB3(String babyHepB3) {
		this.babyHepB3 = babyHepB3;
	}

	@Column(name = "baby_measles")
	public String getBabyMeasles() {
		return this.babyMeasles;
	}

	public void setBabyMeasles(String babyMeasles) {
		this.babyMeasles = babyMeasles;
	}

	@Column(name = "baby_opv0")
	public String getBabyOpv0() {
		return this.babyOpv0;
	}

	public void setBabyOpv0(String babyOpv0) {
		this.babyOpv0 = babyOpv0;
	}

	@Column(name = "baby_opv1")
	public String getBabyOpv1() {
		return this.babyOpv1;
	}

	public void setBabyOpv1(String babyOpv1) {
		this.babyOpv1 = babyOpv1;
	}

	@Column(name = "baby_opv2")
	public String getBabyOpv2() {
		return this.babyOpv2;
	}

	public void setBabyOpv2(String babyOpv2) {
		this.babyOpv2 = babyOpv2;
	}

	@Column(name = "baby_opv3")
	public String getBabyOpv3() {
		return this.babyOpv3;
	}

	public void setBabyOpv3(String babyOpv3) {
		this.babyOpv3 = babyOpv3;
	}

	@Column(name = "baby_vita1")
	public String getBabyVita1() {
		return this.babyVita1;
	}

	public void setBabyVita1(String babyVita1) {
		this.babyVita1 = babyVita1;
	}

	@Column(name = "case_name")
	public String getCaseName() {
		return this.caseName;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}

	@Column(name = "case_type")
	public String getCaseType() {
		return this.caseType;
	}

	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "bcg_date")
	public Date getBcgDate() {
		return this.bcgDate;
	}

	public void setBcgDate(Date bcgDate) {
		this.bcgDate = bcgDate;
	}

	@Column(name = "birth_status")
	public String getBirthStatus() {
		return this.birthStatus;
	}

	public void setBirthStatus(String birthStatus) {
		this.birthStatus = birthStatus;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dob")
	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dpt_1_date")
	public Date getDpt1Date() {
		return this.dpt1Date;
	}

	public void setDpt1Date(Date dpt1Date) {
		this.dpt1Date = dpt1Date;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dpt_2_date")
	public Date getDpt2Date() {
		return this.dpt2Date;
	}

	public void setDpt2Date(Date dpt2Date) {
		this.dpt2Date = dpt2Date;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dpt_3_date")
	public Date getDpt3Date() {
		return this.dpt3Date;
	}

	public void setDpt3Date(Date dpt3Date) {
		this.dpt3Date = dpt3Date;
	}

	@Column(name = "gender")
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "hep_b_0_date")
	public Date getHepB0Date() {
		return this.hepB0Date;
	}

	public void setHepB0Date(Date hepB0Date) {
		this.hepB0Date = hepB0Date;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "hep_b_1_date")
	public Date getHepB1Date() {
		return this.hepB1Date;
	}

	public void setHepB1Date(Date hepB1Date) {
		this.hepB1Date = hepB1Date;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "hep_b_2_date")
	public Date getHepB2Date() {
		return this.hepB2Date;
	}

	public void setHepB2Date(Date hepB2Date) {
		this.hepB2Date = hepB2Date;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "hep_b_3_date")
	public Date getHepB3Date() {
		return this.hepB3Date;
	}

	public void setHepB3Date(Date hepB3Date) {
		this.hepB3Date = hepB3Date;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "measles_date")
	public Date getMeaslesDate() {
		return this.measlesDate;
	}

	public void setMeaslesDate(Date measlesDate) {
		this.measlesDate = measlesDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "opv_0_date")
	public Date getOpv0Date() {
		return this.opv0Date;
	}

	public void setOpv0Date(Date opv0Date) {
		this.opv0Date = opv0Date;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "opv_1_date")
	public Date getOpv1Date() {
		return this.opv1Date;
	}

	public void setOpv1Date(Date opv1Date) {
		this.opv1Date = opv1Date;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "opv_2_date")
	public Date getOpv2Date() {
		return this.opv2Date;
	}

	public void setOpv2Date(Date opv2Date) {
		this.opv2Date = opv2Date;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "opv_3_date")
	public Date getOpv3Date() {
		return this.opv3Date;
	}

	public void setOpv3Date(Date opv3Date) {
		this.opv3Date = opv3Date;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "vit_a_1_date")
	public Date getVitA1Date() {
		return this.vitA1Date;
	}

	public void setVitA1Date(Date vitA1Date) {
		this.vitA1Date = vitA1Date;
	}

	@Column(name = "child_have_a_name")
	public String getChildHaveAName() {
		return this.childHaveAName;
	}

	public void setChildHaveAName(String childHaveAName) {
		this.childHaveAName = childHaveAName;
	}

	@Column(name = "child_name")
	public String getChildName() {
		return this.childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	@Column(name = "weight", precision = 131089, scale = 0)
	public BigDecimal getWeight() {
		return this.weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_time")
    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public String toString() {
        return FormToString.toString(this);
    }
}
