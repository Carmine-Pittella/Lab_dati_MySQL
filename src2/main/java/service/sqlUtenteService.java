package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import business.userService;
import domain.AmministratoreAziendale;
import domain.Studente;
import domain.TutorAziendale;
import domain.TutorUniversitario;

public class sqlUtenteService implements userService {

	public static Connection getConnection() throws Exception {
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto", "root", "root");
			return con;

		} catch (Exception e) {
			System.out.println("get connection" + e.getMessage());
		}
		return null;
	}

	public void creaStudente(Studente s) throws Exception {

		Connection con = getConnection();

		String insert = "INSERT INTO Utente (nome,cognome,username,password,tipo) VALUES (?,?,?,?,?)";

		String s1 = "INSERT INTO Studente (matricola,corso_laurea,handicap,ID_tutorUniversitario,cf,residenza,data_nascita,luogo_nascita,ID_utente)"
				+ "VALUES (?,?,?,?,?,?,?,?,?)";

		try {

			PreparedStatement create = con.prepareStatement(insert);

			create.setString(1, s.getNome());
			create.setString(2, s.getCognome());
			create.setString(3, s.getUsername());
			create.setString(4, s.getPassword());
			create.setString(5, "s");

			create.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			PreparedStatement create = con.prepareStatement(s1);
			create.setInt(1, s.getMatricola());
			create.setString(2, s.getCorsoDiLaurea());
			create.setBoolean(3, s.isHandicap());
			create.setInt(4, 0);
			create.setString(5, s.getCodiceFiscale());
			create.setString(6, s.getResidenza());
			create.setDate(7, s.getDataNascita());
			create.setString(8, s.getLuogoNascita());

			String s2 = "SELECT * FROM utente " + "WHERE username=" + "'" + s.getUsername() + "';";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(s2);
			int i = 0;
			while (rs.next()) {
				i = rs.getInt("ID_utente");
			}
			create.setInt(9, i);

			create.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void creaTutorAziendale(TutorAziendale ta) throws Exception {
		
		Connection con = getConnection();
		
		String s = "INSERT INTO Utente (nome,cognome,username,password,tipo) VALUES (?,?,?,?,?)";

		String s1 = "INSERT INTO tutoraziendale(ID_utente) VALUES (?)";
		try {
			PreparedStatement create = con.prepareStatement(s);
			create.setString(1, ta.getNome());
			create.setString(2, ta.getCognome());
			create.setString(3, ta.getUsername());
			create.setString(4, ta.getPassword());
			create.setString(5, "ta");

			create.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {

			PreparedStatement create = con.prepareStatement(s1);
			String s2 = "SELECT * FROM utente " + "WHERE username=" + "'" + ta.getUsername() + "';";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(s2);
			int i = 0;
			while (rs.next()) {
				i = rs.getInt("ID_utente");
			}
			create.setInt(1, i);
			create.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void creaTutorUniversitario(TutorUniversitario tu) throws Exception {
		
		Connection con = getConnection();
		
		String s = "INSERT INTO Utente (nome,cognome,username,password,tipo) VALUES (?,?,?,?,?)";

		String s1 = "INSERT INTO Tutoruniversitario (ID_utente) VALUES (?)";
		try {
			PreparedStatement create = con.prepareStatement(s);
			create.setString(1, tu.getNome());
			create.setString(2, tu.getCognome());
			create.setString(3, tu.getUsername());
			create.setString(4, tu.getPassword());
			create.setString(5, "tu");

			create.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {

			PreparedStatement create = con.prepareStatement(s1);
			String s2 = "SELECT * FROM utente " + "WHERE username=" + "'" + tu.getUsername() + "';";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(s2);
			while (rs.next()) {
				create.setInt(1, rs.getInt("ID_utente"));
			}
			create.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void creaAdminAziendale(AmministratoreAziendale aa) throws Exception {
		
Connection con = getConnection();
		
		String s = "INSERT INTO Utente (nome,cognome,username,password,tipo) VALUES (?,?,?,?,?)";

		String s1 = "INSERT INTO Amministratoreaziendale (ID_azienda,ID_utente) VALUES (?,?)";
		try {
			PreparedStatement create = con.prepareStatement(s);
			create.setString(1, aa.getNome());
			create.setString(2, aa.getCognome());
			create.setString(3, aa.getUsername());
			create.setString(4, aa.getPassword());
			create.setString(5, "aa");

			create.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {

			PreparedStatement create = con.prepareStatement(s1);
			create.setInt(1, 0);
			String s2 = "SELECT * FROM utente " + "WHERE username=" + "'" + aa.getUsername() + "';";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(s2);
			while (rs.next()) {
				create.setInt(2, rs.getInt("ID_utente"));
			}
			
			create.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
