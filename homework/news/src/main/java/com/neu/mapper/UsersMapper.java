package com.neu.mapper;

import com.neu.po.Users;

public interface UsersMapper {
    Users getUser(String userName,String password);
}
