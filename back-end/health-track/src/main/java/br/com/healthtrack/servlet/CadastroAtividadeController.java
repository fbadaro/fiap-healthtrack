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


@WebServlet("/atividade")
public class CadastroAtividadeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ActivityDAO activitydao;
    private UserActivityDAO useractivdao;
    private UserDAO userdao;
    
    public CadastroAtividadeController() {
        super();
        activitydao = DAOFactory.getActivityDAO();
        useractivdao = DAOFactory.getUserActivityDAO();
        userdao = DAOFactory.getUserDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var lista = activitydao.ListAll();
		request.setAttribute("lista", lista);
		request.getRequestDispatcher("cad-atividade.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = userdao.GetById(1);
		
		int idActivity = Integer.parseInt(request.getParameter("idActivity"));
		Activity acti = activitydao.Get(idActivity);
		
		LocalDate data = LocalDate.parse(request.getParameter("date"));
		
		String duracao = request.getParameter("duration");
		int duration = useractivdao.durationToInt(duracao);
		
		UserActivity novo = new UserActivity(user, acti, duration, data);
		useractivdao.Insert(novo);
			
		request.getRequestDispatcher("cad-atividade.jsp").forward(request, response);
	}

}
