package com.neu.service;

import com.neu.mapper.EmpMapper;
import com.neu.po.Emp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Resource
    private EmpMapper empMapper;


    @Override
    public List<Emp> getAll() {
        return empMapper.getAll();
    }

    @Override
    public Emp getById(int empno) {
        return empMapper.getById(empno);
    }

    @Override
    public int update(Emp emp) {
        return empMapper.update(emp);
    }
}
