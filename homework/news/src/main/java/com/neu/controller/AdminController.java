package com.neu.controller;

import com.neu.po.Users;
import com.neu.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
@RequestMapping("admin")
public class AdminController {
    @Resource
    private UsersService usersService;

    @RequestMapping("/")
    private String loginMain(){
        return "admin/login";
    }


    @RequestMapping("login")
    public String login(String userName, String password, HttpSession session, HttpServletResponse response) throws IOException {
        Users user = usersService.getUser(userName,password);
        System.out.println(userName+"   "+password);

        if (user!=null){
            session.setAttribute("userName",userName);

            return "redirect:/admin/admin";
        }else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("账号或密码错误");

            return "redirect:/admin/";
        }
    }

    @RequestMapping("admin")
    public String admin(){
        return "admin/admin";
    }

    @RequestMapping("welcome")
    public String welcome(){
        return "admin/welcome";
    }
}
