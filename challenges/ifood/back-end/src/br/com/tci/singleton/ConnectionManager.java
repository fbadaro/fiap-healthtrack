package br.com.tci.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionManager {

	private static ConnectionManager connectionManager;
	private Connection connection;

	private ConnectionManager() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static ConnectionManager getInstance() {
		if (connectionManager == null) {
			connectionManager = new ConnectionManager();
		}
		return connectionManager;
	}

	public Connection GetConnection() {
		OpenConnection();
		return this.connection;

	}

	private void OpenConnection() {
		try {
			String host = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String pass = "oracle";
			this.connection = DriverManager.getConnection(host, user, pass);
			
			// this.connection =
			// DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system",
			// "oracle");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void CloseConnection() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int ExecuteCommand(PreparedStatement stmt) {
		int qtd = 0;
		try {
			qtd = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			CloseConnection();
		}
		return qtd;
	}

}
