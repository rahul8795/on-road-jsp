package com.cognizant.assistant.bean;

public class RequestRejected {

	private int mechanicId ;
	private int customerId;
	private int requestId;
	
	
	public RequestRejected() {
		super();
	}
	public RequestRejected(int mechanicId, int customerId, int requestId) {
		super();
		this.mechanicId = mechanicId;
		this.customerId = customerId;
		this.requestId = requestId;
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
	public void setRequestId(int requestid) {
		this.requestId = requestid;
	}
	
	
}
