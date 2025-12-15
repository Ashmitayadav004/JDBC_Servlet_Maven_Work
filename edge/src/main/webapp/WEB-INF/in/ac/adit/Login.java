package in.ac.adit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

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

            if (rs.next()) {
//                out.println("<h2>Login successful. Welcome, " + email + "!</h2>");
                // You can redirect to dashboard.jsp or another page
                response.sendRedirect("home.jsp");
            } else {
                out.println("<h2>Invalid email or password</h2>");
            }

            con.close();
        } catch (Exception e) {
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
            e.printStackTrace();
        }
    }
}
