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

    // 动态选择字段进行排序
    List<Emp> order(String column);

    // 根据id返回Emp对象，同时还有Dept对象
    Emp getByIdWithDept(int empno);

    // 根据部门编号，查询出该部门的所有员工
    List<Emp> getEmpsByDeptno(int deptno);

    // ----------------------------------------------第三天的内容----------------------------------------------
    // 给定员工id，获得它所在的部门对象
    Emp getDeptObjectById(int empno);
}
