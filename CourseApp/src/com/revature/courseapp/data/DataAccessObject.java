package com.revature.courseapp.data;

import com.revature.courseapp.ds.List;

public interface DataAccessObject<T> {

	public T create(T value);
	
	public T findById(int id);
	
	public List<T> findAll();
	
	public void update(T value);
	
	public void delete(T value);
}
