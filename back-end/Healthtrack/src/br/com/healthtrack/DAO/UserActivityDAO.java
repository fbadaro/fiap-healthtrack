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
				
				stmt.setDate(1, java.sql.Date.valueOf(userAct.getActivityDuration()));	
				stmt.setDate(2, java.sql.Date.valueOf(userAct.getDate()));	
				stmt.setInt(3, userAct.getActivity().getId());	
				stmt.setInt(4, userAct.getUser().getId());	
				
				connection.ExecuteCommand(stmt);
				
				System.out.println("Atividade do usuario adicionada com sucesso!");
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
				
		var user = new UserDAO().Get(userId);
		
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
								
				//var id = resultSet.getInt("ID");
				var activityDuration = resultSet.getDate("ACTIVITYDURATION");
				var activityDate  = resultSet.getDate("ACTIVITYDATE");
				var userId = resultSet.getInt("USERID");
				var activityId = resultSet.getInt("ACTIVITYID");
				
				// TODO
				var user = new UserDAO().Get(userId);
				var activity = new ActivityDAO().Get(activityId);
				
				UserActivity userActivity = new UserActivity(
						user, 
						activity, 
						activityDuration.toLocalDate(), 
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
}
