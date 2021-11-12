package br.com.healthtrack.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.connection.ConnectionManager;
import br.com.healthtrack.model.UserWeight;

public class UserWeightDAO {
	
	private String tableName = "THT_USWEIGHT_011";
	private String tableSequenceName = "USWEIGHT_ID_SEQ.NEXtVAL";
	
	PreparedStatement stmt = null;	
	ConnectionManager connection = ConnectionManager.getInstance();
	
	public void Insert(UserWeight userWeigth) {
		
		try {
			
			if (ExistUser(userWeigth.getUser().getId())) {
				
				var query = String.format("INSERT INTO %s (ID, WEIGHT, HEIGHT, WEIGHTDATE, USERID) "
						+ "VALUES (%s, ?, ?, ?, ?)", tableName, tableSequenceName); 
				
				stmt = connection.GetConnection().prepareStatement(query);			
				
				stmt.setDouble(1, userWeigth.getWeight());
				stmt.setDouble(2, userWeigth.getHeight());
				stmt.setDate(3, java.sql.Date.valueOf(userWeigth.getDate()));					
				stmt.setInt(4, userWeigth.getUser().getId());	
				
				connection.ExecuteCommand(stmt);
				
				System.out.println("Peso e Altura do usuario adicionados com sucesso!");
			}								
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	
	public void InsertRange(List<UserWeight> userWeights) {
		
		for (var item : userWeights) {
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
	
	public List<UserWeight> ListAll() {
		
		List<UserWeight> listaUserWeight = new ArrayList<UserWeight>();
		ResultSet resultSet = null;
		
		try {
			
			var query = String.format("SELECT * FROM %s", tableName);
			
			stmt = connection.GetConnection().prepareStatement(query);
			resultSet = stmt.executeQuery();			
			
			while(resultSet.next()) {
								
				//var id = resultSet.getInt("ID");
				var weight = resultSet.getDouble("WEIGHT");
				var height  = resultSet.getDouble("HEIGHT");
				var weightDate = resultSet.getDate("WEIGHTDATE");
				var userId = resultSet.getInt("USERID");
				
				// TODO
				var user = new UserDAO().Get(userId);				
				
				UserWeight userWeight = new UserWeight(
						user, 
						weight, 
						height, 
						weightDate.toLocalDate()
						);
				
				listaUserWeight.add(userWeight);
				
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
		
		return listaUserWeight;
	}
}
