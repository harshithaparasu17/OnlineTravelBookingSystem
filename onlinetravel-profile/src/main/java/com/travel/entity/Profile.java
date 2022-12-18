package com.travel.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.Data;

@Data

@Entity
@Table(name = "profiles")

public class Profile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int profileId; 
	private String fullName;
	private long phoneNo;
	private String email;
	private int flatNo;
	private String streetName;
	private String landMark;
	private int pinCode;
	private String city;
	private String state;
	private String country;

	public Profile() {
		super();
		// TODO Auto-generated constructor stub
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

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(int flatNo) {
		this.flatNo = flatNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Profile(int profileId, String fullName, long phoneNo, String email, int flatNo, String streetName,
			String landMark, int pinCode, String city, String state, String country) {
		super();
		this.profileId = profileId;
		this.fullName = fullName;
		this.phoneNo = phoneNo;
		this.email = email;
		this.flatNo = flatNo;
		this.streetName = streetName;
		this.landMark = landMark;
		this.pinCode = pinCode;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", fullName=" + fullName + ", phoneNo=" + phoneNo + ", email="
				+ email + ", flatNo=" + flatNo + ", streetName=" + streetName + ", landMark=" + landMark + ", pinCode="
				+ pinCode + ", city=" + city + ", state=" + state + ", country=" + country + "]";
	}
	
	


}
