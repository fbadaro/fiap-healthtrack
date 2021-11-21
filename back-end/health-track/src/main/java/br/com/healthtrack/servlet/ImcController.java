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
		//User currentUser = (User) request.getSession().getAttribute("currentUser");
		
		//User mockado enquanto nao for passado no session no login
		String action = request.getParameter("action");
		
		switch(action) {
		case "list":
				User currentUser= userDAO.GetById(1);		
				
				//int id = Integer.parseInt(request.getParameter("codigo")); verificar se � isso ou se � pra pegar da session o id
				int id = currentUser.getId();
				UserWeight userweight = weightDAO.Get(id);
				
				request.setAttribute("imc", userweight);
				request.getRequestDispatcher("cad-imc.jsp").forward(request, response);			
			break;
		
		}
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			//User
			//User currentUser = (User) request.getSession().getAttribute("currentUser");
			
			//User mockado enquanto nao for passado no session no login
			User currentUser= userDAO.GetById(1);	
			Double currentHeight = currentUser.getHeight();
			System.out.println(currentHeight);
			
			
			if (currentHeight != 0.0 ) {
				edit(request, response);
			}
			else {
				insert(request, response);
			}
			
			//usar case se for mexer direto no jsp (outra alternativa)
			
//			String action = request.getParameter("action");
//			
//			switch(action) {
//			case "insert":
//				insert(request, response);
//				break;
//			case "edit":
//				edit(request, response);
//				break;
//			}
			
//			
//			if (currentHeight !=  height) {
//				int userID = currentUser.getId();
//				
////				criar atualizar no userDAO
////				criar atualizar no userWeightDAO
//				User user = new User(userID, height);
//				
//				
//			}
//			
			
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
			//User currentUser = (User) request.getSession().getAttribute("currentUser");
			
			//User mockado enquanto nao for passado no session no login
			User currentUser= userDAO.GetById(1);	
			Double currentHeight = currentUser.getHeight();
			
			
			double height = Double.parseDouble(request.getParameter("height"));
			double weight = Double.parseDouble(request.getParameter("weight"));
			LocalDate weightdate = LocalDate.parse(request.getParameter("date"));
			
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
			//User currentUser = (User) request.getSession().getAttribute("currentUser");
			
			//User mockado enquanto nao for passado no session no login
			User currentUser= userDAO.GetById(1);	
			//Pegar peso do usu�rio logado
			Double currentHeight = currentUser.getHeight();
			
			double height = Double.parseDouble(request.getParameter("height"));
			double weight = Double.parseDouble(request.getParameter("weight"));
			LocalDate weightdate = LocalDate.parse(request.getParameter("date"));
			
			
			UserWeight userweight = new UserWeight(0,currentUser, height, weight, weightdate);
			
			weightDAO.edit(userweight);
			
			
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Valide os dados digitados");
		}
		//request.getRequestDispatcher("cad-imc.jsp").forward(request, response);
	}
}


