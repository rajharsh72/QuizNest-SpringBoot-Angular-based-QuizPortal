package com.quiznestserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.quiznestserver.config.JwtUtil;
import com.quiznestserver.dao.UserDao;
import com.quiznestserver.model.JwtRequest;
import com.quiznestserver.model.JwtResponse;
import com.quiznestserver.model.User;
import com.quiznestserver.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetails;
	
	
	@Override
	public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception{
		
		String username = jwtRequest.getEmail();
		String password = jwtRequest.getPassword();
		
		this.authenticate(username, password);
		
		final UserDetails userDetails = this.userDetails.loadUserByUsername(username);
		
		String newGeneratedToken = this.jwtUtil.generateToken(userDetails);
		
		User user = this.userDao.findByEmail(username);
		
		return new JwtResponse(user, newGeneratedToken);
	}
	
	
	private void authenticate(String username, String password) throws Exception{
		try {
			
			this.authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(username, password));
			
			
		}catch(DisabledException e) {
			
			throw new Exception("User is disabled");
		}catch(BadCredentialsException e) {
			
			throw new Exception("Bad credentials from user");
		}
	}
}
