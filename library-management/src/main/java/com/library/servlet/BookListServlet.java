package com.library.servlet;

import com.library.dao.BookDAO;
import com.library.model.Book;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/books")
public class BookListServlet extends HttpServlet {
    private BookDAO bookDAO = new BookDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Book> books = null;
		try {
			books = bookDAO.listAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        request.setAttribute("books", books);
        request.getRequestDispatcher("jsp/books.jsp").forward(request, response);
    }
}
