package com.fastfire.service;

import java.util.List;

import com.fastfire.model.Student;

public interface StudentService {

	List<Student> listStudents();
	Student getStudentById(int id);
	boolean addStudent(Student student);
	boolean updateStudent(Student student);
	boolean deleteStudent(Student student);
	
}
