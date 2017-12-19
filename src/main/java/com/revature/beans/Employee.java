package com.revature.beans;

public class Employee {
	private String firstname;
	private String lastname;
	private int id;
	private String password;
	private String username;
	private int isManager;
	
	
	public Employee(String firstname, String lastname, int id, String username, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.id = id;
		this.password = password;
		this.username = username;
	}
	
	public Employee(String firstname, String lastname,  String username, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.username = username;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getIsManager() {
		return isManager;
	}
	public void setIsManager(int isManager) {
		this.isManager = isManager;
	}
}
