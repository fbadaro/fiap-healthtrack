package br.com.healthtrack.DAO.test;

import java.time.LocalDate;
import java.util.ArrayList;

import br.com.healthtrack.DAO.ActivityDAO;
import br.com.healthtrack.DAO.UserActivityDAO;
import br.com.healthtrack.DAO.UserDAO;
import br.com.healthtrack.factory.DAOFactory;
import br.com.healthtrack.model.UserActivity;

public class UserActivityDAOTest {

	public static void main(String[] args) {
		
		UserActivityDAO userActivityDAO = DAOFactory.getUserActivityDAO();
		ActivityDAO activityDAO = DAOFactory.getActivityDAO();
		UserDAO userDAO = DAOFactory.getUserDAO();		
		
		// INSERT
//		var activitiesDatabase = activityDAO.ListAll();		
//		var userDatabase = userDAO.GetById(1);		
//		var userActivities = new ArrayList<UserActivity>();
//		
//		for(var item : activitiesDatabase) {
//			userActivities.add(new UserActivity(userDatabase, item, 60, LocalDate.now()));					
//		}
//		
//		userActivityDAO.InsertRange(userActivities);
		
		// LIST
		var userActivitiesDatabase = userActivityDAO.ListAllByUserId(21);
		
		for(var item : userActivitiesDatabase) {
			System.out.println(item.getActivity().getName());
			System.out.println(item.getActivityDuration());
		}
	}

}
