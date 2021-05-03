package com.fc.service.manageImpl;

import com.fc.dao.BookReturnTblMapper;
import com.fc.dao.BookToborrowTblMapper;
import com.fc.entity.BookReturnTbl;
import com.fc.entity.BookToborrowTbl;
import com.fc.entity.BookToborrowTblExample;
import com.fc.service.BookRenewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookRenewServiceImpl implements BookRenewService {
    @Autowired
    private BookReturnTblMapper bookReturnTblMapper;


    @Override
    public int insrtBookReturnInfo(BookReturnTbl bookReturnTbl) {
        return bookReturnTblMapper.insertSelective(bookReturnTbl);
    }
}
