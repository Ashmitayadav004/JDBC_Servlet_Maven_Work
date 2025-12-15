package com.library.servlet;

import com.library.dao.IssueDAO;
import com.library.dao.BookDAO;
import com.library.model.IssueLog;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/issueBook")
public class IssueBookServlet extends HttpServlet {
    private IssueDAO issueDAO = new IssueDAO();
    private BookDAO bookDAO = new BookDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        String dateStr = request.getParameter("issueDate");

        try {
            Date issueDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
            IssueLog log = new IssueLog();
            log.setBookId(bookId);
            log.setUserId(userId);
            log.setIssueDate(issueDate);
            log.setReturnDate(null);
            log.setPenalty(0);
            issueDAO.issueBook(log);
            bookDAO.updateAvailability(bookId, false);
            response.sendRedirect("books");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
