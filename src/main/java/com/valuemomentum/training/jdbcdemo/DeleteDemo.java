package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeleteDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//creating objects
		Connection con;
		Statement stmt;
		ResultSet rs;
		int cnt;
		try {
			// Register JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//open a connection
			System.out.println("connecting to database...");
			con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mysqljdbc","root","Valli@488!!");
			
			String sql="Delete from candidates where rtrim(last_name) like\'Y%g\';";
			System.out.println(" ");
			/// Execute a query
			 stmt=con.createStatement();
			 cnt=stmt.executeUpdate(sql) ;
			 if(cnt>0)
			 {
				 System.out.println("record for young is deleted");
				 
			 }
			 
			 
          
			
			
			 con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
}

		



	}


