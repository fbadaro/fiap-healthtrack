package br.com.healthtrack.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.connection.ConnectionManager;
import br.com.healthtrack.model.Address;


public class AddressDAO {
	
	private String tableName = "THT_ADDRESS_005";
	private String tableSequenceName = "ADDRESS_ID_SEQ.NEXtVAL";
	
	PreparedStatement stmt = null;	
	ConnectionManager connection = ConnectionManager.getInstance();
	
	public void Insert(Address address) {
		
		try {
			
			if (ExistUser(address.getUser().getId())) {
				
				var query = String.format("INSERT INTO %s (ID, STREET, \"number\", CITY, STATE, PRINCIPAL, ZIPCODE, COUNTRY, USERID) "
						+ "VALUES (%s, ?, ?, ?, ?, ?, ?, ?, ?)", tableName, tableSequenceName);
				
				System.out.println(query);
				
				stmt = connection.GetConnection().prepareStatement(query);			
				
				stmt.setString(1, address.getStreet());
				stmt.setInt(2, address.getNumber());
				stmt.setString(3, address.getCity());
				stmt.setString(4, address.getState());
				stmt.setString(5, "A");
				stmt.setString(6, address.getZipCode());
				stmt.setString(7, address.getCountry());
				stmt.setInt(8, address.getUser().getId());			
				
				connection.ExecuteCommand(stmt);
				
				System.out.println("Endereco do usuario adicionado com sucesso!");
			}								
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	
	public void InserRange(List<Address> address) {
		
		for (var item : address) {
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
	
	public List<Address> ListAll() {
		
		List<Address> listaUserAddress = new ArrayList<Address>();
		ResultSet resultSet = null;
		
		try {
			
			var query = String.format("SELECT * FROM %s", tableName);
			
			stmt = connection.GetConnection().prepareStatement(query);
			resultSet = stmt.executeQuery();			
			
			while(resultSet.next()) {
								
				var addressId = resultSet.getInt("ID");
				var addressStreet = resultSet.getString("STREET");
				var addressNumber  = resultSet.getInt("number");
				var addressCity = resultSet.getString("CITY");
				var addressState = resultSet.getString("STATE");
				var addressPrincipal = resultSet.getBoolean("PRINCIPAL");
				var addressZipcode = resultSet.getString("ZIPCODE");
				var addressCountry = resultSet.getString("COUNTRY");
				var addressUserId = resultSet.getInt("USERID");				 
				var addressUser = new UserDAO().GetById(addressUserId);				
				
				Address address = new Address(
					addressId,
					addressUser, 
					addressStreet, 
					addressCity, 
					addressNumber,
					addressCountry,
					addressState,
					addressZipcode,
					addressPrincipal				
				);
				
				listaUserAddress.add(address);
				
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
		
		return listaUserAddress;
	}
}
