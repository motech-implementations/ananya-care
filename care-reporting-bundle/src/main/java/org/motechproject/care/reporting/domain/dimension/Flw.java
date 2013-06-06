package org.motechproject.care.reporting.domain.dimension;

// Generated Jun 4, 2013 4:50:32 PM by Hibernate Tools 3.4.0.CR1

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.motechproject.care.reporting.domain.measure.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Flw generated by hbm2java
 */
@Entity
@Table(name = "flw", uniqueConstraints = @UniqueConstraint(columnNames = "flw_id"))
public class Flw implements java.io.Serializable {

	private int id;
    private String flwId;
	private String defaultPhoneNumber;
	private String email;
	private String firstName;
	private String lastName;
	private String phoneNumbers;
	private String assetId;
	private String awcCode;
	private String imeiNo;
	private String role;
	private String subcentre;
	private String userType;
	private String username;
	private String population;
	private String education;
	private String district;
	private String block;
	private String panchayat;
	private String village;
	private Short age;
    private Set<FlwGroup> flwGroups = new HashSet<>();
	private Set<DeathChildForm> deathChildForms = new HashSet<DeathChildForm>(0);
	private Set<RegistrationMotherForm> registrationMotherForms = new HashSet<RegistrationMotherForm>(
			0);
	private Set<MiForm> miForms = new HashSet<MiForm>(0);
	private Set<MoForm> moForms = new HashSet<MoForm>(0);
	private Set<EbfChildForm> ebfChildForms = new HashSet<EbfChildForm>(0);
	private Set<CfChildForm> cfChildForms = new HashSet<CfChildForm>(0);
	private Set<BpForm> bpForms = new HashSet<BpForm>(0);
	private Set<UiMotherForm> uiMotherForms = new HashSet<UiMotherForm>(0);
	private Set<UiChildForm> uiChildForms = new HashSet<UiChildForm>(0);
	private Set<ReferMotherForm> referMotherForms = new HashSet<ReferMotherForm>(
			0);
	private Set<RegistrationChildForm> registrationChildForms = new HashSet<RegistrationChildForm>(
			0);
	private Set<CloseMotherForm> closeMotherForms = new HashSet<CloseMotherForm>(
			0);
	private Set<CfMotherForm> cfMotherForms = new HashSet<CfMotherForm>(0);
	private Set<AbortForm> abortForms = new HashSet<AbortForm>(0);
	private Set<NewForm> newForms = new HashSet<NewForm>(0);
	private Set<PncChildForm> pncChildForms = new HashSet<PncChildForm>(0);
	private Set<ReferChildForm> referChildForms = new HashSet<ReferChildForm>(0);
	private Set<MotherCase> motherCases = new HashSet<MotherCase>(0);
	private Set<PncMotherForm> pncMotherForms = new HashSet<PncMotherForm>(0);
	private Set<CloseChildForm> closeChildForms = new HashSet<CloseChildForm>(0);
	private Set<DeliveryChildForm> deliveryChildForms = new HashSet<DeliveryChildForm>(
			0);
	private Set<EbfMotherForm> ebfMotherForms = new HashSet<EbfMotherForm>(0);
	private Set<DeliveryMotherForm> deliveryMotherForms = new HashSet<DeliveryMotherForm>(
			0);
	private Set<ChildCase> childCases = new HashSet<ChildCase>(0);
	private Set<DeathMotherForm> deathMotherForms = new HashSet<DeathMotherForm>(
			0);

	public Flw() {
	}

	public Flw(int id) {
		this.id = id;
	}

	public Flw(int id, String flwId,
               String defaultPhoneNumber, String email, String firstName,
               String lastName, String phoneNumbers, String assetId,
               String awcCode, String imeiNo, String role, String subcentre,
               String userType, String username, String population,
               String education, String district, String block, String panchayat, String village, Short age, Set<FlwGroup> flwGroups, Set<DeathChildForm> deathChildForms,
               Set<RegistrationMotherForm> registrationMotherForms,
               Set<MiForm> miForms, Set<MoForm> moForms,
               Set<EbfChildForm> ebfChildForms, Set<CfChildForm> cfChildForms,
               Set<BpForm> bpForms, Set<UiMotherForm> uiMotherForms,
               Set<UiChildForm> uiChildForms,
               Set<ReferMotherForm> referMotherForms,
               Set<RegistrationChildForm> registrationChildForms,
               Set<CloseMotherForm> closeMotherForms,
               Set<CfMotherForm> cfMotherForms, Set<AbortForm> abortForms,
               Set<NewForm> newForms, Set<PncChildForm> pncChildForms,
               Set<ReferChildForm> referChildForms,
               Set<MotherCase> motherCases, Set<PncMotherForm> pncMotherForms,
               Set<CloseChildForm> closeChildForms,
               Set<DeliveryChildForm> deliveryChildForms,
               Set<EbfMotherForm> ebfMotherForms,
               Set<DeliveryMotherForm> deliveryMotherForms,
               Set<ChildCase> childCases, Set<DeathMotherForm> deathMotherForms) {
		this.id = id;
		this.flwId = flwId;
		this.defaultPhoneNumber = defaultPhoneNumber;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumbers = phoneNumbers;
		this.assetId = assetId;
		this.awcCode = awcCode;
		this.imeiNo = imeiNo;
		this.role = role;
		this.subcentre = subcentre;
		this.userType = userType;
		this.username = username;
		this.population = population;
		this.education = education;
        this.district = district;
        this.block = block;
        this.panchayat = panchayat;
        this.village = village;
        this.age = age;
        this.flwGroups = flwGroups;
        this.deathChildForms = deathChildForms;
		this.registrationMotherForms = registrationMotherForms;
		this.miForms = miForms;
		this.moForms = moForms;
		this.ebfChildForms = ebfChildForms;
		this.cfChildForms = cfChildForms;
		this.bpForms = bpForms;
		this.uiMotherForms = uiMotherForms;
		this.uiChildForms = uiChildForms;
		this.referMotherForms = referMotherForms;
		this.registrationChildForms = registrationChildForms;
		this.closeMotherForms = closeMotherForms;
		this.cfMotherForms = cfMotherForms;
		this.abortForms = abortForms;
		this.newForms = newForms;
		this.pncChildForms = pncChildForms;
		this.referChildForms = referChildForms;
		this.motherCases = motherCases;
		this.pncMotherForms = pncMotherForms;
		this.closeChildForms = closeChildForms;
		this.deliveryChildForms = deliveryChildForms;
		this.ebfMotherForms = ebfMotherForms;
		this.deliveryMotherForms = deliveryMotherForms;
		this.childCases = childCases;
		this.deathMotherForms = deathMotherForms;
	}

    public Flw(String flwId,
               String defaultPhoneNumber, String email, String firstName,
               String lastName, String phoneNumbers, String assetId,
               String awcCode, String imeiNo, String role, String subcentre,
               String userType, String username, String population,
               String education, String district, String block, String panchayat, String village, Short age) {
        this.flwId = flwId;
        this.defaultPhoneNumber = defaultPhoneNumber;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumbers = phoneNumbers;
        this.assetId = assetId;
        this.awcCode = awcCode;
        this.imeiNo = imeiNo;
        this.role = role;
        this.subcentre = subcentre;
        this.userType = userType;
        this.username = username;
        this.population = population;
        this.education = education;
        this.district = district;
        this.block = block;
        this.panchayat = panchayat;
        this.village = village;
        this.age = age;
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

    @Column(name = "flw_id", unique = true, length = 36)
	public String getFlwId() {
		return this.flwId;
	}

	public void setFlwId(String flwId) {
		this.flwId = flwId;
	}

	@Column(name = "default_phone_number", length = 20)
	public String getDefaultPhoneNumber() {
		return this.defaultPhoneNumber;
	}

	public void setDefaultPhoneNumber(String defaultPhoneNumber) {
		this.defaultPhoneNumber = defaultPhoneNumber;
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "first_name")
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name")
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "phone_numbers", length = 1000)
	public String getPhoneNumbers() {
		return this.phoneNumbers;
	}

	public void setPhoneNumbers(String phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	@Column(name = "asset_id")
	public String getAssetId() {
		return this.assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	@Column(name = "awc_code")
	public String getAwcCode() {
		return this.awcCode;
	}

	public void setAwcCode(String awcCode) {
		this.awcCode = awcCode;
	}

	@Column(name = "imei_no")
	public String getImeiNo() {
		return this.imeiNo;
	}

	public void setImeiNo(String imeiNo) {
		this.imeiNo = imeiNo;
	}

	@Column(name = "role")
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column(name = "subcentre")
	public String getSubcentre() {
		return this.subcentre;
	}

	public void setSubcentre(String subcentre) {
		this.subcentre = subcentre;
	}

	@Column(name = "user_type")
	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Column(name = "username")
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

    @ManyToMany
    @Cascade(value = {CascadeType.SAVE_UPDATE})
    @JoinTable(name="flw_group_map",
            joinColumns={@JoinColumn(name="flw_id")},
            inverseJoinColumns={@JoinColumn(name="group_id")})
    public Set<FlwGroup> getFlwGroups() {
        return flwGroups;
    }

    public void setFlwGroups(Set<FlwGroup> flwGroups) {
        this.flwGroups = flwGroups;
    }

    @Column(name = "population")
	public String getPopulation() {
		return this.population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	@Column(name = "education")
	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

    @Column(name = "district")
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Column(name = "block")
    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    @Column(name = "panchayat")
    public String getPanchayat() {
        return panchayat;
    }

    public void setPanchayat(String panchayat) {
        this.panchayat = panchayat;
    }

    @Column(name = "village")
    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    @Column(name = "age")
	public Short getAge() {
		return this.age;
	}

	public void setAge(Short age) {
		this.age = age;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "flw")
	public Set<DeathChildForm> getDeathChildForms() {
		return this.deathChildForms;
	}

	public void setDeathChildForms(Set<DeathChildForm> deathChildForms) {
		this.deathChildForms = deathChildForms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "flw")
	public Set<RegistrationMotherForm> getRegistrationMotherForms() {
		return this.registrationMotherForms;
	}

	public void setRegistrationMotherForms(
			Set<RegistrationMotherForm> registrationMotherForms) {
		this.registrationMotherForms = registrationMotherForms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "flw")
	public Set<MiForm> getMiForms() {
		return this.miForms;
	}

	public void setMiForms(Set<MiForm> miForms) {
		this.miForms = miForms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "flw")
	public Set<MoForm> getMoForms() {
		return this.moForms;
	}

	public void setMoForms(Set<MoForm> moForms) {
		this.moForms = moForms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "flw")
	public Set<EbfChildForm> getEbfChildForms() {
		return this.ebfChildForms;
	}

	public void setEbfChildForms(Set<EbfChildForm> ebfChildForms) {
		this.ebfChildForms = ebfChildForms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "flw")
	public Set<CfChildForm> getCfChildForms() {
		return this.cfChildForms;
	}

	public void setCfChildForms(Set<CfChildForm> cfChildForms) {
		this.cfChildForms = cfChildForms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "flw")
	public Set<BpForm> getBpForms() {
		return this.bpForms;
	}

	public void setBpForms(Set<BpForm> bpForms) {
		this.bpForms = bpForms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "flw")
	public Set<UiMotherForm> getUiMotherForms() {
		return this.uiMotherForms;
	}

	public void setUiMotherForms(Set<UiMotherForm> uiMotherForms) {
		this.uiMotherForms = uiMotherForms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "flw")
	public Set<UiChildForm> getUiChildForms() {
		return this.uiChildForms;
	}

	public void setUiChildForms(Set<UiChildForm> uiChildForms) {
		this.uiChildForms = uiChildForms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "flw")
	public Set<ReferMotherForm> getReferMotherForms() {
		return this.referMotherForms;
	}

	public void setReferMotherForms(Set<ReferMotherForm> referMotherForms) {
		this.referMotherForms = referMotherForms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "flw")
	public Set<RegistrationChildForm> getRegistrationChildForms() {
		return this.registrationChildForms;
	}

	public void setRegistrationChildForms(
			Set<RegistrationChildForm> registrationChildForms) {
		this.registrationChildForms = registrationChildForms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "flw")
	public Set<CloseMotherForm> getCloseMotherForms() {
		return this.closeMotherForms;
	}

	public void setCloseMotherForms(Set<CloseMotherForm> closeMotherForms) {
		this.closeMotherForms = closeMotherForms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "flw")
	public Set<CfMotherForm> getCfMotherForms() {
		return this.cfMotherForms;
	}

	public void setCfMotherForms(Set<CfMotherForm> cfMotherForms) {
		this.cfMotherForms = cfMotherForms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "flw")
	public Set<AbortForm> getAbortForms() {
		return this.abortForms;
	}

	public void setAbortForms(Set<AbortForm> abortForms) {
		this.abortForms = abortForms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "flw")
	public Set<NewForm> getNewForms() {
		return this.newForms;
	}

	public void setNewForms(Set<NewForm> newForms) {
		this.newForms = newForms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "flw")
	public Set<PncChildForm> getPncChildForms() {
		return this.pncChildForms;
	}

	public void setPncChildForms(Set<PncChildForm> pncChildForms) {
		this.pncChildForms = pncChildForms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "flw")
	public Set<ReferChildForm> getReferChildForms() {
		return this.referChildForms;
	}

	public void setReferChildForms(Set<ReferChildForm> referChildForms) {
		this.referChildForms = referChildForms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "flw")
	public Set<MotherCase> getMotherCases() {
		return this.motherCases;
	}

	public void setMotherCases(Set<MotherCase> motherCases) {
		this.motherCases = motherCases;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "flw")
	public Set<PncMotherForm> getPncMotherForms() {
		return this.pncMotherForms;
	}

	public void setPncMotherForms(Set<PncMotherForm> pncMotherForms) {
		this.pncMotherForms = pncMotherForms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "flw")
	public Set<CloseChildForm> getCloseChildForms() {
		return this.closeChildForms;
	}

	public void setCloseChildForms(Set<CloseChildForm> closeChildForms) {
		this.closeChildForms = closeChildForms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "flw")
	public Set<DeliveryChildForm> getDeliveryChildForms() {
		return this.deliveryChildForms;
	}

	public void setDeliveryChildForms(Set<DeliveryChildForm> deliveryChildForms) {
		this.deliveryChildForms = deliveryChildForms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "flw")
	public Set<EbfMotherForm> getEbfMotherForms() {
		return this.ebfMotherForms;
	}

	public void setEbfMotherForms(Set<EbfMotherForm> ebfMotherForms) {
		this.ebfMotherForms = ebfMotherForms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "flw")
	public Set<DeliveryMotherForm> getDeliveryMotherForms() {
		return this.deliveryMotherForms;
	}

	public void setDeliveryMotherForms(
			Set<DeliveryMotherForm> deliveryMotherForms) {
		this.deliveryMotherForms = deliveryMotherForms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "flw")
	public Set<ChildCase> getChildCases() {
		return this.childCases;
	}

	public void setChildCases(Set<ChildCase> childCases) {
		this.childCases = childCases;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "flw")
	public Set<DeathMotherForm> getDeathMotherForms() {
		return this.deathMotherForms;
	}

	public void setDeathMotherForms(Set<DeathMotherForm> deathMotherForms) {
		this.deathMotherForms = deathMotherForms;
	}

}
