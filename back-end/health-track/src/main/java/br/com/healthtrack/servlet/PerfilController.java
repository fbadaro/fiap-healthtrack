package br.com.healthtrack.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtrack.DAO.UserDAO;
import br.com.healthtrack.factory.DAOFactory;
import br.com.healthtrack.model.User;

/**
 * Servlet implementation class PerfilController
 */
@WebServlet("/perfil")
public class PerfilController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UserDAO currentUserDAO = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PerfilController() {
        super();
        
        currentUserDAO = DAOFactory.getUserDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Usuario
		User currentUser = (User) request.getSession().getAttribute("currentUser");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Usuario
		User currentUser = (User) request.getSession().getAttribute("currentUser");
				
		String userName = request.getParameter("txtName");
		String userEmail = request.getParameter("txtEmail");		
		
		LocalDate userBirthday = LocalDate.parse(request.getParameter("txtBirthday").replace('-', '/'), DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		
		Double userHeight = Double.parseDouble(request.getParameter("txtHeight"));
		Double userWeight = Double.parseDouble(request.getParameter("txtWeight"));
		
		var user = new User(currentUser.getId(), userName, userEmail, currentUser.getLogin(), currentUser.getPass(), userHeight, userWeight, userBirthday);			
		var updatedUser = currentUserDAO.Update(user);	
		
		request.getSession().setAttribute("currentUser", updatedUser);			
		response.sendRedirect("dash");
	}

}
