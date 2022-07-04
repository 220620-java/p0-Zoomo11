package com.revature.courseapp.models;

public class Faculty {

	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private UserType type;
	
	public Faculty () {
		this.id = 0;
		this.firstName = "";
		this.lastName = "";
		this.username = "";
		this.email = "";
		type = UserType.FACULTY; 
	}
	
	public Faculty (String firstName, String lastName, String username, String email) {
		
	}
}
