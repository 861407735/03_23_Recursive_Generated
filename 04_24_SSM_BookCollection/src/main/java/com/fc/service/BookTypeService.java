package com.fc.service;

import com.fc.entity.BookTbl;
import com.fc.entity.BookTypeTbl;

import java.util.List;

public interface BookTypeService {
    /**
     * 查询书籍所有类型
     * @return
     */
    List<BookTypeTbl> findBookType();

    /**
     * 查询是否有类型
     * @param bookTypeName
     * @return
     */
    BookTypeTbl selectBookType(String bookTypeName);

    /**
     * 查询此类型书籍还有多少本
     * @param typeId
     * @return
     */
    BookTypeTbl selectBookTypeCount(Integer typeId);

    /**
     * 插入书籍
     * @param bookTypeTbl
     * @return
     */
    int insertBookType(BookTypeTbl bookTypeTbl);

    /**
     * 删除书籍
     * @param id
     * @return
     */
    int deleteBookType(Integer id);
}
