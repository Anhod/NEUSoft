package com.neu.dao;

import org.springframework.stereotype.Component;

// 面向接口编程
@Component
public class EmpDaoImpl implements EmpDao{
    public int insert() {
        System.out.println("添加员工成功");
        return 0;
    }
}
