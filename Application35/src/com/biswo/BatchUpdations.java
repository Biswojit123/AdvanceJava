//BatchUpdation use Statement Object
package com.biswo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BatchUpdations {

	public static void main(String[] args) {
		Connection con = null;
		Statement pst = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BiswoDb", "root", "Bishnu@123");
			pst = con.createStatement();
			pst.addBatch("Insert into student values('PG22MCA10','Aditya','2002-03-15','2022-02-09',345)");
			pst.addBatch("update student set Std_fees=std_fees+500 where std_fees < 500");
			pst.addBatch("Delete from student where std_id = 'PG22MCA02'");
			int row[] = pst.executeBatch();
			
			//Here We find How many no of row Updated
			for(int i =0 ;i<row.length;i++) {
				System.out.println(row[i]+" row Updated Successfully!");
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
