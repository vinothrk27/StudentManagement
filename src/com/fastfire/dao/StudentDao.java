package com.fastfire.dao;

import java.util.List;

import com.fastfire.model.Student;

public interface StudentDao {

	List<Student> getAllStudents();
	Student getStudentById(int id);
	boolean addStudent(Student student);
	boolean updateStudent(Student student);
	boolean deleteStudent(Student student);

}
