package com.quiznestserver.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.quiznestserver.dao.RoleDao;
import com.quiznestserver.dao.UserDao;
import com.quiznestserver.model.User;
import com.quiznestserver.model.UserRole;
import com.quiznestserver.service.UserRegisterationService;

public class UserRegisterationServiceImpl implements UserRegisterationService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Override
	public User registerUser(User user, Set<UserRole> userRoles) throws Exception {
		
		User existingUser = this.userDao.findByEmail(user.getEmail());
		if(existingUser != null) {
			System.out.println("User already Exists!!! Try again");
			throw new Exception("User already present");
		}
		return null;
	}

}
