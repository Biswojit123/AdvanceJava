//Add Column to the Table 
package com.biswo;

import java.sql.*;
import java.io.*;
public class JdbcApp04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		Statement st=null;
		BufferedReader br=null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","bishnu");
			
			st=con.createStatement();
			
			br=new BufferedReader(new InputStreamReader(System.in));
			while(true) {
				System.out.print("Enter the table name :");
				String tabName=br.readLine();
				
				System.out.print("Enter the New column :");
				String couName=br.readLine();
				
				System.out.print("Enter the Data type :");
				String couType=br.readLine();
				
				System.out.print("Enter the Size :");
				int size=Integer.parseInt(br.readLine());
				
				//Create the Query
				String query="Alter table "+tabName+" Add "+couName+" "+couType+"("+size+")";
				
				System.out.print("Is a primary key :");
				String primaryOption=br.readLine();
				
				//here Primary key apply
				if(primaryOption.equalsIgnoreCase("Yes")) {
					query=query+" primary key";
				}
				//execute the Query
				int rowCount=st.executeUpdate(query);
				System.out.println(rowCount+" add Successfully!");
				
				System.out.println("You want to add one more column :");
				String option=br.readLine();
				if(option.equalsIgnoreCase("Yes")) {
					continue;
				}else {
					break;
				}
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
