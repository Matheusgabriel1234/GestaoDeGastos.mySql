package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/bankbd","root","Telepa33.");
			
		}catch(SQLException e) {
			System.out.println("Banco não conectado");
			e.printStackTrace();
			
		}
		return null;
	}
}
