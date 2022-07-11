package com.revature.courseapp.services;

import java.util.Scanner;

import com.revature.courseapp.CourseKiosk;
import com.revature.courseapp.data.CourseDAO;
import com.revature.courseapp.data.CoursePostgres;
import com.revature.courseapp.data.UserDAO;
import com.revature.courseapp.data.UserPostgres;
import com.revature.courseapp.ds.List;
import com.revature.courseapp.exceptions.UsernameAlreadyExistsException;
import com.revature.courseapp.models.Course;
import com.revature.courseapp.models.Faculty;
import com.revature.courseapp.models.Student;
import com.revature.courseapp.models.User;

public class UserServiceImpl implements UserService {
	private UserDAO userDao = new UserPostgres();
	private CourseDAO courseDao = new CoursePostgres();
	
	@Override
	public User login(String username, String password) {
		
		User user = userDao.findByUsername(username);
		if(user != null && (password != null && password.equals(user.getPassword()))) {
			return user;
		} else {
			System.out.println("Wrong input, lets try again!");
			return null;
		}
	}

	@Override
	public void studentOpenClass() {
		List<Course> courses = courseDao.findAll();
		System.out.println("List of Classes");
		System.out.println(courses);
		
		
		
	}

	@Override
	public void studentRegClass() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayEnrolledClass() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void studentRemoveClass() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void facultyAllclass() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void facultyAddClass() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void facultyUpdateClass() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void facultyRemoveClass() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Student studentReg(User user) throws UsernameAlreadyExistsException {
		 //TODO Auto-generated method stub
		user = userDao.create(user);
		if (user == null) {
			throw new UsernameAlreadyExistsException();
		}	
		return (Student) user;
	}

	@Override
	public Faculty facultyReg(User user) throws UsernameAlreadyExistsException {
		user = userDao.create(user);
		if (user == null) {
			throw new UsernameAlreadyExistsException();
		}
		return null;
	}

	@Override
	public Student studentReg() throws UsernameAlreadyExistsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Faculty facultyReg() throws UsernameAlreadyExistsException {
		// TODO Auto-generated method stub
		return null;
	}


}
