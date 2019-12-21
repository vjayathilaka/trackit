package com.myproject.trackit.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.myproject.trackit.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{

	public User findByNameAndPassword(String email, String password);

	public List<User> findByUserRole(String userRole);

//	public User findByEmailAndPassword(String email, String password);
	

}
