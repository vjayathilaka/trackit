package com.myproject.trackit.response;

public class UserLoginResponse {

	private String message;
	private String role;
	private String accessToken;
	
	public UserLoginResponse(String message, String role) {
		this.message = message;
		this.role = role;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getAccessToken() {
		return accessToken;
	}
	
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

}
