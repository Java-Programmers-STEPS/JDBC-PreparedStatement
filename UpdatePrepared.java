package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import database.DbConnection;

public class UpdatePrepared {
	public static void main(String args[]) {
		try {
			Class.forName(DbConnection.driverName);
			Connection con = DriverManager.getConnection(DbConnection.connectionURL, DbConnection.userName,
					DbConnection.password);

			PreparedStatement stmt = con.prepareStatement("update employee set name=? where id=?");
			ResultSet resultSet=stmt.executeQuery("select * from employee");
			System.out.println("Available ids");
			while(resultSet.next())
			{
				System.out.println(resultSet.getInt("id"));
			}
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter id for updating");
			int id = scanner.nextInt();
			System.out.println("Enter name for updating");
			String name = scanner.next();
			stmt.setString(1, name);// 1 specifies the first parameter in the query i.e. name
			
			stmt.setInt(2, id);

			int i = stmt.executeUpdate();
			System.out.println(i + " records updated");

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
