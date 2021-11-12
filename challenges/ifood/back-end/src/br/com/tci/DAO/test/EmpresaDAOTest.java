package br.com.tci.DAO.test;

import java.time.LocalDate;

import br.com.tci.Empresa;
import br.com.tci.Plano;
import br.com.tci.Responsavel;
import br.com.tci.DAO.EmpresaDAO;
import br.com.tci.DAO.PlanoDAO;
import br.com.tci.DAO.ResponsavelDAO;

public class EmpresaDAOTest {

	public static void main(String[] args) {
						
		PlanoDAO planoDAO = new PlanoDAO();
		Plano plano = new Plano("Plano DAO Test", 150.00);
		planoDAO.Insert(plano);		
		Plano planoDatabase = planoDAO.GetByName("Plano DAO Test");
		
		ResponsavelDAO responsavelDAO = new ResponsavelDAO();
		Responsavel responsavel = new Responsavel("fabio@ifood.com", "Fabio DAO Test", "Badaro", "358.937.658-93", "41.585.179-8", "SP", 'Y');
		responsavelDAO.Insert(responsavel);
		Responsavel responsavelDatabase = responsavelDAO.GetByEmail("fabio@ifood.com");
		
		EmpresaDAO empresaDAO = new EmpresaDAO();
		Empresa empresa = new Empresa("Empresa DAO", "Empresa Descricao", LocalDate.now(), 15.00, planoDatabase, "CNPJ", "Razao Socila", "Telefone", 'Y', responsavelDatabase);
		empresaDAO.Insert(empresa);
		
	}
}
