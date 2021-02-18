package com.valuemomentum.training.jdbcdemo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchDemo {

	public static void main(String[] args) throws Exception {
		Connection con;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		// creating connection object
		System.out.println("Connection to database");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Valli@488!!");
		
		Statement stmt=con.createStatement();
		
		stmt.addBatch("insert into candidate_skills values(100,5)");
		stmt.addBatch("update  skills set name='Ajax' where id=3");
		stmt.addBatch(" delete from candidates where id=80");
		con.setAutoCommit(false);
		try
		{
			stmt.executeBatch();
			con.commit();
			System.out.println("batch is successfully executed");
		}
		catch(Exception e)
		{
			try
			{
				con.rollback();
				System.out.println("batch is failed");
				System.out.println("Exception is"+e);
			}
			catch(Exception e1)
			{
				System.out.println("Exception is"+e1);
			}
	
	//end of outer catch
	stmt.close();
	con.close();
		}
			
		}
		
		// TODO Auto-generated method stub

	}


