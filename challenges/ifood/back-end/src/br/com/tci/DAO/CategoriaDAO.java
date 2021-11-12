package br.com.tci.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tci.Categoria;
import br.com.tci.singleton.ConnectionManager;

public class CategoriaDAO {

	private String tableName = "TCI_CATEGORIA";
	private String tableSequenceName = "CATEGORIA_ID_SEQ.NEXTVAL";

	PreparedStatement stmt = null;
	ConnectionManager connection = ConnectionManager.getInstance();

	public void Insert(Categoria categoria) {

		try {
			if (!ExistByName(categoria.getNome())) {
				
				var query = String.format("INSERT INTO %s (ID, NOME) " + "VALUES (%s, ?)", tableName, tableSequenceName);

				stmt = connection.GetConnection().prepareStatement(query);

				stmt.setString(1, categoria.getNome());

				connection.ExecuteCommand(stmt);

				System.out.println("Categoria adicionada com sucesso!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void InsertRange(List<Categoria> categorias) {

		for (var item : categorias) {
			Insert(item);
		}
	}

	public boolean ExistByName(String categoriaNome) {

		ResultSet resultSet = null;
		var itemExist = false;

		var query = String.format("SELECT * FROM %s WHERE NOME = '" + categoriaNome + "' AND ROWNUM = 1", tableName);

		try {

			stmt = connection.GetConnection().prepareStatement(query);
			resultSet = stmt.executeQuery();

			if (resultSet.next() != false) {
				itemExist = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				resultSet.close();
				connection.CloseConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return itemExist;
	}

	public List<Categoria> ListAll() {

		List<Categoria> listaCategoria = new ArrayList<Categoria>();
		ResultSet resultSet = null;

		try {

			var query = String.format("SELECT * FROM %s", tableName);

			stmt = connection.GetConnection().prepareStatement(query);
			resultSet = stmt.executeQuery();

			while (resultSet.next()) {

				Categoria categoria = new Categoria(resultSet.getInt("ID"), resultSet.getString("NOME"));
				
				listaCategoria.add(categoria);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				resultSet.close();
				connection.CloseConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return listaCategoria;
	}

}
