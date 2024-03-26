package com.biswojit.factory;

import com.biswojit.service.StudentService;
import com.biswojit.service.StudentserviceImple;

public class StudentServiceFactory {
	private static StudentService studentService;
	
	static {
		studentService=new StudentserviceImple();
	}
	public static StudentService getStudentService() {
		return studentService;
	}
}
