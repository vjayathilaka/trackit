package com.myproject.trackit.controller;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.trackit.domain.User;
import com.myproject.trackit.domain.UserResponse;
import com.myproject.trackit.response.UserLoginResponse;
import com.myproject.trackit.service.UserService;

@CrossOrigin()
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(path="/users")
	public User registerUserMobail(@RequestBody User user) {	
		return userService.registerUserMobail(user);	
	}
	
	@PostMapping(path="/users/ui/")
	public User registerUser(@RequestBody User user) {	
		return userService.registerUser(user);	
	}
	
	
	@PostMapping(path="/login")
	public UserLoginResponse loginUser(@RequestBody User user) {
		return userService.login(user);
	}
	
	@PostMapping(path="/loginAng")
	public User loginUserAng(@RequestBody User user) {
		return userService.loginAng(user);
	}
	
	@GetMapping(path="/users/{id}")
	public User getById(@PathVariable Long id) {
		return userService.getById(id);
	}
	
	@GetMapping(path="/users/validateLogin")
	public String validateUser() {
		return "success";
	}

	@GetMapping(path="/users/userRole/{role}")
	public List<UserResponse> getUsersByRole(@PathVariable String role) {
		List<User> users = userService.getUsersByUserRole(role);
		
		List<UserResponse> userResponse = users.stream().map(user -> new UserResponse(user.getName(),Long.toString(user.getId())))
			.collect(Collectors.toList());
		
		return userResponse;
	}
//
	@GetMapping(path="/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	//
	@DeleteMapping(path="/users/{id}")
	public Map<String, Boolean> deleteProject(@PathVariable Long id) {
		userService.deleteUser(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	@GetMapping(path="/user/delete/{id}")
	public Integer deleteMobileProject(@PathVariable Long id) {
		userService.deleteUser(id);

		return 1;
	}
	
	
	@GetMapping(path="/users/ang")
	public List<User> getAllUsersAng() {
		return userService.getAllUsersAng();
	}
}
