package com.neu.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Emp implements Serializable {
    private Integer empno;   // 编号
    private String ename;    // 姓名
    private String job;      // 岗位
    private Integer mgr;     // 经理编号
    private Date hiredate;  // 入职日期
    private Double sal;      // 薪水
    private Double comm;     // 奖金
    private Integer deptno;  // 部门编号

    private Dept dept;  // 所属部门的部门对象

    public Emp(Integer empno, String ename, String job, Integer mgr, Date hiredate, Double sal, Double comm, Integer deptno) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;
    }
}
