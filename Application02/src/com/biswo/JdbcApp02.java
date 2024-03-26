package com.biswo;

import java.sql.*;
import java.io.*;
public class JdbcApp02 {

	public static void main(String[] args) throws ClassNotFoundException,SQLException,IOException{
		// TODO Auto-generated method stub
		//loading and Register the Driver
		Class.forName("oracle.jdbc.OracleDriver");
		
		//Establish the connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","bishnu");
		
		//Create the Statement 
		Statement st=con.createStatement();
		
		//Take the Dynamic input
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		//take the table name
		System.out.print("Enter the table name :");
		String tabName=br.readLine();
		
		//Create the Query
		String query="Create table "+tabName+"(";
		
		//Here Declare a variable for store primary key column
		String primaryKeys="primary key(";
		
		//Here Declare a variable that ensure if we want multiple primary key
		int primaryKeyCount=0;
		
		//give to the column to the table
		while(true) {
			System.out.print("Enter the column :");
			
			String coluName=br.readLine();
			
			System.out.print("Enter the Data type :");
			
			String coluType=br.readLine();
			
			System.out.print("Enter the size of cloumn :");
			
			int size=Integer.parseInt(br.readLine());
			
			query=query+coluName+" "+coluType+"("+size+")";
			
			System.out.print("Is it Primary key[Yes/No] :");
			
			String primaryKeyOption=br.readLine();
			
			if(primaryKeyOption.equalsIgnoreCase("yes")) {
				if(primaryKeyCount == 0) {
					primaryKeys=primaryKeys+coluName;
					primaryKeyCount ++;
				}else {
					primaryKeys=primaryKeys+","+coluName;
				}
			}
			
			System.out.print("Are you add One more column[Yes/No] :");
			String coluOption=br.readLine();
			
			if(coluOption.equalsIgnoreCase("Yes")) {
				query=query+",";
				continue;
			}else {
				query=query+","+primaryKeys+"))";
				break;
			}
		}
		//System.out.print(query);
		//Execute the Query
		st.executeUpdate(query);
		System.out.print("Create "+tabName+" Successfully!");
		
		st.close();
		con.close();
	}

}
