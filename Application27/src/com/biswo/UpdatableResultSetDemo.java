package com.biswo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdatableResultSetDemo {
	

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BiswoDb", "root", "Bishnu@123");
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery("Select * from Employee ");
			int flag = 0;
			while(rs.next()) {
				int eno = rs.getInt(1);
				int esal = rs.getInt("Emp_sal");
				if(esal < 10000) {
					rs.deleteRow();
					System.out.println(eno+" Employee Deleted Successfully!");
					flag = 1;
				}
			}
			if(flag == 0) {
				System.out.println("No rows are deleted!");
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
