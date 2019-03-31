package com.servicecontrol.dev.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicecontrol.dev.models.User;
import com.servicecontrol.dev.services.UserService;

@RestController
@RequestMapping("/login")
@CrossOrigin("*")
public class AuthController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> login(@RequestBody User userLogin){
		return ResponseEntity.ok(this.userService.getUserByEmail(userLogin.getEmail()));
	}
	
}
