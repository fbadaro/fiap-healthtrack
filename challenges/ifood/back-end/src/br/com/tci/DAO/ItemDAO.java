package br.com.tci.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tci.Cardapio;
import br.com.tci.Item;
import br.com.tci.singleton.ConnectionManager;

public class ItemDAO {

	private String tableName = "TCI_ITEM";
	private String tableSequenceName = "ITEM_ID_SEQ.NEXTVAL";

	PreparedStatement stmt = null;
	ConnectionManager connection = ConnectionManager.getInstance();

	public void Insert(Item item) {

		try {

			var query = String.format("INSERT INTO %s (ID, NOME, DESCRICAO, PRECO, CRIADOEM, TCI_CARDAPIO_ID) "
					+ "VALUES (%s, ?, ?, ?, ?, ?)", tableName, tableSequenceName);

			stmt = connection.GetConnection().prepareStatement(query);

			stmt.setString(1, item.getNome());
			stmt.setString(2, item.getDescricao());
			stmt.setDouble(3, item.getPreco());
			stmt.setDate(4, item.getCriadoem());
			stmt.setInt(5, item.getCardapio().getId());

			connection.ExecuteCommand(stmt);

			System.out.println("Item adicionado com sucesso!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void InsertRange(List<Item> itens) {

		for (var item : itens) {
			Insert(item);
		}
	}

	public List<Item> ListAll() {

		Cardapio cardapio = new Cardapio();
		List<Item> listaItem = new ArrayList<Item>();
		ResultSet resultSet = null;

		try {

			var query = String.format("SELECT * FROM %s", tableName);

			stmt = connection.GetConnection().prepareStatement(query);
			resultSet = stmt.executeQuery();

			while (resultSet.next()) {

				Item item = new Item(resultSet.getInt("ID"), resultSet.getString("NOME"),
						resultSet.getString("DESCRICAO"), resultSet.getDouble("PRECO"), resultSet.getDate("CRIADOEM"),
						cardapio.Get(resultSet.getInt("TCI_CARDAPIO_ID")));

				listaItem.add(item);

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

		return listaItem;
	}

}