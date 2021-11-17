package br.com.healthtrack.factory;

import br.com.healthtrack.DAO.*;

public class DAOFactory {

	public static ActivityDAO getActivityDAO() {
		return new ActivityDAO();
	}
	
	public static AddressDAO getAddressDAO() {
		return new AddressDAO();
	}
	
	public static AdministratorDAO getAdministratorDAO() {
		return new AdministratorDAO();
	}
	
	public static FeedDAO getFeedDAO() {
		return new FeedDAO();
	}
	
	public static UserActivityDAO getUserActivityDAO() {
		return new UserActivityDAO();
	}
	
	public static UserBloodPressureDAO getUserBloodPressureDAO() {
		return new UserBloodPressureDAO();
	}
	
	public static UserDAO getUserDAO() {
		return new UserDAO();
	}
	
	public static UserFeedDAO getUserFeedDAO() {
		return new UserFeedDAO();
	}
	
	public static UserWeightDAO getUserWeightDAO() {
		return new UserWeightDAO();
	}
}
