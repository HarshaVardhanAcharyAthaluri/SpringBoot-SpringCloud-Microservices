package com.training.userservice.model;

public class User {
	
	private int id;
	private String name;
	private String adress;
	private String email;
	
	public User(int id, String name, String adress, String email) {
		this.id = id;
		this.name = name;
		this.adress = adress;
		this.email = email;
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
