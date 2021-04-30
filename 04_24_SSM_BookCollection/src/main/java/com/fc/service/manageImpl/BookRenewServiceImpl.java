package com.fc.service.manageImpl;

import com.fc.dao.BookToborrowTblMapper;
import com.fc.entity.BookToborrowTbl;
import com.fc.entity.BookToborrowTblExample;
import com.fc.service.BookRenewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookRenewServiceImpl implements BookRenewService {
    @Autowired
    private BookToborrowTblMapper bookToborrowTblMapper;

    /**
     * 查询出 读者 的借阅信息
     * @param readerId
     * @return
     */
    @Override
    public List<BookToborrowTbl> findReaderBorrowInfo(Integer readerId) {
        BookToborrowTblExample bookToBorrowExample = new BookToborrowTblExample();
        BookToborrowTblExample.Criteria criteria = bookToBorrowExample.createCriteria();
        criteria.andReaderIdEqualTo(readerId);
        criteria.andIsReturnedEqualTo((byte)(0));  //只查出未归还的数据
        List<BookToborrowTbl> bookToBorrowList = bookToborrowTblMapper.selectByExampleWithBook(bookToBorrowExample);
        return bookToBorrowList;
    }
}
