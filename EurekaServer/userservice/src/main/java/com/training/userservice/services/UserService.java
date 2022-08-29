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
	
	public Customer getByName(String name);
	
	public List<Customer> getCustomerByAdress(String addr);
	
	public List<Customer> getCustomerByPage(int pageNo,int pageSize);
	
	public List<Customer> getCustomerBySort();
	
	public List<Customer> getCustomerBySort(String sortProp);
}
