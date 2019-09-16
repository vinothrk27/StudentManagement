<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Fill student details to add
	<form action="./addStudent" method="post">
		<input type="hidden" name="formName" value="add">
		<label>Name</label>
		<input type="text" name="name">
		<br/>
		<label>Dept</label>
		<input type="text" name="dept">
		<br/>
		<button type="submit">Add</button>
	</form>
</body>
</html>