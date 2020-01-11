package com.myproject.trackit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.trackit.controller.AES;
import com.myproject.trackit.domain.Task;
import com.myproject.trackit.domain.User;
import com.myproject.trackit.repository.TaskRepository;
import com.myproject.trackit.repository.UserRepository;
import com.myproject.trackit.response.UserLoginResponse;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TaskRepository taskRepository;
	
	public User registerUserMobail(User user) {
		
		String password = user.getPassword();
		
		String encriptedPassword = encriptPassword(password);
		
		user.setPassword(encriptedPassword);
		
		User saveUser = userRepository.save(user);
		
		if(saveUser != null){
			return saveUser;
		} else {
			return new User();
		}
	}

	public User registerUser(User user) {
		
		String password = user.getPassword();
		
		String encriptedPassword = encriptPassword(password);
		
		user.setPassword(encriptedPassword);
		
		User saveUser = userRepository.save(user);
		
		return saveUser;
	}
	
	public UserLoginResponse login(User user) {
		
		String password = user.getPassword();
		
		String encriptedPassword = encriptPassword(password);
		
		user.setPassword(encriptedPassword);
		
		User loginUser = userRepository.findByNameAndPassword(user.getName(), user.getPassword());
		
		if(loginUser != null && loginUser.getId() != null) {
//		return new UserLoginResponse("success", loginUser.getUserRole());
			
		return new UserLoginResponse(loginUser.getUserRole(), loginUser.getId());
		}
		else {
		return new UserLoginResponse("Login Failed", null);
		}
	}
	
	
	//
	public User loginAng(User user) {
		
		String password = user.getPassword();
		
		String encriptedPassword = encriptPassword(password);
		
		user.setPassword(encriptedPassword);
		
		User loginUser = userRepository.findByNameAndPassword(user.getName(), user.getPassword());
		
		if(loginUser != null && loginUser.getId() != null)
			return new User(loginUser.getName());
		return new User();
	}
	
	private String encriptPassword(String password) {
		
	    final String secretKey = "ssshhhhhhhhhhh!!!!";
	     
	    String originalPassword = password;
	    
		String encriptedPasswrod = AES.encrypt(originalPassword, secretKey);
//		String decryptedString = AES.decrypt(encriptedPasswrod, secretKey) ;
		
		return encriptedPasswrod;
	}
	
	public User getById(Long id) {
		return userRepository.findById(id).get();
	}

	public List<User> getUsersByUserRole(String userRole) {
		return userRepository.findByUserRole(userRole);
		
	}
	//

	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}
	
	//
	public void deleteUser(Long userId) {
		
		List<Task> tasks = taskRepository.getByAssignee_id(userId);
		
		for (Task task : tasks) {
			task.setAssignee(null);
			taskRepository.save(task);
		}
		
		userRepository.deleteById(userId);
		
	}
	
//	public User getByIdAngular(Long id) {
//		return userRepository.findById(id).get();
//	}
	
	//
	public List<User> getAllUsersAng() {
		return (List<User>) userRepository.findAll();
	}
}
