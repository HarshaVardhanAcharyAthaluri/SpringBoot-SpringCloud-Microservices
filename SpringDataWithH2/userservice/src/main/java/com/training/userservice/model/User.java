package com.training.userservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {
	
	private int id;
	private String name;
	private String adress;
	private String email;
	@JsonIgnore
	private String password;
	
	public User(int id, String name, String adress, String email,String password) {
		this.id = id;
		this.name = name;
		this.adress = adress;
		this.email = email;
		this.password = password;
		
	}
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
