package exoBriefsJavaBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Exo8PreparedStatement {
	
	public static void main(String[] args) {
		Connection connect = ConnectionBDD.connectInstance();
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("Saisissez un nom de service :");
			String userServInput = in.nextLine().toUpperCase();
			System.out.println("Saisissez un salaire :");
			int userSalInput = in.nextInt();
			PreparedStatement stat = connect.prepareStatement(
					"SELECT nom , emploi, sal, noserv FROM emp WHERE noserv IN (SELECT noserv FROM serv WHERE service = ? ) AND sal > ? ");
			stat.setString(1, userServInput);
			stat.setInt(2, userSalInput);
			ResultSet ResultSet = stat.executeQuery();
			while (ResultSet.next()) {
				StringBuilder result = new StringBuilder();
				result.append("Nom : ").append(ResultSet.getString("nom")).append(", Emploi : ")
						.append(ResultSet.getString("emploi")).append(", Salaire : ").append(ResultSet.getInt("sal"))
						.append(", N° de Service : ").append(ResultSet.getString("noserv"));

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
