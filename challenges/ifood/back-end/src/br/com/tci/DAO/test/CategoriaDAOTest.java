package br.com.tci.DAO.test;

import java.util.ArrayList;

import br.com.tci.Categoria;
import br.com.tci.DAO.CategoriaDAO;

public class CategoriaDAOTest {

	public static void main(String[] args) {
		
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		
		// INSERT
		var categorias = new ArrayList<Categoria>();
		
		categorias.add(new Categoria("Vegetariana"));
		categorias.add(new Categoria("Vegana"));
		categorias.add(new Categoria("Japonesa"));
		categorias.add(new Categoria("Massas"));
		categorias.add(new Categoria("Pizza"));
		categorias.add(new Categoria("Padaria"));
		categorias.add(new Categoria("Arabe"));
		categorias.add(new Categoria("Salgados"));			
		
		categoriaDAO.InsertRange(categorias);
		
		// List		
		var categoriasDatabase = categoriaDAO.ListAll();
		
		for (Categoria categoria : categoriasDatabase) {
			System.out.println(categoria.getNome());
		}
	}

}
