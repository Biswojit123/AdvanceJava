//Data Access Layer Implement class 
package com.biswojit.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.biswojit.bean.Student;
import com.biswojit.factory.ConnectionFactory;

public class StudentDaoImple implements StudentDao {
	Connection con ;
	Statement str ;
	ResultSet rs ;
	@Override
	public String add(Student std) {
		String status = "";
		try {
			con = ConnectionFactory.getConnection();
			str = con.createStatement();
			ResultSet rs = str.executeQuery("Select * from student where std_id='"+std.getStd_id()+"'");
			boolean b = rs.next();
			if(b == true) {
				status="Record is Already Exit !";
			}else {
				int rowCount = str.executeUpdate("Insert into student values ('"+std.getStd_id()+"','"+std.getStd_name()+"','"+std.getStd_add()+"')");
				if(rowCount == 1) {
					status = "Record Inserted Successefully!";
				}else {
					status = "Insertion Failed!";
				}
			}
		}catch (Exception e) {
			System.out.println("Insertion failed");
			e.printStackTrace();
		}finally {
			try {
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return status;
	}
	@Override
	public Student search(String std_id) {
		Student std = null;
		 try {
			 con = ConnectionFactory.getConnection();
			 str = con.createStatement();
			 rs = str.executeQuery("Select * from Student where Std_id = '"+std_id+"'");
			 
			 boolean b = rs.next();
			 if( b == true) {
				 std = new Student();
				 std.setStd_id(rs.getString("Std_id"));
				 std.setStd_name(rs.getString("Std_name"));
				 std.setStd_add(rs.getString("Std_add"));
			 }else {
				 std = null;
			 }
		 }catch (Exception e) {
			 e.printStackTrace();
		 }finally {
			 try {
				 
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
		 }
		return std;
	}
	@Override
	public String update(Student std) {
		String status = "";
		try {
			con = ConnectionFactory.getConnection();
			str = con.createStatement();
			int rowCount = str.executeUpdate("Update Student set std_name = '"+std.getStd_name()+"',std_add ='"+std.getStd_add()+"' where std_id = '"+std.getStd_id()+"'");
			if(rowCount == 1) {
				status = "Student update Successfully!";
			}else {
				status = "Student updations Failure!";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	@Override
	public String delete(String std_id) {
		String status = "";
		try {
			con = ConnectionFactory.getConnection();
			str = con.createStatement();
			int rowCount = str.executeUpdate("Delete from student where std_id = '"+std_id+"'");
			
			if(rowCount == 1) {
				status = "Student Delete Successfully!";
			}else {
				status = "Student Deletion failure!";
			}
		}catch(Exception e) {
			
		}
		return status;
	}

}
