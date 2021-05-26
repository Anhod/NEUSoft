package com.neu.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor         // 所有参数的构造方法
@NoArgsConstructor          // 默认的构造方法
public class Dept {
    private int deptno;
    private String dname ;
    private String loc;

    private List<Emp> emps; // 添加员工集合

    public Dept(int deptno, String dname, String loc) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }
}
