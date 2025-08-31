package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	//まずDB接続の材料
	private static final String url =
			"jdbc:mysql://localhost:3306/product_management";
	private static final String user = "root";
	private static final String pass = "root";

	public static Connection getConnection()
			throws SQLException, ClassNotFoundException {

		//JDBCドライバのロード
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url, user, pass);

	}
}
