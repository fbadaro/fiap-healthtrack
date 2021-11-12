package br.com.tci.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.tci.Empresa;
import br.com.tci.Plano;
import br.com.tci.Responsavel;
import br.com.tci.singleton.ConnectionManager;

public class EmpresaDAO {

	private String tableName = "TCI_EMPRESA";
	private String tableSequenceName = "EMPRESA_ID_SEQ.NEXTVAL";

	PreparedStatement stmt = null;
	ConnectionManager connection = ConnectionManager.getInstance();

	public void Insert(Empresa empresa) {

		try {

			var query = String.format(
					"INSERT INTO %s (ID, NOME, DESCRICAO, CRIADOEM, PEDIDOMIN, LOGO, INFO, TCI_PLANO_ID, CNPJ, RAZAOSOCIAL, TELEFONE, POSSUIENTREGA, TCI_RESPONSAVEL_ID) "
							+ "VALUES (%s, ?, ?, ?, ?, NULL, ?, ?, ?, ?, ?, ?, ?)",
					tableName, tableSequenceName);

			stmt = connection.GetConnection().prepareStatement(query);

			stmt.setString(1, empresa.getNome());
			stmt.setString(2, empresa.getDescricao());
			stmt.setDate(3, java.sql.Date.valueOf(empresa.getCriadoem()));
			stmt.setDouble(4, empresa.getPedidomin());		
			stmt.setString(5, empresa.getInfo());					
			stmt.setInt(6, empresa.getPlano().getId());
			stmt.setString(7, empresa.getCnpj());
			stmt.setString(8, empresa.getRazaosocial());
			stmt.setString(9, empresa.getTelefone());
			stmt.setBoolean(10, empresa.getPossuientrega() == 'Y' ? true : false);
			stmt.setInt(11, empresa.getResponsavel().getId());

			connection.ExecuteCommand(stmt);

			System.out.println("Empresa adicionada com sucesso!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void InsertRange(List<Empresa> empresas) {

		for (var item : empresas) {
			Insert(item);
		}
	}

//	public Empresa Get(int empresaId) {
//
//		ResultSet resultSet = null;
//		Empresa empresa = null;
//		Plano plano = new Plano();
//		Responsavel responsavel = new Responsavel();
//
//		var query = String.format("SELECT * FROM %s WHERE ID = " + empresaId + " AND ROWNUM = 1", tableName);
//
//		try {
//
//			stmt = connection.GetConnection().prepareStatement(query);
//			resultSet = stmt.executeQuery();
//
//			if (resultSet.next() != false) {
//				empresa = new Empresa(
//						resultSet.getInt("ID"), 
//						resultSet.getString("NOME"),
//						resultSet.getString("DESCRICAO"), 
//						resultSet.getDate("CRIADOEM"),
//						resultSet.getDouble("PEDIDOMIN"), 
//						plano.Get(resultSet.getInt("TCI_PLANO_ID")),
//						resultSet.getString("CNPJ"), 
//						resultSet.getString("RAZAOSOCIAL"),
//						resultSet.getString("TELEFONE"), 
//						resultSet.getString("POSSUIENTREGA").charAt(0),
//						responsavel.Get(resultSet.getInt("TCI_RESPONSAVEL_ID")));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				stmt.close();
//				resultSet.close();
//				connection.CloseConnection();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//
//		return empresa;
//	}

}