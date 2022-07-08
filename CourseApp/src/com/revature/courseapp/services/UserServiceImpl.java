package com.revature.courseapp.services;

import com.revature.courseapp.data.CourseDAO;
import com.revature.courseapp.data.CoursePostgres;
import com.revature.courseapp.data.FacultyDAO;
import com.revature.courseapp.data.StatusDAO;
import com.revature.courseapp.data.StudentDAO;
import com.revature.courseapp.data.UserDAO;
import com.revature.courseapp.data.UserPostgres;
import com.revature.courseapp.exceptions.UsernameAlreadyExistsException;
import com.revature.courseapp.models.Student;
import com.revature.courseapp.models.User;

public class UserServiceImpl implements UserService {
	private UserDAO userDao = new UserPostgres();
	private CourseDAO courseDao = new CoursePostgres();
	private StatusDAO statusDao;
	private StudentDAO studentDao;
	private FacultyDAO facultDao;
	
	@Override
	public User login(String username, String password) {
		
		User user = userDao.findByUsername(username);
		if(user != null && (password != null && password.equals(user.getPassword()))) {
			return user;
		} else {
			System.out.println("Try again!");
			return null;
		}
	}

	@Override
	public User studentReg(User user) throws UsernameAlreadyExistsException {
		user = userDao.create(user);
		if (user==null) {
			throw new UsernameAlreadyExistsException();
		}
		return user;
	}

	@Override
	public void studentOpenClass() {
		
		
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

}
