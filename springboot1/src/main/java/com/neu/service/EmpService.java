package com.neu.service;

import com.neu.po.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> getAll();

    Emp getById(int empno);

    int update(Emp emp);
}
