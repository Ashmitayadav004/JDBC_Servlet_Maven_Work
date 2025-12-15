package in.sp.backend;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	    
	    // Set response type
//	    response.setContentType("text/html");
	    
	    // Write response
//	    PrintWriter out = response.getWriter();
//	    out.println("<h1>Hello from doGet()!</h1>");
		System.out.println("i am in doGet() method ");
	}

      
}
