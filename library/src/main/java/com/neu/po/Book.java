package com.neu.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Insert;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @NotNull(message = "书籍编号不能为空")
    private Integer bid;
    private String bname;
    private String author;
    private String publish;

    @NotNull(message = "出版日期不能为空")
    private Date publishDate;
    private Integer page;
    private Double price;

    @Size(min = 2,max = 15,message = "书籍摘要在2-15个字符之内")
    private String content;
}
