package com.neu.service;

import com.neu.mapper.EmpMapper;
import com.neu.po.Emp;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class EmpServiceImpl implements EmpService{
    @Resource
    private EmpMapper empMapper;

    @Override
    public List<Emp> getAll() {
        return empMapper.getAll();
    }

    @Override
    public int insert(Emp emp) {
        return empMapper.insert(emp);
    }

    @Override
    public int delete(int empno) {
        return empMapper.delete(empno);
    }

    @Override
    public List<Emp> paged(int pageNum, int pageSize) {
        return empMapper.paged(pageNum,pageSize);
    }


}
