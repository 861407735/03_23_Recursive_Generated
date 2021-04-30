package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PagejumpController {

    @RequestMapping("/bookPush")
    public String toBookReturn(){
        return "bookPush";
    }

    @RequestMapping("/bookRenewAndReturn")
    public String toBookRenew(){
        return "bookRenewAndReturn";
    }

    @RequestMapping("/bookBorrow")
    public String toBookBorrow(){
        return "bookBorrow";
    }

    @RequestMapping("/bookType")
    public String toBookType(){
        return "bookType";
    }


    @RequestMapping("/bookInfo")
    public String toBookInfo(){
        return "bookInfo";
    }

    @RequestMapping(path = "/adminSettings")
    public String toAdminSettings(){
        return "adminSettings";
    }

    @RequestMapping(path = "/readerService")
    public String toReaderService(){
        return "readerService";
    }

    @RequestMapping(path = "/readerRank")
    public String toReaderRank(){
        return "readerRank";
    }

    @RequestMapping(path = "/bookRank")
    public String toBookRank(){
        return "bookRank";
    }

    @RequestMapping(path = "/homepage")
    public String toHomePage(){
        return "homepage";
    }

    @RequestMapping(path = "/changePwd")
    public String toChangePwdPage(){
        return "changePwd";
    }

    @RequestMapping(path = "/error")
    public String toErrorPage(){
        return "redirect:/error";
    }

    @RequestMapping("/login")
    public String toIndexPage(){
        System.out.println(111);
        return "redirect:/index.jsp";
    }
}
