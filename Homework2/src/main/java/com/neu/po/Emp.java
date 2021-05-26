package com.neu.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Emp {
    private Integer empno;   // 编号
    private String ename;    // 姓名
    private String job;      // 岗位
    private Integer mgr;     // 经理编号
    private Date hiredate;  // 入职日期
    private Double sal;      // 薪水
    private Double comm;     // 奖金
    private Integer deptno;  // 部门编号
}
