package com.quiznestserver.service;

import com.quiznestserver.model.JwtRequest;
import com.quiznestserver.model.JwtResponse;

public interface AuthService {
	
	JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception;
}
