//Service Layer implement class
package com.biswojit.service;

import com.biswojit.bean.Student;
import com.biswojit.dao.StudentDao;
import com.biswojit.factory.StudentDaoFactory;

public class StudentserviceImple implements StudentService {
	StudentDao sd;
	String status =" ";
	@Override
	public String addStudent(Student std) {
		//Here Create the StudentDao interface add method
		//we required the StudentDao object
		sd = StudentDaoFactory.getStudentDao();
		status = sd.add(std);
		return status;
	}
	@Override
	public Student searchStudent(String std_id) {
		sd = StudentDaoFactory.getStudentDao();
		Student std = sd.search(std_id);
		return std;
	}
	@Override
	public String updateStudent(Student std) {
		sd = StudentDaoFactory.getStudentDao();
		status = sd.update(std);
		return status;
	}
	@Override
	public String deleteStudent(String std_id) {
		sd = StudentDaoFactory.getStudentDao();
		status = sd.delete(std_id);
		return status;
	}

}
