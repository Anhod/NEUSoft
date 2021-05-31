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

@WebServlet(name = "GetDeptServlet",value = "/GetDeptServlet")
public class GetDeptServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public GetDeptServlet() {
        super();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 得到ServletContext
        ServletContext servletContext = req.getServletContext();

        WebApplicationContext c =  WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);

        DeptService deptService = c.getBean(DeptService.class);

        Dept dept = deptService.getById(10);

        resp.setContentType("text/html;charset=utf-8");

        resp.getWriter()
                .append("部门名称："+dept.getDname())
                .append("部门地址："+dept.getLoc());

        resp.getWriter().close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
