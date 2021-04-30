package com.fc.controller;

import com.fc.entity.BookTbl;
import com.fc.entity.BookTblExample;
import com.fc.entity.Msg;
import com.fc.entity.ReaderTbl;
import com.fc.service.BookBorrowService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 图书借阅  页面：bookBorrow.jsp
 */
@RestController
public class BookBorrowController {
    @Autowired
    private BookBorrowService bookBorrowService;

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

        return null;
    }
}
