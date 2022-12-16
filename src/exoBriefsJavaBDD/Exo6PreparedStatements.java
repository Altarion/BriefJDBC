package exoBriefsJavaBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Exo6PreparedStatements {
	
	public static void main(String[] args) {
		Connection connect = ConnectionBDD.connectInstance();
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("Saisissez une année");
			int userInput = in.nextInt();
			PreparedStatement stat = connect.prepareStatement("SELECT * FROM emp WHERE EXTRACT(YEAR FROM embauche) =  ? ");
			stat.setInt(1, userInput);
			ResultSet ResultSet = stat.executeQuery();
			while (ResultSet.next()) {
				StringBuilder result = new StringBuilder();
				result.append("Nom : ").append(ResultSet.getString("nom")).append(", Prénom : ")
						.append(ResultSet.getString("prenom")).append(", Poste : ").append(ResultSet.getString("emploi"))
						.append(", Date d'embauche : ").append(ResultSet.getDate("embauche"));

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
