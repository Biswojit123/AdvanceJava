//Data Access layer Interface
package com.biswojit.dao;

import com.biswojit.bean.Student;

public interface StudentDao {
	public String add(Student std);
	public Student search(String std_id);
	public String update(Student std);
	public String delete(String std_id);
}
