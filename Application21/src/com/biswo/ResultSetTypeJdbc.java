package com.biswo;

import java.sql.*;

public class ResultSetTypeJdbc {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","bishnu");
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			//Execute the Statement
			rs = st.executeQuery("Select * from Company");
			System.out.println("Print all data in forword direction:");
			System.out.print("Com_id\tCom_name\tCom_add\tCom_pay\n");
			System.out.println("============================================");
			while(rs.next()) {
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3)+"\t");
				System.out.print(rs.getInt(4)+"\n");
			}
			System.out.println("");
			System.out.println("Print all data in Backword direction:");
			System.out.print("Com_id\tCom_name\tCom_add\tCom_pay\n");
			System.out.println("===========================================");
			while(rs.previous()) {
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3)+"\t");
				System.out.print(rs.getInt(4)+"\n");
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
