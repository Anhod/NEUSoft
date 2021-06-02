package com.neu.controller;

import com.neu.po.Account;
import com.neu.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("account")
public class AccountController {
    @Resource
    private AccountService accountService;

    @RequestMapping("getAll")
    public String getAll(Model model){
        List<Account> accounts = accountService.getAll();
        model.addAttribute("accounts",accounts);

        return "allAccount";
    }

    @RequestMapping("batchDelete")
    public String batchDelete(int[] accounts){
        System.out.println(Arrays.toString(accounts));
        int n = accountService.batchDelete(accounts);
//        System.out.println(Arrays.toString(accounts));

        return "redirect:/account/getAll";
    }
}
