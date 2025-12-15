package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String myemail = request.getParameter("email1");
		String mypass = request.getParameter("pass1");

		PrintWriter out = response.getWriter();

		if (myemail.equals("ash@gmail.com") && mypass.equals("123")) {
			
			//print name only on profile.jsp not on about and home page
//			request.setAttribute("name_key","Hardik");
			//String myname = (String) request.getAttribute("name_key"); use this in login to print using request
			
			HttpSession session=request.getSession();
			session.setAttribute("name_key","Hardik");
			
			RequestDispatcher rd = request.getRequestDispatcher("/profile.jsp");
			rd.forward(request, response);

		} else {

			response.setContentType("text/html");// prevent to print all content of html

			out.print("Email and password didnot matched");// do not print if forward method will call

			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			// rd.forward(request, response);

			rd.include(request, response);// prints all content of index html

		}

	}
}
