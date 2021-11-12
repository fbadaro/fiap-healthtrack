package br.com.tci.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tci.Responsavel;
import br.com.tci.DAO.ResponsavelDAO;

/**
 * Servlet implementation class CadResponsavelController
 */
@WebServlet("/cadastro-responsavel")
public class CadResponsavelController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ResponsavelDAO responsavelDAO;	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadResponsavelController() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String userEmail = request.getParameter("txtEmail");
			String userCelular = request.getParameter("txtCelular");
			String userNome = request.getParameter("txtNome");
			String userSobrenome = request.getParameter("txtSobrenome");
			String userCPF = request.getParameter("txtCPF");
			String userRG = request.getParameter("txtRG");
			String userUF = request.getParameter("ddlUF");			
			String userTermos = request.getParameter("chkTermos") == null ? "N" : "Y";					
			
			Responsavel user = new Responsavel(userEmail, userNome, userSobrenome, userCPF, userRG, userUF, userTermos.charAt(0));			
			responsavelDAO.Insert(user);			
			Responsavel currentUserInfo = responsavelDAO.GetByEmail(userEmail);
			
			request.getSession().setAttribute("currentUser", currentUserInfo);			
			response.sendRedirect("cadastro-empresa");				
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			request.setAttribute("error", "Erro ao cadastrar o usuario");
			request.getRequestDispatcher("cadastro-responsavel.jsp").forward(request, response);
		}
	}

}
