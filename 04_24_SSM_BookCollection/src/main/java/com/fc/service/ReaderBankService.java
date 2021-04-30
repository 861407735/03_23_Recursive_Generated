package com.fc.service;

import com.fc.entity.ReaderTbl;
import com.fc.entity.ReaderTblExample;

import javax.swing.*;
import java.util.List;

public interface ReaderBankService {
    /**
     * 查询所有读者信息排行
     * @param
     * @return
     */
    List<ReaderTbl> findAllReader();

    /**
     * 添加读者信息
     * @param
     * @return
     */
    int insertReader(ReaderTbl reader);

    /**
     * 修改读者信息
     * @param reader
     * @return
     */
    int updateReaderInfo(ReaderTbl reader);

    /**
     * 删除读者信息
     * @param id
     * @return
     */
    int deleteReaderInfo(Integer id);

    /**
     * 根据id 查询出读者信息
     * @param readerId
     * @return
     */
    ReaderTbl findReaderInfo(Integer readerId);
}
