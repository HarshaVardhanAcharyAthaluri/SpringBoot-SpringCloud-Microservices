package com.training.springwebdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetController {

	@RequestMapping("/greet")
	public String greetUser() {
		return "hello";
	}
}

