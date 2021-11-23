package br.com.healthtrack.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.connection.ConnectionManager;
import br.com.healthtrack.model.User;
import br.com.healthtrack.model.UserFeed;

public class UserFeedDAO {
	
	private String tableName = "THT_USFEED_010";
	private String tableSequenceName = "USFEED_ID_SEQ.NEXtVAL";
	
	PreparedStatement stmt = null;	
	ConnectionManager connection = ConnectionManager.getInstance();
	
	public void Insert(UserFeed userFeed) {
		
		try {
			
			if (ExistUser(userFeed.getUser().getId()) && ExistFeed(userFeed.getFeed().getId())) {
				
				var query = String.format("INSERT INTO %s (ID, QUANTITY, TYPE, FEEDDATE, FEEDID, USERID, CAL) "
						+ "VALUES (%s, ?, ?, ?, ?, ?, ?)", tableName, tableSequenceName); 
				
				stmt = connection.GetConnection().prepareStatement(query);			
				
				stmt.setDouble(1, userFeed.getQuantity());	
				stmt.setInt(2, userFeed.getType());	
				stmt.setDate(3, java.sql.Date.valueOf(userFeed.getDate()));	
				stmt.setInt(4, userFeed.getFeed().getId());	
				stmt.setInt(5, userFeed.getUser().getId());	
				stmt.setDouble(6, userFeed.getCal());	
				
				stmt.executeUpdate();
				
				System.out.println("Alimentacao do usuario adicionada com sucesso!");
			}								
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	
	public void Update(UserFeed userFeed) {
		
		try {
			
			if (ExistUser(userFeed.getUser().getId()) && ExistFeed(userFeed.getFeed().getId())) {
				
				var query = String.format("UPDATE %s SET QUANTITY = ?, TYPE = ?, FEEDDATE = ?, FEEDID = ?, USERID = ?, CAL = ? "
						+ "WHERE ID = " + userFeed.getId(), tableName); 
								
				stmt = connection.GetConnection().prepareStatement(query);			
				
				stmt.setDouble(1, userFeed.getQuantity());	
				stmt.setInt(2, userFeed.getType());	
				stmt.setDate(3, java.sql.Date.valueOf(userFeed.getDate()));	
				stmt.setInt(4, userFeed.getFeed().getId());	
				stmt.setInt(5, userFeed.getUser().getId());	
				stmt.setDouble(6, userFeed.getCal());	
				
				stmt.executeUpdate();
				
				System.out.println("Alimentacao do usuario adicionada com sucesso!");
			}								
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	
	public void InsertRange(List<UserFeed> userFeeds) {
		
		for(var item : userFeeds) {
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
	
	public boolean ExistFeed(int feedId) {
		
		var feed = new FeedDAO().Get(feedId);
		
		if (feed == null) {
			System.out.println(String.format("O alimento com o Id %s nao existe no banco de dados", feedId));
			return false;
		}
		
		return true;
	}
	
	public List<UserFeed> ListAllByUserId(int userId) {		
		
		List<UserFeed> listaUserFeed = new ArrayList<UserFeed>();
		ResultSet resultSet = null;
		
		try {
			
			var query = String.format("SELECT * FROM %s WHERE USERID = " + userId, tableName);
			
			stmt = connection.GetConnection().prepareStatement(query);
			resultSet = stmt.executeQuery();			
			
			while(resultSet.next()) {
								
				var id = resultSet.getInt("ID");
				var quantity = resultSet.getDouble("QUANTITY");
				var type = resultSet.getInt("TYPE");
				var feedDate = resultSet.getDate("FEEDDATE");
				var feedId = resultSet.getInt("FEEDID");				
				var cal = resultSet.getDouble("CAL");
				
				var user = new UserDAO().GetById(userId);
				var feed = new FeedDAO().Get(feedId);
				
				UserFeed userFeed = new UserFeed(
					id,
					user, 
					feed,
					quantity,
					type, 
					feedDate.toLocalDate(),
					cal
				);
				
				listaUserFeed.add(userFeed);
				
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
		
		return listaUserFeed;
	}
	
	public List<UserFeed> ListAll() {		
		
		List<UserFeed> listaUserFeed = new ArrayList<UserFeed>();
		ResultSet resultSet = null;
		
		try {
			
			var query = String.format("SELECT * FROM %s", tableName);
			
			stmt = connection.GetConnection().prepareStatement(query);
			resultSet = stmt.executeQuery();			
			
			while(resultSet.next()) {
								
				var id = resultSet.getInt("ID");
				var quantity = resultSet.getDouble("QUANTITY");
				var type = resultSet.getInt("TYPE");
				var feedDate = resultSet.getDate("FEEDDATE");
				var feedId = resultSet.getInt("FEEDID");
				var userId = resultSet.getInt("USERID");
				var cal = resultSet.getDouble("CAL");
				
				var user = new UserDAO().GetById(userId);
				var feed = new FeedDAO().Get(feedId);
				
				UserFeed userFeed = new UserFeed(
					id,
					user, 
					feed,
					quantity,
					type, 
					feedDate.toLocalDate(),
					cal
				);
				
				listaUserFeed.add(userFeed);
				
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
		
		return listaUserFeed;
	}
	
	public UserFeed GetById(int userId) {
		return GetBy(userId, "ID");
	}
	
	public UserFeed GetBy(int value, String columnName) {			
		
		ResultSet resultSet = null;
		UserFeed userFeed = null;	
		
		var query = String.format("SELECT * FROM %s WHERE %s = '" + value + "' AND ROWNUM = 1", tableName, columnName);
		
		try {
			
			stmt = connection.GetConnection().prepareStatement(query);
			resultSet = stmt.executeQuery();
								
			if (resultSet.next() != false) {
				
				var id = resultSet.getInt("ID");
				var quantity = resultSet.getDouble("QUANTITY");
				var type = resultSet.getInt("TYPE");
				var feedDate = resultSet.getDate("FEEDDATE");
				var feedId = resultSet.getInt("FEEDID");
				var userId = resultSet.getInt("USERID");
				var cal = resultSet.getDouble("CAL");
				
				var user = new UserDAO().GetById(userId);
				var feed = new FeedDAO().Get(feedId);
				
				userFeed = new UserFeed(
					id,
					user, 
					feed,
					quantity,
					type, 
					feedDate.toLocalDate(),
					cal
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
		
		return userFeed;
	}
}
