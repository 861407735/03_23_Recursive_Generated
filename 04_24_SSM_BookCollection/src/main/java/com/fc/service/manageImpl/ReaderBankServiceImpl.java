package com.fc.service.manageImpl;

import com.fc.dao.ReaderTblMapper;
import com.fc.entity.ReaderTbl;
import com.fc.entity.ReaderTblExample;
import com.fc.service.ReaderBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
@Service
public class ReaderBankServiceImpl implements ReaderBankService {
    @Autowired
    private ReaderTblMapper readerTblMapper;

    /**
     * 查询所有读者信息
     * @return
     */
    @Override
    public List<ReaderTbl> findAllReader() {
        return readerTblMapper.findAllReader();
    }

    /**
     * 添加读者信息
     * @param
     * @return
     */
    @Override
    public int insertReader(ReaderTbl reader) {

        return readerTblMapper.insertSelective(reader);
    }

    /**
     * 修改读者信息
     * @param reader
     * @return
     */
    @Override
    public int updateReaderInfo(ReaderTbl reader) {
        return readerTblMapper.updateByPrimaryKeySelective(reader);
    }

    /**
     * 删除读者信息
     */
    @Override
    public int deleteReaderInfo(Integer id) {
        return readerTblMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据id查询出读者信息
     * @param readerId
     * @return
     */
    @Override
    public ReaderTbl findReaderInfo(Integer readerId) {

        return readerTblMapper.selectByPrimaryKey(readerId);
    }

}
