package in.sp.backend;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/submitForm")
public class MyServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mysearch = request.getParameter("search1");
//		response.sendRedirect("https://www.google.com");
		response.sendRedirect("https://www.google.com/search?q=" + mysearch);

	}
}
