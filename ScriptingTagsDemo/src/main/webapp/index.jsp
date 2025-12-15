<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%!int a = 9;
	String name = "Hardik";

	int square() {
		return a * a;
	}%>



	<%
	out.println("Name : " + name);
	out.println(a);
	out.println(square());

	int b = 0;
	if (b < 10) {
		out.println("less than 10");
	} else {
		out.println("Greator than 10");
	}
	%><br/>
	
	<%= name %>
</body>
</html>