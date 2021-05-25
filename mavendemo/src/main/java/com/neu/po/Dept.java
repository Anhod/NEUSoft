package com.neu.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor         // 所有参数的构造方法
@NoArgsConstructor          // 默认的构造方法
public class Dept {
    private int deptno;
    private String dname ;
    private String loc;
}
