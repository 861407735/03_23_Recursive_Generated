package com.fc.dao;

import com.fc.entity.BookTbl;
import com.fc.entity.BookTypeTbl;
import com.fc.entity.BookTypeTblExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookTypeTblMapper {
    long countByExample(BookTypeTblExample example);

    int deleteByExample(BookTypeTblExample example);

    /**
     * 通过id删除书籍类型
     * @param typeId
     * @return
     */
    int deleteByPrimaryKey(Integer typeId);

    int insert(BookTypeTbl record);

    /**
     *
     * @param record
     * @return
     */
    int insertSelective(BookTypeTbl record);

    List<BookTypeTbl> selectByExample(BookTypeTblExample example);

    BookTypeTbl selectByPrimaryKey(Integer typeId);

    int updateByExampleSelective(@Param("record") BookTypeTbl record, @Param("example") BookTypeTblExample example);

    int updateByExample(@Param("record") BookTypeTbl record, @Param("example") BookTypeTblExample example);

    int updateByPrimaryKeySelective(BookTypeTbl record);

    int updateByPrimaryKey(BookTypeTbl record);

    /**
     * 查询所有书籍的类型
     * @return
     */
    List<BookTypeTbl> findBookType();

    /**
     * 查询此类型书籍还有多少本
     * @param typeId
     * @return
     */
    BookTypeTbl selectBookTypeCount(Integer typeId);
    /**
     * 查询此类型名字有没有
     */
    BookTypeTbl selectBookTypeName(String bookTypeName);
}