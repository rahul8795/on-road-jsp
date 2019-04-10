package com.cognizant.assistant.bean;

public class RequestAccept {

	
	private int mechanicId ;
	private int customerId;
	private int requestId;
	private int acceptId;
	private double mechanicLatitude;
	private double mechanicLongitude;
	private double customerlatitude;
	private double customerLongiude;
	
	
	
	public RequestAccept() {
		super();
	}
	public RequestAccept(int mechanicId, int customerId, int requestId, int acceptId, double mechanicLatitude,
			double mechanicLongitude, double customerlatitude, double customerLongiude) {
		super();
		this.mechanicId = mechanicId;
		this.customerId = customerId;
		this.requestId = requestId;
		this.acceptId = acceptId;
		this.mechanicLatitude = mechanicLatitude;
		this.mechanicLongitude = mechanicLongitude;
		this.customerlatitude = customerlatitude;
		this.customerLongiude = customerLongiude;
	}
	public int getMechanicId() {
		return mechanicId;
	}
	public void setMechanicId(int mechanicId) {
		this.mechanicId = mechanicId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public int getAcceptId() {
		return acceptId;
	}
	public void setAcceptId(int acceptId) {
		this.acceptId = acceptId;
	}
	public double getMechanicLatitude() {
		return mechanicLatitude;
	}
	public void setMechanicLatitude(double mechanicLatitude) {
		this.mechanicLatitude = mechanicLatitude;
	}
	public double getMechanicLongitude() {
		return mechanicLongitude;
	}
	public void setMechanicLongitude(double mechanicLongitude) {
		this.mechanicLongitude = mechanicLongitude;
	}
	public double getCustomerlatitude() {
		return customerlatitude;
	}
	public void setCustomerlatitude(double customerlatitude) {
		this.customerlatitude = customerlatitude;
	}
	public double getCustomerLongiude() {
		return customerLongiude;
	}
	public void setCustomerLongiude(double customerLongiude) {
		this.customerLongiude = customerLongiude;
	}
	
	
}
