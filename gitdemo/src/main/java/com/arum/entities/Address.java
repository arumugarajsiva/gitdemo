package com.arum.entities;

import jakarta.persistence.*;

@Entity
@Table(name="ADDRESS")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, name = "ID")
	private long addressID;
	@Column(name="TYPE")
	private String addressType;
	@Column(name="STREET")
	private String street;
	@Column(name="CITY")
	private String city;
	@Column(name="COUNTRY")
	private String country;
	@Column(name="REGION")
	private String region;
	
	
	public Address() {
		
	}
	
	public Address(long addressID, String addressType, String street, String city, String country, String region) {
		super();
		this.addressID = addressID;
		this.addressType = addressType;
		this.street = street;
		this.city = city;
		this.country = country;
		this.region = region;
	}
	public long getAddressID() {
		return addressID;
	}
	public void setAddressID(long addressID) {
		this.addressID = addressID;
	}
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	
}
