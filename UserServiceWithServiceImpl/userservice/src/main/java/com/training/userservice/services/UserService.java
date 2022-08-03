package com.training.userservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.training.userservice.model.User;

@Service
public interface UserService {

	public List<User> getAllUsers();
	
	public User getUser(int id);
	
	public User saveUser(User u);
	
	public User updateUser( int id, User u);
	
	public String deleteUser(int id);
}
