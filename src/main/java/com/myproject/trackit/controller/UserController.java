package com.myproject.trackit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.trackit.domain.User;
import com.myproject.trackit.response.UserLoginResponse;
import com.myproject.trackit.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(path="/users")
	public String registerUser(@RequestBody User user) {	
		return userService.registerUser(user);	
	}
	
	@PostMapping(path="/login")
	public UserLoginResponse loginUser(@RequestBody User user) {
		return userService.login(user);
	}
	
	@GetMapping(path="/users/{id}")
	public User getById(@PathVariable Long id) {
		return userService.getById(id);
	}
	
	@GetMapping(path="/users/validateLogin")
	public String validateUser() {
		return "success";
	}

}
