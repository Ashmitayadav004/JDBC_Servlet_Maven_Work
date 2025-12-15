package in.sp.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.sp.dbcon.DbConnection;
import in.sp.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginForm")
public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String myemail = request.getParameter("email1");
		String mypass = request.getParameter("pass1");

		try {

			Connection con = DbConnection.getConnection();
			System.out.println("Connection: " + con);
			String select_query = "Select * from register where email=? and password=?";

			PreparedStatement ps = con.prepareStatement(select_query);
			ps.setString(1, myemail);
			ps.setString(2, mypass);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				User user=new User();
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setCity(rs.getString("city"));
				
				HttpSession session=request.getSession();
				session.setAttribute("session_user",user);
				System.out.println("Login successful, redirecting to profile.jsp");

				RequestDispatcher rd = request.getRequestDispatcher("/profile.jsp");
				rd.forward(request, response);
				
			} else {
				out.println("<h3 style='color:red'>Not matched</h3>");
				RequestDispatcher rd = request.getRequestDispatcher("/login.html");
				rd.include(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
			out.println("<h3 style='color:red'>Not matched</h3>");
			RequestDispatcher rd = request.getRequestDispatcher("/login.html");
			rd.include(request, response);
		}
	}
}
