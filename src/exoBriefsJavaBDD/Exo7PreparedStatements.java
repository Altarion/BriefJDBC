package exoBriefsJavaBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Exo7PreparedStatements {
	
	public static void main(String[] args) {
		Connection connect = ConnectionBDD.connectInstance();
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("Saisissez un nom ou une partie de nom");
			String userInput = in.nextLine().toUpperCase();
			userInput = "%" + userInput + "%";
			PreparedStatement stat = connect.prepareStatement("SELECT * FROM emp WHERE nom LIKE ? ");
			stat.setString(1, userInput);
			ResultSet ResultSet = stat.executeQuery();
			while (ResultSet.next()) {
				StringBuilder result = new StringBuilder();
				result.append("Nom : ").append(ResultSet.getString("nom")).append(", Prénom : ")
						.append(ResultSet.getString("prenom")).append(", Poste : ").append(ResultSet.getString("emploi"));

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
