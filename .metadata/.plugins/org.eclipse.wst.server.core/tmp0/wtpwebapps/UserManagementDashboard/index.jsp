<%@ include file="header.jsp"%>

<div class="container mt-5 text-center">
	<h3>Welcome to User Management</h3>
	<p class="mt-3">Your gateway to learn, register, and explore.</p>

	<!-- User options -->
	<a href="register.jsp" class="btn btn-primary me-2">Register Here</a> <a
		href="login.jsp" class="btn btn-success">Login Here</a>

	<hr class="my-4">

	<!-- Admin access -->
	<h5>Admin Access</h5>
	<form action="adminLogin.jsp" method="post" class="d-inline-block mt-2">
		<input type="password" name="adminKey" placeholder="Enter admin key"
			required class="form-control d-inline-block" style="width: 200px;">
		<input type="submit" value="Go to Dashboard"
			class="btn btn-warning ms-2">
	</form>
</div>

<%@ include file="footer.jsp"%>
