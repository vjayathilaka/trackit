package com.myproject.trackit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.trackit.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
