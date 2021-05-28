package com.neu.service;

import com.neu.po.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> getAll();

    int insert(Emp emp);

    int delete(int empno);

    List<Emp> paged(int pageNum,int pageSize);
}
