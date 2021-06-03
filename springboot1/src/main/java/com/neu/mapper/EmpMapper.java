package com.neu.mapper;

import com.neu.po.Emp;

import java.util.List;

public interface EmpMapper {
    List<Emp> getAll();

    Emp getById(int empno);

    int update(Emp emp);
}
