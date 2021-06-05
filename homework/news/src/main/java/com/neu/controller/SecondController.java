package com.neu.controller;

import com.github.pagehelper.PageInfo;
import com.neu.po.FirstTitle;
import com.neu.po.SecondTitle;
import com.neu.service.FirstTitleService;
import com.neu.service.SecondService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("second")
public class SecondController {
    @Resource
    private SecondService secondService;

    @Resource
    private FirstTitleService firstTitleService;

    @RequestMapping("addSecond")
    private String addSecond(Model model){
        List<FirstTitle> firstTitles = firstTitleService.getAll();
        model.addAttribute("firstTitles",firstTitles);

        return "admin/addSecond";
    }

    @RequestMapping("secondList")
    private String secondList(@RequestParam(defaultValue = "1") int pageNum,  @RequestParam(defaultValue = "10") int pageSize, Model model){
        PageInfo<SecondTitle> pageInfo = secondService.getPaged(pageNum,pageSize);
        model.addAttribute("pageInfo",pageInfo);

        System.out.println(pageInfo.getList());

        return "admin/secondList";
    }

    @RequestMapping("insert")
    private String insert(HttpServletRequest request,SecondTitle secondTitle){
        // 获得当前日期
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String createTime = simpleDateFormat.format(new Date());

        // 获得一级标题id
        int fid = Integer.parseInt(request.getParameter("fid"));
        System.out.println(fid);

        secondTitle.setCreateTime(createTime);
        secondTitle.setParentTitleId(fid);
        secondService.insert(secondTitle);

        return "redirect:/second/addSecond";
    }

    @RequestMapping("delete")
    public String delete(String sid){
        secondService.delete(Integer.parseInt(sid));

        return "redirect:/second/secondList";
    }

    @RequestMapping("update")
    public String update(String sid,Model model){
        SecondTitle secondTitle = secondService.getById(Integer.parseInt(sid));

        List<FirstTitle> firstTitles = firstTitleService.getAll();
        model.addAttribute("firstTitles",firstTitles);
        model.addAttribute("secondTitle",secondTitle);

        return "admin/updateSecond";
    }

    @RequestMapping("editSecond")
    public String editFirst(SecondTitle secondTitle,HttpServletRequest request){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String createTime = simpleDateFormat.format(new Date());
        secondTitle.setCreateTime(createTime);

        secondTitle.setParentTitleId(Integer.parseInt(request.getParameter("fid")));
        secondService.update(secondTitle);

        return "redirect:/second/secondList";
    }
}
