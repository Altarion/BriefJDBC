package exoBriefsJavaBDD;

import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exo5 {
	
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);

		Connection connect = ConnectionBDD.connectInstance();
		
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("Veuillez saisir le nom voulu : ");
 			String userInput = in.nextLine().toUpperCase();
			Statement statement = connect.createStatement();                                     
			ResultSet resultSet = statement.executeQuery("SELECT * FROM emp WHERE nom LIKE '" + userInput + "'");
			while (resultSet.next()) {
				StringBuilder result = new StringBuilder();
				result.append("Nom : ").append(resultSet.getString("nom")).append(", Prénom : ")
						.append(resultSet.getString("prenom")).append(", Poste : ").append(resultSet.getString("emploi"));

				System.out.println(result);
			}
			connect.close();
			scanner.close();
			in.close();
		} catch (SQLException e) {
			System.out.println("_______________________________");
			System.out.println("|Une erreur SQL s'est produite|");
			System.out.println("|_____________________________|");
			e.printStackTrace();
		}
	}
}
