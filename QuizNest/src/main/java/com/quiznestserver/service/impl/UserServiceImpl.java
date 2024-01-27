package com.quiznestserver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiznestserver.dao.UserDao;
import com.quiznestserver.model.User;
import com.quiznestserver.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> getAllUsers(){
		if(this.userDao.count() == 0) {
			return null;
		}
		return this.userDao.findAll();
	}
	
	@Override
	public String deleteUser(String email) {
		User user = this.userDao.findByEmail(email);
		if( user !=null) {
			this.userDao.delete(user);
			return "User deleted successfully!!";
		}
		return "No user found!!";
	}
	
	@Override
	public User getCurrentUser(String email) {
		return this.userDao.findByEmail(email);
	}
}
