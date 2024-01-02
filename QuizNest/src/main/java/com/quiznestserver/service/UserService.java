package com.quiznestserver.service;

import java.util.List;

import com.quiznestserver.model.User;

public interface UserService {

	List<User> getAllUsers();

	String deleteUser(String email);

}
