package com.fc.controller;

import com.fc.entity.ManagerTbl;
import com.fc.entity.ManagersInfo;
import com.fc.entity.Msg;
import com.fc.service.ManageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 登录的controller操作
 * 以及管理员的注册 和删除
 */
@RestController
//@RequestMapping("login")
public class LoginController {
    @Autowired
    private ManageService manageService;
    /**
     * 判断账号是否存在
     */
    @RequestMapping(value = "/checkManagerNameExists")
    public Msg checkManagerNameExists(@RequestParam("mangerName") String managerName){
        boolean b = manageService.findManageName(managerName);
        if(b){
            return Msg.success().add("va_login_name_msg","用户名不存在！请注册").add("va_register_name_msg","用户名可用！");
        }else{
            return Msg.fail().add("va_register_name_msg","用户名已存在！请更换用户名！");
        }
    }

    /**
     * 判断账号密码是否存在
     * @return
     */
    @RequestMapping("/checkManagerPwd")
    public Msg checkManagerPwd(@RequestParam("managerName") String managerName, @RequestParam("managerPwd") String managerPwd, HttpSession session){
        boolean b = manageService.checkManagerPwd(managerName, managerPwd);

        if(b){
            session.setAttribute("loginName",managerName);
            return Msg.success();
        }else{
            return Msg.fail().add("va_pwd_msg","密码错误，请重新输入！");
        }
    }
    /**
     * 管理员账号注册
     */
    @RequestMapping("/manager")
    public Msg registerManager(@RequestParam("managerName") String managerName,@RequestParam("confirmPwd")String confirmPwd){

        return manageService.registerManager(managerName, confirmPwd);
    }

    /**
     * 查询管理员 信息  以及操作
     */
    @RequestMapping("/managers")
    public Msg findAllManagersInfo(@RequestParam("pn") Integer pn){
        PageHelper.startPage(pn,10);
        List<ManagerTbl> allManagersInfo = manageService.findAllManagersInfo();
        System.out.println(allManagersInfo);
        PageInfo<ManagerTbl> pageInfo=new PageInfo<>(allManagersInfo);
        return  Msg.success().add("pageInfo",pageInfo);
    }
    /**
     * 删除管理员信息
     * 根据id删除
     */
    @DeleteMapping("/manager/{managerId}")
    public Msg deleteManager(@PathVariable("managerId") Integer id){
        int affectedRow = manageService.deleteManager(id);
        if (affectedRow>=0){
            return Msg.success();
        }
        return Msg.fail();
    }
}
