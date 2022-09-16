package com.training.hystrixdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class UserDetails {

	private RestTemplate rt;
	
  public UserDetails() {
	  rt = new RestTemplate();
  }

  @HystrixCommand(fallbackMethod = "myfallback",commandKey = "userdemo")
  @GetMapping("/hello")
  public String greer() {
	  
	  String msg = rt.getForObject("http://localhost:7080/hello", String.class);
	  
	  return msg;
  }

  @HystrixCommand(fallbackMethod = "myfallback",commandKey = "greetdemo")
  @GetMapping("/greet")
  public String greet() {
	  
	  String msg = rt.getForObject("http://localhost:7080/hello", String.class);
	  
	  return msg;
  }
	
  
  public String myfallback() {
	  return "Currently We are Under Maitanance";
  }	
  
  
	
}
