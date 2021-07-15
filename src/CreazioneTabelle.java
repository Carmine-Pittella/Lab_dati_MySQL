import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CreazioneTabelle {
	
	public static void main(String[] args) {
		try {
			Connection c = getConnection();
			createTable();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("ERRORE NEL MAIN");
		}
		
	}

	// CONNECTION
	public static Connection getConnection() throws Exception {
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tirocini", "root", "root");
			return con;
		} catch (Exception e) {
			System.out.println("get connection" + e.getMessage());
		}
		return null;
	}

	// CREATE TABLE
	public static void createTable() throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS tab2(nome integer");
			create.executeUpdate();

		} catch (Exception e) {
			System.out.println("create table" + e.getMessage());
		}
	}
}
