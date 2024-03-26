package application29;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateOperation {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		BufferedReader br = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BiswoDb","root","Bishnu@123");
			pst = con.prepareStatement("Update Employee set emp_sal = emp_sal +? where emp_sal < ?");
			
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter the Bonus 		 :");
			int bonus = Integer.parseInt(br.readLine());
			System.out.print("Enter the Range Amount :");
			int range_amu = Integer.parseInt(br.readLine());
			
			pst.setInt(1, bonus);
			pst.setInt(2, range_amu);
			
			int rowCount = pst.executeUpdate();
			
			System.out.println(rowCount+" Record are Updated Successfully!");
			
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
