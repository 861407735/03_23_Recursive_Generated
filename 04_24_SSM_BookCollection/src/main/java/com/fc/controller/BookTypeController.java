package com.fc.controller;

import com.fc.entity.BookTbl;
import com.fc.entity.BookTypeTbl;
import com.fc.entity.Msg;
import com.fc.service.BookTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookTypeController{
    @Autowired
    private BookTypeService bookTypeService;

    /**
     * 查询出书籍所有类型
     * @param pn
     * @return
     */
    @RequestMapping("/bookTypes")
    public Msg findBookType(@RequestParam("pn") Integer pn){
        PageHelper.startPage(pn,10);
        List<BookTypeTbl> bookType = bookTypeService.findBookType();
        PageInfo<BookTypeTbl> pageInfo = new PageInfo<>(bookType);
        return Msg.success().add("pageInfo",pageInfo);
    }

    /**
     * 添加此类型 查询此类型是否合适
     * @param
     * @return
     */
    @RequestMapping("/checkBookTypeName")
    public Msg insertBookType(@RequestParam("typeName") String typeName){
        System.out.println(typeName+"checkBookTypeName");
        BookTypeTbl bookTypeTbl = bookTypeService.selectBookType(typeName);

        if(bookTypeTbl==null){
           return Msg.success();
        }else{
            return Msg.fail();
        }
    }

    /**
     * 查询此类型书籍还有多少本
     * 有的话将不能被删除
     * @param typeId
     * @return
     */
    @RequestMapping("/getBookCountByType")
    public Msg selectBookTypeCount(@RequestParam("typeId") Integer typeId){
        BookTypeTbl bookTypeTbl = bookTypeService.selectBookTypeCount(typeId);
        List<BookTbl> list;
        try {
             list=bookTypeTbl.getList();
             if(list!=null){
                 return Msg.success().add("count",list.size());
             }
        }catch (NullPointerException e){
            System.out.println("没有此类型书籍");
                e.printStackTrace();
                return Msg.fail();
        }

        return Msg.success();
    }

    /**
     * 插入书籍
     * @param bookTypeTbl
     * @return
     */
    @PostMapping("/bookType")
    public Msg insertBookType(BookTypeTbl bookTypeTbl){
        bookTypeService.insertBookType(bookTypeTbl);
        return Msg.success();
    }
    /**
     * 删除书籍类型
     */
    @DeleteMapping("/bookType/{id}")
    public Msg deleteBookType(@PathVariable("id") Integer id){
        bookTypeService.deleteBookType(id);
        return Msg.success();
    }
}
