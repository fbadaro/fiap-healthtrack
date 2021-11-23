package br.com.healthtrack.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtrack.DAO.ActivityDAO;
import br.com.healthtrack.DAO.UserActivityDAO;
import br.com.healthtrack.DAO.UserDAO;
import br.com.healthtrack.factory.DAOFactory;
import br.com.healthtrack.model.Activity;
import br.com.healthtrack.model.User;
import br.com.healthtrack.model.UserActivity;
import br.com.healthtrack.model.UserFeed;


@WebServlet("/atividade")
public class CadastroAtividadeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ActivityDAO activitydao;
    private UserActivityDAO useractivdao;
    
    public CadastroAtividadeController() {
        super();
        activitydao = DAOFactory.getActivityDAO();
        useractivdao = DAOFactory.getUserActivityDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		
		var itemId = request.getParameter("item");
		
		var lista = activitydao.ListAll();
		request.getSession().setAttribute("lista", lista);	
		
		if (itemId != null) {
			UserActivity usactivi =  useractivdao.GetById(Integer.parseInt(itemId));
			request.setAttribute("userActi", usactivi);			
			
		}
		
		request.getRequestDispatcher("cad-atividade.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User user = (User) request.getSession().getAttribute("currentUser");
			
			Integer usActiId = request.getParameter("txtUsFeedId") != "" 
					? Integer.parseInt(request.getParameter("txtUsFeedId"))
					: 0;	
			
			int idActivity = Integer.parseInt(request.getParameter("idActivity"));
			Activity acti = activitydao.Get(idActivity);
			
			LocalDate data = LocalDate.parse(request.getParameter("date"));
			
			String duracao = request.getParameter("duration");
			int duration = useractivdao.durationToInt(duracao);
			
			if (usActiId == 0) {
				UserActivity novo = new UserActivity(user, acti, duration, data);
				useractivdao.Insert(novo);
				request.setAttribute("msg", "Atividade cadastrada!");
			} 
			else {				
				UserActivity novo = new UserActivity(usActiId,user, acti, duration, data);
				useractivdao.Update(novo);
				
				request.setAttribute("userActi", novo);	
				request.setAttribute("msg", "Atividade atualizada!");
			}	
						
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Valide os dados digitados");
		}
		
		request.getRequestDispatcher("cad-atividade.jsp").forward(request, response);
	}

}
