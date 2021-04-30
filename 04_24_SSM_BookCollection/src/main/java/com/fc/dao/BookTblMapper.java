package com.fc.dao;

import com.fc.entity.BookTbl;
import com.fc.entity.BookTblExample;
import java.util.List;

import com.fc.entity.BookTypeTbl;
import com.fc.entity.BookcaseTbl;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookTblMapper {
    long countByExample(BookTblExample example);

    int deleteByExample(BookTblExample example);

    /**
     * 通过id 删除书籍
     * @param bookId
     * @return
     */
    int deleteByPrimaryKey(Integer bookId);

    int insert(BookTbl record);

    int insertSelective(BookTbl record);

    List<BookTbl> selectByExample(BookTblExample example);

    BookTbl selectByPrimaryKey(Integer bookId);

    int updateByExampleSelective(@Param("record") BookTbl record, @Param("example") BookTblExample example);

    int updateByExample(@Param("record") BookTbl record, @Param("example") BookTblExample example);

    int updateByPrimaryKeySelective(BookTbl record);

    int updateByPrimaryKey(BookTbl record);

    /**
     * 查询所有书
     * @return
     */
    List<BookTbl> findAllBook();

    /**
     * 查询出所有书类型
     * @return
     */
    List<BookTypeTbl> findBookTypes();

    /**
     * 查询出书籍所有的放置情况
     * @return
     */
    List<BookcaseTbl> findBookCase();

    /**
     * 通过书籍类型id
     * 查询出对应类型
     * @param bookTypeId
     * @return
     */
    BookTypeTbl findIdBookType(Integer bookTypeId);
}