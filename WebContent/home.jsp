<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table border=1>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Department</th>
				<th>View</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${students}" var="student">
			<tr>
				<td>${student.id}</td>
				<td>${student.name}</td>
				<td>${student.dept}</td>
				<td><a href="./view?id=${student.id}">View</a></td>
				<td><a href="./showUpdateForm?id=${student.id}">Update</a></td>
				<td><a href="./delete?id=${student.id}">Delete</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

	<a href="./showAddForm">Add Student</a>

</body>
</html>