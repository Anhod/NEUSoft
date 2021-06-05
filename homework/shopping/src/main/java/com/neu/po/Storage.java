package com.neu.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    private String gid;
    private String gname;
    private Date gin_date;
    private Date gpro_date;
    private Integer g_count;
    private String storage_name;


}
