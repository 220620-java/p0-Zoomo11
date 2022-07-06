package com.revature.courseapp.data;

import com.revature.courseapp.models.User;

public interface UserDAO extends DataAccessObject<User> {

	public User findByUsername(String username);
	
	
}
