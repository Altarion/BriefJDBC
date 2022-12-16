package exoBriefsJavaBDD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Statement;

public class Exo7{
	
	public static void main(String[] args) {
		Connection connect = ConnectionBDD.connectInstance();
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("Saisissez un nom ou une partie de nom");
			String userInput = in.nextLine().toUpperCase();
			Statement statement = connect.createStatement();  
			ResultSet query = statement.executeQuery("SELECT * FROM emp WHERE nom LIKE '" + "%" + userInput + "%'");
			while (query.next()) {
				StringBuilder result = new StringBuilder();
				result.append("Nom : ").append(query.getString("nom")).append(", Prénom : ")
						.append(query.getString("prenom")).append(", Poste : ").append(query.getString("emploi"));

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
