package com.quiznestserver.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiznestserver.model.Role;
import com.quiznestserver.model.User;
import com.quiznestserver.model.UserRole;
import com.quiznestserver.service.UserRegisterationService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserRegisterationService userRegisterationService;
	
	
	@PostMapping("/register")
	public User registerUser(@RequestBody User user) throws Exception {
		
		
		
		
		return this.userRegisterationService.registerUser(user);
		
		
	}

}
