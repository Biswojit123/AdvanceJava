package com.biswo;

import java.sql.*;
import java.io.FileOutputStream;
public class JdbcApp16 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		FileOutputStream fos = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","bishnu");
			st = con.createStatement();
			rs = st.executeQuery("Select * from Employee");
			String data = "";
			data = data+"Emp_id\t,Emp_name\t,Emp_add\t,Emp_sal\t,Emp_com\n";
			while(rs.next()) {
				data = data+rs.getInt("Emp_id")+"\t";
				data = data+rs.getString("Emp_name")+"\t";
				data = data+rs.getString("Emp_add")+"\t";
				data = data+rs.getInt("Emp_sal")+"\t\t";
				data = data+rs.getInt("Emp_com")+"\n";
			}
			fos = new FileOutputStream("C:/Users/TOPHAN PALEI/OneDrive/Documents/HTML/emp.txt");
			byte []b = data.getBytes();
			fos.write(b);
			System.out.println("Data is transferd to C:/Users/TOPHAN PALEI/OneDrive/Documents/HTML/emp.txt");
		}catch(Exception e) {
			e.printStackTrace();
		}finally  {
			try {
				rs.close();
				st.close();
				con.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}