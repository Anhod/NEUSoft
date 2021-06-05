package com.neu.controller;

import com.neu.po.FirstTitle;
import com.neu.po.SecondTitle;
import com.neu.service.FirstTitleService;
import com.neu.service.SecondService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.Resource;
import java.util.List;

@Controller
public class NewsController {
    @Resource
    private FirstTitleService firstTitleService;

    @Resource
    private SecondService secondService;

    @RequestMapping("/")
    public String newsMain(Model model){
        List<FirstTitle> list = firstTitleService.getAll();
        model.addAttribute("list",list);

        return "index";
    }

    // 通过一级标题得到二级标题
    @RequestMapping("getSecond")
    public String getSecond(String firstId,Model model){
        int fid = Integer.parseInt(firstId);
        List<SecondTitle> secondTitles = secondService.getByFid(fid);

        model.addAttribute("secondTitles",secondTitles);

        return "list";
    }

    // 显示具体的新闻信息
    @RequestMapping("news")
    public String news(String secondId,Model model){
        int sid = Integer.parseInt(secondId);
        SecondTitle secondTitle = secondService.getById(sid);
        model.addAttribute("secondTitle",secondTitle);

        return "news";
    }
}
