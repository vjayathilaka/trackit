package com.myproject.trackit.response;

public class UserLoginResponse {

	private String userId;
	private String userRole;
	
	public UserLoginResponse(String userId, String role) {
		this.userId = userId;
		this.userRole = role;
	}

	public String getUserRole() {
		return userRole;
	}
	
	public void setUserRole(String role) {
		this.userRole = role;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
