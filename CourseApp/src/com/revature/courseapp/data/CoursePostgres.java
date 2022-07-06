package com.revature.courseapp.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.courseapp.ds.List;
import com.revature.courseapp.models.Course;
import com.revature.courseapp.models.Status;

public class CoursePostgres implements CourseDAO {

	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();
	
	@Override
	public Course create(Course course) {
		try (Connection conn = connUtil.getConnection()) {
			conn.setAutoCommit(false);
			
			String sql = "insert into course "
					+ "(id, name, description, capacity, status_id)"
					+ "values (default, ?, ?, ?, ?)";
			
			PreparedStatement stmt = conn.prepareStatement(sql, keys);
			stmt.setString(1, course.getName());
			stmt.setString(2, course.getDescription());
			stmt.setInt(3, course.getCapacity());
			stmt.setInt(4, course.getStatus().getId());
			
			int rowsAffected = stmt.executeUpdate();
			ResultSet resultSet = stmt.getGeneratedKeys();
			if (resultSet.next() && rowsAffected==1) {
				course.setId(resultSet.getInt("id"));
				conn.commit();
			} else {
				conn.rollback();
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return course;
	}

	@Override
	public Course findById(int id) {
		try (Connection conn = connUtil.getConnection()) {
			String sql = "select course.id, "
					+ "course.name," + "course.description," +"course.capacity"
					+ ""
		}
		return null;
	}

	@Override
	public List<Course> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Course value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Course value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Course> findByStatus(Status status) {
		// TODO Auto-generated method stub
		return null;
	}

}
