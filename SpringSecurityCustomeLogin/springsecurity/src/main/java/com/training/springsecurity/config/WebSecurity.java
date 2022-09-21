package com.training.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurity extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/home","/").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login").permitAll()
		.and()
		.logout().permitAll();
		
	}

	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails userdeatils = User.withDefaultPasswordEncoder()
				.username("harsha")
				.password("123456")
				.roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(userdeatils);
	}
	
}
