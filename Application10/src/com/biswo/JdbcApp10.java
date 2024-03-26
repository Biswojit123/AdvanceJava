package com.biswo;

import java.sql.*;

public class JdbcApp10 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","bishnu");
			st=con.createStatement();
			
			//Create the Query
			boolean b=st.execute("select * from employee");
			System.out.println(b);
			
			rs=st.getResultSet();
			System.out.println("emp_no \t emp_name \t emp_add \t emp_sal \t emp_comm");
			System.out.println("=========================================================");
			while(rs.next()) {
				System.out.println(rs.getInt("Emp_id")+"\t"+rs.getString("Emp_Name")+"\t"+rs.getString("Emp_add")+"\t"+rs.getInt("Emp_sal")+"\t"+rs.getInt("Emp_com")+"\n");
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
