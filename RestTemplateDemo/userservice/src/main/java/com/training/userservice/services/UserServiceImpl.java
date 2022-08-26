package com.training.userservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.training.userservice.dao.CustomerRepository;
import com.training.userservice.exceptions.UserNotFound;
import com.training.userservice.model.Customer;



@Service
public class UserServiceImpl implements UserService{

	@Autowired
	CustomerRepository repo;
	
	@Override
	public Customer getByName(String name) {
		return repo.findByName(name);
	}
	
	
	@Override
	public List<Customer> getAllUsers() {
		return (List<Customer>) repo.findAll();
	}

	@Override
	public Customer getUser(int id) {
		Customer u = repo.findById(id).orElseThrow(()-> new UserNotFound(id+""));
		return u;
	}

	@Override
	public Customer saveUser(Customer u) {
		return repo.save(u);
	}

	@Override
	public Customer updateUser(int id, Customer u) {
		Customer existingUser = repo.findById(id).orElseThrow(()-> new UserNotFound(id+""));
		
		if(existingUser!=null) {
			if(u.getName()!=null)
				existingUser.setName(u.getName());
			if(u.getAdress()!=null)
				existingUser.setAdress(u.getAdress());
			if(u.getEmail()!=null)
				existingUser.setEmail(u.getEmail());
		}
		repo.save(existingUser);
		return existingUser;
	}

	@Override
	public String deleteUser(int id) {
		String result = null;
		Customer u = repo.findById(id).orElseThrow(()-> new UserNotFound(id+""));
		if(u!=null) {
			repo.deleteById(id);
			result =  "Customer removed Succfully with id :: "+ id;
		}else {
		result =  " Customer not found with id ::: "+ id;
		}
		return result;
	}


	@Override
	public List<Customer> getCustomerByAdress(String addr) {
		return repo.getcustomersadrerss(addr);
	}


	@Override
	public List<Customer> getCustomerByPage(int pageNo,int pageSize) {
		
		 Pageable pageble = PageRequest.of(pageNo,pageSize);
		 
		 Page<Customer> p = repo.findAll(pageble);

		return p.toList();
	}


	@Override
	public List<Customer> getCustomerBySort(String sortprop) {
		return (List<Customer>) repo.findAll(Sort.by(sortprop).descending());
	}

	@Override
	public List<Customer> getCustomerBySort() {
		return (List<Customer>) repo.findAll(Sort.by("name"));
	}
	

}
