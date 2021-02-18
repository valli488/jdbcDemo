package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDemo {

	public static void main(String[] args) throws Exception {
       Connection con;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		// creating connection object
		System.out.println("Connection to database");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Valli@488!!");
		System.out.println("driver is loaded");
		Statement stmt=con.createStatement();
		con.setAutoCommit(false);
		try
		{
			int i1=stmt.executeUpdate("insert into candidate_skills values(101,6)");
			int i2=stmt.executeUpdate("update skills set name='Spring' where id=2");
			int i3=stmt.executeUpdate("delete from  candidates where id=55");
			con.commit();
			System.out.println("Transaction is success");
		}
	catch(Exception e)
		{
		try
		{
			con.rollback();
			System.out.println("Transaction is failed");
		}
          catch(Exception ex)
		{
	      System.out.println(ex);
		}
		}//end of catch
		}
		
		// TODO Auto-generated method stub

	}


