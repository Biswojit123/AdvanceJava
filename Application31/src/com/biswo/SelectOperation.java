package com.biswo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectOperation {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		BufferedReader br = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BiswoDb","root", "Bishnu@123");
			pst = con.prepareStatement("Select * from employee where emp_sal <?");
			br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("Enter the Salary Range :");
			int range = Integer.parseInt(br.readLine());
			//set the range to the PreparedStatement Object
			pst.setInt(1, range);
			ResultSet rs = pst.executeQuery();
			
			System.out.println("Excecute Successfully :");
			System.out.print(" Emp_id|Emp_name|Emp_add|Emp_sal\n");
			System.out.print("==============================================\n");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\n");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
