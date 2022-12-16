package exoBriefsJavaBDD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exo3 {
	
	public static void main(String[] args) {
		
		Connection connect = ConnectionBDD.connectInstance();
		try {
			Statement statement = connect.createStatement();                                     
			ResultSet resultSet = statement.executeQuery("select * from emp where noserv = 5");          
		{                 
			while(resultSet.next()) {                    
				int noemp = resultSet.getInt("noemp");                     
				String nom = resultSet.getString("nom");                     
				String prenom = resultSet.getString("prenom");                     
				String emploi = resultSet.getString("emploi");                     
				System.out.println(noemp +"  |"+nom+"  |"+prenom+"  |"+emploi);                 
				}             
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
