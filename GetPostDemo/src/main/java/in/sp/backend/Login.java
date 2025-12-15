package in.sp.backend;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/myLogin")
public class Login extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name1");
		String pass = req.getParameter("pass1");

		if (name.equals("ash") && pass.equals("abc")) {
			System.out.println("Success");
		} else {
			System.out.println("failed");
		}
	}
}