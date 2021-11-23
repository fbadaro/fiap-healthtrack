package br.com.healthtrack.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtrack.DAO.FeedDAO;
import br.com.healthtrack.DAO.UserFeedDAO;
import br.com.healthtrack.factory.DAOFactory;
import br.com.healthtrack.model.Feed;
import br.com.healthtrack.model.User;
import br.com.healthtrack.model.UserFeed;

/**
 * Servlet implementation class CadastroAlimentacaoController
 */
@WebServlet("/cad-alimentacao")
public class CadastroAlimentacaoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private FeedDAO feedDAO = null;
	private UserFeedDAO userFeedDAO = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroAlimentacaoController() {
        super();        
        
        feedDAO = DAOFactory.getFeedDAO();
        userFeedDAO = DAOFactory.getUserFeedDAO();
    }   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// Usuario
			User currentUser = (User) request.getSession().getAttribute("currentUser");
			
			var itemId = request.getParameter("item");
					
			request.setAttribute("feedList", feedDAO.ListAll());			
			
			if (itemId != null) {
				var currentFeed = userFeedDAO.GetById(Integer.parseInt(itemId));
				request.setAttribute("currentFeed", currentFeed);	
			}				
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());			
		}
		
		request.getRequestDispatcher("cad-alimentacao.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {			
			// Usuario
			User currentUser = (User) request.getSession().getAttribute("currentUser");
			
			Integer usFeedId = request.getParameter("txtUsFeedId") != "" 
					? Integer.parseInt(request.getParameter("txtUsFeedId"))
					: 0;					
			
			Integer feedId = Integer.parseInt(request.getParameter("ddlFeed"));
			LocalDate feedDate = LocalDate.parse(request.getParameter("txtDate").replace('-', '/'), DateTimeFormatter.ofPattern("yyyy/MM/dd"));
			Double feedQuantity = Double.parseDouble(request.getParameter("txtQuantity"));
			Double feedCal = Double.parseDouble(request.getParameter("txtCal"));
			Integer feedType = Integer.parseInt(request.getParameter("ddlType"));
			
			Feed selectedFeed = feedDAO.Get(feedId);
						
			request.setAttribute("feedList", feedDAO.ListAll());	
			
			if (usFeedId == 0) {
				var feed = new UserFeed(currentUser, selectedFeed, feedQuantity, feedType, feedDate, feedCal);
				userFeedDAO.Insert(feed);
				request.setAttribute("msg", "Alimetacao cadastrada!");
			} 
			else {				
				var feed = new UserFeed(usFeedId, currentUser, selectedFeed, feedQuantity, feedType, feedDate, feedCal);
				userFeedDAO.Update(feed);
				
				request.setAttribute("currentFeed", feed);	
				request.setAttribute("msg", "Alimetacao atualizada!");
			}											
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			request.setAttribute("error", "Erro ao cadastrar alimentacao");			
		}
		
		request.getRequestDispatcher("cad-alimentacao.jsp").forward(request, response);
	}

}
