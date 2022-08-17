package com.training.orderservice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.training.orderservice.model.Orders;

@Repository
public interface OrderRepository extends CrudRepository<Orders, Integer>{
	
	

}
