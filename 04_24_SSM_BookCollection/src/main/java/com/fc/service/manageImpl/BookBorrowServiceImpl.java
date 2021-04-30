package com.fc.service.manageImpl;

import com.fc.dao.BookToborrowTblMapper;
import com.fc.entity.BookTbl;
import com.fc.entity.BookToborrowTbl;
import com.fc.entity.ReaderTbl;
import com.fc.service.BookBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookBorrowServiceImpl implements BookBorrowService {
    @Autowired
    private BookToborrowTblMapper bookToborrowTblMapper;

    /**
     * 通过名字查询书籍
     * @param searchText
     * @return
     */
    @Override
    public List<BookTbl> selectBook(String searchText) {
        searchText="%"+searchText+"%";
        return bookToborrowTblMapper.selectBook(searchText);
    }

    /**
     * 通过条形码查询用户
     * @param readerBarCode
     * @return
     */
    @Override
    public ReaderTbl barFindReader(String readerBarCode) {
        return bookToborrowTblMapper.barFindReader(readerBarCode);
    }
}
