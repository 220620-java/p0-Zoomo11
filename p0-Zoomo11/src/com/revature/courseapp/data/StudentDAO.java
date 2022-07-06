package com.revature.courseapp.data;

import com.revature.courseapp.models.Student;

public interface StudentDAO extends DataAccessObject<Student> {

	public Student findByName(String name);
}
