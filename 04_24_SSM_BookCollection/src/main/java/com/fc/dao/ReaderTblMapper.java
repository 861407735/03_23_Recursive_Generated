package com.fc.dao;

import com.fc.entity.ReaderTbl;
import com.fc.entity.ReaderTblExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.swing.*;

/**
 * 读者信息
 */
@Repository
public interface ReaderTblMapper {
    long countByExample(ReaderTblExample example);

    int deleteByExample(ReaderTblExample example);

    /**
     * 根据id删除读者信息
     * @param readerId
     * @return
     */
    int deleteByPrimaryKey(Integer readerId);

    int insert(ReaderTbl record);
    /**
     * 添加读者信息
     * @param
     * @return
     */
    int insertSelective(ReaderTbl record);

    List<ReaderTbl> selectByExample(ReaderTblExample example);

    /**
     * 根据id查询出读者信息
     * @param readerId
     * @return
     */
    ReaderTbl selectByPrimaryKey(Integer readerId);

    int updateByExampleSelective(@Param("record") ReaderTbl record, @Param("example") ReaderTblExample example);

    int updateByExample(@Param("record") ReaderTbl record, @Param("example") ReaderTblExample example);
    /**
     *修改用户信息 动态sql
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ReaderTbl record);

    /**
     * 修改用户信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(ReaderTbl record);

    /**
     * 查询所有读者信息
     */
    List<ReaderTbl> findAllReader();

}