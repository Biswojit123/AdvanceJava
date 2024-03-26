package com.biswo;

import java.sql.*;
public class ResultSetMethod {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","bishnu");
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery("Select * from Company");
			
			rs.afterLast();
			rs.previous();
			System.out.println(rs.getInt(1));
			rs.beforeFirst();
			rs.next();
			System.out.println(rs.getInt(1));
			rs.last();
			System.out.println(rs.getInt(1));
			rs.first();
			System.out.println(rs.getInt(1));
			rs.absolute(3);
			System.out.println(rs.getInt(1));
			rs.absolute(-3);
			System.out.println(rs.getInt(1));
			rs.first();
			rs.relative(3);
			System.out.println(rs.getInt(1));
			rs.relative(-3);
			System.out.println(rs.getInt(1));
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
