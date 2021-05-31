package com.neu.service;

import com.neu.mapper.DeptMapper;
import com.neu.po.Dept;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class DeptServiceImpl implements DeptService{
    @Resource
    private DeptMapper deptMapper;

    @Override
    public Dept getById(int deptno) {
        return deptMapper.getById(deptno);
    }

    @Override
    public List<Dept> getAll() {
        return deptMapper.getAll();
    }

    @Override
    public int delete(int deptno) {
        return deptMapper.delete(deptno);
    }

    @Override
    public int update(Dept dept) {
        return deptMapper.update(dept);
    }

    @Override
    public int insert(Dept dept) {
        return deptMapper.insert(dept);
    }

}
