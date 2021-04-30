package com.fc.controller;

import com.fc.entity.Msg;
import com.fc.entity.ReaderTbl;
import com.fc.entity.ReaderTblExample;
import com.fc.service.ReaderBankService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;

/**
 * 读者操作
 * 1.查询读者所有信息  对应页面 ：readersRank.jsp
 * 2.查询出读者信息  并加以操作 对应页面 ：readerService.jsp
 */
@RestController
public class ReadersBankController {
    /**
     * 查询所有读者信息
     */
    @Autowired
    private ReaderBankService readerBankService;
    @RequestMapping("readersWithRank")
    public Msg readersRank(@RequestParam("pn") Integer pn){
        PageHelper.startPage(pn,10);
        List<ReaderTbl> allReader = readerBankService.findAllReader();
        PageInfo<ReaderTbl> pageInfo=new PageInfo<>(allReader);
        return Msg.success().add("pageInfo",pageInfo);
    }
    /**
     * 查询读者信息
     * 并操作
     */
    @PostMapping("readerService")
    public Msg renderService(@RequestParam("pn") Integer pn){
        System.out.println(pn);
        PageHelper.startPage(pn,10);
        List<ReaderTbl> allReader = readerBankService.findAllReader();
        PageInfo<ReaderTbl> pageInfo=new PageInfo<>(allReader);
        return Msg.success().add("pageInfo",pageInfo);
    }
    /**
     * 添加读者信息
     */
    @PostMapping("reader")
    public Msg insertReader(ReaderTbl reader){
        int affectedRow = readerBankService.insertReader(reader);
        return Msg.success();
    }
    /**
     * 修改读者信息
     */
    @PutMapping(value = "reader/{readerId}")
    public Msg updateReaderInfo(ReaderTbl reader) {
        readerBankService.updateReaderInfo(reader);
        return Msg.success();
    }
    /**
     * 删除读者信息
     */
    @DeleteMapping("reader/{id}")
    public Msg deleteReaderInfo(@PathVariable("id") Integer id){
        readerBankService.deleteReaderInfo(id);
        return Msg.success();
    }
    /**
     *  根据id查询读者信息
     */
    @GetMapping("reader/{id}")
    public Msg findReaderInfo(@PathVariable("id") Integer readerId){
        ReaderTbl readerInfo = readerBankService.findReaderInfo(readerId);
        return Msg.success().add("reader",readerInfo);
    }
}
