package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import database.DbConnection;

public class DeletePrepared {

	public static void main(String args[]) {
		try {
			Class.forName(DbConnection.driverName);
			Connection con = DriverManager.getConnection(DbConnection.connectionURL, DbConnection.userName,
					DbConnection.password);

			PreparedStatement stmt=con.prepareStatement("delete from employee where id=?");  
			Scanner scanner=new Scanner(System.in);
			ResultSet resultSet=stmt.executeQuery("select * from employee");
			System.out.println("Delete record");
			System.out.println("Available ids");
			while(resultSet.next())
			{
				System.out.println(resultSet.getInt("id"));
			}
			System.out.println("Enter id for updating");
			int id = scanner.nextInt();
			stmt.setInt(1,id);  
			  
			int i=stmt.executeUpdate();  
			System.out.println(i+" records deleted"); 

			

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
