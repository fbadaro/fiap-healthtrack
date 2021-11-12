package br.com.tci.DAO.test;

import br.com.tci.Responsavel;
import br.com.tci.DAO.ResponsavelDAO;

public class ResponsavelDAOTest {

	public static void main(String[] args) {
		
		ResponsavelDAO responsavelDAO = new ResponsavelDAO();
		Responsavel responsavel = new Responsavel("fabio@ifood.com", "Fabio", "Badaro", "358.937.658-93", "41.585.179-8", "SP", 'Y');
		
		// Insert
		responsavelDAO.Insert(responsavel);
	}

}
