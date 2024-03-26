//Scroll sensitive result set object supported by type-1 driver and Mysql provided Driver but not Oracle driver also
//Scroll Non sensitive Result set object no any driver supported
package com.biswo;

import java.sql.*;

public class MysqlJdbcPro {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BiswoDb", "root", "Bishnu@123");
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery("Select * from employee");
			System.out.println("Before Updation All data are:");
			System.out.println("Emp_id|Emp_name|Emp_add|Emp_sal");
			System.out.println("===================================");
			while(rs.next()) {
				System.out.print(rs.getInt("Emp_id")+"\t");
				System.out.print(rs.getString("Emp_name")+"\t");
				System.out.print(rs.getString("Emp_add")+"\t");
				System.out.print(rs.getInt("Emp_sal")+"\n");
			}
			System.out.println("Puasing the Program for Few Time!");
			System.in.read();
			rs.beforeFirst();
			System.out.println("After Updation All data are:");
			System.out.println("Emp_id|Emp_name|Emp_add|Emp_sal");
			System.out.println("===================================");
			while(rs.next()) {
				rs.refreshRow();
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
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
