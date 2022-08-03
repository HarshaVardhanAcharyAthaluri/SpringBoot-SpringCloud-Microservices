package com.training.userservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.userservice.model.User;
import com.training.userservice.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers(){
		 HttpHeaders headers = new HttpHeaders();
		 headers.add("usercount", userService.getAllUsers().size()+"");
		return new ResponseEntity<List<User>>(userService.getAllUsers(),headers,HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable int id) {
		return new ResponseEntity<User>(userService.getUser(id),HttpStatus.OK);
	}
	
	@PostMapping("/saveuser")
	public ResponseEntity<User> saveUser(@RequestBody User u){
		return new ResponseEntity<User>(userService.saveUser(u),HttpStatus.CREATED);
	}
	
	@PutMapping("/updateuser/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id,@RequestBody User u) {
		return new ResponseEntity<User>(userService.updateUser(id, u),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id) {
		return new ResponseEntity<String>(userService.deleteUser(id),HttpStatus.ACCEPTED);
	}
	
}
