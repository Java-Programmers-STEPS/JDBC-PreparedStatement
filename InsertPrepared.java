package dao;

import java.sql.*;

import database.DbConnection;

class InsertPrepared {
	public static void main(String args[]) {
		try {
			Class.forName(DbConnection.driverName);
			Connection con = DriverManager.getConnection(DbConnection.connectionURL, DbConnection.userName,
					DbConnection.password);

			PreparedStatement stmt = con.prepareStatement("insert into employee values(?,?,?)");
			stmt.setInt(1, 104);
			stmt.setString(2, "Ratan");
			stmt.setInt(3, 30);

			int i = stmt.executeUpdate();
			System.out.println(i + " records inserted");

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}