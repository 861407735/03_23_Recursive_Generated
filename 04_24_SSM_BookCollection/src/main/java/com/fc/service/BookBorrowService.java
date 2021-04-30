package com.fc.service;

import com.fc.entity.BookTbl;
import com.fc.entity.ReaderTbl;

import java.util.List;

public interface BookBorrowService {
    /**
     * 通过名称查询书籍
     * @param searchText
     * @return
     */
    List<BookTbl> selectBook(String searchText);

    /**
     * 通过条形码查询用户
     * @param readerBarCode
     * @return
     */
    ReaderTbl barFindReader(String readerBarCode);
}
