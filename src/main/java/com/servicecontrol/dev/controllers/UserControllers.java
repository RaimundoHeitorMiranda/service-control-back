package com.servicecontrol.dev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicecontrol.dev.models.User;
import com.servicecontrol.dev.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserControllers {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> register(@RequestBody User user){
		return ResponseEntity.ok(this.userService.register(user));
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAll(){
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id){
		return ResponseEntity.ok(this.userService.getUser(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable Long id,@RequestBody User userUpdate){
		return ResponseEntity.ok(this.userService.updade(id, userUpdate));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		this.userService.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
