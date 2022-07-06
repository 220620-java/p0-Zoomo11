package com.revature.courseapp.data;

import com.revature.courseapp.models.Status;

public interface StatusDAO extends DataAccessObject<Status> {

	public Status findByName(String name);
}
