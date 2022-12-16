package exoBriefsJavaBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionBDD {
	
	final static String URL = "jdbc:postgresql://localhost:5432/Entreprise";
	final static String LOGIN = "postgres";
	final static String PASSWORD = "Altarune2001";

	public static Connection connectInstance() {
		Connection connect = null;
		try {
			Class.forName("org.postgresql.Driver");
			connect = DriverManager.getConnection(URL, LOGIN, PASSWORD);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connect;
	}
	
	public static ResultSet query(final Connection connect, final String query) {
		Statement stat;
		ResultSet result = null;
		try {
			stat = connect.createStatement();
			result = stat.executeQuery(query);
		} catch (SQLException e) {
			System.out.println("Erreur dans la requête");
		}
		return result;
	}

	public static void Update(final Connection connect, final String query) {
		Statement stat;
		try {
			stat = connect.createStatement();
			stat.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erreur dans la requête");
		}
	}
}