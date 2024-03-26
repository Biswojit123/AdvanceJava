//Update the Single column use the some condition
package com.biswo;

import java.sql.*;
import java.io.*;
public class JdbcApp06 {

	public static void main(String[] args) {
		
		Connection con=null;
		Statement st=null;
		BufferedReader br=null;
		
		try {
			//Loading the Class
			Class.forName("oracle.jdbc.OracleDriver");
			
			//Establish the Connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "bishnu");
			
			//Create the Statement
			st=con.createStatement();
			
			//Take the Dynamic input
			br=new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("Enter the TableName :");
			String tabName=br.readLine();
			
			
				System.out.print("Enter the Column name :");
				String colName=br.readLine();
				
				System.out.print("Enter the Where Condition Value :");
				String conValue=br.readLine();
				
				//Create the Query
				String query="Update "+tabName+" set "+colName+"=emp_sal+"+500+" where emp_sal < "+conValue;
				
				//Execute the Query
				int rowCount=st.executeUpdate(query);
				
				System.out.println(rowCount+" rows Updated Successfully!");
				
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
