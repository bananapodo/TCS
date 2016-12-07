package first.sample.util;

import java.sql.DriverManager;

import java.sql.SQLException;

import java.sql.Connection;

//import java.sql.PreparedStatement;

public class DBConnection {

	// public static void main(String[] args) {
	static final String driver = "com.mysql.jdbc.Driver";
	static final String url = "jdbc:mysql://127.0.0.1:3306/tcs";
	static String id = "root";
	static String pw = "oracle";

	public static Connection getConnection() throws Exception {

		Class.forName(driver);
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("DB Connect Success");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;

	}

	// try {
	// Class.forName(JDBC_DRIVER);
	// con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
	// "root", "1234");
	// if (con != null)
	//
	// System.out.println(" mysql connect ");
	//
	// String sql = "insert into detail(name,email,phone)";
	//
	// sql = sql + " values('cc','aa','bb')";
	//
	// PreparedStatement pstmt = con.prepareStatement(sql);
	//
	// int result = pstmt.executeUpdate();
	//
	// if (result == 1)
	//
	// System.out.println("data insert success");
	//
	// else
	//
	// System.out.println("data insert fail");
	// } catch (ClassNotFoundException e) {
	// e.printStackTrace();
	// } catch (SQLException e) {
	//
	// e.printStackTrace();
	// }

}