package com.fc.controller;

import com.fc.entity.*;
import com.fc.service.BookBorrowService;
import com.fc.service.BookMainService;
import com.fc.service.ReaderBankService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 图书借阅  页面：bookBorrow.jsp
 * 图书续借  页面 bookRenewAndReturn.jsp
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
            if(readerTbl==null){
                return Msg.fail().add("checkReader_msg","用户不存在");
            }else{
                return Msg.success().add("reader",readerTbl);
            }
    }

    /**
     * 借书
     * @param readerId
     * @param bookId
     * @return
     */
    @RequestMapping("borrowBook")
    public Msg borrowBooks(@RequestParam("readerId") Integer readerId,@RequestParam("bookId") Integer bookId){
        //借阅书籍信息的类
        BookToborrowTbl bookToborrow=new BookToborrowTbl();
        bookToborrow.setBookId(bookId);             //书籍id
        bookToborrow.setReaderId(readerId);         //读者id
        bookToborrow.setBorrowedDate(new Date());  //借书时间
        bookToborrow.setReturnedDate(getReturnTime(bookId));  //还书时间
        bookBorrowService.borrowBook(bookToborrow);  //插入新的借阅信息
        //读者类
        int affectedRow = bookBorrowService.updateReaderBorrow(readerId);  //读者借阅次数+1以及可借阅次数-1


        //书籍类
        bookBorrowService.bookBorrowNumber(bookId);  //书籍借用数量加1  -1  状态 已借出

        return Msg.success();
    }

    /**
     * 还书时间获取
     * 1.查询书可借阅的时间 再加上当前时间 就是还书时间
     */
    public Date getReturnTime(Integer bookId){
        //通过查询书籍获取类 并调用书籍类型id
        BookTbl book = bookMainService.findBook(bookId);
        //通过书籍类型id 获取类型对应的类
        BookTypeTbl bookType = bookMainService.findIdBookType(book.getTypeId());
        Date returnTime =new Date();
        Calendar calendar=Calendar.getInstance();   //通过反射创建日历对象
        calendar.setTime(returnTime);
        calendar.add(Calendar.DATE,bookType.getToborrowDays());  //当前时间加上通过类型获取的可借阅时间
        returnTime=calendar.getTime();
        return returnTime;
    }
    /**
     * 查询读者借阅信息
     * @return
     */
    @RequestMapping("readerBorrowedBooks")
    public Msg findReaderBorrowInfo(@RequestParam("pn") Integer pn,@RequestParam("readerId") Integer readerId){
        PageHelper.startPage(pn,10);

        List<BookToborrowTbl> readerBorrowInfo = bookBorrowService.findReaderBorrowInfo(readerId);

        PageInfo<BookToborrowTbl> pageInfo=new PageInfo<>(readerBorrowInfo);

        return Msg.success().add("pageInfo",pageInfo);
    }
    /**
     * 图书续借
     */
    @RequestMapping("renewBook")
    public Msg renewBook(@RequestParam("toBorrowId") Integer toBorrowId,@RequestParam("bookId") Integer bookId){
        //根据id查询出借书信息
        BookToborrowTbl borrowInfoById = bookBorrowService.findBorrowInfoById(toBorrowId);
        //获取还书时间  将时间向后延长一月
        Date returnTime = getReturnTime(borrowInfoById.getBookId());
        borrowInfoById.setReturnedDate(returnTime);
        //Update修改后归还的日期
        bookBorrowService.UpdateBorrowInfo(borrowInfoById);
        //修改书籍的可续借次数
        bookBorrowService.bookBorrowNumber(borrowInfoById.getBookId());

        return Msg.success();
    }
}
