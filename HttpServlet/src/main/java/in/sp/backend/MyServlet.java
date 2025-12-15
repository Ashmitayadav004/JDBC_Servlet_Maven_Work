package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/aaa")
public class MyServlet extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String myname = req.getParameter("name1");
		String email = req.getParameter("email1");
		System.out.println("I am in service method");// print it on console
		
		
		PrintWriter out = res.getWriter();//print on browser
		out.println("name : "+myname);
		out.print("\nemail :"+email);
	}
}
