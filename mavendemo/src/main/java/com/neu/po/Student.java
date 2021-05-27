package com.neu.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private int sid;
    private String sname;
    private int sage;
    private String[] interests;       // 注意这里是个字符串数组
}
