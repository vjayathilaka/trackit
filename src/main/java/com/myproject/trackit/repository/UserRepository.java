package com.myproject.trackit.repository;

import org.springframework.data.repository.CrudRepository;

import com.myproject.trackit.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{

	public User findByEmailAndPassword(String email, String password);

}
