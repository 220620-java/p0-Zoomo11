package com.revature.courseapp.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.courseapp.ds.ArrayList;
import com.revature.courseapp.ds.List;
import com.revature.courseapp.models.Faculty;
import com.revature.courseapp.models.Student;
import com.revature.courseapp.models.User;

public class UserPostgres implements UserDAO {
	
	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();
	
	@Override
	public User create(User user) {
		
		try (Connection conn = connUtil.getConnection()) {
			
			String sql = "insert into person "
					+ "(id, firstname, lastname, email, username, passwd)"
					+ "values (default, ?, ?, ?, ?, ?)";
			
			String[] keys = {"id"};
			PreparedStatement state = conn.prepareStatement(sql, keys);
			state.setString(1, user.getFirstName());
			state.setString(2, user.getLastName());
			state.setString(3, user.getEmail());
			state.setString(4, user.getUsername());
			state.setString(5, user.getPassword());
			
			int rowsAffected = state.executeUpdate();
			ResultSet result = state.getGeneratedKeys();
			
			if (result.next() && rowsAffected == 1) {
				user.setId(result.getInt("id"));
				conn.commit();
			} else {
				conn.rollback();
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
		
	}

	@Override
	public User findById(int user_id) {
		try (Connection conn = connUtil.getConnection()) {
			
			String sql = "select * from person where person.id = ?";
			
			PreparedStatement state = conn.prepareStatement(sql);
			state.setInt(1, user_id);
			ResultSet result = state.executeQuery();
			
			if (result.next()) {
				String firstname = result.getString("firstName");
				String lastname = result.getString("lastName");
				String username = result.getString("username");
				String email = result.getString("email");
				String type = result.getString("type");
				User user = new User(firstname, lastname, username, email, type);
				user.setId(user_id);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		List<User> allUser = new ArrayList<>();
		
		try (Connection conn = connUtil.getConnection()){
			
			String sql = "select * from person order by person.id";
			
			Statement state = conn.createStatement();
			ResultSet result = state.executeQuery(sql);
			
			while(result.next()) {
				int id = result.getInt("id");
				String firstname = result.getString("firstName");
				String lastname = result.getString("lastname");
				String email = result.getString("email");
				String username = result.getString("username");
				String password = result.getString("password");
				String usertype = result.getString("usertype");
				User user = new User(firstname, lastname, email, username, password);
				user.setId(id);
				allUser.add(user);			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allUser;
	}

	@Override
	public void update(User user) {
		try (Connection conn = connUtil.getConnection()) {
			conn.setAutoCommit(false);
			
			String sql = "update person set "
					+ "firstname=?, " 
					+ "lastname=?, "
					+ "email=?, "
					+ "username=?,"
					+ "passwd=?"
					+ "where id=?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getUsername());
			stmt.setString(5, user.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(User user) {
		try (Connection conn = connUtil.getConnection()) {
			conn.setAutoCommit(false);
			
			String sql = "delete from person where id=?";
			
			PreparedStatement state = conn.prepareStatement(sql);
			state.setInt(1, user.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public User findByUsername(String userName) {
		try (Connection conn = connUtil.getConnection()) {
			
			String sql = "select * from person where person.id = ?";
			
			PreparedStatement state = conn.prepareStatement(sql);
			state.setString(1, userName);
			ResultSet result = state.executeQuery();
			
			if (result.next()) {
				String firstname = result.getString("firstName");
				String lastname = result.getString("lastName");
				String username = result.getString("username");
				String email = result.getString("email");
				String type = result.getString("type");
				User user = new User(firstname, lastname, username, email, type);
				user.setUsername(userName);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
