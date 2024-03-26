package com.biswo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PrepareStatementDemo {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		BufferedReader br = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BiswoDb", "root", "Bishnu@123");
			pst = con.prepareStatement("insert into employee values(?,?,?,?)");
			br = new BufferedReader(new InputStreamReader(System.in));
			while(true) {
				System.out.print("Enter the Emp_id 	 :");
				int emp_id = Integer.parseInt(br.readLine());
				System.out.print("Enter the Emp_name :");
				String emp_name = br.readLine();
				System.out.print("Enter the Emp_add  :");
				String emp_add = br.readLine();
				System.out.print("Enter the Emp_sal  :");
				int emp_sal = Integer.parseInt(br.readLine());
				
				pst.setInt(1, emp_id);
				pst.setString(2, emp_name);
				pst.setString(3, emp_add);
				pst.setInt(4, emp_sal);
				
				int rowCount=pst.executeUpdate();
				System.out.println(rowCount+" row Inserted Successfully!");
				System.out.println("Are you want one More rows [Yes/No] :");
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
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
