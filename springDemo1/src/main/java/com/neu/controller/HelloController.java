package com.neu.controller;

import com.neu.service.DeptService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@Controller
public class HelloController {

    // @RequestParam手动映射请求参数
    // @RequestParam(required = true,defaultValue = "scott")  String name 设置默认值
    @RequestMapping("hello")
    public void hello(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        System.out.println(name);

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().append(name);
    }

    // 访问页面先登录
    @RequestMapping("/")
    public String getLogin(){
        return "login";
    }

    @RequestMapping("login")
    public String login(String userName, String password, HttpSession session){
        if (userName.equals("admin") && password.equals("111")){
            session.setAttribute("userName",userName);
            return "forward:/dept/getAll";
        }else
            return "redirect:/";
    }


}
