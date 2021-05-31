package com.neu.servlet;

import com.neu.po.Dept;
import com.neu.service.DeptService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditDeptServlet",value = "/EditDeptServlet")
public class EditDeptServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收从jsp传过来的参数
        int deptno = Integer.parseInt(req.getParameter("deptno"));

        // 得到ServletContext
        ServletContext servletContext = req.getServletContext();

        WebApplicationContext c =  WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);

        DeptService deptService = c.getBean(DeptService.class);

        Dept dept = deptService.getById(deptno);
        req.setAttribute("dept",dept);
        req.getRequestDispatcher("/editDept.jsp").forward(req,resp);
    }
}
