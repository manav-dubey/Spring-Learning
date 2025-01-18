package com.learn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.model.User;
import com.learn.model.Users;
import com.learn.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/users")
public class UserController {
		
	@Autowired
	UserService userService;
	
	
	
	//hello
	@GetMapping("/hello")
	public String hello(HttpServletRequest request) {	
		return "hello  " + request.getSession().getId();
	}
	
	
	//all Users
	@GetMapping("/")
	public List<User> getAllUsers() {
		return this.userService.getAllUsers();
	}
	
	//single User
	@GetMapping("/{username}")
	public User getUser(@PathVariable String username) {
		return userService.getUser(username);
	}
	
	//add User
	@PostMapping("/")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
}
