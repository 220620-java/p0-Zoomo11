package com.revature.courseapp.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.courseapp.ds.ArrayList;
import com.revature.courseapp.ds.List;
import com.revature.courseapp.models.Course;
import com.revature.courseapp.models.Status;

public class CoursePostgres implements CourseDAO {

	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();

	@Override
	public Course create(Course course) {
		try (Connection conn = connUtil.getConnection()) {
			conn.setAutoCommit(false);

			String sql = "insert into course " + "(id, name, description, capacity, status_id)"
					+ "values (default, ?, ?, ?, ?)";

			String[] keys = {"id"};
			PreparedStatement state = conn.prepareStatement(sql, keys);
			state.setString(1, course.getName());
			state.setString(2, course.getDescription());
			state.setInt(3, course.getCapacity());
			state.setInt(4, course.getStatus().getId());

			int rowsAffected = state.executeUpdate();
			ResultSet result = state.getGeneratedKeys();
			
			if (result.next() && rowsAffected == 1) {
				course.setId(result.getInt("id"));
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
			
			String sql = "select * from course where course.id=? ";
			
			PreparedStatement state = conn.prepareStatement(sql);
			state.setInt(1, id);
			ResultSet result = state.executeQuery();
			
			if (result.next()) {
				String name = result.getString("name");
				String description = result.getString("description");
				int capacity = result.getInt("id");
				Status status = new Status(result.getInt("status_id"), result.getString("status_name"));
				Course course = new Course(name, description, capacity);
				course.setId(id);
				course.setStatus(status);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Course> findAll() {
		List<Course> allCourses = new ArrayList<>();
		
		try (Connection conn = connUtil.getConnection()){
			
			String sql = "select * from course order by course.id";
			
			Statement state = conn.createStatement();
			ResultSet result = state.executeQuery(sql);
			
			while(result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				String description = result.getString("description");
				int capacity = result.getInt("id");
				Status status = new Status(result.getInt("status_id"), result.getString("status_name"));
				Course course = new Course(name, description, capacity);
				course.setId(id);
				course.setStatus(status);
				allCourses.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allCourses;
	}

	@Override
	public void update(Course course) {
		try (Connection conn = connUtil.getConnection()) {
			conn.setAutoCommit(false);
			
			String sql = "update course "
					+ "name=?, " 
					+ "description=?, "
					+ "capacity=?, "
					+ "status_id=?"
					+ "where id=?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, course.getName());
			stmt.setString(2, course.getDescription());
			stmt.setInt(3, course.getCapacity());
			stmt.setInt(4, course.getStatus().getId());
			stmt.setInt(5, course.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Course course) {
		try (Connection conn = connUtil.getConnection()) {
			conn.setAutoCommit(false);
			
			String sql = "delete from course where id=?";
			
			PreparedStatement state = conn.prepareStatement(sql);
			state.setInt(1, course.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Course> findByStatus(Status status) {
		List<Course> Courses = new ArrayList<>();
		
		try (Connection conn = connUtil.getConnection()){
			
			String sql = "select * from course order by course.id";
			
			Statement state = conn.createStatement();
			ResultSet result = state.executeQuery(sql);
			
			while(result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				String description = result.getString("description");
				int capacity = result.getInt("id");
				Status stat = new Status(result.getInt("status_id"), result.getString("status_name"));
				Course course = new Course(name, description, capacity);
				course.setId(id);
				course.setStatus(stat);
				Courses.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Courses;
	}
}
