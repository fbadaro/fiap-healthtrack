package br.com.healthtrack.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.connection.ConnectionManager;
import br.com.healthtrack.model.UserActivity;

public class UserActivityDAO {
	
	private String tableName = "THT_USACTIVITY_009";
	private String tableSequenceName = "USACTIVITY_ID_SEQ.NEXtVAL";
	
	PreparedStatement stmt = null;	
	ConnectionManager connection = ConnectionManager.getInstance();
	
	public void Insert(UserActivity userAct) {
		
		try {
			
			if (ExistUser(userAct.getUser().getId()) && ExistActivity(userAct.getActivity().getId())) {
				
				var query = String.format("INSERT INTO %s (ID, ACTIVITYDURATION, ACTIVITYDATE, ACTIVITYID, USERID) "
						+ "VALUES (%s, ?, ?, ?, ?)", tableName, tableSequenceName); 
				
				stmt = connection.GetConnection().prepareStatement(query);			
				
				stmt.setInt(1, userAct.getActivityDuration());	
				stmt.setDate(2, java.sql.Date.valueOf(userAct.getDate()));	
				stmt.setInt(3, userAct.getActivity().getId());	
				stmt.setInt(4, userAct.getUser().getId());	
				
				connection.ExecuteCommand(stmt);
							}								
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	
	public void Update(UserActivity userAct) {
		
		try {
			
			if (ExistUser(userAct.getUser().getId()) && ExistActivity(userAct.getActivity().getId())) {
				
				var query = String.format("UPDATE %s SET ACTIVITYDURATION = ?, ACTIVITYDATE = ?, ACTIVITYID = ?, USERID= ? "
					+"WHERE ID = " + userAct.getId(),  tableName); 
				
				stmt = connection.GetConnection().prepareStatement(query);			
				
				stmt.setInt(1, userAct.getActivityDuration());	
				stmt.setDate(2, java.sql.Date.valueOf(userAct.getDate()));	
				stmt.setInt(3, userAct.getActivity().getId());	
				stmt.setInt(4, userAct.getUser().getId());	
				
				connection.ExecuteCommand(stmt);
							}								
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	
	public void InsertRange(List<UserActivity> activities) {
		
		for(var item : activities) {
			Insert(item);
		}
	}
	
	public boolean ExistUser(int userId) {
				
		var user = new UserDAO().GetById(userId);
		
		if (user == null) {
			System.out.println(String.format("O usuario com o Id %s nao existe no banco de dados", userId));
			return false;
		}
		
		return true;
	}
	
	public boolean ExistActivity(int activityId) {
		
		var activity = new ActivityDAO().Get(activityId);
		
		if (activity == null) {
			System.out.println(String.format("A atividade com o Id %s nao existe no banco de dados", activityId));
			return false;
		}
		
		return true;		
	}
	
	public List<UserActivity> ListAll() {		
		
		List<UserActivity> listaUserActivity = new ArrayList<UserActivity>();
		ResultSet resultSet = null;
		
		try {
			
			var query = String.format("SELECT * FROM %s", tableName);
			
			stmt = connection.GetConnection().prepareStatement(query);
			resultSet = stmt.executeQuery();			
			
			while(resultSet.next()) {
								
				var id = resultSet.getInt("ID");
				var activityDuration = resultSet.getInt("ACTIVITYDURATION");
				var activityDate  = resultSet.getDate("ACTIVITYDATE");
				var userId = resultSet.getInt("USERID");
				var activityId = resultSet.getInt("ACTIVITYID");
				
				var user = new UserDAO().GetById(userId);
				var activity = new ActivityDAO().Get(activityId);
				
				UserActivity userActivity = new UserActivity(
					id,
					user, 
					activity, 
					activityDuration, 
					activityDate.toLocalDate()
				);
				
				listaUserActivity.add(userActivity);
				
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
		
		return listaUserActivity;
	}
	
	
	public int durationToInt(String duration) {
		String[] duracao = duration.split(":");
		int n1 = Integer.parseInt(duracao[0]);
		int n2 = Integer.parseInt(duracao[1]);
		
		return n1 * 60 + n2;
		
		
	}



public List<UserActivity> ListAllByUserId(int userId) {		
	
	List<UserActivity> listaUserActivity = new ArrayList<UserActivity>();
	ResultSet resultSet = null;
	
	try {
		
		var query = String.format("SELECT * FROM %s WHERE USERID = " + userId, tableName);
		
		stmt = connection.GetConnection().prepareStatement(query);
		resultSet = stmt.executeQuery();			
		
		while(resultSet.next()) {
							
			var id = resultSet.getInt("ID");
			var activityDuration = resultSet.getInt("ACTIVITYDURATION");
			var activityDate  = resultSet.getDate("ACTIVITYDATE");
			var activityId = resultSet.getInt("ACTIVITYID");
			
			var user = new UserDAO().GetById(userId);
			var activity = new ActivityDAO().Get(activityId);
			
			UserActivity userActivity = new UserActivity(
				id,
				user, 
				activity, 
				activityDuration, 
				activityDate.toLocalDate()
			);
			
			listaUserActivity.add(userActivity);
			
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
	
	return listaUserActivity;
}


public UserActivity GetById(int userAcvitivityID) {		
	
	UserActivity  userActivity = null;
	ResultSet resultSet = null;
	
	try {
		
		var query = String.format("SELECT * FROM %s WHERE ID = " + userAcvitivityID, tableName);
		
		stmt = connection.GetConnection().prepareStatement(query);
		resultSet = stmt.executeQuery();			
		
		if (resultSet.next()) {
							
			var id = resultSet.getInt("ID");
			var activityDuration = resultSet.getInt("ACTIVITYDURATION");
			var activityDate  = resultSet.getDate("ACTIVITYDATE");
			var userId = resultSet.getInt("USERID");
			var activityId = resultSet.getInt("ACTIVITYID");
			
			var user = new UserDAO().GetById(userId);
			var activity = new ActivityDAO().Get(activityId);
			
			userActivity = new UserActivity(
				id,
				user, 
				activity, 
				activityDuration, 
				activityDate.toLocalDate()
			);
			
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
	
	return userActivity;
}

}

