//Here the Question is when we provide the non-select Query inside the executeQuery method then what happen?
//Answer->>It will create the Exception when we use the Type-1 driver and another hand if we use the Type-4
//driver then it does't give any error .here simple result set object store default value that is null

package com.biswo;

import java.sql.*;
public class JdbcApp13 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "bishnu");
			st=con.createStatement();
			rs=st.executeQuery("Insert into employee values(789,'Rasmita jena','tichhini',20678,345)");
			int rowCount=st.getUpdateCount();
			System.out.print(rowCount+" rows inserted successfully!");
		}catch (Exception e) {
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
