package com.home.user.services;

import java.util.List;

import com.home.user.entities.User;

public interface UserService {
	
	User saveUser(User user);
	
	List<User> getAllUsers();
	
	
	User getUser(String userId);
	
	User deleteUser(String userId);
	
	User updateUser(User user);

}
