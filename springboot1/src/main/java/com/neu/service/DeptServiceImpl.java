package com.neu.service;

import com.neu.mapper.DeptMapper;
import com.neu.po.Dept;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService{
    @Resource
    private DeptMapper deptMapper;

    @Override
    public Dept getById(int deptno) {
        return deptMapper.getById(deptno);
    }

    @Override
    public List<Dept> getAll() {
        List<Dept> depts = deptMapper.getAll();
        return depts;
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
