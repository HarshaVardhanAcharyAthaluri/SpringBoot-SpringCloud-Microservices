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

import com.training.userservice.model.Customer;
import com.training.userservice.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<List<Customer>> getAllUsers(){
		 HttpHeaders headers = new HttpHeaders();
		 headers.add("usercount", userService.getAllUsers().size()+"");
		return new ResponseEntity<List<Customer>>(userService.getAllUsers(),headers,HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<Customer> getUser(@PathVariable int id) {
		return new ResponseEntity<Customer>(userService.getUser(id),HttpStatus.OK);
	}
	
	@PostMapping("/saveuser")
	public ResponseEntity<Customer> saveUser(@RequestBody Customer u){
		return new ResponseEntity<Customer>(userService.saveUser(u),HttpStatus.CREATED);
	}
	
	@PutMapping("/updateuser/{id}")
	public ResponseEntity<Customer> updateUser(@PathVariable int id,@RequestBody Customer u) {
		return new ResponseEntity<Customer>(userService.updateUser(id, u),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id) {
		return new ResponseEntity<String>(userService.deleteUser(id),HttpStatus.ACCEPTED);
	}
	
}
