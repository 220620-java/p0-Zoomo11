package com.revature.courseapp.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.courseapp.ds.ArrayList;
import com.revature.courseapp.ds.List;
import com.revature.courseapp.models.Course;
import com.revature.courseapp.models.Student;

public class CoursePostgres implements CourseDAO {

	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();

	@Override
	public Course create(Course course) {
		try (Connection conn = connUtil.getConnection()) {
			conn.setAutoCommit(false);

			String sql = "insert into course " + "(id, name, description, capacity, available)"
					+ "values (default, ?, ?, ?, ?)";

			PreparedStatement state = conn.prepareStatement(sql);
			state.setString(1, course.getName());
			state.setString(2, course.getDescription());
			state.setInt(3, course.getCapacity());
			state.setBoolean(4, course.isAvailable());
			state.executeUpdate();
			System.out.println("New course added");
			state.close();
			return course;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Course findById(int id) {
		PreparedStatement state = null;
		ResultSet result = null;
		try (Connection conn = connUtil.getConnection()) {

			String sql = "select * from course where id=? ";

			state = conn.prepareStatement(sql);
			state.setInt(1, id);
			result = state.executeQuery();

			if (result.next()) {
				String name = result.getString("name");
				String description = result.getString("description");
				int capacity = result.getInt("capacity");
				boolean available = result.getBoolean("available");
				List<Student> students = getEnrolledStudent(id);
				return new Course(id, name, description, capacity, available, students);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(Course course) {
		try (Connection conn = connUtil.getConnection()) {
			conn.setAutoCommit(false);

			String sql = "delete from course where id=?";

			PreparedStatement state = conn.prepareStatement(sql);
			state.setInt(1, course.getId());
			state.executeUpdate();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Course> findAllAvailCourse() {
		List<Course> availCourses = new ArrayList<>();
		Statement state = null;
		ResultSet result = null;
		try (Connection conn = connUtil.getConnection()) {

			String sql = "select from course where available=true order by id";

			state = conn.createStatement();
			result = state.executeQuery(sql);
			while (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				String description = result.getString("description");
				int capacity = result.getInt("capacity");
				boolean available = result.getBoolean("available");
				List<Student> students = getEnrolledStudent(id);

				availCourses.add(new Course(id, name, description, capacity, available, students));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return availCourses;
	}

	@Override
	public List<Course> getEnrolledCourse(int student_id) {
		List<Course> enrolledCourse = new ArrayList<>();

		PreparedStatement state = null;
		ResultSet result = null;
		try (Connection conn = connUtil.getConnection()) {

			// TODO
			String sql = "";

			state = conn.prepareStatement(sql);
			state.setInt(1, student_id);
			result = state.executeQuery();
			while (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				String description = result.getString("description");
				int capacity = result.getInt("capacity");
				boolean available = result.getBoolean("available");
				List<Student> students = getEnrolledStudent(id);
				enrolledCourse.add(new Course(id, name, description, capacity, available, students));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return enrolledCourse;
	}

	@Override
	public List<Student> getEnrolledStudent(int course_id) {
		List<Student> enrolledStudent = new ArrayList<>();

		PreparedStatement state = null;
		ResultSet result = null;
		try (Connection conn = connUtil.getConnection()) {

			String sql = "";

			state = conn.prepareStatement(sql);
			state.setInt(1, course_id);
			result = state.executeQuery();
			while (result.next()) {
				int id = result.getInt("id");
				String firstname = result.getString("firstname");
				String lastname = result.getString("lastname");
				String username = result.getString("username");
				String email = result.getString("email");
				String passwd = result.getString("passwd");
				String usertype = result.getString("usertype");
				if (usertype == "STUDENT") {
					enrolledStudent.add(new Student(id, firstname, lastname, username, email, passwd));
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return enrolledStudent;
	}

	@Override
	public void enrolledCourse(int course_id, int student_id) {
		
		try (Connection conn = connUtil.getConnection()) {
			conn.setAutoCommit(false);
			
			String sql = "insert into coursecont (course_id, student_id) values (?, ?)";
			
			PreparedStatement state = conn.prepareStatement(sql);
			state.executeUpdate();
			state.close();
			System.out.println("Enrolled successful!");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int course_id) {
		try (Connection conn = connUtil.getConnection()) {
			conn.setAutoCommit(false);

			String sql = "delete from course where id=?";

			PreparedStatement state = conn.prepareStatement(sql);
			state.setInt(1, course_id);
			state.executeUpdate();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean disenrolledCourse(int course_id, int student_id) {
		
		try (Connection conn = connUtil.getConnection()) {
			//TODO
			String sql = "";
			
			PreparedStatement state = conn.prepareStatement(sql);
			state.setInt(1, course_id);
			state.setInt(2, student_id);
			ResultSet result = state.executeQuery();
			state.close();
			//TODO
			sql = "";
			state = conn.prepareStatement(sql);
			state.setInt(1, course_id);
			state.setInt(2, student_id);
			state.executeUpdate();
			state.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Course> findAll() {
		List<Course> courses = new ArrayList<>();
		try (Connection conn = connUtil.getConnection()) {

			String sql = "select * from course order by id";

			Statement state = conn.createStatement();
			ResultSet result = state.executeQuery(sql);

			while (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				String description = result.getString("description");
				int capacity = result.getInt("capacity");
				boolean available = result.getBoolean("available");
				List<Student> students = getEnrolledStudent(id);
				courses.add(new Course(id, name, description, capacity, available, students));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return courses;
	}

	@Override
	public void update(Course course) {
		try (Connection conn = connUtil.getConnection()) {
			conn.setAutoCommit(false);

			String sql = "update course set " + "name=?, " + "description=?, " + "capacity=?, " + "where id=?";

			PreparedStatement state = conn.prepareStatement(sql);
			state.setString(1, course.getName());
			state.setString(2, course.getDescription());
			state.setInt(3, course.getCapacity());
			// state.setInt(4, course.getNumOfStudents());
			state.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
