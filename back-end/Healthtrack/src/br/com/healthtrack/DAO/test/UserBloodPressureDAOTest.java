package br.com.healthtrack.DAO.test;

import java.time.LocalDate;
import java.util.ArrayList;

import br.com.healthtrack.DAO.UserBloodPressureDAO;
import br.com.healthtrack.DAO.UserDAO;
import br.com.healthtrack.factory.DAOFactory;
import br.com.healthtrack.model.UserBloodPressure;

public class UserBloodPressureDAOTest {

	public static void main(String[] args) {

		UserBloodPressureDAO userBloddPressureDAO = DAOFactory.getUserBloodPressureDAO();
		UserDAO userDAO = DAOFactory.getUserDAO();
		
		// INSERT
		var userDatabase = userDAO.Get(4);
		var userPressures = new ArrayList<UserBloodPressure>();
		
//		userPressures.add(new UserBloodPressure(userDatabase, 10, 15, LocalDate.now()));
//		userPressures.add(new UserBloodPressure(userDatabase, 12, 22, LocalDate.now().plusDays(5)));
//		userPressures.add(new UserBloodPressure(userDatabase, 13, 16, LocalDate.now().plusDays(10)));
//		userPressures.add(new UserBloodPressure(userDatabase, 14, 15, LocalDate.now().plusDays(15)));
//		userPressures.add(new UserBloodPressure(userDatabase, 10, 15, LocalDate.now().plusDays(20)));
//		
//		userBloddPressureDAO.InsertRange(userPressures);
		
		// LIST
		var userPressuresDatabase = userBloddPressureDAO.ListAll();
		
		for (var item : userPressuresDatabase) {
			System.out.println(String.format("UserDiastolicPressure: %s UserName: %s", item.getDiastolicPressure(), item.getUser().getName()));
		}
	}
}
