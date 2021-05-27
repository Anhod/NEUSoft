package com.neu.mapper;

import com.neu.po.Emp;

import java.util.List;

public interface EmpMapper {
    // 多条件的查询
    List<Emp> search(Emp emp);

    // 多条件的插入，默认值起作用时是插入的时候没传入对应的值（传入null数据库中会存为null，而不是默认值）
    int insert(Emp emp);

    // 有选择的更新
    int update(Emp emp);

    // 批量添加
    int insertBatch(List<Emp> emps);

    // 批量删除
    int deleteBatch(int[] ids);
}
