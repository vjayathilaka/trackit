package com.myproject.trackit.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
//	private Long userId;
	private String name;
	private String email;
	private String userRole;
	private String password;
	
	public User() {}
	
	public User(Long id) {
		this.id = id;
	}
	
	//modification
//	public User(Long userId) {
//		this.userId = userId;
//	}
	
	public User(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long userId) {
		this.id = userId;
	}
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
}
