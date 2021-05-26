package com.neu.mapper;

import com.neu.po.MyUser;

import java.util.List;

public interface MyUserMapper {
    // 给定用户的id，根据其roleId查询role对象
    MyUser getRoleByMyUser(int userId);

    // 给定role查询有哪些user对象
    List<MyUser> getByRoleId(int roleId);
}
