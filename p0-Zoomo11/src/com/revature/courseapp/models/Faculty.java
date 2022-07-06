package com.revature.courseapp.models;

import java.util.Objects;

import com.revature.courseapp.models.User.UserType;

public class Faculty extends User {

	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private UserType type;
	
	public Faculty () {
		super();
		this.id = 0;
		this.firstName = "";
		this.lastName = "";
		this.username = "";
		this.email = "";
		type = UserType.FACULTY; 
	}
	
	public Faculty (String firstName, String lastName, String username, String email) {
		super();
		this.id = 0;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		type = UserType.FACULTY;
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
		return Objects.hash(email, firstName, id, lastName, type, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Faculty other = (Faculty) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(lastName, other.lastName) && type == other.type
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "Faculty [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", email=" + email + ", type=" + type + "]";
	}
	
	
}
