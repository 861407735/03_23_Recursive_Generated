package com.fc.controller;

import com.fc.entity.BookTbl;
import com.fc.entity.BookTypeTbl;
import com.fc.entity.BookcaseTbl;
import com.fc.entity.Msg;
import com.fc.service.BookMainService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 登录的首页  书籍的排行
 * 图书信息管理  页面：bookRank.jsp    bookInfo.jsp
 */
@RestController
public class BookMainController {
    @Autowired
    private BookMainService bookMainService;
    /**
     * 查询你所有书籍
     * @return
     */
    @RequestMapping("/booksWithRank")
    public Msg booksWithRank(@RequestParam("pn") Integer pn){
        PageHelper.startPage(pn,10);
        List<BookTbl> allBook = bookMainService.findAllBook();

        PageInfo<BookTbl> pageInfo=new PageInfo<>(allBook);
        System.out.println(pageInfo);

        return Msg.success().add("pageInfo",pageInfo);
    }
    /**
     * 图书信息管理页面
     * 查出图书
     */
    @RequestMapping("/books")
    public Msg findBooks(@RequestParam("pn") Integer pn){
        //分页   显示第几页   每页显示多少条信息
        PageHelper.startPage(pn,10);
        List<BookTbl> allBook = bookMainService.findAllBook();
        PageInfo<BookTbl> pageInfo=new PageInfo<>(allBook);
        System.out.println(pageInfo);
        return Msg.success().add("pageInfo",pageInfo);
    }

    /**
     * 查询出书籍的类型
     * @return
     */
    @RequestMapping("/getBookTypes")
    public Msg findBookTypes(){
        List<BookTypeTbl> bookTypes = bookMainService.findBookTypes();

        return Msg.success().add("bookTypes",bookTypes);
    }
    /**
     * 查询书籍的放置情况
     * @return
     */
    @RequestMapping("/getBookCases")
    public Msg findBookCase(){
        List<BookcaseTbl> bookCase = bookMainService.findBookCase();
        return Msg.success().add("bookcases",bookCase);
    }

    /**
     * 存储书籍
     * @return
     */
    @RequestMapping("/book")
    public Msg insertBook(BookTbl bookTbl){
        int affectedRow = bookMainService.insertBook(bookTbl);
        return Msg.success();
    }

    /**
     * 根据id查询书籍
     * @param id
     * @return
     */
    @GetMapping("/book/{id}")
    public Msg findBook(@PathVariable("id") Integer id){
        BookTbl book = bookMainService.findBook(id);
        return Msg.success().add("book",book);
    }
    /**
     * 修改书籍信息
     */
    @PutMapping("/book/{bookId}")
    public Msg updateBook(BookTbl bookTbl){
        bookMainService.updateBook(bookTbl);
        return Msg.success();
    }
    /**
     * 删除图书
     */
    @DeleteMapping("/book/{id}")
    public Msg deleteBook(@PathVariable("id") Integer id){
        bookMainService.deleteBook(id);
        return Msg.success();
    }
}
