package com.library.servlet;

import com.library.dao.BookDAO;
import com.library.model.Book;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {
    private BookDAO bookDAO = new BookDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setAvailable(true);
        bookDAO.addBook(book);
        response.sendRedirect("books");
    }
}
