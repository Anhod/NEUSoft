package com.neu.mapper;

import com.neu.po.Role;

public interface RoleMapper {
    // 根据Id查询
    Role getById(int id);

    // 给定role查询有哪些user
    Role getAllUserById(int roleId);
}
