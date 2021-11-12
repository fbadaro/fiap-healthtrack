package br.com.healthtrack.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.connection.ConnectionManager;
import br.com.healthtrack.model.Activity;

public class ActivityDAO {
	
	private String tableName = "THT_ACTIVITY_007";
	private String tableSequenceName = "ACTIVITY_ID_SEQ.NEXtVAL";
	
	PreparedStatement stmt = null;
	ConnectionManager connection = ConnectionManager.getInstance();
	
	public void Insert(Activity activity) {
		
		try {
			
			if (!ExistByName(activity.getName())) {
				
				var query = String.format("INSERT INTO %s (ID, NAME) "
						+ "VALUES (%s, ?)", tableName, tableSequenceName); 
				
				stmt = connection.GetConnection().prepareStatement(query);			
				
				stmt.setString(1, activity.getName());				
				
				connection.ExecuteCommand(stmt);
				
				System.out.println("Atividade adicionada com sucesso!");
			}								
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	
	public void InsertRange(List<Activity> activities) {
		
		for(var item : activities) {
			Insert(item);
		}
	}
	
	public boolean ExistByName(String activityName) {
		
		ResultSet resultSet = null;
		var itemExist = false;			
		
		var query = String.format("SELECT * FROM %s WHERE NAME = '" + activityName + "' AND ROWNUM = 1", tableName);			
		
		try {
			
			stmt = connection.GetConnection().prepareStatement(query);
			resultSet = stmt.executeQuery();
			
			if (resultSet.next() != false) {
				itemExist = true;
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
		
		return itemExist;
	}
	
	public List<Activity> ListAll() {
		
		List<Activity> listaActivity = new ArrayList<Activity>();
		ResultSet resultSet = null;
		
		try {
			
			var query = String.format("SELECT * FROM %s", tableName);
			
			stmt = connection.GetConnection().prepareStatement(query);
			resultSet = stmt.executeQuery();			
			
			while(resultSet.next()) {				
				Activity activity = new Activity(
						resultSet.getInt("ID"),
						resultSet.getString("NAME")
						);
				
				listaActivity.add(activity);
				
			}
		} catch (SQLException e) {			
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
		
		return listaActivity;		
	}
	
	public Activity Get(int activityId) {			
		
		ResultSet resultSet = null;
		Activity activity = null;	
		
		var query = String.format("SELECT * FROM %s WHERE ID = " + activityId + " AND ROWNUM = 1", tableName);
		
		try {
			
			stmt = connection.GetConnection().prepareStatement(query);
			resultSet = stmt.executeQuery();
			
			if (resultSet.next() != false) {
				activity = new Activity(
						resultSet.getInt("ID"),
						resultSet.getString("NAME")
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
		
		return activity;
	}
}
