package com.biswo;

import java.sql.*;
public class JdbcMetaDataResultSet {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","bishnu");
			st = con.createStatement();
			rs = st.executeQuery("Select * from Student");
			ResultSetMetaData md = rs.getMetaData();
			int count = md.getColumnCount();
			System.out.println("Number of column is :"+count);
			//find the column name
			for(int i = 1;i <= count ; i++) {
				System.out.print(md.getColumnName(i)+"\t");
			}
			System.out.println();
			System.out.println("=======================================================");
			while(rs.next()) {
				for(int i =1 ; i <= count;i++) {
					System.out.print(rs.getString(i)+"\t");
				}
				System.out.println();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(Exception e) {
				
			}
		}

	}

}
