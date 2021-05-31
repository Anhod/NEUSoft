package com.neu.mapper;

import com.neu.po.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DeptMapper {
    @Select("select * from dept where  deptno= #{deptno}")
    Dept getById(int deptno);

    @Select("select * from dept")
    List<Dept> getAll();

    @Delete("delete from dept where deptno = #{deptno}")
    int delete(int deptno);

    @Update("update dept set dname = #{dname},loc = #{loc} where deptno = #{deptno}")
    int update(Dept dept);

    @Insert("insert into dept(deptno, dname, loc) VALUES (#{deptno},#{dname},#{loc})")
    int insert(Dept dept);
}
