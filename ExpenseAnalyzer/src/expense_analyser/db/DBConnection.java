package expense_analyser.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static String url = "jdbc:mysql://localhost:3306/expense_analyser";
	private static String usr_name = "root";
	private static String password = "Shyam@2004";

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url, usr_name, password);

		} catch (SQLException e) {
			System.out.println("DB Connection failed.");
			e.printStackTrace();
			return null;
		}
	}

}
