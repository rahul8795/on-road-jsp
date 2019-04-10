package com.cognizant.assistant.bean;

public class Request {
	private int customerId;
	private String customerName;
	private String contact;
	private String email;
	private String location;
	private double latitude;
	private double longitude;
	private int requestId;	
	private int mechanicId;
	
	
	
	public Request(int mechanicId) {
		super();
		this.mechanicId = mechanicId;
	}
	public Request() {
		super();
	}
	public Request(int customerId, String customerName, String contact, String email, String location, double latitude,
			double longitude, int requestId, int mechanicId) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.contact = contact;
		this.email = email;
		this.location = location;
		this.latitude = latitude;
		this.longitude = longitude;
		this.requestId = requestId;
		this.mechanicId = mechanicId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public int getMechanicId() {
		return mechanicId;
	}
	public void setMechanicId(int mechanicId) {
		this.mechanicId = mechanicId;
	}
	


	
	
	
}
