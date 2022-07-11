package com.revature.courseapp.data;

import com.revature.courseapp.ds.List;
import com.revature.courseapp.models.Course;
import com.revature.courseapp.models.Student;

public interface CourseDAO extends DataAccessObject<Course> {

	public List<Course> findAllAvailCourse();
	
	public List<Course> getEnrolledCourse(int student_id);
	
	public List<Student> getEnrolledStudent(int course_id);
	
	public void enrolledCourse (int course_id, int student_id);
	
	public void delete(int course_id);
	
	public boolean disenrolledCourse(int course_id, int student_id);
	
}
