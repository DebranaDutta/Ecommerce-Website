package com.ECW.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Address {
	@Id
	private int addressId;
	private String addressDetails;
	private String city;
	private String state;
	private int zip;
	private long userId;
	private String contactNo;

	public Address() {
		super();
	}

	public Address(int addressId, String addressDetails, String city, String state, int zip, String contactNo) {
		super();
		this.addressId = addressId;
		this.addressDetails = addressDetails;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.contactNo = contactNo;
	}

	public Address(int addressId, String addressDetails, String city, String state, int zip, long userId, String contactNo) {
		super();
		this.addressId = addressId;
		this.addressDetails = addressDetails;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.userId = userId;
		this.contactNo = contactNo;
	}

	public Address(int addressId, String addressDetails, String city, String state, int zip, Long userId) {
		super();
		this.addressId = addressId;
		this.addressDetails = addressDetails;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.userId = userId;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddressDetails() {
		return addressDetails;
	}

	public void setAddressDetails(String addressDetails) {
		this.addressDetails = addressDetails;
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

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", addressDetails=" + addressDetails + ", city=" + city + ", state=" + state + ", zip=" + zip + ", userId=" + userId
				+ ", contactNo=" + contactNo + "]";
	}

}
