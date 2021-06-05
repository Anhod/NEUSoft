package com.neu.controller;

import com.github.pagehelper.PageInfo;
import com.neu.po.Storage;
import com.neu.service.StorageService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("storage")
public class StorageController {
    @Resource
    private StorageService storageService;

    @RequestMapping("first")
    private String first(Model model){
        List<Storage> list = storageService.getAll();

        model.addAttribute("list",list);
        return "storage/first";
    }

    @RequestMapping("submit")
    private String submit(String count, HttpServletRequest request,Model model){
        String gid = request.getParameter("gid");
        int result = Integer.parseInt(count.substring(1,count.length()));

        Storage storage = storageService.getById(gid);
        System.out.println(storage);


        if (storage.getG_count()>=result){
            storage.setG_count(storage.getG_count()-result);
            storageService.update(storage);

            // 出库成功
            model.addAttribute("storage",storage);

            return "storage/success";
        }else {
            model.addAttribute("storage",storage);

            return "storage/fail";
        }
    }

    // 查看全部商品信息
    @RequestMapping("all")
    private String all(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "3") int pageSize, Model model){
        pageSize = 5;
        PageInfo<Storage> pageInfo =storageService.getPaged(pageNum,pageSize);
        model.addAttribute("pageInfo",pageInfo);

        System.out.println(pageInfo.getList());
        return "storage/all";
    }
}
