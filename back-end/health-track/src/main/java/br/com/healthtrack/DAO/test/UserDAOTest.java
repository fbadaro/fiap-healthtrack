package br.com.healthtrack.DAO.test;

import br.com.healthtrack.DAO.UserDAO;
import br.com.healthtrack.factory.DAOFactory;
import br.com.healthtrack.model.User;

public class UserDAOTest {

	public static void main(String[] args) {
		
		UserDAO userDAO = DAOFactory.getUserDAO();
		
		// INSERT
		var user = new User("Fabio Badaro", "fabio@gmail.com", "fbadaro", "123456");		
		userDAO.Insert(user);
				
		var userDatabase = userDAO.Get(1);		
		System.out.println(userDatabase.getName());
	}
}
