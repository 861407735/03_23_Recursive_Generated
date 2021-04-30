package com.fc.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
@Component
public class BookReturnTbl implements Serializable {
    private Integer bookReturnId;

    private Integer bookId;

    private String bookName;
    @DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss" )
    private Date toborrowDate;
    @DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss" )
    private Date toreturnDate;

    private Integer borrowerId;
    @DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss" )
    private Date retrunDate;

    public Integer getBookReturnId() {
        return bookReturnId;
    }

    public void setBookReturnId(Integer bookReturnId) {
        this.bookReturnId = bookReturnId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public Date getToborrowDate() {
        return toborrowDate;
    }

    public void setToborrowDate(Date toborrowDate) {
        this.toborrowDate = toborrowDate;
    }

    public Date getToreturnDate() {
        return toreturnDate;
    }

    public void setToreturnDate(Date toreturnDate) {
        this.toreturnDate = toreturnDate;
    }

    public Integer getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(Integer borrowerId) {
        this.borrowerId = borrowerId;
    }

    public Date getRetrunDate() {
        return retrunDate;
    }

    public void setRetrunDate(Date retrunDate) {
        this.retrunDate = retrunDate;
    }
}