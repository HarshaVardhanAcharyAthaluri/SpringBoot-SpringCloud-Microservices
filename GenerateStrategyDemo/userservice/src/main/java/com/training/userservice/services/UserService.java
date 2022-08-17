package com.training.userservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.training.userservice.model.Customer;

@Service
public interface UserService {

	public List<Customer> getAllUsers();
	
	public Customer getUser(int id);
	
	public Customer saveUser(Customer u);
	
	public Customer updateUser( int id, Customer u);
	
	public String deleteUser(int id);
}
