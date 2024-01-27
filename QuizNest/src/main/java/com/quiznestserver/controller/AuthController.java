package com.quiznestserver.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiznestserver.model.JwtRequest;
import com.quiznestserver.model.JwtResponse;
import com.quiznestserver.model.User;
import com.quiznestserver.service.AuthService;
import com.quiznestserver.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/auth")
	public JwtResponse generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		return this.authService.createJwtToken(jwtRequest);
	}
	
	@GetMapping("/current-user")
	public User getCurrentUserName(Principal principal) {
		
		return this.userService.getCurrentUser(principal.getName());
		
	}

}
