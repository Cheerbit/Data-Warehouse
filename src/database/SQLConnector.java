package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnector {
	public Connection conn;
	static int counter = 0;
	static int exCounter = 0;
	static String log = "";
	
	public SQLConnector() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost/BIOINFO";
			conn = DriverManager.getConnection(url, "root", "root");
		} 
		catch(ClassNotFoundException ex){System.err.println("1:" + ex.getMessage()); exCounter++;}
		catch(IllegalAccessException ex){System.err.println("2:" + ex.getMessage()); exCounter++;}
		catch(InstantiationException ex){System.err.println("3:" + ex.getMessage()); exCounter++;}
		catch(SQLException ex)          {System.err.println("4:" + ex.getMessage()); exCounter++;}
	}
	
	public static int getExCounter() {
		return exCounter;
	}
	
	public static String getLog() {
		return log;
	}
}
