package com.neu.controller;

import com.github.pagehelper.PageInfo;
import com.neu.po.Dept;
import com.neu.service.DeptService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("dept")
public class DeptController {
    @Resource
    private DeptService deptService;

    @RequestMapping(value = "insert",method = {RequestMethod.GET},params = {"deptno=1","dname"})
    public String first(){
        return "dept/getAll";
    }

    // 在路径中输入属性，插入成功跳转查询全部jsp
    // 比如：dept/insert?deptno=100&dname=哈哈&loc=好

    // 在方法的形参中加注解
    @RequestMapping("insert")
    public String insert(@Valid Dept dept, Errors errors,Model model){
        // 检查是否有错误
        if (errors.hasErrors()){
            model.addAttribute("errorList",errors.getAllErrors());
            return "dept/insert";
        }

        int n = deptService.insert(dept);
        System.out.println(dept);

        // 重定向
         return "redirect:/dept/getAll";
    }

    // 直接转回insert jsp
    @RequestMapping("getInsertPage")
    public String getInsertPage(){
        return "dept/insert";
    }

    // 查询全部
    @RequestMapping("getAll")
    public String getAll(Model model){
        List<Dept>  depts = deptService.getAll();
        model.addAttribute("depts",depts);

        return "dept/depts";
    }

    // 删除方法
    @RequestMapping("delete")
    public String delete(int deptno){
        int n = deptService.delete(deptno);

        return "redirect:/dept/getAll";
    }

    @RequestMapping("edit")
    public String edit(int deptno, Model model){
        Dept dept = deptService.getById(deptno);
        model.addAttribute("dept",dept);

        return "dept/editDept";
    }

    @RequestMapping("update")
    public String update(Dept dept){
        int n = deptService.update(dept);

        return "redirect:/dept/getAll";

    }

    // 批量删除
    @RequestMapping("batchDelete")
    public String batchDelete(int[] deptno){
        System.out.println(Arrays.toString(deptno));

        return "redirect:/dept/getAll";
    }

    // 分页
    @RequestMapping("getPaged")
    public String getPaged(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "3") int pageSize, Model model){
        PageInfo<Dept> pageInfo =deptService.getPaged(pageNum,pageSize);
        model.addAttribute("pageInfo",pageInfo);
        return "dept/paged";
    }
}
