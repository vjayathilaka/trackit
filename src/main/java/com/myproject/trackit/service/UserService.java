package com.myproject.trackit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.trackit.domain.User;
import com.myproject.trackit.repository.UserRepository;
import com.myproject.trackit.response.UserLoginResponse;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public String registerUser(User user) {
		
		User saveUser = userRepository.save(user);
		
		if(saveUser.getId() != null)
			return "Success";
		else 
			return "User registration failed";
	}
	
	public UserLoginResponse login(User user) {
		
		User loginUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
		
		if(loginUser != null && loginUser.getId() != null)
			return new UserLoginResponse("success", user.getUserRole());
		return new UserLoginResponse("Login Failed", null);
	}
	
	public User getById(Long id) {
		return userRepository.findById(id).get();
	}
}
