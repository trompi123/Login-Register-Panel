package code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	
	public static Connection con;
	public static Statement stmt;
	public static ResultSet rs;
	public static ResultSet rsCopy;
	public static int lenght;
	public static String table[];

	public static void main(String[] args) {
		
	}
	
	public static void startConnect(String usuario, String clave, String url) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(url,usuario,clave);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void offConnect() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void Write(String command) {
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(command);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*public static ResultSet Read(String command) {
		try {
			rs = stmt.executeQuery(command);
			while(rs.next()) {
				lenght ++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	} */
}
