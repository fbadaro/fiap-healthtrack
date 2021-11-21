package br.com.healthtrack.DAO.test;

import java.time.LocalDate;
import java.util.ArrayList;

import br.com.healthtrack.DAO.UserDAO;
import br.com.healthtrack.DAO.UserWeightDAO;
import br.com.healthtrack.factory.DAOFactory;
import br.com.healthtrack.model.UserWeight;

public class UserWeightDAOTest {

	public static void main(String[] args) {
		
		UserWeightDAO userWeightDAO = DAOFactory.getUserWeightDAO();
		UserDAO userDAO = DAOFactory.getUserDAO();		
		
		// INSERT
		var userDatabase = userDAO.GetById(25);
//		var userWeights = new ArrayList<UserWeight>();
//				
//		userWeights.add(new UserWeight(userDatabase, 67.5, 1.67, LocalDate.now()));
//		userWeights.add(new UserWeight(userDatabase, 63.9, 1.67, LocalDate.now().plusDays(5)));
//		userWeights.add(new UserWeight(userDatabase, 62.7, 1.67, LocalDate.now().plusDays(10)));
//		userWeights.add(new UserWeight(userDatabase, 61.4, 1.67, LocalDate.now().plusDays(15)));
//		userWeights.add(new UserWeight(userDatabase, 60.2, 1.67, LocalDate.now().plusDays(20)));
//		
//		userWeightDAO.InsertRange(userWeights);
//		
//		// LIST
//		var userWeightDatabase = userWeightDAO.ListAll();
//		
//		for (var item : userWeightDatabase) {
//			System.out.println(String.format("UserWeight: %s UserName: %s", item.getWeight(), item.getUser().getName()));
//		}
		
		
		// EDIT
		UserWeight userweight = new UserWeight(userDatabase, 67.5, 1.67, LocalDate.now());
		userweight = userWeightDAO.Get(25);
		userweight.setWeight(100);
		userweight.setHeight(180);
		userweight.setDate(LocalDate.now());
		try {
			userWeightDAO.edit(userweight);
			System.out.println("peso att");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
