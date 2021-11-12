package br.com.healthtrack.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.healthtrack.connection.ConnectionManager;
import br.com.healthtrack.model.Administrator;

public class AdministratorDAO {
	
	private String tableName = "THT_ADMIN_002";
	private String tableSequenceName = "ADMIN_ID_SEQ.NEXtVAL";
	
	PreparedStatement stmt = null;	
	ConnectionManager connection = ConnectionManager.getInstance();
	
	public void Insert(Administrator administrator) {
			
		try {
			
			var query = String.format("INSERT INTO %s (ID, NAME, EMAIL, LOGIN, PASS, ACTIVE, PHOTO) "
					+ "VALUES (%s, ?, ?, ?, ?, 'A', NULL)", tableName, tableSequenceName); 
			
			stmt = connection.GetConnection().prepareStatement(query);			
			
			stmt.setString(1, administrator.getName());	
			stmt.setString(2, administrator.getEmail());	
			stmt.setString(3, administrator.getLogin());	
			stmt.setString(4, administrator.getPass());	
			
			connection.ExecuteCommand(stmt);
			
			System.out.println("Administrador adicionado com sucesso!");
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}			
	}
	
	public Administrator Get(int admId) {
		
		ResultSet resultSet = null;
		Administrator adm = null;
		
		var query = String.format("SELECT * FROM %s WHERE ID = " + admId + " AND ROWNUM = 1", tableName);
		
		try {
			
			stmt = connection.GetConnection().prepareStatement(query);
			resultSet = stmt.executeQuery();
			
			if (resultSet.next() != false) {
				adm = new Administrator(
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
		
		return adm;
	}
}
