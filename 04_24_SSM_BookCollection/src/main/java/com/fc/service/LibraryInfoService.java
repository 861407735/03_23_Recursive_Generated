package com.fc.service;

import com.fc.entity.LibraryTbl;

public interface LibraryInfoService {
    /**
     * 图书馆信息查询
     * @param libraryName
     * @return
     */
    LibraryTbl findLibraryInfo(String libraryName);
}
