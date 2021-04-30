package com.fc.service;

import com.fc.entity.BookToborrowTbl;

import java.util.List;

public interface BookRenewService {
    /**
     * 查询读者借阅信息
     * @param
     * @param readerId
     * @return
     */
    List<BookToborrowTbl> findReaderBorrowInfo(Integer readerId);
}
