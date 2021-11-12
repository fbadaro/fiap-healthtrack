package br.com.tci.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tci.Responsavel;
import br.com.tci.DAO.ResponsavelDAO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ResponsavelDAO responsavelDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();

		responsavelDAO = new ResponsavelDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String userEmail = request.getParameter("txtUserEmail");
			String userPass = request.getParameter("txtUserPass");
			
			Responsavel user = responsavelDAO.GetByEmail(userEmail);
			
			if (user != null) {
				request.setAttribute("currentUser", user);
				request.getRequestDispatcher("dashboard.jsp").forward(request, response);
			}
			else {
				request.setAttribute("error", "Usuario ou Senha invalidos");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		catch(Exception e) {
			request.setAttribute("error", "Erro ao autenticar o usuario");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
