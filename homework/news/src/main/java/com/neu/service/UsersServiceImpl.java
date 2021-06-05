package com.neu.service;

import com.neu.mapper.UsersMapper;
import com.neu.po.Users;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UsersServiceImpl implements UsersService{
    @Resource
    private UsersMapper usersMapper;


    @Override
    public Users getUser(String userName,String password) {
        return usersMapper.getUser(userName,password);
    }
}
