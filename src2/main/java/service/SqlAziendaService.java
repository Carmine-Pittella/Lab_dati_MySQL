package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import business.AziendaService;
import domain.Azienda;

public class SqlAziendaService implements AziendaService {

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

	@Override
	public void creaAzienda(Azienda a, String u) throws Exception {

		Connection con = getConnection();

		String s = "INSERT INTO Azienda(partita_iva,nome,verificata,settore,nome_rappresentante,cognome_rappresentante,ID_amministratore) VALUES (?,?,?,?,?,?,?)";
		
		String s1 = "SELECT * FROM Utente "
					+ "WHERE username= "+"'"+u+"';";
		
		try {

			PreparedStatement create = con.prepareStatement(s);

			create.setString(1, a.getPartitaIva());
			create.setString(2, a.getNome());
			create.setBoolean(3, false);
			create.setString(4, a.getSettore());
			create.setString(5, a.getNomeRappresentante());
			create.setString(6, a.getCognomeRappresentante());

			
		
		
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(s1);
			
			
			int i=0;
			
			if(rs.next()) {
				i = rs.getInt("ID_utente");
				
			}
			
			String s2 = "Select ID_admin_aziendale FROM amministratoreaziendale "
					+ "WHERE ID_utente= "+ "'"+i+"'";
			ResultSet rs1 = st.executeQuery(s2);
			
			if (rs1.next()) {
				create.setInt(7, i);
			}
			
			create.executeUpdate();
				
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
