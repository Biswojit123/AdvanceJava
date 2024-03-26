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
		ResultSet rs = null;
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Biswodb", "root", "Bishnu@123");
			 pst = con.prepareStatement("Select * from student where std_fees = ? ");
			 br = new BufferedReader(new InputStreamReader(System.in));
			 
			 System.out.print("Enter the Student fees :");
			 Float f1 = Float.parseFloat(br.readLine());
			 
			 pst.setFloat(1, f1);
			 rs = pst.executeQuery();
			 boolean b = rs.next();
			 if(b == true ) {
				 System.out.print("Student details are :");
				 System.out.println("=======================");
				 System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getDate(3)+"\t"+rs.getDate(4)+"\t"+rs.getFloat(5));
			 }else {
				 System.out.print("Student record is not Avilable!");
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
