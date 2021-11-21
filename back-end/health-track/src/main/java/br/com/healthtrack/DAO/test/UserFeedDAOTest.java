package br.com.healthtrack.DAO.test;

import java.time.LocalDate;
import java.util.ArrayList;

import br.com.healthtrack.DAO.FeedDAO;
import br.com.healthtrack.DAO.UserDAO;
import br.com.healthtrack.DAO.UserFeedDAO;
import br.com.healthtrack.factory.DAOFactory;
import br.com.healthtrack.model.UserFeed;

public class UserFeedDAOTest {

	public static void main(String[] args) {

		UserFeedDAO userFeedDAO = DAOFactory.getUserFeedDAO();
		FeedDAO feedDAO = DAOFactory.getFeedDAO();
		UserDAO userDAO = DAOFactory.getUserDAO();
		
		// INSERT
		var feedsDatabase = feedDAO.ListAll();
		var userDatabase = userDAO.GetById(1);	
		var userFeeds = new ArrayList<UserFeed>();
		
		for(var item : feedsDatabase) {
			userFeeds.add(new UserFeed(userDatabase, item, 10, 2, LocalDate.now(), 1.0));
		}
		
		userFeedDAO.InsertRange(userFeeds);
		
		// LIST
		var userFeedsDatabase = userFeedDAO.ListAll();
		
		for(var item : userFeedsDatabase) {
			System.out.println(item.getFeed().getName());
		}
	}

}
