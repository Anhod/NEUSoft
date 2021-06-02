package com.neu.service;

import com.github.pagehelper.PageInfo;
import com.neu.po.Dept;

import java.util.List;

public interface DeptService {
    Dept getById(int deptno);

    List<Dept> getAll();
    int delete(int deptno);

    int update(Dept dept);

    int insert(Dept dept);

    PageInfo<Dept> getPaged(int pageNum,int pageSize);
}
