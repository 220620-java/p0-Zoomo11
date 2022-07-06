package com.revature.courseapp.data;

import com.revature.courseapp.ds.List;
import com.revature.courseapp.models.User;

public class UserPostgres implements UserDAO {
	
	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();
	
	@Override
	public User create(User value) {
		
		return null;
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}
