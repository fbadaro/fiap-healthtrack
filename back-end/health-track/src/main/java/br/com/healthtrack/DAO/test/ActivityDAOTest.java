package br.com.healthtrack.DAO.test;

import java.util.ArrayList;

import br.com.healthtrack.DAO.ActivityDAO;
import br.com.healthtrack.model.Activity;
import br.com.healthtrack.factory.DAOFactory;

public class ActivityDAOTest {

	public static void main(String[] args) {
		
		ActivityDAO activityDAO = DAOFactory.getActivityDAO();
		
		// INSERT
		var activities = new ArrayList<Activity>();
		
		activities.add(new Activity("Corrida"));
		activities.add(new Activity("Natacao"));
		activities.add(new Activity("Volei"));
		activities.add(new Activity("Futebol"));
		activities.add(new Activity("Caminhada"));
		activities.add(new Activity("Bicicleta"));
		activities.add(new Activity("Ginastica"));
		activities.add(new Activity("Danca"));
		activities.add(new Activity("Musculacao"));
		activities.add(new Activity("Luta"));
		
		activityDAO.InsertRange(activities);
		
		// LIST
		var activitiesDatabase = activityDAO.ListAll();		
		
		for(var item : activitiesDatabase) {
			System.out.println(item.getName());
		}
	}
}
