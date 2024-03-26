package com.biswo;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HtmlOperation {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Biswodb", "root", "Bishnu@123");
			pst = con.prepareStatement("Select * from employee");
			rs = pst.executeQuery();
			System.out.println("Querey Execute Successfully!");
			String data = "";
			data = data+"<html><body><center><table border='2' bordercolor='green' bgcolor='yellow'>";
			data = data+"<tr><th>Emp_id</th><th>Emp_name</th><th>Emp_add</th><th>Emp_sal</th></tr>";
			while(rs.next()) {
				data = data+"<tr>";
				data = data+"<td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getInt(4)+"</td>";
				data = data+"</tr>";
			}
			data = data+"</table></center></body></html>";
			FileOutputStream fos = new FileOutputStream("C:\\Users\\TOPHAN PALEI\\OneDrive\\Documents\\HTML\\empl.html",true);
			byte []b = data.getBytes();
			fos.write(b);
			System.out.println("Open empl html File to get the Data!");
			
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
