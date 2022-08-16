package com.training.userservice.dao;

import org.springframework.data.repository.CrudRepository;

import com.training.userservice.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{

}
