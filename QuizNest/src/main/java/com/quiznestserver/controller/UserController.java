package com.quiznestserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiznestserver.model.User;
import com.quiznestserver.service.UserRegisterationService;
import com.quiznestserver.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserRegisterationService userRegisterationService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public User registerUser(@RequestBody User user) throws Exception {
		return this.userRegisterationService.registerUser(user);
	}
	
	@GetMapping
	public List<User> getAllUser(){
		return this.userService.getAllUsers();
	}
	
	@DeleteMapping
	public String deleteUser(@RequestParam(name="email") String email) {
		return this.userService.deleteUser(email);
	}
}
