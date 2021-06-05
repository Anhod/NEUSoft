package com.neu.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FirstTitle {
    private Integer fid;
    private String titleName;
    private String creator;
    private String createTime;
}
