package com.fc.controller;

import com.fc.entity.BookToborrowTbl;
import com.fc.entity.Msg;
import com.fc.entity.ReaderTbl;
import com.fc.service.BookBorrowService;
import com.fc.service.BookRenewService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class bookRenewAndReturnController {

    @Autowired
    private BookRenewService bookRenewService;
    /**
     * 查询读者借阅信息
     * @return
     */
    @RequestMapping("readerBorrowedBooks")
    public Msg findReaderBorrowInfo(@RequestParam("pn") Integer pn,@RequestParam("readerId") Integer readerId){
        PageHelper.startPage(pn,10);

        List<BookToborrowTbl> readerBorrowInfo = bookRenewService.findReaderBorrowInfo(readerId);

        PageInfo<BookToborrowTbl> pageInfo=new PageInfo<>(readerBorrowInfo);

        return Msg.success().add("pageInfo",pageInfo);
    }
}
