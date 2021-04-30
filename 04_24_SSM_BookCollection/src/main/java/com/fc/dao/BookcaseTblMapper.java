package com.fc.dao;

import com.fc.entity.BookcaseTbl;
import com.fc.entity.BookcaseTblExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookcaseTblMapper {
    long countByExample(BookcaseTblExample example);

    int deleteByExample(BookcaseTblExample example);

    int deleteByPrimaryKey(Integer bookcaseId);

    int insert(BookcaseTbl record);

    int insertSelective(BookcaseTbl record);

    List<BookcaseTbl> selectByExample(BookcaseTblExample example);

    BookcaseTbl selectByPrimaryKey(Integer bookcaseId);

    int updateByExampleSelective(@Param("record") BookcaseTbl record, @Param("example") BookcaseTblExample example);

    int updateByExample(@Param("record") BookcaseTbl record, @Param("example") BookcaseTblExample example);

    int updateByPrimaryKeySelective(BookcaseTbl record);

    int updateByPrimaryKey(BookcaseTbl record);
}