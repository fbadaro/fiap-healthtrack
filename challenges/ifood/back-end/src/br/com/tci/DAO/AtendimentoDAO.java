package br.com.tci.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tci.Atendimento;
import br.com.tci.Empresa;
import br.com.tci.singleton.ConnectionManager;

public class AtendimentoDAO {

	private String tableName = "TCI_ATENDIMENTO";
	private String tableSequenceName = "ATENDIMENTO_ID_SEQ.NEXTVAL";

	PreparedStatement stmt = null;
	ConnectionManager connection = ConnectionManager.getInstance();

	public void Insert(Atendimento atendimento) {

		try {

			var query = String.format(
					"INSERT INTO %s (ID, SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA, SABADO, DOMINGO, FERIADO, TCI_EMPRESA_ID) "
							+ "VALUES (%s, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
					tableName, tableSequenceName);

			stmt = connection.GetConnection().prepareStatement(query);

			stmt.setString(1, atendimento.getSegunda());
			stmt.setString(2, atendimento.getTerca());
			stmt.setString(3, atendimento.getQuarta());
			stmt.setString(4, atendimento.getQuinta());
			stmt.setString(5, atendimento.getSexta());
			stmt.setString(6, atendimento.getSabado());
			stmt.setString(7, atendimento.getDomingo());
			stmt.setString(8, atendimento.getFeriado());
			stmt.setInt(9, atendimento.getEmpresaid().getId());

			connection.ExecuteCommand(stmt);

			System.out.println("Atendimento adicionado com sucesso!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void InsertRange(List<Atendimento> atendimentos) {

		for (var item : atendimentos) {
			Insert(item);
		}
	}

	public List<Atendimento> ListAll() {

		Empresa empresa = new Empresa();
		List<Atendimento> listaAtendimento = new ArrayList<Atendimento>();
		ResultSet resultSet = null;

		try {

			var query = String.format("SELECT * FROM %s", tableName);

			stmt = connection.GetConnection().prepareStatement(query);
			resultSet = stmt.executeQuery();

			while (resultSet.next()) {

				Atendimento atendimento = new Atendimento(resultSet.getInt("ID"), resultSet.getString("SEGUNDA"),
						resultSet.getString("TERCA"), resultSet.getString("QUARTA"), resultSet.getString("QUINTA"),
						resultSet.getString("SEXTA"), resultSet.getString("SABADO"), resultSet.getString("DOMINGO"),
						resultSet.getString("FERIADO"), empresa.Get(resultSet.getInt("TCI_EMPRESA_ID")));

				listaAtendimento.add(atendimento);

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

		return listaAtendimento;
	}

	public Atendimento Get(int atendimentoID) {

		ResultSet resultSet = null;
		Atendimento atendimento = null;
		Empresa empresa = new Empresa();

		var query = String.format("SELECT * FROM %s WHERE ID = " + atendimentoID, tableName);

		try {

			stmt = connection.GetConnection().prepareStatement(query);
			resultSet = stmt.executeQuery();

			if (resultSet.next() != false) {

				int empresaID = resultSet.getInt("TCI_EMPRESA_ID");

				atendimento = new Atendimento(resultSet.getInt("ID"), resultSet.getString("SEGUNDA"),
						resultSet.getString("TERCA"), resultSet.getString("QUARTA"), resultSet.getString("QUINTA"),
						resultSet.getString("SEXTA"), resultSet.getString("SABADO"), resultSet.getString("DOMINGO"),
						resultSet.getString("FERIADO"), empresa.Get(resultSet.getInt("TCI_EMPRESA_ID")));
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

		return atendimento;
	}

}