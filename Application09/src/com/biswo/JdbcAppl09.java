package com.biswo;

import java.sql.*;
public class JdbcAppl09 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","bishnu");
			st=con.createStatement();
			
			//execute the  query and return the result set object
			rs=st.executeQuery("select * from Employee");
			
			//we fetch the record from the result set we most fllow the two condition 
			//1st we have to check the next record present in the result set or not by useing the next() method of result set interface
			//if it present it return true other wise return false
			//2nd if the record present then we fetch the data by useing some method that is getXXX(int colIndex) or 
			//getXXX(String Col_name)
			System.out.println("emp_id \t emp_name \t emp_add \t emp_sal \t emp_comm");
			System.out.println("=================================================================");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t\t"+rs.getInt(5)+"\n");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
