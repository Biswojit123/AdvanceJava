package com.biswo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BatchUpdationPreSt {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		BufferedReader br = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BiswoDb", "root", "Bishnu@123");
			pst = con.prepareStatement("Insert into Student values(?,?,?,?,?)");
			br = new BufferedReader(new InputStreamReader(System.in));
			
			while(true) {
				System.out.print("Enter the Student id :");
				String std_id = br.readLine();
				System.out.print("Enter the Student Name :");
				String std_name = br.readLine();
				System.out.print("Enter the Student date of Birth :");
				String std_dob = br.readLine();
				java.sql.Date d1 = java.sql.Date.valueOf(std_dob);
				System.out.print("Enter the Student date of Joining");
				String std_doj = br.readLine();
				java.sql.Date d2 = java.sql.Date.valueOf(std_doj);
				System.out.print("Enter the Student fees :");
				float std_fees = Float.parseFloat(br.readLine());
				
				pst.setString(1,std_id);
				pst.setString(2, std_name);
				pst.setDate(3, d1);
				pst.setDate(4, d2);
				pst.setFloat(5,std_fees);
				pst.addBatch();
				
				System.out.println("Sql Query add successfully to the Batch!");
				System.out.println("Are you want one more sql query to add batch :");
				String option = br.readLine();
				
				if(option.equalsIgnoreCase("yes")) {
					continue;
				}else {
					break;
				}	
			}
			int []row = pst.executeBatch();
			for(int i =0;i<row.length;i++) {
				System.out.print(row[i]+" row updated Successfully!");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
