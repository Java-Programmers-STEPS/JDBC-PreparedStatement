package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import database.DbConnection;

public class ViewPrepared {
	public static void main(String args[]) {
		try {
			Class.forName(DbConnection.driverName);
			Connection con = DriverManager.getConnection(DbConnection.connectionURL, DbConnection.userName,
					DbConnection.password);
			/*
			 * Statement stmt = con.createStatement(); ResultSet rs =
			 * stmt.executeQuery("select * from employee");
			 */
			PreparedStatement stmt = con.prepareStatement("select * from employee");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
			}

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
