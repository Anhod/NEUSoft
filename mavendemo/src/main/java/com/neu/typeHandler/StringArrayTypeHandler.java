package com.neu.typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


// https://blog.csdn.net/guyue35/article/details/83688254
// select * from emp where empno = ？
// preparedStatement.set(i,"")

// 下面三个方法是用来查询，第一个方法用来处理

// 设置注解
@MappedJdbcTypes(JdbcType.VARCHAR)       // 数据库里面是varchar类型
@MappedTypes(String[].class)             // java对象里面是String[]类型

// 还得注册类型转换器
// 类名中写的String[] 是实体类里面需要进行处理的属性类型
public class StringArrayTypeHandler extends BaseTypeHandler<String[]> {
    // 通过PreparedStatement 对象进行设置SQL参数
    // i是参数在SQL的下标
    // parameter是参数
    // jdbcType是数据库类型
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String[] strings, JdbcType jdbcType) throws SQLException {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s:strings)
            stringBuilder.append(s).append(",");

        // 去掉最后一个逗号
        stringBuilder.deleteCharAt(stringBuilder.length()-1);

        preparedStatement.setString(i,stringBuilder.toString());
    }

    // --------------------------------------------------------------------------------------------------------
    // 从JDBC结果集中获取数据进行转换，要么使用列名(columnName)要么使用下标(columnIndex)获取数据库的数据
    // 把数据库里爱好的字符串变成数组
    private String[] getStringArray(String columnValue){
        if (columnValue == null)
            return null;

        return columnValue.split(",");
    }

    // 给列名，返回爱好数组
    @Override
    public String[] getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return getStringArray(resultSet.getString(s));
    }

    // 给列名的索引号，返回爱好数组
    @Override
    public String[] getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return getStringArray(resultSet.getString(i));
    }


    // --------------------------------------------------------------------------------------------------------
    // 调用存储过程，返回爱好数组
    @Override
    public String[] getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return getStringArray(callableStatement.getString(i));
    }
}
