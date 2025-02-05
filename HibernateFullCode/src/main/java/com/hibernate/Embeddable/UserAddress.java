package com.hibernate.Embeddable;

import jakarta.persistence.Embeddable;

@Embeddable
public class UserAddress {
	private String street;
	
	private String city;
	private  String zipCode;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public UserAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserAddress(String street, String city, String zipCode) {
		super();
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
	}
	@Override
	public String toString() {
		return "UserAddress [street=" + street + ", city=" + city + ", zipCode=" + zipCode + "]";
	} 

	
}
