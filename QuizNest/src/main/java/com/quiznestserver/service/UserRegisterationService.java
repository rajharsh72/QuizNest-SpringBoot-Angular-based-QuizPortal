 package com.quiznestserver.service;

import java.util.Set;

import com.quiznestserver.model.User;

public interface UserRegisterationService {
	
	//assuming that a user can have multiple roles(ONLY FOR GENERIC CASES)
	public User registerUser(User user) throws Exception;
}
