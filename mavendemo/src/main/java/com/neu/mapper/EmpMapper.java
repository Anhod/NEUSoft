package com.neu.mapper;

import com.neu.po.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    // 查询全部
    List<Emp> findAll();

    // 根据id进行查询
    Emp getById(int empno);

    // 插入操作
    int insert(Emp emp);

    // 修改操作（工资）
    int updateSalById(@Param("empno") int empno,@Param("sal") double sal);

    // 删除操作
    int deleteById(int empno);
}
