package com.neu.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neu.mapper.DeptMapper;
import com.neu.po.Dept;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.security.auth.login.CredentialNotFoundException;
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
    @Transactional   // 开启事务，主键重复添加失败，抛出问题会回滚，该注解也可以在类上添加
    public int insert(Dept dept) {
//        deptMapper.insert(dept);
        return deptMapper.insert(dept);
    }

    @Override
    public PageInfo<Dept> getPaged(int pageNum, int pageSize) {
        // 分页方法，该方法会拦截该语句后的第一个查询，对该查询进行分页操作
        PageHelper.startPage(pageNum,pageSize);
        List<Dept> list = deptMapper.getAll();

        PageInfo<Dept> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

}
