package com.neu.controller;

import com.github.pagehelper.PageInfo;
import com.neu.po.Book;
import com.neu.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("book")
public class BookController {
    @Resource
    private BookService bookService;

    // 分页
    @RequestMapping("getPaged")
    public String getPaged(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "3") int pageSize, Model model){
        PageInfo<Book> pageInfo = bookService.getPaged(pageNum,pageSize);
        model.addAttribute("pageInfo",pageInfo);
        return "book/paged";
    }

    @RequestMapping("getInsertPage")
    public String getInsertPage(){
        return "book/insert";
    }

    // 插入成功后转向分页显示全部页面
    @RequestMapping("insert")
    public String insert(@Valid Book book, Errors errors, Model model){
        // 检查是否有错误
        if (errors.hasErrors()){
            model.addAttribute("errorList",errors.getAllErrors());
            return "book/insert";
        }

        int n = bookService.insert(book);

        return "redirect:/book/getPaged";
    }

    // 图书编辑页面
    @RequestMapping("edit")
    public String edit(int bid,Model model){
        Book book = bookService.getById(bid);
        model.addAttribute("book",book);
        return "book/editBook";
    }

    @RequestMapping("update")
    public String update(Book book){
        int n = bookService.update(book);
        return "redirect:/book/getPaged";
    }
}
