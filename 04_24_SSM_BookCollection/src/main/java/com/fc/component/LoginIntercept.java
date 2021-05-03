package com.fc.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginIntercept implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String surl = request.getRequestURI();
        StringBuffer sburl=request.getRequestURL();
        //登陆时需要执行的Ajax操作
        if(sburl.indexOf("anager")>=0){
            System.out.println("管理操作");
            return true;
        }
        if(surl.indexOf("login")>=0){
            System.out.println("登录操作");
            return true;
        }
        //判断是否登录
        HttpSession session = request.getSession();
        String loginName = (String) session.getAttribute("loginName");
        if(loginName!=null){
            return true;
        }else{
            System.out.println("没有登录");
            request.getRequestDispatcher("error.jsp").forward(request,response);
        }

        System.out.println("拦截器");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
