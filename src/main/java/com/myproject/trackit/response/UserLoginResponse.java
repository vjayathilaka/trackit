package com.myproject.trackit.response;

public class UserLoginResponse {

	private String userId;
	private String role;
	
	public UserLoginResponse(String userId, String role) {
		this.userId = userId;
		this.role = role;
	}

	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
