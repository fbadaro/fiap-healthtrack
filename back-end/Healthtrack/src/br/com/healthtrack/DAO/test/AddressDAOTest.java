package br.com.healthtrack.DAO.test;

import java.util.ArrayList;

import br.com.healthtrack.factory.DAOFactory;
import br.com.healthtrack.DAO.AddressDAO;
import br.com.healthtrack.DAO.UserDAO;
import br.com.healthtrack.model.Address;

public class AddressDAOTest {

	public static void main(String[] args) {

		AddressDAO addressDAO = DAOFactory.getAddressDAO();
		UserDAO userDAO = DAOFactory.getUserDAO();		
		
		// INSERT
		var userDatabase = userDAO.Get(4);
		var userAddresses = new ArrayList<Address>();
		
//		userAddresses.add(new Address(userDatabase, "Rua 1", "Cidade 1", 103, "Pais 1", "Estado 1", "09761125", true));
//		userAddresses.add(new Address(userDatabase, "Rua 2", "Cidade 2", 103, "Pais 2", "Estado 2", "09761125", false));
//		userAddresses.add(new Address(userDatabase, "Rua 3", "Cidade 3", 103, "Pais 3", "Estado 3", "09761125", false));
//		userAddresses.add(new Address(userDatabase, "Rua 4", "Cidade 4", 103, "Pais 4", "Estado 4", "09761125", false));
//		userAddresses.add(new Address(userDatabase, "Rua 5", "Cidade 5", 103, "Pais 5", "Estado 5", "09761125", false));
//		
//		addressDAO.InserRange(userAddresses);
		
		// LIST
		var addressDatabase = addressDAO.ListAll();
		
		for (var item : addressDatabase) {
			System.out.println(String.format("User City: %s", item.getCity()));
		}
	}
}
