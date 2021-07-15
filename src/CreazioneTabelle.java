import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CreazioneTabelle {
	
	
	//serve per connettere java al db
		public static Connection getConnection() throws Exception {
			Connection con;
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Progetto", "root","root");

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
						+ "IdAzienda int NOT NULL AUTO_INCREMENT,"
						+ "PartitaIva varchar(255),"
						+ "Nome varchar(255),"
						+ "Verificata bool,"
						+ "Settore varchar(255),"
						+ "nomeRappresentante varchar(255),"
						+ "cognomeRappresentante varchar(255),"
						+ "IdAmministratore int,"
						+ "PRIMARY KEY(IdAzienda));";
				
				PreparedStatement create = con.prepareStatement(s);
				create.executeUpdate();
			}
			catch (Exception e) {
				System.out.println("create table  " + e.getMessage());
				
			}
			
		}
		
		//crea una tabella,stesso discorso per la colonna con i duplicati
		public static void creaTabellaStudente() throws Exception {
			try {
				Connection con = getConnection();
				String s = "CREATE TABLE Studente("
						+ "IdStudnte int NOT NULL AUTO_INCREMENT,"
						+ "Matricola int NOT NULL,"
						+ "Username varchar(255),"
						+ "Password varchar(255),"
						+ "CorsoLaurea varchar(255),"
						+ "Handicap bool,"
						+ "IdAnagrafica int,"
						+ "IdTutorUniversitario int,"
						+ "PRIMARY KEY (IdStudnte));";
						
				PreparedStatement create = con.prepareStatement(s);
				create.executeUpdate();

			} catch (Exception e) {
				System.out.println("create table  " + e.getMessage());
			}
		}
		
		public static void creaTabellaTirocinio() throws Exception {
			try {
				Connection con = getConnection();
				String s = "CREATE TABLE Tirocinio("
						+ "IdTirocinio int NOT NULL AUTO_INCREMENT,"
						+ "IdAzienda int,"
						+ "IdStudente int,"
						+ "IdTutorAziendale int,"
						+ "esito bool,"
						+ "CFU int,"
						+ "Facilitazioni varchar(255),"
						+ "Modalita varchar(255),"
						+ "AttivitaSvolte varchar(255),"
						+ "Obiettivi varchar(255),"
						+ "Durata int,"
						+ "OrarioInizio int,"
						+ "OrarioFine int,"
						+ "PRIMARY KEY (IdTirocinio),"
						+ "FOREIGN KEY (IdStudente) REFERENCES Studente(IdStudente),"
						+ "FOREIGN KEY (IdAzienda) REFERENCES Azienda(IdAzienda),"
						+ "FOREIGN KEY (IdTutorAziendale) REFERENCES Tutoraziendale(IdTutorAziendale))";
						
				PreparedStatement create = con.prepareStatement(s);
				create.executeUpdate();

			} catch (Exception e) {
				System.out.println("create table  " + e.getMessage());
			}
		}
		
		

}
