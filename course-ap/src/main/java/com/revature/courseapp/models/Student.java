package com.revature.courseapp.models;

import java.util.Objects;

public class Student extends User {

	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String password;
	private UserType type;
	
	public Student() {
		super();
		this.id = 0;
		this.firstName = "";
		this.lastName = "";
		this.username = "";
		this.email = "";
		this.password = "";
		type = UserType.STUDENT;
	}
	
	public Student (String firstName, String lastName, String username, String email, String password) {
		super();
		this.id = 0;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
		type = UserType.STUDENT;
	}
	
	public Student (int id, String firstName, String lastName, String username, String email, String password) {
		super();
		this.id = 0;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
		type = UserType.STUDENT;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, id, lastName, password, type, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& type == other.type && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", email=" + email + ", password=" + password + ", type=" + type + "]";
	}

	

	
}
