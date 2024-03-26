package com.biswo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteOperation {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		BufferedReader br = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BiswoDb","root","Bishnu@123");
			pst = con.prepareStatement("Delete from employee where Emp_sal < ?");
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter the Range :");
			int range = Integer.parseInt(br.readLine());
			
			pst.setInt(1,range);
			int rowCount = pst.executeUpdate();
			System.out.println(rowCount+"Deleted Successfully");
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
