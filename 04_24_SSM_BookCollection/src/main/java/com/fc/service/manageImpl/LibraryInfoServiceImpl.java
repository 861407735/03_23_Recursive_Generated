package com.fc.service.manageImpl;

import com.fc.dao.LibraryTblMapper;
import com.fc.entity.LibraryTbl;
import com.fc.service.LibraryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryInfoServiceImpl implements LibraryInfoService {
    @Autowired
    private LibraryTblMapper libraryTblMapper;

    /**
     * 图书馆信息查询
     * @param libraryName
     * @return
     */
    @Override
    public LibraryTbl findLibraryInfo(String libraryName) {
        return libraryTblMapper.findLibraryInfo(libraryName);
    }
}
