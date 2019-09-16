package com.fastfire.service;

import java.util.List;

import com.fastfire.dao.StudentDao;
import com.fastfire.dao.StudentDaoImpl;
import com.fastfire.model.Student;

public class StudentServiceImpl implements StudentService {

	@Override
	public List<Student> listStudents() {
		StudentDao studentDao = new StudentDaoImpl();
		return studentDao.getAllStudents();
	}

	@Override
	public Student getStudentById(int id) {
		StudentDao studentDao = new StudentDaoImpl();
		return studentDao.getStudentById(id);
	}

	@Override
	public boolean addStudent(Student student) {
		StudentDao studentDao = new StudentDaoImpl();
		return studentDao.addStudent(student);
	}

	@Override
	public boolean updateStudent(Student student) {
		StudentDao studentDao = new StudentDaoImpl();
		return studentDao.updateStudent(student);
	}

	@Override
	public boolean deleteStudent(Student student) {
		StudentDao studentDao = new StudentDaoImpl();
		return studentDao.deleteStudent(student);
	}

}
