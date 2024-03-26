package com.biswojit.factory;

import com.biswojit.dao.StudentDao;
import com.biswojit.dao.StudentDaoImple;

public class StudentDaoFactory {
	private static StudentDao studentDao;
	
	static {
		studentDao=new StudentDaoImple();
	}
	
	public static StudentDao getStudentDao() {
		return studentDao;
	}
}
