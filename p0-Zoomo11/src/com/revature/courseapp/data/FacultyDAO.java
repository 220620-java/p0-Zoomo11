package com.revature.courseapp.data;

import com.revature.courseapp.models.Faculty;

public interface FacultyDAO extends DataAccessObject<Faculty> {

	public Faculty findByName(String name);
}
