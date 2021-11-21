package br.com.healthtrack.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtrack.DAO.FeedDAO;
import br.com.healthtrack.factory.DAOFactory;
import br.com.healthtrack.model.User;

/**
 * Servlet implementation class CadastroAlimentacaoController
 */
@WebServlet("/cad-alimentacao")
public class CadastroAlimentacaoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private FeedDAO feedDAO = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroAlimentacaoController() {
        super();        
        
        feedDAO = DAOFactory.getFeedDAO();
    }   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ola");
		
		// Usuario
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		
		var itemId = request.getParameter("item");
		
		var feedList = feedDAO.ListAll();
		request.setAttribute("alimentos", feedList);			
		
		if (itemId != null) {
			System.out.println("Item preenchido - alterar:" + itemId);
		}
		else {
			System.out.println("Item nao preenchido - criar:" + itemId);
		}
		
		request.getRequestDispatcher("cad-alimentacao.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Ola");
		
		doGet(request, response);
	}

}
