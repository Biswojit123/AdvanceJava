package com.biswo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class NestedTableHtml {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		BufferedReader br = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Biswodb", "root", "Bishnu@123");
			pst = con.prepareStatement("insert into Student values(?,?,?,?,?)");
			br = new BufferedReader(new InputStreamReader(System.in));
			
			while(true) {
				System.out.print("Enter the Student id    :");
				String std_id = br.readLine();
				pst.setString(1,std_id);
				System.out.print("Enter the Student Name  :");
				String std_name = br.readLine();
				pst.setString(2,std_name);
				System.out.print("Enter the Student Date of Birth :");
				String str = br.readLine();
				java.sql.Date d1 = java.sql.Date.valueOf(str);
				pst.setDate(3,d1);
				System.out.print("Enter the Student Joining Date :");
				String str1 = br.readLine();
				java.sql.Date d2 = java.sql.Date.valueOf(str1);
				pst.setDate(4,d2);
				System.out.print("Enter the Student Fees :");
				Float fess = Float.parseFloat(br.readLine());
			
				pst.setFloat(5,fess);
				
				int rowCount = pst.executeUpdate();
				
				if(rowCount == 1) {
					System.out.println(rowCount+" row inserted Successfully!");
				}else {
					System.out.println("Insertion Filure!");
				}
				System.out.println("Are you want to insert one more student Information [yes/no]");
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
