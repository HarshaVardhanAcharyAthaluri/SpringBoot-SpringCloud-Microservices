package com.training.Springwebjsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String greet() {
		return "home";
	}
	
	@RequestMapping(value = "/submitdata",method = RequestMethod.POST)
	public String getUser(String userName,String email,String addr,Model model) {
		model.addAttribute("user", userName);
		model.addAttribute("email", email);
		model.addAttribute("addr", addr);
		return "welcome";
	}
	
}
