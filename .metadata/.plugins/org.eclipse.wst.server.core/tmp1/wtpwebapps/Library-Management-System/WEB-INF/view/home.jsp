<%@page import="com.dto.UserSessionDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Management System</title>
<style type="text/css">
:root {
	--primary: #000000;
	--secondary: #FFFFFF;
	--tertiary: #c1a4f1;
	--accent: #8E54E9;
	--shadow: 8px 8px 0px var(--primary);
}

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Courier New', monospace;
}

body {
	background-color: var(--secondary);
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	min-height: 100vh;
	padding: 20px;
}

<%@ include file="/WEB-INF/nav/navStyles.jsp" %>

h1 {
	text-align: center;
	font-size: 150px;
	color: #FBB144;
}

h2 {
	text-align: center;
	margin-top: 100px;
	margin-bottom: 20px;
	font-size: 50px;
	color: #16e056;
}
</style>
</head>
<body>

	<form action="login" method="post">
		<input type="text" name="username" placeholder="Username" required />
		<input type="password" name="password" placeholder="Password" required />
		<button type="submit">Login</button>
	</form>

	<%
		UserSessionDTO user = (UserSessionDTO)session.getAttribute("user");
		if (user != null) {
			if ("USER".equals(user.getRole())) {
	%>
				<%@ include file="/WEB-INF/nav/userNav.jsp"%>
	<%
			} else if ("ADMIN".equals(user.getRole())) {
	%>
				<%@ include file="/WEB-INF/nav/adminNav.jsp"%>
	<%
			}
	%>
		<h2>Welcome, <%= user.getUser_name() %></h2>
	<%
		}
	%>

	<h1>Library Management System.</h1>

</body>
</html>