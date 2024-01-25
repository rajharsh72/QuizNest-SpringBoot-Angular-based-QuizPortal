package com.quiznestserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiznestserver.model.JwtRequest;
import com.quiznestserver.model.JwtResponse;
import com.quiznestserver.service.AuthService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/auth")
	public JwtResponse generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		return this.authService.createJwtToken(jwtRequest);
	}

}
