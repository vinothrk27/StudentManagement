<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	Student details page
	
	<table border=1>
		<tr>
			<td>Id</td><td>${student.id}</td>
		</tr>
		<tr>
			<td>Name</td><td>${student.name}</td>
		</tr>
		<tr>
			<td>Dept</td><td>${student.dept}</td>
		</tr>
	</table>

</body>
</html>