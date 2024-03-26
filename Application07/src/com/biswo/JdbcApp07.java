package com.biswo;

import java.sql.*;
import java.io.*;
public class JdbcApp07 {

	public static void main(String[] args) {
		
		Connection con=null;
		Statement st=null;
		BufferedReader br=null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "bishnu");
			
			st=con.createStatement();
			
			br=new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter the table name :");
			String tabName=br.readLine();
			
			while(true) {
				System.out.print("Enter the Condition value :");
				int conValue=Integer.parseInt(br.readLine());
				
				//create the query
				String query="Delete from "+tabName+" where emp_sal<"+conValue;
				
				//execute the Query
				int rowCount=st.executeUpdate(query);
				
				System.out.println(rowCount+" rows deleted Successfully!");
				
				System.out.print("One more row Deleted [Yes/No]");
				
				String option=br.readLine();
				
				if(option.equalsIgnoreCase("Yes")) {
					continue;
				}else {
					break;
				}
			}
			
			
			
		}catch (Exception e) {
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
