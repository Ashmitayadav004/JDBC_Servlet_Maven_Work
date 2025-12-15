<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<div class="d-flex justify-content-center align-items-center"
	style="min-height: 80vh;">
	<div class="card shadow-lg p-4" style="width: 450px;">
		<h3 class="text-center mb-4">Register Here</h3>

		<form action="regForm" method="post">
			<div class="mb-3">
				<label for="name" class="form-label">Name:</label> <input
					type="text" id="name" name="name1" class="form-control"
					placeholder="Enter your name" required>
			</div>

			<div class="mb-3">
				<label for="email" class="form-label">Email:</label> <input
					type="email" id="email" name="email1" class="form-control"
					placeholder="Enter your email" required>
			</div>

			<div class="mb-3">
				<label for="password" class="form-label">Password:</label> <input
					type="password" id="password" name="pass1" class="form-control"
					placeholder="Enter your password" required>
			</div>

			<div class="mb-3">
				<label for="city" class="form-label">City:</label> <input
					type="text" id="city" name="city1" class="form-control"
					placeholder="Enter your city" required>
			</div>

			<div class="d-grid">
				<input type="submit" value="Register" class="btn btn-primary">
			</div>

			<p class="text-center mt-3">
				Already have an account? <a href="login.jsp">Login here</a>
			</p>
		</form>
	</div>
</div>

<%@ include file="footer.jsp"%>
