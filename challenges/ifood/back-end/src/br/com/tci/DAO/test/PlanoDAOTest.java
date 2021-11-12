package br.com.tci.DAO.test;

import br.com.tci.Plano;
import br.com.tci.DAO.PlanoDAO;

public class PlanoDAOTest {

	public static void main(String[] args) {
		
		PlanoDAO planoDAO = new PlanoDAO();
		Plano planoBasico = new Plano("Basico", 49.99);
		Plano planoPremium = new Plano("Premium", 149.99);
		
		// Insert Basic Plan
		planoDAO.Insert(planoBasico);
		planoDAO.Insert(planoPremium);
	}

}
