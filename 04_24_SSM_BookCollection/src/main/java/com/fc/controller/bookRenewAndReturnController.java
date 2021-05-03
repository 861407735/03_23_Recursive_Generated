package com.fc.controller;

import com.fc.entity.*;
import com.fc.service.BookBorrowService;
import com.fc.service.BookMainService;
import com.fc.service.BookRenewService;
import com.fc.service.ReaderBankService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 图书归还
 */
@RestController
public class bookRenewAndReturnController {

    @Autowired
    private BookRenewService bookRenewService;
    @Autowired
    private BookMainService bookMainService;   //查询图书所有信息
    @Autowired
    private ReaderBankService readerBankService; //查询读者信息 作用：修改读者可阅读次数
    @Autowired
    private BookBorrowService bookBorrowService;//图书借阅信息

    @RequestMapping("returnBook")
    public Msg returnBook(Integer toBorrowId,Integer bookId){
        //获取书信息
        BookTbl book = bookMainService.findBook(bookId);
        //借阅信息
        BookToborrowTbl borrowInfoById = bookBorrowService.findBorrowInfoById(toBorrowId);
        //读者id
        Integer readerId=borrowInfoById.getReaderId();

        //插入新的归还信息
        BookReturnTbl bookReturnTbl=new BookReturnTbl();

        bookReturnTbl.setBookId(bookId);            //书籍id
        bookReturnTbl.setBookName(book.getBookName());  //书籍名字
        bookReturnTbl.setRetrunDate(new Date());        //还书时间
        bookReturnTbl.setToreturnDate(borrowInfoById.getReturnedDate()); //借书时间
        bookReturnTbl.setToborrowDate(borrowInfoById.getBorrowedDate());  //应该归还时间
        bookReturnTbl.setBorrowerId(readerId);  //借阅者id
        bookRenewService.insrtBookReturnInfo(bookReturnTbl);
        //可续借次数改为3
        book.setToborrowTimes(3);
        //书籍情况改为 未上架
        book.setBookCaseId(1);
        //更新 修改图书信息
        bookMainService.updateBook(book);

        ReaderTbl readerInfo = readerBankService.findReaderInfo(readerId);
        //读者可借书次数+1
        readerInfo.setRemainingBookCount(readerInfo.getRemainingBookCount()+1);
        //更新读者信息
        readerBankService.updateReaderInfo(readerInfo);

        byte b=(byte)1;
        borrowInfoById.setIsReturned(b); //将图书信息是否归还改为1
        bookBorrowService.UpdateBorrowInfo(borrowInfoById);
        return Msg.success();
    }

}
