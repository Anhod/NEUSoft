package com.neu.servlet;

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

@WebServlet(name = "DeleteDeptServlet",value = "/DeleteDeptServlet")
public class DeleteDeptServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int deptno = Integer.parseInt(req.getParameter("deptno"));

        // 得到ServletContext
        ServletContext servletContext = req.getServletContext();
        WebApplicationContext c =  WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        DeptService deptService = c.getBean(DeptService.class);

        int n = deptService.delete(deptno);
        if (n==1){
            req.getRequestDispatcher("/GetAllDeptServlet").forward(req,resp);
        }else {
            resp.getWriter().println("error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
