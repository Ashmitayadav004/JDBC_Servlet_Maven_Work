<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	String name = "Hardik";
	out.println(name);
	//dont need to create object in jsp . Directly using the obj
	%>
	
	<%
	session.setAttribute("session_name", "Hardik Pandya");
	%>
	
	<form action="output.jsp" method="get">
		<input type="text" name="name1" placeholder="Enter the name" /> <input
			type="submit" value="Click mee" />
	</form>
	
</body>
</html>