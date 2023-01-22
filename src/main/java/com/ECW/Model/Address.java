package com.ECW.Model;

public class Address {
	private int addressId;
	private String addressDetails;
	private String city;
	private String state;
	private int zip;
	private Long userId;

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

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", addressDetails=" + addressDetails + ", city=" + city + ", state=" + state + ", zip=" + zip + ", userId=" + userId + "]";
	}

}
