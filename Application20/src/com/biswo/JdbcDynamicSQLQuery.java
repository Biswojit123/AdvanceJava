package com.biswo;

import java.sql.*;
import java.io.*;;
public class JdbcDynamicSQLQuery {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","bishnu");
			st = con.createStatement();
			
			//Take the Dynamic input
			while(true) {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
				System.out.print("Enter the Sql query :");
				String query = br.readLine();
				
				boolean b = st.execute(query);
				
				if(b == true) {
					rs = st.getResultSet();
					ResultSetMetaData md = rs.getMetaData();
					int count = md.getColumnCount();
					for(int i = 1; i <= count;i++) {
						System.out.print(md.getColumnName(i)+"\t");
					}
					System.out.println();
					System.out.println("================================");
					
					while(rs.next()) {
						for(int i = 1; i <= count;i++) {
							System.out.print(rs.getString(i)+"\t");
						}
						System.out.println();
					}
				}else {
					int rowCount = st.getUpdateCount();
					System.out.println(rowCount+" Updated Successfully!");
				}
				System.out.println("Are you want to execute one more SQL Query[Yes/No] :");
				String option = br.readLine();
				if(option.equalsIgnoreCase("Yes")) {
					continue;
				}else {
					break;
				}
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
