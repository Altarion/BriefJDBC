package exoBriefsJavaBDD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Statement;

public class Exo8 {

	public static void main(String[] args) {
		Connection connect = ConnectionBDD.connectInstance();
		
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("Saisissez un nom de service :");
			String userServInput = in.nextLine().toUpperCase();
			System.out.println("Saisissez un salaire :");
			int userSalInput = in.nextInt();
			Statement statement = connect.createStatement();
			ResultSet query = statement.executeQuery("SELECT nom , emploi, sal, noserv FROM emp WHERE noserv IN (SELECT noserv FROM serv WHERE service = '" + userServInput + "'" + ") AND sal >'"  + userSalInput + "'");
			while (query.next()) {
				StringBuilder result = new StringBuilder();
				result.append("Nom : ").append(query.getString("nom")).append(", Emploi : ").append(query.getString("emploi")).append(", Salaire : ").append(query.getInt("sal")).append(", N° de Service : ").append(query.getString("noserv"));

				System.out.println(result);
			}
			connect.close();
			in.close();
		} catch (SQLException e) {
			System.out.println("_______________________________");
			System.out.println("|Une erreur SQL s'est produite|");
			System.out.println("|_____________________________|");
			e.printStackTrace();
		}
	}
	
}
