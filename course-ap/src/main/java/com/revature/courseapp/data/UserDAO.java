package com.revature.courseapp.data;

import com.revature.courseapp.models.Faculty;
import com.revature.courseapp.models.Student;
import com.revature.courseapp.models.User;

public interface UserDAO extends DataAccessObject<User> {

	public User findByUsername(String username);
	
	public Student create(Student student);
	
	public Faculty create(Faculty faculty);
	
	
	
	
}
