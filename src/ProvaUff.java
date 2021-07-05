import java.sql.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class ProvaUff {
	public static void main(String[] args) throws Exception 
	{ getConnection();
	  inserisci();
	  stampa();
	
	
	}
	
	
		public static Connection getConnection() throws Exception 
		{
			Connection con;
			try 
			{
				con = DriverManager.getConnection("jdbc:mysql://root@127.0.0.1:3306/mc", "root","root");
				return con;
			} catch (Exception e) {
				System.out.println ("get connection" + e.getMessage());
			  }
			return null;
		}
		
		public static void inserisci() 
		{   
			try 
			{
			String s1 = "ciao";
			Connection con = getConnection();
			PreparedStatement p = con.prepareStatement("INSERT INTO tabella (colonna) VALUES(?)" );
			p.setString(1,s1 );
			p.executeUpdate();
			} catch (Exception e) { System.out.println("Inserimento male  "+e.getMessage()); }
		}
		
		public static void stampa () 
		{
			try 
			{
			  Connection con = getConnection();
			  PreparedStatement p1 = con.prepareStatement("select colonna from tabella ");
			  ResultSet r = p1.executeQuery();
			  
			  while (r.next()) {
				  System.out.println("carmine: "+ r.getString("colonna")); 
			  }
			  	} catch (Exception e) { System.out.println("query male"); }
		}
			  		
		
		
		
}			
			



