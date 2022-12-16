package exoBriefsJavaBDD;

import java.sql.Connection;
import java.sql.SQLException;

public class Exo1 {

	public static void main(String[] args) {
		
		Connection connect = ConnectionBDD.connectInstance();
		try {
			connect.close();
		} catch (SQLException e) {
			System.out.println("_______________________________");
			System.out.println("|Une erreur SQL s'est produite|");
			System.out.println("|_____________________________|");
			e.printStackTrace();
		}
	}
}