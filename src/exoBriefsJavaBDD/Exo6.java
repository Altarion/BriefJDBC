package exoBriefsJavaBDD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Statement;

public class Exo6 {
	
	public static void main(String[] args) {
		Connection connect = ConnectionBDD.connectInstance();
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("Saisissez une année");
			int userInput = in.nextInt();
			Statement statement = connect.createStatement();  
			ResultSet resultSet = statement.executeQuery(
					"SELECT * FROM emp WHERE EXTRACT(YEAR FROM embauche) = '" + userInput + "'");
			while (resultSet.next()) {
				StringBuilder result = new StringBuilder();
				result.append("Nom : ").append(resultSet.getString("nom")).append(", Prénom : ")
						.append(resultSet.getString("prenom")).append(", Poste : ").append(resultSet.getString("emploi"))
						.append(", Date d'embauche : ").append(resultSet.getDate("embauche"));

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
