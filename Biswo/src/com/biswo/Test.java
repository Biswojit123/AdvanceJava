package com.biswo;
import java.sql.*;
import java.io.*;
public class Test {

		public static void main(String[] args)throws ClassNotFoundException ,SQLException,IOException{
			// TODO Auto-generated method stub
			Class.forName("oracle.jdbc.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "bishnu");
			
			Statement st=con.createStatement();
			
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			String tName=br.readLine();
			
			String query="Create table "+tName+"(std_id int primary key,std_name varchar2(20))";
			
			st.executeUpdate(query);
			
			System.out.println("Successfully");
			st.close();
			con.close();
			
	}

}
