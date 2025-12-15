package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginForm")
public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String myemail = request.getParameter("email1");
		String mypass = request.getParameter("pass1");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yt_demo", "root", "sukku@imunni");
			PreparedStatement ps = con.prepareStatement("Select * from register where email=? and password=?");
			ps.setString(1, myemail);
			ps.setString(2, mypass);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				HttpSession session = request.getSession();
				session.setAttribute("session_name", rs.getString("name"));
				RequestDispatcher rd = request.getRequestDispatcher("/profile.jsp");
				rd.include(request, response);

			} else {
				response.setContentType("text/html");
				out.print("<h3 style='color:red'>Email id and password are incorrect</h3>");
				RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
				rd.include(request, response);

			}

		} catch (Exception e) {
			e.printStackTrace();
			response.setContentType("text/html");
			out.print("<h3 style='color:red'>" + e.getMessage() + "</h3>");
			RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
			rd.include(request, response);

		}

	}
}
