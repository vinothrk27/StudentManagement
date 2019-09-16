package com.fastfire.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastfire.model.Student;
import com.fastfire.service.StudentService;
import com.fastfire.service.StudentServiceImpl;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	StudentService service = new StudentServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		System.out.println(action);
		
		switch (action) {
			case "/view":
				viewStudent(request, response);
				break;
			case "/showAddForm":
				showAddForm(request, response);
				break;
			case "/showUpdateForm":
				showUpdateForm(request, response);
				break;
			case "/delete":
				deleteStudent(request, response);
				break;
			default:
				listStudents(request, response);
				break;
		}

	}

	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("students", service.listStudents());
		request.getRequestDispatcher("/home.jsp").forward(request, response);		
	}
	
	private void viewStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int studentId = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("student", service.getStudentById(studentId));
		request.getRequestDispatcher("/studentDetails.jsp").forward(request, response);
	}
	
	private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/addForm.jsp").forward(request, response);
	}
	
	private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int studentId = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("student", service.getStudentById(studentId));
		request.getRequestDispatcher("/updateForm.jsp").forward(request, response);
	}
	
	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int studentId = Integer.parseInt(request.getParameter("id"));
		Student student = new Student();
		student.setId(studentId);
		service.deleteStudent(student);
		response.sendRedirect("list");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String formName = request.getParameter("formName");
		
		switch(formName) {
			case "add":
				addStudent(request, response);
				break;
			case  "update":
				updateStudent(request, response);
				break;
			default:
				break;
		}
	}
	
	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String dept = request.getParameter("dept");
		Student student = new Student(name,dept);
		service.addStudent(student);
		response.sendRedirect("list");
	}
	
	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String dept = request.getParameter("dept");
		Student student = new Student(name,dept);
		student.setId(id);
		service.updateStudent(student);
		response.sendRedirect("list");
	}
}