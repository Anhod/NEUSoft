package com.neu.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecondTitle {
    private Integer sid;
    private String titleName;
    private String newContent;
    private String creator;
    private String createTime;
    private Integer parentTitleId;

    private FirstTitle firstTitle;
}
