package br.com.tci.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tci.Nutricionista;

/**
 * Servlet implementation class DashboardNutriController
 */
@WebServlet("/dashboard-nutri")
public class DashboardNutriController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardNutriController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Nutricionista nutri = new Nutricionista("carlos.lobo@nutri.com", "000-000-00-00", "Carlos", "Lobo da Silva", "452.458.485-89", "45.458.487-89", "SP", 'Y');			
			request.getSession().setAttribute("currentNutri", nutri);
			
			
			
			request.getRequestDispatcher("dashboard-nutri.jsp").forward(request, response);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			request.setAttribute("error", "Erro ao resgatar nutricionista");
			request.getRequestDispatcher("dashboard-nutri.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
