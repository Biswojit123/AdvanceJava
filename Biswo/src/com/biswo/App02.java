package com.biswo;

import java.sql.*;
import java.io.*;
public class App02 {

	public static void main(String[] args)throws ClassNotFoundException,SQLException,IOException {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.OracleDriver");
		
		//Connection now Create
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "bishnu");
		
		//create Statement
		
		Statement st=con.createStatement();
		
		//Take the Dynamic Input
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("Enter the Student id:");
			int std_id=Integer.parseInt(br.readLine());
			System.out.println("Enter the student name");
			String name=br.readLine();
			
			//prepare Query
			
			String query="insert into biswo values("+std_id+",'"+name+"')";
			
			//Execute the Query
			st.executeUpdate(query);
			System.out.println("Inserted Successfully");
			System.out.println("Are you want to insert One More record[Y/N]:");
			String option=br.readLine();
			if(option.equals("N")) {
				break;
			}
			
		}
		
		st.close();
		con.close();
		
	}

}
