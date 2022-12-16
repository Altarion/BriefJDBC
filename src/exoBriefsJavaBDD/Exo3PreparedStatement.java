package exoBriefsJavaBDD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class Exo3PreparedStatement {

	public static void main(String[] args) {
		Connection connect = ConnectionBDD.connectInstance();
		try {
			PreparedStatement stat = connect.prepareStatement("SELECT * FROM emp WHERE noserv = ?");
			stat.setInt(1, 5);
			ResultSet resultSet = stat.executeQuery();
			while (resultSet.next()) {
				StringBuilder result = new StringBuilder();
				result.append("Nom : ").append(resultSet.getString("nom")).append(", Prénom : ")
						.append(resultSet.getString("prenom")).append(", Poste : ").append(resultSet.getString("emploi"))
						.append(", N° de service : ").append(resultSet.getInt("noserv"));
				System.out.println(result);
			}
			connect.close();
		} catch (SQLException e) {
			System.out.println("_______________________________");
			System.out.println("|Une erreur SQL s'est produite|");
			System.out.println("|_____________________________|");
			e.printStackTrace();
		}
	}	
}
