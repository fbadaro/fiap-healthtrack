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
 * Servlet implementation class CadastroController
 */
@WebServlet("/cadastro")
public class CadastroController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;	
	private UserDAO currentUserDAO = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroController() {
        super();
        
        currentUserDAO = DAOFactory.getUserDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String userName = request.getParameter("txtName");
			String userEmail = request.getParameter("txtEmail");
			String userLogin = request.getParameter("txtLogin");
			String userPass = request.getParameter("txtPass");
			
			LocalDate userBirthday = LocalDate.parse(request.getParameter("txtBirthday").replace('-', '/'), DateTimeFormatter.ofPattern("yyyy/MM/dd"));
			
			Double userHeight = Double.parseDouble(request.getParameter("txtHeight"));
			Double userWeight = Double.parseDouble(request.getParameter("txtWeight"));
			
			var user = new User(userName, userEmail, userLogin, userPass, userHeight, userWeight, userBirthday);			
			var createdUser = currentUserDAO.Insert(user);			
			
			request.getSession().setAttribute("currentUser", createdUser);			
			response.sendRedirect("dash.jsp");	
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			request.setAttribute("error", "Erro ao cadastrar o usuario");
			request.getRequestDispatcher("cadastro.jsp").forward(request, response);
		}
	}

}
