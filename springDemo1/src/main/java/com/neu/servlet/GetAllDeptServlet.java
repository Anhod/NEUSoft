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
import java.util.List;

@WebServlet(name = "GetAllDeptServlet",value = "/GetAllDeptServlet")
public class GetAllDeptServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 得到ServletContext
        ServletContext servletContext = req.getServletContext();
        WebApplicationContext c =  WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        DeptService deptService = c.getBean(DeptService.class);

        List<Dept> depts = deptService.getAll();
        req.setAttribute("depts",depts);

        // 请求转发给jsp
        req.getRequestDispatcher("/depts.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
