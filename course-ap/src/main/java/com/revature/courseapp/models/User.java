package com.revature.courseapp.models;

import java.util.Objects;


public class User {

	public enum UserType {
		STUDENT,
		FACULTY
	}
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	private UserType type;
	//private List<Course> courses;
	
	public User() {
		//super();
		this.id = 0;
		this.firstName = "";
		this.lastName = "";
		this.email = "";
		this.username = "";
		this.password = "";
		//this.courses = new ArrayList<>();
	}
	
	public User(String firstName, String lastName, String email, String username, String password) {
		//super();
		this.id = 0;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		//this.courses = new ArrayList<>();
	}

	public User(String firstName, String lastName, String username, String email) {
		// TODO Auto-generated constructor stub
		this.id = 0;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

////	public List<Course> getCourses() {
//		return courses;
//	}

//	public void setCourses(List<Course> courses) {
//		this.courses = courses;
//	}
	
	public UserType getUserType () {
		return type;
	}

//	@Override
//	public String toString() {
//		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
//				+ ", username=" + username + ", password=" + password + ", type=" + type + "]";
//	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", username=" + username + ", password=" + password + "]";
	}
	
	
}
