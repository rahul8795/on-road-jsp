package com.cognizant.assistant.bean;

public class Rating {

	private int mechanicId;
	private int customerId;
	private double rating;
	
	public Rating() {
		super();
	}
	public Rating(int mechanicId, int customerId, double rating) {
		super();
		this.mechanicId = mechanicId;
		this.customerId = customerId;
		this.rating = rating;
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
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	
}
