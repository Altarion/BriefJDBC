package exoBriefsJavaBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuBDDExo9PreparedStatement {
	
	public static void menu(final Connection connect) {
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("_________________________________________________________");
			System.out.println("|                                                       |");
			System.out.println("|Bienvenue dans le menu de navigation, vous souhaitez : |");
			System.out.println("|1 - Afficher la liste des employés                     |");
			System.out.println("|2 - Afficher le détail d'un employé                    |");
			System.out.println("|3 - Ajouter un employé                                 |");
			System.out.println("|4 - Modifier un employé                                |");
			System.out.println("|5 - Supprimer un employé                               |");
			System.out.println("|-------------------------------------------------------|");
			System.out.println("|6 - Fermer le programme                                |");
			System.out.println("|_______________________________________________________|");
			int userChoice = in.nextInt();
			switch (userChoice) {
			case 1:
				showEmp(connect);
				break;
			case 2:
				empDetail(connect);
				break;
			case 3:
				newEmp(connect);
				break;
			case 4:
				selEmp(connect);
				break;
			case 5:
				delEmp(connect);
				break;
			case 6:
				connect.close();
				System.exit(0);
				break;
			default:
				System.out.println("/!\\ Merci de renseigner le chiffre de l'action souhaitée /!\\");
				menu(connect);
			}
		} catch (InputMismatchException e) {
			System.out.println("___________________________________________________________");
			System.out.println("|Une erreur relative à l'entrée utilisateur s'est produite|");
			System.out.println("|_________________________________________________________|");
			menu(connect);
		} catch (SQLException e) {
			System.out.println("_______________________________");
			System.out.println("|Une erreur SQL s'est produite|");
			System.out.println("|_____________________________|");
			e.printStackTrace();
			menu(connect);
		}

	}

	private static void showEmp(final Connection connect) throws SQLException {
		ResultSet query = ConnectionBDD.query(connect, "SELECT * FROM emp");
		while (query.next()) {
			StringBuilder result = new StringBuilder();
			result.append("Nom : ").append(query.getString("nom")).append(", Prénom : ")
					.append(query.getString("prenom")).append(", Poste : ").append(query.getString("emploi"));
			System.out.println(result);
		}
		menu(connect);
	}

	protected static int inputNoemp(final Connection connect) throws InputMismatchException {
		Scanner in = new Scanner(System.in);
		System.out.println("Saisissez un N° d'employé :");
		int userInput = in.nextInt();
		return userInput;
	}

	protected static String inputFirstname(final Connection connect) throws InputMismatchException {
		Scanner in = new Scanner(System.in);
		System.out.println("Saisissez un prénom :");
		String userInput = in.nextLine().toUpperCase();
		return userInput;
	}

	protected static String inputLastname(final Connection connect) throws InputMismatchException {
		Scanner in = new Scanner(System.in);
		System.out.println("Saisissez un nom :");
		String userInput = in.nextLine().toUpperCase();
		return userInput;
	}

	protected static String inputJob(final Connection connect) throws InputMismatchException {
		Scanner in = new Scanner(System.in);
		System.out.println("Saisissez un poste :");
		String userInput = in.nextLine().toUpperCase();
		return userInput;
	}

	protected static int inputSup(final Connection connect) throws InputMismatchException {
		Scanner in = new Scanner(System.in);
		System.out.println("Saisissez un N° de supérieur :");
		int userInput = in.nextInt();
		return userInput;
	}

	protected static java.sql.Date inputRecruitDate(final Connection connect) {
		java.sql.Date recruit = null;
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("Saisissez la date de recrutement :");
			System.out.println("Jour :");
			int day = in.nextInt();
			System.out.println("Mois : ");
			int month = in.nextInt();
			System.out.println("Année : ");
			int year = in.nextInt();
			Calendar calendar = Calendar.getInstance();
			calendar.set(year, month - 1, day);
			recruit = new java.sql.Date(calendar.getTimeInMillis());
		} catch (InputMismatchException e) {
			System.out.println("___________________________________________________________");
			System.out.println("|Une erreur relative à l'entrée utilisateur s'est produite|");
			System.out.println("|_________________________________________________________|");
			inputRecruitDate(connect);
		}
		return recruit;
	}

	protected static int inputSal(final Connection connect) throws InputMismatchException {
		Scanner in = new Scanner(System.in);
		System.out.println("Saisissez un salaire :");
		int userInput = in.nextInt();
		return userInput;
	}

	protected static int inputComm(final Connection connect) throws InputMismatchException {
		Scanner in = new Scanner(System.in);
		System.out.println("Saisissez une commission :");
		int userInput = in.nextInt();
		return userInput;
	}

	protected static int inputNoserv(final Connection connect) throws InputMismatchException {
		Scanner in = new Scanner(System.in);
		System.out.println("Saisissez un N° de service :");
		int userInput = in.nextInt();
		return userInput;
	}

	protected static void changeEmp(final Connection connect, final String lastname, final String firstname) {
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("__________________________________________________");
			System.out.println("|                                                |");
			System.out.println("|Vous souhaitez :                                |");
			System.out.println("|1 - Modifier le numéro de l'employé.e           |");
			System.out.println("|2 - Modifier le nom de l'employé.e              |");
			System.out.println("|3 - Modifier le prénom de l'employé.e           |");
			System.out.println("|4 - Modifier le poste de l'employé.e            |");
			System.out.println("|5 - Modifier le supérieur de l'employé.e        |");
			System.out.println("|6 - Modifier la date d'embauche de l'employé.e  |");
			System.out.println("|7 - Modifier le salaire de l'employé.e          |");
			System.out.println("|8 - Modifier la commission de l'employé.e       |");
			System.out.println("|9 - Modifier le numéro de service de l'employé.e|");
			System.out.println("|------------------------------------------------|");
			System.out.println("|10 - Revenir au menu principal                  |");
			System.out.println("|________________________________________________|");
			int userChoice = in.nextInt();
			switch (userChoice) {
			case 1:
				EmpModifierExo9PreparedStatement.changeNoemp(connect, lastname, firstname);
				break;
			case 2:
				EmpModifierExo9PreparedStatement.changeLastname(connect, lastname, firstname);
				break;
			case 3:
				EmpModifierExo9PreparedStatement.changeFirstname(connect, lastname, firstname);
				break;
			case 4:
				EmpModifierExo9PreparedStatement.changeJob(connect, lastname, firstname);
				break;
			case 5:
				EmpModifierExo9PreparedStatement.changeSup(connect, lastname, firstname);
				break;
			case 6:
				EmpModifierExo9PreparedStatement.changeRecruitdate(connect, lastname, firstname);
				break;
			case 7:
				EmpModifierExo9PreparedStatement.changeSal(connect, lastname, firstname);
				break;
			case 8:
				EmpModifierExo9PreparedStatement.changeComm(connect, lastname, firstname);
				break;
			case 9:
				EmpModifierExo9PreparedStatement.changeNoserv(connect, lastname, firstname);
				break;
			case 10:
				menu(connect);
				break;
			default:
				System.out.println("/!\\ Merci de renseigner le chiffre de l'action souhaitée /!\\");
				changeEmp(connect, lastname, firstname);
			}
		} catch (InputMismatchException e) {
			System.out.println("___________________________________________________________");
			System.out.println("|Une erreur relative à l'entrée utilisateur s'est produite|");
			System.out.println("|_________________________________________________________|");
			changeEmp(connect, lastname, firstname);
		} catch (SQLException e) {
			System.out.println("_______________________________");
			System.out.println("|Une erreur SQL s'est produite|");
			System.out.println("|_____________________________|");
			changeEmp(connect, lastname, firstname);
		}
	}

	private static void selEmp(final Connection connect) throws InputMismatchException, SQLException {
		String lastname = inputLastname(connect);
		String firstname = inputFirstname(connect);
		PreparedStatement stat = connect.prepareStatement("SELECT nom, prenom FROM emp WHERE nom = ? AND prenom = ?");
		stat.setString(1, lastname);
		stat.setString(2, firstname);
		ResultSet ResultSet = stat.executeQuery();
		if (ResultSet.isBeforeFirst()) {
			changeEmp(connect, lastname, firstname);
		} else {
			System.out.println("Aucun.e employé.e : " + lastname + " " + firstname);
			selEmp(connect);
		}
	}

	private static void empDetail(final Connection connect) throws SQLException {
		String lastname = inputLastname(connect).toUpperCase();
		String firstname = inputFirstname(connect).toUpperCase();
		PreparedStatement stat = connect.prepareStatement("SELECT * FROM emp WHERE nom = ? AND prenom = ?");
		stat.setString(1, lastname);
		stat.setString(2, firstname);
		ResultSet ResultSet = stat.executeQuery();
		if (ResultSet.isBeforeFirst()) {
			while (ResultSet.next()) {
				StringBuilder result = new StringBuilder();
				result.append("N° Employé : ").append(ResultSet.getInt("noemp")).append(", Nom : ")
						.append(ResultSet.getString("nom")).append(", Prénom : ").append(ResultSet.getString("prenom"))
						.append(", Poste : ").append(ResultSet.getString("emploi")).append(", N° Supérieur : ")
						.append(ResultSet.getInt("sup")).append(", Embauche : ").append(ResultSet.getDate("embauche"))
						.append(", Salaire : ").append(ResultSet.getInt("sal")).append(", Commission : ")
						.append(ResultSet.getInt("comm")).append(", N° Service : ").append(ResultSet.getInt("noserv"));
				System.out.println(result);
			}
			menu(connect);
		} else {
			System.out.println("Aucun employé ne correspond à votre recherche.");
			menu(connect);
		}
	}

	private static void newEmp(final Connection connect) throws SQLException {
		int noemp = inputNoemp(connect);
		String lastname = inputLastname(connect).toUpperCase();
		String firstname = inputFirstname(connect).toUpperCase();
		String emploi = inputJob(connect).toUpperCase();
		int sup = inputSup(connect);
		java.sql.Date embauche = inputRecruitDate(connect);
		int sal = inputSal(connect);
		int comm = inputComm(connect);
		int noserv = inputNoserv(connect);
		PreparedStatement stat = connect.prepareStatement(
				"INSERT INTO emp (noemp, nom, prenom, emploi, sup, embauche, sal, comm, noserv) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		stat.setInt(1, noemp);
		stat.setString(2, lastname);
		stat.setString(3, firstname);
		stat.setString(4, emploi);
		stat.setInt(5, sup);
		stat.setDate(6, embauche);
		stat.setInt(7, sal);
		stat.setInt(8, comm);
		stat.setInt(9, noserv);
		stat.executeQuery();
		StringBuilder result = new StringBuilder();
		result.append(lastname).append(" ").append(firstname).append(" à été ajouté.e dans la base de données");
		System.out.println(result);
		menu(connect);
	}

	private static void delEmp(final Connection connect) throws SQLException {
		String lastname = inputLastname(connect).toUpperCase();
		String firstname = inputFirstname(connect).toUpperCase();
		PreparedStatement stat = connect.prepareStatement("SELECT nom, prenom FROM emp WHERE nom = ? AND prenom = ?");
		stat.setString(1, lastname);
		stat.setString(2, firstname);
		stat.executeQuery();
		StringBuilder result = new StringBuilder();
		result.append(lastname).append(" ").append(firstname).append(" à été supprimé.e de la base de données");
		System.out.println(result);
		menu(connect);
	}

}
