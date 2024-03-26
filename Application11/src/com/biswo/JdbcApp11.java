package com.biswo;

import java.sql.*;
public class JdbcApp11 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st= null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","bishnu");
			st=con.createStatement();
			boolean c=st.execute("insert into Employee values(455,'Madhusmita jena','Banapur',2054,45)");
			System.out.println(c);
			
			int rowCount=st.getUpdateCount();
			System.out.println(rowCount+" rows Inserted Successfully!");
		}catch (Exception e) {
			e.printStackTrace();
		}finally  {
			try {
				st.close();
				con.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
