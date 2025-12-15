<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body >
	<form  action="regForm" method="post">
		
		Name : <input type="text" name="name1" placeholder="Enter the name" /><br/><br/>
		
		Email : <input type="text" name="email1" placeholder="Enter the Email" /><br/><br/>
		
		Password : <input type="password" name="pass1"
			placeholder="Enter the Password" /><br/><br/> 
			
	    Gender : <input type="radio"
			name="gender1" value="Male" />Male <input type="radio" name="gender1" value="Female"/> Female<br/><br/>
		
		City : <select name="city1" >
		    <option>Select City</option>
			<option>Gujarat</option>
			<option>Delhi</option>
			<option>Mumbai</option>
			<option>Rajasthan</option>
			<option>UttarPradesh</option>
			
		</select><br/><br/>
		
		<input type="submit" value="Register"/>
		
	</form>
</body>
</html>