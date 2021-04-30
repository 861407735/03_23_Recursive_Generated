package com.fc.dao;

import com.fc.entity.BookTbl;
import com.fc.entity.BookToborrowTbl;
import com.fc.entity.BookToborrowTblExample;
import java.util.List;

import com.fc.entity.ReaderTbl;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookToborrowTblMapper {
    long countByExample(BookToborrowTblExample example);

    int deleteByExample(BookToborrowTblExample example);

    int deleteByPrimaryKey(Integer bookToborrowId);

    int insert(BookToborrowTbl record);

    int insertSelective(BookToborrowTbl record);

    List<BookToborrowTbl> selectByExample(BookToborrowTblExample example);

    BookToborrowTbl selectByPrimaryKey(Integer bookToborrowId);

    int updateByExampleSelective(@Param("record") BookToborrowTbl record, @Param("example") BookToborrowTblExample example);

    int updateByExample(@Param("record") BookToborrowTbl record, @Param("example") BookToborrowTblExample example);

    int updateByPrimaryKeySelective(BookToborrowTbl record);

    int updateByPrimaryKey(BookToborrowTbl record);

    /**
     * 通过名称查询书籍
     * @param searchText
     * @return
     */
    List<BookTbl> selectBook(@Param("searchText") String searchText);

    /**
     * 通过条形码
     * 查询用户信息
     * @param readerBarCode
     * @return
     */
    ReaderTbl barFindReader(@Param("barcode") String readerBarCode);
}