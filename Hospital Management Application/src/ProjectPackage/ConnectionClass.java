package ProjectPackage;

import java.sql.*;

public class ConnectionClass {

	public static Connection getCon() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emrdb", "root", "password");
			return con;
		}
	
		catch(Exception e){
			return null;
		}
	}
}
