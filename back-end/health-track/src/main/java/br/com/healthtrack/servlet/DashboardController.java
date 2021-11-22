package br.com.healthtrack.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtrack.DAO.UserActivityDAO;
import br.com.healthtrack.DAO.UserFeedDAO;
import br.com.healthtrack.DAO.UserWeightDAO;
import br.com.healthtrack.factory.DAOFactory;
import br.com.healthtrack.model.User;

/**
 * Servlet implementation class DashboardController
 */
@WebServlet("/dash")
public class DashboardController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UserActivityDAO userActivityDAO = null;
	private UserFeedDAO userFeedDAO = null;
	private UserWeightDAO userWeightDAO = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardController() {
        super();          
        
        userActivityDAO = DAOFactory.getUserActivityDAO();
        userFeedDAO = DAOFactory.getUserFeedDAO();
        userWeightDAO = DAOFactory.getUserWeightDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			// Usuario
			User currentUser = (User) request.getSession().getAttribute("currentUser");
			
			var userActivityList = userActivityDAO.ListAllByUserId(currentUser.getId());
			request.setAttribute("userActivityList", userActivityList);
						
			var userFeedList = userFeedDAO.ListAllByUserId(currentUser.getId());
			request.setAttribute("userFeedList", userFeedList);	
			
			var imcList = userWeightDAO.IMC(currentUser.getId());
			request.setAttribute("imcList", imcList);
			
			var imcMonth = userWeightDAO.imcByMonth(currentUser.getId());
			request.setAttribute("imcMonth", imcMonth);
						
			request.getRequestDispatcher("dash.jsp").forward(request, response);
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
