package com.serviceHub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConectivity {
	
	public static void databaseConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/kirit","root","");
			Statement st =  con.createStatement();
		 	ResultSet rs = st.executeQuery("select * from test");
			
		 	while(rs.next())
		 	{
		 		int ID = rs.getInt("id");
		 		String name = rs.getString("name");
		 		String password = rs.getString("password");
		 		String mobile = rs.getString("mobile");
		 		System.out.println("ID : "+ID);
		 		System.out.println("Name : "+name);
		 		System.out.println("Password : "+password);
		 		System.out.println("Mobile : "+mobile);
		 	}
		 	
		 	con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void  main(String...str) {
		databaseConnection();
	}
}
