package in.ac.adit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/LoginServlet") // This must match form action
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		String url = "jdbc:mysql://localhost:3306/bank_db";
		String user = "root";
		String dbPassword = "sukku@imunni";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, dbPassword);
			PreparedStatement ps = con.prepareStatement("SELECT * FROM login WHERE email = ? AND password = ?");
			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			RequestDispatcher rd;
			if (rs.next()) {
				// ✅ Store email in request attribute to access in home.jsp
				request.setAttribute("Success", "Login successful!");
				request.setAttribute("email", email);

				rd = request.getRequestDispatcher("home.jsp");
			} else {
				// ✅ Pass an error message to index.jsp
				request.setAttribute("error", "Invalid email or password.");
				rd = request.getRequestDispatcher("index.jsp");
			}
			rd.forward(request, response);
			con.close();
		} catch (Exception e) {
			out.println("<h2>Error: " + e.getMessage() + "</h2>");
			e.printStackTrace();
		}
	}
}
