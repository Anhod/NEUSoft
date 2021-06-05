package com.neu.controller;

import com.github.pagehelper.PageInfo;
import com.neu.po.FirstTitle;
import com.neu.service.FirstTitleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("first")
public class FirstController {
    @Resource
    private FirstTitleService firstTitleService;

    // 跳转到添加一级新闻页面
    @RequestMapping("add")
    public String add(){
        return "admin/addFirst";
    }

    // 跳转到查看一级新闻列表页面
    @RequestMapping("firstList")
    public String getPaged(@RequestParam(defaultValue = "1") int pageNum,  @RequestParam(defaultValue = "10") int pageSize, Model model){
        PageInfo<FirstTitle> pageInfo = firstTitleService.getPaged(pageNum,pageSize);

        System.out.println(pageInfo);
        model.addAttribute("pageInfo",pageInfo);

        return "admin/firstList";
    }

    @RequestMapping("insert")
    public String insert(FirstTitle firstTitle){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String createTime = simpleDateFormat.format(new Date());
        firstTitle.setCreateTime(createTime);

        firstTitleService.insert(firstTitle);

        // 此处还需要改
        return "redirect:/first/add";
    }

    @RequestMapping("delete")
    public String delete(String fid){
        firstTitleService.delete(Integer.parseInt(fid));

        return "redirect:/first/firstList";
    }

    @RequestMapping("update")
    public String update(String fid,Model model){
        FirstTitle firstTitle = firstTitleService.getById(Integer.parseInt(fid));
        model.addAttribute("firstTitle",firstTitle);

        return "admin/updateFirst";
    }

    @RequestMapping("editFirst")
    public String editFirst(FirstTitle firstTitle){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String createTime = simpleDateFormat.format(new Date());
        firstTitle.setCreateTime(createTime);

        System.out.println(firstTitle.getFid());

        firstTitleService.update(firstTitle);

        return "redirect:/first/firstList";
    }
}
