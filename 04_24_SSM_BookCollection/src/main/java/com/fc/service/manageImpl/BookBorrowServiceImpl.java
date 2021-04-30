package com.fc.service.manageImpl;

import com.fc.dao.BookTblMapper;
import com.fc.dao.BookToborrowTblMapper;
import com.fc.dao.ReaderTblMapper;
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
    //书籍对应的mapper
    @Autowired
    private BookTblMapper bookTblMapper;
    //读者对应的信息
    @Autowired
    private ReaderTblMapper readerTblMapper;

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

    /**
     * 插入新的借阅信息
     * @param bookToborrow
     * @return
     */
    @Override
    public int borrowBook(BookToborrowTbl bookToborrow) {
        return bookToborrowTblMapper.insertSelective(bookToborrow);
    }
    /**
     * 将书籍借阅数量-1
     * 被借出数量+1
     * 将bookCese设置6 则是已借出的状态
     */
    public int bookBorrowNumber(Integer bookId){
        BookTbl bookTbl = bookTblMapper.selectByPrimaryKey(bookId);
        bookTbl.setBorrowedTimes(bookTbl.getBorrowedTimes()+1);
        bookTbl.setToborrowTimes(bookTbl.getToborrowTimes()-1);
        bookTbl.setBookCaseId(6);
        return bookTblMapper.updateByPrimaryKeySelective(bookTbl);
    }
    /**
     * 书籍借阅
     * 可借阅次数-1
     * 总借阅次数+1
     * @param readerId
     * @return
     */
    @Override
    public int updateReaderBorrow(Integer readerId) {
        return readerTblMapper.updateByIdBorrow(readerId);
    }

}
