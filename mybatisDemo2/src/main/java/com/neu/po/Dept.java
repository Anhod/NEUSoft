package com.neu.po;

import java.io.Serializable;
import lombok.Data;

/**
 * dept
 * @author 
 */
@Data
public class Dept implements Serializable {
    private Integer deptno;

    private String dname;

    private String loc;

    private static final long serialVersionUID = 1L;
}