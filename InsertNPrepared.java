package dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import database.DbConnection;

public class InsertNPrepared {
	public static void main(String args[]) {
		try {
			Class.forName(DbConnection.driverName);
			Connection con = DriverManager.getConnection(DbConnection.connectionURL, DbConnection.userName,
					DbConnection.password);
			/*
			 * Statement stmt = con.createStatement();
			 * 
			 * int result =
			 * stmt.executeUpdate("insert into employee values(103,'Irfan',35)");
			 */
			PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?)");

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			do {
				System.out.println("enter id:");
				int id = Integer.parseInt(br.readLine());
				System.out.println("enter name:");
				String name = br.readLine();
				System.out.println("enter age:");
				float age = Float.parseFloat(br.readLine());

				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setFloat(3, age);
				int i = ps.executeUpdate();
				System.out.println(i + " records affected");

				System.out.println("Do you want to continue: y/n");
				String s = br.readLine();
				if (s.startsWith("n")) {
					break;
				}
			} while (true);

			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}