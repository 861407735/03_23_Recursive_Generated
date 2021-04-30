package com.fc.service;


import com.fc.entity.ManagerTbl;
import com.fc.entity.Msg;

import java.util.List;

/**
 * 查询管理员信息操作
 */
public interface ManageService {
    /**
     * 查询用户账号是否存在
     * @return
     */
    boolean findManageName(String ManageName);

    /**
     * 判断账号密码是否正确
     * @param managerName
     * @param managerPwd
     * @return
     */
    boolean checkManagerPwd(String managerName, String managerPwd);

    /**
     * 管理员注册
     * @param managerName
     * @param confirmPwd
     * @return
     */
    Msg registerManager(String managerName,String confirmPwd);

    /**
     * 查询管理员的信息 操作
     * @return
     */
    List<ManagerTbl> findAllManagersInfo();

    /**
     * 根据id删除管理员信息
     * @param id
     * @return
     */
    int deleteManager(Integer id);
}
