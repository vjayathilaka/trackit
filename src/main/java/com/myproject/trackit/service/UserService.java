package com.myproject.trackit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.trackit.domain.User;
import com.myproject.trackit.repository.UserRepository;
import com.myproject.trackit.response.UserLoginResponse;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User registerUserMobail(User user) {
		
		User saveUser = userRepository.save(user);
		
		if(saveUser != null){
			return saveUser;
		} else {
			return new User();
		}
	}

	public User registerUser(User user) {
		
		User saveUser = userRepository.save(user);
		
		return saveUser;
	}
	
	public UserLoginResponse login(User user) {
		
		User loginUser = userRepository.findByNameAndPassword(user.getEmail(), user.getPassword());
		
		if(loginUser != null && loginUser.getId() != null)
			return new UserLoginResponse("success", loginUser.getUserRole());
		return new UserLoginResponse("Login Failed", null);
	}
	
	public User getById(Long id) {
		return userRepository.findById(id).get();
	}

	public List<User> getUsersByUserRole(String userRole) {
		return userRepository.findByUserRole(userRole);
		
	}

	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}
	
	//my creation
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}
}
