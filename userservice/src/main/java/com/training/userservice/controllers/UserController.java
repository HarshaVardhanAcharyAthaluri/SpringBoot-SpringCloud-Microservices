package com.training.userservice.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.userservice.model.User;

@RestController
public class UserController {

	List<User> userList = new ArrayList<User>();
	
	public UserController() {
		User u1 = new User(1, "Joe Tribiany", "NY", "joe@some.com");
		User u2 = new User(2, "Chandler", "NY", "cahndle@some.com");
		User u3 = new User(3, "Monika", "NY", "mon@some.com");
		User u4 = new User(4, "Phebe", "NY", "pheb@some.com");
		User u5 = new User(5, "Ross", "NY", "ross@some.com");
		User u6 = new User(6, "Rachel", "NY", "rach@some.com");
		
		userList.add(u1);
		userList.add(u2);
		userList.add(u3);
		userList.add(u4);
		userList.add(u5);
		userList.add(u6);	
	}
	
	
	@GetMapping("/hello")
	public String greet() {
		return "Hello Iam UserMicroservice";
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userList;
	}
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable int id) {
		return userList.stream()
				.filter(user->user.getId()==id)
				.findFirst()
				.orElse(null);
	}
	
	@PostMapping("/saveuser")
	public List<User> saveUser(@RequestBody User u){
		userList.add(u);
		return userList;
	}
	
	@PutMapping("/updateuser/{id}")
	public User updateUser(@PathVariable int id,@RequestBody User u) {
		User existingUser = userList.stream().filter(user->user.getId()==id).findFirst().orElse(null);
		
		if(existingUser!=null) {
			if(u.getName()!=null)
				existingUser.setName(u.getName());
			if(u.getAdress()!=null)
				existingUser.setAdress(u.getAdress());
			if(u.getEmail()!=null)
				existingUser.setEmail(u.getEmail());
		}
		return existingUser;
	}
	

	@DeleteMapping("/deleteuser/{id}")
	public String deleteUser(@PathVariable int id) {
		User u = userList.stream().filter(user->user.getId()==id).findFirst().orElse(null);
		if(u!=null) {
			userList.remove(u);
		return "User removed Succfully with id :: "+ id;
		}
		return " User not found with id ::: "+ id;
	}
	
}
