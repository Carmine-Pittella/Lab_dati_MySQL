package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CreazioneTabelle {
	
	public static void run () throws Exception {
		creaTabellaAdmin();
		creaTabellaAzienda();
		creaTabellaFeedback();
		creaTabellaSede();
		creaTabellaStudente();
		creaTabellaTelefono();
		creaTabellaTirocinio();
		creaTabellaTutorAziendale();
		creaTabellaTutorUniversitario();
		creaTabellaUtente();
		creaTabellaAdminAziendale();
		
	}

	// serve per connettere java al db
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

	public static void creaTabellaAzienda() throws Exception {
		try {
			Connection con = getConnection();

			String s = "CREATE TABLE Azienda(" 
					+ "ID_azienda int NOT NULL AUTO_INCREMENT PRIMARY KEY,"
					+ "partita_iva varchar(255) NOT NULL," 
					+ "nome varchar(255) NOT NULL," 
					+ "verificata bool NOT NULL,"
					+ "settore varchar(255) NOT NULL," 
					+ "nome_rappresentante varchar(255) NOT NULL,"
					+ "cognome_rappresentante varchar(255) NOT NULL," 
					+ "ID_amministratore int NOT NULL,"
					+ "CONSTRAINT azienda_unica UNIQUE (partita_iva)" 
					+ ")";
					

			PreparedStatement create = con.prepareStatement(s);
			create.executeUpdate();
		} catch (Exception e) {
			System.out.println("Errore creazione tabella azienda:  " + e.getMessage());
		}

	}
	
	public static void creaTabellaUtente() throws Exception {
		try {
			Connection con = getConnection();

			String s = "CREATE TABLE Utente("
					+ "ID_utente int NOT NULL AUTO_INCREMENT PRIMARY KEY,"
					+ "nome varchar(255) NOT NULL," 
					+ "cognome varchar(255) NOT NULL,"
					+ "username varchar(255) NOT NULL," 
					+ "password varchar(255) NOT NULL,"
					+ "tipo varchar(255) NOT NULL,"
					+ "CONSTRAINT utente_unico UNIQUE (username)" 
					+ ")";

			PreparedStatement create = con.prepareStatement(s);
			create.executeUpdate();

		} catch (Exception e) {
			System.out.println("Errore creazione tabella utente: " + e.getMessage());
		}
	}

	// crea una tabella,stesso discorso per la colonna con i duplicati
	public static void creaTabellaStudente() throws Exception {
		try {
			Connection con = getConnection();

			String s = "CREATE TABLE Studente(" 
					+ "ID_studente int NOT NULL AUTO_INCREMENT PRIMARY KEY,"
					+ "matricola int NOT NULL," 
					+ "corso_laurea varchar(255) NOT NULL," 
					+ "handicap bool NOT NULL," 
					+ "ID_tutorUniversitario int," 
					+ "cf varchar(255) NOT NULL," 
					+ "residenza varchar(255) NOT NULL," 
					+ "data_nascita DATE NOT NULL,"
					+ "luogo_nascita varchar(255) NOT NULL,"
					+ "ID_utente int NOT NULL,"
					+ "CONSTRAINT studente_unico UNIQUE (matricola,cf)"
					+ ")";

			PreparedStatement create = con.prepareStatement(s);
			create.executeUpdate();

		} catch (Exception e) {
			System.out.println("Errore creazione tabella studente: " + e.getMessage());
		}
	}

	public static void creaTabellaTirocinio() throws Exception {
		try {
			Connection con = getConnection();

			String s = "CREATE TABLE Tirocinio(" 
					+ "ID_tirocinio int NOT NULL AUTO_INCREMENT PRIMARY KEY,"
					+ "ID_azienda int NOT NULL," 
					+ "ID_studente int NOT NULL," 
					+ "ID_tutor_aziendale int NOT NULL,"
					+ "esito bool NOT NULL," 
					+ "CFU int NOT NULL," 
					+ "Facilitazioni varchar(255) NOT NULL,"
					+ "Modalita varchar(255) NOT NULL," 
					+ "AttivitaSvolte varchar(255) NOT NULL,"
					+ "Obiettivi varchar(255) NOT NULL,"
					+ "Durata int NOT NULL," 
					+ "OrarioInizio int NOT NULL,"
					+ "OrarioFine int NOT NULL," 
					+ "FOREIGN KEY (ID_studente) REFERENCES Studente(ID_studente)"
					+ "ON DELETE CASCADE ON UPDATE CASCADE," 
					+ "FOREIGN KEY (ID_azienda) REFERENCES Azienda(ID_azienda)"
					+ "ON DELETE CASCADE ON UPDATE CASCADE,"
					+ "FOREIGN KEY (ID_tutor_aziendale) REFERENCES Tutoraziendale(ID_tutor_aziendale)"
					+ "ON DELETE CASCADE ON UPDATE CASCADE"
					+ ")";

			PreparedStatement create = con.prepareStatement(s);
			create.executeUpdate();

		} catch (Exception e) {
			System.out.println("Errore creazione tabella tirocinio:  " + e.getMessage());
		}
	}

	public static void creaTabellaSede() {
		try {
			Connection con = getConnection();

			String s = "CREATE TABLE Sede(" 
					+ "ID_sede int NOT NULL AUTO_INCREMENT PRIMARY KEY,"
					+ "citta varchar(255) NOT NULL," 
					+ "via varchar(255) NOT NULL," 
					+ "civico int NOT NULL,"
					+ "ID_azienda int NOT NULL," 
					+ "FOREIGN KEY (ID_azienda) REFERENCES Azienda(ID_azienda)"
					+ "ON DELETE CASCADE ON UPDATE CASCADE" 
					+ ")";

			PreparedStatement create = con.prepareStatement(s);
			create.executeUpdate();

		} catch (Exception e) {
			System.out.println("Errore creazione tabella sede:  " + e.getMessage());
		}

	}

	public static void creaTabellaTutorAziendale() {
		try {
			Connection con = getConnection();

			String s = "CREATE TABLE TutorAziendale(" 
					+ "ID_tutor_aziendale int NOT NULL AUTO_INCREMENT PRIMARY KEY,"
					+ "ID_utente int NOT NULL"
					+ ")";

			PreparedStatement create = con.prepareStatement(s);
			create.executeUpdate();

		} catch (Exception e) {
			System.out.println("Errore creazione tabella tutor aziendale:  " + e.getMessage());
		}

	}

	public static void creaTabellaTutorUniversitario() {
		try {
			Connection con = getConnection();

			String s = "CREATE TABLE TutorUniversitario("
					+ "ID_tutor_universitario int NOT NULL AUTO_INCREMENT PRIMARY KEY," 
					+ "ID_utente int NOT NULL"
					+ ")";

			PreparedStatement create = con.prepareStatement(s);
			create.executeUpdate();

		} catch (Exception e) {
			System.out.println("Errore creazione tabella tutor universitario:  " + e.getMessage());
		}

	}

	public static void creaTabellaFeedback() {
		try {
			Connection con = getConnection();

			String s = "CREATE TABLE Feedback(" 
					+ "ID_feedback int NOT NULL AUTO_INCREMENT PRIMARY KEY,"
					+ "dettagli varchar(255) NOT NULL," 
					+ "rating int NOT NULL," 
					+ "ID_studente int NOT NULL,"
					+ "ID_tirocinio int NOT NULL," 
					+ "FOREIGN KEY (ID_studente) REFERENCES Studente(ID_studente)"
					+ "ON DELETE CASCADE ON UPDATE CASCADE,"
					+ "FOREIGN KEY (ID_tirocinio) REFERENCES Tirocinio(ID_tirocinio)"
					+ "ON DELETE CASCADE ON UPDATE CASCADE" 
					+ ")";

			PreparedStatement create = con.prepareStatement(s);
			create.executeUpdate();

		} catch (Exception e) {
			System.out.println("Errore creazione tabella feedback:  " + e.getMessage());
		}
	}

	public static void creaTabellaAdmin() {
		try {
			Connection con = getConnection();

			String s = "CREATE TABLE Amministratore(" 
					+ "ID_admin int NOT NULL AUTO_INCREMENT PRIMARY KEY,"
					+ "username varchar(255) NOT NULL," 
					+ "password varchar(255) NOT NULL,"
					+ "CONSTRAINT admin_univ_unico UNIQUE (username)" 
					+ ")";

			PreparedStatement create = con.prepareStatement(s);
			create.executeUpdate();

		} catch (Exception e) {
			System.out.println("Errore creazione tabella amministratore:  " + e.getMessage());
		}
	}

	

	public static void creaTabellaTelefono() {
		try {
			Connection con = getConnection();

			String s = "CREATE TABLE Telefono(" 
					+ "ID_telefono int NOT NULL AUTO_INCREMENT PRIMARY KEY,"
					+ "numero varchar(255) NOT NULL," 
					+ "CONSTRAINT stud_unico UNIQUE (numero)" 
					+ ")";

			PreparedStatement create = con.prepareStatement(s);
			create.executeUpdate();

		} catch (Exception e) {
			System.out.println("Errore creazione tabella telefono:  " + e.getMessage());
		}
	}
	
	public static void creaTabellaAdminAziendale () {
		try {
			Connection con = getConnection();

			String s = "CREATE TABLE Amministratoreaziendale("
					+ "ID_admin_aziendale int NOT NULL AUTO_INCREMENT PRIMARY KEY,"
					+ "ID_azienda int,"
					+ "ID_utente int NOT NULL"
					+ ")";

			PreparedStatement create = con.prepareStatement(s);
			create.executeUpdate();

		} catch (Exception e) {
			System.out.println("Errore creazione tabella admin aziendale:  " + e.getMessage());
		}
			
		}
	}
	
	


