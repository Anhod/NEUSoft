package com.neu.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    private String gid;
    private String gname;
    private Double price;
    private String company;
    private Date leave_date;
    private String desc;
}
