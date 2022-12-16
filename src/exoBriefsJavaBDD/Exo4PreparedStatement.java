package exoBriefsJavaBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Exo4PreparedStatement {
	
	public static void main(String[] args) {
		Connection connect = ConnectionBDD.connectInstance();
		try {
			PreparedStatement stat = connect.prepareStatement("SELECT * FROM emp LEFT JOIN serv ON emp.noserv = serv.noserv WHERE serv.service = ?");
			stat.setString(1, "INFORMATIQUE");
			ResultSet ResultSet = stat.executeQuery();
			while (ResultSet.next()) {
				StringBuilder result = new StringBuilder();
				result.append("Nom : ").append(ResultSet.getString("nom")).append(", Prénom : ")
						.append(ResultSet.getString("prenom")).append(", Poste : ").append(ResultSet.getString("emploi"))
						.append(", Service : ").append(ResultSet.getString("service"));
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
