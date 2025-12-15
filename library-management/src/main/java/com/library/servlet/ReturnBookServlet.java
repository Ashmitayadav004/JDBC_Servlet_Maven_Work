package com.library.servlet;

import com.library.dao.IssueDAO;
import com.library.dao.BookDAO;
import com.library.model.IssueLog;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.Date;

@WebServlet("/returnBook")
public class ReturnBookServlet extends HttpServlet {
    private IssueDAO issueDAO = new IssueDAO();
    private BookDAO bookDAO = new BookDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int issueId = Integer.parseInt(request.getParameter("issueId"));
        IssueLog log = issueDAO.getById(issueId);
        if (log != null) {
            log.setReturnDate(new Date());
            try {
				issueDAO.returnBook(log);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            bookDAO.updateAvailability(log.getBookId(), true);
        }
        response.sendRedirect("books");
    }
}
