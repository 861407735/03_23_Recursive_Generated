package com.fc.service;

import com.fc.entity.BookReturnTbl;
import com.fc.entity.BookToborrowTbl;

import java.util.List;

public interface BookRenewService {
    /**
     * 插入一条新的图书归还信息
     * @param bookReturnTbl
     * @return
     */
    int insrtBookReturnInfo(BookReturnTbl bookReturnTbl);
}
