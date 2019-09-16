<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Update student details
	<form action="./updateStudent" method="post">
		<input type="hidden" name="formName" value="update">
		<input type="hidden" name="id" value="${student.id}">
		<label>Name</label>
		<input type="text" name="name" value="${student.name}">
		<br/>
		<label>Dept</label>
		<input type="text" name="dept" value="${student.dept}">
		<br/>
		<button type="submit">Add</button>
	</form>
</body>
</html>