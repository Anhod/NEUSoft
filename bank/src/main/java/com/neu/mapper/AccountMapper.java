package com.neu.mapper;

import com.neu.po.Account;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AccountMapper {
    @Select("select * from account where userId = #{userId}")
    Account getById(int userId);

    @Select("select * from account")
    List<Account> getAll();

    int batchDelete(int[] accounts);
}
