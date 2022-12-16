package exoBriefsJavaBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmpModifierExo9PreparedStatement {

	protected static void changeNoemp(final Connection connect, final String lastname, final String firstname)
			throws SQLException {
		int noemp = MenuBDDExo9PreparedStatement.inputNoemp(connect);
		PreparedStatement stat = connect.prepareStatement("UPDATE emp SET ? WHERE nom = ? AND prenom = ?");
		stat.setInt(1, noemp);
		stat.setString(2, lastname);
		stat.setString(3, firstname);
		stat.executeQuery();
		MenuBDDExo9PreparedStatement.changeEmp(connect, lastname, firstname);
	}

	protected static void changeLastname(final Connection connect, final String lastname, final String firstname)
			throws SQLException {
		String nom = MenuBDDExo9PreparedStatement.inputLastname(connect);
		PreparedStatement stat = connect.prepareStatement("UPDATE emp SET ? WHERE nom = ? AND prenom = ?");
		stat.setString(1, nom);
		stat.setString(2, lastname);
		stat.setString(3, firstname);
		stat.executeQuery();
		MenuBDDExo9PreparedStatement.changeEmp(connect, lastname, firstname);
	}


	protected static void changeFirstname(final Connection connect, final String lastname, final String firstname)
			throws SQLException {
		String prenom = MenuBDDExo9PreparedStatement.inputFirstname(connect);
		PreparedStatement stat = connect.prepareStatement("UPDATE emp SET ? WHERE nom = ? AND prenom = ?");
		stat.setString(1, prenom);
		stat.setString(2, lastname);
		stat.setString(3, firstname);
		stat.executeQuery();
		MenuBDDExo9PreparedStatement.changeEmp(connect, lastname, firstname);
	}

	protected static void changeJob(final Connection connect, final String lastname, final String firstname)
			throws SQLException {
		String job = MenuBDDExo9PreparedStatement.inputJob(connect);
		PreparedStatement stat = connect.prepareStatement("UPDATE emp SET ? WHERE nom = ? AND prenom = ?");
		stat.setString(1, job);
		stat.setString(2, lastname);
		stat.setString(3, firstname);
		stat.executeQuery();
		MenuBDDExo9PreparedStatement.changeEmp(connect, lastname, firstname);
	}

	protected static void changeSup(final Connection connect, final String lastname, final String firstname)
			throws SQLException {
		int sup = MenuBDDExo9PreparedStatement.inputSup(connect);
		PreparedStatement stat = connect.prepareStatement("UPDATE emp SET ? WHERE nom = ? AND prenom = ?");
		stat.setInt(1, sup);
		stat.setString(2, lastname);
		stat.setString(3, firstname);
		stat.executeQuery();
		MenuBDDExo9PreparedStatement.changeEmp(connect, lastname, firstname);
	}

	protected static void changeRecruitdate(final Connection connect, final String lastname, final String firstname)
			throws SQLException {
		java.sql.Date embauche = MenuBDDExo9PreparedStatement.inputRecruitDate(connect);
		PreparedStatement stat = connect.prepareStatement("UPDATE emp SET ? WHERE nom = ? AND prenom = ?");
		stat.setDate(1, embauche);
		stat.setString(2, lastname);
		stat.setString(3, firstname);
		stat.executeQuery();
		MenuBDDExo9PreparedStatement.changeEmp(connect, lastname, firstname);
	}

	protected static void changeSal(final Connection connect, final String lastname, final String firstname)
			throws SQLException {
		int sal = MenuBDDExo9PreparedStatement.inputSal(connect);
		PreparedStatement stat = connect.prepareStatement("UPDATE emp SET ? WHERE nom = ? AND prenom = ?");
		stat.setInt(1, sal);
		stat.setString(2, lastname);
		stat.setString(3, firstname);
		stat.executeQuery();
		MenuBDDExo9PreparedStatement.changeEmp(connect, lastname, firstname);
	}

	protected static void changeComm(final Connection connect, final String lastname, final String firstname)
			throws SQLException {
		int comm = MenuBDDExo9PreparedStatement.inputComm(connect);
		PreparedStatement stat = connect.prepareStatement("UPDATE emp SET ? WHERE nom = ? AND prenom = ?");
		stat.setInt(1, comm);
		stat.setString(2, lastname);
		stat.setString(3, firstname);
		stat.executeQuery();
		MenuBDDExo9PreparedStatement.changeEmp(connect, lastname, firstname);
	}

	protected static void changeNoserv(final Connection connect, final String lastname, final String firstname)
			throws SQLException {
		int noserv = MenuBDDExo9PreparedStatement.inputNoserv(connect);
		PreparedStatement stat = connect.prepareStatement("UPDATE emp SET ? WHERE nom = ? AND prenom = ?");
		stat.setInt(1, noserv);
		stat.setString(2, lastname);
		stat.setString(3, firstname);
		stat.executeQuery();
		MenuBDDExo9PreparedStatement.changeEmp(connect, lastname, firstname);
	}
	
}
