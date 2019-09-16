package com.fastfire.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fastfire.model.Student;
import com.fastfire.utils.JDBCConnectionFactory;

public class StudentDaoJDBCImpl implements StudentDao {

	@Override
	public List<Student> getAllStudents() {

		Connection conn = JDBCConnectionFactory.getConnection();
		List<Student> studentsList = new ArrayList<Student>();
		
		try {
			String selectQuery = "SELECT * FROM Student order by 1";
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(selectQuery);
			
			while (resultSet.next()) {
				Student student = new Student();
				student.setId(resultSet.getInt("id"));
				student.setName(resultSet.getString("name"));
				student.setDept(resultSet.getString("dept"));
				studentsList.add(student);
			}
			
			return studentsList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

}
