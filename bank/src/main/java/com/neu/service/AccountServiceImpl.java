package com.neu.service;

import com.neu.mapper.AccountMapper;
import com.neu.po.Account;
import com.sun.scenario.effect.impl.prism.PrReflectionPeer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class AccountServiceImpl implements AccountService{
    @Resource
    private AccountMapper accountMapper;

    @Override
    public Account getById(int userId) {
        return accountMapper.getById(userId);
    }

    @Override
    public List<Account> getAll() {
       return accountMapper.getAll();
    }

    @Override
    public int batchDelete(int[] accounts) {
        return accountMapper.batchDelete(accounts);
    }
}
