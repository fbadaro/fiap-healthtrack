package br.com.tci.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tci.Atendimento;
import br.com.tci.Empresa;
import br.com.tci.Plano;
import br.com.tci.Responsavel;
import br.com.tci.singleton.ConnectionManager;

public class ResponsavelDAO {

	private String tableName = "TCI_RESPONSAVEL";
	private String tableSequenceName = "RESPONSAVEL_ID_SEQ.NEXTVAL";
	
	PreparedStatement stmt = null;
	ConnectionManager connection = ConnectionManager.getInstance();
	
	public void Insert(Responsavel responsavel) {

		try {
			if (!ExistByName(responsavel.getNome())) {
				var query = String.format("INSERT INTO %s (ID, EMAIL, NOME, SOBRENOME, CPF, RG, UF, TERMOS)" 
						+ "VALUES (%s, ?, ?, ?, ?, ?, ?, ?)", tableName, tableSequenceName);

				stmt = connection.GetConnection().prepareStatement(query);

				stmt.setString(1, responsavel.getEmail());
				stmt.setString(2, responsavel.getNome());
				stmt.setString(3, responsavel.getSobrenome());
				stmt.setString(4, responsavel.getCpf());
				stmt.setString(5, responsavel.getRg());
				stmt.setString(6, responsavel.getUf());
				stmt.setBoolean(7, responsavel.getTermos() == 'Y' ? true : false);

				connection.ExecuteCommand(stmt);

				System.out.println("Responsavel adicionado com sucesso!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean ExistByEmail(String usuarioEmail) {
		return ExistBy(usuarioEmail, "EMAIL");
	}
	
	public boolean ExistByName(String usuarioNome) {
		return ExistBy(usuarioNome, "NOME");
	}
	
	public boolean ExistBy(String value, String columnName) {

		ResultSet resultSet = null;
		var itemExist = false;

		var query = String.format("SELECT * FROM %s WHERE %s = '" + value + "' AND ROWNUM = 1", tableName, columnName);

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
	
	public Responsavel GetByEmail(String usuarioEmail) {
		return GetBy(usuarioEmail, "EMAIL");
	}
	
	public Responsavel GetBy(String value, String columnName) {
		
		ResultSet resultSet = null;
		Responsavel responsavel = null;		

		var query = String.format("SELECT * FROM %s WHERE %s = '" + value + "' AND ROWNUM = 1", tableName, columnName);

		try {

			stmt = connection.GetConnection().prepareStatement(query);
			resultSet = stmt.executeQuery();

			if (resultSet.next() != false) {
				
				var id = resultSet.getInt("ID");
				var email = resultSet.getString("EMAIL");
				var nome = resultSet.getString("NOME");
				var sobrenome = resultSet.getString("SOBRENOME");
				var cpf = resultSet.getString("CPF");
				var rg = resultSet.getString("RG");
				var uf = resultSet.getString("UF");
				var termos = resultSet.getString("TERMOS");
				
				responsavel = new Responsavel(id, email, nome, sobrenome, cpf, rg, uf, termos.charAt(0));				
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

		return responsavel;
	}
}
