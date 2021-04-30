package com.fc.dao;

import com.fc.entity.ManagerTbl;
import com.fc.entity.ManagerTblExample;
import java.util.List;

import com.fc.entity.ManagersInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 管理员查询
 */
@Repository
public interface ManagerTblMapper {
    long countByExample(ManagerTblExample example);

    int deleteByExample(ManagerTblExample example);

    /**
     * 通过id删除管理员信息
     * @param managerId
     * @return
     */
    int deleteByPrimaryKey(Integer managerId);

    int insert(ManagerTbl record);

    int insertSelective(ManagerTbl record);

    List<ManagerTbl> selectByExample(ManagerTblExample example);

    ManagerTbl selectByPrimaryKey(Integer managerId);

    int updateByExampleSelective(@Param("record") ManagerTbl record, @Param("example") ManagerTblExample example);

    int updateByExample(@Param("record") ManagerTbl record, @Param("example") ManagerTblExample example);

    int updateByPrimaryKeySelective(ManagerTbl record);

    int updateByPrimaryKey(ManagerTbl record);

    /**
     * 查询用户账号是否存在
     * @return
     */
    ManagerTbl findManageName(@Param("ManageName") String ManageName);

    int registerManager(@Param("user") String managerName, @Param("pwd") String confirmPwd);

    List<ManagerTbl> findAllManagersInfo();
}