package com.fc.controller;

import com.fc.entity.*;
import com.fc.service.BookBorrowService;
import com.fc.service.BookMainService;
import com.fc.service.ReaderBankService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 图书借阅  页面：bookBorrow.jsp
 */
@RestController
public class BookBorrowController {
    //借阅书籍的信息(借阅事件、归还事件、可借阅天数)的service
    @Autowired
    private BookBorrowService bookBorrowService;
    //获取读者信息的service（借阅后将读者可借阅次数-1 ，总借阅次数+1）
    @Autowired
    private ReaderBankService readerBankService;
    //获取书籍信息的service（作用：在借阅后将书籍的可借阅次数-1,查询书籍类型）
    @Autowired
    private BookMainService bookMainService;
    /**
     * 通过名字查询书籍并分页
     * @param pn
     * @param searchText
     * @return
     */
    @RequestMapping("/searchBookUnBorrowed")
    public Msg selectBook(@RequestParam("pn") Integer pn,@RequestParam("searchText") String searchText){
        PageHelper.startPage(pn,10);

        List<BookTbl> bookTbls = bookBorrowService.selectBook(searchText);

        PageInfo<BookTbl> pageInfo=new PageInfo<>(bookTbls);
        return Msg.success().add("pageInfo",pageInfo);
    }

    /**
     * 通过条形码查询出用户信息
     * @param readerBarCode
     * @return
     */
    @GetMapping("/checkReader/{barcode}")
    public Msg barFindReader(@PathVariable("barcode")String readerBarCode){

        ReaderTbl readerTbl = bookBorrowService.barFindReader(readerBarCode);
        System.out.println(readerTbl.getReaderName());
            if(readerTbl==null){
                return Msg.fail().add("checkReader_msg","用户不存在");
            }else{
                return Msg.success().add("reader",readerTbl);
            }
    }
    @RequestMapping("borrowBook")
    public Msg borrowBooks(@RequestParam("readerId") Integer readerId,@RequestParam("bookId") Integer bookId){
        BookToborrowTbl bookToborrow=new BookToborrowTbl();
        bookToborrow.setBookId(bookId);             //书籍id
        bookToborrow.setReaderId(readerId);         //读者id
        bookToborrow.setBorrowedDate(new Date());  //借书时间

        return null;
    }

    /**
     * 还书时间获取
     * 1.查询书可借阅的时间 再加上当前时间 就是还书时间
     */
    public Date getReturnTime(Integer bookId){
        BookTbl book = bookMainService.findBook(bookId);
        //通过书籍类型id 获取类型对应的类
        BookTypeTbl bookType = bookMainService.findIdBookType(book.getTypeId());

        return null;
    }
}
