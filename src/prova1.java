
import java.sql.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class prova1 {
	//il main serve sennò non funziona una minchia
	public static void main(String[] args) throws Exception {
		Connection c = getConnection();
		 //inserisciColonna();
//		 set();
//		 ArrayList<String> arr=getString();
//		 ArrayList<Integer> arr1=getInt();
//		 
//		 stampa(arr,arr1);
        //cancella();
		

	}
	// sto metodo è fatto così giusto per
	public static void stampa(ArrayList<String> arr,ArrayList<Integer> arr1) {
		for (String s: arr) {
			for (int i:arr1) {
				System.out.println("stampa:  " + s +" "+ i);
				
			}
			
		}
	}
	
	
	//svuota la tabella tab2 nel databasea
	public static void cancella () {
		try {
		Connection con = getConnection();
		PreparedStatement canc= con.prepareStatement("delete from tab2 where nome=3");
		canc.executeUpdate();
		} catch (Exception e) { System.out.println("cancellazione non riuscita"+ e.getMessage()); }
	}

	// qua prende valori dalla colonna e li mette nell'arraylist
	public static ArrayList<String> getString() {
		try {
			Connection con = getConnection();
			ArrayList<String> arr = new ArrayList<String>();
			PreparedStatement p = con.prepareStatement("select prova from tab2");
			ResultSet result = p.executeQuery();
			
			while (result.next()) { arr.add(result.getString("prova")); }
			return arr;
		} catch (Exception e) {
			System.out.println("query non eseguita" + e.getMessage());
		  }
		return null;
	}
	
	public static ArrayList<Integer> getInt () {
		try {
			Connection con =getConnection();
			ArrayList<Integer> arr1=new ArrayList<Integer>();
			PreparedStatement prep=con.prepareStatement("select nome from tab2");
			ResultSet r= prep.executeQuery();
			while (r.next()) { arr1.add(r.getInt("nome")); }
			return arr1;
		} catch (Exception e) { System.out.println("inserimento int non riuscito "+e.getMessage()); }
		return null;
	}

	public static void set() throws Exception {
		try {
			String s1 = "ciao";
			String s2 = "grazie";
			int i=3;
			int j=4;
			Connection con = getConnection();
			PreparedStatement test = con.prepareStatement("INSERT INTO tab2 (nome) VALUES(?)");
			test.setInt(1, i);
			test.executeUpdate();
		} catch (Exception e) {
			System.out.println("Inserimento non riuscito"+ e.getMessage());
		  }
	}
	
	/*come da nome, aggiunge una colonna di varchar che sarebbe tipo array di caratteri.
	  dopo la prima chiamata, non crea più un cazzo perchè la colonna già c'è*/
	public static void inserisciColonna() {
		try {
			Connection con = getConnection();
			PreparedStatement col = con.prepareStatement("ALTER TABLE tab2 ADD prova varchar(30)");
			col.executeUpdate();
		} catch (Exception e) {
			System.out.println("colonna non inserita" + e.getMessage());
		}
	}
	//serve per connettere java al db
	public static Connection getConnection() throws Exception {
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MC", "root","root");

			return con;
		} catch (Exception e) {
			System.out.println("get connection" + e.getMessage());
		}
		return null;
	}
	//crea una tabella,stesso discorso per la colonna con i duplicati
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