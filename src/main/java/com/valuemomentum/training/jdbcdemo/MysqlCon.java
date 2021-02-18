package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MysqlCon {
	public static void main(String[] args)
	{
		//creating objects
		Connection con;
		Statement stmt;
		ResultSet rs;
		try {
			// Register JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//open a connection
			System.out.println("connecting to database...");
			con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/classicmodels","root","Valli@488!!");
			
			/// Execute a query
			 stmt=con.createStatement();
			 rs=stmt.executeQuery("select * from  employees");
			 // Extract data from result set
			 while(rs.next()) {
				 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)
				 +" "+rs.getString(4)+" "+rs.getString("email")+" "+rs.getString(6)
				 +" "+rs.getInt(7)+" "+rs.getString(8));
			 }
			 rs.close();
			 stmt.close();
			 con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
			 
			 
		}
		

}

