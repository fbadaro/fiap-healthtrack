package br.com.healthtrack.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.connection.ConnectionManager;
import br.com.healthtrack.model.UserBloodPressure;

public class UserBloodPressureDAO {
	
	private String tableName = "THT_USPRESSURE_012";
	private String tableSequenceName = "USPRESSURE_ID_SEQ.NEXtVAL";
	
	PreparedStatement stmt = null;	
	ConnectionManager connection = ConnectionManager.getInstance();
	
	public void Insert(UserBloodPressure userBloodPressure) {
		
		try {
			
			if (ExistUser(userBloodPressure.getUser().getId())) {
				
				var query = String.format("INSERT INTO %s (ID, DIASTOLICPRESSSURE, SYSTOLICPRESSURE, PRESSUREDATE, USERID) "
						+ "VALUES (%s, ?, ?, ?, ?)", tableName, tableSequenceName); 
				
				stmt = connection.GetConnection().prepareStatement(query);			
				
				stmt.setInt(1, userBloodPressure.getDiastolicPressure());
				stmt.setInt(2, userBloodPressure.getSystolicPressure());
				stmt.setDate(3, java.sql.Date.valueOf(userBloodPressure.getDate()));					
				stmt.setInt(4, userBloodPressure.getUser().getId());	
				
				connection.ExecuteCommand(stmt);
				
				System.out.println("Pressao do usuario adicionada com sucesso!");
			}								
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	
	public void InsertRange(List<UserBloodPressure> userPressures) {
		
		for (var item : userPressures) {
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
	
	public List<UserBloodPressure> ListAll() {
		
		List<UserBloodPressure> listaUserPressure = new ArrayList<UserBloodPressure>();
		ResultSet resultSet = null;
		
		try {
			
			var query = String.format("SELECT * FROM %s", tableName);
			
			stmt = connection.GetConnection().prepareStatement(query);
			resultSet = stmt.executeQuery();			
			
			while(resultSet.next()) {
								
				//var id = resultSet.getInt("ID");
				var diastolic = resultSet.getInt("DIASTOLICPRESSSURE");
				var systolic  = resultSet.getInt("SYSTOLICPRESSURE");
				var pressureDate = resultSet.getDate("PRESSUREDATE");
				var userId = resultSet.getInt("USERID");
				
				// TODO
				var user = new UserDAO().Get(userId);				
				
				UserBloodPressure userBloodPressure = new UserBloodPressure(
						user, 
						systolic, 
						diastolic, 
						pressureDate.toLocalDate()
						);
				
				listaUserPressure.add(userBloodPressure);
				
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
		
		return listaUserPressure;
	}
}
