//Updatable Result set supported by Type-1 driver and mysql but not oracle 
//Here we perfromed the updation of record useing the Updatable Result set object
package com.biswo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdatableResultSet {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BiswoDb", "root", "Bishnu@123");
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery("Select * from Employee");
			
			while(rs.next()) {
				Float f1 = rs.getFloat(4);
				
				if(f1 < 10000) {
					f1 = f1 + 500;
					rs.updateFloat(3, f1);
					rs.updateRow();
					System.out.println(rs.getInt(1)+"Emp_id"+"Updated Successfully!");
				}
				
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
