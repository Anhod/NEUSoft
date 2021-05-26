package com.neu.mapper;

import com.neu.po.Dept;
import org.apache.ibatis.annotations.Param;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Map;

// 数据映射接口
public interface DeptMapper {
    // 根据deptid获得记录
    Dept getById(int deptno);

    // 得到全部记录
    List<Dept> getAll();

    // 插入记录
    int insert(Dept dept);

    // 根据deptId更新dept的loc字段
    int updateLocById(Dept dept);

    // 根据deptId删除记录
    int deleteById(int id);

    //-----------------------------------------多参数查询-----------------------------------------
    // 1.使用@Param注解
    List<Dept> find(@Param("dname") String dname, @Param("loc") String loc);

    // 2.使用实体类封装多个参数
    List<Dept> find2(Dept dept);

    // 3.使用map，慎用
    List<Dept> find3(Map<String,String> map);

    int updateDnameById(@Param("deptno") int deptno,@Param("dname") String dname);

    //-----------------------------------------动态列名-----------------------------------------
    // 参数为排序的列名，动态列名
    List<Dept> getAllByOrderDname(String columnName);

    //-----------------------------------------模糊查询-----------------------------------------
    // 根据dname进行模糊查询，${}
    List<Dept> getByDname(String dname);

    // 根据dname进行模糊查询，#{}
    List<Dept> getByDname2(String dname);

    // ---------------------------------------------------第二天的内容---------------------------------------------------
    // 动态sql,if语句
    List<Dept> search(Dept dept);

    // 动态sql，trim标签
    List<Dept> search2(Dept dept);

    // 动态sql，where标签
    List<Dept> search3(Dept dept);
}
