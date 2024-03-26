//To update the Specific row and column
package com.biswo;

import java.sql.DriverManager;
import java.sql.*;
import java.io.*;
public class JdbcApp05 {

	public static void main(String[] args)throws ClassNotFoundException,SQLException,IOException{
		//Loading the Class to memory
		Class.forName("oracle.jdbc.OracleDriver");
		
		//Establish Connection 
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "bishnu");
		
		//Create a Statement
		Statement st=con.createStatement();
		
		//Take the Dynamic Input
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Enter the Table name :");
		String tabName=br.readLine();
		while(true) {
			System.out.print("Enter the Column name :");
			String colName=br.readLine();
			
			System.out.print("Enter the column value :");
			String colValue=br.readLine();
			
			System.out.print("Enter the Condition value :");
			String condValue=br.readLine();
			
			//write the Query for update specific row and column
			String query="Update "+tabName+" set "+colName+"="+colValue+" where emp_id="+condValue;
			
			
			//System.out.println(query);
			
			//Execute the Query
			int rowCount=st.executeUpdate(query);
			System.out.println(rowCount+" Row updated Successfully!");
			
			System.out.println("Update one more row [Yes/No] :");
			String option=br.readLine();
			
			if(option.equalsIgnoreCase("Yes")) {
				continue;
			}else {
				break;
			}
		}
	}

}
