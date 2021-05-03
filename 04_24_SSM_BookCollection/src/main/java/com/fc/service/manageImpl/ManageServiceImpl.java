package com.fc.service.manageImpl;

import com.fc.dao.ManagerTblMapper;
import com.fc.entity.ManagerTbl;
import com.fc.entity.ManagersInfo;
import com.fc.entity.Msg;
import com.fc.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageServiceImpl implements ManageService {
    @Autowired
    private ManagerTblMapper managerTblMapper;

    /**
     * 查询是否存在此账号
     * @param ManageName
     * @return
     */
    @Override
    public boolean findManageName(String ManageName) {
        ManagerTbl manageName = managerTblMapper.findManageName(ManageName);
        if(manageName!=null){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 判断账号密码是否正确
     * @param managerName
     * @param managerPwd
     * @return
     */
    @Override
    public boolean checkManagerPwd(String managerName, String managerPwd) {
        //调用判断账号的接口方法  返回账号符合账号的对象  用来判断密码是否正确
        ManagerTbl manage = managerTblMapper.findManageName(managerName);
        if(manage.getManagerPwd().equals(managerPwd)){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 管理员账号注册
     * @param managerName
     * @param confirmPwd
     * @return
     */
    @Override
    public Msg registerManager(String managerName, String confirmPwd) {
        //调用查询账号的方法  判断是否账号重复  返回值是对象
        //  对象为null  则表示数据库中没有此对象  可以插入
        ManagerTbl manageName = managerTblMapper.findManageName(managerName);
        if (manageName == null) {
            int affectedRow = managerTblMapper.registerManager(managerName, confirmPwd);
            if (affectedRow >= 0) {
                return Msg.success();
            }
        } else {
            return Msg.fail();
        }
        return Msg.fail();
    }

    /**
     * 查询管理员信息
     * @return
     */
    @Override
    public List<ManagerTbl> findAllManagersInfo() {
        return managerTblMapper.findAllManagersInfo();
    }

    /**
     * 根据id删除管理员信息
     * @param id
     * @return
     */
    @Override
    public int deleteManager(Integer id) {
        return managerTblMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updatePassword(String managerName, String newPwd) {
        return managerTblMapper.updatePassword(managerName,newPwd);
    }
}
