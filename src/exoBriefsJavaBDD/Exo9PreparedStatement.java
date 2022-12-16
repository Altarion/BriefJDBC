package exoBriefsJavaBDD;

import java.sql.Connection;

public class Exo9PreparedStatement {
	
	public static void main(String[] args) {
		Connection connect;
		connect = ConnectionBDD.connectInstance();
		MenuBDDExo9PreparedStatement.menu(connect);
	}

}
