//Here we explain  when we provide the select statement inside the executeUpdate() method what happen?
//answer-->it depends upon the driver class when we use the Type-1 driver it give the Exception but in 
//type-4 driver it does't give any error it give the how many row present inside the result set object
//that number return to the rowCount variable
package com.biswo;
import java.sql.*;
public class JdbcApp12 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","bishnu");
			st=con.createStatement();
			int rowCount=st.executeUpdate("Select * from Employee");
			System.out.println(rowCount);
			rs=st.getResultSet();
			System.out.println("Emp_id \t Emp_Name \t Emp_Add \t Emp_Sal \t Emp_com ");
			System.out.println("--------------------------------------------------------");
			while(rs.next()) {
				System.out.println(rs.getInt("Emp_id")+"\t"+rs.getString("emp_name")+"\t"+rs.getString("emp_add")+"\t\t"+rs.getInt("emp_sal")+"\t"+rs.getInt("emp_com")+"\n");
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
