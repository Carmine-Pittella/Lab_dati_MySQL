import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entita.Amministratore;

public class Prova1 {
	
	
	
	public static Amministratore creaAmministratore () throws Exception {
		Amministratore admin = new Amministratore();
		admin.setUsername("admin");
		admin.setPassword("admin");
		aggAdmin(admin);
		
		return admin;
	}
	
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
	
	public static void aggAdmin (Amministratore a) throws Exception {
		
		Connection con = getConnection();
		String s = "INSERT INTO amministratore (username,password) VALUES (?,?)";
		PreparedStatement create = con.prepareStatement(s);
		create.setString(2, a.getUsername());
		create.setString(3, a.getPassword());
		create.executeUpdate();
	}
	
	public static List<Amministratore> getLista () throws Exception {
		List<Amministratore> lista = new ArrayList<Amministratore>();
		Connection con = getConnection();
		String s = "SELECT ID_admin,username,password FROM amministratore";
		PreparedStatement create = con.prepareStatement(s);
		ResultSet rs = create.executeQuery();
		while (rs.next()) {
			Amministratore admin = new Amministratore();
			admin.setIdAmministratore(rs.getInt(1));
			admin.setUsername(rs.getString(2));
			admin.setPassword(rs.getString(3));
			lista.add(admin);
		}
		return lista;
		
	}
	

}
