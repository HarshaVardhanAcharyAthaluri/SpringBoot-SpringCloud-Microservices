package com.training.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.orderservice.dao.OrderRepository;
import com.training.orderservice.model.Orders;

@RestController
public class OrderController {

	@Autowired
	OrderRepository or;

	@GetMapping("/orders")
	public List<Orders> getOrders(){
		return (List<Orders>) or.findAll();
	}

	@PostMapping("/order")
	public Orders saveOrder(@RequestBody Orders ordr) {
		return or.save(ordr);
	}
	
	
	
	
	
	
}
