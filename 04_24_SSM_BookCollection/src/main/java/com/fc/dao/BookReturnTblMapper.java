package com.fc.dao;

import com.fc.entity.BookReturnTbl;
import com.fc.entity.BookReturnTblExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookReturnTblMapper {
    long countByExample(BookReturnTblExample example);

    int deleteByExample(BookReturnTblExample example);

    int deleteByPrimaryKey(Integer bookReturnId);

    int insert(BookReturnTbl record);

    int insertSelective(BookReturnTbl record);

    List<BookReturnTbl> selectByExample(BookReturnTblExample example);

    BookReturnTbl selectByPrimaryKey(Integer bookReturnId);

    int updateByExampleSelective(@Param("record") BookReturnTbl record, @Param("example") BookReturnTblExample example);

    int updateByExample(@Param("record") BookReturnTbl record, @Param("example") BookReturnTblExample example);

    int updateByPrimaryKeySelective(BookReturnTbl record);

    int updateByPrimaryKey(BookReturnTbl record);
}