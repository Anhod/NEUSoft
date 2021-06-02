package com.neu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    // 访问页面先登录
    @RequestMapping("/")
    public String getLogin(){
        System.out.println("hahaha");
        return "login";
    }

    @RequestMapping("login")
    public String login(String userName, String password, HttpSession session){

        if (userName.equals("admin") && password.equals("111")){
            session.setAttribute("userName",userName);
            return "forward:/book/getPaged";
        }else
            return "redirect:/";
    }
}
