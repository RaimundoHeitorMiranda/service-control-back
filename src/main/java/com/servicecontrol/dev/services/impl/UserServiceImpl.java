package com.servicecontrol.dev.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicecontrol.dev.models.User;
import com.servicecontrol.dev.repositories.UserRepository;
import com.servicecontrol.dev.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User register(User user) {
		return this.userRepository.save(user);
	}

	@Override
	public User getUser(Long id) {
		return this.userRepository.findById(id).orElseThrow(()->
				new RuntimeException());
	}
	
	@Override
	public User getUserByEmail(String email) {
		return this.userRepository.findUserByEmail(email).orElseThrow(()->
		new RuntimeException());
	}

	@Override
	public List<User> getAllUsers() {
		return this.userRepository.findAll();
	}

	@Override
	public User updade(Long id, User userUpdate) {
		this.userRepository.findById(id).orElseThrow(()->
		new RuntimeException());
		
		userUpdate.setId(id);
		
		return this.userRepository.save(userUpdate);
	}

	@Override
	public void delete(Long id) {
		this.userRepository.deleteById(id);
		
	}	
	
}
