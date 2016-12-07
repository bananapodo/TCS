package first.sample.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.plaf.basic.BasicComboBoxUI.ComboBoxLayoutManager;

import com.mysql.jdbc.Statement;

public class InfoDAO {
	// public static void main(String[] args) {
	// String[] s = ReadConfig.getProjectKey();
	public static void insertProjectList() {
		String[] projectData = ReadConfig.getProjectKey();

		String sql = "insert into list(project_name,project_key,save_type,save_path,open_date,close_date)" + "values(?,?,?,?,?,?)";

		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			con = DBConnection.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, projectData[0]);
			pstmt.setString(2, projectData[1]);
			pstmt.setString(3, projectData[2]);
			pstmt.setString(4, projectData[3]);
			pstmt.setString(5, projectData[4]);
			pstmt.setString(6, projectData[5]);

			int i = pstmt.executeUpdate();
			if (i == 1) {
				System.out.println("ProjectList Insert Success");
			} else {
				System.out.println("ProjectList Insert Fail");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void insertData(String[] columnArray, HashMap<String, String> valueArray) {
		// String[] columnArray = ReadConfig.columnArray();
		// HashMap<String, String> valueArray = FileParseJson.valueArray();

		String sql = "insert into detail(" + columnArray[0];

		for (int i = 1; i < columnArray.length; i++) {

			if (columnArray[i] == null) {
				break;
			} else {
				sql += "," + columnArray[i];
			}
		}

		sql += ")values('" + valueArray.get(columnArray[0]);
		for (int i = 1; i < columnArray.length; i++) {
			if (columnArray[i] == null) {
				break;
			}
			sql += "','" + valueArray.get(columnArray[i]);
		}

		sql += "')";

		System.out.println(sql);

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DBConnection.getConnection();
			pstmt = con.prepareStatement(sql);

			int result = pstmt.executeUpdate();

			if (result == 1) {
				System.out.println("Data Insert Success");
			} else {
				System.out.println("Data Insert Fail");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public int getListCount(String project_key) {
		ResultSet rs;
		int result = 0;
		// int count = 0;
		String sql = "select count(*) from detail where project_key = '"+project_key+"'";

		Connection con = null;
		Statement stmt = null;
		try {
			con = DBConnection.getConnection();
			stmt = (Statement) con.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				result = rs.getInt(1);
			}
			// System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
