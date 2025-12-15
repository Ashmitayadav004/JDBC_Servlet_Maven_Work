package com.library.dao;

import com.library.model.Book;
import com.library.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    public List<Book> listAll() throws Exception {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM books ORDER BY title";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Book b = new Book();
                b.setId(rs.getInt("id"));
                b.setTitle(rs.getString("title"));
                b.setAuthor(rs.getString("author"));
                b.setPublisher(rs.getString("publisher"));
                b.setIsbn(rs.getString("isbn"));
                b.setTotalCopies(rs.getInt("total_copies"));
                b.setAvailableCopies(rs.getInt("available_copies"));
                list.add(b);
            }
        }
        return list;
    }

    public Book findById(int id) throws Exception {
        String sql = "SELECT * FROM books WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
             ps.setInt(1, id);
             try (ResultSet rs = ps.executeQuery()) {
                 if (rs.next()) {
                     Book b = new Book();
                     b.setId(rs.getInt("id"));
                     b.setTitle(rs.getString("title"));
                     b.setAuthor(rs.getString("author"));
                     b.setPublisher(rs.getString("publisher"));
                     b.setIsbn(rs.getString("isbn"));
                     b.setTotalCopies(rs.getInt("total_copies"));
                     b.setAvailableCopies(rs.getInt("available_copies"));
                     return b;
                 }
             }
        }
        return null;
    }

    public void add(Book b) throws Exception {
        String sql = "INSERT INTO books (title,author,publisher,isbn,total_copies,available_copies) VALUES (?,?,?,?,?,?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, b.getTitle());
            ps.setString(2, b.getAuthor());
            ps.setString(3, b.getPublisher());
            ps.setString(4, b.getIsbn());
            ps.setInt(5, b.getTotalCopies());
            ps.setInt(6, b.getAvailableCopies());
            ps.executeUpdate();
        }
    }

    public void updateAvailableCopies(int bookId, int delta) throws Exception {
        String sql = "UPDATE books SET available_copies = available_copies + ? WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, delta);
            ps.setInt(2, bookId);
            ps.executeUpdate();
        }
    }

	public void addBook(Book book) {
		// TODO Auto-generated method stub
		
	}

	public void updateAvailability(int bookId, boolean b) {
		// TODO Auto-generated method stub
		
	}

    // add update/delete methods similarly...
}
