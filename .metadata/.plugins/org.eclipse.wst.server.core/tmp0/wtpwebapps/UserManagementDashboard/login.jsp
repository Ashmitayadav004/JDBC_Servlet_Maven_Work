<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<div class="d-flex justify-content-center align-items-center"
	style="min-height: 70vh;">
	<div class="card shadow-lg p-4" style="width: 400px;">
		<h3 class="text-center mb-4">Login Here</h3>

		<form action="loginForm" method="post">
			<div class="mb-3">
				<label for="email" class="form-label">Email:</label> <input
					type="text" id="email" name="email1" class="form-control"
					placeholder="Enter your email" required>
			</div>

			<div class="mb-3">
				<label for="password" class="form-label">Password:</label> <input
					type="password" id="password" name="pass1" class="form-control"
					placeholder="Enter your password" required>
			</div>

			<div class="d-grid">
				<input type="submit" value="Login" class="btn btn-success">
			</div>

			<p class="text-center mt-3">
				Don’t have an account? <a href="register.jsp">Register here</a>
			</p>
		</form>
	</div>
</div>

<%@ include file="footer.jsp"%>
