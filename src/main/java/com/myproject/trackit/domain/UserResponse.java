package com.myproject.trackit.domain;

public class UserResponse {
    private String userName;
    private String userId;
    
	public UserResponse(String userName, String userId) {
		this.userName = userName;
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
