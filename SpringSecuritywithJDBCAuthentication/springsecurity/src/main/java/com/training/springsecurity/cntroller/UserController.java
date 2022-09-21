package com.training.springsecurity.cntroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.springsecurity.dao.UserRepo;
import com.training.springsecurity.dao.Users;

@RestController
public class UserController {
	
	@Autowired
	UserRepo repo;

	@Autowired
	PasswordEncoder encoder;
	
	@PostMapping("/user")
	public Users createUser(@RequestBody Users user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return repo.save(user);
	}
	
	
	
}
