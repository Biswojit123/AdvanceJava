package com.biswo;

import java.sql.*;
import java.io.*;
public class JdbcApp08 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		BufferedReader br=null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "bishnu");
			st=con.createStatement();
			
			br=new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter the Table name :");
			String tabname=br.readLine();
			
			String query="Drop table "+tabname;
			
			st.executeUpdate(query);
			System.out.println(tabname+" table deleted successfully!");
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
