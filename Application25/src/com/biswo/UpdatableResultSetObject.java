//Insert the Record use Updatable ResultSet 
//Updatable Result set Supported by type -1 driver,type-4 driver provided by mysql but not oracle
package com.biswo;

import java.sql.*;
import java.io.*;
public class UpdatableResultSetObject {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		BufferedReader br = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BiswoDb", "root", "Bishnu@123");
			/*Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","bishnu");*/
			//We create the Updatable Resultset object
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery("Select * from employee");
			br = new BufferedReader(new InputStreamReader(System.in));
			rs.moveToInsertRow();
			
			while(true) {
				System.out.print("Enter the Employee Id :");
				int Emp_id = Integer.parseInt(br.readLine());
				System.out.print("Enter the Employee Name:");
				String Emp_name = br.readLine();
				System.out.print("Enter the Employee Address :");
				String Emp_add = br.readLine();
				System.out.print("Enter the Employee Salary :");
				float Emp_sal = Float.parseFloat(br.readLine());
				//Here insert the data to Updatable Result in the cursor position
				rs.updateInt(1, Emp_id);
				rs.updateString(2, Emp_name);
				rs.updateString(3, Emp_add);
				rs.updateFloat(4, Emp_sal);
				
				//here the the Result set object new Inserted row insert into database by useing below method
				rs.insertRow();
				
				System.out.println("Inserted Successfully!");
				System.out.print("Are you want insert one more row [Yes/No] :");
				String option = br.readLine();
				
				if(option.equalsIgnoreCase("Yes") ) {
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
