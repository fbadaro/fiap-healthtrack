package br.com.healthtrack.DAO.test;

import br.com.healthtrack.DAO.AdministratorDAO;
import br.com.healthtrack.factory.DAOFactory;
import br.com.healthtrack.model.Administrator;

public class AdministratorDAOTest {

	public static void main(String[] args) {
		
		AdministratorDAO administratorDAO = DAOFactory.getAdministratorDAO();
		
		// INSERT
		var adm = new Administrator("Belzinha Badaro", "bel@gmail.com", "bel", "123456");		
		administratorDAO.Insert(adm);
		
		// GET
		var admDatabase = administratorDAO.Get(1);
		System.out.println(admDatabase.getName());
	}
}
