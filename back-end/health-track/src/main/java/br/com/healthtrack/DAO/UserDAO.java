package br.com.healthtrack.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.healthtrack.connection.ConnectionManager;
import br.com.healthtrack.model.User;

public class UserDAO {
	
	private String tableName = "THT_USER_001";	
	private String tableSequenceName = "USER_ID_SEQ.NEXTVAL";
	
	PreparedStatement stmt = null;		
	ConnectionManager connection = ConnectionManager.getInstance();
	
	public User Insert(User user) {
				
		User createdUser = null;	
		
		try {
			
			var query = String.format("INSERT INTO %s (ID, NAME, EMAIL, LOGIN, PASS, ACTIVE, PHOTO, BIRTHDAY, WEIGHT, HEIGHT) "
					+ "VALUES (%s, ?, ?, ?, ?, 'A', NULL, ?, ?, ?)", tableName, tableSequenceName); 					
			
			stmt = connection.GetConnection().prepareStatement(query);				
			
			var userName = user.getName();
			var userEmail = user.getEmail();
			var userLogin = user.getLogin();
			var userPass = user.getPass();
			var userBirthday = java.sql.Date.valueOf(user.getBirthday());
			var userWeight = user.getWeight();
			var userHeight = user.getHeight();
			
			stmt.setString(1, userName);	
			stmt.setString(2, userEmail);	
			stmt.setString(3, userLogin);	
			stmt.setString(4, userPass);				
			stmt.setDate(5, userBirthday);	
			stmt.setDouble(6, userWeight);	
			stmt.setDouble(7, userHeight);			
							
			stmt.executeUpdate();								
						
			createdUser = GetByEmail(userEmail);
			
			System.out.println("Usuario adicionado com sucesso!");
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}	
		
		return createdUser;
	}
	
	public User Update(User user) {
		
		User updateddUser = null;
		
		try {
			
			var query = String.format("UPDATE %s SET NAME = ?, EMAIL = ?, BIRTHDAY = ?, WEIGHT = ?, HEIGHT = ? "
					+ "WHERE ID = " + user.getId(), tableName); 
			
			stmt = connection.GetConnection().prepareStatement(query);			
			
			stmt.setString(1, user.getName());	
			stmt.setString(2, user.getEmail());									
			stmt.setDate(3, java.sql.Date.valueOf(user.getBirthday()));	
			stmt.setDouble(4, user.getWeight());	
			stmt.setDouble(5, user.getHeight());	
			
			stmt.executeUpdate();
			
			System.out.println("Usuario atualizado com sucesso!");
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		return updateddUser;
	}
	
	public boolean Authenticate(String email, String pass) {
		
		ResultSet resultSet = null;
		boolean existUser = false;	
		
		try {
			
			var query = String.format("SELECT * FROM %s WHERE EMAIL = '" + email + "' AND PASS = '" + pass + "' AND ROWNUM = 1", tableName);					
			
			stmt = connection.GetConnection().prepareStatement(query);	
			
			resultSet = stmt.executeQuery();
			
			if (resultSet.next()) {					
				existUser = true;
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}	
		
		return existUser;
	}
	
	public void InsertRange(List<User> users) {
		
		for(var item : users) {
			Insert(item);
		}
	}
	
	public User GetByEmail(String userEmail) {
		return GetBy(userEmail, "EMAIL");
	}
	
	public User GetById(int userId) {
		return GetBy(userId, "ID");
	}
	
	public User GetBy(String value, String columnName) {			
		
		ResultSet resultSet = null;
		User user = null;	
		
		var query = String.format("SELECT * FROM %s WHERE %s = '" + value + "' AND ROWNUM = 1", tableName, columnName);
		
		try {
			
			stmt = connection.GetConnection().prepareStatement(query);
			resultSet = stmt.executeQuery();
								
			if (resultSet.next() != false) {
				
				var userId = resultSet.getInt("ID");
				var userName = resultSet.getString("NAME");
				var userEmail = resultSet.getString("EMAIL");
				var userLogin = resultSet.getString("LOGIN");
				var userPass = resultSet.getString("PASS");
				var userHeight = resultSet.getDouble("HEIGHT");
				var userWeight = resultSet.getDouble("WEIGHT");
				var userBirthday = resultSet.getDate("BIRTHDAY").toLocalDate();
				
				user = new User(
					userId,
					userName,
					userEmail,
					userLogin,
					userPass,
					userHeight,
					userWeight,
					userBirthday
				);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
				resultSet.close();
				connection.CloseConnection();
			} catch (SQLException e) { 
				e.printStackTrace();
			}
		}
		
		return user;
	}
	
	public User GetBy(int value, String columnName) {			
		
		ResultSet resultSet = null;
		User user = null;	
		
		var query = String.format("SELECT * FROM %s WHERE %s = '" + value + "' AND ROWNUM = 1", tableName, columnName);
		
		try {
			
			stmt = connection.GetConnection().prepareStatement(query);
			resultSet = stmt.executeQuery();
			
			if (resultSet.next() != false) {
				
				var userId = resultSet.getInt("ID");
				var userName = resultSet.getString("NAME");
				var userEmail = resultSet.getString("EMAIL");
				var userLogin = resultSet.getString("LOGIN");
				var userPass = resultSet.getString("PASS");
				var userHeight = resultSet.getDouble("HEIGHT");
				var userWeight = resultSet.getDouble("WEIGHT");
				var userBirthday = resultSet.getDate("BIRTHDAY").toLocalDate();
				
				user = new User(
					userId,
					userName,
					userEmail,
					userLogin,
					userPass,
					userHeight,
					userWeight,
					userBirthday
				);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
				resultSet.close();
				connection.CloseConnection();
			} catch (SQLException e) { 
				e.printStackTrace();
			}
		}
		
		return user;
	}
}
