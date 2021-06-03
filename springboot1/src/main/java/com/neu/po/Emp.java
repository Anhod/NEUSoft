package com.neu.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Emp {
    private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hiredate;
    private Double sal;
    private Double comm;

    private Dept dept;
}
