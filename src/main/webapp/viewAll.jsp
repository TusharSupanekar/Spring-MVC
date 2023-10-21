<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of students</title>
</head>
<body>
	<table border="1" style="border-collapse: collapse;">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
			</tr>
			
			<c:forEach var="s" items="${student}">
				<tr>
					<td>${s.getId()}</td>
					<td>${s.getName()}</td>
					<td>${s.getEmail()}</td>
					<td ><a href="delete?id=${s.getId()}">DELETE</a></td>
					<td ><a href="update?id=${s.getId()}">UPDATE</a></td>
				</tr>
			</c:forEach>
	</table>
		

</body>
</html>