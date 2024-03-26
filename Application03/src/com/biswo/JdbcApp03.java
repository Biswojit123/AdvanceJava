//Insert the Record into Database table
package com.biswo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.*;
public class JdbcApp03 {

	public static void main(String[] args)throws SQLException {
		//Here declare the Resource 
		Connection con=null;
		Statement st=null;
		BufferedReader br=null;
		
		//use the try catch use to Exception
		
		try {
			//Loading the .class  without creating object
			Class.forName("oracle.jdbc.OracleDriver");
			//Establish the Connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "bishnu");
			//create the statement 
			st=con.createStatement();
			//take the dynamic input
			br=new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter the Table name :");
			String tabName=br.readLine();
			
			while(true) {
				//take the Employee id
				System.out.print("Enter the Employee Id :");
				int empId=Integer.parseInt(br.readLine());
				
				//take the Employee name
				System.out.print("Enter the Employee Name :");
				String name=br.readLine();
				
				//take the Employee Address
				System.out.print("Enter the Employee Address :");
				String add=br.readLine();
				
				//take Employee salary 
				System.out.print("Enter the Employee Salary :");
				int salary=Integer.parseInt(br.readLine());
				
				//Take the Employee 
				System.out.print("Enter the Employee Commitions :");
				int comm=Integer.parseInt(br.readLine());
				
				//Create the Query 
				String query="Insert into "+tabName+" values("+empId+",'"+name+"','"+add+"',"+salary+","+comm+")";
				
				//Execute the Query
				st.executeUpdate(query);
				
				System.out.print("Insert Successful into table "+tabName);
				
				System.out.print("If you want Once more record[Yes/No] :");
				String option=br.readLine();
				
				if(option.equalsIgnoreCase("Yes")) {
					continue;
				}else {
					break;
				}
			}
	
		}catch(IOException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
				st.close();
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
