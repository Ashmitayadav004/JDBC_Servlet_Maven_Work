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
	request.setAttribute("request_name", "Hardik");
	%>
	<h3>Hello : ${requestScope.request_name}</h3>
	<br />
	
	<form action="output.jsp" method="get">
		<input type="text" name="name1" placeholder="Enter the name" /> <input
			type="submit" value="Click mee" />
	</form>
</body>
</html>