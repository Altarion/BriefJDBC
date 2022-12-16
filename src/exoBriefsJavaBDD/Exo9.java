package exoBriefsJavaBDD;


import java.sql.Connection;

public class Exo9 {
	
	public static void main(String[] args) {
		Connection connect;
		connect = ConnectionBDD.connectInstance();
		MenuBDDExo9.menu(connect);
	}
}