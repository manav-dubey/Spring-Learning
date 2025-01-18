package com.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.model.Users;

public interface UserRepo extends JpaRepository<Users, Integer> {

	Users findByUsername(String username);
	
}
