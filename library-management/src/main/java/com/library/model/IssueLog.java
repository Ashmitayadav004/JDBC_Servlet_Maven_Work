package com.library.model;

import java.util.Date;

public class IssueLog {
    private int id;
    private int bookId;
    private int userId;
    private Date issueDate;
    private Date returnDate;
    private double penalty;

    public IssueLog() {}

    public IssueLog(int id, int bookId, int userId, Date issueDate, Date returnDate, double penalty) {
        this.id = id;
        this.bookId = bookId;
        this.userId = userId;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.penalty = penalty;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getIssueDate() {
        return issueDate;
    }
    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public double getPenalty() {
        return penalty;
    }
    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }
}
