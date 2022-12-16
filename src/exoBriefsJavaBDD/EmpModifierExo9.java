package exoBriefsJavaBDD;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EmpModifierExo9 {
	
	protected static void changeNoemp(final Connection connect, final String lastname, final String firstname)
			throws SQLException {
		int noemp = MenuBDDExo9.inputNoemp(connect);
		String query = "UPDATE emp SET noemp = '" + noemp + "' WHERE nom = '" + lastname + "' AND prenom = '"
				+ firstname + "'";
		ConnectionBDD.Update(connect, query);
		MenuBDDExo9.changeEmp(connect, lastname, firstname);
	}

	protected static void changeLastname(final Connection connect, final String lastname, final String firstname)
			throws SQLException {
		String nom = MenuBDDExo9.inputLastname(connect);
		String query = "UPDATE emp SET noemp = '" + nom + "' WHERE nom = '" + lastname + "' AND prenom = '" + firstname
				+ "'";
		ConnectionBDD.Update(connect, query);
		MenuBDDExo9.changeEmp(connect, lastname, firstname);
	}

	protected static void changeFirstname(final Connection connect, final String lastname, final String firstname)
			throws SQLException {
		String prenom = MenuBDDExo9.inputFirstname(connect);
		String query = "UPDATE emp SET noemp = '" + prenom + "' WHERE nom = '" + lastname + "' AND prenom = '"
				+ firstname + "'";
		ConnectionBDD.Update(connect, query);
		MenuBDDExo9.changeEmp(connect, lastname, firstname);
	}

	protected static void changeJob(final Connection connect, final String lastname, final String firstname)
			throws SQLException {
		String job = MenuBDDExo9.inputJob(connect);
		String query = "UPDATE emp SET noemp = '" + job + "' WHERE nom = '" + lastname + "' AND prenom = '" + firstname
				+ "'";
		ConnectionBDD.Update(connect, query);
		MenuBDDExo9.changeEmp(connect, lastname, firstname);
	}

	protected static void changeSup(final Connection connect, final String lastname, final String firstname)
			throws SQLException {
		int sup = MenuBDDExo9.inputSup(connect);
		String query = "UPDATE emp SET noemp = '" + sup + "' WHERE nom = '" + lastname + "' AND prenom = '" + firstname
				+ "'";
		ConnectionBDD.Update(connect, query);
		MenuBDDExo9.changeEmp(connect, lastname, firstname);
	}

	protected static void changeRecruitdate(final Connection connect, final String lastname, final String firstname)
			throws SQLException {
		Date embauche = MenuBDDExo9.inputRecruitDate(connect);
		String query = "UPDATE emp SET noemp = '" + embauche + "' WHERE nom = '" + lastname + "' AND prenom = '"
				+ firstname + "'";
		ConnectionBDD.Update(connect, query);
		MenuBDDExo9.changeEmp(connect, lastname, firstname);
	}

	protected static void changeSal(final Connection connect, final String lastname, final String firstname)
			throws SQLException {
		int sal = MenuBDDExo9.inputSal(connect);
		String query = "UPDATE emp SET noemp = '" + sal + "' WHERE nom = '" + lastname + "' AND prenom = '" + firstname
				+ "'";
		ConnectionBDD.Update(connect, query);
		MenuBDDExo9.changeEmp(connect, lastname, firstname);
	}

	protected static void changeComm(final Connection connect, final String lastname, final String firstname)
			throws SQLException {
		int comm = MenuBDDExo9.inputComm(connect);
		String query = "UPDATE emp SET noemp = '" + comm + "' WHERE nom = '" + lastname + "' AND prenom = '" + firstname
				+ "'";
		ConnectionBDD.Update(connect, query);
		MenuBDDExo9.changeEmp(connect, lastname, firstname);
	}

	protected static void changeNoserv(final Connection connect, final String lastname, final String firstname)
			throws SQLException {
		int noserv = MenuBDDExo9.inputNoserv(connect);
		String query = "UPDATE emp SET noemp = '" + noserv + "' WHERE nom = '" + lastname + "' AND prenom = '"
				+ firstname + "'";
		ConnectionBDD.Update(connect, query);
		MenuBDDExo9.changeEmp(connect, lastname, firstname);
	}

}
