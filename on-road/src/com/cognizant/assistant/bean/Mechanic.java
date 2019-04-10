package com.cognizant.assistant.bean;



public class Mechanic {
	private String mechanicName;
	private String password;
	private int gender;
	private String dateOfBirth;
	private String contact;
	private String email;
	private Double latitude;
	private Double longitude;
	private int mechanicId;
	
	
	
	public Mechanic() {
		super();
	}
	public Mechanic(String mechanicName, String password, int gender, String dateOfBirth, String contact, String email,
			Double latitude, Double longitude, int mechanicId) {
		super();
		this.mechanicName = mechanicName;
		this.password = password;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.contact = contact;
		this.email = email;
		this.latitude = latitude;
		this.longitude = longitude;
		this.mechanicId = mechanicId;
	}
	public String getMechanicName() {
		return mechanicName;
	}
	public void setMechanicName(String mechanicName) {
		this.mechanicName = mechanicName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public int getMechanicId() {
		return mechanicId;
	}
	public void setMechanicId(int mechanicId) {
		this.mechanicId = mechanicId;
	}
	
	
	
	
}
