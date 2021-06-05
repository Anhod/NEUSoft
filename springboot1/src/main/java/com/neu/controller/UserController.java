package com.neu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
//@RequestMapping("user")
public class UserController {
    // 访问根目录打开登录页面
//    @RequestMapping("/")
//    public String getLogin(){
//        return "user/login";
//    }

    @RequestMapping("user/login")
    public String login(String userName, String password, HttpSession session){
        if (userName.equals("admin") && password.equals("111")){
            session.setAttribute("userName",userName);
            return "forward:/emp/getAll";
        }else {
            return "forward:/";
        }
    }
}
