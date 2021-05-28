package com.neu.mapper;

import com.neu.po.Dept;
import org.apache.ibatis.annotations.Select;

public interface DeptMapper {
    @Select("select * from dept where  deptno= #{deptno}")
    Dept getById(int deptno);
}
