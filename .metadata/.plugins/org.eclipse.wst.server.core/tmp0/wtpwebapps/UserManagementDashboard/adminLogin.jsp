<%@ page import="jakarta.servlet.http.*, jakarta.servlet.*"%>
<%
String key = request.getParameter("adminKey");
String staticKey = "admin123";

if (staticKey.equals(key)) {
	response.sendRedirect("dashboard.jsp");
} else {
%>
<h3 style="color: red; text-align: center; margin-top: 50px;">
	Invalid Admin Key! Access Denied.</h3>
<a href="index.jsp" class="btn btn-primary mt-3"
	style="display: block; text-align: center; margin: auto; width: 200px;">
	Back to Home </a>
<%
}
%>
