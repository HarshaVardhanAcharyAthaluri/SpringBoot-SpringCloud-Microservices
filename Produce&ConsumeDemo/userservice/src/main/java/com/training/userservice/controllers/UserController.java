package com.training.userservice.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.userservice.exceptions.UserNotFound;
import com.training.userservice.model.User;

@RestController
public class UserController {

	List<User> userList = new ArrayList<User>();
	
	public UserController() {
		User u1 = new User(1, "Joe Tribiany", "NY", "joe@some.com","abc123");
		User u2 = new User(2, "Chandler", "NY", "cahndle@some.com","abc123");
		User u3 = new User(3, "Monika", "NY", "mon@some.com","abc123");
		User u4 = new User(4, "Phebe", "NY", "pheb@some.com","abc123");
		User u5 = new User(5, "Ross", "NY", "ross@some.com","abc123");
		User u6 = new User(6, "Rachel", "NY", "rach@some.com","abc123");
		
		userList.add(u1);
		userList.add(u2);
		userList.add(u3);
		userList.add(u4);
		userList.add(u5);
		userList.add(u6);	
	}
	
	

	@GetMapping(value = "/hello",produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> greet() {
		return new ResponseEntity<String>("<h1> Hello Iam UserMicroservice </h1>", HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/greet",consumes =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> greet(@RequestBody String name) {
		return new ResponseEntity<String>("<h1> Hello Iam UserMicroservice " +name +"</h1>", HttpStatus.OK);
	}
	
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers(){
		 HttpHeaders headers = new HttpHeaders();
		 headers.add("usercount", userList.size()+"");
		return new ResponseEntity<List<User>>(userList,headers,HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable int id) {
		User u = userList.stream()
				.filter(user->user.getId()==id)
				.findFirst()
				.orElseThrow(()-> new UserNotFound(id+""));
		
		return new ResponseEntity<User>(u,HttpStatus.OK);
	}
	
	@PostMapping("/saveuser")
	public ResponseEntity<List<User>> saveUser(@RequestBody User u){
		userList.add(u);
		return new ResponseEntity<List<User>>(userList,HttpStatus.CREATED);
	}
	
	@PutMapping("/updateuser/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id,@RequestBody User u) {
		User existingUser = userList.stream().filter(user->user.getId()==id).findFirst()
				.orElseThrow(()->new UserNotFound(id+""));
		
		if(existingUser!=null) {
			if(u.getName()!=null)
				existingUser.setName(u.getName());
			if(u.getAdress()!=null)
				existingUser.setAdress(u.getAdress());
			if(u.getEmail()!=null)
				existingUser.setEmail(u.getEmail());
		}
		return new ResponseEntity<User>(existingUser,HttpStatus.CREATED);
	}
	

	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id) {
		String result = null;
		User u = userList.stream().filter(user->user.getId()==id).findFirst()
				.orElseThrow(()->new UserNotFound(id+""));
		if(u!=null) {
			userList.remove(u);
			result =  "User removed Succfully with id :: "+ id;
		}else {
		result =  " User not found with id ::: "+ id;
		}
		return new ResponseEntity<String>(result,HttpStatus.ACCEPTED);
	}
	
}
