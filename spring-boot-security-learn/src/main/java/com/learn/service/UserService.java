package com.learn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.learn.model.User;
import com.learn.model.Users;
import com.learn.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;

	@Autowired
	private JWTService jwtService;
	
	@Autowired
	private AuthenticationManager authManager;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

	public Users register(Users user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return repo.save(user);
	}

	public String verify(Users user) {
		Authentication authentication =
				authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		
		if(authentication.isAuthenticated()) {
			return jwtService.generateToken(user.getUsername());
		}
		return "fail";
	}	

	
	//fake database as List
	List<User> list = new ArrayList<>();

	public UserService() {
		list.add(new User("abc", "abc", "ABC@gmail.com"));
		list.add(new User("xyz", "xyz", "XYZ@gmail.com"));
	}

	// get all users
	public List<User> getAllUsers() {
		return this.list;
	}

	// get single user
	public User getUser(String username) {
		return this.list.stream().filter((user) -> user.getUsername().equals(username)).findAny().orElse(null);
	}

	// add User
	public User addUser(User user) {
		this.list.add(user);
		return user;
	}

}
