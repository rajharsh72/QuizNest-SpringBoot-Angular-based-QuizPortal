package com.quiznestserver.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.quiznestserver.dao.RoleDao;
import com.quiznestserver.dao.UserDao;
import com.quiznestserver.model.Role;
import com.quiznestserver.model.User;
import com.quiznestserver.model.UserRole;
import com.quiznestserver.service.UserRegisterationService;

@Service
public class UserRegisterationServiceImpl implements UserRegisterationService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public User registerUser(User user) throws Exception {
		
		if(this.userDao.findByEmail(user.getEmail()) != null) {
			System.out.println("User already Exists!!! Try again");
			throw new Exception("User already present");
		}else {
			//Setting the new role
			Role role = new Role();
			role.setRoleId(1L);
			role.setRoleName("USER");
			
			//assigning the role to the user
			UserRole userRole = new UserRole();
			userRole.setUser(user);
			userRole.setRole(role);
			
			Set<UserRole> roles = new HashSet<>();
			roles.add(userRole);
			//save the user roles in the database
			for(UserRole ur: roles) {
				this.roleDao.save(ur.getRole());
			}
			
			//assign the roles to the user
			user.getUserRoles().addAll(roles);
			
			user.setPassword(this.passwordEncoder.encode(user.getPassword()));
			
			//save the user in the database
			User newUser = this.userDao.save(user);
			return newUser;
			
		}
		
	}

}
