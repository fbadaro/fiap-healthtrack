package br.com.healthtrack.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtrack.DAO.UserDAO;
import br.com.healthtrack.factory.DAOFactory;
import br.com.healthtrack.utils.CryptographyUtils;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UserDAO currentUserDAO = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
			String userEmail = request.getParameter("txtUserEmail");
			String userPass = CryptographyUtils.cryptography(request.getParameter("txtUserPass"));											
			
			if (currentUserDAO.Authenticate(userEmail, userPass)) {
				
				var user = currentUserDAO.GetByEmail(userEmail);	
				
				System.out.println(userEmail);
				System.out.println(userPass);
				
				request.getSession().setAttribute("currentUser", user);	
				response.sendRedirect("dash");
			}
			else {
				request.setAttribute("error", "Usuario ou Senha invalidos");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		catch (Exception ex){
			System.out.println(ex.getMessage());
			request.setAttribute("error", "Erro ao autenticar o usuario");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
