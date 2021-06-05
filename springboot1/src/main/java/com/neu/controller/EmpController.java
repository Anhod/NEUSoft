package com.neu.controller;

import com.neu.po.Dept;
import com.neu.po.Emp;
import com.neu.service.DeptService;
import com.neu.service.EmpService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

//@Controller
@RestController // RESTFul风格
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

    // 返回JSON
    @RequestMapping("getAll2")
//    @ResponseBody
    public List<Emp> getAll2(){
        List<Emp> list = empService.getAll();

        return list;
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

//    上传文件控制器，转到上传文件的控制器
//    @RequestMapping("upload")
//    public String upload(){
//        return "emp/upload";
//    }

    // 处理上传文件请求
    @RequestMapping("dealUpload")
    public void dealUpload(@RequestParam("files") MultipartFile[] files, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getServletContext().getRealPath("/WEB-INF/upload");
        for (MultipartFile file:files){
            if (file != null && !file.isEmpty()){
                String fname = file.getOriginalFilename();   // 得到文件原始文件名
                File f = new File(path,fname);
                // 保存文件
                file.transferTo(f);
            }
        }

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().append("文件上传成功");
    }

}
