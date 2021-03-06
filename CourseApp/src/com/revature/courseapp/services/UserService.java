package com.revature.courseapp.services;

import com.revature.courseapp.exceptions.UsernameAlreadyExistsException;
import com.revature.courseapp.models.Student;
import com.revature.courseapp.models.User;

public interface UserService {

	public User login(String username, String password);
	public User studentReg (User user) throws UsernameAlreadyExistsException;
	public void studentOpenClass();
	public void studentRegClass();
	public void displayEnrolledClass();
	public void studentRemoveClass();
	public void facultyAllclass();
	public void facultyAddClass();
	public void facultyUpdateClass();
	public void facultyRemoveClass();
}
