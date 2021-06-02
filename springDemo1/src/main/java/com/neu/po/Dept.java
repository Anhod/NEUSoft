package com.neu.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {
    // 在实体类中加注解
    @NotNull(message = "部门编号不能为空")
    @Min(value = 10,message = "部门编号不能小于10")
    private Integer deptno;

    @NotBlank(message = "部门名称不能为空啊啊啊")
    @Size(min = 2,max = 10,message = "部门长度在2-10之间")
    private String dname;

    // 字符串里面全得是数字
    @Pattern(regexp = "^\\d{3,8}$",message = "数字长度在3-8个之间")
    private String loc;

//    @Email 验证邮箱
//    @Post 必须是一个过去的日期
//    @Future 必须是未来的日期
//    @min 最小值
//    @max 最大值
//    @pattern(regexp="^\\d{3,8}$"):使用正则表达式验证
}
