package com.biswo;

import java.sql.*;
public class MysqlJdbc {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BiswoDb","root","Bishnu@123");
			st = con.createStatement();
			rs = st.executeQuery("Select * from Employee");
			System.out.println("All data are :");
			System.out.print("Emp_id |Emp_name|Emp_add|Emp_sal\n");
			System.out.println("===================================");
			while(rs.next()) {
				System.out.print(rs.getInt("Emp_id")+"\t");
				System.out.print(rs.getString("Emp_name")+"\t");
				System.out.print(rs.getString("Emp_add")+"\t");
				System.out.print(rs.getInt("Emp_sal")+"\n");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
				st.close();
				rs.close();
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
