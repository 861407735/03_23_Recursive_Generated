package com.fc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.tracing.ProviderName;
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
public class ReaderTbl implements Serializable {
    private Integer readerId;

    private String readerName;  //名

    private String readerGender;    //性别

    private String readerBarcode;  //

    private String readerProfession;

    private Date readerBirth;

    private String readerDocumentType;

    private String readerDocumentNumber;  //

    private String readerEmail;  //邮箱

    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    private Date readerRegisterDate;

    private Integer borrowedBookCount;

    private Integer remainingBookCount;

    private Integer operatorId;

    //管理员对象
    private ManagerTbl manager;

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName == null ? null : readerName.trim();
    }

    public String getReaderGender() {
        return readerGender;
    }

    public void setReaderGender(String readerGender) {
        this.readerGender = readerGender == null ? null : readerGender.trim();
    }

    public String getReaderBarcode() {
        return readerBarcode;
    }

    public void setReaderBarcode(String readerBarcode) {
        this.readerBarcode = readerBarcode == null ? null : readerBarcode.trim();
    }

    public String getReaderProfession() {
        return readerProfession;
    }

    public void setReaderProfession(String readerProfession) {
        this.readerProfession = readerProfession == null ? null : readerProfession.trim();
    }

    public Date getReaderBirth() {
        return readerBirth;
    }

    public void setReaderBirth(Date readerBirth) {
        this.readerBirth = readerBirth;
    }

    public String getReaderDocumentType() {
        return readerDocumentType;
    }

    public void setReaderDocumentType(String readerDocumentType) {
        this.readerDocumentType = readerDocumentType == null ? null : readerDocumentType.trim();
    }

    public String getReaderDocumentNumber() {
        return readerDocumentNumber;
    }

    public void setReaderDocumentNumber(String readerDocumentNumber) {
        this.readerDocumentNumber = readerDocumentNumber == null ? null : readerDocumentNumber.trim();
    }

    public String getReaderEmail() {
        return readerEmail;
    }

    public void setReaderEmail(String readerEmail) {
        this.readerEmail = readerEmail == null ? null : readerEmail.trim();
    }

    public Date getReaderRegisterDate() {
        return readerRegisterDate;
    }

    public void setReaderRegisterDate(Date readerRegisterDate) {
        this.readerRegisterDate = readerRegisterDate;
    }

    public Integer getBorrowedBookCount() {
        return borrowedBookCount;
    }

    public void setBorrowedBookCount(Integer borrowedBookCount) {
        this.borrowedBookCount = borrowedBookCount;
    }

    public Integer getRemainingBookCount() {
        return remainingBookCount;
    }

    public void setRemainingBookCount(Integer remainingBookCount) {
        this.remainingBookCount = remainingBookCount;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }
}