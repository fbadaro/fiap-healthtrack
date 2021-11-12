package br.com.healthtrack.DAO.test;

import java.util.ArrayList;

import br.com.healthtrack.DAO.FeedDAO;
import br.com.healthtrack.factory.DAOFactory;
import br.com.healthtrack.model.Feed;

public class FeedDAOTest {

	public static void main(String[] args) {
		
		FeedDAO feedDAO = DAOFactory.getFeedDAO();
		
		// INSERT
		var feeds = new ArrayList<Feed>();
		
		feeds.add(new Feed("Arroz"));
		feeds.add(new Feed("Arroz Carreteiro"));
		feeds.add(new Feed("Arroz a Grega"));
		feeds.add(new Feed("Arroz Integral"));
		feeds.add(new Feed("Feijao Carioca"));
		feeds.add(new Feed("Feijao de Corda"));
		feeds.add(new Feed("Feijao Preto"));
		feeds.add(new Feed("Feijoada"));
		feeds.add(new Feed("Batada"));
		feeds.add(new Feed("Macarrao"));
		
		feedDAO.InserRange(feeds);
		
		// LIST
		var feedsDatabase = feedDAO.ListAll();		
		
		for(var item : feedsDatabase) {
			System.out.println(item.getName());
		}
	}

}
