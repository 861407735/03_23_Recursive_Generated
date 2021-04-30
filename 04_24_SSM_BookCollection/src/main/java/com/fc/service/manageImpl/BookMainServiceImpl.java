package com.fc.service.manageImpl;

import com.fc.dao.BookTblMapper;
import com.fc.entity.BookTbl;
import com.fc.entity.BookTypeTbl;
import com.fc.entity.BookcaseTbl;
import com.fc.service.BookMainService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookMainServiceImpl implements BookMainService {
    @Autowired
    private BookTblMapper bookTblMapper;
    /**
     * 查询所有书籍
     * @param
     * @return
     */
    @Override
    public List<BookTbl> findAllBook() {
        return bookTblMapper.findAllBook();
    }

    /**
     * 查询出书籍类型
     * @return
     */
    @Override
    public List<BookTypeTbl> findBookTypes() {
        return bookTblMapper.findBookTypes();
    }

    /**
     * 查询书籍的放置情况
     * @return
     */
    @Override
    public List<BookcaseTbl> findBookCase() {
        return bookTblMapper.findBookCase();
    }
    /**
     * 存储书籍
     * @param bookTbl
     * @return
     */
    @Override
    public int insertBook(BookTbl bookTbl) {
        return bookTblMapper.insertSelective(bookTbl);
    }

    /**
     * 根据id查询书籍
     * @param id
     * @return
     */
    @Override
    public BookTbl findBook(Integer id) {
        return bookTblMapper.selectByPrimaryKey(id);
    }

    /**
     * 修改书籍信息
     * @param bookTbl
     * @return
     */
    @Override
    public int updateBook(BookTbl bookTbl) {
        return bookTblMapper.updateByPrimaryKeySelective(bookTbl);
    }

    /**
     * 删除书籍
     * @param id
     * @return
     */
    @Override
    public int deleteBook(Integer id) {
        return bookTblMapper.deleteByPrimaryKey(id);
    }

}
