package com.neu.servlet;

import com.neu.po.Account;
import com.neu.service.AccountService;
import org.apache.ibatis.annotations.Insert;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("userId"));

        // 得到ServletContext
        ServletContext servletContext = req.getServletContext();

        WebApplicationContext c =  WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);

        AccountService accountService =c.getBean(AccountService.class);

        Account account = accountService.getById(userId);
        if (account.getBalance()>=0){
            req.setAttribute("account",account);
            req.getRequestDispatcher("/success.jsp").forward(req,resp);
        }else
            req.getRequestDispatcher("/fail.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
