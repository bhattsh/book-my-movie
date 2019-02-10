package com.bookyourticket.profile.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Profile {

	@Id
	private int profileId;
	private String fullName;
	// @UniqueElements
	private String emailId;
	// @UniqueElements
	private String contactNumber;
	private Address address;
	// @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private LocalDate dateOfBirth;
	private String gender;
	private String maritalStatus;
	private static int profileIdGenerator;
	static {
		profileIdGenerator = 100;
	}
	{
		profileId = ++profileIdGenerator;
	}

	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}
	/*
	 * public Profile(int profileId, String fullName, String emailId, String
	 * contactNumber, Address address, LocalDate dateOfBirth, String gender, String
	 * maritalStatus, String photoPhoto) { super(); this.profileId = profileId;
	 * this.fullName = fullName; this.emailId = emailId; this.contactNumber =
	 * contactNumber; this.address = address; this.dateOfBirth = dateOfBirth;
	 * this.gender = gender; this.maritalStatus = maritalStatus; this.photoPhoto =
	 * photoPhoto; }
	 */

	public Profile(String fullName, String emailId, String contactNumber, Address address) {
		super();
		this.fullName = fullName;
		this.emailId = emailId;
		this.contactNumber = contactNumber;
		this.address = address;
	}

	public Profile(int profileId, String fullName, String emailId, String contactNumber, Address address,
			String gender) {
		super();
		this.profileId = profileId;
		this.fullName = fullName;
		this.emailId = emailId;
		this.contactNumber = contactNumber;
		this.address = address;
		this.gender = gender;
	}

	public Profile(int profileId, String fullName, String emailId, String contactNumber, Address address) {
		super();
		this.profileId = profileId;
		this.fullName = fullName;
		this.emailId = emailId;
		this.contactNumber = contactNumber;
		this.address = address;
	}

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public static int getProfileIdGenerator() {
		return profileIdGenerator;
	}

	public static void setProfileIdGenerator(int profileIdGenerator) {
		Profile.profileIdGenerator = profileIdGenerator;
	}

	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", fullName=" + fullName + ", emailId=" + emailId
				+ ", contactNumber=" + contactNumber + ", address=" + address + ", dateOfBirth=" + dateOfBirth
				+ ", gender=" + gender + ", maritalStatus=" + maritalStatus + "]";
	}

	

}
