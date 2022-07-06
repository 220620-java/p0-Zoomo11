package com.revature.courseapp.data;

import com.revature.courseapp.ds.List;
import com.revature.courseapp.models.Course;
import com.revature.courseapp.models.Status;

public interface CourseDAO extends DataAccessObject<Course> {

	public List<Course> findByStatus(Status status);
}
