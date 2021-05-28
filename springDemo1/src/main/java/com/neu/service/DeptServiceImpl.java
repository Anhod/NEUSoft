package com.neu.service;

import com.neu.mapper.DeptMapper;
import com.neu.po.Dept;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class DeptServiceImpl implements DeptService{
    @Resource
    private DeptMapper deptMapper;

    @Override
    public Dept getById(int deptno) {
        return deptMapper.getById(deptno);
    }
}
