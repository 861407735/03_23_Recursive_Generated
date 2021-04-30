package com.fc.controller;

import com.fc.entity.LibraryTbl;
import com.fc.entity.Msg;
import com.fc.service.LibraryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 图书馆信息
 * /localhost:8080/library?libraryName=“”
 */
@RestController
public class LibraryController {
    @Autowired
    private LibraryInfoService libraryInfoService;

    /**
     * 查询出图书馆的信息
     * @param libraryName
     * @return
     */
    @RequestMapping("library")
    public Msg libraryInfo(@RequestParam("libraryName") String libraryName){
        LibraryTbl libraryInfo = libraryInfoService.findLibraryInfo(libraryName);
        libraryInfo.getLibraryName();
        return Msg.success().add("lib",libraryInfo);
    }
}
