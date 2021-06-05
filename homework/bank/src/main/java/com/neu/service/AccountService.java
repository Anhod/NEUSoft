package com.neu.service;

import com.neu.po.Account;

import java.util.List;

public interface AccountService {
    Account getById(int userId);

    List<Account> getAll();

    int batchDelete(int[] accounts);
}
