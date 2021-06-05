package com.neu.service;

import com.neu.po.Users;

public interface UsersService {
    Users getUser(String userName,String password);
}
