package com.servicecontrol.dev.services;

import java.util.List;

import com.servicecontrol.dev.models.User;

public interface UserService {

	User register(User user);
	
	User getUser(Long id);
	
//	lack pagination and search
	List<User> getAllUsers();
	
	User updade(Long id,User userUpdate);
	
	void delete(Long id);
	
}
