package com.training.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.orderservice.dao.OrderRepository;
import com.training.orderservice.model.Orders;

@RestController
public class OrderController {

	@Autowired
	OrderRepository or;
	
	
	@GetMapping("/hello")
	public String greet(){
		System.out.println("Order Service");
		return "Hello I'm OrderService";
	}

	
	@GetMapping("/orders")
	public List<Orders> getOrders(){
		return (List<Orders>) or.findAll();
	}

	@GetMapping("/order/{customerId}")
	public List<Orders> getOrdersBycustomerId(@PathVariable int customerId){
		return or.findBycustomerId(customerId);
	}
	
	@PostMapping("/order")
	public Orders saveOrder(@RequestBody Orders ordr) {
		return or.save(ordr);
	}
	
	
	

}
