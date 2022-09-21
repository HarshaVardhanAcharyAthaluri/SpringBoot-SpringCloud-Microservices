package com.training.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	public void addViewControllers(ViewControllerRegistry reg) {
		reg.addViewController("/greet").setViewName("greet");
		reg.addViewController("/home").setViewName("home");
		reg.addViewController("/").setViewName("home");
		reg.addViewController("/login").setViewName("login");
	}
	
}
