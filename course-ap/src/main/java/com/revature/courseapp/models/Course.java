package com.revature.courseapp.models;

import java.util.Objects;

import com.revature.courseapp.ds.ArrayList;
import com.revature.courseapp.ds.List;

public class Course {
	
	private int id;
	private String name;
	private String description;
	private int capacity;
	private boolean available;
	private List<Student> studentEnrolled;
	
	public Course(String name, String description, int capacity, boolean available) {
		this.id = 0;
		this.name = "";
		this.description = "";
		this.capacity = 0;
		this.available = available;
		this.studentEnrolled = new ArrayList<>();
	}
	
	public Course(int id, String name, String description, int capacity, boolean available) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.capacity = capacity;
		this.available = available;
		this.studentEnrolled = new ArrayList<>();
	}
	
	public Course(int id, String name, String description, int capacity, boolean available, List<Student> students) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.capacity = capacity;
		this.available = available;
		this.studentEnrolled = students;
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

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public List<Student> getStudentEnrolled() {
		return studentEnrolled;
	}

	public void setStudentEnrolled(List<Student> studentEnrolled) {
		this.studentEnrolled = studentEnrolled;
	}


	@Override
	public int hashCode() {
		return Objects.hash(available, capacity, description, id, name, studentEnrolled);
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
		return available == other.available && capacity == other.capacity
				&& Objects.equals(description, other.description) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(studentEnrolled, other.studentEnrolled);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", description=" + description + ", capacity=" + capacity
				+ ", available=" + available + ", studentEnrolled=" + studentEnrolled + "]";
	}
}
