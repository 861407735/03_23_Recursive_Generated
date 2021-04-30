package com.fc.dao;

import com.fc.entity.LibraryTbl;
import com.fc.entity.LibraryTblExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * 图书馆信息    dao层
 *
 */
@Repository
public interface LibraryTblMapper {
    long countByExample(LibraryTblExample example);

    int deleteByExample(LibraryTblExample example);

    int deleteByPrimaryKey(String libraryName);

    int insert(LibraryTbl record);

    int insertSelective(LibraryTbl record);

    List<LibraryTbl> selectByExample(LibraryTblExample example);

    LibraryTbl selectByPrimaryKey(String libraryName);

    int updateByExampleSelective(@Param("record") LibraryTbl record, @Param("example") LibraryTblExample example);

    int updateByExample(@Param("record") LibraryTbl record, @Param("example") LibraryTblExample example);

    int updateByPrimaryKeySelective(LibraryTbl record);

    int updateByPrimaryKey(LibraryTbl record);

    /**
     * 查询出图书馆信息
     * @param libraryName
     * @return
     */
    LibraryTbl findLibraryInfo(@Param("libraryName") String libraryName);
}