package br.com.tci.servlet;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tci.Categoria;
import br.com.tci.Empresa;
import br.com.tci.Plano;
import br.com.tci.Responsavel;
import br.com.tci.DAO.CategoriaDAO;
import br.com.tci.DAO.EmpresaDAO;
import br.com.tci.DAO.PlanoDAO;
import br.com.tci.DAO.ResponsavelDAO;

/**
 * Servlet implementation class CadEmpresaController
 */
@WebServlet("/cadastro-empresa")
public class CadEmpresaController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private CategoriaDAO categoriaDAO;
	private EmpresaDAO empresaDAO;
	private PlanoDAO planoDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadEmpresaController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	
    	categoriaDAO = new CategoriaDAO();
    	empresaDAO = new EmpresaDAO();
    	planoDAO = new PlanoDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			
		
		try {			
			List<Categoria> listaCategorias = categoriaDAO.ListAll();					
			request.setAttribute("categorias", listaCategorias);	
			
			request.getRequestDispatcher("cadastro-empresa.jsp").forward(request, response);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {						
		
		try {
			// Responsavel
			Responsavel currentUser = (Responsavel) request.getSession().getAttribute("currentUser");			
			
			// Plano
			Plano plano = planoDAO.ListAll().get(0);
			
			// Empresa
			String companyCNPJ = request.getParameter("txtCNPJ");
			String companyRazaoSocial = request.getParameter("txtRazaoSocial");
			String companyNome = request.getParameter("txtNome");
			String companyTelefone = request.getParameter("txtTelefone");
			String companyDescricao = request.getParameter("txtDescricao");
			Double companyPedidoMin = Double.parseDouble(request.getParameter("ddlEspecialidade"));
			String companyEntrega = request.getParameter("chkEntrega") == null ? "N" : "Y";			
			
			// Endereco
			String companyCEP = request.getParameter("txtCEP");
			String companyUF = request.getParameter("ddlUF");
			String companyCidade = request.getParameter("ddlCidade");
			String companyEndereco = request.getParameter("txtEndereco");
			int companyNumero = Integer.parseInt(request.getParameter("txtNumero"));
			int companyEspecialidade = Integer.parseInt(request.getParameter("ddlEspecialidade"));												
			
			Empresa company = new Empresa(companyNome, companyDescricao, LocalDate.now(), companyPedidoMin, plano, companyCNPJ, 
					companyRazaoSocial, companyTelefone, companyEntrega.charAt(0), currentUser);	
			
			empresaDAO.Insert(company);					
			
			request.getSession().setAttribute("currentCompany", company);						
			response.sendRedirect("dashboard");	
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			request.setAttribute("error", "Erro ao cadastrar a empresa");
			request.getRequestDispatcher("cadastro-empresa.jsp").forward(request, response);
		}		
	}

}
