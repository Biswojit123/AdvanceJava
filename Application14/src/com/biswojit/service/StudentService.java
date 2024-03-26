//Service Layer Interface
package com.biswojit.service;

import com.biswojit.bean.Student;

public interface StudentService {
	public String addStudent(Student std);
	public Student searchStudent(String std_id);
	public String updateStudent(Student std);
	public String deleteStudent(String std_id);
}
