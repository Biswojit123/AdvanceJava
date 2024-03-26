package com.biswo;

import java.sql.*;
public class JdbcResultSetMetaData {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
				Class.forName("oracle.jdbc.OracleDriver");
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "bishnu");
				st = con.createStatement();
				rs = st.executeQuery("Select * from Employee");
				ResultSetMetaData rb = rs.getMetaData();
				int count = rb.getColumnCount();
				System.out.println("Number of Column is :"+count);
				for(int i = 1; i <= count ; i++) {
					System.out.println("Column name is :"+rb.getColumnName(i));
					System.out.println("Column name type is :"+rb.getColumnTypeName(i));
					System.out.println("Column size is :"+rb.getColumnDisplaySize(i));
					System.out.println("====================================================");
				}
			}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
