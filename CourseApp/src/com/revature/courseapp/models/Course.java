package com.revature.courseapp.models;

import java.util.Objects;

public class Course {
	
	private int id;
	private String name;
	private String description;
	private int capacity;
	private Status status;
	
	public Course() {
		super();
		this.id = 0;
		this.name = "";
		this.description = "";
		this.capacity = 0;
		this.status = new Status();
	}
	
	public Course(String name, String description, int capacity) {
		super();
		this.id = 0;
		this.name = name;
		this.description = description;
		this.capacity = capacity;
		this.status = new Status();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(capacity, description, id, name, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return capacity == other.capacity && Objects.equals(description, other.description) && id == other.id
				&& Objects.equals(name, other.name) && Objects.equals(status, other.status);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", description=" + description + ", capacity=" + capacity
				+ ", status=" + status + "]";
	}

	public Course getFaculty() {
		// TODO Auto-generated method stub
		return null;
	}
}
