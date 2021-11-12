package br.com.tci.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tci.Cardapio;
import br.com.tci.Empresa;
import br.com.tci.singleton.ConnectionManager;

public class CardapioDAO {

	private String tableName = "TCI_CARDAPIO";
	private String tableSequenceName = "CARDAPIO_ID_SEQ.NEXTVAL";

	PreparedStatement stmt = null;
	ConnectionManager connection = ConnectionManager.getInstance();

	public void Insert(Cardapio cardapio) {

		try {

			var query = String.format(
					"INSERT INTO %s (ID, TITULO, DESTAQUE, CRIADOEM, TCI_EMPRESA_ID) " + "VALUES (%s, ?, ?, ?, ?)",
					tableName, tableSequenceName);

			stmt = connection.GetConnection().prepareStatement(query);

			stmt.setString(1, cardapio.getTitulo());
			stmt.setString(2, String.valueOf(cardapio.getDestaque()));
			stmt.setDate(3, cardapio.getCriadoem());
			stmt.setInt(9, cardapio.getEmpresaid().getId());

			connection.ExecuteCommand(stmt);

			System.out.println("Cardapio adicionado com sucesso!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void InsertRange(List<Cardapio> cardapios) {

		for (var item : cardapios) {
			Insert(item);
		}
	}

	public List<Cardapio> ListAll() {

		Empresa empresa = new Empresa();
		List<Cardapio> listaCardapio = new ArrayList<Cardapio>();
		ResultSet resultSet = null;

		try {

			var query = String.format("SELECT * FROM %s", tableName);

			stmt = connection.GetConnection().prepareStatement(query);
			resultSet = stmt.executeQuery();

			while (resultSet.next()) {

				Cardapio cardapio = new Cardapio(
						resultSet.getInt("ID"), 
						resultSet.getString("TITULO"),
						resultSet.getString("DESTAQUE").charAt(0), 
						resultSet.getDate("CRIADOEM"),
						empresa.Get(resultSet.getInt("TCI_EMPRESA_ID")));

				listaCardapio.add(cardapio);

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

		return listaCardapio;
	}
	
}
