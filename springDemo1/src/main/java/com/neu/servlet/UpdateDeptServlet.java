package com.neu.servlet;

import com.neu.po.Dept;
import com.neu.service.DeptService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateDeptServlet",value = "/UpdateDeptServlet")
public class UpdateDeptServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 接收从jsp传过来的参数
        int deptno = Integer.parseInt(req.getParameter("deptno"));
        String dname = req.getParameter("dname");
        String loc = req.getParameter("loc");

        Dept dept = new Dept(deptno,dname,loc);

        // 得到ServletContext
        ServletContext servletContext = req.getServletContext();

        WebApplicationContext c =  WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);

        DeptService deptService = c.getBean(DeptService.class);

        int n =deptService.update(dept);
        if (n==1){
            req.getRequestDispatcher("/GetAllDeptServlet").forward(req,resp);
        }else {
            resp.getWriter().println("error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req, resp);
    }
}
