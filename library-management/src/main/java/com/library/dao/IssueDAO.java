package com.library.dao;

import com.library.model.IssueLog;
import com.library.util.DBConnection;

import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class IssueDAO {
    private static final double FINE_PER_DAY = 5.0; // 5 currency units per day

    /**
     * Issue a book: check availability, decrement available_copies and insert issue_log in one transaction.
     */
    public boolean issueBook(int bookId, int userId, LocalDate dueDate) throws Exception {
        String checkSql = "SELECT available_copies FROM books WHERE id = ? FOR UPDATE";
        String updateSql = "UPDATE books SET available_copies = available_copies - 1 WHERE id = ?";
        String insertSql = "INSERT INTO issue_log (book_id,user_id,issue_date,due_date,status) VALUES (?, ?, ?, ?, 'ISSUED')";

        try (Connection con = DBConnection.getConnection()) {
            try {
                con.setAutoCommit(false);

                try (PreparedStatement ps = con.prepareStatement(checkSql)) {
                    ps.setInt(1, bookId);
                    try (ResultSet rs = ps.executeQuery()) {
                        if (!rs.next()) throw new SQLException("Book not found");
                        int avail = rs.getInt("available_copies");
                        if (avail <= 0) {
                            con.rollback();
                            return false; // not available
                        }
                    }
                }

                try (PreparedStatement ps2 = con.prepareStatement(updateSql)) {
                    ps2.setInt(1, bookId);
                    ps2.executeUpdate();
                }

                try (PreparedStatement ps3 = con.prepareStatement(insertSql)) {
                    ps3.setInt(1, bookId);
                    ps3.setInt(2, userId);
                    ps3.setDate(3, Date.valueOf(LocalDate.now()));
                    ps3.setDate(4, Date.valueOf(dueDate));
                    ps3.executeUpdate();
                }

                con.commit();
                return true;
            } catch (Exception ex) {
                con.rollback();
                throw ex;
            } finally {
                con.setAutoCommit(true);
            }
        }
    }

    /**
     * Return book: set return_date, compute fine, set status, and increment available_copies — all in one transaction.
     */
    public boolean returnBook(IssueLog log) throws Exception {
        String selectSql = "SELECT book_id, due_date, return_date FROM issue_log WHERE id = ? FOR UPDATE";
        String updateLog = "UPDATE issue_log SET return_date = ?, fine = ?, status='RETURNED' WHERE id = ?";
        String updateBook = "UPDATE books SET available_copies = available_copies + 1 WHERE id = ?";

        try (Connection con = DBConnection.getConnection()) {
            try {
                con.setAutoCommit(false);

                int bookId;
                Date dueDate;
                try (PreparedStatement ps = con.prepareStatement(selectSql)) {
                    ps.setInt(1, log);
                    try (ResultSet rs = ps.executeQuery()) {
                        if (!rs.next()) {
                            con.rollback();
                            return false;
                        }
                        bookId = rs.getInt("book_id");
                        dueDate = rs.getDate("due_date");
                        Date alreadyReturned = rs.getDate("return_date");
                        if (alreadyReturned != null) {
                            con.rollback();
                            return false; // already returned
                        }
                    }
                }

                LocalDate today = LocalDate.now();
                long daysLate = 0;
                if (dueDate != null) {
                    LocalDate d = dueDate.toLocalDate();
                    if (today.isAfter(d)) {
                        daysLate = ChronoUnit.DAYS.between(d, today);
                    }
                }
                double fine = daysLate * FINE_PER_DAY;

                try (PreparedStatement ps2 = con.prepareStatement(updateLog)) {
                    ps2.setDate(1, Date.valueOf(today));
                    ps2.setDouble(2, fine);
                    ps2.setInt(3, log);
                    ps2.executeUpdate();
                }

                try (PreparedStatement ps3 = con.prepareStatement(updateBook)) {
                    ps3.setInt(1, bookId);
                    ps3.executeUpdate();
                }

                con.commit();
                return true;
            } catch (Exception ex) {
                con.rollback();
                throw ex;
            } finally {
                con.setAutoCommit(true);
            }
        }
    }

	public void issueBook(IssueLog log) {
		// TODO Auto-generated method stub
		
	}

	public IssueLog getById(int issueId) {
		// TODO Auto-generated method stub
		return null;
	}

    // listIssueLogs, get by user, etc.
}
