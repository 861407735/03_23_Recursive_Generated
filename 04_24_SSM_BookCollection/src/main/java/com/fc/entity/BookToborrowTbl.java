package com.fc.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
@Component
public class BookToborrowTbl implements Serializable {
    private Integer bookToborrowId;

    private Integer bookId;

    private Integer readerId;

    private Date borrowedDate;

    private Date returnedDate;

    private Byte isReturned;

    public Integer getBookToborrowId() {
        return bookToborrowId;
    }

    public void setBookToborrowId(Integer bookToborrowId) {
        this.bookToborrowId = bookToborrowId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public Date getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }

    public Byte getIsReturned() {
        return isReturned;
    }

    public void setIsReturned(Byte isReturned) {
        this.isReturned = isReturned;
    }
}