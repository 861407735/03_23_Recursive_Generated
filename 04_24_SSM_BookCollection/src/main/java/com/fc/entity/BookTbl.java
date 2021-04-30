package com.fc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class BookTbl implements Serializable {
    private Integer bookId;

    private String bookName;

    private Integer typeId;

    private String bookAuthor;

    private String bookPress;

    private Float bookPrice;

    private String bookLanguage;

    private String bookPdfurl;

    @DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss" )
    private Date bookEntryTime;

    private Integer toborrowTimes;

    private Integer operatorId;

    private Integer borrowedTimes;

    private Integer bookCaseId;
    //书类型
    private BookTypeTbl bookType;
    //书存放位置
    private BookcaseTbl bookcase;
    //管理员
    private ManagerTbl manager;


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

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor == null ? null : bookAuthor.trim();
    }

    public String getBookPress() {
        return bookPress;
    }

    public void setBookPress(String bookPress) {
        this.bookPress = bookPress == null ? null : bookPress.trim();
    }

    public Float getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Float bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookLanguage() {
        return bookLanguage;
    }

    public void setBookLanguage(String bookLanguage) {
        this.bookLanguage = bookLanguage == null ? null : bookLanguage.trim();
    }

    public String getBookPdfurl() {
        return bookPdfurl;
    }

    public void setBookPdfurl(String bookPdfurl) {
        this.bookPdfurl = bookPdfurl == null ? null : bookPdfurl.trim();
    }

    public Date getBookEntryTime() {
        return bookEntryTime;
    }

    public void setBookEntryTime(Date bookEntryTime) {
        this.bookEntryTime = bookEntryTime;
    }

    public Integer getToborrowTimes() {
        return toborrowTimes;
    }

    public void setToborrowTimes(Integer toborrowTimes) {
        this.toborrowTimes = toborrowTimes;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public Integer getBorrowedTimes() {
        return borrowedTimes;
    }

    public void setBorrowedTimes(Integer borrowedTimes) {
        this.borrowedTimes = borrowedTimes;
    }

    public Integer getBookCaseId() {
        return bookCaseId;
    }

    public void setBookCaseId(Integer bookCaseId) {
        this.bookCaseId = bookCaseId;
    }
}