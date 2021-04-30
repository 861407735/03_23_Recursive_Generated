package com.fc.service;

import com.fc.entity.BookTbl;
import com.fc.entity.BookTypeTbl;
import com.fc.entity.BookcaseTbl;

import java.util.List;

public interface BookMainService {
    /**
     * 查询所有书籍并分页
     * @param
     * @return
     */
    List<BookTbl> findAllBook();

    /**
     * 查询获取书类型
     */
    List<BookTypeTbl> findBookTypes();

    /**
     * 查询书放置的情况
     * @return
     */
    List<BookcaseTbl> findBookCase();

    /**
     * 存储书籍
     * @param bookTbl
     */
    int insertBook(BookTbl bookTbl);

    /**
     * 根据id
     * 查询单本书籍
     * @param id
     * @return
     */
    BookTbl findBook(Integer id);

    /**
     * 修改书籍信息
     * @param bookTbl
     * @return
     */
    int updateBook(BookTbl bookTbl);

    /**
     * 删除书籍
     * @param id
     * @return
     */
    int deleteBook(Integer id);
}
