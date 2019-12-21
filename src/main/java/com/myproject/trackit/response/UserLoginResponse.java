package com.myproject.trackit.response;

public class UserLoginResponse {

//	private String userId;
	//modification
	private Long userId;
	private String userRole;
	
//	private String status;
	
//	public UserLoginResponse(String userId, String role) {
//		this.Id = userId;
//		this.userRole = role;
//	}
	public UserLoginResponse(String role, Long userId){
		this.userId = userId;
		this.userRole = role;
		
	}

	public String getUserRole() {
		return userRole;
	}
	
	public void setUserRole(String role) {
		this.userRole = role;
	}

//	public String getUserId() {
//		return userId;
//	}
//
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}
	//modification
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
