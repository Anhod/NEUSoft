package com.neu.controller;

import com.neu.po.Dept;
import com.neu.service.DeptService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.jws.WebParam;

@Controller
@RequestMapping("dept")
public class DeptController {
    @Resource
    private DeptService deptService;

    @RequestMapping("getById")
    public String getById(int deptno, Model model){
        System.out.println(10);
        Dept dept = deptService.getById(deptno);
        model.addAttribute("dept",dept);

        return "dept/depts";
    }
}
