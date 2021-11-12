package br.com.tci.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tci.Plano;
import br.com.tci.Responsavel;
import br.com.tci.singleton.ConnectionManager;

public class PlanoDAO {

	private String tableName = "TCI_PLANO";
	private String tableSequenceName = "PLANO_ID_SEQ.NEXTVAL";

	PreparedStatement stmt = null;
	ConnectionManager connection = ConnectionManager.getInstance();

	public void Insert(Plano plano) {

		try {
			if (!ExistByName(plano.getNome())) {
				var query = String.format("INSERT INTO %s (ID, NOME, PRECO) " + "VALUES (%s, ?, ?)", tableName,
						tableSequenceName);

				stmt = connection.GetConnection().prepareStatement(query);

				stmt.setString(1, plano.getNome());
				stmt.setDouble(2, plano.getPreco());

				connection.ExecuteCommand(stmt);

				System.out.println("Plano adicionado com sucesso!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void InsertRange(List<Plano> planos) {

		for (var item : planos) {
			Insert(item);
		}
	}

	public boolean ExistByName(String planoNome) {

		ResultSet resultSet = null;
		var itemExist = false;

		var query = String.format("SELECT * FROM %s WHERE NOME = '" + planoNome + "' AND ROWNUM = 1", tableName);

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

	public List<Plano> ListAll() {

		List<Plano> listaPlano = new ArrayList<Plano>();
		ResultSet resultSet = null;

		try {

			var query = String.format("SELECT * FROM %s", tableName);

			stmt = connection.GetConnection().prepareStatement(query);
			resultSet = stmt.executeQuery();

			while (resultSet.next()) {

				Plano plano = new Plano(resultSet.getInt("ID"), resultSet.getString("NOME"), resultSet.getDouble("PRECO"));
				listaPlano.add(plano);
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

		return listaPlano;
	}
	
	public Plano GetByName(String nomePlano) {
		return GetBy(nomePlano, "NOME");
	}
	
	public Plano GetBy(String value, String columnName) {
		
		ResultSet resultSet = null;
		Plano plano = null;		

		var query = String.format("SELECT * FROM %s WHERE %s = '" + value + "' AND ROWNUM = 1", tableName, columnName);

		try {

			stmt = connection.GetConnection().prepareStatement(query);
			resultSet = stmt.executeQuery();

			if (resultSet.next() != false) {
				plano = new Plano(resultSet.getInt("ID"), resultSet.getString("NOME"), resultSet.getDouble("PRECO"));				
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

		return plano;
	}

}