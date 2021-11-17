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
					+ "VALUES (%s, ?, ?, ?, ?, 'A', NULL, NULL, NULL, NULL)", tableName, tableSequenceName); 
			
			stmt = connection.GetConnection().prepareStatement(query);			
			
			stmt.setString(1, user.getName());	
			stmt.setString(2, user.getEmail());	
			stmt.setString(3, user.getLogin());	
			stmt.setString(4, user.getPass());	
			
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
	
	public User Get(int userId) {			
		
		ResultSet resultSet = null;
		User user = null;	
		
		var query = String.format("SELECT * FROM %s WHERE ID = " + userId + " AND ROWNUM = 1", tableName);
		
		try {
			
			stmt = connection.GetConnection().prepareStatement(query);
			resultSet = stmt.executeQuery();
			
			if (resultSet.next() != false) {
				user = new User(
						resultSet.getInt("ID"),
						resultSet.getString("NAME"),
						resultSet.getString("EMAIL"),
						resultSet.getString("LOGIN"),
						resultSet.getString("PASS")
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
