package com.neu.mapper;

import com.neu.po.Dept;
import com.neu.po.Emp;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

public interface EmpMapper {
    List<Emp> getAll();

    int insert(Emp emp);

    int delete(int empno);

    List<Emp> paged(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
}
