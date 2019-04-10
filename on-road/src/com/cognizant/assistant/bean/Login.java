package com.cognizant.assistant.bean;

public class Login {
	private int userId;
	private String password;
	private String type;
	
	public Login() {
		super();
	}
	public Login(int userId, String password, String type) {
		super();
		this.userId = userId;
		this.password = password;
		this.type = type;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
