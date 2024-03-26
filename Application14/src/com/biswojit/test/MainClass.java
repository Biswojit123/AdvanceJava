//Controller Layer
package com.biswojit.test;

import java.io.*;

import com.biswojit.bean.Student;
import com.biswojit.factory.StudentServiceFactory;
import com.biswojit.service.StudentService;
public class MainClass {
	public static void main(String args[]) {
		System.out.println("Welcome to Our Khallikote University!");
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			boolean bu = false;
			System.out.println("Are you Intersted to jion our University[Yes/No] :");
			String choice = br.readLine();
			if(choice.equalsIgnoreCase("Yes")) {
				bu =true;
			}else {
				System.out.println("Than you for Visiting!!");
			}
			while(bu) {
				System.out.println("========================================================================================");
				System.out.println("1.Add 						:");
				System.out.println("2.Search 					:");
				System.out.println("3.Update    				:");
				System.out.println("4.Delete					:");
				System.out.println("5:Exit      				:");
				System.out.println("Your Option here 1,2,3,4,5  :");
				int option = Integer.parseInt(br.readLine());
				String sdt_id ,sdt_name ,sdt_add ;
				StudentService sdtService=StudentServiceFactory.getStudentService();
				Student std = null;
				String status = "";
				switch(option) {
					case 1:
						System.out.println("Enter the Student Id      :");
						sdt_id = br.readLine();
						System.out.println("Enter the Student name    :");
						sdt_name = br.readLine();
						System.out.println("Enter the Student Address :");
						sdt_add = br.readLine();
						//Create the Object of Student
						std=new Student();
						std.setStd_id(sdt_id);
						std.setStd_name(sdt_name);
						std.setStd_add(sdt_add);
						status = sdtService.addStudent(std);
						System.out.println(status );
						break;
					case 2:
						//Search Operation Continue
						System.out.println("Enter the Student Id : ");
						sdt_id = br.readLine();
						System.out.println("---------------------------------------------------------------------------------");
						//Return the Student object
						std = sdtService.searchStudent(sdt_id);
						if(std == null) {
							System.out.println("Student is not Exited!");
						}else {
							System.out.println("Student Details  	:");
							System.out.println("Student Id is 		: "+std.getStd_id());
							System.out.println("Student Name is 	: "+std.getStd_name());
							System.out.println("Student Address is 	: "+std.getStd_add());
						}
						
						break;
					case 3:
						System.out.println("Enter the Student id : ");
						sdt_id = br.readLine();
						//Search student because that student Available or not we simple call the service interface searchStudent()method
						std = sdtService.searchStudent(sdt_id);
						System.out.println("Student UpdateStart! You have to give Information!");
						System.out.println("---------------------------------------------------------------------------------");
						
						if(std == null) {
							System.out.println("Student is not Existed!");
						} else {
							System.out.println("Student name[Old_name :"+std.getStd_name()+"]\n If you want New name ,plz provide :");
							String stdNew_name = br.readLine();
							
							if(stdNew_name == null || stdNew_name == "") {
								stdNew_name = std.getStd_name();
							}
							System.out.println("Student Address[Old_Address :"+std.getStd_add()+"]\n If You want New Address ,Plz provide :");
							String stdNew_add = br.readLine();
							
							if(stdNew_add == null || stdNew_add == "") {
								stdNew_add = std.getStd_add();
							}
							
							Student std_new = new Student();
							std_new.setStd_id(sdt_id);
							std_new.setStd_name(stdNew_name);
							std_new.setStd_add(stdNew_add);
							status = sdtService.updateStudent(std_new);
							System.out.println(status);
						}
						
						break;
					case 4:
						System.out.println("Enter the Student id :");
						sdt_id = br.readLine();
						//First we check the Input student is present or not
						std = sdtService.searchStudent(sdt_id);
						if(std == null) {
							System.out.println("Student is Not existed!");
						}else {
							System.out.println("Student Exist!");
							status = sdtService.deleteStudent(sdt_id);
							
							System.out.print(status);
						}
						break;
					case 5:
						System.out.print("******************Thanku for Joining**************");
						System.exit(0);
						break;
					default :
						System.out.println("Enter the choice from the option[1,2,3,4,5] :");
				}
			}
			
		}catch(Exception e) {
			e.fillInStackTrace();
		}
		
	}
}
