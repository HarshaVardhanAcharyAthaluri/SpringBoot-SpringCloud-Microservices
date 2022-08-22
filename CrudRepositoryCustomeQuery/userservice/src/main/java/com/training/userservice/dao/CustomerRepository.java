package com.training.userservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.training.userservice.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{
	
	Customer findByName(String name);
	
	
	@Query(value="select * from customer where adress=:addr",nativeQuery = true)
	List<Customer> getcustomersadrerss(String addr);

}
