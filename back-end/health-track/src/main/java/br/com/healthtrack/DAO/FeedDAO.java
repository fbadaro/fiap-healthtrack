package br.com.healthtrack.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.connection.ConnectionManager;
import br.com.healthtrack.model.Feed;

public class FeedDAO {
	
	private String tableName = "THT_FEED_008";
	private String tableSequenceName = "FEED_ID_SEQ.NEXtVAL";
	
	PreparedStatement stmt = null;	
	ConnectionManager connection = ConnectionManager.getInstance();
	
	public void Insert(Feed feed) {
		
		try {
			
			if (!ExistByName(feed.getName())) {
				
				var query = String.format("INSERT INTO %s (ID, NAME) "
						+ "VALUES (%s, ?)", tableName, tableSequenceName); 
				
				stmt = connection.GetConnection().prepareStatement(query);			
				
				stmt.setString(1, feed.getName());				
				
				connection.ExecuteCommand(stmt);
				
				System.out.println("Alimentacao adicionada com sucesso!");
			}								
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	
	public void InserRange(List<Feed> feeds) {
		
		for(var item : feeds) {
			Insert(item);
		}
	}
	
	public boolean ExistByName(String feedName) {
		
		ResultSet resultSet = null;
		var itemExist = false;			
		
		var query = String.format("SELECT * FROM %s WHERE NAME = '" + feedName + "' AND ROWNUM = 1", tableName);			
		
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
	
	public List<Feed> ListAll() {
		
		List<Feed> listaFeed = new ArrayList<Feed>();
		ResultSet resultSet = null;
		
		try {
			
			var query = String.format("SELECT * FROM %s", tableName);
			
			stmt = connection.GetConnection().prepareStatement(query);
			resultSet = stmt.executeQuery();			
			
			while(resultSet.next()) {				
				Feed feed = new Feed(
						resultSet.getInt("ID"),
						resultSet.getString("NAME")
						);
				
				listaFeed.add(feed);
				
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
		
		return listaFeed;
	}
	
	public Feed Get(int feedId) {			
		
		ResultSet resultSet = null;
		Feed feed = null;	
		
		var query = String.format("SELECT * FROM %s WHERE ID = " + feedId + " AND ROWNUM = 1", tableName);
		
		try {
			
			stmt = connection.GetConnection().prepareStatement(query);
			resultSet = stmt.executeQuery();
			
			if (resultSet.next() != false) {
				feed = new Feed(
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
		
		return feed;
	}
}
