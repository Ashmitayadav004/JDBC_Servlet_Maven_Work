<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Welcome : User</h3>

<!--<h3>Name : ${model_name}</h3>
	<h3>Email : ${model_email}</h3>
	<h3>Phone : ${model_phone}</h3>-->
	
	<!--<h3>Name : ${model_user.getName()}</h3>
	<h3>Email : ${model_user.getEmail()}</h3>
	<h3>Phone : ${model_user.getPhone()}</h3>-->
	
	<h3>Name : ${user.getName()}</h3>
	<h3>Email : ${user.getEmail()}</h3>
	<h3>Phone : ${user.getPhone()}</h3>-

</body>
</html>