package com.neu.typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import javax.xml.crypto.Data;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@MappedTypes(Date.class)
@MappedJdbcTypes(JdbcType.BIGINT)
public class DateIntTypeHandler extends BaseTypeHandler<Date> {
    // 将date对象转换成毫秒
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        long seconds = date.getTime();   // 得到毫秒数
        preparedStatement.setLong(i,seconds);
    }

    // 将毫秒转换成date对象
    private Date secondsToDate(long seconds){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-DD");
        Date date = new Date();
        date.setTime(seconds);
        return date;
    }

    // 下边三个方法从数据库里返回long型的毫秒数，通过公共方法转换成Date对象
    @Override
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return secondsToDate(resultSet.getLong(s));
    }

    @Override
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return secondsToDate(resultSet.getLong(i));
    }

    @Override
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return secondsToDate(callableStatement.getLong(i));
    }
}
