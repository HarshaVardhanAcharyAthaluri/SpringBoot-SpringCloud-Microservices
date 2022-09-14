package com.training.userservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.training.userservice.dto.CustomerDeatils;
import com.training.userservice.dto.OrderDto;
import com.training.userservice.model.Customer;
import com.training.userservice.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Value("${orderserviceurl}")
	String ordrurl;
	
	@Autowired
	RestTemplate rt;
	
	@GetMapping("/greet")
	public ResponseEntity<String> greetFromOrderService() {
		System.out.println("User Service");
		ResponseEntity<String> msg = rt.getForEntity(ordrurl+"/hello", String.class);
		return msg;
	}
	
	@GetMapping("/customerorders/{customerId}")
	public ResponseEntity<CustomerDeatils> getCustomerOrderDetails(@PathVariable int customerId){
		
		CustomerDeatils custdetails = new CustomerDeatils();
		
		List<OrderDto> orderList = rt.getForObject(ordrurl+"/order/"+customerId, List.class);
		custdetails.setOrders(orderList);
		
		Customer custmr= userService.getUser(customerId);
		if(custdetails!=null) {
			custdetails.setId(customerId);
			custdetails.setName(custmr.getName());
			custdetails.setAdress(custmr.getAdress());
			custdetails.setEmail(custmr.getEmail());
		}
		return new ResponseEntity<CustomerDeatils>(custdetails,HttpStatus.OK);
	} 
	
	
	@GetMapping("/users")
	public ResponseEntity<List<Customer>> getAllUsers(){
		 HttpHeaders headers = new HttpHeaders();
		 headers.add("usercount", userService.getAllUsers().size()+"");
		return new ResponseEntity<List<Customer>>(userService.getAllUsers(),headers,HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<Customer> getUser(@PathVariable int id) {
		return new ResponseEntity<Customer>(userService.getUser(id),HttpStatus.OK);
	}
	
	@GetMapping("/userbyname/{name}")
	public ResponseEntity<Customer> getUserByName(@PathVariable String name) {
		return new ResponseEntity<Customer>(userService.getByName(name),HttpStatus.OK);
	}
	
	@GetMapping("/userbyadress/{addr}")
	public ResponseEntity<List<Customer>> getUserByAdress(@PathVariable String addr) {
		return new ResponseEntity<List<Customer>>(userService.getCustomerByAdress(addr),HttpStatus.OK);
	}
	
	@GetMapping("/user/{PageSize}/{PageNo}")
	public ResponseEntity<List<Customer>> getUserByPage(@PathVariable int PageNo,@PathVariable int PageSize) {
		return new ResponseEntity<List<Customer>>(userService.getCustomerByPage(PageNo, PageSize),HttpStatus.OK);
	}
	
	@GetMapping("/sortedusers")
	public ResponseEntity<List<Customer>> getUserBySortByName() {
		return new ResponseEntity<List<Customer>>(userService.getCustomerBySort(),HttpStatus.OK);
	}
	
	@GetMapping("/sortedusers/{sortProp}")
	public ResponseEntity<List<Customer>> getUserBySort(@PathVariable String sortProp) {
		return new ResponseEntity<List<Customer>>(userService.getCustomerBySort(sortProp),HttpStatus.OK);
	}
	
	
	@PostMapping("/saveuser")
	public ResponseEntity<Customer> saveUser(@RequestBody Customer u){
		return new ResponseEntity<Customer>(userService.saveUser(u),HttpStatus.CREATED);
	}
	
	@PutMapping("/updateuser/{id}")
	public ResponseEntity<Customer> updateUser(@PathVariable int id,@RequestBody Customer u) {
		return new ResponseEntity<Customer>(userService.updateUser(id, u),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id) {
		return new ResponseEntity<String>(userService.deleteUser(id),HttpStatus.ACCEPTED);
	}
	
}
