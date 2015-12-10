import java.sql.*;

public class DBconnect {
	Connection con = null;
	String URL = "jdbc:mysql://localhost:3306/";
	String dbName = "MandarinSuperMarket";
	String driver = "com.mysql.jdbc.Driver";
	String userName = "aqeel";
	String password = "ozil";

	DBconnect() {
		try {
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection(URL + dbName, userName, password);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String args[]) {
		new DBconnect();
	}

}
