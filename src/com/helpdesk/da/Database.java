package com.helpdesk.da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	public Connection Get_Connection() throws Exception {
		try {
			String connectionURL = "jdbc:mariadb://96.9.255.219:3306/eHelpdesk";
			Connection connection = null;
			Class.forName("org.mariadb.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionURL, "dbsi", "k@mpr3t6015");
			return connection;
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}

}
