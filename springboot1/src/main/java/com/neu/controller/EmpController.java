package com.neu.controller;

import com.neu.po.Dept;
import com.neu.po.Emp;
import com.neu.service.DeptService;
import com.neu.service.EmpService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("emp")
public class EmpController {
    @Resource
    private EmpService empService;

    @Resource
    private DeptService deptService;

    @RequestMapping("getAll")
    public String getAll(Model model){

        List<Emp> emps = empService.getAll();
        model.addAttribute("emps",emps);

        return "emp/emps";
    }

    @RequestMapping("edit")
    public String edit(int empno,Model model){
        Emp emp = empService.getById(empno);
        model.addAttribute("emp",emp);

        List<Dept> depts = deptService.getAll();
        model.addAttribute("depts",depts);

        return "emp/edit";
    }

    @RequestMapping("update")
    public String update(Emp emp){
        System.out.println(emp);

        return "redirect:/emp/getAll";
    }
}
