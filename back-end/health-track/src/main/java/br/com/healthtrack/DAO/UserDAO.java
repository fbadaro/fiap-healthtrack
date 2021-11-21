package br.com.healthtrack.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.healthtrack.connection.ConnectionManager;
import br.com.healthtrack.model.User;

public class UserDAO {
	
	private String tableName = "THT_USER_001";
	private String tableSequenceName = "USER_ID_SEQ.NEXtVAL";
	
	PreparedStatement stmt = null;	
	ConnectionManager connection = ConnectionManager.getInstance();
	
	public void Insert(User user) {
		
		try {
			
			var query = String.format("INSERT INTO %s (ID, NAME, EMAIL, LOGIN, PASS, ACTIVE, PHOTO, BIRTHDAY, WEIGHT, HEIGHT) "
					+ "VALUES (%s, ?, ?, ?, ?, 'A', NULL, ?, ?, ?)", tableName, tableSequenceName); 
			
			stmt = connection.GetConnection().prepareStatement(query);			
			
			stmt.setString(1, user.getName());	
			stmt.setString(2, user.getEmail());	
			stmt.setString(3, user.getLogin());	
			stmt.setString(4, user.getPass());				
			stmt.setDate(5, java.sql.Date.valueOf(user.getBirthday()));	
			stmt.setDouble(6, user.getWeight());	
			stmt.setDouble(7, user.getHeight());	
			
			connection.ExecuteCommand(stmt);
			
			System.out.println("Usuario adicionado com sucesso!");
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}			
	}
	
	public void InsertRange(List<User> users) {
		
		for(var item : users) {
			Insert(item);
		}
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
