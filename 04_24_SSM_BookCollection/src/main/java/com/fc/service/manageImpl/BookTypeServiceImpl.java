package com.fc.service.manageImpl;

import com.fc.dao.BookTblMapper;
import com.fc.dao.BookTypeTblMapper;
import com.fc.entity.BookTbl;
import com.fc.entity.BookTypeTbl;
import com.fc.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookTypeServiceImpl implements BookTypeService {
    @Autowired
    private BookTypeTblMapper bookTypeTblMapper;
    /**
     * 查询所有书籍情况
     * @return
     */
    @Override
    public List<BookTypeTbl> findBookType() {
        return bookTypeTblMapper.findBookType();
    }

    /**
     * 添加书籍类型
     * @param bookTypeName
     * @return
     */
    @Override
    public BookTypeTbl selectBookType(String bookTypeName) {

        return  bookTypeTblMapper.selectBookTypeName(bookTypeName);
    }

    /**
     * 查询此类型书籍还有多少本
     * @param typeId
     * @return
     */
    @Override
    public BookTypeTbl selectBookTypeCount(Integer typeId) {
        return bookTypeTblMapper.selectBookTypeCount(typeId);
    }

    /**
     * 插入书籍类型
     * @param bookTypeTbl
     * @return
     */
    @Override
    public int insertBookType(BookTypeTbl bookTypeTbl) {
        return bookTypeTblMapper.insertSelective(bookTypeTbl);
    }

    /**
     * 通过id 删除书籍类型
     * @param id
     * @return
     */
    @Override
    public int deleteBookType(Integer id) {
        return bookTypeTblMapper.deleteByPrimaryKey(id);
    }
}
