package br.com.healthtrack.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.healthtrack.DAO.UserDAO;
import br.com.healthtrack.DAO.UserWeightDAO;
import br.com.healthtrack.factory.DAOFactory;
import br.com.healthtrack.model.User;
import br.com.healthtrack.model.UserWeight;

/**
 * Servlet implementation class ImcServlet
 */
@WebServlet("/imc")
public class ImcController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserWeightDAO weightDAO;
	private UserDAO userDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public void init() throws ServletException {
        super.init();
        weightDAO = DAOFactory.getUserWeightDAO();
        userDAO = DAOFactory.getUserDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//User
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		

		int id = currentUser.getId();
		UserWeight userweight = weightDAO.Get(id);
				
		request.setAttribute("imc", userweight);
				
		System.out.println(userweight.getHeight());
		request.getRequestDispatcher("cad-imc.jsp").forward(request, response);			
		
		}
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	//}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			//User
			User currentUser = (User) request.getSession().getAttribute("currentUser");			
			Double currentHeight = currentUser.getHeight();
			System.out.println(currentHeight);
			
			String check = request.getParameter("check");
			
			System.out.println(check);
			
			insert(request, response);
			
//			if (currentHeight != 0.0 && check == null ) {
//				edit(request, response);
//			}
//			else {
//				insert(request, response);
//			}
			
			response.sendRedirect("dash.jsp");	
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Valide os dados digitados");
		}
		//request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	}
	
	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			//User
			User currentUser = (User) request.getSession().getAttribute("currentUser");
			Double currentHeight = currentUser.getHeight();
			
			
			double height = Double.parseDouble(request.getParameter("height"));
			double weight = Double.parseDouble(request.getParameter("weight"));
			LocalDate weightdate = LocalDate.parse(request.getParameter("date"));
			String check = request.getParameter("check");
			
			System.out.println(check);
			
			//guardar na session o valor de weight para verificar se est� vazio ou n�o
			HttpSession session = request.getSession();
			session.setAttribute("ImcServlet", weight);
			
			UserWeight userweight = new UserWeight(0,currentUser, height, weight, weightdate);
			weightDAO.Insert(userweight);
			
			
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Valide os dados digitados");
		}
		//request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//User
			User currentUser = (User) request.getSession().getAttribute("currentUser");
			//Double currentHeight = currentUser.getHeight();
			
			int userid = currentUser.getId();
			//UserWeight userweight = weightDAO.Get(userid);
			
			double height = Double.parseDouble(request.getParameter("height"));
			double weight = Double.parseDouble(request.getParameter("weight"));
			LocalDate weightdate = LocalDate.parse(request.getParameter("date"));
			
			UserWeight userweight = weightDAO.Get(userid);
			userweight.setWeight(weight);
			userweight.setHeight(height);
			userweight.setDate(weightdate);
			
			
			//UserWeight userweight = new UserWeight(0,currentUser, height, weight, weightdate);
			
			weightDAO.edit(userweight);
			
			
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Valide os dados digitados");
		}
		//request.getRequestDispatcher("cad-imc.jsp").forward(request, response);
	}
}


