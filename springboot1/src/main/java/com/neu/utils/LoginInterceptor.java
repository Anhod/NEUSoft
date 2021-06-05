package com.neu.utils;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 拦截器接口
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object userName = session.getAttribute("userName");

        if (userName != null){
            // 表示放行不拦截
            return true;
        }
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("没有权限不能访问");

        return false;
    }
}
