package org.motechproject.mcts.care.common.mds.dimension;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.mcts.care.common.domain.SelfUpdatable;
import org.motechproject.mcts.care.common.domain.annotations.ExternalPrimaryKey;
import org.motechproject.mcts.care.common.utils.SelfUpdatableUtil;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity
public class Flw implements java.io.Serializable, SelfUpdatable<Flw> {

	private static final long serialVersionUID = 6447315416364482489L;

	@ExternalPrimaryKey
	@Unique
	private String flwId;
	@Field
	private String defaultPhoneNumber;
	@Field
	private String email;
	@Field
	private String firstName;
	@Field
	private String lastName;
	@Field
	private String phoneNumber1;
	@Field
	private String phoneNumber2;
	@Field
	private String assetId;
	@Field
	private String awcCode;
	@Field
	private String role;
	@Field
	private String subcentre;
	@Field
	private String userType;
	@Field
	private String username;
	@Field
	private String population;
	@Field
	private String education;
	@Field
	private String state;
	@Field
	private String district;
	@Field
	private String block;
	@Field
	private String panchayat;
	@Field
	private String village;
	@Field
	private String ward;
	@Field
	private String caste;
	@Field
	private String ictcordinator;
	@Field
	private String remarks;
	@Field
	private DateTime dob;
	@Field
	private DateTime creationTime;
	@Field
	private DateTime lastModifiedTime;
	
	
	@Persistent(mappedBy="flws")
	private Set<FlwGroup> flwGroups;

	@Field
	private LocationDimension locationDimension;

	@Field
	private String locationCode;

	public Flw() {
		DateTime date = new DateTime();
		creationTime = date;
		lastModifiedTime = date;
		flwGroups = new HashSet<>();
	}

	public Flw(String flwId, String defaultPhoneNumber, String email,
			String firstName, String lastName, String phoneNumber1,
			String phoneNumber2, String assetId, String awcCode, String role,
			String subcentre, String userType, String username,
			String population, String education, String state, String district,
			String block, String panchayat, String village, String ward,
			String caste, String ictcordinator, String remarks, DateTime dob,
			DateTime creationTime, DateTime lastModifiedTime,
			LocationDimension locationDimension) {
		this.flwId = flwId;
		this.defaultPhoneNumber = defaultPhoneNumber;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber1 = phoneNumber1;
		this.phoneNumber2 = phoneNumber2;
		this.assetId = assetId;
		this.awcCode = awcCode;
		this.role = role;
		this.subcentre = subcentre;
		this.userType = userType;
		this.username = username;
		this.population = population;
		this.education = education;
		this.state = state;
		this.district = district;
		this.block = block;
		this.panchayat = panchayat;
		this.village = village;
		this.ward = ward;
		this.caste = caste;
		this.ictcordinator = ictcordinator;
		this.remarks = remarks;
		this.dob = dob;
		this.creationTime = creationTime;
		this.lastModifiedTime = lastModifiedTime;
		this.locationDimension = locationDimension;
	}

	public String getFlwId() {
		return this.flwId;
	}

	public void setFlwId(String flwId) {
		this.flwId = flwId;
	}

	public String getDefaultPhoneNumber() {
		return this.defaultPhoneNumber;
	}

	public void setDefaultPhoneNumber(String defaultPhoneNumber) {
		this.defaultPhoneNumber = defaultPhoneNumber;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber1() {
		return this.phoneNumber1;
	}

	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}

	public String getPhoneNumber2() {
		return this.phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}

	public String getAssetId() {
		return this.assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getAwcCode() {
		return this.awcCode;
	}

	public void setAwcCode(String awcCode) {
		this.awcCode = awcCode;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSubcentre() {
		return this.subcentre;
	}

	public void setSubcentre(String subcentre) {
		this.subcentre = subcentre;
	}

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Field
	public Set<FlwGroup> getFlwGroups() {
		return flwGroups;
	}

	public void setFlwGroups(Set<FlwGroup> flwGroups) {
		this.flwGroups = flwGroups;
	}

	public String getPopulation() {
		return this.population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getPanchayat() {
		return panchayat;
	}

	public void setPanchayat(String panchayat) {
		this.panchayat = panchayat;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public String getIctcordinator() {
		return ictcordinator;
	}

	public void setIctcordinator(String ictcordinator) {
		this.ictcordinator = ictcordinator;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public DateTime getDob() {
		return dob;
	}

	public void setDob(DateTime dob) {
		this.dob = dob;
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
	public void updateToLatest(Flw object) {
		validateIfUpdatable(this.flwId, object.flwId);
		updateFields(object, Arrays.asList("id", "flwId", "creationTime"));
	}

	public Boolean validateIfUpdatable(String thisId, String otherId) {
		return SelfUpdatableUtil.validateIfUpdatable(thisId, otherId,
				this.getClass());
	}

	public void updateFields(Flw source, List<String> ignoredFields) {
		SelfUpdatableUtil.updateFields(source, ignoredFields, this.getClass(),
				this);
	}

	public LocationDimension getLocationDimension() {
		return this.locationDimension;
	}

	public void setLocationDimension(LocationDimension locationDimension) {
		this.locationDimension = locationDimension;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

}
