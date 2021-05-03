package com.fc.service;

import com.fc.entity.BookTbl;
import com.fc.entity.BookToborrowTbl;
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

    /**
     * 插入新的借阅的信息
     * @param bookToborrow
     */
    int borrowBook(BookToborrowTbl bookToborrow);

    /**
     * 书籍续可借次数-1
     * 续借次数+1
     * 类型改为已借出
     * @param bookId
     * @return
     */
    int bookBorrowNumber(Integer bookId);
    /**
     * 减少一次读者的借阅次数
     * 加一次读者的总借阅次数
     * @return
     */
    int updateReaderBorrow(Integer readerId);
    /**
     * 查询读者借阅信息
     * @param
     * @param readerId
     * @return
     */
    List<BookToborrowTbl> findReaderBorrowInfo(Integer readerId);

    /**
     * 通过id查询借书信息
     * @return
     */
    BookToborrowTbl findBorrowInfoById(Integer borrowId);

    /**
     * 修改后的信息
     * @param
     */
    int UpdateBorrowInfo(BookToborrowTbl borrowInfoById);
}
