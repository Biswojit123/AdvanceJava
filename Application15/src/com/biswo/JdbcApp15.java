package com.biswo;
import java.sql.*;
import java.io.*;
public class JdbcApp15 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		FileOutputStream fos = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","bishnu");
			st = con.createStatement();
			rs = st.executeQuery("Select * from Student");
			
			String data = "";
			data = "<html><body><table border ='1' align = 'center'>" ;
			data = data+"<tr><th>Std_id</th><th>Std_name</th><th>Std_add</th></tr>";
			while(rs.next()) {
				data = data+"<tr>";
				data = data+"<td>"+rs.getString(1)+"</td>";
				data = data+"<td>"+rs.getString(2)+"</td>";
				data = data+"<td>"+rs.getString(3)+"</td>";
				data = data+"</tr>";
			}
			data = data+"</table></body></html>";
			fos = new FileOutputStream("C:/Users/TOPHAN PALEI/OneDrive/Documents/HTML/emp.html");
			byte []b = data.getBytes();
			fos.write(b);
			System.out.println("Data transfer to C:/Users/TOPHAN PALEI/OneDrive/Documents/HTML/emp.html :");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
