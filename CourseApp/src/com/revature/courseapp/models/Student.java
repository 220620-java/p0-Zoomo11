package com.revature.courseapp.models;

public class Student {

	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	
	
	public Student() {
		this.id = 0;
		this.firstName = "";
		this.lastName = "";
		this.username = "";
		this.email = "";
		//UserType type = UserType.STUDENT;
	}
	
	public Student (String firstName, String lastName, String username, String email) {
		this.id = 0;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		//UserType type = UserType.STUDENT;
	
	}
}
